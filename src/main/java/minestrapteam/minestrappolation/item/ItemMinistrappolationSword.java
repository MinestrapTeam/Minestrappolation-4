package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemMinistrappolationSword extends ItemSword
{
	
	public ItemMinistrappolationSword(ToolMaterial material)
	{
		super(material);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		if (toRepair == new ItemStack(MItems.copper_pickaxe) || toRepair == new ItemStack(MItems.copper_axe) || toRepair == new ItemStack(MItems.copper_shovel) || toRepair == new ItemStack(MItems.copper_hoe) || toRepair == new ItemStack(MItems.copper_sword))
			return new ItemStack(MItems.copper_ingot) == repair ? true : super.getIsRepairable(toRepair, repair);
		else
			return true;
	}
}
