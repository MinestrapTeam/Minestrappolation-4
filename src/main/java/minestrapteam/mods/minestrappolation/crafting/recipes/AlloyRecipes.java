package minestrapteam.mods.minestrappolation.crafting.recipes;

import com.google.common.collect.Maps;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.util.MGameUtil;
import minestrapteam.mods.minestrappolation.util.MStacks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class AlloyRecipes
{
	private Map<ItemStack, Float>							experienceList	= Maps.newHashMap();
	private Map<ItemStack, Integer>							stack1Size		= Maps.newHashMap();
	private Map<ItemStack, Integer>							stack2Size		= Maps.newHashMap();
	
	public AlloyRecipes()
	{
		//Stones
		this.addRecipe(new ItemStack(Blocks.COBBLESTONE, 4, 0), new ItemStack(Blocks.QUARTZ_BLOCK, 1, 0), new ItemStack(Blocks.STONE, 4, 3), 0.3F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 4, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.QUARTZ_BLOCK, 1, 0), new ItemStack(Blocks.STONE, 4, 3), 0.3F);
		this.addRecipe(new ItemStack(Blocks.COBBLESTONE, 4, 0), new ItemStack(MBlocks.desert_quartz_block, 1, 0), new ItemStack(Blocks.STONE, 4, 3), 0.3F);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 4, OreDictionary.WILDCARD_VALUE), new ItemStack(MBlocks.desert_quartz_block, 1, 0), new ItemStack(Blocks.STONE, 4, 3), 0.3F);
		this.addRecipe(new ItemStack(Blocks.STONE, 4, 3), new ItemStack(Blocks.COBBLESTONE, 4, 0), new ItemStack(Blocks.STONE, 6, 5), 0.3F);
		this.addRecipe(new ItemStack(Blocks.STONE, 4, 3), new ItemStack(MBlocks.biome_cobble, 4, OreDictionary.WILDCARD_VALUE), new ItemStack(Blocks.STONE, 6, 5), 0.3F);
		this.addRecipe(new ItemStack(Blocks.STONE, 4, 3), new ItemStack(Blocks.QUARTZ_BLOCK, 1, 0), new ItemStack(Blocks.STONE, 4, 1), 0.3F);
		this.addRecipe(new ItemStack(Blocks.STONE, 4, 3), new ItemStack(MBlocks.desert_quartz_block, 1, 0), new ItemStack(Blocks.STONE, 4, 1), 0.3F);
		this.addRecipe(new ItemStack(Blocks.CLAY, 4, 0), new ItemStack(Blocks.QUARTZ_BLOCK, 1, 0), new ItemStack(MBlocks.slate, 4, 0), 0.3F);
		this.addRecipe(new ItemStack(Blocks.CLAY, 4, 0), new ItemStack(MBlocks.desert_quartz_block, 1, 0), new ItemStack(MBlocks.slate, 4, 0), 0.3F);
		
		//Minerals
		this.addDictionaryRecipes("ingotTin", 3, "ingotCopper", 3, new ItemStack(MItems.bronze_ingot), 1F);
		this.addRecipe(new ItemStack(Items.IRON_INGOT, 1, 0), new ItemStack(Items.COAL, 6, 0), new ItemStack(MItems.steel_ingot), 1F);
		this.addRecipe(new ItemStack(Items.PRISMARINE_SHARD, 1), new ItemStack(MItems.sunstone_shard, 1), new ItemStack(Items.PRISMARINE_CRYSTALS), 1F);
		this.addRecipe(new ItemStack(MItems.chunks, 8, 3), new ItemStack(MItems.radiant_quartz, 1), new ItemStack(Items.PRISMARINE_CRYSTALS, 8), 1.5F);
		this.addRecipe(new ItemStack(Items.BLAZE_POWDER, 1), new ItemStack(MItems.sunstone_shard, 1), new ItemStack(MItems.blaze_shard), 1F);
		this.addRecipe(new ItemStack(Items.BONE, 1), new ItemStack(MItems.blaze_shard, 4), new ItemStack(Items.BLAZE_ROD), 1F);
		this.addRecipe(new ItemStack(MItems.blaze_shard, 4), new ItemStack(Items.GOLD_INGOT, 1), new ItemStack(MItems.blazium_ingot), 1F);
		this.addRecipe(new ItemStack(MItems.glacieric_ice_shard, 4), new ItemStack(MItems.torite_ingot, 1), new ItemStack(MItems.glacierite_ingot), 1F);
		
		//Food
		this.addRecipe(new ItemStack(MItems.dough, 1), new ItemStack(Items.BOWL, 1), new ItemStack(MItems.bread_bowl, 1), 0.2F);
		this.addRecipe(new ItemStack(MItems.corn_meal, 1), new ItemStack(Items.BOWL, 1), new ItemStack(MItems.bread_bowl, 1), 0.2F);
		this.addRecipe(new ItemStack(MItems.dough, 1), new ItemStack(MBlocks.pepper_seed, 1), new ItemStack(MItems.bun, 2), 0.2F);
		this.addRecipe(new ItemStack(Blocks.PUMPKIN, 1), new ItemStack(MItems.pie_crust, 2), new ItemStack(Items.PUMPKIN_PIE, 2), 0.4F);
		this.addRecipe(new ItemStack(Items.APPLE, 2), new ItemStack(MItems.pie_crust, 2), new ItemStack(MItems.apple_pie, 2), 0.4F);
		this.addRecipe(new ItemStack(Items.EGG, 1), new ItemStack(MItems.bread_bowl, 1), new ItemStack(MItems.bread_fried_egg, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.EGG, 1), new ItemStack(Items.BOWL, 1), new ItemStack(MItems.fried_egg, 1), 0.3F);
		this.addRecipe(new ItemStack(MItems.corn_on_stick, 1), new ItemStack(MItems.fat, 1), new ItemStack(MItems.grilled_corn), 0.4F);
		this.addRecipe(new ItemStack(MBlocks.corn, 1), new ItemStack(Items.BOWL, 1), new ItemStack(MItems.popcorn, 1), 0.3F);
		this.addRecipe(new ItemStack(MBlocks.corn, 1), new ItemStack(MItems.bread_bowl, 1), new ItemStack(MItems.bread_popcorn, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.POTATO, 1), new ItemStack(MItems.grease, 1), new ItemStack(MItems.fries, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.COOKED_FISH, 1, 0), new ItemStack(MItems.grease, 1), new ItemStack(MItems.fried_fish, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.COOKED_FISH, 1, 1), new ItemStack(MItems.grease, 1), new ItemStack(MItems.fried_salmon, 1), 0.3F);
		this.addRecipe(new ItemStack(MItems.tomato_sauce, 1), new ItemStack(MItems.fat, 1), new ItemStack(MItems.tomato_soup, 1), 0.3F);
		this.addRecipe(new ItemStack(MItems.bread_tomato_sauce, 1), new ItemStack(MItems.fat, 1), new ItemStack(MItems.bread_tomato_soup, 1), 0.3F);
		this.addRecipe(new ItemStack(MItems.tomato_sauce, 1), new ItemStack(MItems.dry_spaghetti, 1), new ItemStack(MItems.spaghetti, 1), 0.3F);
		this.addRecipe(new ItemStack(MItems.bread_tomato_sauce, 1), new ItemStack(MItems.dry_spaghetti, 1), new ItemStack(MItems.bread_spaghetti, 1), 0.3F);
		this.addRecipe(new ItemStack(MItems.dough, 1), new ItemStack(MBlocks.steel_mesh, 0), new ItemStack(MItems.dry_spaghetti, 1), 0.2F);
		
		//Misc
		this.addRecipe(new ItemStack(Blocks.SAND, 1), new ItemStack(Blocks.SAND, 1), new ItemStack(MBlocks.glass_refined, 2), 0.3F);
		this.addRecipe(new ItemStack(Items.BLAZE_POWDER, 1), new ItemStack(Items.ENDER_PEARL, 1), new ItemStack(Items.ENDER_EYE, 1), 1.0F);
		for(int i = 0; i<15 ; i++)
		{
			this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Blocks.LOG, 2, i), new ItemStack(Items.LEATHER, 1), 0.3F);
			this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Blocks.LOG2, 2, i), new ItemStack(Items.LEATHER, 1), 0.3F);
			this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(MBlocks.ministrapp_log, 2, i), new ItemStack(Items.LEATHER, 1), 0.3F);
			this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Blocks.LEAVES, 12, i), new ItemStack(Items.LEATHER, 1), 0.3F);
			this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Blocks.LEAVES2, 12, i), new ItemStack(Items.LEATHER, 1), 0.3F);
			this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(MBlocks.ministrapp_leaves, 12, i), new ItemStack(Items.LEATHER, 1), 0.3F);
		}
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Items.APPLE, 2), new ItemStack(Items.LEATHER, 2), 0.3F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Items.CARROT, 3), new ItemStack(Items.LEATHER, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Items.POTATO, 3), new ItemStack(Items.LEATHER, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(MBlocks.lettuce, 4), new ItemStack(Items.LEATHER, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(MBlocks.cabbage, 4), new ItemStack(Items.LEATHER, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(MItems.celery, 5), new ItemStack(Items.LEATHER, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(MItems.pepper, 3), new ItemStack(Items.LEATHER, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(MBlocks.onion, 1), new ItemStack(Items.LEATHER, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Items.POISONOUS_POTATO, 1), new ItemStack(Items.LEATHER, 2), 0.3F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Items.DYE, 2, 1), new ItemStack(Items.LEATHER, 1), 0.3F);	
		this.addRecipe(new ItemStack(MBlocks.purple_glowshroom, 8), new ItemStack(Blocks.PUMPKIN, 1), new ItemStack(Blocks.LIT_PUMPKIN, 1), 0.3F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Items.POTIONITEM, 1, 8193), new ItemStack(MItems.flesh, 1), 0.8F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Items.POTIONITEM, 1, 8257), new ItemStack(MItems.flesh, 1), 0.8F);
		this.addRecipe(new ItemStack(Items.ROTTEN_FLESH, 1), new ItemStack(Items.POTIONITEM, 1, 8225), new ItemStack(MItems.flesh, 1), 0.8F);
	}
	
	public class AlloyRecipe
    {
        private final ItemStack baseItem;
        private final ItemStack first;
        private final ItemStack result;

        public AlloyRecipe(final ItemStack first, final ItemStack baseItem, final ItemStack result)
        {
            this.first = first;
            this.baseItem = baseItem;
            this.result = result;
        }

        public ItemStack getCraftingResult()
        {
            return this.result.copy();
        }

        public ItemStack[] getIngredients()
        {
            return new ItemStack[] { this.first, this.baseItem };
        }

        @SuppressWarnings("unused")
		public boolean matches(final ItemStack first, final ItemStack second)
        {
            if (first.isItemEqual(second)) { return false; }

            if (this.uses(first) && this.uses(second)) { return true; }

            if (this.uses(first) && (second == null)) { return true; }

            if (this.uses(second) && (first == null)) { return true; }

            return this.matchesOreDict(first, second);
        }

        private boolean matchesOreDict(final ItemStack first, final ItemStack second)
        {
            if (MGameUtil.matchesOreDict(first,this.first) && MGameUtil.matchesOreDict(second, this.baseItem)) { return true; }

            if (MGameUtil.matchesOreDict(first,this.baseItem) && MGameUtil.matchesOreDict(second, this.first)) { return true; }

            if (MGameUtil.matchesOreDict(first, this.first) && (second == null)) { return true; }

            if (MGameUtil.matchesOreDict(second, this.first) && (first == null)) { return true; }

            return false;
        }

        public boolean uses(final ItemStack ingredient)
        {
            if (ingredient == null) { return false; }

            if ((this.first != null) && this.first.isItemEqual(ingredient))
            {
                return true;
            }
            else if ((this.baseItem != null) && this.baseItem.isItemEqual(ingredient)) { return true; }

            return false;
        }
    }

    private static AlloyRecipes instance = new AlloyRecipes();

    public static AlloyRecipes getInstance()
    {
        return AlloyRecipes.instance;
    }

    private final ArrayList<AlloyRecipe> recipes = new ArrayList<AlloyRecipe>();

    public void addRecipe(ItemStack itemStack, ItemStack otherItemStack, ItemStack output, float experience)
    {
        this.recipes.add(new AlloyRecipe(itemStack, otherItemStack, output));
        
        this.stack1Size.put(itemStack, itemStack.getCount());
		this.stack2Size.put(otherItemStack, otherItemStack.getCount());
		
		this.stack1Size.put(otherItemStack, otherItemStack.getCount());
		this.stack2Size.put(itemStack, itemStack.getCount());
		
        this.experienceList.put(output, Float.valueOf(experience));
    }

    public ItemStack getAlloyResult(ItemStack itemStack, ItemStack otherItemStack)
    {
        for (int j = 0; j < this.recipes.size(); ++j)
        {
            AlloyRecipe irecipe = this.recipes.get(j);

            if (irecipe.matches(itemStack, otherItemStack)) 
            { 
            	if((MStacks.equals(itemStack, irecipe.first) && MStacks.equals(otherItemStack, irecipe.baseItem)) || (MStacks.equals(otherItemStack, irecipe.first) && MStacks.equals(itemStack, irecipe.baseItem)))
            	{
            		return irecipe.getCraftingResult(); 
            	}
            }
        }

        return null;
    }

    public boolean hasUsage(ItemStack itemStack)
    {
        for (int j = 0; j < this.recipes.size(); ++j)
        {
            AlloyRecipe irecipe = this.recipes.get(j);

            if (irecipe.uses(itemStack)) 
            { 
            	return true; 
            }
        }
        return false;
    }

    public ArrayList<AlloyRecipe> getRecipesFor(ItemStack output)
    {
        ArrayList<AlloyRecipe> list = new ArrayList<AlloyRecipe>();

        for (AlloyRecipe alloyRecipe : this.recipes)
        {
            if (alloyRecipe.result.isItemEqual(output) && alloyRecipe.result.getTagCompound() == output.getTagCompound())
            {
                list.add(alloyRecipe);
            }
        }
        return list;
    }

    public ArrayList<AlloyRecipe> getRecipesUsing(ItemStack ingredient)
    {
        ArrayList<AlloyRecipe> list = new ArrayList<AlloyRecipe>();

        for (AlloyRecipe alloyRecipe : this.recipes)
        {
            if (alloyRecipe.uses(ingredient))
            {
                list.add(alloyRecipe);
                continue;
            }

            if (MGameUtil.matchesOreDict(ingredient, alloyRecipe.first))
            {
                list.add(new AlloyRecipe(ingredient, alloyRecipe.baseItem.copy(), alloyRecipe.result.copy()));
                continue;
            }

            if (MGameUtil.matchesOreDict(ingredient, alloyRecipe.baseItem))
            {
                list.add(new AlloyRecipe(alloyRecipe.first.copy(), ingredient, alloyRecipe.result.copy()));
            }
        }
        return list;
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
	
	public void addDictionaryRecipes(String name, int amount, String otherName, int amount2, ItemStack output, Float exp)
    {
		ItemStack[] set1 = OreDictionary.getOres(name).toArray(new ItemStack[OreDictionary.getOres(name).size()]);
		ItemStack[] set2 = OreDictionary.getOres(otherName).toArray(new ItemStack[OreDictionary.getOres(otherName).size()]);
	
    	for(int i = 0; i < set1.length; i++)
    	{
    		for(int i2 = 0; i2 < set2.length; i2++)
    		{
    			this.addRecipe(new ItemStack(set1[i].getItem(), amount), new ItemStack(set2[i2].getItem(), amount2), output, exp);
    		}
    	}	
    }
}