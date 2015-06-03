package minestrapteam.minestrappolation.api;

import minestrapteam.minestrappolation.crafting.recipes.AlloyRecipes;
import minestrapteam.minestrappolation.crafting.recipes.CrusherRecipes;
import minestrapteam.minestrappolation.crafting.recipes.MelterRecipes;
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
	
}
