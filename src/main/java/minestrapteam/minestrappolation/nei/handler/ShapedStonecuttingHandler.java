package minestrapteam.minestrappolation.nei.handler;

import java.awt.Rectangle;
import java.util.Collection;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.ShapedRecipeHandler;
import minestrapteam.minestrappolation.crafting.stonecutter.ICuttingRecipes;
import minestrapteam.minestrappolation.crafting.stonecutter.ShapedCuttingRecipe;
import minestrapteam.minestrappolation.crafting.stonecutter.StonecuttingManager;
import minestrapteam.minestrappolation.inventory.gui.GuiStoneCutter;
import minestrapteam.minestrappolation.util.MGameUtil;
import minestrapteam.minestrappolation.util.MStacks;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class ShapedStonecuttingHandler extends ShapedRecipeHandler
{
	public class CachedShapedSCRecipe extends CachedShapedRecipe
	{
		public PositionedStack	extraSlot;
		
		public CachedShapedSCRecipe(int width, int height, Object[] items, ItemStack extra, ItemStack out)
		{
			super(width, height, items, out);
			this.result = new PositionedStack(out, 133, 24);
			this.setExtraSlot(extra);
			this.setIngredients(width, height, items);
		}
		
		public CachedShapedSCRecipe(ShapedCuttingRecipe recipe)
		{
			this(recipe.recipeWidth, recipe.recipeHeight, recipe.recipeItems, recipe.extraSlot, recipe.recipeOutput);
		}
		
		public void setExtraSlot(ItemStack extra)
		{
			if (extra != null)
			{
				this.extraSlot = new PositionedStack(extra, 3, 24);
			}
		}
		
		@Override
		public void setIngredients(int width, int height, Object[] items)
		{
			this.ingredients.clear();
			for (int x = 0; x < width; x++)
			{
				for (int y = 0; y < height; y++)
				{
					if (items[y * width + x] == null)
					{
						continue;
					}
					
					PositionedStack stack = new PositionedStack(items[y * width + x], 39 + x * 18, 6 + y * 18, false);
					stack.setMaxSize(1);
					this.ingredients.add(stack);
				}
			}
		}
		
		@Override
		public boolean contains(Collection<PositionedStack> ingredients, Item ingred)
		{
			if (this.extraSlot != null && this.extraSlot.contains(ingred))
			{
				return true;
			}
			return super.contains(ingredients, ingred);
		}
		
		@Override
		public boolean contains(Collection<PositionedStack> ingredients, ItemStack ingredient)
		{
			if (this.extraSlot != null && this.extraSlot.contains(ingredient))
			{
				return true;
			}
			return super.contains(ingredients, ingredient);
		}
		
		@Override
		public PositionedStack getOtherStack()
		{
			return this.extraSlot;
		}
	}
	
	@Override
	public String getGuiTexture()
	{
		return GuiStoneCutter.texture.toString();
	}
	
	@Override
	public String getRecipeName()
	{
		return StatCollector.translateToLocal("recipe.stonecutter.shaped");
	}
	
	@Override
	public String getOverlayIdentifier()
	{
		return "stonecutter";
	}
	
	@Override
	public void loadTransferRects()
	{
		this.transferRects.add(new RecipeTransferRect(new Rectangle(22, 23, 12, 18), "stonecutter"));
		this.transferRects.add(new RecipeTransferRect(new Rectangle(98, 23, 24, 18), "stonecutter"));
	}
	
	@Override
	public Class<? extends GuiContainer> getGuiClass()
	{
		return GuiStoneCutter.class;
	}
	
	@Override
	public boolean hasOverlay(GuiContainer gui, Container container, int recipe)
	{
		return false;
	}
	
	@Override
	public void loadCraftingRecipes(String outputId, Object... results)
	{
		this.transferRects.clear();
		this.loadTransferRects();
		
		if ("stonecutter".equals(outputId))
		{
			for (ICuttingRecipes irecipe : StonecuttingManager.instance().getRecipeList())
			{
				if (irecipe instanceof ShapedCuttingRecipe)
				{
					CachedShapedSCRecipe recipe = new CachedShapedSCRecipe((ShapedCuttingRecipe) irecipe);
					
					recipe.computeVisuals();
					this.arecipes.add(recipe);
				}
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
		for (ICuttingRecipes irecipe : StonecuttingManager.instance().getRecipeList())
		{
			if (irecipe instanceof ShapedCuttingRecipe)
			{
				if (MStacks.itemEquals(irecipe.getRecipeOutput(), result))
				{
					CachedShapedSCRecipe recipe = new CachedShapedSCRecipe((ShapedCuttingRecipe) irecipe);
					recipe.computeVisuals();
					this.arecipes.add(recipe);
				}
			}
		}
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		for (ICuttingRecipes irecipe : StonecuttingManager.instance().getRecipeList())
		{
			if (irecipe instanceof ShapedCuttingRecipe)
			{
				CachedShapedSCRecipe recipe = new CachedShapedSCRecipe((ShapedCuttingRecipe) irecipe);
				
				if (recipe.contains(recipe.ingredients, ingredient.getItem()))
				{
					recipe.computeVisuals();
					if (recipe.contains(recipe.ingredients, ingredient))
					{
						recipe.setIngredientPermutation(recipe.ingredients, ingredient);
						this.arecipes.add(recipe);
					}
				}
			}
		}
	}
}
