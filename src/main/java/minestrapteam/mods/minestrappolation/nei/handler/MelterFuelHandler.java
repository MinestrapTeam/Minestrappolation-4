package minestrapteam.mods.minestrappolation.nei.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.GuiRecipe;
import minestrapteam.mods.minestrappolation.crafting.recipes.MelterRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class MelterFuelHandler extends MelterRecipeHandler
{
	public class CachedFuelRecipe extends CachedRecipe
	{
		public FuelPair	fuel;
		
		public CachedFuelRecipe(FuelPair fuel)
		{
			this.fuel = fuel;
		}
		
		private MeltingPair getRecipe()
		{
			return MelterFuelHandler.this.mfurnace.get(MelterFuelHandler.this.cycleticks / 48 % MelterFuelHandler.this.mfurnace.size());
		}
		
		@Override
		public PositionedStack getIngredient()
		{
			return this.getRecipe().ingred;
		}
		
		@Override
		public PositionedStack getResult()
		{
			return this.getRecipe().result;
		}
		
		@Override
		public List<PositionedStack> getOtherStacks()
		{
			List<PositionedStack> list = super.getOtherStacks();
			if (this.fuel.stack != null)
			{
				list.add(this.fuel.stack);
			}
			PositionedStack bucket = this.getRecipe().bucket;
			if (bucket != null)
			{
				list.add(bucket);
			}
			return list;
		}
	}
	
	private ArrayList<MeltingPair>	mfurnace	= new ArrayList();
	
	public MelterFuelHandler()
	{
		super();
		this.loadAllSmelting();
	}
	
	@Override
	public String getRecipeName()
	{
		return StatCollector.translateToLocal("recipe.melter_fuel");
	}
	
	private void loadAllSmelting()
	{
		Map<ItemStack, ItemStack> recipes = MelterRecipes.instance().getSmeltingList();
		
		for (Entry<ItemStack, ItemStack> recipe : recipes.entrySet())
		{
			this.mfurnace.add(new MeltingPair(recipe.getKey(), recipe.getValue()));
		}
	}
	
	@Override
	public void loadCraftingRecipes(String outputId, Object... results)
	{
		if (outputId.equals("melter_fuel"))
		{
			for (FuelPair fuel : afuels)
			{
				this.arecipes.add(new CachedFuelRecipe(fuel));
			}
		}
	}
	
	@Override
	public void loadUsageRecipes(ItemStack ingredient)
	{
		for (FuelPair fuel : afuels)
		{
			if (fuel.stack.contains(ingredient))
			{
				this.arecipes.add(new CachedFuelRecipe(fuel));
			}
		}
	}
	
	@Override
	public String getOverlayIdentifier()
	{
		return "melter_fuel";
	}
	
	@Override
	public List<String> handleItemTooltip(GuiRecipe gui, ItemStack stack, List<String> currenttip, int recipe)
	{
		CachedFuelRecipe crecipe = (CachedFuelRecipe) this.arecipes.get(recipe);
		FuelPair fuel = crecipe.fuel;
		float burnTime = fuel.burnTime / 200F;
		
		if (gui.isMouseOver(fuel.stack, recipe) && burnTime < 1)
		{
			burnTime = 1F / burnTime;
			String s_time;
			if (burnTime == Math.round(burnTime))
			{
				s_time = Integer.toString((int) burnTime);
			}
			else
			{
				s_time = Float.toString(burnTime);
			}
			
			currenttip.add(StatCollector.translateToLocalFormatted("nei.recipe.fuel.required", s_time));
		}
		else if (burnTime > 1 && (gui.isMouseOver(crecipe.getResult(), recipe) || gui.isMouseOver(crecipe.getIngredient(), recipe)))
		{
			String s_time;
			if (burnTime == Math.round(burnTime))
			{
				s_time = Integer.toString((int) burnTime);
			}
			else
			{
				s_time = Float.toString(burnTime);
			}
			
			currenttip.add(StatCollector.translateToLocalFormatted("nei.recipe.fuel." + (gui.isMouseOver(crecipe.getResult(), recipe) ? "produced" : "processed"), s_time));
		}
		
		return currenttip;
	}
}
