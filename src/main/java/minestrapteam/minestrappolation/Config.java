package minestrapteam.minestrappolation;

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
	
	// ********* Integers **********
	//Misc
	public static int		soulGemDropChance;
	public static int		soulBlockDamage;
	public static int		bedrockBlockDamage;
	public static int		soulGemXPGain;
	public static int		soulBottleStorage;
	
	//Plants
	public static int		bushGrowChance;
	public static int		pepperSeedChance;
	public static int		onionSeedChance;
	public static int		cabbageSeedChance;
	public static int		peanutChance;
	public static int		riceSeedChance;
	public static int		celerySeedChance;
	
	
	// ********* Doubles **********
	public static double    healthIncreaseMax;
	public static double    healthStarting;
	
	public static void configInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(new File("config/Minestrapp.CFG"));
		config.load();
		radiationEffects = config.get("Mechanics", "RadiationEffects", true).getBoolean();
		blaziumFireEffect = config.get("Mechanics", "BlaziumFireEffect", true).getBoolean();
		frostSpeedEffect = config.get("Mechanics", "TheFrostSpeedEffect", true).getBoolean();
		
		checkForUpdates = config.get("Mechanics", "CheckForUpdates", true).getBoolean();
		
		soulGemDropChance = config.get("Mechanics", "SoulGemDropChance", 3).getInt();
		soulBlockDamage = config.get("Mechanics", "SoulBlockDamage", 200).getInt();
		bedrockBlockDamage = config.get("Mechanics", "BedRockBlockDamage", 2000).getInt();
		soulGemXPGain = config.get("Mechanics", "SoulGemXPGain", 20).getInt();
		soulBottleStorage = config.get("Mechanics", "SoulBottleStorage", 10).getInt();
		
		healthIncreaseMax = config.get("Mechanics", "MaxHealthIncrease", 40D).getDouble();
		healthStarting = config.get("Mechanics", "StartingHealth", 10D).getDouble();
		
		bushGrowChance = config.get("Plants", "BushGrowthChance", 4).getInt();
		pepperSeedChance = config.get("Plants", "PepperSeedChance", 10).getInt();
		onionSeedChance = config.get("Plants", "OnionSeedChance", 10).getInt();
		cabbageSeedChance = config.get("Plants", "CabbageSeedChance", 10).getInt();
		peanutChance = config.get("Plants", "PeanutSeedChance", 10).getInt();
		riceSeedChance = config.get("Plants", "RiceSeedChance", 10).getInt();
		celerySeedChance = config.get("Plants", "CelerySeedChance", 10).getInt();
		config.save();
	}
	
}
