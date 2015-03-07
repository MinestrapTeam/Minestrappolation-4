package com.delocuro.ministrappolation.items;

import com.delocuro.ministrappolation.init.MinistrappolationItems;

import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemMinistrappolationHoe extends ItemHoe{

	public ItemMinistrappolationHoe(ToolMaterial material) {
		super(material);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
       if(toRepair == new ItemStack(MinistrappolationItems.copper_pickaxe) || toRepair == new ItemStack(MinistrappolationItems.copper_axe) || toRepair == new ItemStack(MinistrappolationItems.copper_shovel) || toRepair == new ItemStack(MinistrappolationItems.copper_hoe) || toRepair == new ItemStack(MinistrappolationItems.copper_sword))
       {
    	   return new ItemStack(MinistrappolationItems.copper_ingot) == repair ? true : super.getIsRepairable(toRepair, repair);
       }
       else
    	   return true;
    }
}
