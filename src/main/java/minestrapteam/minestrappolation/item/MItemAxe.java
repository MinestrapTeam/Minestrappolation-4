package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class MItemAxe extends ItemAxe
{
	public MItemAxe(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		if (toRepair.getItem() == MItems.copper_axe)
		{
			return repair.getItem() == MItems.copper_ingot;
		}
		return false;
	}
}
