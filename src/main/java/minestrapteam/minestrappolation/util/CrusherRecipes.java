package minestrapteam.minestrappolation.util;

import java.util.HashMap;
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

public class CrusherRecipes
{
	private static final CrusherRecipes		crusherBase		= new CrusherRecipes();
	private Map								meltingList		= Maps.newHashMap();
	private Map								experienceList	= Maps.newHashMap();
	private Map								chance			= Maps.newHashMap();
	public HashMap<ItemStack, ItemStack>	extraDropList	= new HashMap<ItemStack, ItemStack>();
	
	public static CrusherRecipes instance()
	{
		return crusherBase;
	}
	
	private CrusherRecipes()
	{
		//Stones
		this.addRecipe(new ItemStack(Blocks.stone, 1, 0), new ItemStack(Blocks.cobblestone, 1), 0.05F, null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 0), new ItemStack(MBlocks.biome_cobble, 1, 0), 0.05F, null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 1), new ItemStack(MBlocks.biome_cobble, 1, 1), 0.05F, null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 2), new ItemStack(MBlocks.biome_cobble, 1, 2), 0.05F, null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 3), new ItemStack(MBlocks.biome_cobble, 1, 3), 0.05F, null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 4), new ItemStack(MBlocks.biome_cobble, 1, 4), 0.05F, null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 5), new ItemStack(MBlocks.biome_cobble, 1, 5), 0.05F, null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 6), new ItemStack(MBlocks.biome_cobble, 1, 6), 0.05F, null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 7), new ItemStack(MBlocks.biome_cobble, 1, 7), 0.05F, null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 8), new ItemStack(MBlocks.biome_cobble, 1, 8), 0.05F, null, 0);
		this.addRecipe(new ItemStack(Blocks.cobblestone, 1, 0), new ItemStack(Blocks.gravel, 1), 0.05F, new ItemStack(MItems.chunks, 1, 0), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 0), new ItemStack(Blocks.gravel, 1), 0.05F, new ItemStack(MItems.chunks, 1, 0), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 1), new ItemStack(Blocks.gravel, 1), 0.05F, new ItemStack(MItems.chunks, 1, 1), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 2), new ItemStack(Blocks.gravel, 1), 0.05F, new ItemStack(MItems.chunks, 1, 1), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 3), new ItemStack(Blocks.gravel, 1), 0.05F, new ItemStack(MItems.chunks, 1, 2), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 4), new ItemStack(Blocks.gravel, 1), 0.05F, new ItemStack(MItems.chunks, 1, 2), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 5), new ItemStack(Blocks.gravel, 1), 0.05F, new ItemStack(MItems.chunks, 1, 3), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 6), new ItemStack(Blocks.gravel, 1), 0.05F, new ItemStack(MItems.chunks, 1, 3), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 7), new ItemStack(Blocks.gravel, 1), 0.05F, new ItemStack(MItems.chunks, 1, 4), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 8), new ItemStack(Blocks.gravel, 1), 0.05F, new ItemStack(MItems.chunks, 1, 4), 5);
		this.addRecipe(new ItemStack(Blocks.stone, 1, 3), new ItemStack(MItems.desert_quartz_item, 2, 0), 0.1F, new ItemStack(MItems.chunks, 1, 0), 80);
		this.addRecipe(new ItemStack(Blocks.stone, 1, 1), new ItemStack(Blocks.stone, 1, 3), 0.1F, new ItemStack(MItems.desert_quartz_item, 1, 0), 80);
		this.addRecipe(new ItemStack(Blocks.stone, 1, 5), new ItemStack(Blocks.stone, 1, 3), 0.1F, new ItemStack(MItems.chunks, 1, 0), 80);
		this.addRecipe(new ItemStack(MBlocks.slate, 1, 0), new ItemStack(Items.clay_ball, 2, 0), 0.1F, new ItemStack(MItems.desert_quartz_item, 1, 0), 80);
		this.addRecipe(Blocks.sandstone, new ItemStack(Blocks.sand, 3, 0), 0.5F, new ItemStack(MItems.desert_quartz_item), 2);
		this.addRecipe(Blocks.red_sandstone, new ItemStack(Blocks.sand, 3, 1), 0.5F, new ItemStack(MItems.desert_quartz_item), 2);
		this.addRecipe(Blocks.hardened_clay, new ItemStack(Blocks.sand, 1, 1), 0.2F, null, 0);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 0), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 15), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 1), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 14), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 2), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 13), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 3), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 12), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 4), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 11), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 5), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 10), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 6), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 9), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 7), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 8), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 8), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 7), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 9), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 6), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 10), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 5), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 11), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 4), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 12), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 3), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 13), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 2), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 14), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 1), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 15), new ItemStack(Blocks.sand, 1, 1), 0.2F, new ItemStack(Items.dye, 1, 0), 5);
		this.addRecipe(new ItemStack(Blocks.prismarine, 1, 0), new ItemStack(Items.prismarine_shard, 3, 0), 0.3F, new ItemStack(Items.prismarine_crystals, 1, 0), 3);
		this.addRecipe(new ItemStack(Items.prismarine_shard, 1, 0), new ItemStack(MItems.chunks, 1, 3), 0.1F, new ItemStack(MItems.radiant_quartz, 1, 0), 1);
		this.addRecipe(new ItemStack(Blocks.quartz_block, 1), new ItemStack(Items.quartz, 3, 0), 0.1F, new ItemStack(Items.quartz, 1, 0), 10);
		
		//Ores
		this.addRecipe(Blocks.coal_ore, new ItemStack(Items.coal, 3, 0), 0.05F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 0), new ItemStack(Items.coal, 3, 0), 0.05F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 1), new ItemStack(Items.coal, 3, 0), 0.05F, new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 2), new ItemStack(Items.coal, 3, 0), 0.05F, new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 3), new ItemStack(Items.coal, 3, 0), 0.05F, new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 4), new ItemStack(Items.coal, 3, 0), 0.05F, new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 5), new ItemStack(Items.coal, 3, 0), 0.05F, new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 6), new ItemStack(Items.coal, 3, 0), 0.05F, new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 7), new ItemStack(Items.coal, 3, 0), 0.05F, new ItemStack(MItems.chunks, 1, 4), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 8), new ItemStack(Items.coal, 3, 0), 0.05F, new ItemStack(MItems.chunks, 1, 4), 20);
		
		this.addRecipe(Blocks.iron_ore, new ItemStack(MItems.chunks, 2, 7), 0.35F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 0), new ItemStack(MItems.chunks, 2, 7), 0.35F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 1), new ItemStack(MItems.chunks, 2, 7), 0.35F, new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 2), new ItemStack(MItems.chunks, 2, 7), 0.35F, new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 3), new ItemStack(MItems.chunks, 2, 7), 0.35F, new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 4), new ItemStack(MItems.chunks, 2, 7), 0.35F, new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 5), new ItemStack(MItems.chunks, 2, 7), 0.35F, new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 6), new ItemStack(MItems.chunks, 2, 7), 0.35F, new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 7), new ItemStack(MItems.chunks, 2, 7), 0.35F, new ItemStack(MItems.chunks, 1, 4), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 8), new ItemStack(MItems.chunks, 2, 7), 0.35F, new ItemStack(MItems.chunks, 1, 4), 20);
		
		this.addRecipe(Blocks.gold_ore, new ItemStack(MItems.chunks, 2, 8), 0.5F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 0), new ItemStack(MItems.chunks, 2, 8), 0.5F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 1), new ItemStack(MItems.chunks, 2, 8), 0.5F, new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 2), new ItemStack(MItems.chunks, 2, 8), 0.5F, new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 3), new ItemStack(MItems.chunks, 2, 8), 0.5F, new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 4), new ItemStack(MItems.chunks, 2, 8), 0.5F, new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 5), new ItemStack(MItems.chunks, 2, 8), 0.5F, new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 6), new ItemStack(MItems.chunks, 2, 8), 0.5F, new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 7), new ItemStack(MItems.chunks, 2, 8), 0.5F, new ItemStack(MItems.chunks, 1, 4), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 8), new ItemStack(MItems.chunks, 2, 8), 0.5F, new ItemStack(MItems.chunks, 1, 4), 20);
		
		this.addRecipe(Blocks.redstone_ore, new ItemStack(Items.redstone, 9, 0), 0.35F, new ItemStack(Items.glowstone_dust), 5);
		this.addRecipe(MBlocks.biome_redstone, new ItemStack(Items.redstone, 9, 0), 0.35F, new ItemStack(Items.glowstone_dust), 5);
		
		this.addRecipe(Blocks.lapis_ore, new ItemStack(Items.dye, 18, 4), 0.1F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 0), new ItemStack(Items.dye, 18, 4), 0.1F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 1), new ItemStack(Items.dye, 18, 4), 0.1F, new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 2), new ItemStack(Items.dye, 18, 4), 0.1F, new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 3), new ItemStack(Items.dye, 18, 4), 0.1F, new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 4), new ItemStack(Items.dye, 18, 4), 0.1F, new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 5), new ItemStack(Items.dye, 18, 4), 0.1F, new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 6), new ItemStack(Items.dye, 18, 4), 0.1F, new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 7), new ItemStack(Items.dye, 18, 4), 0.1F, new ItemStack(MItems.chunks, 1, 4), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 8), new ItemStack(Items.dye, 18, 4), 0.1F, new ItemStack(MItems.chunks, 1, 4), 20);
		
		this.addRecipe(Blocks.emerald_ore, new ItemStack(Items.emerald, 2, 0), 0.5F, new ItemStack(Items.diamond), 5);
		this.addRecipe(MBlocks.biome_emerald, new ItemStack(Items.emerald, 2, 0), 0.5F, new ItemStack(Items.diamond), 5);
		
		this.addRecipe(Blocks.diamond_ore, new ItemStack(Items.diamond, 2, 0), 0.5F, new ItemStack(Items.emerald), 5);
		this.addRecipe(MBlocks.biome_diamond, new ItemStack(Items.diamond, 2, 0), 0.5F, new ItemStack(Items.emerald), 5);
		
		this.addRecipe(Blocks.quartz_ore, new ItemStack(Items.quartz, 3, 0), 0.5F, new ItemStack(MItems.radiant_quartz), 2);
		
		this.addRecipe(MBlocks.copper_ore, new ItemStack(MItems.chunks, 2, 5), 0.25F, new ItemStack(MItems.chunks, 1, 6), 8);
		this.addRecipe(MBlocks.biome_copper, new ItemStack(MItems.chunks, 2, 5), 0.25F, new ItemStack(MItems.chunks, 1, 6), 8);
		
		this.addRecipe(MBlocks.tin_ore, new ItemStack(MItems.chunks, 2, 6), 0.25F, new ItemStack(MItems.chunks, 1, 5), 8);
		this.addRecipe(MBlocks.biome_tin, new ItemStack(MItems.chunks, 2, 6), 0.25F, new ItemStack(MItems.chunks, 1, 5), 8);
		
		this.addRecipe(MBlocks.meurodite_ore, new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 0), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 1), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F, new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 2), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F, new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 3), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F, new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 4), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F, new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 5), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F, new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 6), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F, new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 7), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F, new ItemStack(MItems.chunks, 1, 4), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 8), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F, new ItemStack(MItems.chunks, 1, 4), 20);
		
		this.addRecipe(MBlocks.torite_ore, new ItemStack(MItems.chunks, 2, 9), 0.6F, new ItemStack(Items.emerald), 1);
		this.addRecipe(MBlocks.biome_torite, new ItemStack(MItems.chunks, 2, 9), 0.6F, new ItemStack(Items.emerald), 1);
		
		this.addRecipe(MBlocks.sunstone_ore, new ItemStack(MItems.sunstone_shard, 6, 0), 0.5F, new ItemStack(Items.glowstone_dust), 5);
		this.addRecipe(MBlocks.biome_sunstone, new ItemStack(MItems.sunstone_shard, 6, 0), 0.5F, new ItemStack(Items.glowstone_dust), 5);
		
		this.addRecipe(MBlocks.plutonium_ore, new ItemStack(MItems.plutonium, 3, 0), 0.5F, new ItemStack(MItems.uranium), 3);
		this.addRecipe(MBlocks.biome_plutonium, new ItemStack(MItems.plutonium, 3, 0), 0.5F, new ItemStack(MItems.uranium), 3);
		
		this.addRecipe(MBlocks.uranium_ore, new ItemStack(MItems.uranium, 3, 0), 0.5F, new ItemStack(MItems.plutonium), 3);
		this.addRecipe(MBlocks.biome_uranium, new ItemStack(MItems.uranium, 3, 0), 0.5F, new ItemStack(MItems.plutonium), 3);
		
		//Misc
		this.addRecipe(Blocks.clay, new ItemStack(Blocks.sand, 1, 0), 0.1F, new ItemStack(Items.clay_ball, 2, 0), 50);
		this.addRecipe(Blocks.gravel, new ItemStack(Blocks.sand, 1, 0), 0.05F, new ItemStack(Items.flint, 1, 0), 30);
		this.addRecipe(new ItemStack(Blocks.dirt, 1, 1), new ItemStack(Blocks.dirt, 1, 0), 0.05F, new ItemStack(Items.flint, 1, 0), 10);
		this.addRecipe(Blocks.bookshelf, new ItemStack(Items.book, 3), 0.05F, new ItemStack(Items.paper, 1), 5);
		this.addRecipe(Blocks.web, new ItemStack(Items.string, 4), .2F, new ItemStack(Items.spider_eye, 1, 0), 20);
		this.addRecipe(Blocks.ladder, new ItemStack(Items.stick, 1), 0.05F, new ItemStack(Items.stick, 1), 50);
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
		this.extraDropList.put(input, extra);
		this.chance.put(input, chance);
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
	
	public ItemStack getExtra(ItemStack stack)
	{
		Iterator iterator = this.extraDropList.entrySet().iterator();
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
	
	public int getChance(ItemStack stack)
	{
		Iterator iterator = this.chance.entrySet().iterator();
		Entry entry;
		
		do
		{
			if (!iterator.hasNext())
				return 0;
			
			entry = (Entry) iterator.next();
		}
		while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));
		
		return (Integer) entry.getValue();
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