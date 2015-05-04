package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemMPickaxe extends ItemPickaxe
{

	Item repairItem;
	
	public ItemMPickaxe(ToolMaterial material, Item repair)
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
