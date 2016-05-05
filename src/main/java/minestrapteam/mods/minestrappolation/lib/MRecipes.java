package minestrapteam.mods.minestrappolation.lib;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.crafting.recipes.MShapedRecipe;
import minestrapteam.mods.minestrappolation.util.RecipeHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MRecipes
{

	public static void register()
	{
		GameRegistry.addRecipe(new ItemStack(MItems.soulbottle, 1), "S", "B", 'S', MItems.soul_gem, 'B',
		                       Items.glass_bottle);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.heart_container, 1), MItems.heart_piece, MItems.heart_piece,
		                                MItems.heart_piece, MItems.heart_piece);
		GameRegistry.addRecipe(new ItemStack(MItems.wing_segment, 1), "SSS", "LLL", "FFF", 'S', MItems.wing_sinew, 'L',
		                       Items.leather, 'F', Items.feather);
		GameRegistry.addRecipe(new ItemStack(Items.dye, 1, 15), "BB", "BB", 'B', MItems.animal_bones);
		GameRegistry.addRecipe(new ItemStack(MItems.amuletPorcum, 1), "SSS", "GFG", "NEN", 'S', Items.string, 'G', Items.gold_ingot,
		                       'F', MItems.pig_foot, 'N', Items.gold_nugget, 'E', Items.emerald);
		GameRegistry.addRecipe(new ItemStack(MItems.amuletVaccam, 1), "SSS", "GFG", "NEN", 'S', Items.string, 'G', Items.gold_ingot,
		                       'F', MItems.cow_foot, 'N', Items.gold_nugget, 'E', Items.emerald);
		GameRegistry.addRecipe(new ItemStack(MItems.amuletOves, 1), "SSS", "GFG", "NEN", 'S', Items.string, 'G', Items.gold_ingot,
		                       'F', MItems.sheep_foot, 'N', Items.gold_nugget, 'E', Items.emerald);
		GameRegistry.addRecipe(new ItemStack(MItems.amuletPullum, 1), "SSS", "GFG", "NEN", 'S', Items.string, 'G', Items.gold_ingot,
		                       'F', MItems.chicken_foot, 'N', Items.gold_nugget, 'E', Items.emerald);
		GameRegistry.addRecipe(new ItemStack(MItems.propeller, 1), "C C", " B ", " C ", 'C', MItems.copper_ingot, 'B',
		                       MItems.bronze_ingot);
		GameRegistry.addRecipe(new ItemStack(MBlocks.fan, 1), "GSG", "CBC", "CPC", 'G', MBlocks.granite_bricks, 'S',
		                       MBlocks.steel_mesh, 'C', new ItemStack(MBlocks.biome_bricks, 1, 3), 'B', MItems.propeller,
		                       'P', MItems.technological_doodad);
		GameRegistry.addRecipe(new ItemStack(MBlocks.chimney, 1), "G G", "SSS", "SSS", 'G',
		                       new ItemStack(MItems.bricks, 4, 11), 'S', new ItemStack(MItems.bricks, 4, 10));
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.ice_charge, 3), MItems.glacieric_ice_shard, MItems.mana_leaf,
		                                MItems.crushed_ice);

		GameRegistry.addRecipe(new ItemStack(MItems.satchel, 1), "HRH", "HCH", "HHH", 'H', Items.rabbit_hide, 'R',
		                       MBlocks.rope, 'C', MBlocks.crate);
		GameRegistry.addRecipe(new ItemStack(MItems.backpack, 1), "HGH", "RBR", "HHH", 'H', MItems.wolf_hide, 'R',
		                       MBlocks.rope, 'B', MBlocks.barrel, 'G', Items.gold_ingot);

		GameRegistry.addSmelting(new ItemStack(MItems.fat), new ItemStack(MItems.tallow), 0.5F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.candle, 2), "R", "T", 'R', MBlocks.rope, 'T', MItems.tallow);

		GameRegistry.addRecipe(new ItemStack(MItems.deathmeal, 3), "B", 'B', MItems.wither_bone);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.will_o_wisp, 1), Items.glass_bottle, Items.blaze_powder,
		                                MItems.ender_aura, MBlocks.wither_ash, MItems.animal_bones, MItems.grease);
		GameRegistry.addRecipe(new ItemStack(MBlocks.virtian_soil, 4, 1), "VG", "GV", 'V',
		                       new ItemStack(MBlocks.virtian_soil, 1, 0), 'G', Blocks.gravel);

		// Food
		GameRegistry.addRecipe(new ItemStack(MItems.corn_meal, 2), "WW", "WW", 'W', MBlocks.corn);
		GameRegistry.addRecipe(new ItemStack(MItems.dough, 2), "WW", "WW", 'W', Items.wheat);
		GameRegistry.addSmelting(new ItemStack(MItems.corn_meal), new ItemStack(MItems.corn_bread), 0.3F);
		GameRegistry.addSmelting(new ItemStack(MItems.dough), new ItemStack(Items.bread), 0.3F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.pbj_sandwich, 1), MItems.bun, MItems.bun, MItems.peanut_butter_bottle.setContainerItem(Items.glass_bottle),
		                                MItems.jam_bottle.setContainerItem(Items.glass_bottle));
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.hamburger, 1), MItems.bun, MItems.bun, MBlocks.lettuce,
		                                MBlocks.onion, Items.cooked_beef);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.salmon_burger, 1), MItems.bun, MItems.bun, MBlocks.lettuce,
		                                MBlocks.onion, MItems.fried_salmon);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.fish_and_chips, 1), MItems.fries, MItems.fried_fish);
		GameRegistry
			.addShapelessRecipe(new ItemStack(MItems.sugar_dough, 2), MItems.dough, Items.sugar);
		GameRegistry.addSmelting(new ItemStack(MItems.sugar_dough), new ItemStack(MItems.sugar_cookie, 6), 0.2F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.chocolate_dough, 2), MItems.dough,
		                                new ItemStack(Items.dye, 1, 3));
		GameRegistry.addSmelting(new ItemStack(MItems.chocolate_dough), new ItemStack(Items.cookie, 6), 0.2F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.pie_crust, 1), MItems.sugar_dough, Items.egg, Items.bowl);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.hot_sauce, 1), MItems.pepper,
		                                new ItemStack(Items.potionitem, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.bread_mushroom_stew, 1), Blocks.red_mushroom, Blocks.brown_mushroom,
		                                MItems.bread_bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.bread_rabbit_stew, 1), " R ", "CPM", " B ", 'R', Items.cooked_rabbit,
		                             'C', Items.carrot, 'P', Items.baked_potato, 'M', Blocks.red_mushroom, 'B',
		                             MItems.bread_bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.bread_rabbit_stew, 1), " R ", "CPM", " B ", 'R', Items.cooked_rabbit,
		                             'C', Items.carrot, 'P', Items.baked_potato, 'M', Blocks.brown_mushroom, 'B',
		                             MItems.bread_bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C', MBlocks.cabbage,
		                             '#', Items.carrot, 'B', Items.bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C', MBlocks.cabbage,
		                             '#', MItems.celery, 'B', Items.bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C', MBlocks.cabbage,
		                             '#', MBlocks.onion, 'B', Items.bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C', MBlocks.cabbage,
		                             '#', MItems.pepper, 'B', Items.bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.bread_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C',
		                             MBlocks.cabbage, '#', Items.carrot, 'B', MItems.bread_bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.bread_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C',
		                             MBlocks.cabbage, '#', MItems.celery, 'B', MItems.bread_bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.bread_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C',
		                             MBlocks.cabbage, '#', MBlocks.onion, 'B', MItems.bread_bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.bread_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C',
		                             MBlocks.cabbage, '#', MItems.pepper, 'B', MItems.bread_bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.health_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C',
		                             MBlocks.cabbage, '#', MItems.raspberry, 'B', Items.bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.bread_health_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce,
		                             'C', MBlocks.cabbage, '#', MItems.raspberry, 'B', MItems.bread_bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.saturation_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C',
		                             MBlocks.cabbage, '#', MItems.blueberry, 'B', Items.bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.bread_saturation_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce,
		                             'C', MBlocks.cabbage, '#', MItems.blueberry, 'B', MItems.bread_bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.speed_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C',
		                             MBlocks.cabbage, '#', MItems.blackberry, 'B', Items.bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.bread_speed_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C',
		                             MBlocks.cabbage, '#', MItems.blackberry, 'B', MItems.bread_bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.strength_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce, 'C',
		                             MBlocks.cabbage, '#', MItems.strawberry, 'B', Items.bowl);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.bread_strength_salad, 1), "L#C", " B ", 'L', MBlocks.lettuce,
		                             'C', MBlocks.cabbage, '#', MItems.strawberry, 'B', MItems.bread_bowl);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.stir_fry, 1), MItems.rice_bowl, MItems.hot_sauce.setContainerItem(Items.glass_bottle),
		                                Items.carrot);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.stir_fry, 1), MItems.rice_bowl, MItems.hot_sauce.setContainerItem(Items.glass_bottle),
		                                MBlocks.onion);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.stir_fry, 1), MItems.rice_bowl, MItems.hot_sauce.setContainerItem(Items.glass_bottle),
		                                MItems.celery);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.bread_stir_fry, 1), MItems.bread_rice_bowl, MItems.hot_sauce.setContainerItem(Items.glass_bottle),
		                                Items.carrot);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.bread_stir_fry, 1), MItems.bread_rice_bowl, MItems.hot_sauce.setContainerItem(Items.glass_bottle),
		                                MBlocks.onion);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.bread_stir_fry, 1), MItems.bread_rice_bowl, MItems.hot_sauce.setContainerItem(Items.glass_bottle),
		                                MItems.celery);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.jam_bottle, 1), MItems.blueberry, MItems.strawberry, MItems.raspberry,
		                                MItems.blackberry, Items.glass_bottle);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.peanut_butter_bottle, 1), MBlocks.peanuts, MBlocks.peanuts,
		                                MBlocks.peanuts, MBlocks.peanuts, Items.glass_bottle);
		GameRegistry.addSmelting(new ItemStack(MItems.squid_tentacle), new ItemStack(MItems.calamari), 0.3F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.sushi, 1), MBlocks.seaweed, MBlocks.rice, Items.carrot,
		                                new ItemStack(Items.cooked_fish, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.sushi, 1), MBlocks.seaweed, MBlocks.rice, MItems.celery,
		                                new ItemStack(Items.cooked_fish, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.lucky_sushi, 1), MBlocks.seaweed, MBlocks.rice, Items.carrot,
		                                MItems.hot_sauce.setContainerItem(Items.glass_bottle),
		                                new ItemStack(Items.fish, 1, 2), Items.gold_nugget, Items.gold_nugget, Items.gold_nugget,
		                                Items.gold_nugget);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.lucky_sushi, 1), MBlocks.seaweed, MBlocks.rice, MItems.celery,
		                                MItems.hot_sauce.setContainerItem(Items.glass_bottle),
		                                new ItemStack(Items.fish, 1, 2), Items.gold_nugget, Items.gold_nugget, Items.gold_nugget,
		                                Items.gold_nugget);
		GameRegistry.addRecipe(new ItemStack(MItems.onigiri, 3), " R ", "RCR", "RSR", 'R', MBlocks.rice, 'C', MItems.calamari,
		                       'S', MBlocks.seaweed);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.ice_cream, 1), MItems.strawberry,
		                                new ItemStack(Items.dye, 1, EnumDyeColor.BROWN.getDyeDamage()), MItems.crushed_ice,
		                                Items.bowl, Items.sugar, Items.milk_bucket.setContainerItem(Items.bucket));
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.ice_cream, 1), MItems.strawberry,
		                                new ItemStack(Items.dye, 1, EnumDyeColor.BROWN.getDyeDamage()), MItems.crushed_ice,
		                                MItems.bread_bowl, Items.sugar,
		                                Items.milk_bucket.setContainerItem(Items.bucket));
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.glowshroom_stew, 1), Items.bowl, MBlocks.purple_glowshroom,
		                                MBlocks.green_glowshroom, MItems.mana_leaf, Items.ghast_tear);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.bread_glowshroom_stew, 1), MItems.bread_bowl, MBlocks.purple_glowshroom,
		                                MBlocks.green_glowshroom, MItems.mana_leaf, Items.ghast_tear);

		// Minerals
		GameRegistry.addSmelting(MBlocks.copper_ore, new ItemStack(MItems.copper_ingot), 0.5F);
		GameRegistry.addSmelting(MBlocks.biome_copper, new ItemStack(MItems.copper_ingot), 0.5F);
		GameRegistry.addSmelting(new ItemStack(MItems.chunks, 1, 5), new ItemStack(MItems.copper_ingot), 0.5F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.copper_ingot, 9), MBlocks.copper_block);

		GameRegistry.addSmelting(MBlocks.tin_ore, new ItemStack(MItems.tin_ingot), 0.5F);
		GameRegistry.addSmelting(MBlocks.biome_tin, new ItemStack(MItems.tin_ingot), 0.5F);
		GameRegistry.addSmelting(new ItemStack(MItems.chunks, 1, 6), new ItemStack(MItems.tin_ingot), 0.5F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.tin_ingot, 9), MBlocks.tin_block);

		GameRegistry.addShapelessRecipe(new ItemStack(MItems.bronze_ingot, 9), MBlocks.bronze_block);

		GameRegistry.addShapelessRecipe(new ItemStack(MItems.steel_ingot, 9), MBlocks.steel_block);

		GameRegistry.addSmelting(MBlocks.sunstone_ore, new ItemStack(MItems.sunstone_shard), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_sunstone, new ItemStack(MItems.sunstone_shard), 1.0F);
		GameRegistry
			.addRecipe(new ItemStack(MBlocks.sunstone_block), "SS", "SS", 'S', MItems.sunstone_shard);
		GameRegistry.addRecipe(new ItemStack(MBlocks.godstone), "SGS", "PEP", "SGS", 'S', MItems.sunstone_shard, 'G',
		                       Items.glowstone_dust, 'P', Items.prismarine_crystals, 'E', Blocks.end_stone);

		GameRegistry.addSmelting(MBlocks.meurodite_ore, new ItemStack(MItems.meurodite_gem), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_meurodite, new ItemStack(MItems.meurodite_gem), 1.0F);
		GameRegistry
			.addShapelessRecipe(new ItemStack(MItems.meurodite_gem, 9), MBlocks.meurodite_block);

		GameRegistry.addSmelting(MBlocks.torite_ore, new ItemStack(MItems.torite_ingot), 1.2F);
		GameRegistry.addSmelting(MBlocks.biome_torite, new ItemStack(MItems.torite_ingot), 1.2F);
		GameRegistry.addSmelting(new ItemStack(MItems.chunks, 1, 9), new ItemStack(MItems.torite_ingot), 1.2F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.torite_ingot, 9), MBlocks.torite_block);

		GameRegistry.addSmelting(MBlocks.plutonium_ore, new ItemStack(MItems.plutonium), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_plutonium, new ItemStack(MItems.plutonium), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.plutonium, 9), MBlocks.plutonium_block);

		GameRegistry.addSmelting(MBlocks.uranium_ore, new ItemStack(MItems.uranium), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_uranium, new ItemStack(MItems.uranium), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.uranium, 9), MBlocks.uranium_block);

		GameRegistry.addSmelting(MBlocks.desert_quartz, new ItemStack(MItems.desert_quartz_item), 0.2F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.desert_quartz_block, 1), "QQ", "QQ", 'Q',
		                       MItems.desert_quartz_item);

		GameRegistry.addSmelting(MBlocks.radiant_ore, new ItemStack(MItems.radiant_quartz), 1.2F);
		GameRegistry.addSmelting(MBlocks.biome_radiant, new ItemStack(MItems.radiant_quartz), 1.2F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.radiant_block, 1), "QQ", "QQ", 'Q', MItems.radiant_quartz);

		GameRegistry
			.addShapelessRecipe(new ItemStack(MItems.titanium_ingot, 9), MBlocks.titanium_block);

		GameRegistry.addSmelting(MBlocks.blazium_ore, new ItemStack(MItems.blaze_shard), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.blazium_ingot, 9), MBlocks.blazium_block);

		GameRegistry.addSmelting(MBlocks.soul_ore, new ItemStack(MItems.soul_gem), 1.0F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.soul_gem, 9), MBlocks.soul_gem_block);

		GameRegistry
			.addShapelessRecipe(new ItemStack(MItems.glacierite_ingot, 9), MBlocks.glacierite_block);

		GameRegistry.addSmelting(MBlocks.biome_coal, new ItemStack(Items.coal, 1, 0), 0.1F);
		GameRegistry.addSmelting(MBlocks.biome_iron, new ItemStack(Items.iron_ingot), 0.7F);
		GameRegistry.addSmelting(new ItemStack(MItems.chunks, 1, 7), new ItemStack(Items.iron_ingot), 0.7F);
		GameRegistry.addSmelting(MBlocks.biome_gold, new ItemStack(Items.gold_ingot), 1.0F);
		GameRegistry.addSmelting(new ItemStack(MItems.chunks, 1, 8), new ItemStack(Items.gold_ingot), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_redstone, new ItemStack(Items.redstone), 0.7F);
		GameRegistry
			.addSmelting(MBlocks.biome_lapis, new ItemStack(Items.dye, 1, EnumDyeColor.BLUE.getDyeDamage()), 0.2F);
		GameRegistry.addSmelting(MBlocks.biome_diamond, new ItemStack(Items.diamond), 1.0F);
		GameRegistry.addSmelting(MBlocks.biome_emerald, new ItemStack(Items.emerald), 1.0F);

		// Decor
		GameRegistry.addRecipe(new ItemStack(MBlocks.mud, 1), "MM", "MM", 'M', MItems.mud_ball);
		GameRegistry.addRecipe(new ItemStack(MBlocks.mud, 8), "DDD", "DWD", "DDD", 'D', new ItemStack(Blocks.dirt, 1, 0),
		                       'W', Items.water_bucket.setContainerItem(Items.bucket));
		GameRegistry.addRecipe(new ItemStack(MBlocks.snow_bricks, 4), "SS", "SS", 'S', Blocks.snow);
		GameRegistry
			.addRecipe(new ItemStack(MBlocks.snow_refined, 9), "SSS", "SSS", "SSS", 'S', Blocks.snow);
		GameRegistry
			.addRecipe(new ItemStack(MBlocks.snow_tiles, 4), "SS", "SS", 'S', MBlocks.snow_refined);
		GameRegistry.addRecipe(new ItemStack(MBlocks.glacieric_ice, 3), "GPG", "PGP", "GPG", 'G', MItems.glacieric_ice_shard,
		                       'P', Blocks.packed_ice);

		GameRegistry.addRecipe(new ItemStack(MBlocks.glass_bricks, 4), "GG", "GG", 'G', Blocks.glass);
		GameRegistry.addSmelting(new ItemStack(Blocks.glass), new ItemStack(MBlocks.glass_refined), .1F);
		GameRegistry
			.addRecipe(new ItemStack(MBlocks.glass_tiles, 4), "GG", "GG", 'G', MBlocks.glass_refined);
		GameRegistry.addRecipe(new ItemStack(MBlocks.glass_window, 4), "IGI", "GIG", "IGI", 'I', Blocks.iron_bars, 'G',
		                       MBlocks.glass_refined);
		GameRegistry.addRecipe(new ItemStack(MBlocks.bricked_glass_pane, 16), "GGG", "GGG", 'G', MBlocks.glass_bricks);
		GameRegistry.addRecipe(new ItemStack(MBlocks.refined_glass_pane, 16), "GGG", "GGG", 'G', MBlocks.glass_refined);
		GameRegistry.addRecipe(new ItemStack(MBlocks.tiled_glass_pane, 16), "GGG", "GGG", 'G', MBlocks.glass_tiles);
		GameRegistry.addRecipe(new ItemStack(MBlocks.framed_glass_pane, 16), "GGG", "GGG", 'G', MBlocks.glass_window);
		GameRegistry.addRecipe(new ItemStack(MBlocks.glow_glass_pane, 16), "GGG", "GGG", 'G', MBlocks.glow_glass);

		GameRegistry.addRecipe(new ItemStack(MBlocks.flint_block, 1), "FF", "FF", 'F', Items.flint);
		GameRegistry
			.addRecipe(new ItemStack(MBlocks.sugar_block, 1), "SSS", "SSS", "SSS", 'S', Items.sugar);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.sugar, 9), MBlocks.sugar_block);

		GameRegistry.addRecipe(new ItemStack(MBlocks.rope, 1), "S", "S", "S", 'S', Items.string);
		GameRegistry.addRecipe(new ItemStack(MBlocks.cardboard, 2), "PPP", "PPP", 'P', Items.paper);
		GameRegistry
			.addRecipe(new ItemStack(MBlocks.cardboard_block, 1), "PP", "PP", 'P', MBlocks.cardboard);

		GameRegistry.addSmelting(new ItemStack(MBlocks.cold_sand, 1, 0), new ItemStack(Blocks.sand, 1, 0), 0.1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.cold_sand, 1, 1), new ItemStack(Blocks.sand, 1, 1), 0.1F);
		GameRegistry.addSmelting(new ItemStack(MBlocks.dirt_permafrost, 1, 0), new ItemStack(Blocks.dirt, 1, 0), 0.1F);

		MShapedRecipe.addRecipe(new ItemStack(MBlocks.pumpkin_carved_0, 1, 0), "SP ", " C ", 'S',
		                        Items.shears.setContainerItem(Items.shears), 'P', Blocks.pumpkin, 'C', MBlocks.candle);
		MShapedRecipe.addRecipe(new ItemStack(MBlocks.pumpkin_carved_1, 1, 0), "S  ", " P ", " C ", 'S',
		                        Items.shears.setContainerItem(Items.shears), 'P', Blocks.pumpkin, 'C', MBlocks.candle);
		MShapedRecipe.addRecipe(new ItemStack(MBlocks.pumpkin_carved_2, 1, 0), " S ", " P ", " C ", 'S',
		                        Items.shears.setContainerItem(Items.shears), 'P', Blocks.pumpkin, 'C', MBlocks.candle);
		MShapedRecipe.addRecipe(new ItemStack(MBlocks.pumpkin_carved_3, 1, 0), "  S", " P ", " C ", 'S',
		                        Items.shears.setContainerItem(Items.shears), 'P', Blocks.pumpkin, 'C', MBlocks.candle);
		MShapedRecipe.addRecipe(new ItemStack(MBlocks.pumpkin_carved_4, 1, 0), " PS", " C ", 'S',
		                        Items.shears.setContainerItem(Items.shears), 'P', Blocks.pumpkin, 'C', MBlocks.candle);

		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.hourglass_sand, 1), MBlocks.hourglass_empty,
		                                new ItemStack(Blocks.sand, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.hourglass_red_sand, 1), MBlocks.hourglass_empty,
		                                new ItemStack(Blocks.sand, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.hourglass_cold_sand, 1), MBlocks.hourglass_empty,
		                                new ItemStack(MBlocks.cold_sand, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.hourglass_cold_red_sand, 1), MBlocks.hourglass_empty,
		                                new ItemStack(MBlocks.cold_sand, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.hourglass_redstone, 1), MBlocks.hourglass_empty,
		                                Items.redstone);

		// Wood
		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.ministrapp_planks, 4, 0),
		                                new ItemStack(MBlocks.ministrapp_log, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.ministrapp_planks, 4, 1),
		                                new ItemStack(MBlocks.ministrapp_log, 1, 1));
		GameRegistry.addSmelting(new ItemStack(MBlocks.ministrapp_log), new ItemStack(Items.coal, 1, 1), 0.15F);

		//Stone
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 0), new ItemStack(MBlocks.biome_stones, 1, 0), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 1), new ItemStack(MBlocks.biome_stones, 1, 1), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 2), new ItemStack(MBlocks.biome_stones, 1, 2), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 3), new ItemStack(MBlocks.biome_stones, 1, 3), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 4), new ItemStack(MBlocks.biome_stones, 1, 4), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 5), new ItemStack(MBlocks.biome_stones, 1, 5), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 6), new ItemStack(MBlocks.biome_stones, 1, 6), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 7), new ItemStack(MBlocks.biome_stones, 1, 7), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_cobble, 1, 8), new ItemStack(MBlocks.biome_stones, 1, 8), .1F);

		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_bricks, 1, 0), new ItemStack(MBlocks.cracked_bricks, 1, 0), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_bricks, 1, 1), new ItemStack(MBlocks.cracked_bricks, 1, 1), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_bricks, 1, 2), new ItemStack(MBlocks.cracked_bricks, 1, 2), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_bricks, 1, 3), new ItemStack(MBlocks.cracked_bricks, 1, 3), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_bricks, 1, 4), new ItemStack(MBlocks.cracked_bricks, 1, 4), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_bricks, 1, 5), new ItemStack(MBlocks.cracked_bricks, 1, 5), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_bricks, 1, 6), new ItemStack(MBlocks.cracked_bricks, 1, 6), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_bricks, 1, 7), new ItemStack(MBlocks.cracked_bricks, 1, 7), .1F);
		GameRegistry
			.addSmelting(new ItemStack(MBlocks.biome_bricks, 1, 8), new ItemStack(MBlocks.cracked_bricks, 1, 8), .1F);

		GameRegistry.addRecipe(new ItemStack(Blocks.cobblestone, 1), "CC", "CC", 'C',
		                       new ItemStack(MItems.chunks, 1, 0));
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 1), "CC", "CC", 'C',
		                       new ItemStack(MItems.chunks, 1, 1));
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 3), "CC", "CC", 'C',
		                       new ItemStack(MItems.chunks, 1, 2));
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 5), "CC", "CC", 'C',
		                       new ItemStack(MItems.chunks, 1, 3));
		GameRegistry.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 7), "CC", "CC", 'C',
		                       new ItemStack(MItems.chunks, 1, 4));

		// Tech
		GameRegistry.addRecipe(new ItemStack(MBlocks.sorter, 2), "PB", " H", 'P', MBlocks.pipe, 'B', MItems.bronze_plating,
		                       'H', Blocks.hopper);
		GameRegistry.addRecipe(new ItemStack(MBlocks.alloy, 1), "TTT", "TFT", "BBB", 'T', new ItemStack(MItems.tin_plating),
		                       'F', new ItemStack(Blocks.furnace), 'B', new ItemStack(MBlocks.biome_bricks, 1, 1));
		GameRegistry.addRecipe(new ItemStack(MBlocks.melter, 1), "MMM", "MFM", "IBI", 'M', new ItemStack(MItems.meurodite_plating),
		                       'F', new ItemStack(Blocks.furnace), 'I', new ItemStack(Blocks.iron_bars), 'B',
		                       MBlocks.blazium_block);
		GameRegistry.addRecipe(new ItemStack(MBlocks.frost_generator, 1), "IPI", "QPQ", "GRG", 'I',
		                       new ItemStack(MBlocks.biome_cobble, 1, 5), 'G', new ItemStack(MBlocks.biome_stones, 1, 6),
		                       'P', new ItemStack(MBlocks.glacieric_ice), 'R', Blocks.redstone_block, 'Q',
		                       MItems.radiant_quartz);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.titanium_sifter, 1), MItems.empty_titanium_sifter,
		                                MBlocks.steel_mesh);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.upgradechip, 1, 0), MItems.inert_chip, MItems.ender_aura);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.upgradechip, 1, 1), MItems.inert_chip,
		                                Blocks.light_weighted_pressure_plate);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.upgradechip, 1, 2), MItems.inert_chip, Items.compass);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.upgradechip, 1, 3), MItems.inert_chip,
		                                MItems.advanced_tech_doodad);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.upgradechip, 1, 4), MItems.inert_chip, Blocks.dispenser);
		GameRegistry.addRecipe(new ItemStack(MBlocks.block_flesh, 8), "FFF", "FHF", "FFF", 'F', MItems.flesh, 'H',
		                       MItems.crystal_heart);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.cow_gene_sample, 1), MItems.cow_foot, MItems.slime_core,
		                                Items.sugar, Blocks.brown_mushroom);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.chicken_gene_sample, 1), MItems.chicken_foot, MItems.slime_core,
		                                Items.sugar, Blocks.brown_mushroom);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.sheep_gene_sample, 1), MItems.sheep_foot, MItems.slime_core,
		                                Items.sugar, Blocks.brown_mushroom);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.wolf_gene_sample, 1), MItems.wolf_hide, MItems.slime_core,
		                                Items.sugar, Blocks.brown_mushroom);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.rabbit_gene_sample, 1), Items.rabbit_foot, MItems.slime_core,
		                                Items.sugar, Blocks.brown_mushroom);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.bat_gene_sample, 1), MItems.wing_sinew, MItems.slime_core,
		                                Items.sugar, Blocks.brown_mushroom);

		// Tools and Weapons
		GameRegistry.addRecipe(new ItemStack(MItems.copper_pickaxe), "III", " S ", " S ", 'I', MItems.copper_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.copper_axe), "II", "IS", " S", 'I', MItems.copper_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.copper_shovel), "I", "S", "S", 'I', MItems.copper_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.copper_hoe), "II", " S", " S", 'I', MItems.copper_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.copper_sword), "I", "I", "S", 'I', MItems.copper_ingot, 'S',
		                       Items.stick);

		GameRegistry.addRecipe(new ItemStack(MItems.bronze_pickaxe), "III", " S ", " S ", 'I', MItems.bronze_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_axe), "II", "IS", " S", 'I', MItems.bronze_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_shovel), "I", "S", "S", 'I', MItems.bronze_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_hoe), "II", " S", " S", 'I', MItems.bronze_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_sword), "I", "I", "S", 'I', MItems.bronze_ingot, 'S',
		                       Items.stick);

		GameRegistry.addRecipe(new ItemStack(MItems.steel_pickaxe), "III", " S ", " S ", 'I', MItems.steel_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.steel_axe), "II", "IS", " S", 'I', MItems.steel_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.steel_shovel), "I", "S", "S", 'I', MItems.steel_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.steel_hoe), "II", " S", " S", 'I', MItems.steel_ingot, 'S',
		                       Items.stick);
		GameRegistry.addRecipe(new ItemStack(MItems.steel_sword), "I", "I", "S", 'I', MItems.steel_ingot, 'S',
		                       Items.stick);

		GameRegistry
			.addRecipe(new ItemStack(MItems.meurodite_pickaxe), "III", " S ", " S ", 'I', MItems.meurodite_gem, 'S',
			           MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_axe), "II", "IS", " S", 'I', MItems.meurodite_gem, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_shovel), "I", "S", "S", 'I', MItems.meurodite_gem, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_hoe), "II", " S", " S", 'I', MItems.meurodite_gem, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_sword), "I", "I", "S", 'I', MItems.meurodite_gem, 'S',
		                       MItems.reinforced_stick);

		GameRegistry.addRecipe(new ItemStack(MItems.torite_pickaxe), "III", " S ", " S ", 'I', MItems.torite_ingot, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.torite_axe), "II", "IS", " S", 'I', MItems.torite_ingot, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.torite_shovel), "I", "S", "S", 'I', MItems.torite_ingot, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.torite_hoe), "II", " S", " S", 'I', MItems.torite_ingot, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.torite_sword), "I", "I", "S", 'I', MItems.torite_ingot, 'S',
		                       MItems.reinforced_stick);

		GameRegistry
			.addRecipe(new ItemStack(MItems.ice_pickaxe), "III", " S ", " S ", 'I', MItems.glacierite_ingot, 'S',
			           MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.ice_axe), "II", "IS", " S", 'I', MItems.glacierite_ingot, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.ice_shovel), "I", "S", "S", 'I', MItems.glacierite_ingot, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.ice_hoe), "II", " S", " S", 'I', MItems.glacierite_ingot, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.ice_sword), "I", "I", "S", 'I', MItems.glacierite_ingot, 'S',
		                       MItems.reinforced_stick);

		GameRegistry.addRecipe(new ItemStack(MItems.fire_pickaxe), "III", " S ", " S ", 'I', MItems.blazium_ingot, 'S',
		                       Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(MItems.fire_axe), "II", "IS", " S", 'I', MItems.blazium_ingot, 'S',
		                       Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(MItems.fire_shovel), "I", "S", "S", 'I', MItems.blazium_ingot, 'S',
		                       Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(MItems.fire_hoe), "II", " S", " S", 'I', MItems.blazium_ingot, 'S',
		                       Items.blaze_rod);
		GameRegistry.addRecipe(new ItemStack(MItems.fire_sword), "I", "I", "S", 'I', MItems.blazium_ingot, 'S',
		                       Items.blaze_rod);

		GameRegistry
			.addRecipe(new ItemStack(MItems.titanium_pickaxe), "III", " S ", " S ", 'I', MItems.titanium_ingot, 'S',
			           MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_axe), "II", "IS", " S", 'I', MItems.titanium_ingot, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_shovel), "I", "S", "S", 'I', MItems.titanium_ingot, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_hoe), "II", " S", " S", 'I', MItems.titanium_ingot, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_sword), "I", "I", "S", 'I', MItems.titanium_ingot, 'S',
		                       MItems.reinforced_stick);

		GameRegistry.addRecipe(new ItemStack(MItems.bedrock_pickaxe), "III", " S ", " S ", 'I', Blocks.bedrock, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.bedrock_axe), "II", "IS", " S", 'I', Blocks.bedrock, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.bedrock_shovel), "I", "S", "S", 'I', Blocks.bedrock, 'S',
		                       MItems.reinforced_stick);
		GameRegistry.addRecipe(new ItemStack(MItems.bedrock_hoe), "II", " S", " S", 'I', Blocks.bedrock, 'S',
		                       MItems.reinforced_stick);

		GameRegistry.addRecipe(new ItemStack(MItems.tin_helmet), "III", "I I", 'I', MItems.tin_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.tin_chestplate), "I I", "III", "III", 'I', MItems.tin_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.tin_leggings), "III", "I I", "I I", 'I', MItems.tin_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.tin_boots), "I I", "I I", 'I', MItems.tin_ingot);

		GameRegistry.addRecipe(new ItemStack(MItems.bronze_helmet), "III", "I I", 'I', MItems.bronze_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_chestplate), "I I", "III", "III", 'I', MItems.bronze_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_leggings), "III", "I I", "I I", 'I', MItems.bronze_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.bronze_boots), "I I", "I I", 'I', MItems.bronze_ingot);

		GameRegistry.addRecipe(new ItemStack(MItems.steel_helmet), "III", "I I", 'I', MItems.steel_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.steel_chestplate), "I I", "III", "III", 'I', MItems.steel_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.steel_leggings), "III", "I I", "I I", 'I', MItems.steel_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.steel_boots), "I I", "I I", 'I', MItems.steel_ingot);

		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_helmet), "III", "I I", 'I', MItems.meurodite_gem);
		GameRegistry
			.addRecipe(new ItemStack(MItems.meurodite_chestplate), "I I", "III", "III", 'I', MItems.meurodite_gem);
		GameRegistry
			.addRecipe(new ItemStack(MItems.meurodite_leggings), "III", "I I", "I I", 'I', MItems.meurodite_gem);
		GameRegistry.addRecipe(new ItemStack(MItems.meurodite_boots), "I I", "I I", 'I', MItems.meurodite_gem);

		GameRegistry.addRecipe(new ItemStack(MItems.torite_helmet), "III", "I I", 'I', MItems.torite_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.torite_chestplate), "I I", "III", "III", 'I', MItems.torite_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.torite_leggings), "III", "I I", "I I", 'I', MItems.torite_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.torite_boots), "I I", "I I", 'I', MItems.torite_ingot);

		GameRegistry.addRecipe(new ItemStack(MItems.ice_helmet), "III", "I I", 'I', MItems.glacierite_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.ice_chestplate), "I I", "III", "III", 'I', MItems.glacierite_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.ice_leggings), "III", "I I", "I I", 'I', MItems.glacierite_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.ice_boots), "I I", "I I", 'I', MItems.glacierite_ingot);

		GameRegistry.addRecipe(new ItemStack(MItems.blazium_helmet), "III", "I I", 'I', MItems.blazium_ingot);
		GameRegistry
			.addRecipe(new ItemStack(MItems.blazium_chestplate), "I I", "III", "III", 'I', MItems.blazium_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.blazium_leggings), "III", "I I", "I I", 'I', MItems.blazium_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.blazium_boots), "I I", "I I", 'I', MItems.blazium_ingot);

		GameRegistry.addRecipe(new ItemStack(MItems.titanium_helmet), "III", "I I", 'I', MItems.titanium_ingot);
		GameRegistry
			.addRecipe(new ItemStack(MItems.titanium_chestplate), "I I", "III", "III", 'I', MItems.titanium_ingot);
		GameRegistry
			.addRecipe(new ItemStack(MItems.titanium_leggings), "III", "I I", "I I", 'I', MItems.titanium_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.titanium_boots), "I I", "I I", 'I', MItems.titanium_ingot);

		GameRegistry.addRecipe(new ItemStack(MItems.rad_helmet), "TST", "UGU", 'T', MItems.torite_ingot, 'S',
		                       MItems.steel_plating, 'U', MItems.uranium, 'G',
		                       new ItemStack(Blocks.stained_glass_pane, 1, 2));
		GameRegistry
			.addRecipe(new ItemStack(MItems.rad_chestplate), "S S", "URU", "TDT", 'S', MItems.steel_plating, 'U',
			           MItems.uranium, 'R', new ItemStack(Items.potionitem, 1, 8193), 'T', MItems.torite_ingot, 'D',
			           MItems.technological_doodad);
		GameRegistry
			.addRecipe(new ItemStack(MItems.rad_chestplate), "S S", "URU", "TDT", 'S', MItems.steel_plating, 'U',
			           MItems.uranium, 'R', new ItemStack(Items.potionitem, 1, 8257), 'T', MItems.torite_ingot, 'D',
			           MItems.technological_doodad);
		GameRegistry
			.addRecipe(new ItemStack(MItems.rad_chestplate), "S S", "URU", "TDT", 'S', MItems.steel_plating, 'U',
			           MItems.uranium, 'R', new ItemStack(Items.potionitem, 1, 8225), 'T', MItems.torite_ingot, 'D',
			           MItems.technological_doodad);
		GameRegistry.addRecipe(new ItemStack(MItems.rad_leggings), "SDS", "P P", "T T", 'S', MItems.steel_plating, 'D',
		                       MItems.technological_doodad, 'P', MItems.plutonium, 'T', MItems.torite_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.rad_boots), "S S", "P P", "T T", 'S', MItems.steel_plating, 'P',
		                       MItems.plutonium, 'T', MItems.torite_ingot);

		if (Config.genBiomeStones == false)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.biome_stones, 0), Blocks.cobblestone, Blocks.stone);
			GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.biome_stones, 1), Blocks.sand, Blocks.stone);
			GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.biome_stones, 2), Blocks.sandstone, Blocks.stone);
			GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.biome_stones, 3), Items.snowball, Blocks.stone);
			GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.biome_stones, 4), Blocks.snow, Blocks.stone);
			GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.biome_stones, 5), Blocks.ice, Blocks.stone);
			GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.biome_stones, 6), Blocks.packed_ice, Blocks.stone);
			GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.biome_stones, 7), Items.fish, Blocks.stone);
			GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.biome_stones, 8), MBlocks.seaweed, Blocks.stone);
		}

		//Vanilla
		GameRegistry.addRecipe(new ItemStack(Blocks.redstone_lamp, 1, 0), " R ", "RSR", " R ", 'R', Items.redstone, 'S',
		                       MBlocks.sunstone_block);
		GameRegistry.addRecipe(new ItemStack(MBlocks.ministrapp_flower_pot, 1, 0), "BDB", " B ", 'B', Items.brick, 'D',
		                       new ItemStack(Blocks.dirt, 1, 0));
	}

	public static void removeRecipes()
	{
		if (Config.removeRecipes)
		{
			RecipeHelper.removeRecipeContaining(Items.bread);
			RecipeHelper.removeRecipeContaining(Items.pumpkin_pie);
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
			RecipeHelper.removeRecipeContaining(Items.oak_door);
			RecipeHelper.removeRecipeContaining(Items.birch_door);
			RecipeHelper.removeRecipeContaining(Items.spruce_door);
			RecipeHelper.removeRecipeContaining(Items.jungle_door);
			RecipeHelper.removeRecipeContaining(Items.acacia_door);
			RecipeHelper.removeRecipeContaining(Items.dark_oak_door);
			RecipeHelper.removeRecipeContaining(Items.bed);
			RecipeHelper.removeRecipeContaining(Items.sign);
			RecipeHelper.removeRecipeContaining(Items.item_frame);
			RecipeHelper.removeRecipeContaining(Items.painting);
			RecipeHelper.removeRecipeContaining(Items.armor_stand);
			RecipeHelper.removeRecipeContaining(Blocks.anvil);
			RecipeHelper.removeRecipeContaining(Blocks.chest);
			RecipeHelper.removeRecipeContaining(Blocks.jukebox);
			RecipeHelper.removeRecipeContaining(Blocks.noteblock);
			RecipeHelper.removeRecipeContaining(Blocks.trapdoor);
			RecipeHelper.removeRecipeContaining(Blocks.nether_brick);
			RecipeHelper.removeRecipeContaining(Blocks.nether_brick_fence);
			RecipeHelper.removeRecipeContaining(Blocks.quartz_block);
			RecipeHelper.removeRecipeContaining(Items.ender_eye);
			RecipeHelper.removeRecipeContaining(Items.flower_pot);
			RecipeHelper.removeRecipeContaining(Blocks.lit_pumpkin);
			RecipeHelper.removeRecipeContaining(Blocks.hopper);
			RecipeHelper.removeRecipeContaining(Items.boat);
		}
	}
}
