package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.enumtypes.ItemBrickTypes2;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemBricks2 extends Item
{

	public ItemBricks2()
	{
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	public static void inventoryRender()
	{
		Item itemBlockBrickVariants = GameRegistry.findItem(MReference.MODID, "bricks2");

		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:sandstone_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:red_sandstone_brick");

		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "bricks2");
		ItemBrickTypes2[] aenumtype = ItemBrickTypes2.values();
		int i = aenumtype.length;

		for (int j = 0; j < i; ++j)
		{
			ItemBrickTypes2 enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":"
				                                                                            + enumtype
					                                                                              .getUnlocalizedName()
				                                                                            + "_brick", "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			         .register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List list)
	{
		ItemBrickTypes2[] aenumtype = ItemBrickTypes2.values();
		int i = aenumtype.length;

		for (int j = 0; j < i; ++j)
		{
			ItemBrickTypes2 enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemBrickTypes2.byMetadata(item.getItemDamage()) + "_brick";
	}
}
