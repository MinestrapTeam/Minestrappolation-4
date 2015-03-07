package com.delocuro.ministrappolation.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;

import com.delocuro.ministrappolation.init.MinistrappolationBlocks;
import com.delocuro.ministrappolation.init.MinistrappolationItems;

public class BlockDefault extends Block{
	
	private final MapColor mapColor;
	
	public BlockDefault(Material materialIn, MapColor mapColorIn) {
		super(materialIn);
		this.mapColor = mapColorIn;
	}
	
	public MapColor getMapColor(IBlockState state)
    {
        return this.mapColor;
    }
}
