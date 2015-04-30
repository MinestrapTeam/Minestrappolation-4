package com.delocuro.ministrappolation.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.delocuro.ministrappolation.blocks.MStoneType;

public class ItemBlockBiomeBricks extends ItemBlock
{
	
	public ItemBlockBiomeBricks(Block block)
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
		return MStoneType.byMetadata(item.getItemDamage()) + "_bricks";
	}
}