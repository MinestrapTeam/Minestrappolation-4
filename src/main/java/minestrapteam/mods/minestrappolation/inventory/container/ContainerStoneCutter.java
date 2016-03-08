package minestrapteam.mods.minestrappolation.inventory.container;

import minestrapteam.mods.minestrappolation.crafting.stonecutter.StonecuttingManager;
import minestrapteam.mods.minestrappolation.inventory.slot.SlotStoneCutter;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityStoneCutter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class ContainerStoneCutter extends Container
{
	public InventoryCrafting		craftMatrix	= new InventoryCrafting(this, 3, 3);
	public IInventory				extraSlot	= new InventoryCrafting(this, 1, 1);
	public IInventory				craftResult	= new InventoryCraftResult();
	public TileEntityStoneCutter	stoneCutter;
	
	public ContainerStoneCutter(EntityPlayer player, TileEntityStoneCutter te)
	{
		this.stoneCutter = te;
		
		this.addSlotToContainer(new SlotStoneCutter(player, this.craftMatrix, this.craftResult, this.extraSlot, 0, 124 + 14, 35));
		this.addSlotToContainer(new Slot(this.extraSlot, 0, 8, 35));
		
		int l;
		int i1;
		
		for (l = 0; l < 3; ++l)
		{
			for (i1 = 0; i1 < 3; ++i1)
			{
				this.addSlotToContainer(new Slot(this.craftMatrix, i1 + l * 3, 30 + i1 * 18 + 14, 17 + l * 18));
			}
		}
		
		for (l = 0; l < 3; ++l)
		{
			for (i1 = 0; i1 < 9; ++i1)
			{
				this.addSlotToContainer(new Slot(player.inventory, i1 + l * 9 + 9, 8 + i1 * 18, 84 + l * 18));
			}
		}
		
		for (l = 0; l < 9; ++l)
		{
			this.addSlotToContainer(new Slot(player.inventory, l, 8 + l * 18, 142));
		}
		
		this.onCraftMatrixChanged(this.craftMatrix);
	}
	
	@Override
	public void onCraftMatrixChanged(IInventory inventory)
	{
		this.craftResult.setInventorySlotContents(0, StonecuttingManager.instance().findMatchingRecipe(this.craftMatrix, this.extraSlot.getStackInSlot(0), this.stoneCutter.getWorld()));
	}
	
	@Override
	public void onContainerClosed(EntityPlayer player)
	{
		super.onContainerClosed(player);
		
		if (!this.stoneCutter.getWorld().isRemote)
		{
			for (int i = 0; i < 9; ++i)
			{
				ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
				
				if (itemstack != null)
				{
					player.dropPlayerItemWithRandomChoice(itemstack, true);
				}
			}
			
			ItemStack extraItem = this.extraSlot.getStackInSlotOnClosing(0);
			if (extraItem != null)
			{
				player.dropPlayerItemWithRandomChoice(extraItem, true);
			}
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.stoneCutter.isUseableByPlayer(player);
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
			
			if (slotID == 0)
			{
				if (!this.mergeItemStack(itemstack1, 11, 47, true))
					return null;
				
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (this.isItemAddon(itemstack1) && slotID != 1)
			{
				if(!this.mergeItemStack(itemstack1, 1, 2, false))
					return null;
			}
			else if (slotID >= 11 && slotID < 38)
			{
				if (!this.mergeItemStack(itemstack1, 38, 47, false))
					return null;
			}
			else if (slotID >= 38 && slotID < 47)
			{
				if (!this.mergeItemStack(itemstack1, 11, 38, false))
					return null;
			}
			else if (!this.mergeItemStack(itemstack1, 11, 47, false))
				return null;
			
			if (itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
			
			if (itemstack1.stackSize == itemstack.stackSize)
				return null;
			
			slot.onPickupFromSlot(player, itemstack1);
		}
		
		return itemstack;
	}
	
	public boolean isItemAddon(ItemStack itemStack)
	{
		Item item = itemStack.getItem();
		if (item instanceof ItemDye ||
			item == Item.getItemFromBlock(MBlocks.moss) ||
			item == Item.getItemFromBlock(MBlocks.hanging_moss) ||
			item == Item.getItemFromBlock(MBlocks.hanging_glow_moss) ||
			item == MItems.crushed_ice)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean canMergeSlot(ItemStack stack, Slot slot)
	{
		return slot.inventory != this.craftResult && super.canMergeSlot(stack, slot);
	}
}
