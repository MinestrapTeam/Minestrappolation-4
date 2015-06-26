package minestrapteam.minestrappolation.crafting.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;

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
		this.addRecipe(new ItemStack(Blocks.lit_pumpkin, 1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(Blocks.torch, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.sandstone, 1, 0), new ItemStack(Blocks.sand, 2, 0), new ItemStack(Blocks.sand, 2, 0), 0.1F);
		this.addRecipe(new ItemStack(Blocks.sandstone, 1, 1), new ItemStack(Blocks.sand, 2, 1), new ItemStack(Blocks.sand, 2, 1), 0.1F);
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
		this.addRecipe(new ItemStack(Items.flower_pot, 1), new ItemStack(Items.brick, 2), new ItemStack(Items.brick, 1), 0.1F);
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
		this.addRecipe(new ItemStack(Items.diamond_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.diamond, 3), 0.1F);
		
		this.addRecipe(new ItemStack(Items.wooden_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.planks, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.stone_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.cobblestone, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.iron_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.gold_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.diamond, 3), 0.1F);
		
		this.addRecipe(new ItemStack(Items.wooden_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.planks, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.stone_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.cobblestone, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.iron_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.gold_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.diamond, 1), 0.1F);
		
		this.addRecipe(new ItemStack(Items.wooden_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.planks, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.stone_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.cobblestone, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.iron_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.gold_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.diamond, 2), 0.1F);
		
		this.addRecipe(new ItemStack(Items.wooden_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(Blocks.planks, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.stone_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(Blocks.cobblestone, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(Items.iron_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(Items.gold_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(Items.diamond, 2), 0.1F);
		
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
		
		//Minestrapp Decor Blocks
		this.addRecipe(new ItemStack(MBlocks.glass_window, 1), new ItemStack(MBlocks.glass_refined, 1), new ItemStack(Blocks.iron_bars, 1), 0.1F);
		this.addRecipe(new ItemStack(Blocks.cobblestone, 1), new ItemStack(MItems.chunks, 2, 0), new ItemStack(MItems.chunks, 2, 0), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 1), new ItemStack(MItems.chunks, 2, 1), new ItemStack(MItems.chunks, 2, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 3), new ItemStack(MItems.chunks, 2, 2), new ItemStack(MItems.chunks, 2, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 5), new ItemStack(MItems.chunks, 2, 3), new ItemStack(MItems.chunks, 2, 3), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 7), new ItemStack(MItems.chunks, 2, 4), new ItemStack(MItems.chunks, 2, 4), 0.1F);
		
		this.addRecipe(new ItemStack(Blocks.stonebrick, 1, 0), new ItemStack(MItems.stone_brick, 2), new ItemStack(MItems.stone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 0), new ItemStack(MItems.deepstone_brick, 2), new ItemStack(MItems.deepstone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 1), new ItemStack(MItems.red_rock_brick, 2), new ItemStack(MItems.red_rock_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 2), new ItemStack(MItems.deep_red_rock_brick, 2), new ItemStack(MItems.deep_red_rock_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 3), new ItemStack(MItems.coldstone_brick, 2), new ItemStack(MItems.coldstone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 4), new ItemStack(MItems.deep_coldstone_brick, 2), new ItemStack(MItems.deep_coldstone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 5), new ItemStack(MItems.icestone_brick, 2), new ItemStack(MItems.icestone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 6), new ItemStack(MItems.glacierrock_brick, 2), new ItemStack(MItems.glacierrock_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 7), new ItemStack(MItems.oceanstone_brick, 2), new ItemStack(MItems.oceanstone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 8), new ItemStack(MItems.pressurized_oceanstone_brick, 2), new ItemStack(MItems.pressurized_oceanstone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.granite_bricks, 1), new ItemStack(MItems.granite_brick, 2), new ItemStack(MItems.granite_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.diorite_bricks, 1), new ItemStack(MItems.diorite_brick, 2), new ItemStack(MItems.diorite_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.andesite_bricks, 1), new ItemStack(MItems.andesite_brick, 2), new ItemStack(MItems.andesite_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.slate_bricks, 1), new ItemStack(MItems.slate_brick, 2), new ItemStack(MItems.slate_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.flint_bricks, 1), new ItemStack(MItems.flint_brick, 2), new ItemStack(MItems.flint_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.prismarine, 1, 1), new ItemStack(Items.prismarine_shard, 2), new ItemStack(Items.prismarine_shard, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.brick_block, 1), new ItemStack(Items.brick, 2), new ItemStack(Items.brick, 2), 0.1F);
		this.addRecipe(new ItemStack(Blocks.nether_brick, 1), new ItemStack(Items.netherbrick, 2), new ItemStack(Items.netherbrick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.obsidian_bricks, 1), new ItemStack(MItems.obsidian_brick, 2), new ItemStack(MItems.obsidian_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.melon_bricks, 1), new ItemStack(Items.melon, 5), new ItemStack(Items.melon, 4), 0.1F);
		
		this.addRecipe(new ItemStack(MBlocks.stone_pattern_bricks, 1), new ItemStack(MItems.stone_brick, 2), new ItemStack(MItems.stone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 0), new ItemStack(MItems.deepstone_brick, 2), new ItemStack(MItems.deepstone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 1), new ItemStack(MItems.red_rock_brick, 2), new ItemStack(MItems.red_rock_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 2), new ItemStack(MItems.deep_red_rock_brick, 2), new ItemStack(MItems.deep_red_rock_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 3), new ItemStack(MItems.coldstone_brick, 2), new ItemStack(MItems.coldstone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 4), new ItemStack(MItems.deep_coldstone_brick, 2), new ItemStack(MItems.deep_coldstone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 5), new ItemStack(MItems.icestone_brick, 2), new ItemStack(MItems.icestone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 6), new ItemStack(MItems.glacierrock_brick, 2), new ItemStack(MItems.glacierrock_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 7), new ItemStack(MItems.oceanstone_brick, 2), new ItemStack(MItems.oceanstone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 1, 8), new ItemStack(MItems.pressurized_oceanstone_brick, 2), new ItemStack(MItems.pressurized_oceanstone_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.granite_pattern_bricks, 1), new ItemStack(MItems.granite_brick, 2), new ItemStack(MItems.granite_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.diorite_pattern_bricks, 1), new ItemStack(MItems.diorite_brick, 2), new ItemStack(MItems.diorite_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.andesite_pattern_bricks, 1), new ItemStack(MItems.andesite_brick, 2), new ItemStack(MItems.andesite_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.slate_pattern_bricks, 1), new ItemStack(MItems.slate_brick, 2), new ItemStack(MItems.slate_brick, 2), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.flint_pattern_bricks, 1), new ItemStack(MItems.flint_brick, 2), new ItemStack(MItems.flint_brick, 2), 0.1F);
		
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
		this.addRecipe(new ItemStack(Blocks.nether_brick_fence, 1), new ItemStack(Items.netherbrick, 2), new ItemStack(Items.netherbrick, 1), 0.1F);
		
		//Minestrapp Tech Blocks
		this.addRecipe(new ItemStack(MBlocks.alloy, 1), new ItemStack(MItems.tin_plating, 5), new ItemStack(MBlocks.biome_bricks, 3, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.melter, 1), new ItemStack(MItems.meurodite_plating, 5), new ItemStack(MBlocks.blazium_block, 1), 0.1F);
		this.addRecipe(new ItemStack(MBlocks.frost_generator, 1), new ItemStack(Blocks.packed_ice, 2), new ItemStack(MItems.radiant_quartz, 2), 0.1F);
		
		//Minestrapp Foods
		this.addRecipe(new ItemStack(MItems.dough, 1), new ItemStack(Items.wheat, 1), new ItemStack(Items.wheat, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.pie_crust, 1), new ItemStack(MItems.sugar_dough, 1), new ItemStack(Items.egg, 1), 0.1F);
		
		//Minestrapp Tools
		this.addRecipe(new ItemStack(MItems.copper_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.copper_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.bronze_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.steel_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.meurodite_gem, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.torite_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.fire_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.blazium_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.titanium_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.bedrock_pickaxe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.bedrock, 3), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.copper_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.copper_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.bronze_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.steel_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.meurodite_gem, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.torite_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.fire_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.blazium_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.titanium_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.bedrock_axe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.bedrock, 3), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.copper_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.copper_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.bronze_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.steel_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.meurodite_gem, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.torite_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.fire_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.blazium_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.titanium_ingot, 1), 0.1F);
		this.addRecipe(new ItemStack(MItems.bedrock_shovel, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.bedrock, 1), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.copper_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.copper_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.bronze_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.steel_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.meurodite_gem, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.torite_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.fire_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.blazium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(MItems.titanium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.bedrock_hoe, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.bedrock, 2), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.copper_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(MItems.copper_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(MItems.bronze_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(MItems.steel_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(MItems.meurodite_gem, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(MItems.torite_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.fire_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(MItems.blazium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_sword, 1, 0), new ItemStack(Items.stick, 1), new ItemStack(MItems.titanium_ingot, 2), 0.1F);
		
		//Minestrapp Armor
		this.addRecipe(new ItemStack(MItems.tin_helmet, 1, 0), new ItemStack(MItems.tin_ingot, 3), new ItemStack(MItems.tin_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_helmet, 1, 0), new ItemStack(MItems.bronze_ingot, 3), new ItemStack(MItems.bronze_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_helmet, 1, 0), new ItemStack(MItems.steel_ingot, 3), new ItemStack(MItems.steel_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_helmet, 1, 0), new ItemStack(MItems.meurodite_gem, 3), new ItemStack(MItems.meurodite_gem, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_helmet, 1, 0), new ItemStack(MItems.torite_ingot, 3), new ItemStack(MItems.torite_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.blazium_helmet, 1, 0), new ItemStack(MItems.blazium_ingot, 3), new ItemStack(MItems.blazium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_helmet, 1, 0), new ItemStack(MItems.titanium_ingot, 3), new ItemStack(MItems.titanium_ingot, 2), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.tin_chestplate, 1, 0), new ItemStack(MItems.tin_ingot, 4), new ItemStack(MItems.tin_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_chestplate, 1, 0), new ItemStack(MItems.bronze_ingot, 4), new ItemStack(MItems.bronze_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_chestplate, 1, 0), new ItemStack(MItems.steel_ingot, 4), new ItemStack(MItems.steel_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_chestplate, 1, 0), new ItemStack(MItems.meurodite_gem, 4), new ItemStack(MItems.meurodite_gem, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_chestplate, 1, 0), new ItemStack(MItems.torite_ingot, 4), new ItemStack(MItems.torite_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.blazium_chestplate, 1, 0), new ItemStack(MItems.blazium_ingot, 4), new ItemStack(MItems.blazium_ingot, 4), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_chestplate, 1, 0), new ItemStack(MItems.titanium_ingot, 4), new ItemStack(MItems.titanium_ingot, 4), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.tin_leggings, 1, 0), new ItemStack(MItems.tin_ingot, 4), new ItemStack(MItems.tin_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_leggings, 1, 0), new ItemStack(MItems.bronze_ingot, 4), new ItemStack(MItems.bronze_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_leggings, 1, 0), new ItemStack(MItems.steel_ingot, 4), new ItemStack(MItems.steel_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_leggings, 1, 0), new ItemStack(MItems.meurodite_gem, 4), new ItemStack(MItems.meurodite_gem, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_leggings, 1, 0), new ItemStack(MItems.torite_ingot, 4), new ItemStack(MItems.torite_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.blazium_leggings, 1, 0), new ItemStack(MItems.blazium_ingot, 4), new ItemStack(MItems.blazium_ingot, 3), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_leggings, 1, 0), new ItemStack(MItems.titanium_ingot, 4), new ItemStack(MItems.titanium_ingot, 3), 0.1F);
		
		this.addRecipe(new ItemStack(MItems.tin_boots, 1, 0), new ItemStack(MItems.tin_ingot, 2), new ItemStack(MItems.tin_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.bronze_boots, 1, 0), new ItemStack(MItems.bronze_ingot, 2), new ItemStack(MItems.bronze_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.steel_boots, 1, 0), new ItemStack(MItems.steel_ingot, 2), new ItemStack(MItems.steel_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.meurodite_boots, 1, 0), new ItemStack(MItems.meurodite_gem, 2), new ItemStack(MItems.meurodite_gem, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.torite_boots, 1, 0), new ItemStack(MItems.torite_ingot, 2), new ItemStack(MItems.torite_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.blazium_boots, 1, 0), new ItemStack(MItems.blazium_ingot, 2), new ItemStack(MItems.blazium_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(MItems.titanium_boots, 1, 0), new ItemStack(MItems.titanium_ingot, 2), new ItemStack(MItems.titanium_ingot, 2), 0.1F);
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
}