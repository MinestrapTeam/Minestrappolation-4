package minestrapteam.mods.minestrappolation;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config
{
	
	// ********** Booleans **********
	public static Boolean	radiationEffects;
	public static Boolean	blaziumFireEffect;
	public static Boolean   frostSpeedEffect;
	
	public static Boolean checkForUpdates;
	
	public static Boolean removeRecipes;
	
	//Ores
	public static Boolean   genCopper;
	public static Boolean   genTin;
	public static Boolean   genTitanium;
	public static Boolean   genMeurodite;
	public static Boolean   genSunstone;
	public static Boolean   genTorite;
	public static Boolean   genPlutonium;
	public static Boolean   genUranium;
	public static Boolean   genSlate;
	public static Boolean   genRadiant;
	public static Boolean	genMud;
	public static Boolean	genRubble;
	
	//Biomes
	public static Boolean   genRedwood;
	public static Boolean   genFrost;
	
	// ********* Integers **********
	//Misc
	public static int		soulGemDropChance;
	public static int		soulBlockDamage;
	public static int		bedrockBlockDamage;
	public static int		soulGemXPGain;
	public static int		soulBottleStorage;
	
	//Plants
	public static int		bushGrowChance;
	public static int		seaweedGrowChance;
	public static int		pepperSeedChance;
	public static int		onionSeedChance;
	public static int		riceSeedChance;
	public static int		celerySeedChance;
	
	//Drops
	public static int		animalBoneDropAmount;
	public static int		fatDropAmount;
	public static int 		sinewDropAmount;
	public static int		animalFeetDropAmount;
	public static int		wolfHideDropAmount;
	public static int		slimeCoreDropAmount;
	public static int		fleshDropAmount;
	public static int		tentacleDropAmount;
	public static int		doodadDropAmount;
	public static int		fungusDropAmount;
	public static int		guanoDropAmount;
	public static int		candyDropAmount;
	
	
	// ********* Floats **********
	
	//Drops
	public static float		animalBoneDropChance;
	public static float		fatDropChance;
	public static float 	sinewDropChance;
	public static float		animalFeetDropChance;
	public static float		wolfHideDropChance;
	public static float		slimeCoreDropChance;
	public static float		fleshDropChance;
	public static float		tentacleDropChance;
	public static float		doodadDropChance;
	public static float		fungusDropChance;
	public static float		guanoDropChance;
	public static float		candyDropChance;
	
	
	// ********* Doubles **********
	public static double    healthIncreaseMax;
	public static double    healthStarting;
	
	public static void configInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(new File("config/Minestrapp.cfg"));
		config.load();
		radiationEffects = config.get("Mechanics", "RadiationEffects", true, "Set to False to prevent Uranium and Plutonium Ore from giving you Poison/Wither effects while mining.").getBoolean();
		blaziumFireEffect = config.get("Mechanics", "BlaziumFireEffect", true, "Set to False to prevent Blocks of Blazium from igniting nearby flammable blocks.").getBoolean();
		frostSpeedEffect = config.get("Mechanics", "TheFrostSpeedEffect", true, "Set to False to disable the slowness effect that occurs while walking in the Frost biome.").getBoolean();
		
		checkForUpdates = config.get("Mechanics", "CheckForUpdates", true, "Set to True to allow Minestrapp to notify you if there is a newer stable release available.").getBoolean();
		
		removeRecipes = config.get("Mechanics", "RemoveRecipes", true, "Set to False to prevent Minestrapp from removing Vanilla crafting recipes.").getBoolean();
		
		soulGemDropChance = config.get("Mechanics", "SoulGemDropChance", 3, "The percentage chance that harvesting a fully-grown Nether Wart planted on Soul Ore will drop a Soul Gem.").getInt();
		soulBlockDamage = config.get("Mechanics", "SoulBlockDamage", 200, "The amount of durability damage inflicted on a tool when mining a Soul Block.").getInt();
		bedrockBlockDamage = config.get("Mechanics", "BedRockBlockDamage", 2000, "The amound of durability damage inflicted on a tool when mining Bedrock.").getInt();
		soulGemXPGain = config.get("Mechanics", "SoulGemXPGain", 20, "The amount of XP gained by right-clicking while holding a Soul Gem.").getInt();
		soulBottleStorage = config.get("Mechanics", "SoulBottleStorage", 10, "The maximum number of XP levels a Soul Bottle can hold.").getInt();
		
		healthIncreaseMax = config.get("Mechanics", "MaxHealthIncrease", 40D, "The maximum amount of health players can get from using Heart Containers.").getDouble();
		healthStarting = config.get("Mechanics", "StartingHealth", 10D, "The amount of health players have when entering the world (Vanilla players have 20).").getDouble();
		
		bushGrowChance = config.get("Plants", "BushGrowthChance", 4, "The growth rate of Bushes, Glacieric Ice Deposits, and Gene Blocks. Increasing this will cause these blocks to grow slower.").getInt();
		seaweedGrowChance = config.get("Plants", "SeaweedGrowthChance", 20, "The growth rate of Seaweed. Increasing this will cause Seaweed to grow slower.").getInt();
		pepperSeedChance = config.get("Plants", "PepperSeedChance", 10, "The percentage chance of finding Peppercorns when breaking Tall Grass.").getInt();
		onionSeedChance = config.get("Plants", "OnionSeedChance", 10, "The percentage chance of finding Onions when breaking Allium flowers.").getInt();
		riceSeedChance = config.get("Plants", "RiceSeedChance", 10, "The percentage chance of finding Rice when breaking Tall Grass.").getInt();
		celerySeedChance = config.get("Plants", "CelerySeedChance", 10, "The percentage chance of finding Celery Seeds when breaking Tall Grass.").getInt();
		
		animalBoneDropChance = config.get("Drops", "AnimalBoneDropChance", 20, "The percentage chance of finding Animal Bones when killing any farm animal.").getInt();
		animalBoneDropAmount = config.get("Drops", "AnimalBoneDropQuantity", 2, "The maximum amount of Animal Bones dropped when killing any farm animal.").getInt();
		fatDropChance = config.get("Drops", "FatDropChance", 40, "The percentage chance of finding Fat when killing Pigs or Zombie Pigmen.").getInt();
		fatDropAmount = config.get("Drops", "FatDropQuantity", 1, "The maximum amount of Animal Bones dropped when killing Pigs or Zombie Pigmen.").getInt();
		animalFeetDropChance = config.get("Drops", "AnimalFeetDropChance", 8, "The percentage chance of finding animal feet when killing any farm animal.").getInt();
		animalFeetDropAmount = config.get("Drops", "AnimalFeetDropQuantity", 1, "The maximum amount of animal feet dropped when killing any farm animal.").getInt();
		wolfHideDropChance = config.get("Drops", "WolfHideDropChance", 10, "The percentage chance of finding Wolf Hide when killing Wolves.").getInt();
		wolfHideDropAmount = config.get("Drops", "WolfHideDropQuantity", 1, "The maximum amount of Wolf Hide dropped when killing Wolves.").getInt();
		sinewDropChance = config.get("Drops", "WingSinewDropChance", 50, "The percentage chance of finding Wing Sinew when killing Bats.").getInt();
		sinewDropAmount = config.get("Drops", "WingSinewDropQuantity", 1, "The maximum amount of Wing Sinew dropped when killing Bats.").getInt();
		slimeCoreDropChance = config.get("Drops", "SlimeCoreDropChance", 50, "The percentage chance of finding Slime Cores when killing Slimes or Magma Cubes.").getInt();
		slimeCoreDropAmount = config.get("Drops", "SlimeCoreDropQuantity", 1, "The maximum amount of Slime Cores dropped when killing Slimes or Magma Cubes.").getInt();
		fleshDropChance = config.get("Drops", "FleshDropChance", 80, "The percentage chance of finding Flesh when killing Villagers.").getInt();
		fleshDropAmount = config.get("Drops", "FleshDropQuantity", 3, "The maximum amount of Flesh dropped when killing Villagers.").getInt();
		tentacleDropChance = config.get("Drops", "SquidTentacleDropChance", 55, "The percentage chance of finding Squid Tentacles when killing Squids or Guardians.").getInt();
		tentacleDropAmount = config.get("Drops", "SquidTentacleDropQuantity", 3, "The maximum amount of Squid Tentacles dropped when killing Squids or Guardians.").getInt();
		doodadDropChance = config.get("Drops", "TechnologicalDoodadDropChance", 100, "The percentage chance of finding Technological Doodads when killing Iron Golems.").getInt();
		doodadDropAmount = config.get("Drops", "TechnologicalDoodadDropQuantity", 1, "The maximum amount of Technological Doodads dropped when killing Iron Golems.").getInt();
		fungusDropChance = config.get("Drops", "InfectiousFungusDropChance", 15, "The percentage chance of finding Infectious Fungus when killing Mooshrooms.").getInt();
		fungusDropAmount = config.get("Drops", "InfectiousFungusDropQuantity", 1, "The maximum amount of Infectious Fungus dropped when killing Mooshrooms.").getInt();
		guanoDropChance = config.get("Drops", "GuanoDropChance", 30, "The percentage chance of finding Guano when killing Bats.").getInt();
		guanoDropAmount = config.get("Drops", "GuanoDropQuantity", 3, "The maximum amount of Guano dropped when killing Bats.").getInt();
		candyDropChance = config.get("Drops", "CandyDropChance", 30, "The percentage chance of finding Candy when killing various mobs during late October.").getInt();
		candyDropAmount = config.get("Drops", "CandyDropQuantity", 2, "The maximum amount of Candy dropped when killing various mobs during late October.").getInt();
		
		genCopper = config.get("Ores", "GenerateCopper", true, "Set to False to prevent Copper Ore from generating.").getBoolean();
		genTin = config.get("Ores", "GenerateTin", true, "Set to False to prevent Tin Ore from generating.").getBoolean();
		genTitanium = config.get("Ores", "GenerateTitanium", true, "Set to False to prevent Titanium Ore from generating.").getBoolean();
		genMeurodite = config.get("Ores", "GenerateMeurodite", true, "Set to False to prevent Meurodite Ore from generating.").getBoolean();
		genSunstone = config.get("Ores", "GenerateSunstone", true, "Set to False to prevent Sunstone Ore from generating.").getBoolean();
		genTorite = config.get("Ores", "GenerateTorite", true, "Set to False to prevent Torite Ore from generating.").getBoolean();
		genPlutonium = config.get("Ores", "GeneratePlutonium", true, "Set to False to prevent Plutonium Ore from generating.").getBoolean();
		genUranium = config.get("Ores", "GenerateUranium", true, "Set to False to prevent Uranium Ore from generating.").getBoolean();
		genSlate = config.get("Ores", "GenerateSlate", true, "Set to False to prevent Slate from generating.").getBoolean();
		genRadiant = config.get("Ores", "GenerateRadiant", true, "Set to False to prevent Radiant Quartz Ore from generating.").getBoolean();
		genMud = config.get("Ores", "GenerateMud", true, "Set to False to prevent Mud from generating.").getBoolean();
		genRubble = config.get("Ores", "GenerateRubble", true, "Set to False to prevent Rubble from generating.").getBoolean();

		genRedwood = config.get("Biomes", "GenerateRedwood", true, "Set to False to prevent Redwood biomes from generating.").getBoolean();
		genFrost = config.get("Biomes", "GenerateTheFrost", true, "Set to False to prevent Frost biomes from generating.").getBoolean();
		config.save();
	}
	
}
