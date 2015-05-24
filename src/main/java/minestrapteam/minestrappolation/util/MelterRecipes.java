package minestrapteam.minestrappolation.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.google.common.collect.Maps;

public class MelterRecipes
{
	private static final MelterRecipes	meltingBase		= new MelterRecipes();
	private Map							meltingList		= Maps.newHashMap();
	private Map							experienceList	= Maps.newHashMap();
	
	public static MelterRecipes instance()
	{
		return meltingBase;
	}
	
	private MelterRecipes()
	{
		// Vanilla Lava
		this.addRecipe(Blocks.cobblestone, new ItemStack(Items.lava_bucket), 1F);
		this.addRecipe(Blocks.cobblestone, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(Blocks.mossy_cobblestone, new ItemStack(Items.lava_bucket), 0.6F);
		this.addRecipe(Blocks.stone, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(Blocks.stonebrick, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(Blocks.stone_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(Blocks.stone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(Blocks.cobblestone_wall, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(Blocks.sandstone, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(Blocks.sandstone_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		
		// Vanilla Water
		this.addRecipe(Blocks.snow, new ItemStack(Items.water_bucket), 0.4F);
		this.addRecipe(Blocks.ice, new ItemStack(Items.water_bucket), 0.7F);
		
		// Minestrappolation lava
		this.addRecipe(MBlocks.biome_stones, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.biome_cobble, new ItemStack(Items.lava_bucket), 0.5F);
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
	
	public Map getSmeltingList()
	{
		return this.meltingList;
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