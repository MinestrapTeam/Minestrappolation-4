package com.delocuro.ministrappolation.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

public class MinistrappolationStackHandler
{
	public static final int	WILDCARD_VALUE	= OreDictionary.WILDCARD_VALUE;
	
	public static boolean equals(ItemStack input, ItemStack target)
	{
		return itemEquals(input, target);
	}
	
	public static boolean stackEquals(ItemStack input, ItemStack target)
	{
		if (input == target)
			return true;
		else if (input == null)
			return target == null;
		else if (target == null)
			return false;
		return equals(input.getItem(), input.stackSize, input.getItemDamage(), target.getItem(), target.stackSize, target.getItemDamage());
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
		return item1 == item2 && (meta1 == meta2 || meta1 == WILDCARD_VALUE || meta2 == WILDCARD_VALUE);
	}
	
	public static boolean equals(Item item1, int size1, int meta1, Item item2, int size2, int meta2)
	{
		return item1 == item2 && size1 == size2 && (meta1 == meta2 || meta1 == WILDCARD_VALUE || meta2 == WILDCARD_VALUE);
	}
	
	public static int hashCode(ItemStack stack)
	{
		return itemHashCode(stack);
	}
	
	public static int itemHashCode(ItemStack stack)
	{
		return stack == null ? 0 : hashCode(stack.getItem(), 1, stack.getItemDamage());
	}
	
	public static int stackHashCode(ItemStack stack)
	{
		return stack == null ? 0 : hashCode(stack.getItem(), stack.stackSize, stack.getItemDamage());
	}
	
	public static int hashCode(Item item, int stackSize, int metadata)
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (item == null ? 0 : Item.getIdFromItem(item));
		result = prime * result + stackSize;
		result = prime * result + metadata;
		return result;
	}
	
	public static String toString(ItemStack stack)
	{
		return stack == null ? "null" : toString(stack.getItem(), stack.stackSize, stack.getItemDamage());
	}
	
	public static String toString(Item item, int stackSize, int metadata)
	{
		return new StringBuilder(20).append(stackSize).append(" x ").append(item.getUnlocalizedName()).append(":").append(metadata).toString();
	}
	
	public static int mergeItemStack(ItemStack[] stacks, int start, ItemStack stack)
	{
		return mergeItemStack(stacks, stacks.length, stack);
	}
	
	public static int mergeItemStack(ItemStack[] stacks, int start, int end, ItemStack stack)
	{
		int i = -1;
		int max = stack.getMaxStackSize();
		ItemStack stack1;
		
		for (int j = start; j < end && stack.isStackable() && stack.stackSize > 0; j++)
		{
			stack1 = stacks[j];
			if (stack1 != null && equals(stack, stack1))
			{
				int k = stack1.stackSize + stack.stackSize;
				if (k <= max)
				{
					stack.stackSize = 0;
					stack1.stackSize = k;
					i = j;
				}
				else if (stack1.stackSize < max)
				{
					stack.stackSize -= max - stack1.stackSize;
					stack1.stackSize = max;
					i = j;
				}
			}
		}
		
		if (stack.stackSize > 0)
		{
			for (int j = start; j < end; j++)
			{
				stack1 = stacks[j];
				if (stack1 == null)
				{
					stacks[j] = stack.copy();
					stack.stackSize = 0;
					return j;
				}
			}
		}
		return i;
	}
	
	public static NBTTagCompound getNBT(ItemStack stack)
	{
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt == null)
		{
			nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
		}
		return nbt;
	}
	
	// Finish class based on
	// Clashsoft-Lib/src/main/java/cslib/minecraft/stacks/CSStacks.java. See
	// GitHub for source.
}
