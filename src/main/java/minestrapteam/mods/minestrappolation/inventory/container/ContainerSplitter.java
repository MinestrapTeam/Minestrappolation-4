package minestrapteam.mods.minestrappolation.inventory.container;

import java.util.List;

import minestrapteam.mods.minestrappolation.crafting.recipes.MelterRecipes;
import minestrapteam.mods.minestrappolation.crafting.recipes.SplitterRecipes;
import minestrapteam.mods.minestrappolation.inventory.slot.SlotSplitter;
import minestrapteam.mods.minestrappolation.tileentity.TileEntitySplitter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSplitter extends MinestrappolationContainer
{
	private TileEntitySplitter	splitter;
	private int					lastSplitTime;
	private int					lastBurnTime;
	private int					lastMaxBurnTime;
	
	public ContainerSplitter(EntityPlayer player, TileEntitySplitter splitter)
	{
		super(player, splitter);
		
		this.splitter = splitter;
		this.lastSplitTime = 0;
		this.lastBurnTime = 0;
		this.lastMaxBurnTime = 0;
		
		// input
		this.addSlotToContainer(new Slot(splitter, 0, 79, 17));
		// fuel
		this.addSlotToContainer(new Slot(splitter, 1, 79, 53));
		// left_result
		this.addSlotToContainer(new SlotSplitter(player, splitter, 2, 56, 46));
		// right_result
		this.addSlotToContainer(new SlotSplitter(player, splitter, 3, 102, 46));
		
		this.addInventorySlots();
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		for (ICrafting crafting : (List<ICrafting>) this.crafters)
		{
			if (this.lastSplitTime != this.splitter.splitTime)
			{
				crafting.sendProgressBarUpdate(this, 0, this.splitter.splitTime);
			}
			if (this.lastBurnTime != this.splitter.burnTime)
			{
				crafting.sendProgressBarUpdate(this, 1, this.splitter.burnTime);
			}
			if (this.lastMaxBurnTime != this.splitter.maxBurnTime)
			{
				crafting.sendProgressBarUpdate(this, 2, this.splitter.maxBurnTime);
			}
		}
		this.lastSplitTime = this.splitter.splitTime;
		this.lastBurnTime = this.splitter.burnTime;
		this.lastMaxBurnTime = this.splitter.maxBurnTime;
	}
	
	@Override
	public void updateProgressBar(int id, int time)
	{
		if (id == 0)
		{
			this.splitter.splitTime = time;
		}
		
		if (id == 1)
		{
			this.splitter.burnTime = time;
		}
		
		if (id == 2)
		{
			this.splitter.maxBurnTime = time;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.splitter.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotID);
		
		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (slotID < 4)
			{
				if (!this.mergeItemStack(itemstack1, 4, 40, true))
					return null;
			}
			else if (SplitterRecipes.instance().getResult(itemstack1) != null)
			{
				if (!this.mergeItemStack(itemstack1, 0, 1, false))
					return null;
			}
			else if (TileEntitySplitter.isItemFuel(itemstack1))
			{
				if (!this.mergeItemStack(itemstack1, 1, 2, false))
					return null;
			}
			else if (slotID >= 3 && slotID < 31)
			{
				if (!this.mergeItemStack(itemstack1, 31, 40, false))
					return null;
			}
			else if (slotID >= 30 && slotID < 40)
			{
				if (!this.mergeItemStack(itemstack1, 4, 31, false))
					return null;
			}
			
			if (itemstack1.stackSize == 0)
			{
				slot.putStack(null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if (itemstack1.stackSize == itemstack.stackSize)
				return null;
			
			slot.onPickupFromSlot(player, itemstack);
		}
		
		return itemstack;
	}
}