package minestrapteam.minestrappolation.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemMHoe extends ItemHoe 
{

	Item repairItem;
	
	public ItemMHoe(ToolMaterial material, Item repair) 
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
