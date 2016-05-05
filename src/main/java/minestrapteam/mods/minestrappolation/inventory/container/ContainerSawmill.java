package minestrapteam.mods.minestrappolation.inventory.container;

import minestrapteam.mods.minestrappolation.crafting.sawmill.SawingManager;
import minestrapteam.mods.minestrappolation.inventory.slot.SlotSawmill;
import minestrapteam.mods.minestrappolation.tileentity.TileEntitySawMill;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerSawmill extends Container
{
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
	public IInventory        craftResult = new InventoryCraftResult();
	public World             worldObj;
	public TileEntitySawMill sawmill;

	public ContainerSawmill(EntityPlayer player, TileEntitySawMill sawmill)
	{
		this.worldObj = sawmill.getWorld();
		this.sawmill = sawmill;
		this.addSlotToContainer(new SlotSawmill(player, this.craftMatrix, this.craftResult, 0, 124, 35));
		int i;
		int j;

		for (i = 0; i < 3; ++i)
		{
			for (j = 0; j < 3; ++j)
			{
				this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 3, 30 + j * 18, 17 + i * 18));
			}
		}

		for (i = 0; i < 3; ++i)
		{
			for (j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
		}

		this.onCraftMatrixChanged(this.craftMatrix);
	}

	@Override
	public void onContainerClosed(EntityPlayer player)
	{
		super.onContainerClosed(player);

		if (!this.sawmill.getWorld().isRemote)
		{
			for (int i = 0; i < 9; ++i)
			{
				ItemStack itemstack = this.craftMatrix.removeStackFromSlot(i);

				if (itemstack != null)
				{
					player.dropPlayerItemWithRandomChoice(itemstack, true);
				}
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.sawmill.isUseableByPlayer(player);
	}

	@Override
	public void onCraftMatrixChanged(IInventory inventory)
	{
		this.craftResult
			.setInventorySlotContents(0, SawingManager.instance.findMatchingRecipe(this.craftMatrix, this.worldObj));
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		ItemStack itemstack = null;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index == 0)
			{
				if (!this.mergeItemStack(itemstack1, 10, 46, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}
			else if (index >= 10 && index < 37)
			{
				if (!this.mergeItemStack(itemstack1, 37, 46, false))
				{
					return null;
				}
			}
			else if (index >= 37 && index < 46)
			{
				if (!this.mergeItemStack(itemstack1, 10, 37, false))
				{
					return null;
				}
			}
			else if (!this.mergeItemStack(itemstack1, 10, 46, false))
			{
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
			{
				return null;
			}

			slot.onPickupFromSlot(playerIn, itemstack1);
		}

		return itemstack;
	}

	@Override
	public boolean canMergeSlot(ItemStack stack, Slot slot)
	{
		return slot.inventory != this.craftResult && super.canMergeSlot(stack, slot);
	}
}
