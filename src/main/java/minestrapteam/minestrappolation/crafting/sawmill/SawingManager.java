package minestrapteam.minestrappolation.crafting.sawmill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
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
		this.addRecipe(new ItemStack(Blocks.chest, 1), new Object[] { "###", "# #", "###", '#', "plankWood" });
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
			{
				return recipe.getCraftingResult(inventory);
			}
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