package com.delocuro.ministrappolation.world;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeRedwood extends BiomeGenBase {

	public BiomeRedwood(int id) 
	{
		super(id);
		this.topBlock = Blocks.dirt.getDefaultState();
		this.fillerBlock = Blocks.stone.getDefaultState();
	}

}
