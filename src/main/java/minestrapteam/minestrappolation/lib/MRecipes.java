package minestrapteam.minestrappolation.lib;

import java.util.Iterator;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MRecipes
{
	
	public static void register()
	{
		// Food
		GameRegistry.addRecipe(new ItemStack(MItems.dough, 2), new Object[] { "WW", "WW", 'W', Items.wheat });
		GameRegistry.addSmelting(new ItemStack(MItems.dough), new ItemStack(Items.bread), 0.3F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.sugar_dough, 2), new Object[] { MItems.dough, Items.sugar });
		GameRegistry.addSmelting(new ItemStack(MItems.sugar_dough), new ItemStack(MItems.sugar_cookie, 6), 0.2F);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.chocolate_dough, 2), new Object[] { MItems.dough, new ItemStack(Items.dye, 1, 3) });
		GameRegistry.addSmelting(new ItemStack(MItems.chocolate_dough), new ItemStack(Items.cookie, 6), 0.2F);
		
		// Minerals
		GameRegistry.addSmelting(MBlocks.copper_ore, new ItemStack(MItems.copper_ingot), 0.5F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.copper_block), new Object[] { "III", "III", "III", 'I', MItems.copper_ingot });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.copper_ingot, 9), new Object[] { MBlocks.copper_block });
		
		GameRegistry.addSmelting(MBlocks.tin_ore, new ItemStack(MItems.tin_ingot), 0.5F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.tin_block), new Object[] { "III", "III", "III", 'I', MItems.tin_ingot });
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.tin_ingot, 9), new Object[] { MBlocks.tin_block });
		
		GameRegistry.addSmelting(MBlocks.sunstone_ore, new ItemStack(MItems.sunstone_shard), 1.0F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.sunstone_block), new Object[] { "SS", "SS", 'S', MItems.sunstone_shard });
		
		// Decor
		GameRegistry.addRecipe(new ItemStack(MBlocks.snow_bricks, 4), new Object[] { "SS", "SS", 'S', Blocks.snow });
		GameRegistry.addRecipe(new ItemStack(MBlocks.snow_refined, 9), new Object[] { "SSS", "SSS", "SSS", 'S', Blocks.snow });
		GameRegistry.addRecipe(new ItemStack(MBlocks.snow_tiles, 4), new Object[] { "SS", "SS", 'S', MBlocks.snow_refined });
		GameRegistry.addRecipe(new ItemStack(MBlocks.glass_bricks, 4), new Object[] { "GG", "GG", 'G', Blocks.glass });
		GameRegistry.addSmelting(new ItemStack(Blocks.glass), new ItemStack(MBlocks.glass_refined), .1F);
		GameRegistry.addRecipe(new ItemStack(MBlocks.glass_tiles, 4), new Object[] { "GG", "GG", 'G', MBlocks.glass_refined });
		GameRegistry.addRecipe(new ItemStack(MBlocks.glass_window, 4), new Object[] { "IGI", "GIG", "IGI", 'I', Blocks.iron_bars, 'G', MBlocks.glass_refined });
		
		// Wood
		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.ministrapp_planks, 4, 0), new Object[] { new ItemStack(MBlocks.ministrapp_log, 1, 0) });
		
		// Tools and Weapons
		GameRegistry.addRecipe(new ItemStack(MItems.copper_pickaxe), new Object[] { "III", " S ", " S ", 'I', MItems.copper_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.copper_axe), new Object[] { "II", "IS", " S", 'I', MItems.copper_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.copper_shovel), new Object[] { "I", "S", "S", 'I', MItems.copper_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.copper_hoe), new Object[] { "II", " S", " S", 'I', MItems.copper_ingot, 'S', Items.stick });
		GameRegistry.addRecipe(new ItemStack(MItems.copper_sword), new Object[] { "I", "I", "S", 'I', MItems.copper_ingot, 'S', Items.stick });
		
		GameRegistry.addRecipe(new ItemStack(MItems.tin_helmet), new Object[] { "III", "I I", 'I', MItems.tin_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.tin_chestplate), new Object[] { "I I", "III", "III", 'I', MItems.tin_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.tin_leggings), new Object[] { "III", "I I", "I I", 'I', MItems.tin_ingot });
		GameRegistry.addRecipe(new ItemStack(MItems.tin_boots), new Object[] { "I I", "I I", 'I', MItems.tin_ingot });
	}
	
	public static void removeRecipes()
	{
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		
		Iterator<IRecipe> remover = recipes.iterator();
		
		while (remover.hasNext())
		{
			ItemStack itemstack = remover.next().getRecipeOutput();
			if (itemstack != null && itemstack.getItem() == Items.bread)
			{
				remover.remove();
			}
			if (itemstack != null && itemstack.getItem() == Items.cookie)
			{
				remover.remove();
			}
		}
	}
	
}
