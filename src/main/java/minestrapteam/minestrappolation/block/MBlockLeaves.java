package minestrapteam.minestrappolation.block;

import java.util.List;
import java.util.Random;

import minestrapteam.minestrappolation.enumtypes.MWoodType;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MReference;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Predicate;

public class MBlockLeaves extends MBlockLeavesBase
{
	public static final PropertyEnum	VARIANT	= PropertyEnum.create("variant", MWoodType.class, new Predicate()
												{
													public boolean apply(MWoodType type)
													{
														return type.getMetadata() < 4;
													}
													
													@Override
													public boolean apply(Object p_apply_1_)
													{
														return this.apply((MWoodType) p_apply_1_);
													}
												});
	
	private int							flammability;
	
	public MBlockLeaves(int flame)
	{
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, MWoodType.REDWOOD).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		this.flammability = flame;
	}
	
	@Override
	protected int getSaplingDropChance(IBlockState state)
	{
		return super.getSaplingDropChance(state);
	}
	
	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
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
	protected ItemStack createStackedBlock(IBlockState state)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((MWoodType) state.getValue(VARIANT)).getMetadata());
	}
	
	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, this.getCustomWoodType(meta)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}
	
	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state)
	{
		byte b0 = 0;
		int i = b0 | ((MWoodType) state.getValue(VARIANT)).getMetadata();
		
		if (!((Boolean) state.getValue(DECAYABLE)).booleanValue())
		{
			i |= 4;
		}
		
		if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue())
		{
			i |= 8;
		}
		
		return i;
	}
	
	public MWoodType getCustomWoodType(int meta)
	{
		return MWoodType.byMetadata((meta & 3) % 4);
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { VARIANT, CHECK_DECAY, DECAYABLE });
	}
	
	/**
	 * Get the damage value that this Block should drop
	 */
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((MWoodType) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te)
	{
		if (!worldIn.isRemote && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Items.shears)
		{
			player.triggerAchievement(StatList.mineBlockStatArray[Block.getIdFromBlock(this)]);
			spawnAsEntity(worldIn, pos, new ItemStack(Item.getItemFromBlock(this), 1, ((MWoodType) state.getValue(VARIANT)).getMetadata()));
		}
		else
		{
			super.harvestBlock(worldIn, player, pos, state, te);
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(MBlocks.ministrapp_sapling);
	}
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
	{
		IBlockState state = world.getBlockState(pos);
		return new java.util.ArrayList(java.util.Arrays.asList(new ItemStack(this, 0, ((MWoodType) state.getValue(VARIANT)).getMetadata())));
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return !Minecraft.isFancyGraphicsEnabled();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return Minecraft.isFancyGraphicsEnabled() ? EnumWorldBlockLayer.TRANSLUCENT : EnumWorldBlockLayer.SOLID;
	}
	
	@Override
	public MWoodType getWoodType(int meta)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return this.flammability;
	}
	
	public static void preinventoryRender()
	{
		Item itemBlockBrickVariants = GameRegistry.findItem(MReference.MODID, "ministrapp_leaves");
		
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:redwood_leaves");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:frozen_oak_leaves");
	}
	
	public static void inventoryRender()
	{
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "ministrapp_leaves");
		MWoodType[] aenumtype = MWoodType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MWoodType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + enumtype.getUnlocalizedName() + "_leaves", "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
	
}
