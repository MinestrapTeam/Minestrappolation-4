package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemMSword extends ItemSword
{
	Item repairItem;
	
	public ItemMSword(ToolMaterial material, Item repair)
	{
		super(material);
		this.repairItem = repair;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == repairItem;
	}
}
