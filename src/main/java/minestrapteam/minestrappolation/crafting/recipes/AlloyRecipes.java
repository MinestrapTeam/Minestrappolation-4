package minestrapteam.minestrappolation.crafting.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.util.MStacks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.google.common.collect.Maps;

public class AlloyRecipes
{
	private static final AlloyRecipes	meltingBase		= new AlloyRecipes();
	private Map							meltingList		= Maps.newHashMap();
	private Map							meltingList2	= Maps.newHashMap();
	private Map							experienceList	= Maps.newHashMap();
	
	private Map							stack1Size		= Maps.newHashMap();
	private Map							stack2Size		= Maps.newHashMap();
	
	public static AlloyRecipes instance()
	{
		return meltingBase;
	}
	
	private AlloyRecipes()
	{
		//Stones
		this.addRecipe(new ItemStack(Blocks.cobblestone, 4, 0), new ItemStack(Blocks.quartz_block, 1, 0), new ItemStack(Blocks.stone, 4, 3), 0.3F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 4, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.quartz_block, 1, 0), new ItemStack(Blocks.stone, 4, 3), 0.3F);
		this.addRecipe(new ItemStack(Blocks.cobblestone, 4, 0), new ItemStack(MBlocks.desert_quartz_block, 1, 0), new ItemStack(Blocks.stone, 4, 3), 0.3F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 4, OreDictionary.WILDCARD_VALUE), new ItemStack(MBlocks.desert_quartz_block, 1, 0), new ItemStack(Blocks.stone, 4, 3), 0.3F);
		this.addRecipe(new ItemStack(Blocks.stone, 4, 3), new ItemStack(Blocks.cobblestone, 4, 0), new ItemStack(Blocks.stone, 6, 5), 0.3F);
		this.addRecipe(new ItemStack(Blocks.stone, 4, 3), new ItemStack(MBlocks.biome_cobble, 4, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.stone, 6, 5), 0.3F);
		this.addRecipe(new ItemStack(Blocks.stone, 4, 3), new ItemStack(Blocks.quartz_block, 1, 0), new ItemStack(Blocks.stone, 4, 1), 0.3F);
		this.addRecipe(new ItemStack(Blocks.stone, 4, 3), new ItemStack(MBlocks.desert_quartz_block, 1, 0), new ItemStack(Blocks.stone, 4, 1), 0.3F);
		this.addRecipe(new ItemStack(Blocks.clay, 4, 0), new ItemStack(Blocks.quartz_block, 1, 0), new ItemStack(MBlocks.slate, 4, 0), 0.3F);
		this.addRecipe(new ItemStack(Blocks.clay, 4, 0), new ItemStack(MBlocks.desert_quartz_block, 1, 0), new ItemStack(MBlocks.slate, 4, 0), 0.3F);
		
		//Minerals
		this.addRecipe(new ItemStack(MItems.tin_ingot, 3, 0), new ItemStack(MItems.copper_ingot, 3, 0), new ItemStack(MItems.bronze_ingot), 1F);
		this.addRecipe(new ItemStack(Items.iron_ingot, 1, 0), new ItemStack(Items.coal, 6, 0), new ItemStack(MItems.steel_ingot), 1F);
		this.addRecipe(new ItemStack(Items.prismarine_shard, 1), new ItemStack(MItems.sunstone_shard, 1), new ItemStack(Items.prismarine_crystals), 1F);
		this.addRecipe(new ItemStack(MItems.chunks, 8, 3), new ItemStack(MItems.radiant_quartz, 1), new ItemStack(Items.prismarine_shard, 8), 1.5F);
		this.addRecipe(new ItemStack(Items.blaze_powder, 1), new ItemStack(MItems.sunstone_shard, 1), new ItemStack(MItems.blaze_shard), 1F);
		this.addRecipe(new ItemStack(Items.bone, 1), new ItemStack(MItems.blaze_shard, 4), new ItemStack(Items.blaze_rod), 1F);
		this.addRecipe(new ItemStack(MItems.blaze_shard, 4), new ItemStack(Items.gold_ingot, 1), new ItemStack(MItems.blazium_ingot), 1F);
		
		//Misc
		this.addRecipe(new ItemStack(MItems.dough, 1), new ItemStack(Items.bowl, 1), new ItemStack(MItems.bread_bowl, 1), 0.2F);
		this.addRecipe(new ItemStack(MItems.dough, 1), new ItemStack(MBlocks.pepper_seed, 1), new ItemStack(MItems.bun, 2), 0.2F);
		this.addRecipe(new ItemStack(Blocks.pumpkin, 1), new ItemStack(MItems.pie_crust, 2), new ItemStack(Items.pumpkin_pie, 2), 0.3F);
		this.addRecipe(new ItemStack(Items.apple, 2), new ItemStack(MItems.pie_crust, 2), new ItemStack(MItems.apple_pie, 2), 0.3F);
		this.addRecipe(new ItemStack(Items.egg, 1), new ItemStack(MItems.bread_bowl, 1), new ItemStack(MItems.bread_fried_egg, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.egg, 1), new ItemStack(Items.bowl, 1), new ItemStack(MItems.fried_egg, 1), 0.3F);
		this.addRecipe(new ItemStack(Blocks.sand, 1), new ItemStack(Blocks.sand, 1), new ItemStack(MBlocks.glass_refined, 2), 0.3F);
		this.addRecipe(new ItemStack(Items.blaze_powder, 1), new ItemStack(Items.ender_pearl, 1), new ItemStack(Items.ender_eye, 1), 1.0F);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 1), new ItemStack(Blocks.log, 2, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.leather, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 1), new ItemStack(Blocks.log2, 2, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.leather, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 1), new ItemStack(MBlocks.ministrapp_log, 2, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.leather, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 1), new ItemStack(Blocks.leaves, 12, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.leather, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 1), new ItemStack(Blocks.leaves2, 12, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.leather, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 1), new ItemStack(MBlocks.ministrapp_leaves, 12, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.leather, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 1), new ItemStack(Items.apple, 2), new ItemStack(Items.leather, 2), 0.3F);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 1), new ItemStack(Items.carrot, 3), new ItemStack(Items.leather, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 1), new ItemStack(Items.potato, 3), new ItemStack(Items.leather, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 1), new ItemStack(Items.poisonous_potato, 1), new ItemStack(Items.leather, 2), 0.3F);
		this.addRecipe(new ItemStack(Items.rotten_flesh, 1), new ItemStack(Items.dye, 2, 1), new ItemStack(Items.leather, 1), 0.3F);
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
				return null;
			
			entry = (Entry) iterator.next();
			entry2 = (Entry) iterator2.next();
		}
		while (!MStacks.equals(input, (ItemStack) entry.getKey()) || !MStacks.equals(input2, (ItemStack) entry2.getValue()));
		
		return (ItemStack) this.meltingList.get(entry.getKey());
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
		while (!MStacks.equals(stack, (ItemStack) entry.getKey()));
		
		return ((Float) entry.getValue()).floatValue();
	}
	
	public int getInputSize(ItemStack stack)
	{
		Iterator iterator = this.stack1Size.entrySet().iterator();
		Entry entry;
		
		do
		{
			if (!iterator.hasNext())
				return 0;
			
			entry = (Entry) iterator.next();
		}
		while (!MStacks.equals(stack, (ItemStack) entry.getKey()));
		
		return (Integer) entry.getValue();
	}
	
	public int getInput2Size(ItemStack stack)
	{
		Iterator iterator = this.stack2Size.entrySet().iterator();
		Entry entry;
		
		do
		{
			if (!iterator.hasNext())
				return 0;
			
			entry = (Entry) iterator.next();
		}
		while (!MStacks.equals(stack, (ItemStack) entry.getKey()));
		
		return (Integer) entry.getValue();
	}
}