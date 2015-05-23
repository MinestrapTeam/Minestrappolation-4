package minestrapteam.minestrappolation.util;

import com.google.common.collect.Maps;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class CrusherRecipes
{
    private static final CrusherRecipes crusherBase = new CrusherRecipes();
    private Map meltingList = Maps.newHashMap();
    private Map experienceList = Maps.newHashMap();

    public static CrusherRecipes instance()
    {
        return crusherBase;
    }

   
    private CrusherRecipes()
    {
        this.addRecipe(Blocks.cobblestone, new ItemStack(Blocks.gravel, 4, 0), 1F);
    }

    public void addRecipe(Block input, ItemStack stack, float experience)
    {
        this.addRecipe(Item.getItemFromBlock(input), stack, experience);
    }

    public void addRecipe(Item input, ItemStack stack, float experience)
    {
        this.addRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    public void addRecipe(ItemStack input, ItemStack stack, float experience)
    {
        this.meltingList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }

    public ItemStack getResult(ItemStack stack)
    {
        Iterator iterator = this.meltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.compareItemStacks(stack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map getSmeltingList()
    {
        return this.meltingList;
    }

    public float getSmeltingExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.compareItemStacks(stack, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}