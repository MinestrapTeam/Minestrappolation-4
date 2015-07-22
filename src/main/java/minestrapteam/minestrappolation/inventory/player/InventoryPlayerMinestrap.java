package minestrapteam.minestrappolation.inventory.player;

import minestrapteam.minestrappolation.item.ItemBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.IChatComponent;

public class InventoryPlayerMinestrap implements IInventory
{
	private final String name = "Minestrap Inventory";

	private final String tagName = "MinestrapInv";


	public static final int INV_SIZE = 2, SLOT_BACKPACK = 0;

	ItemStack[] inventory = new ItemStack[INV_SIZE];

	public InventoryPlayerMinestrap()
	{

	}

	@Override
	public int getSizeInventory()
	{
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot)
	{
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount)
	{
		ItemStack stack = getStackInSlot(slot);

		if (stack != null)
		{
			if (stack.stackSize > amount)
			{
				stack = stack.splitStack(amount);

				if (stack.stackSize == 0)
				{
					setInventorySlotContents(slot, null);
				}
			}
			else
			{
				setInventorySlotContents(slot, null);
			}

			this.markDirty();
		}

		return stack;
	}

	@Override

	public ItemStack getStackInSlotOnClosing(int slot)
	{
		ItemStack stack = getStackInSlot(slot);

		if (stack != null)
		{
			setInventorySlotContents(slot, null);
		}

		return stack;
	}

	@Override

	public void setInventorySlotContents(int slot, ItemStack itemstack)
	{
		this.inventory[slot] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())

		{

			itemstack.stackSize = this.getInventoryStackLimit();

		}

		this.markDirty();
	}

	@Override
	public boolean hasCustomName()
	{
		return name.length() > 0;
	}

	/**
	 * 
	 * Our custom slots are similar to armor - only one item per slot
	 * 
	 */

	@Override

	public int getInventoryStackLimit()
	{
		return 1;
	}
	

	@Override
	public void markDirty()
	{
		for (int i = 0; i < this.getSizeInventory(); ++i)
		{

			if (this.getStackInSlot(i) != null && this.getStackInSlot(i).stackSize == 0)

				this.setInventorySlotContents(i, null);
		}
	}

	/**
	 * 
	 * This method doesn't seem to do what it claims to do, as
	 * 
	 * items can still be left-clicked and placed in the inventory
	 * 
	 * even when this returns false
	 * 
	 */

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack)	
	{
		if(slot == SLOT_BACKPACK && itemstack.getItem() instanceof ItemBackpack)
		{
			return true;
		}
		return false;
	}

	public void writeToNBT(NBTTagCompound tagcompound)
	{
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.getSizeInventory(); ++i)

		{

			if (this.getStackInSlot(i) != null)

			{

				NBTTagCompound nbttagcompound1 = new NBTTagCompound();

				nbttagcompound1.setByte("Slot", (byte) i);

				this.getStackInSlot(i).writeToNBT(nbttagcompound1);

				nbttaglist.appendTag(nbttagcompound1);

			}

		}

		tagcompound.setTag(tagName, nbttaglist);
	}

	public void readFromNBT(NBTTagCompound tagcompound)
	{
		NBTTagList nbttaglist = tagcompound.getTagList(tagName, tagcompound.getId());

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);

			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.getSizeInventory())
			{
				this.setInventorySlotContents(b0, ItemStack.loadItemStackFromNBT(nbttagcompound1));
			}
		}
	}

	@Override
	public String getCommandSenderName()
	{
		return null;
	}

	@Override
	public IChatComponent getDisplayName()
	{
		return null;
	}


	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player)
	{
		
	}

	@Override
	public void closeInventory(EntityPlayer player)
	{
		
	}

	@Override
	public int getField(int id)
	{
		return 0;
	}

	@Override
	public void setField(int id, int value)
	{
		
	}

	@Override
	public int getFieldCount()
	{
		return 0;
	}

	@Override
	public void clear() 
	{
		 for (int i = 0; i < inventory.length; ++i)
		 {
		 	inventory[ i ] = null;
		 }
	}
}