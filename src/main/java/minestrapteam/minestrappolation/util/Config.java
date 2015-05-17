package minestrapteam.minestrappolation.util;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {
	
	//Booleans
	public static Boolean useRainBowXp;
	public static Boolean radiationEffects;
	public static Boolean blaziumFireEffect;
	
	//Integers
	public static int soulGemDropChance;
	
	public static void configInit(FMLPreInitializationEvent event)
	{
		   Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		   config.load();
		   useRainBowXp = config.get("Visuals", "RainbowXP", true).getBoolean();
		   radiationEffects = config.get("Mechanics", "RadiationEffects", true).getBoolean();
		   blaziumFireEffect = config.get("Mechanics", "BlaziumFireEffect", true).getBoolean();
		   
		   soulGemDropChance = config.get("Mechanics", "SoulGemDropChance", 3).getInt();
		   config.save();
	}

}
