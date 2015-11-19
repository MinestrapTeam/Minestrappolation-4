package minestrapteam.mods.minestrappolation.block.biomeores;

import java.util.List;
import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.enumtypes.MCreepType;
import minestrapteam.mods.minestrappolation.enumtypes.MStoneType;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTerraCreep extends Block
{
	public static final PropertyEnum	VARIANT	= PropertyEnum.create("variant", MCreepType.class);
	
	public BlockTerraCreep()
	{
		super(Material.rock);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, MCreepType.STONE));
		this.setTickRandomly(true);
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        int Chance = rand.nextInt(150);
        if(Chance >= 50 && Chance <= 54)
        {
        	this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockState(pos, Blocks.air.getDefaultState());
        }
        else if(Chance == 1)
        {
        	this.tryReplaceBlock(worldIn, pos.up(), pos, state, rand);
        }
        else if(Chance == 2)
        {
        	this.tryReplaceBlock(worldIn, pos.down(), pos, state, rand);
        }
        else if(Chance == 3)
        {
        	this.tryReplaceBlock(worldIn, pos.north(), pos, state, rand);
        }
        else if(Chance == 4)
        {
        	this.tryReplaceBlock(worldIn, pos.east(), pos, state, rand);
        }
        else if(Chance == 5)
        {
        	this.tryReplaceBlock(worldIn, pos.south(), pos, state, rand);
        }
        else if(Chance == 6)
        {
        	this.tryReplaceBlock(worldIn, pos.west(), pos, state, rand);
        }
        else if(Chance == 7)
        {
        	this.tryReplaceBlock(worldIn, pos.north().up(), pos, state, rand);
        }
        else if(Chance == 8)
        {
        	this.tryReplaceBlock(worldIn, pos.east().up(), pos, state, rand);
        }
        else if(Chance == 9)
        {
        	this.tryReplaceBlock(worldIn, pos.south().up(), pos, state, rand);
        }
        else if(Chance == 10)
        {
        	this.tryReplaceBlock(worldIn, pos.west().up(), pos, state, rand);
        }
        else if(Chance == 11)
        {
        	this.tryReplaceBlock(worldIn, pos.north().down(), pos, state, rand);
        }
        else if(Chance == 12)
        {
        	this.tryReplaceBlock(worldIn, pos.east().down(), pos, state, rand);
        }
        else if(Chance == 13)
        {
        	this.tryReplaceBlock(worldIn, pos.south().down(), pos, state, rand);
        }
        else if(Chance == 14)
        {
        	this.tryReplaceBlock(worldIn, pos.west().down(), pos, state, rand);
        }
        else if(Chance == 15)
        {
        	this.tryReplaceBlock(worldIn, pos.north().east(), pos, state, rand);
        }
        else if(Chance == 16)
        {
        	this.tryReplaceBlock(worldIn, pos.north().west(), pos, state, rand);
        }
        else if(Chance == 17)
        {
        	this.tryReplaceBlock(worldIn, pos.south().east(), pos, state, rand);
        }
        else if(Chance == 18)
        {
        	this.tryReplaceBlock(worldIn, pos.south().west(), pos, state, rand);
        }
        else if(Chance == 19)
        {
        	this.tryReplaceBlock(worldIn, pos.north().east().up(), pos, state, rand);
        }
        else if(Chance == 20)
        {
        	this.tryReplaceBlock(worldIn, pos.north().east().down(), pos, state, rand);
        }
        else if(Chance == 21)
        {
        	this.tryReplaceBlock(worldIn, pos.north().west().up(), pos, state, rand);
        }
        else if(Chance == 22)
        {
        	this.tryReplaceBlock(worldIn, pos.north().west().down(), pos, state, rand);
        }
        else if(Chance == 23)
        {
        	this.tryReplaceBlock(worldIn, pos.south().east().up(), pos, state, rand);
        }
        else if(Chance == 24)
        {
        	this.tryReplaceBlock(worldIn, pos.south().east().down(), pos, state, rand);
        }
        else if(Chance == 25)
        {
        	this.tryReplaceBlock(worldIn, pos.south().west().up(), pos, state, rand);
        }
        else if(Chance == 26)
        {
        	this.tryReplaceBlock(worldIn, pos.south().west().down(), pos, state, rand);
        }
    }
	
	public void tryReplaceBlock(World worldIn, BlockPos pos, BlockPos originPos, IBlockState state, Random rand)
	{
		int meta = 0;
		int splitChance = rand.nextInt(3);
		if(worldIn.getBlockState(pos) == Blocks.stone.getDefaultState())
		{
			worldIn.setBlockState(pos, this.getStateFromMeta(MCreepType.STONE.getMetadata()));
			if(splitChance != 1)
			{
				this.dropBlockAsItem(worldIn, originPos, state, 0);
				worldIn.setBlockState(originPos, Blocks.air.getDefaultState());
			}
		}
		else if(worldIn.getBlockState(pos) == MBlocks.biome_stones.getStateFromMeta(0) || worldIn.getBlockState(pos) == MBlocks.biome_stones.getStateFromMeta(1) || worldIn.getBlockState(pos) == MBlocks.biome_stones.getStateFromMeta(2) || worldIn.getBlockState(pos) == MBlocks.biome_stones.getStateFromMeta(3) || worldIn.getBlockState(pos) == MBlocks.biome_stones.getStateFromMeta(4) || worldIn.getBlockState(pos) == MBlocks.biome_stones.getStateFromMeta(5) || worldIn.getBlockState(pos) == MBlocks.biome_stones.getStateFromMeta(6) || worldIn.getBlockState(pos) == MBlocks.biome_stones.getStateFromMeta(7) || worldIn.getBlockState(pos) == MBlocks.biome_stones.getStateFromMeta(8))
		{
			meta = ((MStoneType) worldIn.getBlockState(pos).getValue(BlockBiomeStones.VARIANT)).getMetadata();
			worldIn.setBlockState(pos, this.getStateFromMeta(meta));
			if(splitChance != 1)
			{
				this.dropBlockAsItem(worldIn, originPos, state, 0);
				worldIn.setBlockState(originPos, Blocks.air.getDefaultState());
			}
		}
		else if(worldIn.getBlockState(pos) == Blocks.netherrack.getDefaultState())
		{
			worldIn.setBlockState(pos, this.getStateFromMeta(MCreepType.NETHERRACK.getMetadata()));
			if(splitChance != 1)
			{
				this.dropBlockAsItem(worldIn, originPos, state, 0);
				worldIn.setBlockState(originPos, Blocks.air.getDefaultState());
			}
		}
		else if(worldIn.getBlockState(pos) == Blocks.end_stone.getDefaultState())
		{
			worldIn.setBlockState(pos, this.getStateFromMeta(MCreepType.ENDSTONE.getMetadata()));
			if(splitChance != 1)
			{
				this.dropBlockAsItem(worldIn, originPos, state, 0);
				worldIn.setBlockState(originPos, Blocks.air.getDefaultState());
			}
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if(((MCreepType) state.getValue(VARIANT)).getMetadata() < 9)
			return Item.getItemFromBlock(MBlocks.biome_cobble.getStateFromMeta(this.getMetaFromState(state)).getBlock());
		else if(((MCreepType) state.getValue(VARIANT)).getMetadata() == 9)
			return Item.getItemFromBlock(Blocks.cobblestone.getDefaultState().getBlock());
		else if(((MCreepType) state.getValue(VARIANT)).getMetadata() == 10)
			return Item.getItemFromBlock(Blocks.netherrack.getDefaultState().getBlock());
		else
			return Item.getItemFromBlock(Blocks.end_stone.getDefaultState().getBlock());
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		if(((MCreepType) state.getValue(VARIANT)).getMetadata() < 9)
			return ((MCreepType) state.getValue(VARIANT)).getMetadata();
		else
			return 0;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		MCreepType[] aenumtype = MCreepType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MCreepType enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, MCreepType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((MCreepType) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { VARIANT });
	}
	
	public static void inventoryRender()
	{
		Item item = GameRegistry.findItem(MReference.MODID, "terracreep");
		
		ModelBakery.addVariantName(item, "ministrapp:deepstone");
		ModelBakery.addVariantName(item, "ministrapp:coldstone");
		ModelBakery.addVariantName(item, "ministrapp:icestone");
		ModelBakery.addVariantName(item, "ministrapp:glacierrock");
		ModelBakery.addVariantName(item, "ministrapp:deep_coldstone");
		ModelBakery.addVariantName(item, "ministrapp:red_rock");
		ModelBakery.addVariantName(item, "ministrapp:deep_redrock");
		ModelBakery.addVariantName(item, "ministrapp:oceanstone");
		ModelBakery.addVariantName(item, "ministrapp:pressurized_oceanstone");
		ModelBakery.addVariantName(item, "ministrapp:stone");
		ModelBakery.addVariantName(item, "ministrapp:netherrack");
		ModelBakery.addVariantName(item, "ministrapp:endstone");
		
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "terracreep");
		MCreepType[] aenumtype = MCreepType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MCreepType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + enumtype.getUnlocalizedName(), "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
	
	@Override
	public float getBlockHardness(World worldIn, BlockPos pos)
	{
		IBlockState state = worldIn.getBlockState(pos);
		if (state == this.getStateFromMeta(MCreepType.DEEPSTONE.getMetadata()) || state == this.getStateFromMeta(MCreepType.DEEPCOLDSTONE.getMetadata()) || state == this.getStateFromMeta(MCreepType.DEEPREDROCK.getMetadata()) || state == this.getStateFromMeta(MCreepType.GLACIERSTONE.getMetadata()) || state == this.getStateFromMeta(MCreepType.POCEANSTONE.getMetadata()))
			return 1.5F * this.blockHardness;
		else if(state == this.getStateFromMeta(MCreepType.NETHERRACK.getMetadata()))
			return 0.5F * this.blockHardness;
		else
			return this.blockHardness;
	}
	
	@Override
	public boolean canSilkHarvest()
	{
		return false;
	}
}