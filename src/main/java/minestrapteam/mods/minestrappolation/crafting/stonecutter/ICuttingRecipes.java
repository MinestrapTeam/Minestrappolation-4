package minestrapteam.mods.minestrappolation.crafting.stonecutter;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface ICuttingRecipes
{
	/**
	 * Used to check if a recipe matches current crafting inventory
	 */
	public boolean matches(InventoryCrafting inventory, ItemStack extra, World world);
	
	/**
	 * Returns an Item that is the result of this recipe
	 */
	public ItemStack getCraftingResult(InventoryCrafting inventory, ItemStack extra);
	
	/**
	 * Returns the size of the recipe area
	 */
	public int getRecipeSize();
	
	public ItemStack getRecipeOutput();
}