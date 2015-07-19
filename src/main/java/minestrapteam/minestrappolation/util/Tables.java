package minestrapteam.minestrappolation.util;

import java.util.ArrayList;

import minestrapteam.minestrappolation.lib.MBlocks;
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
		Chance.createChanceTable("sifter_sand", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_red_sand", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_gravel", new ArrayList<Item>());
		Chance.createChanceTable("sifter_dirt", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_podzol", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_mycelium", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_permafrost", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_cold_sand", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_soul_sand", new ArrayList<ItemStack>());
	}
	
	private static void populateTables()
	{
		//Sifter - Sand
		Chance.addToChanceTable("sifter_sand", null, 25);
    	Chance.addToChanceTable("sifter_sand", new ItemStack(MItems.chunks, 1, 4), 20);
    	Chance.addToChanceTable("sifter_sand", new ItemStack(MItems.chunks, 1, 1), 5);
    	Chance.addToChanceTable("sifter_sand", new ItemStack(Items.clay_ball, 1, 0), 20);
    	Chance.addToChanceTable("sifter_sand", new ItemStack(MItems.chunks, 1, 6), 2);
    	//Sifter - Red Sand
    	Chance.addToChanceTable("sifter_red_sand", null, 25);
    	Chance.addToChanceTable("sifter_red_sand", new ItemStack(MItems.chunks, 1, 1), 20);
    	Chance.addToChanceTable("sifter_red_sand", new ItemStack(MItems.chunks, 1, 4), 5);
    	Chance.addToChanceTable("sifter_red_sand", new ItemStack(Items.clay_ball, 1, 0), 50);
    	Chance.addToChanceTable("sifter_red_sand", new ItemStack(MItems.chunks, 1, 5), 3);
    	//Sifter - Gravel
    	Chance.addToChanceTable("sifter_gravel", null, 25);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(MItems.chunks, 1, 2), 20);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(Items.bone, 1, 0), 10);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(Items.flint, 1, 0), 20);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(Items.gunpowder, 1, 0), 5);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(MItems.chunks, 1, 7), 3);
    	//Sifter - Dirt
    	Chance.addToChanceTable("sifter_dirt", null, 25);
    	Chance.addToChanceTable("sifter_dirt", new ItemStack(MItems.chunks, 1, 0), 5);
    	Chance.addToChanceTable("sifter_dirt", new ItemStack(Items.wheat_seeds, 1, 0), 10);
    	Chance.addToChanceTable("sifter_dirt", new ItemStack(MBlocks.pepper_seed, 1, 0), 10);
    	Chance.addToChanceTable("sifter_dirt", new ItemStack(MBlocks.celery_seed, 1, 0), 10);
    	Chance.addToChanceTable("sifter_dirt", new ItemStack(MBlocks.rice, 1, 0), 10);
    	Chance.addToChanceTable("sifter_dirt", new ItemStack(Items.potato, 1, 0), 1);
    	Chance.addToChanceTable("sifter_dirt", new ItemStack(Items.carrot, 1, 0), 1);
    	Chance.addToChanceTable("sifter_dirt", new ItemStack(MItems.sunstone_shard, 1, 0), 3);
    	//Sifter - Podzol
    	Chance.addToChanceTable("sifter_dirt", null, 25);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(MItems.chunks, 1, 0), 5);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(Blocks.sapling), 1, 0), 10);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(Blocks.sapling), 1, 1), 10);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(MBlocks.ministrapp_sapling), 1, 0), 10);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(MBlocks.moss), 1, 0), 5);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(Blocks.red_mushroom), 1, 0), 10);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(Blocks.brown_mushroom), 1, 0), 10);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(MBlocks.lettuce, 1, 0), 1);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(MBlocks.cabbage, 1, 0), 1);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(Blocks.sapling), 1, 2), 1);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(Blocks.sapling), 1, 3), 1);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(Blocks.sapling), 1, 4), 1);
    	Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(Blocks.sapling), 1, 5), 1);
    	//Sifter - Mycelium
    	Chance.addToChanceTable("sifter_mycelium", null, 25);
    	Chance.addToChanceTable("sifter_mycelium", new ItemStack(MItems.chunks, 1, 0), 5);
    	Chance.addToChanceTable("sifter_mycelium", new ItemStack(MItems.chunks, 1, 4), 1);
    	Chance.addToChanceTable("sifter_mycelium", new ItemStack(Item.getItemFromBlock(Blocks.red_mushroom), 1, 0), 10);
    	Chance.addToChanceTable("sifter_mycelium", new ItemStack(Item.getItemFromBlock(Blocks.brown_mushroom), 1, 0), 10);
    	Chance.addToChanceTable("sifter_mycelium", new ItemStack(MItems.uranium, 1, 0), 1);
    	Chance.addToChanceTable("sifter_mycelium", new ItemStack(MItems.plutonium, 1, 0), 1);
    	//Sifter - Permafrost
    	Chance.addToChanceTable("sifter_permafrost", null, 25);
    	Chance.addToChanceTable("sifter_permafrost", new ItemStack(MItems.chunks, 1, 3), 5);
    	Chance.addToChanceTable("sifter_permafrost", new ItemStack(Items.snowball, 1, 0), 30);
    	Chance.addToChanceTable("sifter_permafrost", new ItemStack(Item.getItemFromBlock(Blocks.ice), 1, 0), 1);
    	//Sifter - Cold Sand
    	Chance.addToChanceTable("sifter_cold_sand", null, 25);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(MItems.chunks, 1, 4), 20);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(MItems.chunks, 1, 3), 5);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(Items.clay_ball, 1, 0), 20);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(Items.snowball, 1, 0), 30);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(Item.getItemFromBlock(Blocks.ice), 1, 0), 1);
    	//Sifter - Soul Sand
    	Chance.addToChanceTable("sifter_soul_sand", null, 25);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(Items.quartz, 1, 0), 20);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(Items.nether_wart, 1, 0), 1);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(Items.ghast_tear, 1, 0), 1);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(Items.blaze_powder, 1, 0), 10);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(MItems.blaze_shard, 1, 0), 5);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(MItems.soul_gem, 1, 0), 1);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(MItems.chunks, 1, 8), 1);
	}
}
