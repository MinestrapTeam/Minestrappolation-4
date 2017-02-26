package minestrapteam.mods.minestrappolation.world;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.world.biomes.BiomeFrost;
import minestrapteam.mods.minestrappolation.world.biomes.BiomeRedwood;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class MBiomeManager
{
	private static int nextBiomeID	= 50;
	
	public static Biome	redwood;
	public static Biome	frost;
	
	public static void load()
	{
		initBiomes();
	}
	
	private static void initBiomes()
	{
		if(Config.genRedwood == true)
		{
			redwood = new BiomeRedwood(new Biome.BiomeProperties("Redwood Forest"));
			registerBiomes(redwood, BiomeType.WARM, Type.FOREST, 5, true); //TODO adjust 5
		}
		if(Config.genFrost == true)
		{
			registerBiomes(frost, BiomeType.ICY, Type.COLD, 5, false); //TODO adjust 5
		}
	}
	
	private static void registerBiomes(Biome biome, BiomeType type, Type forgeType, int weight, boolean canSpawnIn)
	{
		BiomeDictionary.addTypes(biome, forgeType);
		BiomeManager.addBiome(type, new BiomeEntry(biome, weight));
		if (canSpawnIn)
		{
			BiomeManager.addSpawnBiome(biome);
		}
	}
}
