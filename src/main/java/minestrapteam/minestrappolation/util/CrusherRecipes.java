package minestrapteam.minestrappolation.util;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
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
    private Map chance = Maps.newHashMap();
    public HashMap<ItemStack, ItemStack> extraDropList = new HashMap<ItemStack, ItemStack>();

    public static CrusherRecipes instance()
    {
        return crusherBase;
    }

   
    private CrusherRecipes()
    {
        this.addRecipe(MBlocks.biome_iron, new ItemStack(MItems.chunks, 2, 1), .2F, new ItemStack(MItems.chunks, 1, 0), 100);
        this.addRecipe(MBlocks.biome_gold, new ItemStack(MItems.chunks, 2, 2), .2F, new ItemStack(MItems.chunks, 1, 0), 100);
        this.addRecipe(MBlocks.biome_tin, new ItemStack(MItems.chunks, 2, 3), .2F, new ItemStack(MItems.chunks, 1, 0), 100);
        this.addRecipe(MBlocks.biome_copper, new ItemStack(MItems.chunks, 2, 4), .2F, new ItemStack(MItems.chunks, 1, 3), 100);
    }

    public void addRecipe(Block input, ItemStack stack, float experience, ItemStack extra, int chance)
    {
        this.addRecipe(Item.getItemFromBlock(input), stack, experience, extra, chance);
    }

    public void addRecipe(Item input, ItemStack stack, float experience, ItemStack extra, int chance)
    {
        this.addRecipe(new ItemStack(input, 1, 32767), stack, experience, extra, chance);
    }

    public void addRecipe(ItemStack input, ItemStack stack, float experience, ItemStack extra, int chance)
    {
        this.meltingList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
        this.extraDropList.put(input , extra);
        this.chance.put(input , chance);
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
    
    public ItemStack getExtra(ItemStack stack)
    {
        Iterator iterator = this.extraDropList.entrySet().iterator();
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
    
    public int getChance(ItemStack stack)
    {
        Iterator iterator = this.chance.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.compareItemStacks(stack, (ItemStack)entry.getKey()));

        return (Integer)entry.getValue();
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