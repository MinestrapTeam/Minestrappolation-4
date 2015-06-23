package minestrapteam.minestrappolation.crafting.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;

public class SplitterRecipes
{
	private static final SplitterRecipes	splitBase		= new SplitterRecipes();
	private Map							splitList		= Maps.newHashMap();
	private Map							splitList2		= Maps.newHashMap();
	private Map							experienceList	= Maps.newHashMap();
	
	public static SplitterRecipes instance()
	{
		return splitBase;
	}
	
	private SplitterRecipes()
	{
		this.addRecipe(Items.iron_pickaxe, new ItemStack(Items.stick , 1), new ItemStack(Items.iron_ingot, 3), 0.5F);
		this.addRecipe(Items.stone_pickaxe, new ItemStack(Items.stick , 1), new ItemStack(Blocks.cobblestone, 3), 0.5F);
	}
	
	public void addRecipe(Block input, ItemStack stack, ItemStack stack2, float experience)
	{
		this.addRecipe(Item.getItemFromBlock(input), stack, stack2, experience);
	}
	
	public void addRecipe(Item input, ItemStack stack, ItemStack stack2, float experience)
	{
		this.addRecipe(new ItemStack(input, 1, 32767), stack, stack2, experience);
	}
	
	public void addRecipe(ItemStack input, ItemStack stack, ItemStack stack2, float experience)
	{
		this.splitList.put(input, stack);
		this.splitList2.put(input, stack2);
		this.experienceList.put(stack, Float.valueOf(experience));
	}
	
	public ItemStack getResult(ItemStack stack)
	{
		Iterator iterator = this.splitList.entrySet().iterator();
		Entry entry;
		
		do
		{
			if (!iterator.hasNext())
				return null;
			
			entry = (Entry) iterator.next();
		}
		while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));
		
		return (ItemStack) entry.getValue();
	}
	
	public ItemStack getResult2(ItemStack stack)
	{
		Iterator iterator = this.splitList2.entrySet().iterator();
		Entry entry;
		
		do
		{
			if (!iterator.hasNext())
				return null;
			
			entry = (Entry) iterator.next();
		}
		while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));
		
		return (ItemStack) entry.getValue();
	}
	
	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
	}
	
	public Map getSsplitList()
	{
		return this.splitList;
	}
	
	public float getSmeltingExperience(ItemStack stack)
	{
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;
		
		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;
		
		do
		{
			if (!iterator.hasNext())
				return 0.0F;
			
			entry = (Entry) iterator.next();
		}
		while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));
		
		return ((Float) entry.getValue()).floatValue();
	}
}