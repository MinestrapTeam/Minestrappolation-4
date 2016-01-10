package minestrapteam.mods.minestrappolation.crafting.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.google.common.collect.Maps;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;

public class MelterRecipes
{
	private static final MelterRecipes	meltingBase		= new MelterRecipes();
	private Map							meltingList		= Maps.newHashMap();
	private Map							experienceList	= Maps.newHashMap();
	public HashMap<Item, Boolean> 		needBucket      = new HashMap<Item, Boolean>();
	public HashMap<Item, Item> 		    container       = new HashMap<Item, Item>();
	
	public static MelterRecipes instance()
	{
		return meltingBase;
	}
	
	private MelterRecipes()
	{
		// Vanilla Lava
		this.addRecipe(Blocks.gravel, new ItemStack(Items.lava_bucket), 0.3F, true);
		this.addRecipe(Blocks.stone, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(Blocks.cobblestone, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(Blocks.mossy_cobblestone, new ItemStack(Items.lava_bucket), 0.6F, true);
		this.addRecipe(Blocks.stonebrick, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(Blocks.stone_stairs, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(Blocks.stone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(Blocks.cobblestone_wall, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(Blocks.sandstone, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(Blocks.sandstone_stairs, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(Blocks.red_sandstone, new ItemStack(Items.lava_bucket), 0.6F, true);
		this.addRecipe(Blocks.red_sandstone_stairs, new ItemStack(Items.lava_bucket), 0.6F, true);
		this.addRecipe(Blocks.furnace, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(Blocks.dropper, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(Blocks.dispenser, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(Blocks.netherrack, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(Blocks.nether_brick, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(Blocks.nether_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F, true);
		
		// Vanilla Water
		this.addRecipe(Blocks.snow, new ItemStack(Items.water_bucket), 0.4F, true);
		this.addRecipe(Blocks.ice, new ItemStack(Items.water_bucket), 0.7F, true);
		this.addRecipe(Blocks.packed_ice, new ItemStack(Items.water_bucket), 0.9F, true);
		this.addRecipe(Blocks.prismarine, new ItemStack(Items.water_bucket), 0.5F, true);
		this.addRecipe(Blocks.cactus, new ItemStack(Items.water_bucket), 0.3F, true);
		this.addRecipe(Items.snowball, new ItemStack(Items.potionitem, 1, 0), 0.2F, Items.glass_bottle, true);
		
		//Vanilla Milk
		this.addRecipe(Items.cake, new ItemStack(Items.milk_bucket), 0.4F, true);
		
		//Vanilla Magma
		this.addRecipe(Blocks.bedrock, new ItemStack(MBlocks.magmaBucket), 2.0F, true);
		this.addRecipe(Blocks.obsidian, new ItemStack(MBlocks.magmaBucket), 1.0F, true);
		
		//Minestrappolation Water
		this.addRecipe(MBlocks.snow_bricks, new ItemStack(Items.water_bucket), 0.4F, true);
		this.addRecipe(MBlocks.snow_refined, new ItemStack(Items.water_bucket), 0.4F, true);
		this.addRecipe(MBlocks.snow_tiles, new ItemStack(Items.water_bucket), 0.4F, true);
		
		// Minestrappolation Lava
		this.addRecipe(MBlocks.biome_stones, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.biome_cobble, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(MBlocks.biome_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.chiseled, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.mossy, new ItemStack(Items.lava_bucket), 0.6F, true);
		this.addRecipe(MBlocks.mossy_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.cracked_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.pattern_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.refined, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.tiles, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.lamp_glowstone, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.lamp_prismarine, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.lamp_sunstone, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.slate, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.slate_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.slate_pattern_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.slate_refined, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.andesite_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.andesite_pattern_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.granite_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.granite_pattern_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.diorite_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.diorite_pattern_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.flint_block, new ItemStack(Items.lava_bucket), 0.7F, true);
		this.addRecipe(MBlocks.flint_bricks, new ItemStack(Items.lava_bucket), 0.7F, true);
		this.addRecipe(MBlocks.flint_pattern_bricks, new ItemStack(Items.lava_bucket), 0.7F, true);
		this.addRecipe(MBlocks.flint_refined, new ItemStack(Items.lava_bucket), 0.7F, true);
		this.addRecipe(MBlocks.flint_tiles, new ItemStack(Items.lava_bucket), 0.7F, true);
		this.addRecipe(MBlocks.flint_chiseled, new ItemStack(Items.lava_bucket), 0.7F, true);
		this.addRecipe(MBlocks.flint_lamp_glowstone, new ItemStack(Items.lava_bucket), 0.7F, true);
		this.addRecipe(MBlocks.flint_lamp_sunstone, new ItemStack(Items.lava_bucket), 0.7F, true);
		this.addRecipe(MBlocks.flint_lamp_prismarine, new ItemStack(Items.lava_bucket), 0.7F, true);
		this.addRecipe(MBlocks.stonecutter, new ItemStack(Items.lava_bucket), 0.6F, true);
		this.addRecipe(MBlocks.roads, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.red_rock_wall, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.red_rock_wall_mossy, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.coldstone_wall, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.coldstone_wall_mossy, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.icestone_wall, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.icestone_wall_mossy, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.oceanstone_wall, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.oceanstone_wall_mossy, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.stone_boulder, new ItemStack(Items.lava_bucket), 0.6F, true);
		this.addRecipe(MBlocks.red_rock_boulder, new ItemStack(Items.lava_bucket), 0.6F, true);
		this.addRecipe(MBlocks.coldstone_boulder, new ItemStack(Items.lava_bucket), 0.6F, true);
		this.addRecipe(MBlocks.icestone_boulder, new ItemStack(Items.lava_bucket), 0.6F, true);
		this.addRecipe(MBlocks.oceanstone_boulder, new ItemStack(Items.lava_bucket), 0.6F, true);
		this.addRecipe(MBlocks.stone_lamp_glowstone, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.stone_lamp_sunstone, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.stone_lamp_prismarine, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.stone_pattern_bricks, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.stone_refined, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.stone_tiles, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.deepstone_stairs, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(MBlocks.redrock_stairs, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(MBlocks.deep_redrock_stairs, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(MBlocks.coldstone_stairs, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(MBlocks.deep_coldstone_stairs, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(MBlocks.icestone_stairs, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(MBlocks.glacierstone_stairs, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(MBlocks.oceanstone_stairs, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(MBlocks.poceanstone_stairs, new ItemStack(Items.lava_bucket), 0.4F, true);
		this.addRecipe(MBlocks.deepstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.redrock_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.deep_redrock_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.coldstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.deep_coldstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.icestone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.glacierstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.oceanstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F, true);
		this.addRecipe(MBlocks.poceanstone_brick_stairs, new ItemStack(Items.lava_bucket), 0.5F, true);
		
		//Minestrappolation Magma
		this.addRecipe(MBlocks.obsidian_bricks, new ItemStack(MBlocks.magmaBucket), 1.0F, true);
		
		//Misc
		this.addRecipe(Blocks.glowstone, new ItemStack(MBlocks.glow_glass), 1.0F, false);
		this.addDictionaryRecipes("oreTitanium", new ItemStack(MItems.titanium_ingot), 2.0F, false);
		this.addRecipe(new ItemStack(MItems.chunks, 1, 10), new ItemStack(MItems.titanium_ingot), 2.0F, false);
		this.addRecipe(MItems.fat, new ItemStack(MItems.grease, 2), 1.0F, false);
		this.addRecipe(MBlocks.continnium_ore, new ItemStack(MBlocks.hourglass_continurum, 1), 3.0F, Item.getItemFromBlock(MBlocks.hourglass_empty), true);
		this.addRecipe(MBlocks.dimensium_ore, new ItemStack(MItems.dimensium_ingot, 1), 3.0F, false);
		this.addRecipe(MItems.continnium_chunk, new ItemStack(MBlocks.hourglass_continurum, 1), 3.0F, Item.getItemFromBlock(MBlocks.hourglass_empty), true);
		this.addRecipe(MItems.dimensium_chunk, new ItemStack(MItems.dimensium_ingot, 1), 3.0F, false);
	}
	
	public void addRecipe(Block input, ItemStack stack, float experience, boolean bucket)
	{
		this.addRecipe(Item.getItemFromBlock(input), stack, experience, bucket);
		this.needBucket.put(Item.getItemFromBlock(input), bucket);
		this.container.put(Item.getItemFromBlock(input), Items.bucket);
	}
	
	public void addRecipe(Block input, ItemStack stack, float experience, Item container, boolean bucket)
	{
		this.addRecipe(Item.getItemFromBlock(input), stack, experience, bucket);
		this.needBucket.put(Item.getItemFromBlock(input), bucket);
		this.container.put(Item.getItemFromBlock(input), container);
	}
	
	public void addRecipe(Item input, ItemStack stack, float experience, Item container, boolean bucket)
	{
		this.addRecipe(input, stack, experience, bucket);
		this.needBucket.put(input, bucket);
		this.container.put(input, container);
	}
	
	public void addRecipe(Item input, ItemStack stack, float experience, boolean bucket)
	{
		this.addRecipe(new ItemStack(input, 1, 32767), stack, experience, bucket);
	}
	
	public void addRecipe(ItemStack input, ItemStack stack, float experience, boolean bucket)
	{
		this.meltingList.put(input, stack);
		this.experienceList.put(stack, Float.valueOf(experience));
		this.needBucket.put(input.getItem(), bucket);
		this.container.put(input.getItem(), Items.bucket);
	}
	
	public void addRecipe(ItemStack input, ItemStack stack, float experience, Item container, boolean bucket)
	{
		this.addRecipe(input, stack, experience, bucket);
		this.container.put(input.getItem(), container);
	}
	
	public boolean needsBucket(ItemStack stack)
	{
		if(this.needBucket.containsKey(stack.getItem()))
		{
			return (boolean)this.needBucket.get(stack.getItem());
		}
		return true;
	}
	
	public Item getRequiredContainer(ItemStack stack)
	{
		if(this.container.containsKey(stack.getItem()))
		{
			return this.container.get(stack.getItem());
		}
		return Items.bucket;
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
	
	public void addDictionaryRecipes(String name, ItemStack output, Float exp, boolean needsBucket)
    {
    	for(ItemStack is : OreDictionary.getOres(name))
    	{
    		this.addRecipe(is, output, exp, needsBucket);
    	}
    }
}