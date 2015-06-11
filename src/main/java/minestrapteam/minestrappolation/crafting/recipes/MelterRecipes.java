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
		this.addRecipe(Blocks.gravel, new ItemStack(Items.lava_bucket), 0.3F);
		this.addRecipe(Blocks.stone, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(Blocks.cobblestone, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(Blocks.mossy_cobblestone, new ItemStack(Items.lava_bucket), 0.6F);
		this.addRecipe(Blocks.stonebrick, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(Blocks.stone_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(Blocks.stone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(Blocks.cobblestone_wall, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(Blocks.sandstone, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(Blocks.sandstone_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(Blocks.red_sandstone, new ItemStack(Items.lava_bucket), 0.6F);
		this.addRecipe(Blocks.red_sandstone_stairs, new ItemStack(Items.lava_bucket), 0.6F);
		this.addRecipe(Blocks.furnace, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(Blocks.dropper, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(Blocks.dispenser, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(Blocks.netherrack, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(Blocks.nether_brick, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(Blocks.nether_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		
		// Vanilla Water
		this.addRecipe(Blocks.snow, new ItemStack(Items.water_bucket), 0.4F);
		this.addRecipe(Blocks.ice, new ItemStack(Items.water_bucket), 0.7F);
		this.addRecipe(Blocks.packed_ice, new ItemStack(Items.water_bucket), 0.9F);
		this.addRecipe(Blocks.prismarine, new ItemStack(Items.water_bucket), 0.5F);
		this.addRecipe(Blocks.cactus, new ItemStack(Items.water_bucket), 0.3F);
		
		//Vanilla Milk
		this.addRecipe(Items.cake, new ItemStack(Items.milk_bucket), 0.4F);
		
		//Minestrappolation Water
		this.addRecipe(MBlocks.snow_bricks, new ItemStack(Items.water_bucket), 0.4F);
		this.addRecipe(MBlocks.snow_refined, new ItemStack(Items.water_bucket), 0.4F);
		this.addRecipe(MBlocks.snow_tiles, new ItemStack(Items.water_bucket), 0.4F);
		
		// Minestrappolation Lava
		this.addRecipe(MBlocks.biome_stones, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.biome_cobble, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(MBlocks.biome_bricks, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.chiseled, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.mossy, new ItemStack(Items.lava_bucket), 0.6F);
		this.addRecipe(MBlocks.mossy_bricks, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.cracked_bricks, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.pattern_bricks, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.refined, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.tiles, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.lamp_glowstone, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.lamp_prismarine, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.lamp_sunstone, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.slate, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.flint_block, new ItemStack(Items.lava_bucket), 0.7F);
		this.addRecipe(MBlocks.stonecutter, new ItemStack(Items.lava_bucket), 0.6F);
		this.addRecipe(MBlocks.roads, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(MBlocks.stone_boulder, new ItemStack(Items.lava_bucket), 0.6F);
		this.addRecipe(MBlocks.red_rock_boulder, new ItemStack(Items.lava_bucket), 0.6F);
		this.addRecipe(MBlocks.coldstone_boulder, new ItemStack(Items.lava_bucket), 0.6F);
		this.addRecipe(MBlocks.icestone_boulder, new ItemStack(Items.lava_bucket), 0.6F);
		this.addRecipe(MBlocks.oceanstone_boulder, new ItemStack(Items.lava_bucket), 0.6F);
		this.addRecipe(MBlocks.stone_lamp_glowstone, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.stone_lamp_sunstone, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.stone_lamp_prismarine, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.stone_pattern_bricks, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.stone_refined, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.stone_tiles, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.deepstone_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(MBlocks.redrock_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(MBlocks.deep_redrock_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(MBlocks.coldstone_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(MBlocks.deep_coldstone_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(MBlocks.icestone_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(MBlocks.glacierstone_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(MBlocks.oceanstone_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(MBlocks.poceanstone_stairs, new ItemStack(Items.lava_bucket), 0.4F);
		this.addRecipe(MBlocks.deepstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.redrock_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.deep_redrock_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.coldstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.deep_coldstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.icestone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.glacierstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.oceanstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		this.addRecipe(MBlocks.poceanstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F);
		
		//Misc
		this.addRecipe(MBlocks.titanium_ore, new ItemStack(MItems.titanium_ingot), 2.0F);
		this.addRecipe(MBlocks.biome_titanium, new ItemStack(MItems.titanium_ingot), 2.0F);
		this.addRecipe(new ItemStack(MItems.chunks, 1, 10), new ItemStack(MItems.titanium_ingot), 2.0F);
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