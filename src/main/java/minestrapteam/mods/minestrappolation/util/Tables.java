package minestrapteam.mods.minestrappolation.util;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class Tables
{
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
		Chance.createChanceTable("sifter_virtian_soil", new ArrayList<ItemStack>());
		Chance.createChanceTable("sifter_virtian_ash", new ArrayList<ItemStack>());

		//Boulders
		Chance.createChanceTable("boulder_stone", new ArrayList<ItemStack>());
		Chance.createChanceTable("boulder_red", new ArrayList<ItemStack>());
		Chance.createChanceTable("boulder_cold", new ArrayList<ItemStack>());
		Chance.createChanceTable("boulder_ice", new ArrayList<ItemStack>());
		Chance.createChanceTable("boulder_ocean", new ArrayList<ItemStack>());

		//Dimensional Fishery
		Chance.createChanceTable("overworld_items", new ArrayList<ItemStack>());
		Chance.createChanceTable("nether_items", new ArrayList<ItemStack>());
		Chance.createChanceTable("end_items", new ArrayList<ItemStack>());
		Chance.createChanceTable("virtious_items", new ArrayList<ItemStack>());
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
		Chance.addToChanceTable("sifter_mud", new ItemStack(MBlocks.tomato_seed, 1, 0), 5);
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
		Chance.addToChanceTable("sifter_podzol", null, 25);
		Chance.addToChanceTable("sifter_podzol", new ItemStack(MItems.chunks, 1, 0), 5);
		Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(Blocks.sapling), 1, 0), 10);
		Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(Blocks.sapling), 1, 1), 10);
		Chance.addToChanceTable("sifter_podzol", new ItemStack(Item.getItemFromBlock(MBlocks.ministrapp_sapling), 1, 0),
		                        10);
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
		Chance
			.addToChanceTable("sifter_mycelium", new ItemStack(Item.getItemFromBlock(Blocks.brown_mushroom), 1, 0), 10);
		Chance.addToChanceTable("sifter_mycelium", new ItemStack(MItems.uranium, 1, 0), 1);
		Chance.addToChanceTable("sifter_mycelium", new ItemStack(MItems.plutonium, 1, 0), 1);

		//Sifter - Permafrost
		Chance.addToChanceTable("sifter_permafrost", null, 25);
		Chance.addToChanceTable("sifter_permafrost", new ItemStack(MItems.chunks, 1, 3), 5);
		Chance.addToChanceTable("sifter_permafrost", new ItemStack(Items.snowball, 1, 0), 30);
		Chance.addToChanceTable("sifter_permafrost", new ItemStack(Item.getItemFromBlock(Blocks.ice), 1, 0), 3);
		Chance.addToChanceTable("sifter_permafrost", new ItemStack(MItems.crushed_ice, 1, 0), 1);
		Chance.addToChanceTable("sifter_permafrost", new ItemStack(MItems.glacieric_ice_shard, 1, 0), 1);

		//WIKI NOTE: 107 Cold Sand Entries as of 3/9/16
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

		//Sifter - Virtian Soil
		Chance.addToChanceTable("sifter_virtian_soil", null, 25);
		Chance
			.addToChanceTable("sifter_virtian_soil", new ItemStack(Item.getItemFromBlock(MBlocks.purple_glowshroom), 1),
			                  8);
		Chance
			.addToChanceTable("sifter_virtian_soil", new ItemStack(Item.getItemFromBlock(MBlocks.green_glowshroom), 1),
			                  8);
		Chance.addToChanceTable("sifter_virtian_soil", new ItemStack(MItems.jadachite_shard, 1), 3);
		Chance.addToChanceTable("sifter_virtian_soil", new ItemStack(MItems.terracreep_spore, 1), 1);

		//Sifter - Ashen Virtian Soil
		Chance.addToChanceTable("sifter_virtian_ash", null, 25);
		Chance.addToChanceTable("sifter_virtian_ash", new ItemStack(Item.getItemFromBlock(MBlocks.wither_ash), 1), 20);
		Chance.addToChanceTable("sifter_virtian_ash", new ItemStack(Items.bone, 1), 8);
		Chance.addToChanceTable("sifter_virtian_ash", new ItemStack(MItems.animal_bones, 1), 12);
		Chance.addToChanceTable("sifter_virtian_ash", new ItemStack(MItems.wither_bone, 1), 1);
		Chance.addToChanceTable("sifter_virtian_ash", new ItemStack(MItems.jadachite_shard, 1), 3);
		Chance.addToChanceTable("sifter_virtian_ash", new ItemStack(MItems.terracreep_spore, 1), 1);

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

		//WIKI NOTES: 6120 Total Overworld Entries as of 3/9/16
		//Dimensional Fishery -- Overworld Blocks
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.sand, 64, 0), 500);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.dirt, 50, 0), 400);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.gravel, 30, 0), 200);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.sandstone, 16, 0), 150);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.bedrock, 13, 0), 130);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.stone, 64, 0), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_stones, 64, 0), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_stones, 64, 1), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_stones, 64, 2), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_stones, 64, 3), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_stones, 64, 4), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_stones, 64, 5), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_stones, 64, 6), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_stones, 64, 7), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_stones, 64, 8), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.stone, 40, 1), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.stone, 40, 3), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.stone, 40, 5), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.slate, 40, 0), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.grass, 8, 0), 80);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.dirt_permafrost, 8, 0), 80);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.leaves, 8, 0), 80);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.log, 7, 0), 75);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.leaves, 7, 1), 75);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.log, 7, 1), 70);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.cold_sand, 6, 0), 65);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.dirt, 6, 1), 60);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.dirt, 6, 2), 60);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.sand, 6, 1), 60);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.snow_layer, 5, 0), 58);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.tallgrass, 5, 1), 58);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.leaves, 5, 3), 55);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.lichen_permafrost, 5, 0), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.log, 5, 3), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.leaves, 5, 2), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.leaves2, 5, 0), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.ice, 5, 0), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.log, 4, 2), 45);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.log2, 4, 0), 45);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.leaves2, 4, 1), 45);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.ministrapp_leaves, 4, 0), 45);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.log2, 4, 1), 40);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.ministrapp_log, 4, 0), 40);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.tallgrass, 3, 2), 38);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.ministrapp_leaves, 3, 1), 35);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.clay, 3, 0), 32);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.mud, 3, 0), 32);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.ministrapp_log, 3, 1), 30);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.deadbush, 2, 0), 22);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.cactus, 2, 0), 22);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.shrub_grass, 2, 0), 22);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.brown_mushroom, 3, 0), 18);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.brown_mushroom_block, 3, 0), 18);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_mushroom_block, 3, 0), 18);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.packed_ice, 1, 0), 18);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.hardened_clay, 10, 0), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.stained_hardened_clay, 10, 0), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.stained_hardened_clay, 10, 1), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.stained_hardened_clay, 10, 4), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.stained_hardened_clay, 10, 8), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.stained_hardened_clay, 10, 12), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.stained_hardened_clay, 10, 14), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.yellow_flower, 15, 0), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_flower, 15, 0), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_flower, 15, 3), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_flower, 15, 4), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_flower, 15, 5), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_flower, 15, 6), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_flower, 15, 7), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_flower, 15, 8), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.wool, 7, 0), 15);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.moss, 1, 0), 14);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.hanging_moss, 3, 0), 14);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.seaweed, 3, 0), 14);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.vine, 3, 0), 14);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.mycelium, 1, 0), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.snow, 1, 0), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_sandstone, 16, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.pumpkin, 1, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.stone_boulder, 5, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.red_rock_boulder, 5, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.coldstone_boulder, 5, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.icestone_boulder, 5, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.oceanstone_boulder, 5, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.blueberry_bush, 5, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.blackberry_bush, 5, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.raspberry_bush, 5, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.strawberry_bush, 5, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.desert_quartz, 1, 0), 9);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_mushroom, 3, 0), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_flower, 15, 1), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.red_flower, 15, 2), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.waterlily, 1, 0), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.double_plant, 4, 0), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.double_plant, 4, 1), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.double_plant, 4, 2), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.double_plant, 4, 3), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.double_plant, 4, 4), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.double_plant, 4, 5), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.wool, 7, 7), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.wool, 7, 8), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.wool, 7, 15), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.melon_block, 1, 0), 7);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_redstone, 3, 0), 14);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_redstone, 3, 2), 14);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_redstone, 3, 4), 14);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_redstone, 3, 6), 14);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_redstone, 3, 8), 14);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.coal_ore, 6, 0), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_coal, 6, 0), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_coal, 6, 1), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_coal, 6, 2), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_coal, 6, 3), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_coal, 6, 4), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_coal, 6, 5), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_coal, 6, 6), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_coal, 6, 7), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_coal, 6, 8), 12);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.mana_bush, 5, 0), 5);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.cobblestone, 1, 0), 5);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.obsidian, 1, 0), 5);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.sponge, 1, 0), 5);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.wool, 7, 12), 5);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.iron_ore, 5, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.copper_ore, 5, 0), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_copper, 5, 0), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_copper, 5, 1), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_copper, 5, 2), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_copper, 5, 3), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_copper, 5, 4), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_copper, 5, 5), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_copper, 5, 6), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_copper, 5, 7), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_copper, 5, 8), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.tin_ore, 5, 0), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_tin, 5, 0), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_tin, 5, 1), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_tin, 5, 2), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_tin, 5, 3), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_tin, 5, 4), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_tin, 5, 5), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_tin, 5, 6), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_tin, 5, 7), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_tin, 5, 8), 11);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_iron, 5, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_iron, 5, 1), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_iron, 5, 2), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_iron, 5, 3), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_iron, 5, 4), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_iron, 5, 5), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_iron, 5, 6), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_iron, 5, 7), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_iron, 5, 8), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_gold, 2, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_gold, 2, 2), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_gold, 2, 4), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_gold, 2, 6), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_gold, 2, 8), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_meurodite, 2, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_meurodite, 2, 2), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_meurodite, 2, 4), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_meurodite, 2, 6), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_meurodite, 2, 8), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_emerald, 1, 3), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_emerald, 1, 4), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_lapis, 2, 0), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_lapis, 2, 2), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_lapis, 2, 4), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_lapis, 2, 6), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_lapis, 2, 8), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_torite, 1, 0), 20);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.sunstone_ore, 2, 0), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_sunstone, 2, 0), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_sunstone, 2, 1), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_sunstone, 2, 2), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_sunstone, 2, 3), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_sunstone, 2, 4), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_sunstone, 2, 5), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_sunstone, 2, 6), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_sunstone, 2, 7), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_sunstone, 2, 8), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_plutonium, 1, 0), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_plutonium, 1, 2), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_plutonium, 1, 4), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_plutonium, 1, 6), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_plutonium, 1, 8), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_uranium, 1, 0), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_uranium, 1, 2), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_uranium, 1, 4), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_uranium, 1, 6), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_uranium, 1, 8), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_diamond, 1, 0), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_diamond, 1, 2), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_diamond, 1, 4), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_diamond, 1, 6), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_diamond, 1, 8), 4);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.radiant_ore, 1, 0), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_radiant, 1, 0), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_radiant, 1, 1), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_radiant, 1, 2), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_radiant, 1, 3), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_radiant, 1, 4), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_radiant, 1, 5), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_radiant, 1, 6), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_radiant, 1, 7), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_radiant, 1, 8), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_titanium, 1, 0), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_titanium, 1, 2), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_titanium, 1, 4), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_titanium, 1, 6), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(MBlocks.biome_titanium, 1, 8), 2);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.wool, 7, 6), 1);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.skull, 1, 0), 1);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.skull, 1, 2), 1);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.skull, 1, 3), 1);
		Chance.addToChanceTable("overworld_items", new ItemStack(Blocks.skull, 1, 4), 1);

		//Dimensional Fishery -- Overworld Items
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.animal_bones, 6, 0), 60);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.rotten_flesh, 5, 0), 58);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.bone, 5, 0), 50);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.egg, 4, 0), 42);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.beef, 4, 0), 40);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.porkchop, 4, 0), 40);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.arrow, 3, 0), 38);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.chicken, 3, 0), 35);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.feather, 3, 0), 35);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.string, 3, 0), 35);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.fish, 7, 0), 35);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.mutton, 3, 0), 32);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.gunpowder, 3, 0), 30);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.leather, 3, 0), 30);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.fat, 3, 0), 30);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.guano, 3, 0), 30);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.fish, 7, 1), 25);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.dye, 2, 0), 25);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.spider_eye, 2, 0), 22);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.flesh, 2, 0), 20);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.ender_pearl, 2, 0), 20);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.slime_ball, 2, 0), 20);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.rabbit, 2, 0), 20);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.squid_tentacle, 1, 0), 18);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.rabbit_hide, 1, 0), 18);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.reeds, 1, 0), 14);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.dye, 1, 3), 14);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.prismarine_shard, 1, 0), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.fish, 7, 3), 10);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.wing_sinew, 1, 0), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.redstone, 1, 0), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.glowstone_dust, 1, 0), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.sugar, 1, 0), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.stick, 1, 0), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.slime_core, 1, 0), 8);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.pig_foot, 3, 0), 7);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.cow_foot, 3, 0), 7);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.sheep_foot, 3, 0), 7);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.chicken_foot, 3, 0), 7);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.carrot, 1, 0), 5);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.potato, 1, 0), 5);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.prismarine_crystals, 1, 0), 5);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.wolf_hide, 1, 0), 5);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.rabbit_foot, 3, 0), 5);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.infectious_fungus, 1, 0), 5);
		Chance.addToChanceTable("overworld_items", new ItemStack(Items.fish, 7, 2), 3);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.ender_aura, 1, 0), 3);
		Chance.addToChanceTable("overworld_items", new ItemStack(MItems.heart_piece, 1, 0), 1);

		//Dimensional Fishery -- Nether Blocks
		Chance.addToChanceTable("nether_items", new ItemStack(Blocks.netherrack, 64, 0), 1000);
		Chance.addToChanceTable("nether_items", new ItemStack(Blocks.bedrock, 30, 0), 300);
		Chance.addToChanceTable("nether_items", new ItemStack(Blocks.soul_sand, 20, 0), 200);
		Chance.addToChanceTable("nether_items", new ItemStack(Blocks.gravel, 10, 0), 100);
		Chance.addToChanceTable("nether_items", new ItemStack(Blocks.glowstone, 10, 0), 100);
		Chance.addToChanceTable("nether_items", new ItemStack(Blocks.quartz_ore, 6, 0), 60);
		Chance.addToChanceTable("nether_items", new ItemStack(MBlocks.glow_mossy_netherrack, 5, 0), 52);
		Chance.addToChanceTable("nether_items", new ItemStack(Blocks.brown_mushroom, 9, 0), 48);
		Chance.addToChanceTable("nether_items", new ItemStack(Blocks.red_mushroom, 9, 0), 48);
		Chance.addToChanceTable("nether_items", new ItemStack(MBlocks.blazium_ore, 4, 0), 42);
		Chance.addToChanceTable("nether_items", new ItemStack(MBlocks.green_glowshroom, 8, 0), 40);
		Chance.addToChanceTable("nether_items", new ItemStack(MBlocks.purple_glowshroom, 8, 0), 40);
		Chance.addToChanceTable("nether_items", new ItemStack(MBlocks.hanging_glow_moss, 3, 0), 30);
		Chance.addToChanceTable("nether_items", new ItemStack(MBlocks.soul_ore, 2, 0), 22);
		Chance.addToChanceTable("nether_items", new ItemStack(Blocks.obsidian, 1, 0), 5);
		Chance.addToChanceTable("nether_items", new ItemStack(Blocks.skull, 1, 1), 3);
		Chance.addToChanceTable("nether_items", new ItemStack(Blocks.skull, 1, 0), 1);

		//Dimensional Fishery -- Nether Items
		Chance.addToChanceTable("nether_items", new ItemStack(Items.rotten_flesh, 10, 0), 100);
		Chance.addToChanceTable("nether_items", new ItemStack(Items.nether_wart, 8, 0), 80);
		Chance.addToChanceTable("nether_items", new ItemStack(Items.bone, 6, 0), 60);
		Chance.addToChanceTable("nether_items", new ItemStack(Items.gold_nugget, 5, 0), 50);
		Chance.addToChanceTable("nether_items", new ItemStack(Items.arrow, 4, 0), 40);
		Chance.addToChanceTable("nether_items", new ItemStack(Items.blaze_rod, 3, 0), 30);
		Chance.addToChanceTable("nether_items", new ItemStack(Items.coal, 2, 0), 25);
		Chance.addToChanceTable("nether_items", new ItemStack(MItems.fat, 2, 0), 22);
		Chance.addToChanceTable("nether_items", new ItemStack(Items.gunpowder, 2, 0), 20);
		Chance.addToChanceTable("nether_items", new ItemStack(Items.magma_cream, 2, 0), 20);
		Chance.addToChanceTable("nether_items", new ItemStack(MItems.wither_bone, 1, 0), 18);
		Chance.addToChanceTable("nether_items", new ItemStack(Items.fire_charge, 1, 0), 15);
		Chance.addToChanceTable("nether_items", new ItemStack(Items.ghast_tear, 1, 0), 10);
		Chance.addToChanceTable("nether_items", new ItemStack(MItems.pig_foot, 1, 0), 7);
		Chance.addToChanceTable("nether_items", new ItemStack(Items.feather, 1, 0), 5);

		//Dimensional Fishery -- End Blocks
		Chance.addToChanceTable("end_items", new ItemStack(Blocks.end_stone, 50, 0), 400);
		Chance.addToChanceTable("end_items", new ItemStack(Blocks.obsidian, 10, 0), 100);
		Chance.addToChanceTable("end_items", new ItemStack(MBlocks.glow_mossy_end_stone, 8, 0), 80);
		Chance.addToChanceTable("end_items", new ItemStack(MBlocks.hanging_glow_moss, 3, 0), 30);
		Chance.addToChanceTable("end_items", new ItemStack(Blocks.bedrock, 2, 0), 20);
		Chance.addToChanceTable("end_items", new ItemStack(MBlocks.continnium_ore, 1, 0), 18);
		Chance.addToChanceTable("end_items", new ItemStack(MBlocks.dimensium_ore, 1, 0), 18);
		Chance.addToChanceTable("end_items", new ItemStack(Blocks.dragon_egg, 1, 0), 1);

		//Dimensional Fishery -- End Items
		Chance.addToChanceTable("end_items", new ItemStack(Items.ender_pearl, 10, 0), 100);
		Chance.addToChanceTable("end_items", new ItemStack(MItems.ender_aura, 1, 0), 15);

		//Dimensional Fishery -- Virtious
		Chance.addToChanceTable("virtious_items", new ItemStack(MBlocks.virtian_soil, 50, 0), 400);
		Chance.addToChanceTable("virtious_items", new ItemStack(Blocks.bedrock, 13, 0), 130);
		Chance.addToChanceTable("virtious_items", new ItemStack(MBlocks.virtian_grass, 8), 80);
		Chance.addToChanceTable("virtious_items", new ItemStack(MBlocks.virtian_soil, 6, 1), 60);
		Chance.addToChanceTable("virtious_items", new ItemStack(MBlocks.virtian_soil, 6, 2), 60);
		Chance.addToChanceTable("virtious_items", new ItemStack(MBlocks.green_glowshroom, 4, 0), 40);
		Chance.addToChanceTable("virtious_items", new ItemStack(MBlocks.purple_glowshroom, 4, 0), 40);
		Chance.addToChanceTable("virtious_items", new ItemStack(MBlocks.huge_green_glowshroom, 1), 18);
		Chance.addToChanceTable("virtious_items", new ItemStack(MBlocks.huge_purple_glowshroom, 1), 18);
		Chance.addToChanceTable("virtious_items", new ItemStack(MBlocks.jadachiteroot, 1), 11);
		Chance.addToChanceTable("virtious_items", new ItemStack(MItems.terracreep_spore, 1), 11);
	}
}
