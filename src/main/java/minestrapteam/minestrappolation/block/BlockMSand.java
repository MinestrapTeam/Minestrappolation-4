package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.lib.MReference;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockMSand extends BlockSand{
	
	public BlockMSand()
	{

	}
	
	public static void preinventoryRender()
	{
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "cold_sand");
		
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:cold_sand");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:cold_red_sand");
	}
	
	public static void inventoryRender()
	{
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "cold_sand");
		EnumType[] aenumtype = BlockSand.EnumType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			BlockSand.EnumType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + "cold_" + enumtype.getName(), "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
}
