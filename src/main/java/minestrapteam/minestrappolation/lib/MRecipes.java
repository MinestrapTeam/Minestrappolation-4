package minestrapteam.minestrappolation.lib;

import minestrapteam.minestrappolation.util.RecipeHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

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
		GameRegistry.addSmelting(new ItemStack(MItems.chunks, 1, 5), new ItemStack(MItems.copper_ingot), 0.5F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.copper_ingot, 9), new Object[] { MBlocks.copper_block });
		
		GameRegistry.addSmelting(MBlocks.tin_ore, new ItemStack(MItems.tin_ingot), 0.5F);
		GameRegistry.addSmelting(MBlocks.biome_tin, new ItemStack(MItems.tin_ingot), 0.5F);
		GameRegistry.addSmelting(new ItemStack(MItems.chunks, 1, 6), new ItemStack(MItems.tin_ingot), 0.5F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.tin_ingot, 9), new Object[] { MBlocks.tin_block });
		
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.bronze_ingot, 9), new Object[] { MBlocks.bronze_block });
		
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.steel_ingot, 9), new Object[] { MBlocks.steel_block });
		
		GameRegistry.addSmelting(MBlocks.sunstone_ore, new ItemStack(MItems.sunstone_shard), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_sunstone, new ItemStack(MItems.sunstone_shard), 1.0F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.sunstone_block), new Object[] { "SS", "SS", 'S', MItems.sunstone_shard });
		GameRegistry.addRecipe(new ItemStack(MBlocks.godstone), new Object[] { "SGS", "PEP", "SGS", 'S', MItems.sunstone_shard, 'G', Items.glowstone_dust, 'P', Items.prismarine_crystals, 'E', Blocks.end_stone });
		
		GameRegistry.addSmelting(MBlocks.meurodite_ore, new ItemStack(MItems.meurodite_gem), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_meurodite, new ItemStack(MItems.meurodite_gem), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.meurodite_gem, 9), new Object[] { MBlocks.meurodite_block });
		
		GameRegistry.addSmelting(MBlocks.torite_ore, new ItemStack(MItems.torite_ingot), 1.2F);
		GameRegistry.addSmelting(MBlocks.biome_torite, new ItemStack(MItems.torite_ingot), 1.2F);
		GameRegistry.addSmelting(new ItemStack(MItems.chunks, 1, 9), new ItemStack(MItems.torite_ingot), 1.2F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.torite_ingot, 9), new Object[] { MBlocks.torite_block });
		
		GameRegistry.addSmelting(MBlocks.plutonium_ore, new ItemStack(MItems.plutonium), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_plutonium, new ItemStack(MItems.plutonium), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.plutonium, 9), new Object[] { MBlocks.plutonium_block });
		
		GameRegistry.addSmelting(MBlocks.uranium_ore, new ItemStack(MItems.uranium), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_uranium, new ItemStack(MItems.uranium), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.uranium, 9), new Object[] { MBlocks.uranium_block });
		
		GameRegistry.addSmelting(MBlocks.desert_quartz, new ItemStack(MItems.desert_quartz_item), 0.2F);
		
		GameRegistry.addSmelting(MBlocks.radiant_ore, new ItemStack(MItems.radiant_quartz), 1.2F);
		GameRegistry.addSmelting(MBlocks.biome_radiant, new ItemStack(MItems.radiant_quartz), 1.2F);
		
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.titanium_ingot, 9), new Object[] { MBlocks.titanium_block });
		
		GameRegistry.addSmelting(MBlocks.blazium_ore, new ItemStack(MItems.blaze_shard), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.blazium_ingot, 9), new Object[] { MBlocks.blazium_block });
		GameRegistry.addRecipe(new ItemStack(MItems.blazium_ingot, 1), new Object[] { "BB", "BB", 'B', MItems.blaze_shard });
		
		GameRegistry.addSmelting(MBlocks.soul_ore, new ItemStack(MItems.soul_gem), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.soul_gem, 9), new Object[] { MBlocks.soul_gem_block });
		
		GameRegistry.addSmelting(MBlocks.biome_coal, new ItemStack(Items.coal, 1, 0), 0.1F);
		GameRegistry.addSmelting(MBlocks.biome_iron, new ItemStack(Items.iron_ingot), 0.7F);
		GameRegistry.addSmelting(new ItemStack(MItems.chunks, 1, 7), new ItemStack(Items.iron_ingot), 0.7F);
		GameRegistry.addSmelting(MBlocks.biome_gold, new ItemStack(Items.gold_ingot), 1.0F);
		GameRegistry.addSmelting(new ItemStack(MItems.chunks, 1, 8), new ItemStack(Items.gold_ingot), 1.0F);
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
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.flint_block, 1), new Object[] { "FF", "FF", 'F', Items.flint});
		GameRegistry.addRecipe(new ItemStack(MBlocks.sugar_block, 1), new Object[] { "SSS", "SSS", "SSS", 'S', Items.sugar});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.sugar, 9), new Object[] { MBlocks.sugar_block });
		
		GameRegistry.addSmelting(new ItemStack(MBlocks.cold_sand, 1, 0), new ItemStack(Blocks.sand, 1, 0), 0.1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.cold_sand, 1, 1), new ItemStack(Blocks.sand, 1, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.dirt_permafrost, 1, 0), new ItemStack(Blocks.dirt, 1, 0), 0.1F);
		
		// Wood
		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.ministrapp_planks, 4, 0), new Object[] { new ItemStack(MBlocks.ministrapp_log, 1, 0) });
		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.ministrapp_planks, 4, 1), new Object[] { new ItemStack(MBlocks.ministrapp_log, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.redwood_stairs, 4), new Object[] { "W  ", "WW ", "WWW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 0) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.frozen_oak_stairs, 4), new Object[] { "W  ", "WW ", "WWW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 1) });
		GameRegistry.addSmelting(new ItemStack(MBlocks.ministrapp_log), new ItemStack(Items.coal, 1, 1), 0.15F);
		
		//Stone
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 0), new ItemStack(MBlocks.biome_stones, 1, 0), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 1), new ItemStack(MBlocks.biome_stones, 1, 1), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 2), new ItemStack(MBlocks.biome_stones, 1, 2), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 3), new ItemStack(MBlocks.biome_stones, 1, 3), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 4), new ItemStack(MBlocks.biome_stones, 1, 4), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 5), new ItemStack(MBlocks.biome_stones, 1, 5), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 6), new ItemStack(MBlocks.biome_stones, 1, 6), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 7), new ItemStack(MBlocks.biome_stones, 1, 7), .1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 8), new ItemStack(MBlocks.biome_stones, 1, 8), .1F);
		
		GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 1), new Object[] { "CC", "CC", 'C', new ItemStack(MItems.chunks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 1), new Object[] { "CC", "CC", 'C', new ItemStack(MItems.chunks, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 3), new Object[] { "CC", "CC", 'C', new ItemStack(MItems.chunks, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 5), new Object[] { "CC", "CC", 'C', new ItemStack(MItems.chunks, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 7), new Object[] { "CC", "CC", 'C', new ItemStack(MItems.chunks, 1, 4)});
		
		GameRegistry.addRecipe(new ItemStack(MBlocks.roads, 3, 0), new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(MItems.chunks, 1, 0), 'D', new ItemStack(Blocks.dirt, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.roads, 3, 1), new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(MItems.chunks, 1, 1), 'D', new ItemStack(Blocks.sand, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.roads, 3, 2), new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(MItems.chunks, 1, 2), 'D', new ItemStack(Blocks.gravel, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.roads, 3, 3), new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(MItems.chunks, 1, 3), 'D', new ItemStack(MBlocks.dirt_permafrost, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.roads, 3, 4), new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(MItems.chunks, 1, 4), 'D', new ItemStack(Blocks.sand, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(MBlocks.roads, 6, 5), new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(Blocks.netherrack), 'D', new ItemStack(Blocks.soul_sand, 1, 0)});
		
		// Tech
		GameRegistry.addRecipe(new ItemStack(MBlocks.alloy, 1), new Object[] { "TTT", "TFT", "BBB", 'T', new ItemStack(MItems.tin_plating), 'F', new ItemStack(Blocks.furnace), 'B', new ItemStack(MBlocks.biome_bricks, 1, 1) });
		GameRegistry.addRecipe(new ItemStack(MBlocks.melter, 1), new Object[] { "MMM", "MFM", "IBI", 'M', new ItemStack(MItems.meurodite_plating), 'F', new ItemStack(Blocks.furnace), 'I', new ItemStack(Blocks.iron_bars), 'B', MBlocks.blazium_block });
		GameRegistry.addRecipe(new ItemStack(MBlocks.frost_generator, 1), new Object[] { "IPI", "QPQ", "GRG", 'I', new ItemStack(MBlocks.biome_cobble, 1, 5), 'G', new ItemStack(MBlocks.biome_stones, 1, 6), 'P', new ItemStack(Blocks.packed_ice), 'R', Blocks.redstone_block, 'Q', MItems.radiant_quartz });
		
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
		
		//Vanilla
		GameRegistry.addRecipe(new ItemStack(Blocks.sandstone, 1, 0), new Object[] { "SS", "SS", 'S', new ItemStack(Blocks.sand, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(Blocks.red_sandstone, 1, 0), new Object[] { "SS", "SS", 'S', new ItemStack(Blocks.sand, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(Blocks.prismarine, 1, 0), new Object[] { "PP", "PP", 'P', Items.prismarine_shard});
		GameRegistry.addRecipe(new ItemStack(Blocks.redstone_lamp, 1, 0), new Object[] { " R ", "RSR", " R ", 'R', Items.redstone, 'S', MBlocks.sunstone_block});
	}
	
	public static void removeRecipes()
	{
		RecipeHelper.removeRecipeContaining(Items.bread);
		RecipeHelper.removeRecipeContaining(Items.cookie);
		RecipeHelper.removeRecipeContaining(Items.diamond_axe);
		RecipeHelper.removeRecipeContaining(Items.diamond_hoe);
		RecipeHelper.removeRecipeContaining(Items.diamond_pickaxe);
		RecipeHelper.removeRecipeContaining(Items.diamond_shovel);
		RecipeHelper.removeRecipeContaining(Items.diamond_sword);
		RecipeHelper.removeRecipeContaining(Items.flint_and_steel);
		RecipeHelper.removeRecipeContaining(Blocks.stonebrick);
		RecipeHelper.removeRecipeContaining(Blocks.stone);
		RecipeHelper.removeRecipeContaining(Blocks.mossy_cobblestone);
		RecipeHelper.removeRecipeContaining(Blocks.stone_slab);
		RecipeHelper.removeRecipeContaining(Blocks.stone_slab2);
		RecipeHelper.removeRecipeContaining(Blocks.stone_stairs);
		RecipeHelper.removeRecipeContaining(Blocks.brick_stairs);
		RecipeHelper.removeRecipeContaining(Blocks.stone_brick_stairs);
		RecipeHelper.removeRecipeContaining(Blocks.nether_brick_stairs);
		RecipeHelper.removeRecipeContaining(Blocks.sandstone_stairs);
		RecipeHelper.removeRecipeContaining(Blocks.quartz_stairs);
		RecipeHelper.removeRecipeContaining(Blocks.red_sandstone_stairs);
		RecipeHelper.removeRecipeContaining(Blocks.stained_hardened_clay);
		RecipeHelper.removeRecipeContaining(Blocks.sandstone);
		RecipeHelper.removeRecipeContaining(Blocks.red_sandstone);
		RecipeHelper.removeRecipeContaining(Blocks.prismarine);
		RecipeHelper.removeRecipeContaining(Blocks.bookshelf);
		RecipeHelper.removeRecipeContaining(Blocks.brick_block);
		RecipeHelper.removeRecipeContaining(Blocks.cobblestone_wall);
		RecipeHelper.removeRecipeContaining(Blocks.oak_fence);
		RecipeHelper.removeRecipeContaining(Blocks.birch_fence);
		RecipeHelper.removeRecipeContaining(Blocks.spruce_fence);
		RecipeHelper.removeRecipeContaining(Blocks.jungle_fence);
		RecipeHelper.removeRecipeContaining(Blocks.acacia_fence);
		RecipeHelper.removeRecipeContaining(Blocks.dark_oak_fence);
		RecipeHelper.removeRecipeContaining(Blocks.oak_fence_gate);
		RecipeHelper.removeRecipeContaining(Blocks.birch_fence_gate);
		RecipeHelper.removeRecipeContaining(Blocks.spruce_fence_gate);
		RecipeHelper.removeRecipeContaining(Blocks.jungle_fence_gate);
		RecipeHelper.removeRecipeContaining(Blocks.acacia_fence_gate);
		RecipeHelper.removeRecipeContaining(Blocks.dark_oak_fence_gate);
		RecipeHelper.removeRecipeContaining(Blocks.oak_door);
		RecipeHelper.removeRecipeContaining(Blocks.birch_door);
		RecipeHelper.removeRecipeContaining(Blocks.spruce_door);
		RecipeHelper.removeRecipeContaining(Blocks.jungle_door);
		RecipeHelper.removeRecipeContaining(Blocks.acacia_door);
		RecipeHelper.removeRecipeContaining(Blocks.dark_oak_door);
		RecipeHelper.removeRecipeContaining(Blocks.anvil);
		RecipeHelper.removeRecipeContaining(Blocks.chest);
		RecipeHelper.removeRecipeContaining(Blocks.jukebox);
		RecipeHelper.removeRecipeContaining(Blocks.noteblock);
		RecipeHelper.removeRecipeContaining(Blocks.trapdoor);
		RecipeHelper.removeRecipeContaining(Blocks.nether_brick);
		RecipeHelper.removeRecipeContaining(Blocks.nether_brick_fence);
		RecipeHelper.removeRecipeContaining(Items.ender_eye);
	}
	
}
