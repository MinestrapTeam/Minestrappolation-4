package com.delocuro.ministrappolation.blocks;

import net.minecraft.block.BlockSnowBlock;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockMinistrappSnow extends BlockSnowBlock
{
	private final MapColor mapColor;
	
	public BlockMinistrappSnow(Material materialIn, MapColor mapColorIn) 
	{
		this.mapColor = mapColorIn;
	}
	
	public MapColor getMapColor(IBlockState state)
    {
        return this.mapColor;
    }
}
