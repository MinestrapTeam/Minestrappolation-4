package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.block.BlockSand;
import net.minecraft.block.SoundType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockMSand extends BlockSand
{
	
	public BlockMSand(SoundType sound)
	{
		this.setSoundType(sound);
	}
	
	public static void inventoryRender()
	{
		Item item = GameRegistry.findItem(MReference.MODID, "cold_sand");
		
		ModelBakery.addVariantName(item, "ministrapp:cold_sand");
		ModelBakery.addVariantName(item, "ministrapp:cold_red_sand");
		
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
