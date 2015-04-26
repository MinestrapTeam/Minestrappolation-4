package com.delocuro.ministrappolation.world;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;

public class MBiomeManager {
	
	public static BiomeGenBase redwood;
	
	public static void load()
	{
		initBiomes();
		registerBiomes();
	}
	
	private static void initBiomes()
	{
		redwood = new BiomeRedwood(137).setBiomeName("Redwood Forest");
	}
	
	private static void registerBiomes()
	{
		BiomeDictionary.registerBiomeType(redwood, Type.FOREST);
		BiomeManager.addSpawnBiome(redwood);
	}

}
