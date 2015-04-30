package com.delocuro.ministrappolation.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.delocuro.ministrappolation.blocks.MWoodType;

public class ItemBlockLeaves extends ItemBlock
{
	
	public ItemBlockLeaves(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		
	}
	
	@Override
	public int getMetadata(int damageValue)
	{
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return MWoodType.byMetadata(item.getItemDamage()) + "_leaves";
	}
	
}
