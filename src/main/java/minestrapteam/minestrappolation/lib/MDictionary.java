package minestrapteam.minestrappolation.lib;

import net.minecraftforge.oredict.OreDictionary;

public class MDictionary {
	
	public static void load()
	{
		OreDictionary.registerOre("copperIngot", MItems.copper_ingot);
		OreDictionary.registerOre("tinIngot", MItems.tin_ingot);
		
		OreDictionary.registerOre("plankWood", MBlocks.ministrapp_planks);
	}

}
