package com.delocuro.ministrappolation.world;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class MBiomeManager
{
	
	private static int			nextBiomeID	= 50;
	
	public static BiomeGenBase	redwood;
	
	public static void load()
	{
		initBiomes();
	}
	
	private static void initBiomes()
	{
		redwood = new BiomeRedwood(nextBiomeID).setBiomeName("Redwood Forest");
		registerBiomes(redwood, BiomeType.WARM, Type.FOREST, 50);
	}
	
	private static void registerBiomes(BiomeGenBase biome, BiomeType type, Type forgeType, int weight)
	{
		BiomeDictionary.registerBiomeType(biome, forgeType);
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(type, new BiomeEntry(biome, weight));
	}
	
	/**
	 * Gets the next free biome ID
	 */
	public static int nextBiomeID()
	{
		for (int id = nextBiomeID; id < 256; id++)
		{
			if (BiomeGenBase.getBiomeGenArray()[id] == null)
			{
				nextBiomeID = id + 1;
				return id;
			}
		}
		
		return -1;
	}
	
}
