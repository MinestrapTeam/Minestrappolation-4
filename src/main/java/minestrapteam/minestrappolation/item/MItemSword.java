package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class MItemSword extends ItemSword
{
	public MItemSword(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		if (toRepair.getItem() == MItems.copper_sword)
		{
			return repair.getItem() == MItems.copper_ingot;
		}
		return false;
	}
}
