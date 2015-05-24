package minestrapteam.minestrappolation.util;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class AlloyRecipes
{
    private static final AlloyRecipes meltingBase = new AlloyRecipes();
    private Map meltingList = Maps.newHashMap();
    private Map meltingList2 = Maps.newHashMap();
    private Map experienceList = Maps.newHashMap();
    
    private Map stack1Size = Maps.newHashMap();
    private Map stack2Size = Maps.newHashMap();

    public static AlloyRecipes instance()
    {
        return meltingBase;
    }

   
    private AlloyRecipes()
    {
        this.addRecipe(new ItemStack(MItems.tin_ingot), new ItemStack(MItems.copper_ingot ,3 ,0), new ItemStack(Items.diamond), 1F);
        this.addRecipe(Items.apple, Items.arrow, new ItemStack(Items.coal), 1F);
        this.addRecipe(Items.apple, Items.bed, new ItemStack(Items.baked_potato), 1F);
    }

    public void addRecipe(Block input, Block input2, ItemStack stack, float experience)
    {
        this.addRecipe(Item.getItemFromBlock(input), Item.getItemFromBlock(input2), stack, experience);
    }

    public void addRecipe(Item input, Item input2, ItemStack stack, float experience)
    {
        this.addRecipe(new ItemStack(input, 1, 32767), new ItemStack(input2, 1, 32767), stack, experience);
    }

    public void addRecipe(ItemStack input, ItemStack input2, ItemStack stack, float experience)
    {
        this.meltingList.put(input, stack);
        this.meltingList2.put(input, input2);
        
        this.meltingList.put(input2, stack);
        this.meltingList2.put(input2, input);
        
        this.stack1Size.put(input, input.stackSize);
        this.stack2Size.put(input2, input2.stackSize);
        this.stack1Size.put(input2, input2.stackSize);
        this.stack2Size.put(input, input.stackSize);
        
        this.experienceList.put(stack, Float.valueOf(experience));
    }

    public ItemStack getResult(ItemStack input, ItemStack input2)
    {
        Iterator iterator = this.meltingList.entrySet().iterator();
        Entry entry;
        Iterator iterator2 = this.meltingList2.entrySet().iterator();
        Entry entry2;
        
        do
        {
            if (!iterator.hasNext() && !iterator2.hasNext())
            {
                return null;
            }
            
            entry = (Entry)iterator.next();
            entry2 = (Entry)iterator2.next();
        } while (!MStacks.equals(input, (ItemStack)entry.getKey()) || !MStacks.equals(input2, (ItemStack)entry2.getValue()));
       
        return (ItemStack)this.meltingList.get(entry.getKey());
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
        while (!MStacks.equals(stack, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
    
    public int getInputSize(ItemStack stack)
    {
        Iterator iterator = this.stack1Size.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0;
            }

            entry = (Entry)iterator.next();
        }
        while (!MStacks.equals(stack, (ItemStack)entry.getKey()));

        return (Integer)entry.getValue();
    }
    
    public int getInput2Size(ItemStack stack)
    {
        Iterator iterator = this.stack2Size.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0;
            }

            entry = (Entry)iterator.next();
        }
        while (!MStacks.equals(stack, (ItemStack)entry.getKey()));

        return (Integer)entry.getValue();
    }
}