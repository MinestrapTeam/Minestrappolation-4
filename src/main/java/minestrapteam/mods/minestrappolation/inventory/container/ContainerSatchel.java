package minestrapteam.mods.minestrappolation.inventory.container;

import minestrapteam.mods.minestrappolation.inventory.InventoryBackpack;
import minestrapteam.mods.minestrappolation.inventory.slot.SlotBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerSatchel extends MinestrappolationContainer
{
	public final InventoryBackpack inventory;

	/**
	 * Current item using gui
	 */
	private final ItemStack containerstack;

	public boolean needsUpdate;

	private static final int INV_START = 18, INV_END = INV_START + 26,

	HOTBAR_START = INV_END + 1, HOTBAR_END = HOTBAR_START + 8;

	public ContainerSatchel(EntityPlayer par1Player, InventoryPlayer inventoryPlayer, InventoryBackpack InventoryBackpack)
	{
		super(par1Player, InventoryBackpack);

		this.inventory = InventoryBackpack;

		this.containerstack = par1Player.getHeldItem();

		// SATCHEL INVENTORY
		for (int j = 0; j < 2; ++j)
		{
			for (int k = 0; k < 9; ++k)
			{
				this.addSlotToContainer(new SlotBackpack(this.inventory, k + j * 9, 8 + k * 18, 18 + j * 18 - 1));
			}
		}

		this.addInventorySlots(0, -18);
	}

	public void writeToNBT()
	{
		if (!this.containerstack.hasTagCompound())
		{
			this.containerstack.setTagCompound(new NBTTagCompound());
		}

		this.inventory.writeToNBT(this.containerstack.getTagCompound());
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer)
	{
		return true;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack itemstack = null;

		Slot slot = this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();

			itemstack = itemstack1.copy();

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

					if (!this.mergeItemStack(itemstack1, 0, INV_START, false))

					{

						return null;
					}
				}

				else if (par2 >= HOTBAR_START && par2 < HOTBAR_END + 1)
				{

					if (!this.mergeItemStack(itemstack1, 0, INV_START, false))

					{

						return null;
					}
				}
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

			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}

		this.needsUpdate = true;

		return itemstack;
	}

	@Override
	public ItemStack slotClick(int slotID, int buttonPressed, int flag, EntityPlayer player)
	{
		this.needsUpdate = true;
		InventoryPlayer inventoryplayer = player.inventory;

		if (slotID >= 0 && this.getSlot(slotID) != null && this.getSlot(slotID).getStack() == player.getHeldItem())
		{
			return null;
		}
		if (flag == 2 && buttonPressed >= 0 && buttonPressed < 9)
		{
			Slot slot2 = this.inventorySlots.get(slotID);
			ItemStack itemstack3 = inventoryplayer.getStackInSlot(buttonPressed);
			if (slot2.getStack() == player.getHeldItem() || itemstack3 == player.getHeldItem())
			{
				return null;
			}
		}
		return super.slotClick(slotID, buttonPressed, flag, player);
	}

	/*
	 * 
	 * Vanilla mergeItemStack method doesn't correctly handle inventories whose
	 * 
	 * max stack size is 1 when you shift-click into the inventory.
	 * 
	 * This is a modified method I wrote to handle such cases.
	 * 
	 * Note you only need it if your slot / inventory's max stack size is 1
	 * 
	 */

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

				slot = this.inventorySlots.get(k);

				itemstack1 = slot.getStack();

				if (itemstack1 != null && itemstack1.getItem() == par1ItemStack.getItem() && (!par1ItemStack
					                                                                               .getHasSubtypes() ||
					                                                                              par1ItemStack
						                                                                              .getItemDamage()
						                                                                              == itemstack1
							                                                                                 .getItemDamage())
					    && ItemStack.areItemStackTagsEqual(par1ItemStack, itemstack1))

				{

					int l = itemstack1.stackSize + par1ItemStack.stackSize;

					if (l <= par1ItemStack.getMaxStackSize() && l <= slot.getSlotStackLimit())

					{

						par1ItemStack.stackSize = 0;

						itemstack1.stackSize = l;

						this.inventory.markDirty();

						flag1 = true;
					}

					else if (itemstack1.stackSize < par1ItemStack.getMaxStackSize() && l < slot.getSlotStackLimit())

					{

						par1ItemStack.stackSize -= par1ItemStack.getMaxStackSize() - itemstack1.stackSize;

						itemstack1.stackSize = par1ItemStack.getMaxStackSize();

						this.inventory.markDirty();

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

				slot = this.inventorySlots.get(k);

				itemstack1 = slot.getStack();

				if (itemstack1 == null)

				{

					int l = par1ItemStack.stackSize;

					if (l <= slot.getSlotStackLimit())

					{

						slot.putStack(par1ItemStack.copy());

						par1ItemStack.stackSize = 0;

						this.inventory.markDirty();

						flag1 = true;

						break;
					}

					else

					{

						this.putStackInSlot(k, new ItemStack(par1ItemStack.getItem(), slot.getSlotStackLimit()));

						par1ItemStack.stackSize -= slot.getSlotStackLimit();

						this.inventory.markDirty();

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
}
