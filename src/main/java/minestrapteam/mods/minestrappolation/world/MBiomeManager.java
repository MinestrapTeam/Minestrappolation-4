package minestrapteam.mods.minestrappolation.world;

import minestrapteam.mods.minestrappolation.world.biomes.BiomeFrost;
import minestrapteam.mods.minestrappolation.world.biomes.BiomeRedwood;
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
	public static BiomeGenBase	frost;
	
	public static void load()
	{
		initBiomes();
	}
	
	private static void initBiomes()
	{
		redwood = new BiomeRedwood(nextBiomeID).setBiomeName("Redwood Forest");
		frost = new BiomeFrost(nextBiomeID + 1).setBiomeName("The Frost");
		
		registerBiomes(redwood, BiomeType.WARM, Type.FOREST, nextBiomeID(), true);
		registerBiomes(frost, BiomeType.ICY, Type.COLD, nextBiomeID(), false);
	}
	
	private static void registerBiomes(BiomeGenBase biome, BiomeType type, Type forgeType, int id, boolean canSpawnIn)
	{
		BiomeDictionary.registerBiomeType(biome, forgeType);
		BiomeManager.addBiome(type, new BiomeEntry(biome, id));
		if (canSpawnIn)
		{
			BiomeManager.addSpawnBiome(biome);
		}
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
				System.out.println("Found next Biome ID: " + nextBiomeID);
				return nextBiomeID;
			}
		}
		
		return -1;
	}
	
}
