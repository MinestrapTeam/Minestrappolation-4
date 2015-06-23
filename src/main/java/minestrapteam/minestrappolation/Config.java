package minestrapteam.minestrappolation;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config
{
	
	// Booleans
	public static Boolean	useRainBowXp;
	public static Boolean	radiationEffects;
	public static Boolean	blaziumFireEffect;
	public static Boolean   frostSpeedEffect;
	
	public static Boolean checkForUpdates;
	
	// Integers
	public static int		soulGemDropChance;
	public static int		soulBlockDamage;
	public static int		soulGemXPGain;
	
	public static void configInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		useRainBowXp = config.get("Visuals", "RainbowXP", true).getBoolean();
		radiationEffects = config.get("Mechanics", "RadiationEffects", true).getBoolean();
		blaziumFireEffect = config.get("Mechanics", "BlaziumFireEffect", true).getBoolean();
		frostSpeedEffect = config.get("Mechanics", "TheFrostSpeedEffect", true).getBoolean();
		
		checkForUpdates = config.get("Mechanics", "CheckForUpdates", true).getBoolean();
		
		soulGemDropChance = config.get("Mechanics", "SoulGemDropChance", 3).getInt();
		soulBlockDamage = config.get("Mechanics", "SoulBlockDamage", 200).getInt();
		soulGemXPGain = config.get("Mechanics", "SoulGemXPGain", 20).getInt();
		config.save();
	}
	
}
