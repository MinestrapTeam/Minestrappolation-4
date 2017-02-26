package minestrapteam.mods.minestrappolation.block;

import java.util.List;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.enumtypes.MStoneType;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.block.material.MapColor;
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
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCrackedBricks extends MBlock
{

	private static final PropertyEnum	VARIANT	= PropertyEnum.create("type", MStoneType.class);
	public BlockCrackedBricks(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn, mapColorIn);
		this.setCreativeTab(Minestrappolation.tabMBuilding);
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { VARIANT });
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((MStoneType) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list)
	{
		MStoneType[] aenumtype = MStoneType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MStoneType enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
		
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, MStoneType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((MStoneType) state.getValue(VARIANT)).getMetadata();
	}
	
	public static void inventoryRender()
	{
		Item itemBlockBrickVariants = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MReference.MODID, "biome_cracked_bricks"));
		
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:deepstone_cracked_bricks"));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:coldstone_cracked_bricks"));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:icestone_cracked_bricks"));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:glacierrock_cracked_bricks"));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:deep_coldstone_cracked_bricks"));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:red_rock_cracked_bricks"));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:deep_redrock_cracked_bricks"));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:oceanstone_cracked_bricks"));
		ModelBakery.registerItemVariants(itemBlockBrickVariants, new ResourceLocation("ministrapp:pressurized_oceanstone_cracked_bricks"));
		
		Item itemBlockVariants = ForgeRegistries.ITEMS.getValue(new ResourceLocation(MReference.MODID,"biome_cracked_bricks"));
		MStoneType[] aenumtype = MStoneType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MStoneType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + enumtype.getUnlocalizedName() + "_cracked_bricks", "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}

}
