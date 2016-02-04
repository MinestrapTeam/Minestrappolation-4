package minestrapteam.mods.minestrappolation.crafting.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.google.common.collect.Maps;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;

public class SplitterRecipes
{
	private static final SplitterRecipes	splitBase		= new SplitterRecipes();
	private Map							splitList		= Maps.newHashMap();
	private Map							splitList2		= Maps.newHashMap();
	private Map							experienceList	= Maps.newHashMap();
	
	public static SplitterRecipes instance()
	{
		return splitBase;
	}
	
	private SplitterRecipes()
	{
		//Vanilla Mineral Blocks
		this.addRecipe(new ItemStack(Blocks.snow, 1, 0), new ItemStack(Items.snowball, 2), new ItemStack(Items.snowball, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.clay, 1, 0), new ItemStack(Items.clay_ball, 2), new ItemStack(Items.clay_ball, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.hay_block, 1), new ItemStack(Items.wheat, 5), new ItemStack(Items.wheat, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.melon_block, 1, 0), new ItemStack(Items.melon, 5), new ItemStack(Items.melon, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.coal_block, 1, 0), new ItemStack(Items.coal, 5), new ItemStack(Items.coal, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.iron_block, 1, 0), new ItemStack(Items.iron_ingot, 5), new ItemStack(Items.iron_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.gold_block, 1, 0), new ItemStack(Items.gold_ingot, 5), new ItemStack(Items.gold_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.lapis_block, 1, 0), new ItemStack(Items.dye, 5, 4), new ItemStack(Items.dye, 4, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.redstone_block, 1), new ItemStack(Items.redstone, 5), new ItemStack(Items.redstone, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.diamond_block, 1, 0), new ItemStack(Items.diamond, 5), new ItemStack(Items.diamond, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.emerald_block, 1, 0), new ItemStack(Items.emerald, 5), new ItemStack(Items.emerald, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.prismarine, 1, 0), new ItemStack(Items.prismarine_shard, 2), new ItemStack(Items.prismarine_shard, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.quartz_block, 1, 0), new ItemStack(Items.quartz, 2), new ItemStack(Items.quartz, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.glowstone, 1, 0), new ItemStack(Items.glowstone_dust, 2), new ItemStack(Items.glowstone_dust, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.slime_block, 1, 0), new ItemStack(Items.slime_ball, 5), new ItemStack(Items.slime_ball, 4), 0.1F);
		
		//Vanilla Decor Blocks
		this.addRecipe(new ItemStack(Blocks.bookshelf, 1, 0), new ItemStack(Items.book, 3), new ItemStack(Blocks.planks, 6), 0.1F);
		this.addRecipe(new ItemStack(Blocks.lit_pumpkin, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.purple_glowshroom, 8), 0.1F);
		this.addRecipe(new ItemStack(Blocks.sandstone, 1, 0), new ItemStack(Blocks.sand, 2, 0), new ItemStack(Blocks.sand, 2, 0), 0.1F);
		this.addRecipe(new ItemStack(Blocks.red_sandstone, 1, 0), new ItemStack(Blocks.sand, 2, 1), new ItemStack(Blocks.sand, 2, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.sea_lantern, 1, 0), new ItemStack(Items.prismarine_shard, 5), new ItemStack(Items.prismarine_crystals, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.ladder, 1), new ItemStack(Items.stick, 1), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.oak_fence, 1), new ItemStack(Blocks.planks, 1, 0), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.spruce_fence, 1), new ItemStack(Blocks.planks, 1, 1), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.birch_fence, 1), new ItemStack(Blocks.planks, 1, 2), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.jungle_fence, 1), new ItemStack(Blocks.planks, 1, 3), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.acacia_fence, 1), new ItemStack(Blocks.planks, 1, 4), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.dark_oak_fence, 1), new ItemStack(Blocks.planks, 1, 5), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.oak_fence_gate, 1), new ItemStack(Blocks.planks, 2, 0), new ItemStack(Items.stick, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.spruce_fence_gate, 1), new ItemStack(Blocks.planks, 2, 1), new ItemStack(Items.stick, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.birch_fence_gate, 1), new ItemStack(Blocks.planks, 2, 2), new ItemStack(Items.stick, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.jungle_fence_gate, 1), new ItemStack(Blocks.planks, 2, 3), new ItemStack(Items.stick, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.acacia_fence_gate, 1), new ItemStack(Blocks.planks, 2, 4), new ItemStack(Items.stick, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.dark_oak_fence_gate, 1), new ItemStack(Blocks.planks, 2, 5), new ItemStack(Items.stick, 4), 0.1F);
		this.addRecipe(new ItemStack(Items.painting, 1), new ItemStack(Blocks.wool, 1), new ItemStack(Items.stick, 8), 0.1F);
		this.addRecipe(new ItemStack(Items.item_frame, 1), new ItemStack(Items.leather, 1), new ItemStack(Items.stick, 8), 0.1F);
		this.addRecipe(new ItemStack(Items.sign, 1), new ItemStack(Blocks.planks, 1), new ItemStack(Blocks.planks, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.bed, 1), new ItemStack(Blocks.planks, 3), new ItemStack(Blocks.wool, 3), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.ministrapp_flower_pot, 1), new ItemStack(Items.brick, 3), new ItemStack(Blocks.dirt, 1, 0), 0.1F);
		this.addRecipe(new ItemStack(Items.banner, 1), new ItemStack(Blocks.wool, 1), new ItemStack(Blocks.wool, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.armor_stand, 1), new ItemStack(Blocks.stone_slab, 1), new ItemStack(Items.stick, 6), 0.1F);
		this.addRecipe(new ItemStack(Items.oak_door, 1), new ItemStack(Blocks.planks, 1, 0), new ItemStack(Blocks.planks, 1, 0), 0.1F);
		this.addRecipe(new ItemStack(Items.spruce_door, 1), new ItemStack(Blocks.planks, 1, 1), new ItemStack(Blocks.planks, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.birch_door, 1), new ItemStack(Blocks.planks, 1, 2), new ItemStack(Blocks.planks, 1, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.jungle_door, 1), new ItemStack(Blocks.planks, 1, 3), new ItemStack(Blocks.planks, 1, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.acacia_door, 1), new ItemStack(Blocks.planks, 1, 4), new ItemStack(Blocks.planks, 1, 4), 0.1F);
		this.addRecipe(new ItemStack(Items.dark_oak_door, 1), new ItemStack(Blocks.planks, 1, 5), new ItemStack(Blocks.planks, 1, 5), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_door, 1), new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.iron_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.trapdoor, 1), new ItemStack(Blocks.planks, 2), new ItemStack(Blocks.planks, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.iron_trapdoor, 1), new ItemStack(Items.iron_ingot, 2), new ItemStack(Items.iron_ingot, 2), 0.1F);
		
		//Vanilla Tech Blocks
		this.addRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), new ItemStack(Blocks.planks, 1), new ItemStack(Blocks.planks, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stone_pressure_plate, 1), new ItemStack(Blocks.stone, 1), new ItemStack(Blocks.stone, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.heavy_weighted_pressure_plate, 1), new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.iron_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.light_weighted_pressure_plate, 1), new ItemStack(Items.gold_ingot, 1), new ItemStack(Items.gold_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.lever, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.crafting_table, 1), new ItemStack(Blocks.planks, 2), new ItemStack(Blocks.planks, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.furnace, 1), new ItemStack(Blocks.cobblestone, 4), new ItemStack(Blocks.cobblestone, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.chest, 1), new ItemStack(Blocks.planks, 4), new ItemStack(Blocks.planks, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.trapped_chest, 1), new ItemStack(Blocks.chest, 1), new ItemStack(Blocks.tripwire_hook, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.ender_chest, 1), new ItemStack(Blocks.obsidian, 8), new ItemStack(Items.ender_eye, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.noteblock, 1), new ItemStack(Blocks.planks, 8), new ItemStack(Items.redstone, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.jukebox, 1), new ItemStack(Blocks.planks, 8), new ItemStack(Items.diamond, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new ItemStack(Blocks.obsidian, 4), new ItemStack(Items.diamond, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.hopper, 1), new ItemStack(Blocks.chest, 1), new ItemStack(Items.iron_ingot, 5), 0.1F);
		this.addRecipe(new ItemStack(Blocks.tnt, 1), new ItemStack(Items.gunpowder, 5), new ItemStack(Blocks.sand, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.daylight_detector, 1), new ItemStack(Blocks.glass, 3), new ItemStack(MItems.desert_quartz_item, 3), 0.1F);
		this.addRecipe(new ItemStack(Blocks.redstone_torch, 1), new ItemStack(Items.redstone, 1), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.repeater, 1), new ItemStack(Blocks.stone, 3), new ItemStack(Blocks.redstone_torch, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.dropper, 1), new ItemStack(Blocks.cobblestone, 7), new ItemStack(Items.redstone, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.dispenser, 1), new ItemStack(Blocks.cobblestone, 7), new ItemStack(Items.bow, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.comparator, 1), new ItemStack(Blocks.stone, 3), new ItemStack(Blocks.redstone_torch, 3), 0.1F);
		this.addRecipe(new ItemStack(Blocks.piston, 1), new ItemStack(Blocks.cobblestone, 4), new ItemStack(Items.iron_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.sticky_piston, 1), new ItemStack(Blocks.piston, 1), new ItemStack(Items.slime_ball, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.redstone_lamp, 1), new ItemStack(Blocks.glowstone, 1), new ItemStack(Items.redstone, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.activator_rail, 1), new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.golden_rail, 1), new ItemStack(Items.gold_ingot, 1), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.detector_rail, 1), new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.brewing_stand, 1), new ItemStack(Items.blaze_rod, 1), new ItemStack(Blocks.cobblestone, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.cauldron, 1), new ItemStack(Items.iron_ingot, 4), new ItemStack(Items.iron_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(Blocks.beacon, 1), new ItemStack(Items.nether_star, 1), new ItemStack(Blocks.obsidian, 3), 0.1F);
		this.addRecipe(new ItemStack(Blocks.anvil, 1, 0), new ItemStack(Blocks.iron_block, 3), new ItemStack(MItems.steel_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.anvil, 1, 1), new ItemStack(Blocks.iron_block, 2), new ItemStack(MItems.steel_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(Blocks.anvil, 1, 2), new ItemStack(Blocks.iron_block, 1), new ItemStack(MItems.steel_ingot, 1), 0.1F);
		
		//Vanilla Dyed Blocks
		this.addRecipe(new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.string, 2, 0), new ItemStack(Items.string, 2, 0), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 1), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 14), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 2), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 13), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 3), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 12), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 4), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 11), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 5), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 10), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 6), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 9), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 7), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 8), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 8), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 7), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 9), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 6), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 10), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 5), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 11), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 12), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 3), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 13), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 14), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.wool, 1, 15), new ItemStack(Blocks.wool, 1, 0), new ItemStack(Items.dye, 1, 0), 0.1F);
		
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 0), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 15), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 1), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 14), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 2), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 13), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 3), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 12), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 4), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 11), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 5), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 10), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 6), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 9), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 7), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 8), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 8), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 7), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 9), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 6), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 10), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 5), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 11), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 12), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 3), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 13), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 14), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_glass, 1, 15), new ItemStack(Blocks.glass, 8, 0), new ItemStack(Items.dye, 1, 0), 0.1F);
		
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 0), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 15), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 1), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 14), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 2), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 13), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 3), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 12), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 4), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 11), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 5), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 10), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 6), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 9), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 7), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 8), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 8), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 7), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 9), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 6), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 10), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 5), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 11), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 4), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 12), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 3), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 13), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 14), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 15), new ItemStack(Blocks.hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 0), 0.1F);
		
		//Vanilla Foods
		this.addRecipe(new ItemStack(Items.mushroom_stew, 1), new ItemStack(Blocks.red_mushroom, 1), new ItemStack(Blocks.brown_mushroom, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.rabbit_stew, 1), new ItemStack(Items.cooked_rabbit, 1), new ItemStack(Items.baked_potato, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_apple, 1, 0), new ItemStack(Items.apple, 1), new ItemStack(Items.gold_ingot, 8), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_apple, 1, 1), new ItemStack(Items.apple, 1), new ItemStack(Blocks.gold_block, 8), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_carrot, 1), new ItemStack(Items.carrot, 1), new ItemStack(Items.gold_nugget, 8), 0.1F);
		this.addRecipe(new ItemStack(Items.speckled_melon, 1), new ItemStack(Items.melon, 1), new ItemStack(Items.gold_nugget, 8), 0.1F);
		this.addRecipe(new ItemStack(Items.cake, 1), new ItemStack(Items.wheat, 3), new ItemStack(Items.sugar, 2), 0.1F);
		
		//Vanilla Misc Items
		this.addRecipe(new ItemStack(Items.fermented_spider_eye, 1), new ItemStack(Items.spider_eye, 1), new ItemStack(Items.sugar, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.magma_cream, 1), new ItemStack(Items.slime_ball, 1), new ItemStack(Items.blaze_powder, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.gold_ingot, 1), new ItemStack(Items.gold_nugget, 5), new ItemStack(Items.gold_nugget, 4), 0.1F);
		this.addRecipe(new ItemStack(Items.leather, 1), new ItemStack(Items.rabbit_hide, 2), new ItemStack(Items.rabbit_hide, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.book, 1), new ItemStack(Items.paper, 3), new ItemStack(Items.leather, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.writable_book, 1), new ItemStack(Items.book, 1), new ItemStack(Items.dye, 1, 0), 0.1F);
		this.addRecipe(new ItemStack(Items.written_book, 1), new ItemStack(Items.book, 1), new ItemStack(Items.dye, 1, 0), 0.1F);
		this.addRecipe(new ItemStack(Items.map, 1), new ItemStack(Items.paper, 8), new ItemStack(Items.compass, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.filled_map, 1), new ItemStack(Items.paper, 1), new ItemStack(Items.compass, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.fireworks, 1), new ItemStack(Items.gunpowder, 1), new ItemStack(Items.paper, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.ender_eye, 1), new ItemStack(Items.ender_pearl, 1), new ItemStack(Items.blaze_powder, 1), 0.1F);
		
		//Vanilla Utility Items
		this.addRecipe(new ItemStack(Items.bowl, 1), new ItemStack(Blocks.planks, 1), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.bucket, 1), new ItemStack(Items.iron_ingot, 2), new ItemStack(Items.iron_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.compass, 1), new ItemStack(Items.iron_ingot, 4), new ItemStack(Items.redstone, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.clock, 1), new ItemStack(Items.gold_ingot, 4), new ItemStack(Items.redstone, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.boat, 1), new ItemStack(Blocks.planks, 3), new ItemStack(Blocks.planks, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.minecart, 1), new ItemStack(Items.iron_ingot, 3), new ItemStack(Items.iron_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.chest_minecart, 1), new ItemStack(Items.minecart, 1), new ItemStack(Blocks.chest, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.furnace_minecart, 1), new ItemStack(Items.minecart, 1), new ItemStack(Blocks.furnace, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.tnt_minecart, 1), new ItemStack(Items.minecart, 1), new ItemStack(Blocks.tnt, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.hopper_minecart, 1), new ItemStack(Items.minecart, 1), new ItemStack(Blocks.hopper, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_horse_armor, 1), new ItemStack(Items.iron_ingot, 6), new ItemStack(Blocks.wool, 1, 15), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_horse_armor, 1), new ItemStack(Items.gold_ingot, 6), new ItemStack(Blocks.wool, 1, 14), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_horse_armor, 1), new ItemStack(Items.diamond, 6), new ItemStack(Blocks.wool, 1, 4), 0.1F);
		this.addRecipe(new ItemStack(Items.saddle, 1), new ItemStack(Items.leather, 5), new ItemStack(Items.iron_ingot, 1, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.experience_bottle, 1), new ItemStack(MItems.soul_gem, 1), new ItemStack(Items.glass_bottle, 1), 0.1F);
		
		//Vanilla Tools
		this.addRecipe(new ItemStack(Items.carrot_on_a_stick, 1, 0), new ItemStack(Items.fishing_rod, 1), new ItemStack(Items.carrot, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.fishing_rod, 1, 0), new ItemStack(Items.string, 2), new ItemStack(Items.stick, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.flint_and_steel, 1, 0), new ItemStack(MItems.steel_ingot, 1), new ItemStack(Items.flint, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.lead, 1), new ItemStack(Items.string, 1), new ItemStack(Items.string, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.shears, 1, 0), new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.iron_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.bow, 1, 0), new ItemStack(Items.string, 3), new ItemStack(Items.stick, 3), 0.1F);
		
		this.addRecipe(new ItemStack(Items.wooden_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.planks, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.stone_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.cobblestone, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.iron_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.gold_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_pickaxe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(Items.diamond, 3), 0.1F);
		
		this.addRecipe(new ItemStack(Items.wooden_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.planks, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.stone_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.cobblestone, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.iron_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.gold_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_axe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(Items.diamond, 3), 0.1F);
		
		this.addRecipe(new ItemStack(Items.wooden_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.planks, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.stone_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.cobblestone, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.iron_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.gold_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_shovel, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(Items.diamond, 1), 0.1F);
		
		this.addRecipe(new ItemStack(Items.wooden_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.planks, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.stone_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.cobblestone, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.iron_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.gold_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_hoe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(Items.diamond, 2), 0.1F);
		
		this.addRecipe(new ItemStack(Items.wooden_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(Blocks.planks, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.stone_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(Blocks.cobblestone, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(Items.iron_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(Items.gold_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_sword, 1, 0), new ItemStack(MItems.reinforced_stick, 1), new ItemStack(Items.diamond, 2), 0.1F);
		
		//Vanilla Armor
		this.addRecipe(new ItemStack(Items.leather_helmet, 1, 0), new ItemStack(Items.leather, 3), new ItemStack(Items.leather, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.chainmail_helmet, 1, 0), new ItemStack(Items.iron_ingot, 3), new ItemStack(Items.iron_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_helmet, 1, 0), new ItemStack(Items.iron_ingot, 3), new ItemStack(Items.iron_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_helmet, 1, 0), new ItemStack(Items.gold_ingot, 3), new ItemStack(Items.gold_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_helmet, 1, 0), new ItemStack(Items.diamond, 3), new ItemStack(Items.diamond, 2), 0.1F);
		
		this.addRecipe(new ItemStack(Items.leather_chestplate, 1, 0), new ItemStack(Items.leather, 4), new ItemStack(Items.leather, 4), 0.1F);
		this.addRecipe(new ItemStack(Items.chainmail_chestplate, 1, 0), new ItemStack(Items.iron_ingot, 4), new ItemStack(Items.iron_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_chestplate, 1, 0), new ItemStack(Items.iron_ingot, 4), new ItemStack(Items.iron_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_chestplate, 1, 0), new ItemStack(Items.gold_ingot, 4), new ItemStack(Items.gold_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_chestplate, 1, 0), new ItemStack(Items.diamond, 4), new ItemStack(Items.diamond, 4), 0.1F);
		
		this.addRecipe(new ItemStack(Items.leather_leggings, 1, 0), new ItemStack(Items.leather, 4), new ItemStack(Items.leather, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.chainmail_leggings, 1, 0), new ItemStack(Items.iron_ingot, 4), new ItemStack(Items.iron_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_leggings, 1, 0), new ItemStack(Items.iron_ingot, 4), new ItemStack(Items.iron_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_leggings, 1, 0), new ItemStack(Items.gold_ingot, 4), new ItemStack(Items.gold_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_leggings, 1, 0), new ItemStack(Items.diamond, 4), new ItemStack(Items.diamond, 3), 0.1F);
		
		this.addRecipe(new ItemStack(Items.leather_boots, 1, 0), new ItemStack(Items.leather, 2), new ItemStack(Items.leather, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.chainmail_boots, 1, 0), new ItemStack(Items.iron_ingot, 2), new ItemStack(Items.iron_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_boots, 1, 0), new ItemStack(Items.iron_ingot, 2), new ItemStack(Items.iron_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_boots, 1, 0), new ItemStack(Items.gold_ingot, 2), new ItemStack(Items.gold_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_boots, 1, 0), new ItemStack(Items.diamond, 2), new ItemStack(Items.diamond, 2), 0.1F);
		
		//Minestrapp Mineral Blocks
		this.addRecipe(new ItemStack(MBlocks.copper_block, 1), new ItemStack(MItems.copper_ingot, 5), new ItemStack(MItems.copper_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.tin_block, 1), new ItemStack(MItems.tin_ingot, 5), new ItemStack(MItems.tin_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.bronze_block, 1), new ItemStack(MItems.bronze_ingot, 5), new ItemStack(MItems.bronze_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.steel_block, 1), new ItemStack(MItems.steel_ingot, 5), new ItemStack(MItems.steel_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.sunstone_block, 1), new ItemStack(MItems.sunstone_shard, 2), new ItemStack(MItems.sunstone_shard, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.godstone, 1), new ItemStack(MItems.sunstone_shard, 4), new ItemStack(Items.prismarine_crystals, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.meurodite_block, 1), new ItemStack(MItems.meurodite_gem, 5), new ItemStack(MItems.meurodite_gem, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.torite_block, 1), new ItemStack(MItems.torite_ingot, 5), new ItemStack(MItems.torite_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.plutonium_block, 1), new ItemStack(MItems.plutonium, 5), new ItemStack(MItems.plutonium, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.uranium_block, 1), new ItemStack(MItems.uranium, 5), new ItemStack(MItems.uranium, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.desert_quartz_block, 1), new ItemStack(MItems.desert_quartz_item, 2), new ItemStack(MItems.desert_quartz_item, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.radiant_block, 1), new ItemStack(MItems.radiant_quartz, 2), new ItemStack(MItems.radiant_quartz, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.titanium_block, 1), new ItemStack(MItems.titanium_ingot, 5), new ItemStack(MItems.titanium_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.blazium_block, 1), new ItemStack(MItems.blazium_ingot, 5), new ItemStack(MItems.blazium_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.soul_gem_block, 1), new ItemStack(MItems.soul_gem, 5), new ItemStack(MItems.soul_gem, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.flint_block, 1), new ItemStack(Items.flint, 2), new ItemStack(Items.flint, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.sugar_block, 1), new ItemStack(Items.sugar, 5), new ItemStack(Items.sugar, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.glacierite_block, 1), new ItemStack(MItems.glacierite_ingot, 5), new ItemStack(MItems.glacierite_ingot, 4), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.tin_plating, 1), new ItemStack(MItems.tin_ingot, 3), new ItemStack(MItems.tin_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_plating, 1), new ItemStack(MItems.steel_ingot, 3), new ItemStack(MItems.steel_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_plating, 1), new ItemStack(MItems.meurodite_gem, 3), new ItemStack(MItems.meurodite_gem, 3), 0.1F);
		
		//Minestrapp Materials
		this.addRecipe(new ItemStack(MItems.bronze_ingot, 1), new ItemStack(MItems.copper_ingot, 3), new ItemStack(MItems.tin_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_ingot, 1), new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.coal, 6), 0.1F);
		this.addRecipe(new ItemStack(Items.prismarine_crystals, 1), new ItemStack(Items.prismarine_shard, 1), new ItemStack(MItems.sunstone_shard, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.blaze_shard, 1), new ItemStack(Items.blaze_powder, 1), new ItemStack(MItems.sunstone_shard, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.blaze_rod, 1), new ItemStack(Items.bone, 1), new ItemStack(MItems.blaze_shard, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.blazium_ingot, 1), new ItemStack(Items.gold_ingot, 1), new ItemStack(MItems.blaze_shard, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.glacierite_ingot, 1), new ItemStack(MItems.torite_ingot, 1), new ItemStack(MItems.glacieric_ice_shard, 4), 0.1F);
		
		//Minestrapp Decor Blocks
		this.addRecipe(new ItemStack(MBlocks.mud, 1, 0), new ItemStack(MItems.mud_ball, 2), new ItemStack(MItems.mud_ball, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.mud_bricks, 1, 0), new ItemStack(MItems.mud_ball, 2), new ItemStack(MItems.mud_ball, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.glass_window, 1), new ItemStack(MBlocks.glass_refined, 1), new ItemStack(Blocks.iron_bars, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.rope, 1), new ItemStack(Items.string, 2), new ItemStack(Items.string, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.cobblestone, 1), new ItemStack(MItems.chunks, 2, 0), new ItemStack(MItems.chunks, 2, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 1), new ItemStack(MItems.chunks, 2, 1), new ItemStack(MItems.chunks, 2, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 3), new ItemStack(MItems.chunks, 2, 2), new ItemStack(MItems.chunks, 2, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 5), new ItemStack(MItems.chunks, 2, 3), new ItemStack(MItems.chunks, 2, 3), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 7), new ItemStack(MItems.chunks, 2, 4), new ItemStack(MItems.chunks, 2, 4), 0.1F);
		
		this.addRecipe(new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(MItems.bricks, 2, 0), new ItemStack(MItems.bricks, 2, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 0), new ItemStack(MItems.bricks, 2, 1), new ItemStack(MItems.bricks, 2, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 1), new ItemStack(MItems.bricks, 2, 2), new ItemStack(MItems.bricks, 2, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 2), new ItemStack(MItems.bricks, 2, 3), new ItemStack(MItems.bricks, 2, 3), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 3), new ItemStack(MItems.bricks, 2, 4), new ItemStack(MItems.bricks, 2, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 4), new ItemStack(MItems.bricks, 2, 5), new ItemStack(MItems.bricks, 2, 5), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 5), new ItemStack(MItems.bricks, 2, 6), new ItemStack(MItems.bricks, 2, 6), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 6), new ItemStack(MItems.bricks, 2, 7), new ItemStack(MItems.bricks, 2, 7), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 7), new ItemStack(MItems.bricks, 2, 8), new ItemStack(MItems.bricks, 2, 8), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 8), new ItemStack(MItems.bricks, 2, 9), new ItemStack(MItems.bricks, 2, 9), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.granite_bricks, 1), new ItemStack(MItems.bricks, 2, 11), new ItemStack(MItems.bricks, 2, 11), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.diorite_bricks, 1), new ItemStack(MItems.bricks, 2, 12), new ItemStack(MItems.bricks, 2, 12), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.andesite_bricks, 1), new ItemStack(MItems.bricks, 2, 13), new ItemStack(MItems.bricks, 2, 13), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.slate_bricks, 1), new ItemStack(MItems.bricks, 2, 10), new ItemStack(MItems.bricks, 2, 10), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.sandstone_bricks, 1), new ItemStack(MItems.bricks2, 2, 0), new ItemStack(MItems.bricks2, 2, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.red_sandstone_bricks, 1), new ItemStack(MItems.bricks2, 2, 1), new ItemStack(MItems.bricks2, 2, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.flint_bricks, 1), new ItemStack(MItems.bricks, 2, 14), new ItemStack(MItems.bricks, 2, 14), 0.1F);
		this.addRecipe(new ItemStack(Blocks.prismarine, 1, 1), new ItemStack(Items.prismarine_shard, 2), new ItemStack(Items.prismarine_shard, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.brick_block, 1), new ItemStack(Items.brick, 2), new ItemStack(Items.brick, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.nether_brick, 1), new ItemStack(Items.netherbrick, 2), new ItemStack(Items.netherbrick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.obsidian_bricks, 1), new ItemStack(MItems.bricks, 2, 15), new ItemStack(MItems.bricks, 2, 15), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.melon_bricks, 1), new ItemStack(Items.melon, 5), new ItemStack(Items.melon, 4), 0.1F);
		
		this.addRecipe(new ItemStack(MBlocks.stone_pattern_bricks, 1), new ItemStack(MItems.bricks, 2, 0), new ItemStack(MItems.bricks, 2, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 0), new ItemStack(MItems.bricks, 2, 1), new ItemStack(MItems.bricks, 2, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 1),  new ItemStack(MItems.bricks, 2, 2), new ItemStack(MItems.bricks, 2, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 2), new ItemStack(MItems.bricks, 2, 3), new ItemStack(MItems.bricks, 2, 3), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 3), new ItemStack(MItems.bricks, 2, 4), new ItemStack(MItems.bricks, 2, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 4), new ItemStack(MItems.bricks, 2, 5), new ItemStack(MItems.bricks, 2, 5), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 5), new ItemStack(MItems.bricks, 2, 6), new ItemStack(MItems.bricks, 2, 6), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 6), new ItemStack(MItems.bricks, 2, 7), new ItemStack(MItems.bricks, 2, 7), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 7), new ItemStack(MItems.bricks, 2, 8), new ItemStack(MItems.bricks, 2, 8), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 8), new ItemStack(MItems.bricks, 2, 9), new ItemStack(MItems.bricks, 2, 9), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.granite_pattern_bricks, 1), new ItemStack(MItems.bricks, 2, 11), new ItemStack(MItems.bricks, 2, 11), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.diorite_pattern_bricks, 1), new ItemStack(MItems.bricks, 2, 12), new ItemStack(MItems.bricks, 2, 12), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.andesite_pattern_bricks, 1), new ItemStack(MItems.bricks, 2, 13), new ItemStack(MItems.bricks, 2, 13), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.slate_pattern_bricks, 1), new ItemStack(MItems.bricks, 2, 10), new ItemStack(MItems.bricks, 2, 10), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.sandstone_pattern_bricks, 1), new ItemStack(MItems.bricks2, 2, 0), new ItemStack(MItems.bricks2, 2, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.red_sandstone_pattern_bricks, 1), new ItemStack(MItems.bricks2, 2, 1), new ItemStack(MItems.bricks2, 2, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.flint_pattern_bricks, 1), new ItemStack(MItems.bricks, 2, 14), new ItemStack(MItems.bricks, 2, 14), 0.1F);
		
		this.addRecipe(new ItemStack(Blocks.stonebrick, 1, 3), new ItemStack(Blocks.stone_slab, 1), new ItemStack(Blocks.stone_slab, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 0), new ItemStack(MBlocks.deepstone_slab, 1), new ItemStack(MBlocks.deepstone_slab, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 1), new ItemStack(MBlocks.red_rock_slab, 1), new ItemStack(MBlocks.red_rock_slab, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 2), new ItemStack(MBlocks.deep_red_rock_slab, 1), new ItemStack(MBlocks.deep_red_rock_slab, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 3), new ItemStack(MBlocks.coldstone_slab, 1), new ItemStack(MBlocks.coldstone_slab, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 4), new ItemStack(MBlocks.deep_coldstone_slab, 1), new ItemStack(MBlocks.deep_coldstone_slab, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 5), new ItemStack(MBlocks.icestone_slab, 1), new ItemStack(MBlocks.icestone_slab, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 6), new ItemStack(MBlocks.glacierrock_slab, 1), new ItemStack(MBlocks.glacierrock_slab, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 7), new ItemStack(MBlocks.oceanstone_slab, 1), new ItemStack(MBlocks.oceanstone_slab, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 8), new ItemStack(MBlocks.poceanstone_slab, 1), new ItemStack(MBlocks.poceanstone_slab, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.sandstone, 1, 1), new ItemStack(Blocks.stone_slab, 1, 1), new ItemStack(Blocks.stone_slab, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.red_sandstone, 1, 1), new ItemStack(Blocks.stone_slab2, 1, 0), new ItemStack(Blocks.stone_slab2, 1, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.desert_quartz_chiseled, 1), new ItemStack(MBlocks.desert_quartz_slab), new ItemStack(MBlocks.desert_quartz_slab), 0.1F);
		this.addRecipe(new ItemStack(Blocks.quartz_block, 1, 1), new ItemStack(Blocks.stone_slab, 1, 7), new ItemStack(Blocks.stone_slab, 1, 7), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.radiant_chiseled, 1), new ItemStack(MBlocks.radiant_slab, 1), new ItemStack(MBlocks.radiant_slab, 1), 0.1F);
		
		this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 1), new ItemStack(MItems.chunks, 2, 0), new ItemStack(MItems.chunks, 1, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.red_rock_wall, 1), new ItemStack(MItems.chunks, 2, 1), new ItemStack(MItems.chunks, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.red_rock_wall_mossy, 1), new ItemStack(MItems.chunks, 2, 1), new ItemStack(MItems.chunks, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.coldstone_wall, 1), new ItemStack(MItems.chunks, 2, 1), new ItemStack(MItems.chunks, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.coldstone_wall_mossy, 1), new ItemStack(MItems.chunks, 2, 1), new ItemStack(MItems.chunks, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.icestone_wall, 1), new ItemStack(MItems.chunks, 2, 1), new ItemStack(MItems.chunks, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.icestone_wall_mossy, 1), new ItemStack(MItems.chunks, 2, 1), new ItemStack(MItems.chunks, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.oceanstone_wall, 1), new ItemStack(MItems.chunks, 2, 1), new ItemStack(MItems.chunks, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.oceanstone_wall_mossy, 1), new ItemStack(MItems.chunks, 2, 1), new ItemStack(MItems.chunks, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.nether_brick_fence, 1), new ItemStack(Items.netherbrick, 2), new ItemStack(Items.netherbrick, 1), 0.1F);
		
		this.addRecipe(new ItemStack(MBlocks.roads, 1, 0), new ItemStack(Blocks.dirt, 1, 0), new ItemStack(MItems.chunks, 2, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.roads, 1, 1), new ItemStack(Blocks.sand, 1, 1), new ItemStack(MItems.chunks, 2, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.roads, 1, 2), new ItemStack(Blocks.gravel, 1, 0), new ItemStack(MItems.chunks, 2, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.roads, 1, 3), new ItemStack(MBlocks.dirt_permafrost, 1, 0), new ItemStack(MItems.chunks, 2, 3), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.roads, 1, 4), new ItemStack(Blocks.sand, 1, 0), new ItemStack(MItems.chunks, 2, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.roads, 1, 6), new ItemStack(MBlocks.soul_ore, 3, 0), new ItemStack(MItems.steel_plating, 1, 0), 0.1F);
		
		//Minestrapp Tech Blocks
		this.addRecipe(new ItemStack(MBlocks.crate, 1), new ItemStack(Blocks.planks, 6), new ItemStack(Items.stick, 3), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.barrel, 1), new ItemStack(Blocks.planks, 6), new ItemStack(MItems.tin_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.sawmill, 1), new ItemStack(Blocks.planks, 4), new ItemStack(MItems.copper_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.stonecutter, 1), new ItemStack(Blocks.cobblestone, 4), new ItemStack(Items.iron_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.alloy, 1), new ItemStack(MItems.tin_plating, 5), new ItemStack(MBlocks.biome_bricks, 3, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.melter, 1), new ItemStack(MItems.meurodite_plating, 5), new ItemStack(MBlocks.blazium_block, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.frost_generator, 1), new ItemStack(Blocks.packed_ice, 2), new ItemStack(MItems.radiant_quartz, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.plutonium_insulated, 1), new ItemStack(MItems.steel_ingot, 6), new ItemStack(MBlocks.plutonium_block, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.uranium_insulated, 1), new ItemStack(MItems.steel_ingot, 6), new ItemStack(MBlocks.uranium_block, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.crusher, 1), new ItemStack(MBlocks.bronze_block, 4), new ItemStack(MItems.titanium_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.splitter, 1), new ItemStack(MBlocks.radiant_chiseled, 4), new ItemStack(MItems.torite_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.claimerator, 1), new ItemStack(Items.diamond, 4), new ItemStack(MBlocks.godstone, 1), 0.1F);
		
		//Minestrapp Foods
		this.addRecipe(new ItemStack(MItems.dough, 1), new ItemStack(Items.wheat, 1), new ItemStack(Items.wheat, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_bowl, 1), new ItemStack(MItems.dough, 1), new ItemStack(Items.bowl, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.pbj_sandwich, 1), new ItemStack(MItems.bun, 2), new ItemStack(MItems.jam_bottle, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.hamburger, 1), new ItemStack(MItems.bun, 2), new ItemStack(Items.cooked_beef, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.pie_crust, 1), new ItemStack(MItems.sugar_dough, 1), new ItemStack(Items.egg, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.apple_pie, 1), new ItemStack(MItems.pie_crust, 1), new ItemStack(Items.apple, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.fried_egg, 1), new ItemStack(Items.bowl, 1), new ItemStack(Items.egg, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_fried_egg, 1), new ItemStack(MItems.bread_bowl, 1), new ItemStack(Items.egg, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.rice_bowl, 1), new ItemStack(MBlocks.rice, 1), new ItemStack(Items.bowl, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_rice_bowl, 1), new ItemStack(MBlocks.rice, 1), new ItemStack(MItems.bread_bowl, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.stir_fry, 1), new ItemStack(MItems.rice_bowl, 1), new ItemStack(MItems.hot_sauce, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_stir_fry, 1), new ItemStack(MItems.rice_bowl, 1), new ItemStack(MItems.hot_sauce, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.hot_sauce, 1), new ItemStack(MItems.pepper, 1), new ItemStack(Items.glass_bottle, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_mushroom_stew, 1), new ItemStack(Blocks.red_mushroom, 1), new ItemStack(Blocks.brown_mushroom, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_rabbit_stew, 1), new ItemStack(Items.cooked_rabbit, 1), new ItemStack(Items.baked_potato, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.salad, 1), new ItemStack(MBlocks.lettuce, 1), new ItemStack(MBlocks.cabbage, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_salad, 1), new ItemStack(MBlocks.lettuce, 1), new ItemStack(MBlocks.cabbage, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.health_salad, 1), new ItemStack(MBlocks.lettuce, 1), new ItemStack(MBlocks.cabbage, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_health_salad, 1), new ItemStack(MBlocks.lettuce, 1), new ItemStack(MBlocks.cabbage, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.saturation_salad, 1), new ItemStack(MBlocks.lettuce, 1), new ItemStack(MBlocks.cabbage, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_saturation_salad, 1), new ItemStack(MBlocks.lettuce, 1), new ItemStack(MBlocks.cabbage, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.speed_salad, 1), new ItemStack(MBlocks.lettuce, 1), new ItemStack(MBlocks.cabbage, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_speed_salad, 1), new ItemStack(MBlocks.lettuce, 1), new ItemStack(MBlocks.cabbage, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.strength_salad, 1), new ItemStack(MBlocks.lettuce, 1), new ItemStack(MBlocks.cabbage, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_strength_salad, 1), new ItemStack(MBlocks.lettuce, 1), new ItemStack(MBlocks.cabbage, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.jam_bottle, 1), new ItemStack(MItems.strawberry, 1), new ItemStack(MItems.blackberry, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.peanut_butter_bottle, 1), new ItemStack(MBlocks.peanuts, 4), new ItemStack(Items.glass_bottle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.meat_block, 1), new ItemStack(Items.rotten_flesh, 5), new ItemStack(Items.rotten_flesh, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.sushi), new ItemStack(Items.cooked_fish, 1, 1), new ItemStack(MBlocks.rice), 0.1F);
		this.addRecipe(new ItemStack(MItems.lucky_sushi), new ItemStack(Items.fish, 1, 2), new ItemStack(Items.gold_nugget, 1), 0.1F);
		
		//Minestrapp Tools
		this.addRecipe(new ItemStack(MItems.copper_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.copper_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.bronze_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.steel_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_pickaxe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.meurodite_gem, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_pickaxe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.torite_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.fire_pickaxe, 1, 0), new ItemStack(Items.blaze_rod, 2), new ItemStack(MItems.blazium_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_pickaxe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.titanium_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.bedrock_pickaxe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(Blocks.bedrock, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.ice_pickaxe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.glacierite_ingot, 3), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.copper_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.copper_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.bronze_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.steel_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_axe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.meurodite_gem, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_axe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.torite_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.fire_axe, 1, 0), new ItemStack(Items.blaze_rod, 2), new ItemStack(MItems.blazium_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_axe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.titanium_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.bedrock_axe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(Blocks.bedrock, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.ice_axe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.glacierite_ingot, 3), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.copper_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.copper_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.bronze_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.steel_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_shovel, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.meurodite_gem, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_shovel, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.torite_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.fire_shovel, 1, 0), new ItemStack(Items.blaze_rod, 2), new ItemStack(MItems.blazium_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_shovel, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.titanium_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bedrock_shovel, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(Blocks.bedrock, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.ice_shovel, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.glacierite_ingot, 1), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.copper_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.copper_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.bronze_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.steel_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_hoe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.meurodite_gem, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_hoe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.torite_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.fire_hoe, 1, 0), new ItemStack(Items.blaze_rod, 2), new ItemStack(MItems.blazium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_hoe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.titanium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.bedrock_hoe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(Blocks.bedrock, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.ice_hoe, 1, 0), new ItemStack(MItems.reinforced_stick, 2), new ItemStack(MItems.glacierite_ingot, 2), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.copper_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(MItems.copper_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(MItems.bronze_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(MItems.steel_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_sword, 1, 0), new ItemStack(MItems.reinforced_stick, 1), new ItemStack(MItems.meurodite_gem, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_sword, 1, 0), new ItemStack(MItems.reinforced_stick, 1), new ItemStack(MItems.torite_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.fire_sword, 1, 0), new ItemStack(Items.blaze_rod, 1), new ItemStack(MItems.blazium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_sword, 1, 0), new ItemStack(MItems.reinforced_stick, 1), new ItemStack(MItems.titanium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.ice_sword, 1, 0), new ItemStack(MItems.reinforced_stick, 1), new ItemStack(MItems.glacierite_ingot, 2), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.sifter, 1, 0), new ItemStack(MItems.copper_ingot, 3), new ItemStack(MItems.reinforced_stick, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_sifter, 1), new ItemStack(MItems.titanium_ingot, 3), new ItemStack(MItems.reinforced_stick, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.empty_titanium_sifter, 1), new ItemStack(MItems.titanium_ingot, 3), new ItemStack(MItems.reinforced_stick, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.wing_segment, 1), new ItemStack(MItems.wing_sinew, 3), new ItemStack(Items.leather, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.hangglider, 1, 0), new ItemStack(Blocks.planks, 4), new ItemStack(MItems.wing_sinew, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.soulbottle, 1), new ItemStack(MItems.soul_gem, 1), new ItemStack(Items.glass_bottle, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.heart_container, 1), new ItemStack(MItems.heart_piece, 2), new ItemStack(MItems.heart_piece, 2), 0.1F);
		
		//Minestrapp Armor
		this.addRecipe(new ItemStack(MItems.tin_helmet, 1, 0), new ItemStack(MItems.tin_ingot, 3), new ItemStack(MItems.tin_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_helmet, 1, 0), new ItemStack(MItems.bronze_ingot, 3), new ItemStack(MItems.bronze_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_helmet, 1, 0), new ItemStack(MItems.steel_ingot, 3), new ItemStack(MItems.steel_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_helmet, 1, 0), new ItemStack(MItems.meurodite_gem, 3), new ItemStack(MItems.meurodite_gem, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_helmet, 1, 0), new ItemStack(MItems.torite_ingot, 3), new ItemStack(MItems.torite_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.blazium_helmet, 1, 0), new ItemStack(MItems.blazium_ingot, 3), new ItemStack(MItems.blazium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_helmet, 1, 0), new ItemStack(MItems.titanium_ingot, 3), new ItemStack(MItems.titanium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.rad_helmet, 1, 0), new ItemStack(MItems.steel_plating, 1), new ItemStack(MItems.torite_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.ice_helmet, 1, 0), new ItemStack(MItems.glacierite_ingot, 3), new ItemStack(MItems.glacierite_ingot, 2), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.tin_chestplate, 1, 0), new ItemStack(MItems.tin_ingot, 4), new ItemStack(MItems.tin_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_chestplate, 1, 0), new ItemStack(MItems.bronze_ingot, 4), new ItemStack(MItems.bronze_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_chestplate, 1, 0), new ItemStack(MItems.steel_ingot, 4), new ItemStack(MItems.steel_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_chestplate, 1, 0), new ItemStack(MItems.meurodite_gem, 4), new ItemStack(MItems.meurodite_gem, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_chestplate, 1, 0), new ItemStack(MItems.torite_ingot, 4), new ItemStack(MItems.torite_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.blazium_chestplate, 1, 0), new ItemStack(MItems.blazium_ingot, 4), new ItemStack(MItems.blazium_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_chestplate, 1, 0), new ItemStack(MItems.titanium_ingot, 4), new ItemStack(MItems.titanium_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.rad_chestplate, 1, 0), new ItemStack(MItems.technological_doodad, 1), new ItemStack(MItems.steel_plating, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.ice_chestplate, 1, 0), new ItemStack(MItems.glacierite_ingot, 4), new ItemStack(MItems.glacierite_ingot, 4), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.tin_leggings, 1, 0), new ItemStack(MItems.tin_ingot, 4), new ItemStack(MItems.tin_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_leggings, 1, 0), new ItemStack(MItems.bronze_ingot, 4), new ItemStack(MItems.bronze_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_leggings, 1, 0), new ItemStack(MItems.steel_ingot, 4), new ItemStack(MItems.steel_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_leggings, 1, 0), new ItemStack(MItems.meurodite_gem, 4), new ItemStack(MItems.meurodite_gem, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_leggings, 1, 0), new ItemStack(MItems.torite_ingot, 4), new ItemStack(MItems.torite_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.blazium_leggings, 1, 0), new ItemStack(MItems.blazium_ingot, 4), new ItemStack(MItems.blazium_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_leggings, 1, 0), new ItemStack(MItems.titanium_ingot, 4), new ItemStack(MItems.titanium_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.rad_leggings, 1, 0), new ItemStack(MItems.technological_doodad, 1), new ItemStack(MItems.steel_plating, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.ice_leggings, 1, 0), new ItemStack(MItems.glacierite_ingot, 4), new ItemStack(MItems.glacierite_ingot, 3), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.tin_boots, 1, 0), new ItemStack(MItems.tin_ingot, 2), new ItemStack(MItems.tin_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_boots, 1, 0), new ItemStack(MItems.bronze_ingot, 2), new ItemStack(MItems.bronze_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_boots, 1, 0), new ItemStack(MItems.steel_ingot, 2), new ItemStack(MItems.steel_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_boots, 1, 0), new ItemStack(MItems.meurodite_gem, 2), new ItemStack(MItems.meurodite_gem, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_boots, 1, 0), new ItemStack(MItems.torite_ingot, 2), new ItemStack(MItems.torite_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.blazium_boots, 1, 0), new ItemStack(MItems.blazium_ingot, 2), new ItemStack(MItems.blazium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_boots, 1, 0), new ItemStack(MItems.titanium_ingot, 2), new ItemStack(MItems.titanium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.rad_boots, 1, 0), new ItemStack(MItems.steel_plating, 2), new ItemStack(MItems.torite_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.ice_boots, 1, 0), new ItemStack(MItems.glacierite_ingot, 2), new ItemStack(MItems.glacierite_ingot, 2), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.amuletOves, 1, 0), new ItemStack(MItems.sheep_foot, 1), new ItemStack(Items.gold_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.amuletVaccam, 1, 0), new ItemStack(MItems.cow_foot, 1), new ItemStack(Items.gold_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.amuletPorcum, 1, 0), new ItemStack(MItems.pig_foot, 1), new ItemStack(Items.gold_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.amuletPullum, 1, 0), new ItemStack(MItems.chicken_foot, 1), new ItemStack(Items.gold_ingot, 3), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.propeller, 1), new ItemStack(MItems.copper_ingot, 3), new ItemStack(MItems.bronze_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.fan, 1), new ItemStack(MItems.propeller, 1), new ItemStack(MItems.technological_doodad, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.chimney, 1), new ItemStack(MItems.bricks, 6, 10), new ItemStack(MItems.bricks, 2, 11), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.ice_cream, 1), new ItemStack(MItems.crushed_ice, 1), new ItemStack(MItems.strawberry, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_ice_cream, 1), new ItemStack(MItems.crushed_ice, 1), new ItemStack(MItems.strawberry, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.glacieric_ice, 1), new ItemStack(MItems.glacieric_ice_shard, 1), new ItemStack(Blocks.packed_ice, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.charge_gun, 1), new ItemStack(MItems.titanium_ingot, 2), new ItemStack(MItems.steel_plating, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.satchel, 1), new ItemStack(Items.rabbit_hide, 7), new ItemStack(MBlocks.crate, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.backpack, 1), new ItemStack(MItems.wolf_hide, 5), new ItemStack(MBlocks.barrel, 1), 0.1F);

		this.addRecipe(new ItemStack(MItems.crystal_heart, 1), new ItemStack(MItems.diamond_dust, 4), new ItemStack(MItems.heart_piece, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.inert_crystal_heart, 1), new ItemStack(MItems.diamond_dust, 4), new ItemStack(MItems.heart_piece, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_cow, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.cow_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_mooshroom, 1), new ItemStack(MBlocks.block_cow, 1), new ItemStack(MItems.infectious_fungus, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_chicken, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.chicken_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_rabbit, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.rabbit_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_wolf, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.wolf_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_white, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_silver, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_grey, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_black, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_brown, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_pink, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_red, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_orange, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_yellow, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_lime, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_green, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_cyan, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_light_blue, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_blue, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_purple, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_sheep_magenta, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.sheep_gene_sample, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.cow_gene_sample, 1), new ItemStack(MItems.cow_foot, 1), new ItemStack(MItems.slime_core, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.chicken_gene_sample, 1), new ItemStack(MItems.chicken_foot, 1), new ItemStack(MItems.slime_core, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.rabbit_gene_sample, 1), new ItemStack(Items.rabbit_foot, 1), new ItemStack(MItems.slime_core, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.sheep_gene_sample, 1), new ItemStack(MItems.sheep_foot, 1), new ItemStack(MItems.slime_core, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.wolf_gene_sample, 1), new ItemStack(MItems.wolf_hide, 1), new ItemStack(MItems.slime_core, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bat_gene_sample, 1), new ItemStack(MItems.wing_sinew, 1), new ItemStack(MItems.slime_core, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.block_bat, 1), new ItemStack(MBlocks.block_flesh, 1), new ItemStack(MItems.bat_gene_sample, 1), 0.1F);

		this.addRecipe(new ItemStack(MItems.glowshroom_stew, 1), new ItemStack(MBlocks.purple_glowshroom, 1), new ItemStack(MBlocks.green_glowshroom, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_glowshroom_stew, 1), new ItemStack(MBlocks.purple_glowshroom, 1), new ItemStack(MBlocks.green_glowshroom, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.corn_on_stick, 1), new ItemStack(MBlocks.corn, 1), new ItemStack(Items.stick, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.grilled_corn, 1), new ItemStack(MItems.corn_on_stick, 1), new ItemStack(MItems.fat, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.popcorn, 1), new ItemStack(MBlocks.corn, 1), new ItemStack(Items.bowl, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_popcorn, 1), new ItemStack(MBlocks.corn, 1), new ItemStack(MItems.bread_bowl, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.corn_meal, 1), new ItemStack(MBlocks.corn, 1), new ItemStack(MBlocks.corn, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.fries, 1), new ItemStack(Items.potato, 1), new ItemStack(MItems.grease, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.fried_fish, 1), new ItemStack(Items.cooked_fish, 1, 0), new ItemStack(MItems.grease, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.fried_salmon, 1), new ItemStack(Items.cooked_fish, 1, 1), new ItemStack(MItems.grease, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.salmon_burger, 1), new ItemStack(MItems.bun, 2), new ItemStack(MItems.fried_salmon, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.fish_and_chips, 1), new ItemStack(MItems.fries, 1), new ItemStack(MItems.fried_fish, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_carved_0, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_carved_1, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_carved_2, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_carved_3, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_carved_4, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_smashed, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_carved_0_lit, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_carved_1_lit, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_carved_2_lit, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_carved_3_lit, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_carved_4_lit, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pumpkin_smashed_lit, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(MBlocks.candle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.hourglass_empty, 1), new ItemStack(MItems.bronze_ingot, 4), new ItemStack(Items.glass_bottle, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.hourglass_sand, 1), new ItemStack(MBlocks.hourglass_empty, 1), new ItemStack(Blocks.sand, 1, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.hourglass_red_sand, 1), new ItemStack(MBlocks.hourglass_empty, 1), new ItemStack(Blocks.sand, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.hourglass_cold_sand, 1), new ItemStack(MBlocks.hourglass_empty, 1), new ItemStack(MBlocks.cold_sand, 1, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.hourglass_cold_red_sand, 1), new ItemStack(MBlocks.hourglass_empty, 1), new ItemStack(MBlocks.cold_sand, 1, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.hourglass_redstone, 1), new ItemStack(MBlocks.hourglass_empty, 1), new ItemStack(Items.redstone, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.ritual_conduit, 1), new ItemStack(Items.iron_ingot, 7), new ItemStack(MItems.bronze_plating, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_plating, 1), new ItemStack(MItems.bronze_ingot, 3), new ItemStack(MItems.bronze_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.advanced_tech_doodad, 1), new ItemStack(MItems.technological_doodad, 4), new ItemStack(MItems.titanium_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.tomato_sauce, 1), new ItemStack(MItems.tomato, 2), new ItemStack(Items.bowl, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_tomato_sauce, 1), new ItemStack(MItems.tomato, 2), new ItemStack(MItems.bread_bowl, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.tomato_soup, 1), new ItemStack(MItems.tomato_sauce, 1), new ItemStack(MItems.fat, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_tomato_soup, 1), new ItemStack(MItems.bread_tomato_sauce, 1), new ItemStack(MItems.fat, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.spaghetti, 1), new ItemStack(MItems.tomato_sauce, 1), new ItemStack(MItems.dry_spaghetti, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bread_spaghetti, 1), new ItemStack(MItems.bread_tomato_sauce, 1), new ItemStack(MItems.dry_spaghetti, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.compacted_dirt, 1), new ItemStack(Blocks.dirt, 5, 0), new ItemStack(Blocks.dirt, 4, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.compacted_netherrack, 1), new ItemStack(Blocks.netherrack, 5), new ItemStack(Blocks.netherrack, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.compacted_endstone, 1), new ItemStack(Blocks.end_stone, 5), new ItemStack(Blocks.end_stone, 4), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.compacted_glowshrooms, 1), new ItemStack(MBlocks.huge_purple_glowshroom, 4), new ItemStack(MBlocks.huge_green_glowshroom, 5), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.dimensium_block, 1), new ItemStack(MItems.dimensium_ingot, 5), new ItemStack(MItems.dimensium_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.will_o_wisp, 1), new ItemStack(Items.glass_bottle, 1), new ItemStack(MItems.ender_aura, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.jadachite_block, 1), new ItemStack(MItems.jadachite_shard, 2), new ItemStack(MItems.jadachite_shard, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.jadachite_bricks, 1), new ItemStack(MItems.jadachite_shard, 2), new ItemStack(MItems.jadachite_shard, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.dimensional_fishery, 1), new ItemStack(MBlocks.hourglass_continurum, 1), new ItemStack(MItems.advanced_tech_doodad, 1), 0.1F);
	}
	
	public void addRecipe(Block input, ItemStack stack, ItemStack stack2, float experience)
	{
		this.addRecipe(Item.getItemFromBlock(input), stack, stack2, experience);
	}
	
	public void addRecipe(Item input, ItemStack stack, ItemStack stack2, float experience)
	{
		this.addRecipe(new ItemStack(input, 1, 32767), stack, stack2, experience);
	}
	
	public void addRecipe(ItemStack input, ItemStack stack, ItemStack stack2, float experience)
	{
		this.splitList.put(input, stack);
		this.splitList2.put(input, stack2);
		this.experienceList.put(stack, Float.valueOf(experience));
	}
	
	public ItemStack getResult(ItemStack stack)
	{
		Iterator iterator = this.splitList.entrySet().iterator();
		Entry entry;
		
		do
		{
			if (!iterator.hasNext())
				return null;
			
			entry = (Entry) iterator.next();
		}
		while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));
		
		return (ItemStack) entry.getValue();
	}
	
	public ItemStack getResult2(ItemStack stack)
	{
		Iterator iterator = this.splitList2.entrySet().iterator();
		Entry entry;
		
		do
		{
			if (!iterator.hasNext())
				return null;
			
			entry = (Entry) iterator.next();
		}
		while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));
		
		return (ItemStack) entry.getValue();
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Map getSsplitList()
	{
		return this.splitList;
	}
	
	public float getSmeltingExperience(ItemStack stack)
	{
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;
		
		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;
		
		do
		{
			if (!iterator.hasNext())
				return 0.0F;
			
			entry = (Entry) iterator.next();
		}
		while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));
		
		return ((Float) entry.getValue()).floatValue();
	}
	
	public void addDictionaryRecipes(String name, ItemStack output, ItemStack output2, Float exp, int chance)
    {
    	for(ItemStack is : OreDictionary.getOres(name))
    	{
    		this.addRecipe(is, output, output2, 0.1F);
    	}
    }
}