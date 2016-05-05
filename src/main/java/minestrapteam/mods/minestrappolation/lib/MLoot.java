package minestrapteam.mods.minestrappolation.lib;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class MLoot
{
	public static void addItemsToChests()
	{
		ChestGenHooks bonusChest = ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST);
		ChestGenHooks dungeonChest = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
		ChestGenHooks mineshaftCorridor = ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR);
		ChestGenHooks strongholdCorridor = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR);
		ChestGenHooks strongholdCrossing = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING);
		ChestGenHooks jungleChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		ChestGenHooks jungleDispenser = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER);
		ChestGenHooks desertChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
		ChestGenHooks blacksmithChest = ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH);
		ChestGenHooks strongholdLibrary = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY);
		ChestGenHooks netherFortress = ChestGenHooks.getInfo(ChestGenHooks.NETHER_FORTRESS);

		//Dungeon
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.technological_doodad), 2, 6, 50));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.copper_ingot), 1, 4, 20));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.tin_ingot), 1, 4, 20));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.sunstone_shard), 1, 4, 25));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_ingot), 1, 3, 10));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_ingot), 1, 3, 10));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.meurodite_gem), 1, 1, 5));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.radiant_quartz), 1, 2, 4));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.amuletPorcum), 1, 1, 1));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.amuletVaccam), 1, 1, 1));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.amuletOves), 1, 1, 1));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.amuletPullum), 1, 1, 1));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.heart_piece), 1, 2, 6));

		//Abandoned Mineshaft
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.technological_doodad), 1, 3, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.copper_ingot), 1, 5, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.tin_ingot), 1, 5, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.sunstone_shard), 4, 8, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_ingot), 1, 3, 15));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_ingot), 1, 3, 15));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.meurodite_gem), 1, 3, 8));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_pickaxe), 1, 1, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_pickaxe), 1, 1, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.sunstone_block), 1, 1, 3));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.uranium), 1, 2, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.plutonium), 1, 2, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.radiant_quartz), 1, 5, 1));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.heart_piece), 1, 2, 6));

		//Stronghold Corridor
		strongholdCorridor
			.addItem(new WeightedRandomChestContent(new ItemStack(MItems.technological_doodad), 1, 4, 40));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.copper_ingot), 1, 5, 30));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.tin_ingot), 1, 5, 30));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.sunstone_shard), 3, 9, 30));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_ingot), 1, 3, 15));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_ingot), 1, 3, 15));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.meurodite_gem), 1, 3, 13));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.torite_ingot), 1, 3, 8));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_pickaxe), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_sword), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_helmet), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_chestplate), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_leggings), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_boots), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.titanium_ingot), 1, 1, 1));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.godstone), 1, 1, 1));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.soul_gem), 1, 2, 1));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.radiant_quartz), 1, 2, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MItems.heart_piece), 1, 2, 6));

		//Stronghold Storage Room
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.lettuce), 1, 3, 50));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.cabbage), 1, 3, 50));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MItems.copper_ingot), 1, 5, 15));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MItems.tin_ingot), 1, 5, 15));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MItems.sunstone_shard), 1, 6, 20));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_ingot), 1, 3, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_ingot), 1, 3, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MItems.meurodite_gem), 1, 1, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_pickaxe), 1, 1, 2));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_pickaxe), 1, 1, 2));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MItems.meurodite_pickaxe), 0, 1, 2));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(MItems.heart_piece), 1, 2, 6));

		//Stronghold Library
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.peanuts), 1, 3, 20));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(MItems.desert_quartz_item), 1, 3, 15));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(MItems.radiant_quartz), 1, 3, 8));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(MItems.soul_gem), 1, 2, 3));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.radiant_chiseled), 1, 1, 2));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(MItems.heart_piece), 1, 2, 6));

		//Jungle Temple Chest
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.peanuts), 1, 3, 20));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.copper_ingot), 1, 4, 30));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.tin_ingot), 1, 4, 30));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_ingot), 1, 4, 25));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.torite_ingot), 1, 5, 15));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.meurodite_gem), 1, 3, 13));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.radiant_quartz), 1, 2, 6));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_ingot), 1, 3, 8));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.soul_gem), 1, 3, 1));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.heart_piece), 1, 2, 8));

		//Jungle Temple Dispenser
		jungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(Items.fire_charge), 1, 5, 10));
		jungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(MItems.ice_charge), 1, 5, 10));
		jungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(Items.lava_bucket), 1, 1, 8));
		jungleDispenser.addItem(new WeightedRandomChestContent(new ItemStack(Blocks.tnt), 1, 3, 6));

		//Desert Temple
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.peanuts), 1, 3, 20));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.copper_ingot), 1, 4, 30));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.tin_ingot), 1, 4, 30));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_ingot), 1, 4, 25));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.desert_quartz_item), 3, 11, 30));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.meurodite_gem), 1, 3, 13));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.radiant_quartz), 1, 4, 6));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_ingot), 1, 3, 8));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.soul_gem), 1, 3, 1));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.heart_piece), 1, 2, 8));

		//Village Blacksmith Building
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.lettuce), 1, 3, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.cabbage), 1, 3, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.copper_ingot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.tin_ingot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_ingot), 1, 3, 25));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_ingot), 1, 3, 25));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.meurodite_gem), 1, 2, 13));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.sunstone_shard), 1, 8, 15));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.desert_quartz_item), 1, 5, 15));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.radiant_quartz), 1, 3, 8));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_sword), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_pickaxe), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_helmet), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_chestplate), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_leggings), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.steel_boots), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_sword), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_pickaxe), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_helmet), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_chestplate), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_leggings), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.bronze_boots), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.radiant_ore), 1, 1, 1));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.titanium_ingot), 1, 1, 1));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.soul_gem), 1, 3, 1));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MItems.heart_piece), 1, 2, 6));

		//Nether Fortress Corners
		netherFortress.addItem(new WeightedRandomChestContent(new ItemStack(MItems.blaze_shard), 1, 6, 20));
		netherFortress.addItem(new WeightedRandomChestContent(new ItemStack(MItems.blazium_ingot), 1, 2, 10));
		netherFortress.addItem(new WeightedRandomChestContent(new ItemStack(MItems.soul_gem), 1, 3, 7));
		netherFortress.addItem(new WeightedRandomChestContent(new ItemStack(MItems.fire_pickaxe), 1, 1, 2));
		netherFortress.addItem(new WeightedRandomChestContent(new ItemStack(MItems.fire_sword), 1, 1, 2));
		netherFortress.addItem(new WeightedRandomChestContent(new ItemStack(MItems.heart_piece), 1, 2, 10));
	}
}
