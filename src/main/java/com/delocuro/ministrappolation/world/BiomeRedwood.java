package com.delocuro.ministrappolation.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeRedwood extends BiomeGenBase {

	public BiomeRedwood(int id) 
	{
		super(id);
		this.setTemperatureRainfall(1.0F, 2F);
		this.enableSnow = false;
		
		this.topBlock = Blocks.grass.getDefaultState();
		this.fillerBlock = Blocks.stone.getDefaultState();
	}
	
	
	
	@Override
	public WorldGenAbstractTree genBigTreeChance(Random random)
    {	
		return random.nextInt(4) == 0 ? new WorldGenRedWoodTree() : random.nextInt(8) < 2 ? this.worldGeneratorTrees : new WorldGenRedWoodTreeSmall();	
	}

}
