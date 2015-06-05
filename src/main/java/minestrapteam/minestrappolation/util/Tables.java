package minestrapteam.minestrappolation.util;

import java.util.ArrayList;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Tables {
	public static void loadTables()
	{
		createTables();
		populateTables();
	}

	private static void createTables()
	{
		Chance.createChanceTable("sifter_sand", new ArrayList<Item>());
		Chance.createChanceTable("sifter_red_sand", new ArrayList<Item>());
		Chance.createChanceTable("sifter_gravel", new ArrayList<Item>());
		Chance.createChanceTable("sifter_dirt", new ArrayList<Item>());
		Chance.createChanceTable("sifter_mycelium", new ArrayList<Item>());
		Chance.createChanceTable("sifter_permafrost", new ArrayList<Item>());
		Chance.createChanceTable("sifter_cold_sand", new ArrayList<Item>());
		Chance.createChanceTable("sifter_soul_sand", new ArrayList<Item>());
	}
	
	private static void populateTables()
	{
		//Sifter - Sand
		Chance.addToChanceTable("sifter_sand", null, 25);
    	Chance.addToChanceTable("sifter_sand", new ItemStack(MItems.chunks, 1, 4), 20);
    	Chance.addToChanceTable("sifter_sand", new ItemStack(MItems.chunks, 1, 1), 5);
    	Chance.addToChanceTable("sifter_sand", Items.clay_ball, 20);
    	Chance.addToChanceTable("sifter_sand", new ItemStack(MItems.chunks, 1, 6), 2);
    	//Sifter - Red Sand
    	Chance.addToChanceTable("sifter_red_sand", null, 25);
    	Chance.addToChanceTable("sifter_red_sand", new ItemStack(MItems.chunks, 1, 1), 20);
    	Chance.addToChanceTable("sifter_red_sand", new ItemStack(MItems.chunks, 1, 4), 5);
    	Chance.addToChanceTable("sifter_red_sand", Items.clay_ball, 50);
    	Chance.addToChanceTable("sifter_red_sand", new ItemStack(MItems.chunks, 1, 5), 3);
    	//Sifter - Gravel
    	Chance.addToChanceTable("sifter_gravel", null, 25);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(MItems.chunks, 1, 2), 20);
    	Chance.addToChanceTable("sifter_gravel", Items.bone, 10);
    	Chance.addToChanceTable("sifter_gravel", Items.flint, 20);
    	Chance.addToChanceTable("sifter_gravel", Items.gunpowder, 5);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(MItems.chunks, 1, 7), 3);
    	//Sifter - Dirt
    	Chance.addToChanceTable("sifter_dirt", null, 25);
    	Chance.addToChanceTable("sifter_dirt", new ItemStack(MItems.chunks, 1, 0), 5);
    	Chance.addToChanceTable("sifter_dirt", Items.wheat_seeds, 10);
    	Chance.addToChanceTable("sifter_dirt", Items.potato, 1);
    	Chance.addToChanceTable("sifter_dirt", Items.carrot, 1);
    	Chance.addToChanceTable("sifter_dirt", MItems.sunstone_shard, 3);
    	//Sifter - Mycelium
    	Chance.addToChanceTable("sifter_mycelium", null, 25);
    	Chance.addToChanceTable("sifter_mycelium", new ItemStack(MItems.chunks, 1, 0), 5);
    	Chance.addToChanceTable("sifter_mycelium", new ItemStack(MItems.chunks, 1, 4), 1);
    	Chance.addToChanceTable("sifter_mycelium", Blocks.red_mushroom, 10);
    	Chance.addToChanceTable("sifter_mycelium", Blocks.brown_mushroom, 10);
    	Chance.addToChanceTable("sifter_mycelium", MItems.uranium, 1);
    	Chance.addToChanceTable("sifter_mycelium", MItems.plutonium, 1);
    	//Sifter - Permafrost
    	Chance.addToChanceTable("sifter_permafrost", null, 25);
    	Chance.addToChanceTable("sifter_permafrost", new ItemStack(MItems.chunks, 1, 3), 5);
    	Chance.addToChanceTable("sifter_permafrost", Items.snowball, 30);
    	Chance.addToChanceTable("sifter_permafrost", Blocks.ice, 1);
    	//Sifter - Cold Sand
    	Chance.addToChanceTable("sifter_cold_sand", null, 25);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(MItems.chunks, 1, 4), 20);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(MItems.chunks, 1, 3), 5);
    	Chance.addToChanceTable("sifter_cold_sand", Items.clay_ball, 20);
    	Chance.addToChanceTable("sifter_cold_sand", Items.snowball, 30);
    	Chance.addToChanceTable("sifter_cold_sand", Blocks.ice, 1);
    	//Sifter - Soul Sand
    	Chance.addToChanceTable("sifter_soul_sand", null, 25);
    	Chance.addToChanceTable("sifter_soul_sand", Items.quartz, 20);
    	Chance.addToChanceTable("sifter_soul_sand", Items.nether_wart, 1);
    	Chance.addToChanceTable("sifter_soul_sand", Items.ghast_tear, 1);
    	Chance.addToChanceTable("sifter_soul_sand", Items.blaze_powder, 10);
    	Chance.addToChanceTable("sifter_soul_sand", MItems.blaze_shard, 5);
    	Chance.addToChanceTable("sifter_soul_sand", MItems.soul_gem, 1);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(MItems.chunks, 1, 8), 1);
	}
}
