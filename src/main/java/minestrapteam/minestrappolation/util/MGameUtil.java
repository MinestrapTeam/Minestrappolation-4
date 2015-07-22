package minestrapteam.minestrappolation.util;

import java.util.ArrayList;
import java.util.List;

import minestrapteam.minestrappolation.lib.MReference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class MGameUtil 
{
	public static final int WILDCARD_VALUE	= OreDictionary.WILDCARD_VALUE;
	
	public static Block findBlock(final String name) 
	{
		return GameRegistry.findBlock(MReference.NAME, name);
    }
	
	public static boolean equals(ItemStack input, ItemStack target)
	{
		return itemEquals(input, target);
	}
	
	public static boolean stackEquals(ItemStack input, ItemStack target)
	{
		if (input == target)
		{
			return true;
		}
		else if (input == null)
		{
			return target == null;
		}
		else if (target == null)
		{
			return false;
		}
		return equals(input.getItem(), input.stackSize, input.getItemDamage(), target.getItem(), target.stackSize, target.getItemDamage());
	}
	
	public static boolean itemEquals(ItemStack input, ItemStack target)
	{
		if (input == target)
		{
			return true;
		}
		else if (input == null)
		{
			return target == null;
		}
		else if (target == null)
		{
			return false;
		}
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
	
	public static boolean matchesOreDict(ItemStack input, ItemStack... stacks)
    {
        if (input == null) { return false; }

        final int oreID = OreDictionary.getOreID(input.getDisplayName());

        if (oreID == -1) { return false; }

        final List<ItemStack> ores = OreDictionary.getOres(OreDictionary.getOreName(oreID));

        for (final ItemStack ore : ores)
        {
            for (final ItemStack stack : stacks)
            {
                if (stack != null && OreDictionary.itemMatches(stack, ore, true)) { return true; }
            }

        }

        return false;
    }
}
