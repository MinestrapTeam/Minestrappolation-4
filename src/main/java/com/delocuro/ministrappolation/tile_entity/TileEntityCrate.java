package com.delocuro.ministrappolation.tile_entity;


public class TileEntityCrate extends TileEntityInventory
{
	public TileEntityCrate()
	{
		super(18);
	}
	
	@Override
	public int getSizeInventory()
	{
		return 18;
	}
}
