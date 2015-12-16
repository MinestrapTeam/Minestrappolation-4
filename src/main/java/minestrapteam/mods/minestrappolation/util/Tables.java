package minestrapteam.mods.minestrappolation.util;

import java.util.ArrayList;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
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
		Chance.createChanceTable("sifter_clay", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_mud", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_rubble", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_gravel", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_dirt", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_podzol", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_mycelium", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_permafrost", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_cold_sand", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_soul_sand", new ArrayList<ItemStack>());
		
		//Boulders
		Chance.createChanceTable("boulder_stone", new ArrayList<ItemStack>());
		Chance.createChanceTable("boulder_red", new ArrayList<ItemStack>());
		Chance.createChanceTable("boulder_cold", new ArrayList<ItemStack>());
		Chance.createChanceTable("boulder_ice", new ArrayList<ItemStack>());
		Chance.createChanceTable("boulder_ocean", new ArrayList<ItemStack>());
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
    	
    	//Sifter - Clay
    	Chance.addToChanceTable("sifter_clay", null, 25);
    	Chance.addToChanceTable("sifter_clay", new ItemStack(Items.clay_ball, 1, 0), 50);
    	Chance.addToChanceTable("sifter_clay", new ItemStack(MItems.animal_bones, 1, 0), 30);
    	Chance.addToChanceTable("sifter_clay", new ItemStack(Items.bone, 1, 0), 10);
    	Chance.addToChanceTable("sifter_clay", new ItemStack(Items.reeds, 1, 0), 10);
    	Chance.addToChanceTable("sifter_clay", new ItemStack(MBlocks.seaweed, 1, 0), 5);
    	Chance.addToChanceTable("sifter_clay", new ItemStack(Items.slime_ball, 1, 0), 5);
    	Chance.addToChanceTable("sifter_clay", new ItemStack(MItems.squid_tentacle, 1, 0), 3);
    	
    	//Sifter - Mud
    	Chance.addToChanceTable("sifter_mud", null, 25);
    	Chance.addToChanceTable("sifter_mud", new ItemStack(MItems.mud_ball, 1, 0), 50);
    	Chance.addToChanceTable("sifter_mud", new ItemStack(MItems.animal_bones, 1, 0), 40);
    	Chance.addToChanceTable("sifter_mud", new ItemStack(Items.clay_ball, 1, 0), 30);
    	Chance.addToChanceTable("sifter_mud", new ItemStack(MItems.chunks, 1, 0), 5);
    	Chance.addToChanceTable("sifter_mud", new ItemStack(Items.wheat_seeds, 1, 0), 5);
    	Chance.addToChanceTable("sifter_mud", new ItemStack(MBlocks.pepper_seed, 1, 0), 5);
    	Chance.addToChanceTable("sifter_mud", new ItemStack(MBlocks.celery_seed, 1, 0), 5);
    	Chance.addToChanceTable("sifter_mud", new ItemStack(MBlocks.rice, 1, 0), 5);
    	Chance.addToChanceTable("sifter_mud", new ItemStack(Items.potato, 1, 0), 1);
    	Chance.addToChanceTable("sifter_mud", new ItemStack(Items.carrot, 1, 0), 1);
    	Chance.addToChanceTable("sifter_mud", new ItemStack(Items.slime_ball, 1, 0), 8);
    	
    	//Sifter - Gravel
    	Chance.addToChanceTable("sifter_gravel", null, 25);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(MItems.chunks, 1, 2), 20);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(Items.bone, 1, 0), 10);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(Items.flint, 1, 0), 20);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(Items.gunpowder, 1, 0), 5);
    	Chance.addToChanceTable("sifter_gravel", new ItemStack(MItems.chunks, 1, 7), 3);
    	
    	//Sifter - Rubble
    	Chance.addToChanceTable("sifter_rubble", null, 25);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.chunks, 1, 2), 20);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(Items.bone, 1, 0), 10);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(Items.flint, 1, 0), 20);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(Items.gunpowder, 1, 0), 5);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.chunks, 1, 7), 3);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.technological_doodad, 1, 0), 5);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.propeller, 1, 0), 10);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 0), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 1), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 2), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 3), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 4), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 5), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 6), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 7), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 8), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 9), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 10), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 11), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 12), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 13), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 14), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(MItems.bricks, 1, 15), 1);
    	Chance.addToChanceTable("sifter_rubble", new ItemStack(Blocks.skull, 1, 0), 1);
    	
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
    	Chance.addToChanceTable("sifter_permafrost", new ItemStack(Item.getItemFromBlock(Blocks.ice), 1, 0), 3);
    	Chance.addToChanceTable("sifter_permafrost", new ItemStack(MItems.crushed_ice, 1, 0), 1);
    	Chance.addToChanceTable("sifter_permafrost", new ItemStack(MItems.glacieric_ice_shard, 1, 0), 1);
    	
    	//Sifter - Cold Sand
    	Chance.addToChanceTable("sifter_cold_sand", null, 25);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(MItems.chunks, 1, 4), 20);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(MItems.chunks, 1, 3), 5);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(Items.clay_ball, 1, 0), 20);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(Items.snowball, 1, 0), 30);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(Item.getItemFromBlock(Blocks.ice), 1, 0), 5);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(MItems.crushed_ice, 1, 0), 1);
    	Chance.addToChanceTable("sifter_cold_sand", new ItemStack(MItems.glacieric_ice_shard, 1, 0), 1);
    	
    	//Sifter - Soul Sand
    	Chance.addToChanceTable("sifter_soul_sand", null, 25);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(Items.quartz, 1, 0), 20);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(Items.nether_wart, 1, 0), 1);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(Items.ghast_tear, 1, 0), 1);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(Items.blaze_powder, 1, 0), 10);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(MItems.blaze_shard, 1, 0), 5);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(MItems.soul_gem, 1, 0), 1);
    	Chance.addToChanceTable("sifter_soul_sand", new ItemStack(MItems.chunks, 1, 8), 1);
    	
    	//Boudler Stone
    	Chance.addToChanceTable("boulder_stone", new ItemStack(Blocks.cobblestone, 1, 0), 25);
    	Chance.addToChanceTable("boulder_stone", new ItemStack(MItems.chunks, 1, 0), 18);
    	Chance.addToChanceTable("boulder_stone", new ItemStack(Items.flint, 1, 0), 8);
    	Chance.addToChanceTable("boulder_stone", new ItemStack(Items.gunpowder, 1, 0), 8);
    	Chance.addToChanceTable("boulder_stone", new ItemStack(Items.redstone, 1, 0), 4);
    	Chance.addToChanceTable("boulder_stone", new ItemStack(MItems.sunstone_shard, 1, 0), 4);
    	Chance.addToChanceTable("boulder_stone", new ItemStack(Items.diamond, 1, 0), 2);
    	Chance.addToChanceTable("boulder_stone", new ItemStack(MItems.meurodite_gem, 1, 0), 2);
    	
    	//Boudler red
    	Chance.addToChanceTable("boulder_red", new ItemStack(MBlocks.biome_cobble, 1, 1), 25);
    	Chance.addToChanceTable("boulder_red", new ItemStack(MItems.chunks, 1, 1), 18);
    	Chance.addToChanceTable("boulder_red", new ItemStack(MItems.desert_quartz_item, 1, 0), 8);
    	Chance.addToChanceTable("boulder_red", new ItemStack(Items.clay_ball, 1, 0), 8);
    	Chance.addToChanceTable("boulder_red", new ItemStack(Items.redstone, 1, 0), 4);
    	Chance.addToChanceTable("boulder_red", new ItemStack(MItems.sunstone_shard, 1, 0), 4);
    	Chance.addToChanceTable("boulder_red", new ItemStack(Items.diamond, 1, 0), 2);
    	Chance.addToChanceTable("boulder_red", new ItemStack(MItems.radiant_quartz, 1, 0), 2);
    	
    	//Boudler cold
    	Chance.addToChanceTable("boulder_cold", new ItemStack(MBlocks.biome_cobble, 1, 3), 25);
    	Chance.addToChanceTable("boulder_cold", new ItemStack(MItems.chunks, 1, 2), 18);
    	Chance.addToChanceTable("boulder_cold", new ItemStack(Items.bone, 1, 0), 8);
    	Chance.addToChanceTable("boulder_cold", new ItemStack(Items.dye, 1, 0), 8);
    	Chance.addToChanceTable("boulder_cold", new ItemStack(Items.redstone, 1, 0), 4);
    	Chance.addToChanceTable("boulder_cold", new ItemStack(MItems.sunstone_shard, 1, 0), 4);
    	Chance.addToChanceTable("boulder_cold", new ItemStack(Items.diamond, 1, 0), 2);
    	Chance.addToChanceTable("boulder_cold", new ItemStack(Items.emerald, 1, 0), 2);
    	
    	//Boudler ice
    	Chance.addToChanceTable("boulder_ice", new ItemStack(MBlocks.biome_cobble, 1, 5), 25);
    	Chance.addToChanceTable("boulder_ice", new ItemStack(MItems.chunks, 1, 3), 18);
    	Chance.addToChanceTable("boulder_ice", new ItemStack(Items.snowball, 1, 0), 8);
    	Chance.addToChanceTable("boulder_ice", new ItemStack(Blocks.ice, 1, 0), 8);
    	Chance.addToChanceTable("boulder_ice", new ItemStack(Blocks.packed_ice, 1, 0), 4);
    	Chance.addToChanceTable("boulder_ice", new ItemStack(MItems.sunstone_shard, 1, 0), 4);
    	Chance.addToChanceTable("boulder_ice", new ItemStack(Items.diamond, 1, 0), 2);
    	Chance.addToChanceTable("boulder_ice", new ItemStack(Items.emerald, 1, 0), 2);
    	
    	//Boudler ocean
    	Chance.addToChanceTable("boulder_ocean", new ItemStack(MBlocks.biome_cobble, 1, 7), 25);
    	Chance.addToChanceTable("boulder_ocean", new ItemStack(MItems.chunks, 1, 4), 18);
    	Chance.addToChanceTable("boulder_ocean", new ItemStack(Items.fish, 1, 0), 8);
    	Chance.addToChanceTable("boulder_ocean", new ItemStack(Items.prismarine_shard, 1, 0), 8);
    	Chance.addToChanceTable("boulder_ocean", new ItemStack(Items.redstone, 1, 0), 4);
    	Chance.addToChanceTable("boulder_ocean", new ItemStack(Items.prismarine_crystals, 1, 0), 4);
    	Chance.addToChanceTable("boulder_ocean", new ItemStack(Items.diamond, 1, 0), 2);
    	Chance.addToChanceTable("boulder_ocean", new ItemStack(Blocks.sea_lantern, 1, 0), 2);
	}
}
