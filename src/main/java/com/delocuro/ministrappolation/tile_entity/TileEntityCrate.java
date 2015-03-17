package com.delocuro.ministrappolation.tile_entity;

import net.minecraft.util.IChatComponent;

import com.delocuro.ministrappolation.tile_entity.TileEntityInventory;

public class TileEntityCrate extends TileEntityInventory
{	
	public TileEntityCrate()
	{
		super (18);
	}
	
	@Override
	public int getSizeInventory()
	{
		return 18;
	}
}
