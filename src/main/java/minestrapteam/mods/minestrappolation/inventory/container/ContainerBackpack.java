package minestrapteam.mods.minestrappolation.inventory.container;

import minestrapteam.mods.minestrappolation.inventory.InventoryBackpack;
import minestrapteam.mods.minestrappolation.inventory.slot.SlotBackpack;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerBackpack extends MinestrappolationContainer
{
	public final InventoryBackpack inventory;
	
	/**
	 * Current item using gui
	 */
	
	public boolean needsUpdate;

	private static final int INV_START = InventoryBackpack.INV_SIZE, INV_END = INV_START + 26,

	HOTBAR_START = INV_END + 1, HOTBAR_END = HOTBAR_START + 8;

	public ContainerBackpack(EntityPlayer par1Player, InventoryPlayer inventoryPlayer,
			InventoryBackpack InventoryBackpack)
	{
		super(par1Player, InventoryBackpack);
		
		this.inventory = InventoryBackpack;

		// BARREL INVENTORY
		for (int j = 0; j < 4; ++j)
		{
			for (int k = 0; k < 9; ++k)
			{
				this.addSlotToContainer(new SlotBackpack(this.inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
			}
		}
		
		this.addInventorySlots(0, 20);
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return true;
	}

	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack itemstack = null;

		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();

			itemstack = itemstack1.copy();
			
			if(itemstack.isItemEqual(new ItemStack(MItems.backpack)) || itemstack.isItemEqual(new ItemStack(MItems.satchel)))
			{
				return null;
			}

			if (par2 < INV_START)
			{
				if (!this.mergeItemStack(itemstack1, INV_START, HOTBAR_END + 1, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack1, itemstack);
			}

			else
			{
				if (par2 >= INV_START && par2 < HOTBAR_START)
				{

					if (!this.mergeItemStack(itemstack1, 0, INV_START - 1, false))

					{

						return null;

					}

				}

				else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1)
				{

					if (!this.mergeItemStack(itemstack1, 0, INV_START - 1, false))

					{

						return null;

					}

				}

			}

			if (itemstack1.stackSize == 0)
			{

				slot.putStack((ItemStack) null);

			}

			else
			{

				slot.onSlotChanged();

			}

			if (itemstack1.stackSize == itemstack.stackSize)
			{

				return null;

			}

			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);

		}

		this.needsUpdate = true;

		return itemstack;
	}

	@Override

	protected boolean mergeItemStack(ItemStack par1ItemStack, int par2, int par3, boolean par4)

	{

		boolean flag1 = false;

		int k = par2;

		if (par4)

		{

			k = par3 - 1;

		}

		Slot slot;

		ItemStack itemstack1;

		if (par1ItemStack.isStackable())

		{

			while (par1ItemStack.stackSize > 0 && (!par4 && k < par3 || par4 && k >= par2))

			{

				slot = (Slot) this.inventorySlots.get(k);

				itemstack1 = slot.getStack();

				if (itemstack1 != null && itemstack1.getItem() == par1ItemStack.getItem()
						&& (!par1ItemStack.getHasSubtypes()
								|| par1ItemStack.getItemDamage() == itemstack1.getItemDamage())
						&& ItemStack.areItemStackTagsEqual(par1ItemStack, itemstack1))

				{

					int l = itemstack1.stackSize + par1ItemStack.stackSize;

					if (l <= par1ItemStack.getMaxStackSize() && l <= slot.getSlotStackLimit())

					{

						par1ItemStack.stackSize = 0;

						itemstack1.stackSize = l;

						inventory.markDirty();

						flag1 = true;

					}

					else if (itemstack1.stackSize < par1ItemStack.getMaxStackSize() && l < slot.getSlotStackLimit())

					{

						par1ItemStack.stackSize -= par1ItemStack.getMaxStackSize() - itemstack1.stackSize;

						itemstack1.stackSize = par1ItemStack.getMaxStackSize();

						inventory.markDirty();

						flag1 = true;

					}

				}

				if (par4)

				{

					--k;

				}

				else

				{

					++k;

				}

			}

		}

		if (par1ItemStack.stackSize > 0)

		{

			if (par4)

			{

				k = par3 - 1;

			}

			else

			{

				k = par2;

			}

			while (!par4 && k < par3 || par4 && k >= par2)

			{

				slot = (Slot) this.inventorySlots.get(k);

				itemstack1 = slot.getStack();

				if (itemstack1 == null)

				{

					int l = par1ItemStack.stackSize;

					if (l <= slot.getSlotStackLimit())

					{

						slot.putStack(par1ItemStack.copy());

						par1ItemStack.stackSize = 0;

						inventory.markDirty();

						flag1 = true;

						break;

					}

					else

					{

						this.putStackInSlot(k, new ItemStack(par1ItemStack.getItem(), slot.getSlotStackLimit()));

						par1ItemStack.stackSize -= slot.getSlotStackLimit();

						inventory.markDirty();

						flag1 = true;

					}

				}

				if (par4)

				{

					--k;

				}

				else

				{

					++k;

				}

			}

		}

		return flag1;

	}
	
	@Override
	public ItemStack slotClick(int slotId, int clickedButton, int mode, EntityPlayer playerIn)
    {
		this.needsUpdate = true;
		InventoryPlayer inventoryplayer = playerIn.inventory;
		
		if(slotId >= 0 && this.getSlot(slotId) != null && this.getSlot(slotId).getStack() == playerIn.getHeldItem())
		{
			return null;
		}
		if (mode == 2 && clickedButton >= 0 && clickedButton < 9)
        {
			Slot slot2 = (Slot)this.inventorySlots.get(slotId);
			ItemStack itemstack3 = inventoryplayer.getStackInSlot(clickedButton);
			if(slot2.getStack() == playerIn.getHeldItem() || itemstack3 == playerIn.getHeldItem())
			{
				return null;
			}
        }
		return super.slotClick(slotId, clickedButton, mode, playerIn);
    }
}