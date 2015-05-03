package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class MItemPickaxe extends ItemPickaxe
{
	public MItemPickaxe(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		if (toRepair.getItem() == MItems.copper_pickaxe)
		{
			return repair.getItem() == MItems.copper_ingot;
		}
		return false;
	}
}
