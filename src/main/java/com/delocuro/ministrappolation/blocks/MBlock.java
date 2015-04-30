package com.delocuro.ministrappolation.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

import com.delocuro.ministrappolation.Minestrappolation;

public class MBlock extends Block
{
	
	private final MapColor	mapColor;
	
	public MBlock(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn);
		this.mapColor = mapColorIn;
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
	}
	
	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return this.mapColor;
	}
	
}
