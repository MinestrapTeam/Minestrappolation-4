package minestrapteam.minestrappolation.crafting.stonecutter;


import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class ShapedCuttingRecipe implements ICuttingRecipes
{
	public final int			recipeWidth;
	public final int			recipeHeight;
	
	public final ItemStack[]	recipeItems;
	public final ItemStack		recipeOutput;
	
	public ItemStack			extraSlot;
	
	protected boolean			hasNBTResult;
	
	public ShapedCuttingRecipe(ItemStack output, ItemStack extra, Object... data)
	{
		String s = "";
		int index = 0;
		int width = 0;
		int height = 0;
		
		if (data[index] instanceof String[])
		{
			String[] strings = (String[]) data[index++];
			
			for (String s1 : strings)
			{
				++height;
				width = s1.length();
				s += s1;
			}
		}
		else
		{
			while (data[index] instanceof String)
			{
				String s1 = (String) data[index++];
				++height;
				width = s1.length();
				s += s1;
			}
		}
		
		HashMap map;
		
		for (map = new HashMap(); index < data.length; index += 2)
		{
			Character c = (Character) data[index];
			int index1 = index + 1;
			ItemStack stack1 = null;
			
			if (data[index1] instanceof Item)
			{
				stack1 = new ItemStack((Item) data[index1]);
			}
			else if (data[index1] instanceof Block)
			{
				stack1 = new ItemStack((Block) data[index1], 1, 32767);
			}
			else if (data[index1] instanceof ItemStack)
			{
				stack1 = (ItemStack) data[index1];
			}
			
			map.put(c, stack1);
		}
		
		int len = width * height;
		ItemStack[] stacks = new ItemStack[len];
		
		for (int i = 0; i < len; ++i)
		{
			char c = s.charAt(i);
			
			if (map.containsKey(Character.valueOf(c)))
			{
				stacks[i] = ((ItemStack) map.get(Character.valueOf(c))).copy();
			}
			else
			{
				stacks[i] = null;
			}
		}
		
		this.recipeWidth = width;
		this.recipeHeight = height;
		this.recipeItems = stacks;
		this.recipeOutput = output;
		this.extraSlot = extra;
	}
	
	public ShapedCuttingRecipe(ItemStack output, ItemStack extra, int width, int height, ItemStack[] data)
	{
		this.recipeOutput = output;
		this.extraSlot = extra;
		this.recipeWidth = width;
		this.recipeHeight = height;
		this.recipeItems = data;
	}
	
	@Override
	public ItemStack getRecipeOutput()
	{
		return this.recipeOutput;
	}
	
	public static boolean equals(ItemStack input, ItemStack target)
	{
		return itemEquals(input, target);
	}
	
	public static boolean itemEquals(ItemStack input, ItemStack target)
	{
		if (input == target)
			return true;
		else if (input == null)
			return target == null;
		else if (target == null)
			return false;
		return equals(input.getItem(), input.getItemDamage(), target.getItem(), target.getItemDamage());
	}
	
	public static boolean equals(Item item1, int meta1, Item item2, int meta2)
	{
		return item1 == item2 && (meta1 == meta2 || meta1 == OreDictionary.WILDCARD_VALUE || meta2 == OreDictionary.WILDCARD_VALUE);
	}
	
	@Override
	public boolean matches(InventoryCrafting inventory, ItemStack extra, World world)
	{
		if (!this.equals(extraSlot, extra))
		{
			return false;
		}
		
		for (int i = 0; i <= 3 - this.recipeWidth; ++i)
		{
			for (int j = 0; j <= 3 - this.recipeHeight; ++j)
			{
				if (this.checkMatch(inventory, i, j, true))
				{
					return true;
				}
				
				if (this.checkMatch(inventory, i, j, false))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Checks if the region of a crafting inventory is match for the recipe.
	 */
	private boolean checkMatch(InventoryCrafting inventory, int x, int y, boolean mirror)
	{
		for (int i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 3; ++j)
			{
				int i1 = i - x;
				int j1 = j - y;
				ItemStack stack1 = null;
				
				if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
				{
					if (mirror)
					{
						stack1 = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
					}
					else
					{
						stack1 = this.recipeItems[i1 + j1 * this.recipeWidth];
					}
				}
				
				ItemStack stack2 = inventory.getStackInRowAndColumn(i, j);
				
				if (stack2 != null || stack1 != null)
				{
					if (!this.equals(stack1, stack2))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory, ItemStack extra)
	{
		ItemStack stack = this.getRecipeOutput().copy();
		
		if (this.hasNBTResult)
		{
			for (int i = 0; i < inventory.getSizeInventory(); ++i)
			{
				ItemStack stack1 = inventory.getStackInSlot(i);
				
				if (stack1 != null && stack1.hasTagCompound())
				{
					stack.setTagCompound((NBTTagCompound) stack1.getTagCompound().copy());
				}
			}
		}
		
		return stack;
	}
	
	@Override
	public int getRecipeSize()
	{
		return this.recipeWidth * this.recipeHeight;
	}
	
	public ShapedCuttingRecipe setHasNBTResult(boolean hasNBTResult)
	{
		this.hasNBTResult = hasNBTResult;
		return this;
	}
}