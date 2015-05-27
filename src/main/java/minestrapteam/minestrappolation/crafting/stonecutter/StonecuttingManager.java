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
		this.addShapelessRecipe(new ItemStack(Items.brick, 4), null, new Object[] { new ItemStack(Blocks.hardened_clay, 1, 0) });
		
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
		this.addRecipe(new ItemStack(Blocks.prismarine, 1, 1), null, new Object[] { "BB", "BB", 'B', Items.prismarine_shard});
		this.addRecipe(new ItemStack(Blocks.brick_block, 1, 0), null, new Object[] { "BB", "BB", 'B', Items.brick});
		
		//Mossy Brick Blocks
		this.addRecipe(new ItemStack(Blocks.stonebrick, 9, 1), new ItemStack(Blocks.vine), new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stonebrick, 1, 0)});
		
		//Pattern Brick Blocks
		this.addRecipe(new ItemStack(MBlocks.stone_pattern_bricks, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', MItems.stone_brick });
		
		//Mossy Cobblestone
		this.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 9), new ItemStack(Blocks.vine), new Object[] { "BBB", "BBB", "BBB", 'B', Blocks.cobblestone});
		
		//Refined Blocks
		this.addRecipe(new ItemStack(MBlocks.stone_refined, 9), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stone, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.stone, 9, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stone, 1, 1) });
		this.addRecipe(new ItemStack(Blocks.stone, 9, 4), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stone, 1, 3) });
		this.addRecipe(new ItemStack(Blocks.stone, 9, 6), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.stone, 1, 5) });
		this.addRecipe(new ItemStack(Blocks.sandstone, 9, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.sandstone, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.red_sandstone, 9, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', new ItemStack(Blocks.red_sandstone, 1, 0) });
		
		//Chiseled Blocks
		this.addRecipe(new ItemStack(Blocks.stonebrick, 1, 3), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.stone_slab, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.sandstone, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.stone_slab, 1, 1)});
		this.addRecipe(new ItemStack(Blocks.quartz_block, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.stone_slab, 1, 7)});
		this.addRecipe(new ItemStack(Blocks.red_sandstone, 1, 1), null, new Object[] { "S", "S", 'S', new ItemStack(Blocks.stone_slab2, 1, 0)});
		
		//Tiles
		this.addRecipe(new ItemStack(MBlocks.stone_tiles, 4), null, new Object[] { "BB", "BB", 'B', MBlocks.stone_refined });
		
		//Lamps
		this.addRecipe(new ItemStack(MBlocks.stone_lamp_glowstone, 4), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(Blocks.stonebrick, 1, 3), 'G', Blocks.glowstone });
		this.addRecipe(new ItemStack(MBlocks.stone_lamp_sunstone, 4), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(Blocks.stonebrick, 1, 3), 'G', MBlocks.sunstone_block });
		this.addRecipe(new ItemStack(MBlocks.stone_lamp_prismarine, 4), null, new Object[] { " S ", "SGS", " S ", 'S', new ItemStack(Blocks.stonebrick, 1, 3), 'G', Blocks.sea_lantern });
		
		//Slabs
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 0), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stone, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 1), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 3), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.cobblestone, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 4), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.brick_block, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 5), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.stonebrick, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 6), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.nether_brick, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 7), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_slab2, 6, 0), null, new Object[] { "SSS", 'S', new ItemStack(Blocks.red_sandstone, 1, 0)});
		
		//Stairs
		this.addRecipe(new ItemStack(Blocks.stone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.cobblestone, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.brick_block, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.stone_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.stonebrick, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.nether_brick_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.nether_brick, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.sandstone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.sandstone, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.quartz_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.quartz_block, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.red_sandstone_stairs, 4, 0), null, new Object[] { "  S", " SS", "SSS", 'S', new ItemStack(Blocks.red_sandstone, 1, 0)});
		
		//Walls, Fences, etc
		this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 2, 0), null, new Object[] { "CCC", "CCC", 'C', new ItemStack(MItems.chunks, 1, 0)});
		this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 2, 0), new ItemStack(Blocks.vine), new Object[] { "CCC", "CCC", 'C', new ItemStack(MItems.chunks, 1, 0)});
		
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
		
		//Misc
		this.addRecipe(new ItemStack(MItems.tin_plating, 1), null, new Object[] { "III", "III", 'I', MItems.tin_ingot});
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
