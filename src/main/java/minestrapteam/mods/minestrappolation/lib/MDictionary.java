package minestrapteam.mods.minestrappolation.lib;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class MDictionary
{
	
	public static final int	WILDCARD_VALUE	= Short.MAX_VALUE;
	
	public static void load()
	{
		OreDictionary.registerOre("ingotCopper", MItems.copper_ingot);
		OreDictionary.registerOre("ingotTin", MItems.tin_ingot);
		OreDictionary.registerOre("ingotBronze", MItems.bronze_ingot);
		OreDictionary.registerOre("ingotSteel", MItems.steel_ingot);
		OreDictionary.registerOre("gemMeurodite", MItems.meurodite_gem);
		OreDictionary.registerOre("ingotTorite", MItems.torite_ingot);
		OreDictionary.registerOre("dustBlazium", MItems.blaze_shard);
		OreDictionary.registerOre("ingotBlazium", MItems.blazium_ingot);
		OreDictionary.registerOre("ingotTitanium", MItems.titanium_ingot);
		OreDictionary.registerOre("dustSunstone", MItems.sunstone_shard);
		OreDictionary.registerOre("ingotPlutonium", MItems.plutonium);
		OreDictionary.registerOre("ingotUranium", MItems.uranium);
		OreDictionary.registerOre("gemDesertQuartz", MItems.desert_quartz_item);
		OreDictionary.registerOre("gemRadiantQuartz", MItems.radiant_quartz);
		OreDictionary.registerOre("gemQuartzAny", Items.quartz);
		OreDictionary.registerOre("gemQuartzAny", MItems.desert_quartz_item);
		OreDictionary.registerOre("gemQuartzAny", MItems.radiant_quartz);
		OreDictionary.registerOre("gemSoul", MItems.soul_gem);
		
		OreDictionary.registerOre("blockCopper", MBlocks.copper_block);
		OreDictionary.registerOre("blockTin", MBlocks.tin_block);
		OreDictionary.registerOre("blockBronze", MBlocks.bronze_block);
		OreDictionary.registerOre("blockSteel", MBlocks.steel_block);
		OreDictionary.registerOre("blockMeurodite", MBlocks.meurodite_block);
		OreDictionary.registerOre("blockTorite", MBlocks.torite_block);
		OreDictionary.registerOre("blockBlazium", MBlocks.blazium_block);
		OreDictionary.registerOre("blockTitanium", MBlocks.titanium_block);
		OreDictionary.registerOre("sunstone", MBlocks.sunstone_block);
		OreDictionary.registerOre("blockPlutonium", MBlocks.plutonium_block);
		OreDictionary.registerOre("blockUranium", MBlocks.uranium_block);
		OreDictionary.registerOre("blockSoulGem", MBlocks.soul_gem_block);
		
		OreDictionary.registerOre("ingotBrickStone", new ItemStack(MItems.bricks, 0));
		OreDictionary.registerOre("ingotBrickStone", new ItemStack(MItems.bricks, 1));
		OreDictionary.registerOre("ingotBrickStone", new ItemStack(MItems.bricks, 2));
		OreDictionary.registerOre("ingotBrickStone", new ItemStack(MItems.bricks, 3));
		OreDictionary.registerOre("ingotBrickStone", new ItemStack(MItems.bricks, 4));
		OreDictionary.registerOre("ingotBrickStone", new ItemStack(MItems.bricks, 5));
		OreDictionary.registerOre("ingotBrickStone", new ItemStack(MItems.bricks, 6));
		OreDictionary.registerOre("ingotBrickStone", new ItemStack(MItems.bricks, 7));
		OreDictionary.registerOre("ingotBrickStone", new ItemStack(MItems.bricks, 8));
		OreDictionary.registerOre("ingotBrickStone", new ItemStack(MItems.bricks, 9));
		
		OreDictionary.registerOre("logWood", new ItemStack(MBlocks.ministrapp_log, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("plankWood", new ItemStack(MBlocks.ministrapp_planks, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.redwood_slab, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("slabWood", new ItemStack(MBlocks.frozen_oak_slab, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("stairWood", new ItemStack(MBlocks.redwood_stairs, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("stairWood", new ItemStack(MBlocks.frozen_oak_stairs, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("treeSapling", new ItemStack(MBlocks.ministrapp_sapling, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("treeLeaves", new ItemStack(MBlocks.ministrapp_leaves, 1, WILDCARD_VALUE));
		
		OreDictionary.registerOre("stone", new ItemStack(MBlocks.biome_stones, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestone", new ItemStack(MBlocks.biome_cobble, 1, WILDCARD_VALUE));
		
		OreDictionary.registerOre("slabSmoothStone", new ItemStack(Blocks.stone_slab, 1, 0));
		OreDictionary.registerOre("slabSmoothStone", new ItemStack(MBlocks.deepstone_slab, 1, 0));
		OreDictionary.registerOre("slabSmoothStone", new ItemStack(MBlocks.red_rock_slab, 1, 0));
		OreDictionary.registerOre("slabSmoothStone", new ItemStack(MBlocks.deep_red_rock_slab, 1, 0));
		OreDictionary.registerOre("slabSmoothStone", new ItemStack(MBlocks.coldstone_slab, 1, 0));
		OreDictionary.registerOre("slabSmoothStone", new ItemStack(MBlocks.deep_coldstone_slab, 1, 0));
		OreDictionary.registerOre("slabSmoothStone", new ItemStack(MBlocks.icestone_slab, 1, 0));
		OreDictionary.registerOre("slabSmoothStone", new ItemStack(MBlocks.glacierrock_slab, 1, 0));
		OreDictionary.registerOre("slabSmoothStone", new ItemStack(MBlocks.oceanstone_slab, 1, 0));
		OreDictionary.registerOre("slabSmoothStone", new ItemStack(MBlocks.poceanstone_slab, 1, 0));
		
		OreDictionary.registerOre("oreGold", new ItemStack(MBlocks.biome_gold, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreIron", new ItemStack(MBlocks.biome_iron, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreLapis", new ItemStack(MBlocks.biome_lapis, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreDiamond", new ItemStack(MBlocks.biome_diamond, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreRedstone", new ItemStack(MBlocks.biome_redstone, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreEmerald", new ItemStack(MBlocks.biome_emerald, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreCoal", new ItemStack(MBlocks.biome_coal, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreCopper", new ItemStack(MBlocks.biome_copper, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreTin", new ItemStack(MBlocks.biome_tin, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("orePlutonium", new ItemStack(MBlocks.biome_plutonium, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreUranium", new ItemStack(MBlocks.biome_uranium, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreRadiantQuartz", new ItemStack(MBlocks.biome_radiant, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreTitanium", new ItemStack(MBlocks.biome_titanium, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreMeurodite", new ItemStack(MBlocks.biome_meurodite, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("oreTorite", new ItemStack(MBlocks.biome_torite, 1, WILDCARD_VALUE));
		
		OreDictionary.registerOre("oreCopper", new ItemStack(MBlocks.copper_ore));
		OreDictionary.registerOre("oreTin", new ItemStack(MBlocks.tin_ore));
		OreDictionary.registerOre("orePlutonium", new ItemStack(MBlocks.plutonium_ore));
		OreDictionary.registerOre("oreUranium", new ItemStack(MBlocks.uranium_ore));
		OreDictionary.registerOre("oreRadiantQuartz", new ItemStack(MBlocks.radiant_ore));
		OreDictionary.registerOre("oreTitanium", new ItemStack(MBlocks.titanium_ore));
		OreDictionary.registerOre("oreMeurodite", new ItemStack(MBlocks.meurodite_ore));
		OreDictionary.registerOre("oreTorite", new ItemStack(MBlocks.torite_ore));
		OreDictionary.registerOre("oreDesertQuartz", new ItemStack(MBlocks.desert_quartz));
		OreDictionary.registerOre("oreBlazium", new ItemStack(MBlocks.blazium_ore));
		OreDictionary.registerOre("oreSoul", new ItemStack(MBlocks.soul_ore));
		
		OreDictionary.registerOre("blockGlassColorless", new ItemStack(MBlocks.glass_bricks));
		OreDictionary.registerOre("blockGlassColorless", new ItemStack(MBlocks.glass_refined));
		OreDictionary.registerOre("blockGlassColorless", new ItemStack(MBlocks.glass_tiles));
		OreDictionary.registerOre("blockGlass", new ItemStack(MBlocks.glass_bricks));
		OreDictionary.registerOre("blockGlass", new ItemStack(MBlocks.glass_refined));
		OreDictionary.registerOre("blockGlass", new ItemStack(MBlocks.glass_tiles));
		OreDictionary.registerOre("blockGlass", new ItemStack(MBlocks.glass_window));
		OreDictionary.registerOre("paneGlassColorless", new ItemStack(MBlocks.bricked_glass_pane));
		OreDictionary.registerOre("paneGlassColorless", new ItemStack(MBlocks.refined_glass_pane));
		OreDictionary.registerOre("paneGlassColorless", new ItemStack(MBlocks.tiled_glass_pane));
		OreDictionary.registerOre("paneGlass", new ItemStack(MBlocks.bricked_glass_pane));
		OreDictionary.registerOre("paneGlass", new ItemStack(MBlocks.refined_glass_pane));
		OreDictionary.registerOre("paneGlass", new ItemStack(MBlocks.tiled_glass_pane));
		OreDictionary.registerOre("paneGlass", new ItemStack(MBlocks.framed_glass_pane));
		
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.fish, 1, 0));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.fish, 1, 1));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.fish, 1, 2));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.fish, 1, 3));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.beef));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.chicken));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.mutton));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.porkchop));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.rabbit));
		OreDictionary.registerOre("meatRaw", new ItemStack(Items.rotten_flesh));
		
		//Minerals
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.copper_block), new Object[] { "III", "III", "III", 'I', "ingotCopper" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.tin_block), new Object[] { "III", "III", "III", 'I', "ingotTin" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.bronze_block), new Object[] { "III", "III", "III", 'I', "ingotBronze" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.steel_block), new Object[] { "III", "III", "III", 'I', "ingotSteel" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.meurodite_block), new Object[] { "III", "III", "III", 'I', "gemMeurodite" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.torite_block), new Object[] { "III", "III", "III", 'I', "ingotTorite" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.plutonium_block), new Object[] { "III", "III", "III", 'I', "ingotPlutonium" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.uranium_block), new Object[] { "III", "III", "III", 'I', "ingotUranium" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.titanium_block), new Object[] { "III", "III", "III", 'I', "ingotTitanium" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.blazium_block), new Object[] { "III", "III", "III", 'I', "ingotBlazium" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.soul_gem_block), new Object[] { "III", "III", "III", 'I', "gemSoul" }));
		
		//Tech
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.crate, 1), new Object[] { "WWW", "SSS", "WWW", 'W', "plankWood", 'S', "stickWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.sawmill, 1), new Object[] { "CC", "WW", "WW", 'C', "ingotCopper", 'W', "plankWood" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.stonecutter, 1), new Object[] { "II", "CC", "CC", 'I', "ingotIron", 'C', "cobblestone" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.crusher, 1), new Object[] { "BPB", "BTB", "OOO", 'B', "blockBronze", 'P', Blocks.piston, 'T', "ingotTitanium", 'O', MBlocks.obsidian_bricks }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.plutonium_insulated), new Object[] { "SSS", "GBG", "SSS", 'S', "ingotSteel", 'G', MBlocks.framed_glass_pane, 'B', "blockPlutonium" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.uranium_insulated), new Object[] { "SSS", "GBG", "SSS", 'S', "ingotSteel", 'G', MBlocks.framed_glass_pane, 'B', "blockUranium" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MItems.sifter, 1), new Object[] { " C ", "CMC", " S ", 'C', "ingotCopper", 'M', MBlocks.steel_mesh, 'S', MItems.reinforced_stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.splitter, 1), new Object[] { "RTR", "GSG", "RTR", 'R', MBlocks.radiant_chiseled, 'T', "ingotTorite", 'S', MBlocks.sunstone_block, 'G', MItems.soul_gem}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.claimerator, 1), new Object[] { "DOD", "PGU", "DOD", 'D', Items.diamond, 'O', Blocks.obsidian, 'P', "ingotPlutonium", 'U', "ingotUranium", 'G', MBlocks.godstone }));
		
		//Materials
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MItems.reinforced_stick, 8), new Object[] { "SSS", "STS", "SSS", 'S', "stickWood", 'T', new ItemStack(MItems.tin_plating) }));
		
		//Decor
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.meat_block, 1), new Object[] { "MMM", "MMM", "MMM", 'M', "meatRaw" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.glass_door_item, 3), new Object[] { "II", "GG", "II", 'I', Blocks.iron_bars, 'G', "paneGlassColorless"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MBlocks.steel_mesh, 16), new Object[] { "SSS", "SSS", 'S', "ingotSteel" }));
		
		//Food
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MItems.rice_bowl, 1), new Object[] { "stickWood", MBlocks.rice, Items.bowl, new ItemStack(Items.potionitem, 1, 0)}));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(MItems.bread_rice_bowl, 1), new Object[] { "stickWood", MBlocks.rice, MItems.bread_bowl, new ItemStack(Items.potionitem, 1, 0)}));
		
		//Vanilla
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.flint_and_steel), new Object[] { "S ", " F", 'S', "ingotSteel", 'F', new ItemStack(Items.flint) }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.daylight_detector), new Object[] { "GGG", "QQQ", "WWW", 'G', "blockGlassColorless", 'Q', "gemQuartzAny", 'W', "slabWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.anvil, 1, 0), new Object[] { "III", " S ", "SSS", 'I', "blockIron", 'S', "ingotSteel" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.diamond_pickaxe), new Object[] { "III", " S ", " S ", 'I', Items.diamond, 'S', MItems.reinforced_stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.diamond_axe), new Object[] { "II", "IS", " S", 'I', Items.diamond, 'S', MItems.reinforced_stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.diamond_shovel), new Object[] { "I", "S", "S", 'I', Items.diamond, 'S', MItems.reinforced_stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.diamond_hoe), new Object[] { "II", " S", " S", 'I', Items.diamond, 'S', MItems.reinforced_stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.diamond_sword), new Object[] { "I", "I", "S", 'I', Items.diamond, 'S', MItems.reinforced_stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.quartz_block, 1, 0), new Object[] { "QQ", "QQ", 'Q', Items.quartz}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.sandstone, 1, 0), new Object[] { "SS", "SS", 'S', new ItemStack(Blocks.sand, 1, 0)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.red_sandstone, 1, 0), new Object[] { "SS", "SS", 'S', new ItemStack(Blocks.sand, 1, 1)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.prismarine, 1, 0), new Object[] { "PP", "PP", 'P', Items.prismarine_shard}));
		
		//TODO: Replace Leather and Feathers with Wing Segments.
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(MItems.hangglider, 1), new Object[] { "PRP", "WPW", " S ", 'P', "plankWood", 'R', MBlocks.rope, 'W', MItems.wing_segment, 'S', MItems.reinforced_stick }));
	}
	
}
