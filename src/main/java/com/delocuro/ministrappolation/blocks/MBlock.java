package com.delocuro.ministrappolation.blocks;

import com.delocuro.ministrappolation.Minestrappolation;
import com.delocuro.ministrappolation.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MBlock extends Block{
	
	private final MapColor mapColor;
	
	public MBlock(Material materialIn, MapColor mapColorIn) {
		super(materialIn);
		this.mapColor = mapColorIn;
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
	}
	
	public MapColor getMapColor(IBlockState state)
    {
        return this.mapColor;
    }
	
}
