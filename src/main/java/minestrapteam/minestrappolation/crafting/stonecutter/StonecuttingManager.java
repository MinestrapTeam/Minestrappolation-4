package minestrapteam.minestrappolation.crafting.stonecutter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import minestrapteam.minestrappolation.enumtypes.MStoneType;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
		this.addRecipe(new ItemStack(MItems.deepstone_brick, 4, 0), null, new Object[] { "S", 'S', new ItemStack(MBlocks.biome_stones, 1, MStoneType.DEEPSTONE.getMetadata()) });
		this.addRecipe(new ItemStack(MItems.coldstone_brick, 4, 0), new ItemStack(MItems.copper_ingot, 1, 0), new Object[] { "S", 'S', new ItemStack(MBlocks.biome_stones, 1, MStoneType.COLDSTONE.getMetadata()) });
		this.addRecipe(new ItemStack(Blocks.cobblestone, 1), null, new Object[] { "SS", "SS", 'S', MItems.icestone_brick });
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
