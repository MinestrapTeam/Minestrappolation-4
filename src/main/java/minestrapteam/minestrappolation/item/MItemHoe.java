package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class MItemHoe extends ItemHoe
{
	public MItemHoe(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		if (toRepair.getItem() == MItems.copper_hoe)
		{
			return repair.getItem() == MItems.copper_ingot;
		}
		return false;
	}
}
