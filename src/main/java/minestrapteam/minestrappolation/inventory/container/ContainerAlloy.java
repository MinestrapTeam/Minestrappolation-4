package minestrapteam.minestrappolation.inventory.container;

import java.util.List;

import minestrapteam.minestrappolation.crafting.recipes.AlloyRecipes;
import minestrapteam.minestrappolation.crafting.recipes.MelterRecipes;
import minestrapteam.minestrappolation.tileentity.TileEntityAlloy;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;
import minestrapteam.minestrappolation.util.MinistrappolationInventoryHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerAlloy extends MinistrappolationInventoryHandler
{
	private TileEntityAlloy	furnace;
	private int				lastSmeltTime;
	private int				lastBurnTime;
	private int				lastMaxBurnTime;
	
	public ContainerAlloy(EntityPlayer player, TileEntityAlloy furnace)
	{
		super(player, furnace);
		
		this.furnace = furnace;
		this.lastSmeltTime = 0;
		this.lastBurnTime = 0;
		this.lastMaxBurnTime = 0;
		// input1
		this.addSlotToContainer(new Slot(furnace, 0, 37, 17));
		// fuel
		this.addSlotToContainer(new Slot(furnace, 1, 46, 53));
		// result
		this.addSlotToContainer(new Slot(furnace, 2, 116, 35));
		// smelt2
		this.addSlotToContainer(new Slot(furnace, 3, 55, 17));
		
		this.addInventorySlots();
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		for (ICrafting crafting : (List<ICrafting>) this.crafters)
		{
			if (this.lastSmeltTime != this.furnace.meltTime)
			{
				crafting.sendProgressBarUpdate(this, 0, this.furnace.meltTime);
			}
			if (this.lastBurnTime != this.furnace.burnTime)
			{
				crafting.sendProgressBarUpdate(this, 1, this.furnace.burnTime);
			}
			if (this.lastMaxBurnTime != this.furnace.maxBurnTime)
			{
				crafting.sendProgressBarUpdate(this, 2, this.furnace.maxBurnTime);
			}
		}
		this.lastSmeltTime = this.furnace.meltTime;
		this.lastBurnTime = this.furnace.burnTime;
		this.lastMaxBurnTime = this.furnace.maxBurnTime;
	}
	
	@Override
	public void updateProgressBar(int id, int time)
	{
		if (id == 0)
		{
			this.furnace.meltTime = time;
		}
		
		if (id == 1)
		{
			this.furnace.burnTime = time;
		}
		
		if (id == 2)
		{
			this.furnace.maxBurnTime = time;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.furnace.isUseableByPlayer(player);
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
			else if (TileEntityAlloy.isItemFuel(itemstack1))
			{
				if (!this.mergeItemStack(itemstack1, 1, 2, false))
					return null;
			}
			else if (slotID >= 3 && slotID < 30)
			{
				if (!this.mergeItemStack(itemstack1, 31, 40, false))
					return null;
			}
			else if (slotID >= 30 && slotID < 39)
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