package minestrapteam.minestrappolation.item;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemMAxe extends ItemAxe
{

	Item repairItem;
	
	public ItemMAxe(ToolMaterial material, Item repair)
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
