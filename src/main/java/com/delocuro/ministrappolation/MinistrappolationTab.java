package com.delocuro.ministrappolation;

import com.delocuro.ministrappolation.init.MinistrappolationItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MinistrappolationTab extends CreativeTabs {

	public MinistrappolationTab(String label) {
		super(label);
		this.setBackgroundImageName("ministrappolation.png");
	}

	@Override
	public Item getTabIconItem() {
		return MinistrappolationItems.copper_ingot;
	}

	
}
