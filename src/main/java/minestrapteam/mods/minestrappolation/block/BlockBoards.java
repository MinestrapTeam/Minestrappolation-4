package minestrapteam.mods.minestrappolation.block;

import java.util.List;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.enumtypes.AllWoodTypes;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBoards extends Block
{
	public static final PropertyEnum	VARIANT	= PropertyEnum.create("type", AllWoodTypes.class);
	
	private int							flammability;
	private String						type;
	
	public BlockBoards(int flame, String type)
	{
		super(Material.WOOD);
		this.setCreativeTab(Minestrappolation.tabMBuilding);
		this.flammability = flame;
		this.type = type;
		this.setUnlocalizedName("ministrapp_" + type);
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((AllWoodTypes) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list)
	{
		AllWoodTypes[] aenumtype = AllWoodTypes.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			AllWoodTypes enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, AllWoodTypes.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((AllWoodTypes) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}
	
	public static void inventoryRender(String type)
	{
		Item itemBlockBrickVariants = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MReference.MODID, "ministrapp_" + type));
		
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:oak_" + type));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:spruce_" + type));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:birch_" + type));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:jungle_" + type));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:acacia_" + type));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:dark_oak_" + type));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:redwood_" + type));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:frozen_oak_" + type));
		
		Item itemBlockVariants = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MReference.MODID, "ministrapp_" + type));
		AllWoodTypes[] aenumtype = AllWoodTypes.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			AllWoodTypes enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + enumtype.getUnlocalizedName() + "_" + type, "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return this.flammability;
	}
	
}
