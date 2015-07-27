package minestrapteam.mods.minestrappolation.nei.handler;

import codechicken.nei.recipe.ShapelessRecipeHandler;
import minestrapteam.mods.minestrappolation.crafting.sawmill.SawingManager;
import minestrapteam.mods.minestrappolation.inventory.gui.GuiSawmill;
import minestrapteam.mods.minestrappolation.util.MStacks;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ShapelessSawingHandler extends ShapelessRecipeHandler
{
	@Override
	public String getRecipeName()
	{
		return StatCollector.translateToLocal("recipe.sawmill.shapeless");
	}
	
	@Override
	public Class<? extends GuiContainer> getGuiClass()
	{
		return GuiSawmill.class;
	}
	
	@Override
	public boolean hasOverlay(GuiContainer gui, Container container, int recipe)
	{
		return false;
	}
	
	@Override
	public void loadCraftingRecipes(String outputId, Object... results)
	{
		if ("sawmill".equals(outputId))
		{
			for (IRecipe irecipe : SawingManager.instance.getRecipeList())
			{
				CachedShapelessRecipe recipe = null;
				if (irecipe instanceof ShapelessRecipes)
				{
					recipe = this.shapelessRecipe((ShapelessRecipes) irecipe);
				}
				else if (irecipe instanceof ShapelessOreRecipe)
				{
					recipe = this.forgeShapelessRecipe((ShapelessOreRecipe) irecipe);
				}
				
				if (recipe == null)
				{
					continue;
				}
				
				this.arecipes.add(recipe);
			}
		}
		else
		{
			super.loadCraftingRecipes(outputId, results);
		}
	}
	
	@Override
	public void loadCraftingRecipes(ItemStack result)
	{
		for (IRecipe irecipe : SawingManager.instance.getRecipeList())
		{
			if (MStacks.itemEquals(irecipe.getRecipeOutput(), result))
			{
				CachedShapelessRecipe recipe = null;
				if (irecipe instanceof ShapelessRecipes)
				{
					recipe = this.shapelessRecipe((ShapelessRecipes) irecipe);
				}
				else if (irecipe instanceof ShapelessOreRecipe)
				{
					recipe = this.forgeShapelessRecipe((ShapelessOreRecipe) irecipe);
				}
				
				if (recipe == null)
				{
					continue;
				}
				
				this.arecipes.add(recipe);
			}
		}
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		for (IRecipe irecipe : SawingManager.instance.getRecipeList())
		{
			CachedShapelessRecipe recipe = null;
			if (irecipe instanceof ShapelessRecipes)
			{
				recipe = this.shapelessRecipe((ShapelessRecipes) irecipe);
			}
			else if (irecipe instanceof ShapelessOreRecipe)
			{
				recipe = this.forgeShapelessRecipe((ShapelessOreRecipe) irecipe);
			}
			
			if (recipe == null)
			{
				continue;
			}
			
			if (recipe.contains(recipe.ingredients, ingredient))
			{
				recipe.setIngredientPermutation(recipe.ingredients, ingredient);
				this.arecipes.add(recipe);
			}
		}
	}
	
	protected CachedShapelessRecipe shapelessRecipe(ShapelessRecipes recipe)
	{
		if (recipe.recipeItems == null)
		{
			return null;
		}
		return new CachedShapelessRecipe(recipe.recipeItems, recipe.getRecipeOutput());
	}
}
