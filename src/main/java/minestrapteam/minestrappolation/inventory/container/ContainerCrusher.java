package minestrapteam.minestrappolation.inventory.container;

import java.util.List;

import minestrapteam.minestrappolation.tileentity.TileEntityCrusher;
import minestrapteam.minestrappolation.util.CrusherRecipes;
import minestrapteam.minestrappolation.util.MinistrappolationInventoryHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCrusher extends MinistrappolationInventoryHandler
{
	private TileEntityCrusher	furnace;
	private int					lastScrushTime;
	private int					lastBurnTime;
	private int					lastMaxBurnTime;
	
	public ContainerCrusher(EntityPlayer player, TileEntityCrusher furnace)
	{
		super(player, furnace);
		
		this.furnace = furnace;
		this.lastScrushTime = 0;
		this.lastBurnTime = 0;
		this.lastMaxBurnTime = 0;
		// input1
		this.addSlotToContainer(new Slot(furnace, 0, 56, 17));
		
		// fuel
		this.addSlotToContainer(new Slot(furnace, 1, 56, 53));
		
		// result
		this.addSlotToContainer(new Slot(furnace, 2, 116, 25));
		// randomOut
		this.addSlotToContainer(new Slot(furnace, 3, 116, 49));
		
		this.addInventorySlots();
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		for (ICrafting crafting : (List<ICrafting>) this.crafters)
		{
			if (this.lastScrushTime != this.furnace.crushTime)
			{
				crafting.sendProgressBarUpdate(this, 0, this.furnace.crushTime);
			}
			if (this.lastBurnTime != this.furnace.burnTime)
			{
				crafting.sendProgressBarUpdate(this, 1, this.furnace.burnTime);
			}
			if (this.lastMaxBurnTime != this.furnace.maxCrushTime)
			{
				crafting.sendProgressBarUpdate(this, 2, this.furnace.maxCrushTime);
			}
		}
		this.lastScrushTime = this.furnace.crushTime;
		this.lastBurnTime = this.furnace.burnTime;
		this.lastMaxBurnTime = this.furnace.maxCrushTime;
	}
	
	@Override
	public void updateProgressBar(int id, int time)
	{
		if (id == 0)
		{
			this.furnace.crushTime = time;
		}
		
		if (id == 1)
		{
			this.furnace.burnTime = time;
		}
		
		if (id == 2)
		{
			this.furnace.maxCrushTime = time;
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
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (CrusherRecipes.instance().getResult(itemstack1) != null)
			{
				if (!this.mergeItemStack(itemstack1, 0, 1, false))
					return null;
			}
			else if (TileEntityCrusher.isItemFuel(itemstack1))
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
				slot.putStack((ItemStack)null);
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