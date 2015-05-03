package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class MItemArmor extends ItemArmor
{
	public MItemArmor(ArmorMaterial material, int renderIndex, int armorType)
	{
		super(material, renderIndex, armorType);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return this.armorType == 2 ? "ministrapp:textures/models/armor/tin_2.png" : "ministrapp:textures/models/armor/tin_1.png";
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		Item item = toRepair.getItem();
		if (item == MItems.tin_helmet || item == MItems.tin_chestplate || item == MItems.tin_leggings || item == MItems.tin_boots)
		{
			return repair.getItem() == MItems.tin_ingot;
		}
		return false;
	}
}
