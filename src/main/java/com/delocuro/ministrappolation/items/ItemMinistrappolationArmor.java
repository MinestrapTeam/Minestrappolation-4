package com.delocuro.ministrappolation.items;

import com.delocuro.ministrappolation.init.MinistrappolationItems;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemMinistrappolationArmor extends ItemArmor {

	public ItemMinistrappolationArmor(ArmorMaterial material, int renderIndex, int armorType) 
	{
		super(material, renderIndex, armorType);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(this.armorType == 2)
		{
			return "ministrapp:textures/models/armor/tin_2.png";
		}
		return "ministrapp:textures/models/armor/tin_1.png";
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
       if(toRepair == new ItemStack(MinistrappolationItems.tin_helmet) || toRepair == new ItemStack(MinistrappolationItems.tin_chestplate) || toRepair == new ItemStack(MinistrappolationItems.tin_leggings) || toRepair == new ItemStack(MinistrappolationItems.tin_boots))
       {
    	   return new ItemStack(MinistrappolationItems.tin_ingot) == repair ? true : super.getIsRepairable(toRepair, repair);
       }
       else
    	   return true;
    }
}
