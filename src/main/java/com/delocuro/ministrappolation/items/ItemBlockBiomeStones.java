package com.delocuro.ministrappolation.items;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import com.delocuro.ministrappolation.Reference;
import com.delocuro.ministrappolation.blocks.BlockBiomeStones;

public class ItemBlockBiomeStones extends ItemBlock{

	public ItemBlockBiomeStones(Block block) 
	{
		super(block);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
    public int getMetadata (int damageValue) 
	{
        return damageValue;
    }

    @Override
    public String getUnlocalizedName(ItemStack item) 
    {
        return BlockBiomeStones.EnumType.byMetadata(item.getItemDamage())+"_rock";
    }
	
	

}