package minestrapteam.mods.minestrappolation.world;

import minestrapteam.mods.minestrappolation.Config;
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

	private static int nextBiomeID = 50;

	public static BiomeGenBase redwood;
	public static BiomeGenBase frost;

	public static void load()
	{
		initBiomes();
	}

	private static void initBiomes()
	{
		if (Config.genRedwood == true)
		{
			int redwoodID = nextBiomeID();
			redwood = new BiomeRedwood(redwoodID).setBiomeName("Redwood Forest");
			registerBiomes(redwood, BiomeType.WARM, Type.FOREST, redwoodID, true);
		}
		if (Config.genFrost == true)
		{
			int frostID = nextBiomeID();
			frost = new BiomeFrost(frostID).setBiomeName("The Frost");
			registerBiomes(frost, BiomeType.ICY, Type.COLD, frostID, false);
		}
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
				nextBiomeID = id;
				System.out.println("Found next Biome ID: " + nextBiomeID);
				return nextBiomeID;
			}
		}

		return -1;
	}
}
