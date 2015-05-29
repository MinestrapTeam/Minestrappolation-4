package minestrapteam.minestrappolation.crafting.stonecutter;

import java.util.ArrayList;
import java.util.List;

import minestrapteam.minestrappolation.util.MStacks;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ShapelessCuttingRecipe implements ICuttingRecipes
{
	public final List		recipeItems;
	public final ItemStack	recipeOutput;
	public final ItemStack	extraSlot;
	
	public ShapelessCuttingRecipe(ItemStack output, ItemStack extraSlot, Object... data)
	{
		ArrayList list = new ArrayList();
		int len = data.length;
		
		for (int i = 0; i < len; ++i)
		{
			Object o = data[i];
			
			if (o instanceof ItemStack)
			{
				list.add(((ItemStack) o).copy());
			}
			else if (o instanceof Item)
			{
				list.add(new ItemStack((Item) o));
			}
			else if (o instanceof Block)
			{
				list.add(new ItemStack((Block) o));
			}
			else
				throw new RuntimeException("Invalid shapeless recipy!");
		}
		
		this.recipeItems = list;
		this.recipeOutput = output;
		this.extraSlot = extraSlot;
	}
	
	public ShapelessCuttingRecipe(ItemStack output, List items, ItemStack extraSlot)
	{
		this.recipeOutput = output;
		this.recipeItems = items;
		this.extraSlot = extraSlot;
	}
	
	@Override
	public ItemStack getRecipeOutput()
	{
		return this.recipeOutput;
	}

	@Override
	public boolean matches(InventoryCrafting inventory, ItemStack extra, World par2World)
	{
		if (!MStacks.equals(this.extraSlot, extra))
			return false;
		
		ArrayList<ItemStack> list = new ArrayList(this.recipeItems);
		
		for (int i = 0; i < inventory.getSizeInventory(); ++i)
		{
			ItemStack stack = inventory.getStackInSlot(i);
			
			if (stack != null)
			{
				boolean flag = false;
				for (ItemStack stack1 : list)
				{
					if (MStacks.equals(stack, stack1))
					{
						flag = true;
						list.remove(stack1);
						break;
					}
				}
				
				if (!flag)
					return false;
			}
		}
		
		return list.isEmpty();
	}
	
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory, ItemStack extra)
	{
		return this.recipeOutput.copy();
	}
	
	@Override
	public int getRecipeSize()
	{
		return this.recipeItems.size();
	}
}