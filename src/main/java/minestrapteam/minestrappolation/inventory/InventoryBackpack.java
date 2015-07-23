package minestrapteam.minestrappolation.inventory;

import java.util.UUID;

import minestrapteam.minestrappolation.inventory.container.ContainerBackpack;
import minestrapteam.minestrappolation.item.ItemBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class InventoryBackpack implements IInventory
{
	private String name = "Backpack Inventory";
	private String uniqueID;
	
	public static final int INV_SIZE = 36;

	public ItemStack[] inventory = new ItemStack[INV_SIZE];

	public InventoryBackpack(ItemStack itemstack)
	{
		uniqueID = "";
		if (!itemstack.hasTagCompound())
		{
			itemstack.setTagCompound(new NBTTagCompound());
			uniqueID = UUID.randomUUID().toString();
		}
		readFromNBT(itemstack.getTagCompound());
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
	public String getCommandSenderName()
	{
		return name;
	}

	@Override
	public boolean hasCustomName()
	{
		return name.length() > 0;
	}

	@Override

	public int getInventoryStackLimit()
	{
		return 64;
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

	@Override

	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack)
	{
		return !(itemstack.getItem() instanceof ItemBackpack);
	}

	public void readFromNBT(NBTTagCompound tagcompound)
	{
		NBTTagList nbttaglist = tagcompound.getTagList("ItemInventory", tagcompound.getId());

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);

			int b0 = nbttagcompound1.getInteger("Slot");
			if (b0 >= 0 && b0 < this.getSizeInventory())
			{
				this.setInventorySlotContents(b0, ItemStack.loadItemStackFromNBT(nbttagcompound1));
			}

		}

		if ("".equals(uniqueID))
		{
			uniqueID = tagcompound.getString("uniqueID");

			if ("".equals(uniqueID))
			{
				uniqueID = UUID.randomUUID().toString();
			}
		}
	}

	/**
	 * 
	 * A custom method to write our inventory to an ItemStack's NBT compound
	 * 
	 */

	public void writeToNBT(NBTTagCompound tagcompound)
	{
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); ++i)
		{
			if (this.getStackInSlot(i) != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();

				nbttagcompound1.setInteger("Slot", i);

				this.getStackInSlot(i).writeToNBT(nbttagcompound1);

				nbttaglist.appendTag(nbttagcompound1);
			}

		}

		tagcompound.setTag("ItemInventory", nbttaglist);
		tagcompound.setString("uniqueID", this.uniqueID);
	}

	@Override
	public IChatComponent getDisplayName()
	{
		return new ChatComponentText(name);
	}

	public void openInventory(EntityPlayer player)
	{
	}

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
			inventory[i] = null;

		}
	}
}