package com.delocuro.ministrappolation;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.delocuro.ministrappolation.init.MItems;

public class MTab extends CreativeTabs
{
	
	public MTab(String label)
	{
		super(label);
		this.setBackgroundImageName("ministrappolation.png");
	}
	
	@Override
	public Item getTabIconItem()
	{
		return MItems.copper_ingot;
	}
	
}
