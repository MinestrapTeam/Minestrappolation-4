package minestrapteam.minestrappolation.util;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {
	
	public static Boolean useRainBowXp = true;
	
	public static void configInit(FMLPreInitializationEvent event)
	{
		   Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		   config.load();
		   useRainBowXp = config.get("Visuals", "RainbowXP", true).getBoolean();
		   config.save();
	}

}
