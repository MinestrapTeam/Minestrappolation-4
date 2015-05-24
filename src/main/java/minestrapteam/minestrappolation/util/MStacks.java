package minestrapteam.minestrappolation.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class MStacks {
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
		return equals(input.getItem(), input.getItemDamage(), input.stackSize, target.getItem(), target.getItemDamage(), target.stackSize);
	}
	
	public static boolean equals(Item item1, int meta1, int amount, Item item2, int meta2, int amount2)
	{
		return item1 == item2 && (meta1 == meta2 || meta1 == OreDictionary.WILDCARD_VALUE || meta2 == OreDictionary.WILDCARD_VALUE) && (amount >= amount2);
	}
}
