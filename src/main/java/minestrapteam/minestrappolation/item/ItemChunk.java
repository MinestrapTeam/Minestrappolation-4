package minestrapteam.minestrappolation.item;

import java.util.List;

import minestrapteam.minestrappolation.enumtypes.MItemChunkTypes;
import minestrapteam.minestrappolation.lib.MReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemChunk extends Item
{
	
	public ItemChunk()
	{
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	public static void preinventoryRender()
	{
		Item itemBlockBrickVariants = GameRegistry.findItem(MReference.MODID, "chunks");
		
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:stone_chunk");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:copper_chunk");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:gold_chunk");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:tin_chunk");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:iron_chunk");
	}
	
	public static void inventoryRender()
	{
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "chunks");
		MItemChunkTypes[] aenumtype = MItemChunkTypes.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MItemChunkTypes enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + enumtype.getUnlocalizedName() + "_chunk", "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List list)
	{
		MItemChunkTypes[] aenumtype = MItemChunkTypes.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MItemChunkTypes enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return MItemChunkTypes.byMetadata(item.getItemDamage()) + "_chunk";
	}
}
