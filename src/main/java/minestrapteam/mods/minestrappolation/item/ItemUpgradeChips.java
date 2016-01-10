package minestrapteam.mods.minestrappolation.item;

import java.util.List;

import minestrapteam.mods.minestrappolation.enumtypes.ItemChipTypes;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemUpgradeChips extends Item
{
	
	public ItemUpgradeChips()
	{
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
	}
	
	public static void inventoryRender()
	{
		Item itemBlockBrickVariants = GameRegistry.findItem(MReference.MODID, "chips");
		
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:preserver_chip");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:collision_chip");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:inversion_chip");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:selfsufficient_chip");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:placer_chip");
		
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "chips");
		ItemChipTypes[] aenumtype = ItemChipTypes.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			ItemChipTypes enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + enumtype.getUnlocalizedName() + "_chips", "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List list)
	{
		ItemChipTypes[] aenumtype = ItemChipTypes.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			ItemChipTypes enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemChipTypes.byMetadata(item.getItemDamage()) + "_chips";
	}
}