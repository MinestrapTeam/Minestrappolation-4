package minestrapteam.minestrappolation.block.BiomeOres;

import java.util.List;
import java.util.Random;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.block.MStoneType;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MReference;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBiomeStones extends Block
{
	public static final PropertyEnum	VARIANT	= PropertyEnum.create("variant", MStoneType.class);
	
	public BlockBiomeStones()
	{
		super(Material.rock);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, MStoneType.DEEPSTONE));
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(MBlocks.biome_cobble.getStateFromMeta(this.getMetaFromState(state)).getBlock());
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((MStoneType) state.getValue(VARIANT)).getMetadata();
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
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { VARIANT });
	}
	
	public static void preinventoryRender()
	{
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "biome_stone");
		
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:deepstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:coldstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:icestone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:glacierrock");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:deep_coldstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:red_rock");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:deep_redrock");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:oceanstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:pressurized_oceanstone");
	}
	
	public static void inventoryRender()
	{
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "biome_stone");
		MStoneType[] aenumtype = MStoneType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MStoneType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":"+enumtype.getUnlocalizedName(), "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
}