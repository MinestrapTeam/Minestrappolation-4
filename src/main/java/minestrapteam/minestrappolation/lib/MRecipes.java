package minestrapteam.minestrappolation.lib;

import java.util.Iterator;
import java.util.List;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.block.BlockBiomeBricks;
import minestrapteam.minestrappolation.util.RecipeHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MRecipes
{
	
	public static void register()
	{
		// Food
		GameRegistry.addRecipe(new ItemStack(MItems.dough, 2), new Object[] { "WW", "WW", 'W', Items.wheat });
		GameRegistry.addSmelting(new ItemStack(MItems.dough), new ItemStack(Items.bread), 0.3F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.sugar_dough, 2), new Object[] { MItems.dough, Items.sugar });
		GameRegistry.addSmelting(new ItemStack(MItems.sugar_dough), new ItemStack(MItems.sugar_cookie, 6), 0.2F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.chocolate_dough, 2), new Object[] { MItems.dough, new ItemStack(Items.dye, 1, 3) });
		GameRegistry.addSmelting(new ItemStack(MItems.chocolate_dough), new ItemStack(Items.cookie, 6), 0.2F);
		
		// Minerals
		GameRegistry.addSmelting(MBlocks.copper_ore, new ItemStack(MItems.copper_ingot), 0.5F);
		GameRegistry.addSmelting(MBlocks.biome_copper, new ItemStack(MItems.copper_ingot), 0.5F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.copper_block), new Object[] { "III", "III", "III", 'I', MItems.copper_ingot });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.copper_ingot, 9), new Object[] { MBlocks.copper_block });
		
		GameRegistry.addSmelting(MBlocks.tin_ore, new ItemStack(MItems.tin_ingot), 0.5F);
		GameRegistry.addSmelting(MBlocks.biome_tin, new ItemStack(MItems.tin_ingot), 0.5F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.tin_block), new Object[] { "III", "III", "III", 'I', MItems.tin_ingot });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.tin_ingot, 9), new Object[] { MBlocks.tin_block });
		
		GameRegistry.addSmelting(MBlocks.sunstone_ore, new ItemStack(MItems.sunstone_shard), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_sunstone, new ItemStack(MItems.sunstone_shard), 1.0F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.sunstone_block), new Object[] { "SS", "SS", 'S', MItems.sunstone_shard });
		GameRegistry.addRecipe(new ItemStack(MBlocks.godstone), new Object[] { "SGS", "PEP", "SGS", 'S', MItems.sunstone_shard, 'G', Items.glowstone_dust, 'P', Items.prismarine_crystals, 'E', Blocks.end_stone});
		
		GameRegistry.addSmelting(MBlocks.meurodite_ore, new ItemStack(MItems.meurodite_gem), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_meurodite, new ItemStack(MItems.meurodite_gem), 1.0F);
		
		GameRegistry.addSmelting(MBlocks.torite_ore, new ItemStack(MItems.torite_ingot), 1.2F);
		GameRegistry.addSmelting(MBlocks.biome_torite, new ItemStack(MItems.torite_ingot), 1.2F);
		
		//GameRegistry.addSmelting(MBlocks.plutonium_ore, new ItemStack(MItems.plutonium), 1.0F);
		//GameRegistry.addSmelting(MBlocks.biome_plutonium, new ItemStack(MItems.plutonium), 1.0F);
		
		//GameRegistry.addSmelting(MBlocks.uranium_ore, new ItemStack(MItems.uranium), 1.0F);
		//GameRegistry.addSmelting(MBlocks.biome_uranium, new ItemStack(MItems.uranium), 1.0F);
		
		GameRegistry.addSmelting(MBlocks.desert_quartz, new ItemStack(MItems.desert_quartz_item), 0.2F);
		
		GameRegistry.addSmelting(MBlocks.radiant_ore, new ItemStack(MItems.radiant_quartz), 1.2F);
		GameRegistry.addSmelting(MBlocks.biome_radiant, new ItemStack(MItems.radiant_quartz), 1.2F);
		
		GameRegistry.addSmelting(MBlocks.blazium_ore, new ItemStack(MItems.blaze_shard), 1.0F);
		
		GameRegistry.addSmelting(MBlocks.soul_ore, new ItemStack(MItems.soul_gem), 1.0F);
		
		GameRegistry.addSmelting(MBlocks.biome_coal, new ItemStack(Items.coal, 1, 0), 0.1F);
		GameRegistry.addSmelting(MBlocks.biome_iron, new ItemStack(Items.iron_ingot), 0.7F);
		GameRegistry.addSmelting(MBlocks.biome_gold, new ItemStack(Items.gold_ingot), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_redstone, new ItemStack(Items.redstone), 0.7F);
		GameRegistry.addSmelting(MBlocks.biome_lapis, new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeDamage()), 0.2F);
		GameRegistry.addSmelting(MBlocks.biome_diamond, new ItemStack(Items.diamond), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_emerald, new ItemStack(Items.emerald), 1.0F);
		
		// Decor
		GameRegistry.addRecipe(new ItemStack(MBlocks.snow_bricks, 4), new Object[] { "SS", "SS", 'S', Blocks.snow });
		GameRegistry.addRecipe(new ItemStack(MBlocks.snow_refined, 9), new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.snow });
		GameRegistry.addRecipe(new ItemStack(MBlocks.snow_tiles, 4), new Object[] { "SS", "SS", 'S', MBlocks.snow_refined });
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.glass_bricks, 4), new Object[] { "GG", "GG", 'G', Blocks.glass });
		GameRegistry.addSmelting(new ItemStack(Blocks.glass), new ItemStack(MBlocks.glass_refined), .1F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.glass_tiles, 4), new Object[] { "GG", "GG", 'G', MBlocks.glass_refined });
		GameRegistry.addRecipe(new ItemStack(MBlocks.glass_window, 4), new Object[] { "IGI", "GIG", "IGI", 'I', Blocks.iron_bars, 'G', MBlocks.glass_refined });
		GameRegistry.addRecipe(new ItemStack(MBlocks.bricked_glass_pane, 16), new Object[] { "GGG", "GGG", 'G', MBlocks.glass_bricks });
		GameRegistry.addRecipe(new ItemStack(MBlocks.refined_glass_pane, 16), new Object[] { "GGG", "GGG", 'G', MBlocks.glass_refined });
		GameRegistry.addRecipe(new ItemStack(MBlocks.tiled_glass_pane, 16), new Object[] { "GGG", "GGG", 'G', MBlocks.glass_tiles });
		GameRegistry.addRecipe(new ItemStack(MBlocks.framed_glass_pane, 16), new Object[] { "GGG", "GGG", 'G', MBlocks.glass_window });
		
		// Wood
		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.ministrapp_planks, 4, 0), new Object[] { new ItemStack(MBlocks.ministrapp_log, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.redwood_door_item, 3), new Object[] { "WW", "WW", "WW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.redwood_stairs, 4), new Object[] { "W  ", "WW ", "WWW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 0) });
		
		//Stones
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.stone_brick, 4), new Object[] { new ItemStack(Blocks.stone, 1, 0) });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.deepstone_brick, 4), new Object[] { new ItemStack(MBlocks.biome_stones, 1, 0) });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.red_rock_brick, 4), new Object[] { new ItemStack(MBlocks.biome_stones, 1, 1) });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.deep_red_rock_brick, 4), new Object[] { new ItemStack(MBlocks.biome_stones, 1, 2) });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.coldstone_brick, 4), new Object[] { new ItemStack(MBlocks.biome_stones, 1, 3) });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.deep_coldstone_brick, 4), new Object[] { new ItemStack(MBlocks.biome_stones, 1, 4) });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.icestone_brick, 4), new Object[] { new ItemStack(MBlocks.biome_stones, 1, 5) });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.glacierrock_brick, 4), new Object[] { new ItemStack(MBlocks.biome_stones, 1, 6) });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.oceanstone_brick, 4), new Object[] { new ItemStack(MBlocks.biome_stones, 1, 7) });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.pressurized_oceanstone_brick, 4), new Object[] { new ItemStack(MBlocks.biome_stones, 1, 8) });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.slate_brick, 4), new Object[] { new ItemStack(MBlocks.slate, 1, 0) });
		
		GameRegistry.addRecipe(new ItemStack(Blocks.stonebrick, 1, 0), new Object[] { "BB", "BB", 'B', MItems.stone_brick });
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 0), new Object[] { "BB", "BB", 'B', MItems.deepstone_brick });
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 1), new Object[] { "BB", "BB", 'B', MItems.red_rock_brick });
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 2), new Object[] { "BB", "BB", 'B', MItems.deep_red_rock_brick });
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 3), new Object[] { "BB", "BB", 'B', MItems.coldstone_brick });
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 4), new Object[] { "BB", "BB", 'B', MItems.deep_coldstone_brick });
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 5), new Object[] { "BB", "BB", 'B', MItems.icestone_brick });
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 6), new Object[] { "BB", "BB", 'B', MItems.glacierrock_brick });
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 7), new Object[] { "BB", "BB", 'B', MItems.oceanstone_brick });
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 8), new Object[] { "BB", "BB", 'B', MItems.pressurized_oceanstone_brick });
		
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 0), new ItemStack(MBlocks.biome_stones, 1, 0), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 1), new ItemStack(MBlocks.biome_stones, 1, 1), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 2), new ItemStack(MBlocks.biome_stones, 1, 2), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 3), new ItemStack(MBlocks.biome_stones, 1, 3), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 4), new ItemStack(MBlocks.biome_stones, 1, 4), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 5), new ItemStack(MBlocks.biome_stones, 1, 5), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 6), new ItemStack(MBlocks.biome_stones, 1, 6), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 7), new ItemStack(MBlocks.biome_stones, 1, 7), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 8), new ItemStack(MBlocks.biome_stones, 1, 8), .1F);
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.stone_pattern_bricks, 2), new Object[] { "BBB", "BBB", "BBB", 'B', MItems.stone_brick });
		GameRegistry.addRecipe(new ItemStack(MBlocks.stone_refined, 9), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stone, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.stone_tiles, 4), new Object[] { "BB", "BB", 'B', MBlocks.stone_refined });
		GameRegistry.addRecipe(new ItemStack(MBlocks.stone_lamp_glowstone, 4), new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(Blocks.stonebrick, 1, 3), 'G', Blocks.glowstone });
		GameRegistry.addRecipe(new ItemStack(MBlocks.stone_lamp_sunstone, 4), new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(Blocks.stonebrick, 1, 3), 'G', MBlocks.sunstone_block });
		GameRegistry.addRecipe(new ItemStack(MBlocks.stone_lamp_prismarine, 4), new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(Blocks.stonebrick, 1, 3), 'G', Blocks.sea_lantern });
		
		//Tech
		GameRegistry.addRecipe(new ItemStack(MBlocks.alloy, 1), new Object[] { "TTT", "TFT", "BBB", 'T', new ItemStack(MItems.tin_plating), 'F', new ItemStack(Blocks.furnace), 'B', new ItemStack(MBlocks.biome_bricks, 1, 1) });
		
		// Tools and Weapons
		GameRegistry.addRecipe(new ItemStack(MItems.copper_pickaxe), new Object[] { "III", " S ", " S ", 'I', MItems.copper_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.copper_axe), new Object[] { "II", "IS", " S", 'I', MItems.copper_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.copper_shovel), new Object[] { "I", "S", "S", 'I', MItems.copper_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.copper_hoe), new Object[] { "II", " S", " S", 'I', MItems.copper_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.copper_sword), new Object[] { "I", "I", "S", 'I', MItems.copper_ingot, 'S', Items.stick });
		
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_pickaxe), new Object[] { "III", " S ", " S ", 'I', MItems.bronze_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_axe), new Object[] { "II", "IS", " S", 'I', MItems.bronze_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_shovel), new Object[] { "I", "S", "S", 'I', MItems.bronze_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_hoe), new Object[] { "II", " S", " S", 'I', MItems.bronze_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_sword), new Object[] { "I", "I", "S", 'I', MItems.bronze_ingot, 'S', Items.stick });
		
		GameRegistry.addRecipe(new ItemStack(MItems.steel_pickaxe), new Object[] { "III", " S ", " S ", 'I', MItems.steel_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.steel_axe), new Object[] { "II", "IS", " S", 'I', MItems.steel_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.steel_shovel), new Object[] { "I", "S", "S", 'I', MItems.steel_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.steel_hoe), new Object[] { "II", " S", " S", 'I', MItems.steel_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.steel_sword), new Object[] { "I", "I", "S", 'I', MItems.steel_ingot, 'S', Items.stick });
		
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_pickaxe), new Object[] { "III", " S ", " S ", 'I', MItems.meurodite_gem, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_axe), new Object[] { "II", "IS", " S", 'I', MItems.meurodite_gem, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_shovel), new Object[] { "I", "S", "S", 'I', MItems.meurodite_gem, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_hoe), new Object[] { "II", " S", " S", 'I', MItems.meurodite_gem, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_sword), new Object[] { "I", "I", "S", 'I', MItems.meurodite_gem, 'S', MItems.reinforced_stick });
		
		GameRegistry.addRecipe(new ItemStack(MItems.torite_pickaxe), new Object[] { "III", " S ", " S ", 'I', MItems.torite_ingot, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.torite_axe), new Object[] { "II", "IS", " S", 'I', MItems.torite_ingot, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.torite_shovel), new Object[] { "I", "S", "S", 'I', MItems.torite_ingot, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.torite_hoe), new Object[] { "II", " S", " S", 'I', MItems.torite_ingot, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.torite_sword), new Object[] { "I", "I", "S", 'I', MItems.torite_ingot, 'S', MItems.reinforced_stick });
		
		GameRegistry.addRecipe(new ItemStack(MItems.fire_pickaxe), new Object[] { "III", " S ", " S ", 'I', MItems.blazium_ingot, 'S', Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(MItems.fire_axe), new Object[] { "II", "IS", " S", 'I', MItems.blazium_ingot, 'S', Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(MItems.fire_shovel), new Object[] { "I", "S", "S", 'I', MItems.blazium_ingot, 'S', Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(MItems.fire_hoe), new Object[] { "II", " S", " S", 'I', MItems.blazium_ingot, 'S', Items.blaze_rod });
		GameRegistry.addRecipe(new ItemStack(MItems.fire_sword), new Object[] { "I", "I", "S", 'I', MItems.blazium_ingot, 'S', Items.blaze_rod });
		
		GameRegistry.addRecipe(new ItemStack(Items.diamond_pickaxe), new Object[] { "III", " S ", " S ", 'I', Items.diamond, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(Items.diamond_axe), new Object[] { "II", "IS", " S", 'I', Items.diamond, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(Items.diamond_shovel), new Object[] { "I", "S", "S", 'I', Items.diamond, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(Items.diamond_hoe), new Object[] { "II", " S", " S", 'I', Items.diamond, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(Items.diamond_sword), new Object[] { "I", "I", "S", 'I', Items.diamond, 'S', MItems.reinforced_stick });
		
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_pickaxe), new Object[] { "III", " S ", " S ", 'I', MItems.titanium_ingot, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_axe), new Object[] { "II", "IS", " S", 'I', MItems.titanium_ingot, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_shovel), new Object[] { "I", "S", "S", 'I', MItems.titanium_ingot, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_hoe), new Object[] { "II", " S", " S", 'I', MItems.titanium_ingot, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_sword), new Object[] { "I", "I", "S", 'I', MItems.titanium_ingot, 'S', MItems.reinforced_stick });
		
		GameRegistry.addRecipe(new ItemStack(MItems.bedrock_pickaxe), new Object[] { "III", " S ", " S ", 'I', Blocks.bedrock, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.bedrock_axe), new Object[] { "II", "IS", " S", 'I', Blocks.bedrock, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.bedrock_shovel), new Object[] { "I", "S", "S", 'I', Blocks.bedrock, 'S', MItems.reinforced_stick });
		GameRegistry.addRecipe(new ItemStack(MItems.bedrock_hoe), new Object[] { "II", " S", " S", 'I', Blocks.bedrock, 'S', MItems.reinforced_stick });
		
		GameRegistry.addRecipe(new ItemStack(MItems.tin_helmet), new Object[] { "III", "I I", 'I', MItems.tin_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.tin_chestplate), new Object[] { "I I", "III", "III", 'I', MItems.tin_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.tin_leggings), new Object[] { "III", "I I", "I I", 'I', MItems.tin_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.tin_boots), new Object[] { "I I", "I I", 'I', MItems.tin_ingot });
		
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_helmet), new Object[] { "III", "I I", 'I', MItems.bronze_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_chestplate), new Object[] { "I I", "III", "III", 'I', MItems.bronze_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_leggings), new Object[] { "III", "I I", "I I", 'I', MItems.bronze_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_boots), new Object[] { "I I", "I I", 'I', MItems.bronze_ingot });
		
		GameRegistry.addRecipe(new ItemStack(MItems.steel_helmet), new Object[] { "III", "I I", 'I', MItems.steel_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.steel_chestplate), new Object[] { "I I", "III", "III", 'I', MItems.steel_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.steel_leggings), new Object[] { "III", "I I", "I I", 'I', MItems.steel_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.steel_boots), new Object[] { "I I", "I I", 'I', MItems.steel_ingot });
		
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_helmet), new Object[] { "III", "I I", 'I', MItems.meurodite_gem });
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_chestplate), new Object[] { "I I", "III", "III", 'I', MItems.meurodite_gem });
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_leggings), new Object[] { "III", "I I", "I I", 'I', MItems.meurodite_gem });
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_boots), new Object[] { "I I", "I I", 'I', MItems.meurodite_gem });
		
		GameRegistry.addRecipe(new ItemStack(MItems.torite_helmet), new Object[] { "III", "I I", 'I', MItems.torite_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.torite_chestplate), new Object[] { "I I", "III", "III", 'I', MItems.torite_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.torite_leggings), new Object[] { "III", "I I", "I I", 'I', MItems.torite_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.torite_boots), new Object[] { "I I", "I I", 'I', MItems.torite_ingot });
		
		GameRegistry.addRecipe(new ItemStack(MItems.blazium_helmet), new Object[] { "III", "I I", 'I', MItems.blazium_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.blazium_chestplate), new Object[] { "I I", "III", "III", 'I', MItems.blazium_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.blazium_leggings), new Object[] { "III", "I I", "I I", 'I', MItems.blazium_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.blazium_boots), new Object[] { "I I", "I I", 'I', MItems.blazium_ingot });
		
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_helmet), new Object[] { "III", "I I", 'I', MItems.titanium_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_chestplate), new Object[] { "I I", "III", "III", 'I', MItems.titanium_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_leggings), new Object[] { "III", "I I", "I I", 'I', MItems.titanium_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_boots), new Object[] { "I I", "I I", 'I', MItems.titanium_ingot });
	}
	
	public static void removeRecipes()
	{
		RecipeHelper.removeRecipeContaining(new ItemStack(Items.bread, 1));
		RecipeHelper.removeRecipeContaining(new ItemStack(Items.cookie));
		RecipeHelper.removeRecipeContaining(new ItemStack(Items.diamond_axe));
		RecipeHelper.removeRecipeContaining(new ItemStack(Items.diamond_hoe));
		RecipeHelper.removeRecipeContaining(new ItemStack(Items.diamond_pickaxe));
		RecipeHelper.removeRecipeContaining(new ItemStack(Items.diamond_shovel));
		RecipeHelper.removeRecipeContaining(new ItemStack(Items.diamond_sword));
		RecipeHelper.removeRecipeContaining(new ItemStack(Items.flint_and_steel));
		RecipeHelper.removeRecipeContaining(new ItemStack(Blocks.stone_button));
		RecipeHelper.removeRecipeContaining(new ItemStack(Blocks.stonebrick, 4, 0));
		//RecipeHelper.removeRecipeContaining(new ItemStack(Blocks.stonebrick, 1, 1));
	}
	
}
