package minestrapteam.minestrappolation.block;

import java.util.List;
import java.util.Random;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.enumtypes.MWoodType;
import minestrapteam.minestrappolation.world.WorldGenRedWoodTree;
import minestrapteam.minestrappolation.world.WorldGenRedWoodTreeSmall;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MBlockSapling extends BlockBush implements IGrowable
{
	
	private static final PropertyEnum	TYPE	= PropertyEnum.create("type", MWoodType.class);
	public static final PropertyInteger	STAGE	= PropertyInteger.create("stage", 0, 1);
	private int							flammability;
	
	public MBlockSapling(int flame)
	{
		super(Material.plants);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, MWoodType.REDWOOD).withProperty(STAGE, Integer.valueOf(0)));
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
		this.setUnlocalizedName("ministrapp_sapling");
		this.flammability = flame;
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (!worldIn.isRemote)
		{
			super.updateTick(worldIn, pos, state, rand);
			
			if (worldIn.getLightFromNeighbors(pos.offset(EnumFacing.UP)) >= 9 && rand.nextInt(7) == 0)
			{
				this.grow(worldIn, pos, state, rand);
			}
		}
	}
	
	public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (((Integer) state.getValue(STAGE)).intValue() == 0)
		{
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
		}
		else
		{
			this.generateTree(worldIn, pos, state, rand);
		}
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { TYPE, STAGE });
	}
	
	public void generateTree(World world, BlockPos pos, IBlockState state, Random random)
	{
		if (!TerrainGen.saplingGrowTree(world, random, pos))
			return;
		Object object = random.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
		int i = 0;
		int j = 0;
		boolean flag = false;
		
		switch ((MWoodType) state.getValue(TYPE))
		{
		case REDWOOD:
			label78:
			
			for (i = 0; i >= -1; --i)
			{
				for (j = 0; j >= -1; --j)
				{
					if (this.isTypeAt(world, pos.add(i, 0, j), MWoodType.REDWOOD) && this.isTypeAt(world, pos.add(i + 1, 0, j), MWoodType.REDWOOD) && this.isTypeAt(world, pos.add(i, 0, j + 1), MWoodType.REDWOOD) && this.isTypeAt(world, pos.add(i + 1, 0, j + 1), MWoodType.REDWOOD))
					{
						object = new WorldGenRedWoodTree();
						flag = true;
						break label78;
					}
				}
			}
			
			if (!flag)
			{
				j = 0;
				i = 0;
				object = new WorldGenRedWoodTreeSmall();
			}
		}
		
		IBlockState iblockstate1 = Blocks.air.getDefaultState();
		
		if (flag)
		{
			world.setBlockState(pos.add(i, 0, j), iblockstate1, 4);
			world.setBlockState(pos.add(i + 1, 0, j), iblockstate1, 4);
			world.setBlockState(pos.add(i, 0, j + 1), iblockstate1, 4);
			world.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate1, 4);
		}
		else
		{
			world.setBlockState(pos, iblockstate1, 4);
		}
		
		if (!((WorldGenerator) object).generate(world, random, pos.add(i, 0, j)))
		{
			if (flag)
			{
				world.setBlockState(pos.add(i, 0, j), state, 4);
				world.setBlockState(pos.add(i + 1, 0, j), state, 4);
				world.setBlockState(pos.add(i, 0, j + 1), state, 4);
				world.setBlockState(pos.add(i + 1, 0, j + 1), state, 4);
			}
			else
			{
				world.setBlockState(pos, state, 4);
			}
		}
	}
	
	public boolean isTypeAt(World worldIn, BlockPos pos, MWoodType type)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos);
		return iblockstate.getBlock() == this && iblockstate.getValue(TYPE) == type;
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((MWoodType) state.getValue(TYPE)).getMetadata();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		MWoodType[] aenumtype = MWoodType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MWoodType enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
		
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(TYPE, MWoodType.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		byte b0 = 0;
		int i = b0 | ((MWoodType) state.getValue(TYPE)).getMetadata();
		i |= ((Integer) state.getValue(STAGE)).intValue() << 3;
		return i;
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		return worldIn.rand.nextFloat() < 0.45D;
	}
	
	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		this.grow(worldIn, pos, state, rand);
	}
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return this.flammability;
	}
	
}
