package minestrapteam.mods.minestrappolation.nei.handler;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import codechicken.nei.ItemList;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.TemplateRecipeHandler;
import minestrapteam.mods.minestrappolation.crafting.recipes.CrusherRecipes;
import minestrapteam.mods.minestrappolation.inventory.gui.GuiCrusher;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityCrusher;
import minestrapteam.mods.minestrappolation.util.MStacks;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class CrusherRecipesHandler extends TemplateRecipeHandler
{
	public class CrushingPair extends CachedRecipe
	{
		protected PositionedStack	ingred;
		protected PositionedStack	result;
		protected PositionedStack	bonus;
		
		public CrushingPair(ItemStack ingred, ItemStack result)
		{
			ingred.stackSize = 1;
			this.ingred = new PositionedStack(ingred, 51, 6);
			this.result = new PositionedStack(result, 111, 15);
			
			ItemStack bonus = new ItemStack(CrusherRecipes.instance().getExtra(ingred).getItem());
			if (bonus != null)
			{
				this.bonus = new PositionedStack(bonus, 111, 38);
			}
		}
		
		@Override
		public List<PositionedStack> getIngredients()
		{
			return this.getCycledIngredients(CrusherRecipesHandler.this.cycleticks / 48, Arrays.asList(this.ingred));
		}
		
		@Override
		public PositionedStack getResult()
		{
			return this.result;
		}
		
		@Override
		public List<PositionedStack> getOtherStacks()
		{
			List<PositionedStack> list = super.getOtherStacks();
			PositionedStack fuel = afuels.get(CrusherRecipesHandler.this.cycleticks / 48 % afuels.size()).stack;
			if (fuel != null)
			{
				list.add(fuel);
			}
			if (this.bonus != null)
			{
				list.add(this.bonus);
			}
			return list;
		}
	}
	
	public static class FuelPair
	{
		public PositionedStack	stack;
		public int				burnTime;
		
		public FuelPair(ItemStack ingred, int burnTime)
		{
			this.stack = new PositionedStack(ingred, 51, 42, false);
			this.burnTime = burnTime;
		}
	}
	
	public static ArrayList<FuelPair>	afuels;
	
	@Override
	public void loadTransferRects()
	{
		this.transferRects.add(new RecipeTransferRect(new Rectangle(50, 23, 18, 18), "crusher_fuel"));
		this.transferRects.add(new RecipeTransferRect(new Rectangle(74, 23, 24, 18), "crusher"));
	}
	
	@Override
	public Class<? extends GuiContainer> getGuiClass()
	{
		return GuiCrusher.class;
	}
	
	@Override
	public String getRecipeName()
	{
		return StatCollector.translateToLocal("recipe.crusher");
	}
	
	@Override
	public TemplateRecipeHandler newInstance()
	{
		if (afuels == null)
		{
			findFuels();
		}
		return super.newInstance();
	}
	
	@Override
	public void loadCraftingRecipes(String outputId, Object... results)
	{
		if (outputId.equals("crusher"))
		{
			Map<ItemStack, ItemStack> recipes = CrusherRecipes.instance().getSmeltingList();
			for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
			{
				this.arecipes.add(new CrushingPair(recipe.getKey(), recipe.getValue()));
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
		Map<ItemStack, ItemStack> recipes = CrusherRecipes.instance().getSmeltingList();
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
		{
			if (MStacks.itemEquals(recipe.getValue(), result))
			{
				this.arecipes.add(new CrushingPair(recipe.getKey(), recipe.getValue()));
			}
		}
	}
	
	@Override
	public String getGuiTexture()
	{
		return GuiCrusher.texture.toString();
	}
	
	@Override
	public void drawExtras(int recipe)
	{
		this.drawProgressBar(51, 25, 176, 0, 14, 14, 48, 7);
		this.drawProgressBar(74, 14, 176, 14, 24, 16, 48, 0);
	}
	
	private static void findFuels()
	{
		afuels = new ArrayList<FuelPair>();
		for (ItemStack item : ItemList.items)
		{
			int burnTime = TileEntityCrusher.getItemBurnTime(item);
			if (burnTime > 0)
			{
				afuels.add(new FuelPair(item.copy(), burnTime));
			}
		}
	}
	
	@Override
	public String getOverlayIdentifier()
	{
		return "crusher";
	}
}
