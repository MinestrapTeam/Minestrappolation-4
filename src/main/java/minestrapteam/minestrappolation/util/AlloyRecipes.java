package minestrapteam.minestrappolation.util;

import com.google.common.collect.Maps;

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

    public static AlloyRecipes instance()
    {
        return meltingBase;
    }

   
    private AlloyRecipes()
    {
        this.addRecipe(MItems.tin_ingot, MItems.copper_ingot, new ItemStack(Items.diamond), 1F);
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
        } while (!this.compareItemStacks(input, (ItemStack)entry.getKey()) || !this.compareItemStacks(input2, (ItemStack)entry2.getValue()));
       
        return (ItemStack)this.meltingList.get(entry.getKey());
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
    	if(stack1 == null || stack2 == null)
    	{
    		return false;
    	}
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