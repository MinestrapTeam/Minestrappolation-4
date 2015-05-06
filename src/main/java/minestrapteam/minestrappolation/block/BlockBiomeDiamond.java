package minestrapteam.minestrappolation.block;

import java.util.List;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.lib.MReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBiomeDiamond extends MBlockOre
{
	
	private static final PropertyEnum	VARIANT	= PropertyEnum.create("type", MStoneType.class);
	
	public BlockBiomeDiamond(int range, int rate, Material material, MapColor mapColor, Item itemDrop, int meta, int expMin, int expMax, int dropAmount, int bonusAmount, String tool, int level, boolean silkHarvest)
	{
		super(material, mapColor, itemDrop, meta, expMin, expMax, dropAmount,bonusAmount, tool, level, silkHarvest);
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
		this.setUnlocalizedName("biome_diamond");
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { VARIANT });
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
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
	
	public static void preinventoryRender()
	{
		Item itemBlockBrickVariants = GameRegistry.findItem(MReference.MODID, "biome_diamond");
		
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:deepstone_diamond");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:coldstone_diamond");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:icestone_diamond");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:glacierrock_diamond");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:deep_coldstone_diamond");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:red_rock_diamond");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:deep_redrock_diamond");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:oceanstone_diamond");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:pressurized_oceanstone_diamond");
	}
	
	public static void inventoryRender()
	{
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "biome_diamond");
		MStoneType[] aenumtype = MStoneType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MStoneType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":"+enumtype.getUnlocalizedName()+"_diamond", "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}

}
