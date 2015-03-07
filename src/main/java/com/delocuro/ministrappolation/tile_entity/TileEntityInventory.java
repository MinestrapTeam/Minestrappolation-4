package com.delocuro.ministrappolation.tile_entity;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInventory extends TileEntity implements IInventory{

	public String name;
	public ItemStack[] itemStacks;
	
	public TileEntityInventory()
	{
		this.itemStacks = new ItemStack[this.getSizeInventory()];
	}
	
	public TileEntityInventory(int size)
	{
		this.itemStacks = new ItemStack[size];
	}
	
	/*public boolean mergeStack(ItemStack stack, int start, int end)
	{
		int slotID = 
	}*/
	
	//Finish class based on Clashsoft-Lib/src/main/java/cslib/minecraft/tileentity/TileEntityInventory.java. See GitHub for source.
}
