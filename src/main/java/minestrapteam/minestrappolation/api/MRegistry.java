package minestrapteam.minestrappolation.api;

import minestrapteam.minestrappolation.crafting.recipes.AlloyRecipes;
import minestrapteam.minestrappolation.crafting.recipes.CrusherRecipes;
import minestrapteam.minestrappolation.crafting.recipes.MelterRecipes;
import minestrapteam.minestrappolation.crafting.recipes.SplitterRecipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MRegistry
{
	
	public static void addMelterRecipe(Block block, ItemStack stack, float xp)
	{
		MelterRecipes.instance().addRecipe(block, stack, xp);
	}
	
	public static void addMelterRecipe(Item item, ItemStack stack, float xp)
	{
		MelterRecipes.instance().addRecipe(item, stack, xp);
	}
	
	public static void addAlloyRecipe(Block block, Block block2, ItemStack stack, float xp)
	{
		AlloyRecipes.instance().addRecipe(block, block2, stack, xp);
	}
	
	public static void addAlloyRecipe(Item item, Item item2, ItemStack stack, float xp)
	{
		AlloyRecipes.instance().addRecipe(item, item2, stack, xp);
	}
	
	public static void addCrusherRecipe(Block block, ItemStack stack, float xp, ItemStack extra, int chance)
	{
		CrusherRecipes.instance().addRecipe(block, stack, xp, extra, chance);
	}
	
	public static void addCrusherRecipe(Item item, Item item2, ItemStack stack, float xp, ItemStack extra, int chance)
	{
		CrusherRecipes.instance().addRecipe(item, stack, xp, extra, chance);
	}
	
	public static void addSplitterRecipe(Item input, Item stack, Item stack2, float experience)
	{
		SplitterRecipes.instance().addRecipe(new ItemStack(input), new ItemStack(stack), new ItemStack(stack2), experience);
	}
	
	public static void addSplitterRecipe(Block input, Item stack, Item stack2, float experience)
	{
		SplitterRecipes.instance().addRecipe(new ItemStack(input), new ItemStack(stack), new ItemStack(stack2), experience);
	}
	
}
