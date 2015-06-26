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
		this.addRecipe(new ItemStack(Items.repeater, 1), new ItemStack(Blocks.stone, 3), new ItemStack(Blocks.redstone_torch, 2), 0.1F);
		
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
		
		//Vanilla Tools
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
		
		this.addRecipe(new ItemStack(Items.wooden_sword, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.planks, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.stone_sword, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Blocks.cobblestone, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.iron_sword, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.iron_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.golden_sword, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.gold_ingot, 2), 0.1F);
		this.addRecipe(new ItemStack(Items.diamond_sword, 1, 0), new ItemStack(Items.stick, 2), new ItemStack(Items.diamond, 2), 0.1F);
		
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