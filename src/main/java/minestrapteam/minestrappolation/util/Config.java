package minestrapteam.minestrappolation.util;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {
	
	public static Boolean test = true;
	
	public static void configInit(FMLPreInitializationEvent event)
	{
		   Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		   config.load();
		   test = config.get("Misc", "test", true).getBoolean();
		   config.save();
	}

}
