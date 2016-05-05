package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.enumtypes.ItemBrickTypes;
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

public class ItemBricks extends Item
{

	public ItemBricks()
	{
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}

	public static void inventoryRender()
	{
		Item itemBlockBrickVariants = GameRegistry.findItem(MReference.MODID, "bricks");

		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:stone_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:deepstone_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:red_rock_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:deep_red_rock_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:coldstone_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:deep_coldstone_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:icestone_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:glacierrock_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:oceanstone_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:pressurized_oceanstone_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:slate_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:granite_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:diorite_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:andesite_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:obsidian_brick");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:flint_brick");

		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "bricks");
		ItemBrickTypes[] aenumtype = ItemBrickTypes.values();
		int i = aenumtype.length;

		for (int j = 0; j < i; ++j)
		{
			ItemBrickTypes enumtype = aenumtype[j];
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
		ItemBrickTypes[] aenumtype = ItemBrickTypes.values();
		int i = aenumtype.length;

		for (int j = 0; j < i; ++j)
		{
			ItemBrickTypes enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemBrickTypes.byMetadata(item.getItemDamage()) + "_brick";
	}
}
