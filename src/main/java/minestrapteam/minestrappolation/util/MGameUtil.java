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
