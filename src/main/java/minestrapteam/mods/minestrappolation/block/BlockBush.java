package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.util.FakePlayer;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BlockBush extends MBlock implements IPlantable, IShearable
{

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 5);
	public Item item;

	public BlockBush(Material material, Item item, MapColor mapcolor)
	{
		super(material, mapcolor);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
		this.setLightOpacity(0);
		this.setTickRandomly(true);
		this.item = item;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (worldIn.getBlockState(pos.down()).getBlock() != this && !this.checkForDrop(worldIn, pos, state))
		{
			return;
		}

		final int age = state.getValue(AGE);
		if (age < 5 && rand.nextInt(Config.bushGrowChance) == 0)
		{
			worldIn.setBlockState(pos, state.withProperty(AGE, age + 1), 2);
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (state.getValue(AGE) != 5)
		{
			return false;
		}

		if (worldIn.isRemote)
		{
			return true;
		}

		worldIn.setBlockState(pos, this.getDefaultState(), 2);
		EntityItem ei = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(this.item));
		worldIn.spawnEntityInWorld(ei);

		if (playerIn instanceof FakePlayer)
		{
			ei.onCollideWithPlayer(playerIn);
		}
		return true;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		if (state.getValue(AGE) == 5)
		{
			return FULL_BLOCK_AABB;
		}
		return new AxisAlignedBB(0.1, 0.1, 0.1, 0.9, 0.9, 0.9);
	}

	@Override
	public boolean canPlaceBlockAt(World world, BlockPos pos)
	{
		final IBlockState blockState = world.getBlockState(pos.down());

		Block block = blockState.getBlock();

		return block == this || block.canSustainPlant(blockState, world, pos.down(), EnumFacing.UP, this)
			       || block == Blocks.GRASS || block == Blocks.DIRT || block == Blocks.SAND
			       || block == Blocks.MYCELIUM && this == MBlocks.mana_bush; // Mana bushes can grow on Mycelium
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	{
		this.checkForDrop(worldIn, pos, state);
	}

	protected final boolean checkForDrop(World worldIn, BlockPos p_176353_2_, IBlockState state)
	{
		if (this.canBlockStay(worldIn, p_176353_2_))
		{
			return true;
		}
		else
		{
			this.dropBlockAsItem(worldIn, p_176353_2_, state, 0);
			worldIn.setBlockToAir(p_176353_2_);
			return false;
		}
	}

	public boolean canBlockStay(World worldIn, BlockPos pos)
	{
		return this.canPlaceBlockAt(worldIn, pos);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
	{
		return null;
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(AGE, meta);
	}

	@Override
	public BlockRenderLayer getBlockLayer()
	{
		if (this == MBlocks.mana_bush || this == MBlocks.glacieric_ice_vein)
			return BlockRenderLayer.TRANSLUCENT;
		else
			return BlockRenderLayer.CUTOUT;
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(AGE);
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, AGE);
	}

	@Override
	public net.minecraftforge.common.EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
	{
		return net.minecraftforge.common.EnumPlantType.Plains;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos)
	{
		return this.getDefaultState();
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isVisuallyOpaque()
	{
		return false;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
	{
		return false;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
	{
		return Collections.singletonList(new ItemStack(this));
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return 600;
	}
}
