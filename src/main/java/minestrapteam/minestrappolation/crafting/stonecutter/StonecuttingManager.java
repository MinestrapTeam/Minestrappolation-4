package minestrapteam.minestrappolation.crafting.stonecutter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import minestrapteam.minestrappolation.enumtypes.MStoneType;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class StonecuttingManager
{
	/** The static instance of this class */
	private static final StonecuttingManager	instance	= new StonecuttingManager();
	
	/** A list of all the recipes added */
	private List<ICuttingRecipes>				recipes		= new ArrayList();
	private boolean								listSorted;
	
	public static StonecuttingManager instance()
	{
		return instance;
	}
	
	private StonecuttingManager()
	{		
		//Chunk Items
		this.addShapelessRecipe(new ItemStack(MItems.chunks, 4, 0), null, new Object[] { new ItemStack(Blocks.cobblestone, 1, 0) });
		this.addShapelessRecipe(new ItemStack(MItems.chunks, 4, 1), null, new Object[] { new ItemStack(MBlocks.biome_cobble, 1, 1) });
		this.addShapelessRecipe(new ItemStack(MItems.chunks, 4, 2), null, new Object[] { new ItemStack(MBlocks.biome_cobble, 1, 3) });
		this.addShapelessRecipe(new ItemStack(MItems.chunks, 4, 3), null, new Object[] { new ItemStack(MBlocks.biome_cobble, 1, 5) });
		this.addShapelessRecipe(new ItemStack(MItems.chunks, 4, 4), null, new Object[] { new ItemStack(MBlocks.biome_cobble, 1, 7) });
		
		this.addRecipe(new ItemStack(Blocks.cobblestone, 1), null, new Object[] { "CC", "CC", 'C', new ItemStack(MItems.chunks, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 1), null, new Object[] { "CC", "CC", 'C', new ItemStack(MItems.chunks, 1, 1)});
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 3), null, new Object[] { "CC", "CC", 'C', new ItemStack(MItems.chunks, 1, 2)});
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 5), null, new Object[] { "CC", "CC", 'C', new ItemStack(MItems.chunks, 1, 3)});
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 7), null, new Object[] { "CC", "CC", 'C', new ItemStack(MItems.chunks, 1, 4)});
		
		//Brick Items
		this.addShapelessRecipe(new ItemStack(MItems.stone_brick, 4), null, new Object[] { new ItemStack(Blocks.stone, 1, 0) });
		this.addShapelessRecipe(new ItemStack(MItems.deepstone_brick, 4), null, new Object[] { new ItemStack(MBlocks.biome_stones, 1, 0) });
		this.addShapelessRecipe(new ItemStack(MItems.red_rock_brick, 4), null, new Object[] { new ItemStack(MBlocks.biome_stones, 1, 1) });
		this.addShapelessRecipe(new ItemStack(MItems.deep_red_rock_brick, 4), null, new Object[] { new ItemStack(MBlocks.biome_stones, 1, 2) });
		this.addShapelessRecipe(new ItemStack(MItems.coldstone_brick, 4), null, new Object[] { new ItemStack(MBlocks.biome_stones, 1, 3) });
		this.addShapelessRecipe(new ItemStack(MItems.deep_coldstone_brick, 4), null, new Object[] { new ItemStack(MBlocks.biome_stones, 1, 4) });
		this.addShapelessRecipe(new ItemStack(MItems.icestone_brick, 4), null, new Object[] { new ItemStack(MBlocks.biome_stones, 1, 5) });
		this.addShapelessRecipe(new ItemStack(MItems.glacierrock_brick, 4), null, new Object[] { new ItemStack(MBlocks.biome_stones, 1, 6) });
		this.addShapelessRecipe(new ItemStack(MItems.oceanstone_brick, 4), null, new Object[] { new ItemStack(MBlocks.biome_stones, 1, 7) });
		this.addShapelessRecipe(new ItemStack(MItems.pressurized_oceanstone_brick, 4), null, new Object[] { new ItemStack(MBlocks.biome_stones, 1, 8) });
		this.addShapelessRecipe(new ItemStack(MItems.slate_brick, 4), null, new Object[] { new ItemStack(MBlocks.slate, 1, 0) });
		this.addShapelessRecipe(new ItemStack(MItems.granite_brick, 4), null, new Object[] { new ItemStack(Blocks.stone, 1, 1) });
		this.addShapelessRecipe(new ItemStack(MItems.diorite_brick, 4), null, new Object[] { new ItemStack(Blocks.stone, 1, 3) });
		this.addShapelessRecipe(new ItemStack(MItems.andesite_brick, 4), null, new Object[] { new ItemStack(Blocks.stone, 1, 5) });
		this.addShapelessRecipe(new ItemStack(MItems.flint_brick, 4), null, new Object[] { new ItemStack(MBlocks.flint_block, 1, 0) });
		this.addShapelessRecipe(new ItemStack(Items.brick, 4), null, new Object[] { new ItemStack(Blocks.hardened_clay, 1, 0) });
		this.addShapelessRecipe(new ItemStack(MItems.obsidian_brick, 4), null, new Object[] { new ItemStack(Blocks.obsidian, 1, 0) });
		
		//Brick Blocks
		this.addRecipe(new ItemStack(Blocks.stonebrick, 1, 0), null, new Object[] { "BB", "BB", 'B', MItems.stone_brick });
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 0), null, new Object[] { "BB", "BB", 'B', MItems.deepstone_brick });
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 1), null, new Object[] { "BB", "BB", 'B', MItems.red_rock_brick });
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 2), null, new Object[] { "BB", "BB", 'B', MItems.deep_red_rock_brick });
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 3), null, new Object[] { "BB", "BB", 'B', MItems.coldstone_brick });
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 4), null, new Object[] { "BB", "BB", 'B', MItems.deep_coldstone_brick });
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 5), null, new Object[] { "BB", "BB", 'B', MItems.icestone_brick });
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 6), null, new Object[] { "BB", "BB", 'B', MItems.glacierrock_brick });
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 7), null, new Object[] { "BB", "BB", 'B', MItems.oceanstone_brick });
		this.addRecipe(new ItemStack(MBlocks.biome_bricks, 1, 8), null, new Object[] { "BB", "BB", 'B', MItems.pressurized_oceanstone_brick });
		this.addRecipe(new ItemStack(MBlocks.slate_bricks, 1, 0), null, new Object[] { "BB", "BB", 'B', MItems.slate_brick});
		this.addRecipe(new ItemStack(MBlocks.granite_bricks, 1, 0), null, new Object[] { "BB", "BB", 'B', MItems.granite_brick});
		this.addRecipe(new ItemStack(MBlocks.diorite_bricks, 1, 0), null, new Object[] { "BB", "BB", 'B', MItems.diorite_brick});
		this.addRecipe(new ItemStack(MBlocks.andesite_bricks, 1, 0), null, new Object[] { "BB", "BB", 'B', MItems.andesite_brick});
		this.addRecipe(new ItemStack(MBlocks.flint_bricks, 1, 0), null, new Object[] { "BB", "BB", 'B', MItems.flint_brick});
		this.addRecipe(new ItemStack(Blocks.prismarine, 1, 1), null, new Object[] { "BB", "BB", 'B', Items.prismarine_shard});
		this.addRecipe(new ItemStack(Blocks.brick_block, 1, 0), null, new Object[] { "BB", "BB", 'B', Items.brick});
		this.addRecipe(new ItemStack(Blocks.nether_brick, 1, 0), null, new Object[] { "BB", "BB", 'B', Items.netherbrick});
		this.addRecipe(new ItemStack(MBlocks.obsidian_bricks, 1), null, new Object[] { "BB", "BB", 'B', MItems.obsidian_brick});
		
		//Mossy Brick Blocks
		this.addRecipe(new ItemStack(Blocks.stonebrick, 9, 1), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stonebrick, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.mossy_bricks, 9, 0), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_bricks, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.mossy_bricks, 9, 1), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_bricks, 1, 1)});
		this.addRecipe(new ItemStack(MBlocks.mossy_bricks, 9, 2), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_bricks, 1, 2)});
		this.addRecipe(new ItemStack(MBlocks.mossy_bricks, 9, 3), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_bricks, 1, 3)});
		this.addRecipe(new ItemStack(MBlocks.mossy_bricks, 9, 4), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_bricks, 1, 4)});
		this.addRecipe(new ItemStack(MBlocks.mossy_bricks, 9, 5), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_bricks, 1, 5)});
		this.addRecipe(new ItemStack(MBlocks.mossy_bricks, 9, 6), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_bricks, 1, 6)});
		this.addRecipe(new ItemStack(MBlocks.mossy_bricks, 9, 7), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_bricks, 1, 7)});
		this.addRecipe(new ItemStack(MBlocks.mossy_bricks, 9, 8), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_bricks, 1, 8)});
		
		//Pattern Brick Blocks
		this.addRecipe(new ItemStack(MBlocks.stone_pattern_bricks, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.stone_brick });
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 2, 0), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.deepstone_brick });
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 2, 1), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.red_rock_brick });
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.deep_red_rock_brick });
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 2, 3), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.coldstone_brick });
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 2, 4), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.deep_coldstone_brick });
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 2, 5), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.icestone_brick });
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 2, 6), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.glacierrock_brick });
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 2, 7), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.oceanstone_brick });
		this.addRecipe(new ItemStack(MBlocks.pattern_bricks, 2, 8), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.pressurized_oceanstone_brick });
		this.addRecipe(new ItemStack(MBlocks.slate_pattern_bricks, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.slate_brick });
		this.addRecipe(new ItemStack(MBlocks.granite_pattern_bricks, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.granite_brick });
		this.addRecipe(new ItemStack(MBlocks.diorite_pattern_bricks, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.diorite_brick });
		this.addRecipe(new ItemStack(MBlocks.andesite_pattern_bricks, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.andesite_brick });
		this.addRecipe(new ItemStack(MBlocks.flint_pattern_bricks, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.flint_brick });
		
		//Mossy Cobblestone
		this.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 9), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', Blocks.cobblestone});
		this.addRecipe(new ItemStack(MBlocks.mossy, 9, 0), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_cobble, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.mossy, 9, 1), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_cobble, 1, 1)});
		this.addRecipe(new ItemStack(MBlocks.mossy, 9, 2), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_cobble, 1, 2)});
		this.addRecipe(new ItemStack(MBlocks.mossy, 9, 3), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_cobble, 1, 3)});
		this.addRecipe(new ItemStack(MBlocks.mossy, 9, 4), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_cobble, 1, 4)});
		this.addRecipe(new ItemStack(MBlocks.mossy, 9, 7), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_cobble, 1, 7)});
		this.addRecipe(new ItemStack(MBlocks.mossy, 9, 8), new ItemStack(MBlocks.moss), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_cobble, 1, 8)});
		
		//Refined Blocks
		this.addRecipe(new ItemStack(MBlocks.stone_refined, 9), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stone, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.stone, 9, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stone, 1, 1) });
		this.addRecipe(new ItemStack(Blocks.stone, 9, 4), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stone, 1, 3) });
		this.addRecipe(new ItemStack(Blocks.stone, 9, 6), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stone, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.slate_refined, 9, 0), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.slate, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.flint_refined, 9, 0), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.flint_block, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.sandstone, 9, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.sandstone, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.red_sandstone, 9, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.red_sandstone, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.refined, 9, 0), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_stones, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.refined, 9, 1), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_stones, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.refined, 9, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_stones, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.refined, 9, 3), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_stones, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.refined, 9, 4), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_stones, 1, 4) });
		this.addRecipe(new ItemStack(MBlocks.refined, 9, 5), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_stones, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.refined, 9, 6), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_stones, 1, 6) });
		this.addRecipe(new ItemStack(MBlocks.refined, 9, 7), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_stones, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.refined, 9, 8), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(MBlocks.biome_stones, 1, 8) });
		
		//Chiseled Blocks
		this.addRecipe(new ItemStack(Blocks.stonebrick, 1, 3), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.stone_slab, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.sandstone, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.stone_slab, 1, 1)});
		this.addRecipe(new ItemStack(Blocks.quartz_block, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.stone_slab, 1, 7)});
		this.addRecipe(new ItemStack(Blocks.red_sandstone, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.stone_slab2, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.desert_quartz_chiseled, 1), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.desert_quartz_slab, 1)});
		this.addRecipe(new ItemStack(MBlocks.radiant_chiseled, 1), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.radiant_slab, 1)});
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 0), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.deepstone_slab, 1)});
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.red_rock_slab, 1)});
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 2), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.deep_red_rock_slab, 1)});
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 3), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.coldstone_slab, 1)});
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 4), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.deep_coldstone_slab, 1)});
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 5), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.icestone_slab, 1)});
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 6), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.glacierrock_slab, 1)});
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 7), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.oceanstone_slab, 1)});
		this.addRecipe(new ItemStack(MBlocks.chiseled, 1, 8), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.poceanstone_slab, 1)});
		
		//Tiles
		this.addRecipe(new ItemStack(MBlocks.stone_tiles, 4), null, new Object[] { "BB", "BB", 'B', MBlocks.stone_refined });
		this.addRecipe(new ItemStack(MBlocks.tiles, 4, 0), null, new Object[] { "BB", "BB", 'B', new ItemStack(MBlocks.refined, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.tiles, 4, 1), null, new Object[] { "BB", "BB", 'B', new ItemStack(MBlocks.refined, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.tiles, 4, 2), null, new Object[] { "BB", "BB", 'B', new ItemStack(MBlocks.refined, 1, 2) });
		this.addRecipe(new ItemStack(MBlocks.tiles, 4, 3), null, new Object[] { "BB", "BB", 'B', new ItemStack(MBlocks.refined, 1, 3) });
		this.addRecipe(new ItemStack(MBlocks.tiles, 4, 4), null, new Object[] { "BB", "BB", 'B', new ItemStack(MBlocks.refined, 1, 4) });
		this.addRecipe(new ItemStack(MBlocks.tiles, 4, 5), null, new Object[] { "BB", "BB", 'B', new ItemStack(MBlocks.refined, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.tiles, 4, 6), null, new Object[] { "BB", "BB", 'B', new ItemStack(MBlocks.refined, 1, 6) });
		this.addRecipe(new ItemStack(MBlocks.tiles, 4, 7), null, new Object[] { "BB", "BB", 'B', new ItemStack(MBlocks.refined, 1, 7) });
		this.addRecipe(new ItemStack(MBlocks.tiles, 4, 8), null, new Object[] { "BB", "BB", 'B', new ItemStack(MBlocks.refined, 1, 8) });
		this.addRecipe(new ItemStack(MBlocks.flint_tiles, 4, 0), null, new Object[] { "BB", "BB", 'B', new ItemStack(MBlocks.flint_refined, 1, 0) });
		
		//Pillars
		this.addRecipe(new ItemStack(Blocks.quartz_block, 2, 2), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.quartz_block, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.desert_quartz_block, 2), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.desert_quartz_block, 1)});
		this.addRecipe(new ItemStack(MBlocks.radiant_pillar, 2), null, new Object[] { "S", "S", 'S', new ItemStack(MBlocks.radiant_block, 1)});
		
		//Lamps
		this.addRecipe(new ItemStack(MBlocks.stone_lamp_glowstone, 4), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(Blocks.stonebrick, 1, 3), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.lamp_glowstone, 4, 0), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 0), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.lamp_glowstone, 4, 1), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 1), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.lamp_glowstone, 4, 2), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 2), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.lamp_glowstone, 4, 3), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 3), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.lamp_glowstone, 4, 4), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 4), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.lamp_glowstone, 4, 5), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 5), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.lamp_glowstone, 4, 6), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 6), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.lamp_glowstone, 4, 7), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 7), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.lamp_glowstone, 4, 8), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 8), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.flint_lamp_glowstone, 4, 0), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.flint_chiseled, 1, 0), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.stone_lamp_sunstone, 4), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(Blocks.stonebrick, 1, 3), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.lamp_sunstone, 4, 0), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 0), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.lamp_sunstone, 4, 1), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 1), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.lamp_sunstone, 4, 2), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 2), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.lamp_sunstone, 4, 3), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 3), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.lamp_sunstone, 4, 4), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 4), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.lamp_sunstone, 4, 5), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 5), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.lamp_sunstone, 4, 6), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 6), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.lamp_sunstone, 4, 7), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 7), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.lamp_sunstone, 4, 8), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 8), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.flint_lamp_sunstone, 4, 0), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.flint_chiseled, 1, 0), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.stone_lamp_prismarine, 4), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(Blocks.stonebrick, 1, 3), 'G', Blocks.sea_lantern });
		this.addRecipe(new ItemStack(MBlocks.lamp_prismarine, 4, 0), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 0), 'G', Blocks.sea_lantern });
		this.addRecipe(new ItemStack(MBlocks.lamp_prismarine, 4, 1), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 1), 'G', Blocks.sea_lantern });
		this.addRecipe(new ItemStack(MBlocks.lamp_prismarine, 4, 2), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 2), 'G', Blocks.sea_lantern });
		this.addRecipe(new ItemStack(MBlocks.lamp_prismarine, 4, 3), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 3), 'G', Blocks.sea_lantern });
		this.addRecipe(new ItemStack(MBlocks.lamp_prismarine, 4, 4), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 4), 'G', Blocks.sea_lantern });
		this.addRecipe(new ItemStack(MBlocks.lamp_prismarine, 4, 5), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 5), 'G', Blocks.sea_lantern });
		this.addRecipe(new ItemStack(MBlocks.lamp_prismarine, 4, 6), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 6), 'G', Blocks.sea_lantern });
		this.addRecipe(new ItemStack(MBlocks.lamp_prismarine, 4, 7), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 7), 'G', Blocks.sea_lantern });
		this.addRecipe(new ItemStack(MBlocks.lamp_prismarine, 4, 8), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.chiseled, 1, 8), 'G', Blocks.sea_lantern });
		this.addRecipe(new ItemStack(MBlocks.flint_lamp_prismarine, 4, 0), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(MBlocks.flint_chiseled, 1, 0), 'G', Blocks.sea_lantern });
		
		//Slabs
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 0), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stone, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 1), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.cobblestone, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 4), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.brick_block, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 5), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stonebrick, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.nether_brick, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 7), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab2, 6, 0), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.red_sandstone, 1, 0)});
		
		this.addRecipe(new ItemStack(MBlocks.desert_quartz_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.desert_quartz_block, 1)});
		this.addRecipe(new ItemStack(MBlocks.radiant_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.radiant_block, 1)});
		
		this.addRecipe(new ItemStack(MBlocks.deepstone_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_stones, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.red_rock_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_stones, 1, 1)});
		this.addRecipe(new ItemStack(MBlocks.deep_red_rock_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_stones, 1, 2)});
		this.addRecipe(new ItemStack(MBlocks.coldstone_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_stones, 1, 3)});
		this.addRecipe(new ItemStack(MBlocks.deep_coldstone_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_stones, 1, 4)});
		this.addRecipe(new ItemStack(MBlocks.icestone_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_stones, 1, 5)});
		this.addRecipe(new ItemStack(MBlocks.glacierrock_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_stones, 1, 6)});
		this.addRecipe(new ItemStack(MBlocks.oceanstone_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_stones, 1, 7)});
		this.addRecipe(new ItemStack(MBlocks.poceanstone_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_stones, 1, 8)});
		
		this.addRecipe(new ItemStack(MBlocks.deepstone_cobble_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.red_rock_cobble_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 1)});
		this.addRecipe(new ItemStack(MBlocks.deep_red_rock_cobble_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 2)});
		this.addRecipe(new ItemStack(MBlocks.coldstone_cobble_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 3)});
		this.addRecipe(new ItemStack(MBlocks.deep_coldstone_cobble_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 4)});
		this.addRecipe(new ItemStack(MBlocks.icestone_cobble_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 5)});
		this.addRecipe(new ItemStack(MBlocks.glacierrock_cobble_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 6)});
		this.addRecipe(new ItemStack(MBlocks.oceanstone_cobble_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 7)});
		this.addRecipe(new ItemStack(MBlocks.poceanstone_cobble_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 8)});
		
		this.addRecipe(new ItemStack(MBlocks.deepstone_brick_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.red_rock_brick_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 1)});
		this.addRecipe(new ItemStack(MBlocks.deep_red_rock_brick_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 2)});
		this.addRecipe(new ItemStack(MBlocks.coldstone_brick_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 3)});
		this.addRecipe(new ItemStack(MBlocks.deep_coldstone_brick_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 4)});
		this.addRecipe(new ItemStack(MBlocks.icestone_brick_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 5)});
		this.addRecipe(new ItemStack(MBlocks.glacierrock_brick_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 6)});
		this.addRecipe(new ItemStack(MBlocks.oceanstone_brick_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 7)});
		this.addRecipe(new ItemStack(MBlocks.poceanstone_brick_slab, 6), null, new Object[] { "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 8)});
		
		//Stairs
		this.addRecipe(new ItemStack(Blocks.stone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.cobblestone, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.brick_block, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.stonebrick, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.nether_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.nether_brick, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.sandstone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.quartz_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.red_sandstone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.red_sandstone, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.desert_quartz_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.desert_quartz_block, 1)});
		this.addRecipe(new ItemStack(MBlocks.radiant_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.radiant_block, 1)});
		this.addRecipe(new ItemStack(MBlocks.deepstone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.coldstone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 3)});
		this.addRecipe(new ItemStack(MBlocks.deep_coldstone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 4)});
		this.addRecipe(new ItemStack(MBlocks.redrock_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 1)});
		this.addRecipe(new ItemStack(MBlocks.deep_redrock_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 2)});
		this.addRecipe(new ItemStack(MBlocks.icestone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 5)});
		this.addRecipe(new ItemStack(MBlocks.glacierstone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 6)});
		this.addRecipe(new ItemStack(MBlocks.oceanstone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 7)});
		this.addRecipe(new ItemStack(MBlocks.poceanstone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_cobble, 1, 8)});
		this.addRecipe(new ItemStack(MBlocks.deepstone_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.coldstone_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 3)});
		this.addRecipe(new ItemStack(MBlocks.deep_coldstone_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 4)});
		this.addRecipe(new ItemStack(MBlocks.redrock_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 1)});
		this.addRecipe(new ItemStack(MBlocks.deep_redrock_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 2)});
		this.addRecipe(new ItemStack(MBlocks.icestone_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 5)});
		this.addRecipe(new ItemStack(MBlocks.glacierstone_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 6)});
		this.addRecipe(new ItemStack(MBlocks.oceanstone_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 7)});
		this.addRecipe(new ItemStack(MBlocks.poceanstone_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(MBlocks.biome_bricks, 1, 8)});
		
		//Walls, Fences, etc
		this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 2, 0), null, new Object[] { "CCC", "CCC", 'C', new ItemStack(MItems.chunks, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 2, 1), new ItemStack(MBlocks.moss), new Object[] { "CCC", "CCC", 'C', new ItemStack(MItems.chunks, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.nether_brick_fence, 2, 0), null, new Object[] { "BBB", "BBB", 'B', new ItemStack(Items.netherbrick, 1)});
		
		//Dying
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 0), new ItemStack(Items.dye, 1, 15), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 1), new ItemStack(Items.dye, 1, 14), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 2), new ItemStack(Items.dye, 1, 13), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 3), new ItemStack(Items.dye, 1, 12), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 4), new ItemStack(Items.dye, 1, 11), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 5), new ItemStack(Items.dye, 1, 10), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 6), new ItemStack(Items.dye, 1, 9), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 7), new ItemStack(Items.dye, 1, 8), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 8), new ItemStack(Items.dye, 1, 7), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 9), new ItemStack(Items.dye, 1, 6), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 10), new ItemStack(Items.dye, 1, 5), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 11), new ItemStack(Items.dye, 1, 4), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 12), new ItemStack(Items.dye, 1, 3), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 13), new ItemStack(Items.dye, 1, 2), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 14), new ItemStack(Items.dye, 1, 1), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 9, 15), new ItemStack(Items.dye, 1, 0), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.hardened_clay, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.prismarine, 9, 2), new ItemStack(Items.dye, 1, 0), new Object[] { "SSS", "SSS", "SSS", 'S', new ItemStack(Blocks.prismarine, 1, 0)});
		
		//Roads
		this.addRecipe(new ItemStack(MBlocks.roads, 3, 0), null, new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(MItems.chunks, 1, 0), 'D', new ItemStack(Blocks.dirt, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.roads, 3, 1), null, new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(MItems.chunks, 1, 1), 'D', new ItemStack(Blocks.sand, 1, 1)});
		this.addRecipe(new ItemStack(MBlocks.roads, 3, 2), null, new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(MItems.chunks, 1, 2), 'D', new ItemStack(Blocks.gravel, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.roads, 3, 3), null, new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(MItems.chunks, 1, 3), 'D', new ItemStack(MBlocks.dirt_permafrost, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.roads, 3, 4), null, new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(MItems.chunks, 1, 4), 'D', new ItemStack(Blocks.sand, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.roads, 6, 5), null, new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(Blocks.netherrack), 'D', new ItemStack(Blocks.soul_sand, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.roads, 1, 6), new ItemStack(MItems.steel_plating, 1), new Object[] { "CCC", "CCC", "DDD", 'C', new ItemStack(Items.netherbrick), 'D', new ItemStack(MBlocks.soul_ore)});
		
		//Misc
		this.addRecipe(new ItemStack(MItems.tin_plating, 1), null, new Object[] { "III", "III", 'I', MItems.tin_ingot});
		this.addRecipe(new ItemStack(MItems.steel_plating, 1), null, new Object[] { "III", "III", 'I', MItems.steel_ingot});
		this.addRecipe(new ItemStack(MItems.meurodite_plating, 1), null, new Object[] { "III", "III", 'I', MItems.meurodite_gem});
	}
	
	public ShapedCuttingRecipe addRecipe(ItemStack output, ItemStack extraSlot, Object... data)
	{
		ShapedCuttingRecipe recipe = new ShapedCuttingRecipe(output, extraSlot, data);
		this.recipes.add(recipe);
		this.listSorted = false;
		return recipe;
	}
	
	public ShapelessCuttingRecipe addShapelessRecipe(ItemStack stack, ItemStack extra, Object... data)
	{
		ShapelessCuttingRecipe recipe = new ShapelessCuttingRecipe(stack, extra, data);
		this.recipes.add(recipe);
		return recipe;
	}
	
	public ItemStack findMatchingRecipe(InventoryCrafting inventory, ItemStack extra, World world)
	{
		for (ICuttingRecipes recipe : this.getRecipeList())
		{
			if (recipe.matches(inventory, extra, world))
				return recipe.getCraftingResult(inventory, extra);
		}
		
		return null;
	}
	
	public List<ICuttingRecipes> getRecipeList()
	{
		if (!this.listSorted)
		{
			Collections.sort(this.recipes, new Comparator<ICuttingRecipes>()
			{
				@Override
				public int compare(ICuttingRecipes recipe1, ICuttingRecipes recipe2)
				{
					boolean flag1 = recipe1 instanceof ShapedCuttingRecipe;
					boolean flag2 = recipe1 instanceof ShapelessCuttingRecipe;
					boolean flag3 = recipe2 instanceof ShapedCuttingRecipe;
					boolean flag4 = recipe2 instanceof ShapelessCuttingRecipe;
					return flag2 && flag3 ? 1 : flag4 && flag1 ? -1 : recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0;
				}
			});
			
			this.listSorted = true;
		}
		
		return this.recipes;
	}
}
