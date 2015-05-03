package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class MItemShovel extends ItemSpade
{	
	public MItemShovel(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		if (toRepair.getItem() == MItems.copper_shovel)
		{
			return repair.getItem() == MItems.copper_ingot;
		}
		return false;
	}
}
