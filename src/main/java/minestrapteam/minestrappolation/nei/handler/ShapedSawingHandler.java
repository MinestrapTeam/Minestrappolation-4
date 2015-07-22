package minestrapteam.minestrappolation.nei.handler;

import java.awt.Rectangle;

import codechicken.nei.recipe.ShapedRecipeHandler;
import minestrapteam.minestrappolation.crafting.sawmill.SawingManager;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.StatCollector;
import net.minecraftforge.oredict.ShapedOreRecipe;
import minestrapteam.minestrappolation.inventory.gui.GuiSawmill;
import minestrapteam.minestrappolation.util.MGameUtil;

public class ShapedSawingHandler extends ShapedRecipeHandler
{
	@Override
	public String getRecipeName()
	{
		return StatCollector.translateToLocal("recipe.sawmill.shaped");
	}
	
	@Override
	public void loadTransferRects()
	{
		this.transferRects.add(new RecipeTransferRect(new Rectangle(84, 23, 24, 18), "sawmill"));
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
				CachedShapedRecipe recipe = null;
				if (irecipe instanceof ShapedRecipes)
				{
					recipe = new CachedShapedRecipe((ShapedRecipes) irecipe);
				}
				else if (irecipe instanceof ShapedOreRecipe)
				{
					recipe = this.forgeShapedRecipe((ShapedOreRecipe) irecipe);
				}
				if (recipe == null)
				{
					continue;
				}
				
				recipe.computeVisuals();
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
			if (MGameUtil.itemEquals(irecipe.getRecipeOutput(), result))
			{
				CachedShapedRecipe recipe = null;
				if (irecipe instanceof ShapedRecipes)
				{
					recipe = new CachedShapedRecipe((ShapedRecipes) irecipe);
				}
				else if (irecipe instanceof ShapedOreRecipe)
				{
					recipe = this.forgeShapedRecipe((ShapedOreRecipe) irecipe);
				}
				
				if (recipe == null)
				{
					continue;
				}
				
				recipe.computeVisuals();
				this.arecipes.add(recipe);
			}
		}
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		for (IRecipe irecipe : SawingManager.instance.getRecipeList())
		{
			CachedShapedRecipe recipe = null;
			if (irecipe instanceof ShapedRecipes)
			{
				recipe = new CachedShapedRecipe((ShapedRecipes) irecipe);
			}
			else if (irecipe instanceof ShapedOreRecipe)
			{
				recipe = this.forgeShapedRecipe((ShapedOreRecipe) irecipe);
			}
			
			if (recipe == null || !recipe.contains(recipe.ingredients, ingredient.getItem()))
			{
				continue;
			}
			
			recipe.computeVisuals();
			if (recipe.contains(recipe.ingredients, ingredient))
			{
				recipe.setIngredientPermutation(recipe.ingredients, ingredient);
				this.arecipes.add(recipe);
			}
		}
	}
}
