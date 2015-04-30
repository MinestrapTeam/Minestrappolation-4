package com.delocuro.ministrappolation.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class MinistrappolationInventoryHandler extends Container
{
	public final IInventory		inventory;
	public final EntityPlayer	player;
	
	public MinistrappolationInventoryHandler(EntityPlayer player, IInventory inventory)
	{
		this.inventory = inventory;
		this.player = player;
	}
	
	public final void addInventorySlots()
	{
		this.addInventorySlots(8, 84, 142);
	}
	
	@Deprecated
	public final void addInventorySlots(int xOffset, int yOffset)
	{
		this.addInventorySlots(8 + xOffset, 84 + yOffset, 142 + yOffset);
	}
	
	public final void addInventorySlots(int xOffset, int yOffset, int yHotbar)
	{
		InventoryPlayer inventory = this.player.inventory;
		
		for (int i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(inventory, 9 + j + i * 9, xOffset + j * 18, yOffset + i * 18));
			}
		}
		
		for (int i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(inventory, i, xOffset + i * 18, yHotbar));
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.inventory.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		int inv_low = this.inventory.getSizeInventory();
		int inv_high = inv_low + 27;
		int hotbar_low = inv_high;
		int hotbar_high = hotbar_low + 9;
		
		ItemStack theStack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotID);
		
		if (slot != null && slot.getHasStack())
		{
			ItemStack stack = slot.getStack();
			theStack = stack.copy();
			int[] merge;
			
			if (slotID < inv_low)
			{
				if (!this.mergeItemStack(stack, inv_low, hotbar_high, false))
					return null;
			}
			else if (slotID >= inv_low && slotID < hotbar_high && (merge = this.merge(player, slotID, stack)) != null)
			{
				int i = merge[0];
				int j = merge.length > 1 ? merge[1] : i + 1;
				if (!this.mergeItemStack(stack, i, j, false))
					return null;
			}
			else if (slotID >= inv_low && slotID < inv_high)
			{
				if (!this.mergeItemStack(stack, hotbar_low, hotbar_high, false))
					return null;
			}
			else if (slotID >= hotbar_low && slotID < hotbar_high)
			{
				if (!this.mergeItemStack(stack, inv_low, inv_high, false))
					return null;
			}
			else if (!this.mergeItemStack(stack, inv_low, hotbar_high, false))
				return null;
			
			if (stack.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if (stack.stackSize == theStack.stackSize)
				return null;
			
			slot.onPickupFromSlot(player, stack);
		}
		
		return theStack;
	}
	
	public int[] merge(EntityPlayer player, int slot, ItemStack stack)
	{
		return null;
	}
}
