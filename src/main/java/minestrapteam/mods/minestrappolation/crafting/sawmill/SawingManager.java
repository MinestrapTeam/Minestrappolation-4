package minestrapteam.mods.minestrappolation.crafting.sawmill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class SawingManager
{
	/** The static instance of this class */
	public static final SawingManager	instance	= new SawingManager();
	
	/** A list of all the recipes added */
	private List<IRecipe>				recipes		= new ArrayList();
	private boolean						listSorted;
	
	private SawingManager()
	{
		//Vanilla Alternate Recipes
		this.addRecipe(new ItemStack(Blocks.crafting_table, 1, 0), new Object[] { "WW", "WW", 'W', "plankWood" });
		this.addRecipe(new ItemStack(Items.stick, 6), new Object[] { "W", "W", 'W', "plankWood", 'S', "stickWood"});
		this.addRecipe(new ItemStack(Blocks.ladder, 3), new Object[] { "S S", "SSS", "S S", 'S', "stickWood"});
		this.addRecipe(new ItemStack(Blocks.torch, 4), new Object[] { "C", "S", 'C', Items.coal, 'S', "stickWood"});
		this.addRecipe(new ItemStack(Items.bowl, 6), new Object[] { "W W", " W ", 'W', "plankWood" });
		this.addRecipe(new ItemStack(Blocks.wooden_button, 1), new Object[]{ "W", 'W', "plankWood" });
		this.addRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), new Object[] { "WW", 'W', "plankWood" });
		
		this.addRecipe(new ItemStack(Blocks.planks, 6, 0), new Object[] { "L", 'L', new ItemStack(Blocks.log, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.planks, 6, 1), new Object[] { "L", 'L', new ItemStack(Blocks.log, 1, 1) });
		this.addRecipe(new ItemStack(Blocks.planks, 6, 2), new Object[] { "L", 'L', new ItemStack(Blocks.log, 1, 2) });
		this.addRecipe(new ItemStack(Blocks.planks, 6, 3), new Object[] { "L", 'L', new ItemStack(Blocks.log, 1, 3) });
		this.addRecipe(new ItemStack(Blocks.planks, 6, 4), new Object[] { "L", 'L', new ItemStack(Blocks.log2, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.planks, 6, 5), new Object[] { "L", 'L', new ItemStack(Blocks.log2, 1, 1) });
		this.addRecipe(new ItemStack(MBlocks.ministrapp_planks, 6, 0), new Object[] { "L", 'L', new ItemStack(MBlocks.ministrapp_log, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.ministrapp_planks, 6, 1), new Object[] { "L", 'L', new ItemStack(MBlocks.ministrapp_log, 1, 1) });
		
		this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 0), new Object[] { "WWW", 'W', new ItemStack(Blocks.planks, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 1), new Object[] { "WWW", 'W', new ItemStack(Blocks.planks, 1, 1) });
		this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 2), new Object[] { "WWW", 'W', new ItemStack(Blocks.planks, 1, 2) });
		this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 3), new Object[] { "WWW", 'W', new ItemStack(Blocks.planks, 1, 3) });
		this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 4), new Object[] { "WWW", 'W', new ItemStack(Blocks.planks, 1, 4) });
		this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 5), new Object[] { "WWW", 'W', new ItemStack(Blocks.planks, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.redwood_slab, 6), new Object[] { "WWW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 0)});
		this.addRecipe(new ItemStack(MBlocks.frozen_oak_slab, 6), new Object[] { "WWW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 1)});
		
		this.addRecipe(new ItemStack(Blocks.oak_stairs, 4, 0), new Object[] { "  W", " WW", "WWW", 'W', new ItemStack(Blocks.planks, 1, 0) });
		this.addRecipe(new ItemStack(Blocks.spruce_stairs, 4, 0), new Object[] { "  W", " WW", "WWW", 'W', new ItemStack(Blocks.planks, 1, 1) });
		this.addRecipe(new ItemStack(Blocks.birch_stairs, 4, 0), new Object[] { "  W", " WW", "WWW", 'W', new ItemStack(Blocks.planks, 1, 2) });
		this.addRecipe(new ItemStack(Blocks.jungle_stairs, 4, 0), new Object[] { "  W", " WW", "WWW", 'W', new ItemStack(Blocks.planks, 1, 3) });
		this.addRecipe(new ItemStack(Blocks.acacia_stairs, 4, 0), new Object[] { "  W", " WW", "WWW", 'W', new ItemStack(Blocks.planks, 1, 4) });
		this.addRecipe(new ItemStack(Blocks.dark_oak_stairs, 4, 0), new Object[] { "  W", " WW", "WWW", 'W', new ItemStack(Blocks.planks, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.redwood_stairs, 4, 0), new Object[] { "  W", " WW", "WWW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.frozen_oak_stairs, 4, 0), new Object[] { "  W", " WW", "WWW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 1) });
		
		//Vanilla Replacement Recipes
		this.addRecipe(new ItemStack(Blocks.bookshelf, 1), new Object[] { "WWW", "BBB", "WWW", 'W', "plankWood", 'B', Items.book });
		this.addRecipe(new ItemStack(Items.bed, 1), new Object[] { "WWW", "PPP", 'W', Blocks.wool, 'P', "plankWood" });
		this.addRecipe(new ItemStack(Blocks.oak_fence, 4), new Object[] { "WSW", "WSW", 'W', new ItemStack(Blocks.planks, 1, 0), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Blocks.spruce_fence, 4), new Object[] { "WSW", "WSW", 'W', new ItemStack(Blocks.planks, 1, 1), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Blocks.birch_fence, 4), new Object[] { "WSW", "WSW", 'W', new ItemStack(Blocks.planks, 1, 2), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Blocks.jungle_fence, 4), new Object[] { "WSW", "WSW", 'W', new ItemStack(Blocks.planks, 1, 3), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Blocks.acacia_fence, 4), new Object[] { "WSW", "WSW", 'W', new ItemStack(Blocks.planks, 1, 4), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Blocks.dark_oak_fence, 4), new Object[] { "WSW", "WSW", 'W', new ItemStack(Blocks.planks, 1, 5), 'S', "stickWood" });
		this.addRecipe(new ItemStack(MBlocks.redwood_fence, 4), new Object[] { "WSW", "WSW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 0), 'S', "stickWood" });
		this.addRecipe(new ItemStack(MBlocks.frozen_oak_fence, 4), new Object[] { "WSW", "WSW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 1), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Blocks.oak_fence_gate, 1), new Object[] { "SWS", "SWS", 'W', new ItemStack(Blocks.planks, 1, 0), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Blocks.spruce_fence_gate, 1), new Object[] { "SWS", "SWS", 'W', new ItemStack(Blocks.planks, 1, 1), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Blocks.birch_fence_gate, 1), new Object[] { "SWS", "SWS", 'W', new ItemStack(Blocks.planks, 1, 2), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Blocks.jungle_fence_gate, 1), new Object[] { "SWS", "SWS", 'W', new ItemStack(Blocks.planks, 1, 3), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Blocks.acacia_fence_gate, 1), new Object[] { "SWS", "SWS", 'W', new ItemStack(Blocks.planks, 1, 4), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Blocks.dark_oak_fence_gate, 1), new Object[] { "SWS", "SWS", 'W', new ItemStack(Blocks.planks, 1, 5), 'S', "stickWood" });
		this.addRecipe(new ItemStack(MBlocks.redwood_fence_gate, 1), new Object[] { "SWS", "SWS", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 0), 'S', "stickWood" });
		this.addRecipe(new ItemStack(MBlocks.frozen_oak_fence_gate, 1), new Object[] { "SWS", "SWS", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 1), 'S', "stickWood" });
		this.addRecipe(new ItemStack(Items.oak_door, 3), new Object[] { "WW", "WW", "WW", 'W', new ItemStack(Blocks.planks, 1, 0) });
		this.addRecipe(new ItemStack(Items.spruce_door, 3), new Object[] { "WW", "WW", "WW", 'W', new ItemStack(Blocks.planks, 1, 1) });
		this.addRecipe(new ItemStack(Items.birch_door, 3), new Object[] { "WW", "WW", "WW", 'W', new ItemStack(Blocks.planks, 1, 2) });
		this.addRecipe(new ItemStack(Items.jungle_door, 3), new Object[] { "WW", "WW", "WW", 'W', new ItemStack(Blocks.planks, 1, 3) });
		this.addRecipe(new ItemStack(Items.acacia_door, 3), new Object[] { "WW", "WW", "WW", 'W', new ItemStack(Blocks.planks, 1, 4) });
		this.addRecipe(new ItemStack(Items.dark_oak_door, 3), new Object[] { "WW", "WW", "WW", 'W', new ItemStack(Blocks.planks, 1, 5) });
		this.addRecipe(new ItemStack(MBlocks.redwood_door_item, 3), new Object[] { "WW", "WW", "WW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 0) });
		this.addRecipe(new ItemStack(MBlocks.frozen_door_item, 3), new Object[] { "WW", "WW", "WW", 'W', new ItemStack(MBlocks.ministrapp_planks, 1, 1) });
		this.addRecipe(new ItemStack(Blocks.trapdoor, 2), new Object[] { "WWW", "WWW", 'W', "plankWood" });
		this.addRecipe(new ItemStack(Blocks.chest, 1, 0), new Object[] { "WWW", "W W", "WWW", 'W', "plankWood" });
		this.addRecipe(new ItemStack(Blocks.jukebox, 1), new Object[] { "WWW", "WDW", "WWW", 'W', "plankWood", 'D', Items.diamond});
		this.addRecipe(new ItemStack(Blocks.noteblock, 1), new Object[] { "WWW", "WRW", "WWW", 'W', "plankWood", 'R', Items.redstone});
		this.addRecipe(new ItemStack(Items.sign, 3, 0), new Object[] { "WWW", "WWW", " S ", 'W', "plankWood", 'S', "stickWood" });
		this.addRecipe(new ItemStack(Items.item_frame, 1, 0), new Object[] { "SSS", "SLS", "SSS", 'S', "stickWood", 'L', Items.leather });
		this.addRecipe(new ItemStack(Items.painting, 1, 0), new Object[] { "SSS", "SWS", "SSS", 'W', Blocks.wool, 'S', "stickWood" });
		this.addRecipe(new ItemStack(Items.armor_stand, 1, 0), new Object[] { "SSS", " S ", "SHS", 'H', "slabSmoothStone", 'S', "stickWood" });
		
		//Minestrapp Alternate Recipes
		this.addRecipe(new ItemStack(MBlocks.crate, 1), new Object[] { "WWW", "SSS", "WWW", 'W', "plankWood", 'S', "stickWood" });
		this.addRecipe(new ItemStack(MItems.reinforced_stick, 8), new Object[] { "SSS", "STS", "SSS", 'S', "stickWood", 'T', MItems.tin_plating});
		this.addRecipe(new ItemStack(MBlocks.magnetic_torch, 6), new Object[] {"C", "S", "R", 'C', Items.coal, 'S', "stickWood", 'R', Items.redstone});
		
		//Minestrapp Carpenters Bench Recipes
		this.addRecipe(new ItemStack(MBlocks.barrel, 1), new Object[] { "WTW", "W W", "WTW", 'W', "plankWood", 'T', "ingotTin" });
	}
	
	public ShapedOreRecipe addRecipe(ItemStack output, Object... data)
	{
		ShapedOreRecipe recipe = new ShapedOreRecipe(output, data);
		this.recipes.add(recipe);
		this.listSorted = false;
		return recipe;
	}
	
	public ShapelessOreRecipe addShapelessRecipe(ItemStack stack, Object... data)
	{
		ShapelessOreRecipe recipe = new ShapelessOreRecipe(stack, data);
		this.recipes.add(recipe);
		this.listSorted = false;
		return recipe;
	}
	
	public ItemStack findMatchingRecipe(InventoryCrafting inventory, World world)
	{
		for (IRecipe recipe : this.getRecipeList())
		{
			if (recipe.matches(inventory, world))
				return recipe.getCraftingResult(inventory);
		}
		
		return null;
	}
	
	public List<IRecipe> getRecipeList()
	{
		if (!this.listSorted)
		{
			Collections.sort(this.recipes, new Comparator<IRecipe>()
			{
				@Override
				public int compare(IRecipe recipe1, IRecipe recipe2)
				{
					boolean flag1 = recipe1 instanceof ShapedRecipes;
					boolean flag2 = recipe1 instanceof ShapelessRecipes;
					boolean flag3 = recipe2 instanceof ShapedRecipes;
					boolean flag4 = recipe2 instanceof ShapelessRecipes;
					return flag2 && flag3 ? 1 : flag4 && flag1 ? -1 : recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0;
				}
			});
			
			this.listSorted = true;
		}
		
		return this.recipes;
	}
}