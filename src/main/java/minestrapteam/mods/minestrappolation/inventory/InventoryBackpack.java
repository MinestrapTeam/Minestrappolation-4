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
		if (!this.invStack.hasTagCompound())
		{
			this.invStack.setTagCompound(new NBTTagCompound());
		}
		this.readFromNBT(this.invStack.getTagCompound());
	}

	@Override

	public int getSizeInventory()
	{
		return this.inventory.length;
	}

	@Override

	public ItemStack getStackInSlot(int slot)
	{
		return this.inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount)
	{
		ItemStack stack = this.getStackInSlot(slot);
		if (stack != null)
		{
			if (stack.stackSize > amount)
			{
				stack = stack.splitStack(amount);
				this.markDirty();
			}
			else
			{
				this.setInventorySlotContents(slot, null);
			}
		}

		return stack;
	}

	@Override
	public ItemStack removeStackFromSlot(int slot)
	{
		ItemStack stack = this.getStackInSlot(slot);
		this.setInventorySlotContents(slot, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack)
	{
		this.inventory[slot] = stack;
		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
		this.markDirty();
	}

	@Override
	public String getName()
	{
		return this.name;
	}

	@Override
	public boolean hasCustomName()
	{
		return this.name.length() > 0;
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
				this.inventory[i] = null;
		}
		this.writeToNBT(this.invStack.getTagCompound());
	}

	@Override

	public boolean isUseableByPlayer(EntityPlayer entityplayer)
	{
		return entityplayer.getHeldItem() == this.invStack;
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
			if (slot >= 0 && slot < this.getSizeInventory())
			{
				this.inventory[slot] = ItemStack.loadItemStackFromNBT(item);
			}
		}
	}

	public void writeToNBT(NBTTagCompound compound)
	{
		NBTTagList items = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); ++i)
		{
			if (this.getStackInSlot(i) != null)
			{
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte) i);
				this.getStackInSlot(i).writeToNBT(item);
				items.appendTag(item);
			}
		}
		compound.setTag("ItemInventory", items);
	}

	@Override
	public IChatComponent getDisplayName()
	{
		return new ChatComponentText(this.name);
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
		for (int i = 0; i < this.inventory.length; ++i)
		{
			this.inventory[i] = null;
		}
	}
}
