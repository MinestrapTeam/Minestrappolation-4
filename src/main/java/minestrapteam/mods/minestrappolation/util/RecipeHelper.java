package minestrapteam.mods.minestrappolation.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.Iterator;
import java.util.List;

public class RecipeHelper
{

	public static void removeRecipeContaining(Item item)
	{
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

		Iterator<IRecipe> remover = recipes.iterator();

		while (remover.hasNext())
		{
			ItemStack itemstack = remover.next().getRecipeOutput();
			if (itemstack != null && itemstack.getItem() == item)
			{
				remover.remove();
			}
		}
	}

	public static void removeRecipeContaining(Block block)
	{
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

		Iterator<IRecipe> remover = recipes.iterator();

		while (remover.hasNext())
		{
			ItemStack itemstack = remover.next().getRecipeOutput();
			if (itemstack != null && itemstack.getItem() == Item.getItemFromBlock(block))
			{
				remover.remove();
			}
		}
	}
}
