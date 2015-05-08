package minestrapteam.minestrappolation.lib;

import minestrapteam.minestrappolation.block.MStoneType;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MDictionary {
	
	public static final int WILDCARD_VALUE = Short.MAX_VALUE;
	
	public static void load()
	{
		OreDictionary.registerOre("copperIngot", MItems.copper_ingot);
		OreDictionary.registerOre("tinIngot", MItems.tin_ingot);
		
		OreDictionary.registerOre("logWood",     new ItemStack(MBlocks.ministrapp_log, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("plankWood",   new ItemStack(MBlocks.ministrapp_planks, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("stone",       new ItemStack(MBlocks.biome_stones, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestone", new ItemStack(MBlocks.biome_cobble, 1, WILDCARD_VALUE));
		
		OreDictionary.registerOre("oreGold",     new ItemStack(MBlocks.biome_gold, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreIron",     new ItemStack(MBlocks.biome_iron, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreLapis",    new ItemStack(MBlocks.biome_lapis, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreDiamond",  new ItemStack(MBlocks.biome_diamond, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreRedstone", new ItemStack(MBlocks.biome_redstone, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreEmerald",  new ItemStack(MBlocks.biome_emerald, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreCoal",     new ItemStack(MBlocks.biome_coal, 1, WILDCARD_VALUE));
	}

}
