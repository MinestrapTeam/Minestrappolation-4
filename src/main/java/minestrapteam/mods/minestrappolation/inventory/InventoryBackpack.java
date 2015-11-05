package minestrapteam.mods.minestrappolation.inventory;

import minestrapteam.mods.minestrappolation.item.ItemBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.common.util.Constants;

public class InventoryBackpack implements IInventory
{
	private String name = "Backpack Inventory";

	public static final int INV_SIZE = 36;

	public ItemStack[] inventory = new ItemStack[INV_SIZE];

	public final ItemStack invStack;

	public InventoryBackpack(ItemStack stack)
	{
		this.invStack = stack;
		if (!invStack.hasTagCompound())
		{
			invStack.setTagCompound(new NBTTagCompound());
		}
		readFromNBT(invStack.getTagCompound());
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
				markDirty();
			} else
			{
				setInventorySlotContents(slot, null);
			}
		}

		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot)
	{
		ItemStack stack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		inventory[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit())
		{
			stack.stackSize = getInventoryStackLimit();
		}
		markDirty();
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
		for (int i = 0; i < getSizeInventory(); ++i)
		{
			if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0)
				inventory[i] = null;
		}
		writeToNBT(invStack.getTagCompound());
	}

	@Override

	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return entityplayer.getHeldItem() == invStack;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack)
	{
		return !(itemstack.getItem() instanceof ItemBackpack);
	}

	public void readFromNBT(NBTTagCompound compound)
	{
		NBTTagList items = compound.getTagList("ItemInventory", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < items.tagCount(); ++i)
		{
			NBTTagCompound item = items.getCompoundTagAt(i);
			byte slot = item.getByte("Slot");
			if (slot >= 0 && slot < getSizeInventory())
			{
				inventory[slot] = ItemStack.loadItemStackFromNBT(item);
			}
		}
	}

	public void writeToNBT(NBTTagCompound compound)
	{
		NBTTagList items = new NBTTagList();
		for (int i = 0; i < getSizeInventory(); ++i)
		{
			if (getStackInSlot(i) != null)
			{
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte) i);
				getStackInSlot(i).writeToNBT(item);
				items.appendTag(item);
			}
		}
		compound.setTag("ItemInventory", items);
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