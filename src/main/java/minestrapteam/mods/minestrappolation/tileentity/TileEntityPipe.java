package minestrapteam.mods.minestrappolation.tileentity;

import minestrapteam.mods.minestrappolation.block.machines.BlockPipe;
import minestrapteam.mods.minestrappolation.inventory.container.ContainerPipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.IHopper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;

public class TileEntityPipe extends TileEntityLockable implements IHopper, ITickable
{
	private ItemStack[] inventory = new ItemStack[1];
	private String customName;
	private int transferCooldown = -1;

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		NBTTagList nbttaglist = compound.getTagList("Items", 10);
		this.inventory = new ItemStack[this.getSizeInventory()];

		if (compound.hasKey("CustomName", 8))
		{
			this.customName = compound.getString("CustomName");
		}

		this.transferCooldown = compound.getInteger("TransferCooldown");

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound.getByte("Slot");

			if (j >= 0 && j < this.inventory.length)
			{
				this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.inventory.length; ++i)
		{
			if (this.inventory[i] != null)
			{
				NBTTagCompound nbttagcompound = new NBTTagCompound();
				nbttagcompound.setByte("Slot", (byte) i);
				this.inventory[i].writeToNBT(nbttagcompound);
				nbttaglist.appendTag(nbttagcompound);
			}
		}

		compound.setTag("Items", nbttaglist);
		compound.setInteger("TransferCooldown", this.transferCooldown);

		if (this.hasCustomName())
		{
			compound.setString("CustomName", this.customName);
		}
	}

	/**
	 * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
	 * hasn't changed and skip it.
	 */
	@Override
	public void markDirty()
	{
		super.markDirty();
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory()
	{
		return this.inventory.length;
	}

	/**
	 * Returns the stack in the given slot.
	 *
	 * @param index
	 * 	The slot to retrieve from.
	 */
	@Override
	public ItemStack getStackInSlot(int index)
	{
		return this.inventory[index];
	}

	/**
	 * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
	 *
	 * @param index
	 * 	The slot to remove from.
	 * @param count
	 * 	The maximum amount of items to remove.
	 */
	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		if (this.inventory[index] != null)
		{
			if (this.inventory[index].stackSize <= count)
			{
				ItemStack itemstack1 = this.inventory[index];
				this.inventory[index] = null;
				return itemstack1;
			}
			else
			{
				ItemStack itemstack = this.inventory[index].splitStack(count);

				if (this.inventory[index].stackSize == 0)
				{
					this.inventory[index] = null;
				}

				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * Removes a stack from the given slot and returns it.
	 *
	 * @param index
	 * 	The slot to remove a stack from.
	 */
	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		if (this.inventory[index] != null)
		{
			ItemStack itemstack = this.inventory[index];
			this.inventory[index] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		this.inventory[index] = stack;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	/**
	 * Gets the name of this command sender (usually username, but possibly "Rcon")
	 */
	@Override
	public String getName()
	{
		return this.hasCustomName() ? this.customName : "container.hopper";
	}

	/**
	 * Returns true if this thing is named
	 */
	@Override
	public boolean hasCustomName()
	{
		return this.customName != null && this.customName.length() > 0;
	}

	public void setCustomName(String customNameIn)
	{
		this.customName = customNameIn;
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
	 */
	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return this.worldObj.getTileEntity(this.pos) == this && player.getDistanceSq((double) this.pos.getX() + 0.5D,
		                                                                             (double) this.pos.getY() + 0.5D,
		                                                                             (double) this.pos.getZ() + 0.5D)
			                                                        <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player)
	{
	}

	@Override
	public void closeInventory(EntityPlayer player)
	{
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 */
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		return true;
	}

	/**
	 * Like the old updateEntity(), except more generic.
	 */
	@Override
	public void update()
	{
		if (this.worldObj != null && !this.worldObj.isRemote)
		{
			--this.transferCooldown;

			if (!this.isOnTransferCooldown())
			{
				this.setTransferCooldown(0);
				this.updateHopper();
			}
		}
	}

	public boolean updateHopper()
	{
		if (this.worldObj != null && !this.worldObj.isRemote)
		{
			if (!this.isOnTransferCooldown())
			{
				boolean flag = false;

				if (!this.isEmpty())
				{
					flag = this.transferItemsOut();
				}

				if (flag)
				{
					this.setTransferCooldown(8);
					this.markDirty();
					return true;
				}
			}

			return false;
		}
		else
		{
			return false;
		}
	}

	private boolean isEmpty()
	{
		for (ItemStack itemstack : this.inventory)
		{
			if (itemstack != null)
			{
				return false;
			}
		}

		return true;
	}

	private boolean isFull()
	{
		for (ItemStack itemstack : this.inventory)
		{
			if (itemstack == null || itemstack.stackSize != itemstack.getMaxStackSize())
			{
				return false;
			}
		}

		return true;
	}

	private boolean transferItemsOut()
	{
		//if (net.minecraftforge.items.VanillaInventoryCodeHooks.insertHook(this)) { return true; }
		IInventory iinventory = this.getInventoryForHopperTransfer();

		if (iinventory == null)
		{
			return false;
		}
		else
		{
			EnumFacing enumfacing = BlockPipe.getFacing(this.getBlockMetadata()).getOpposite();

			if (this.isInventoryFull(iinventory, enumfacing))
			{
				return false;
			}
			else
			{
				for (int i = 0; i < this.getSizeInventory(); ++i)
				{
					if (this.getStackInSlot(i) != null)
					{
						ItemStack itemstack = this.getStackInSlot(i).copy();
						ItemStack itemstack1 = putStackInInventoryAllSlots(iinventory, this.decrStackSize(i, 1),
						                                                   enumfacing);

						if (itemstack1 == null || itemstack1.stackSize == 0)
						{
							iinventory.markDirty();
							return true;
						}

						this.setInventorySlotContents(i, itemstack);
					}
				}

				return false;
			}
		}
	}

	/**
	 * Returns false if the inventory has any room to place items in
	 *
	 * @param inventoryIn
	 * 	The inventory to check
	 * @param side
	 * 	The side to check from
	 */
	private boolean isInventoryFull(IInventory inventoryIn, EnumFacing side)
	{
		if (inventoryIn instanceof ISidedInventory)
		{
			ISidedInventory isidedinventory = (ISidedInventory) inventoryIn;
			int[] aint = isidedinventory.getSlotsForFace(side);

			for (int anAint : aint)
			{
				ItemStack itemstack1 = isidedinventory.getStackInSlot(anAint);

				if (itemstack1 == null || itemstack1.stackSize != itemstack1.getMaxStackSize())
				{
					return false;
				}
			}
		}
		else
		{
			int i = inventoryIn.getSizeInventory();

			for (int j = 0; j < i; ++j)
			{
				ItemStack itemstack = inventoryIn.getStackInSlot(j);

				if (itemstack == null || itemstack.stackSize != itemstack.getMaxStackSize())
				{
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Returns false if the specified IInventory contains any items
	 *
	 * @param inventoryIn
	 * 	The inventory to check
	 * @param side
	 * 	The side to access the inventory from
	 */
	private static boolean isInventoryEmpty(IInventory inventoryIn, EnumFacing side)
	{
		if (inventoryIn instanceof ISidedInventory)
		{
			ISidedInventory isidedinventory = (ISidedInventory) inventoryIn;
			int[] aint = isidedinventory.getSlotsForFace(side);

			for (int anAint : aint)
			{
				if (isidedinventory.getStackInSlot(anAint) != null)
				{
					return false;
				}
			}
		}
		else
		{
			int j = inventoryIn.getSizeInventory();

			for (int k = 0; k < j; ++k)
			{
				if (inventoryIn.getStackInSlot(k) != null)
				{
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Attempts to place the passed stack in the inventory, using as many slots as required. Returns leftover items
	 */
	public static ItemStack putStackInInventoryAllSlots(IInventory inventoryIn, ItemStack stack, EnumFacing side)
	{
		if (inventoryIn instanceof ISidedInventory && side != null)
		{
			ISidedInventory isidedinventory = (ISidedInventory) inventoryIn;
			int[] aint = isidedinventory.getSlotsForFace(side);

			for (int k = 0; k < aint.length && stack != null && stack.stackSize > 0; ++k)
			{
				stack = insertStack(inventoryIn, stack, aint[k], side);
			}
		}
		else
		{
			int i = inventoryIn.getSizeInventory();

			for (int j = 0; j < i && stack != null && stack.stackSize > 0; ++j)
			{
				stack = insertStack(inventoryIn, stack, j, side);
			}
		}

		if (stack != null && stack.stackSize == 0)
		{
			stack = null;
		}

		return stack;
	}

	/**
	 * Can this hopper insert the specified item from the specified slot on the specified side?
	 *
	 * @param inventoryIn
	 * 	The inventory to check if insertable
	 * @param stack
	 * 	The stack to check if insertable
	 * @param index
	 * 	The slot to check if insertable
	 * @param side
	 * 	The side to check if insertable
	 */
	private static boolean canInsertItemInSlot(IInventory inventoryIn, ItemStack stack, int index, EnumFacing side)
	{
		return inventoryIn.isItemValidForSlot(index, stack) && (!(inventoryIn instanceof ISidedInventory)
			                                                        || ((ISidedInventory) inventoryIn)
				                                                           .canInsertItem(index, stack, side));
	}

	/**
	 * Insert the specified stack to the specified inventory and return any leftover items
	 *
	 * @param inventoryIn
	 * 	The inventory to insert to
	 * @param stack
	 * 	The stack to try and insert
	 * @param index
	 * 	The slot to try and put items in
	 * @param side
	 * 	The side to insert from
	 */
	private static ItemStack insertStack(IInventory inventoryIn, ItemStack stack, int index, EnumFacing side)
	{
		ItemStack itemstack = inventoryIn.getStackInSlot(index);

		if (canInsertItemInSlot(inventoryIn, stack, index, side))
		{
			boolean flag = false;

			if (itemstack == null)
			{
				//Forge: BUGFIX: Again, make things respect max stack sizes.
				int max = Math.min(stack.getMaxStackSize(), inventoryIn.getInventoryStackLimit());
				if (max >= stack.stackSize)
				{
					inventoryIn.setInventorySlotContents(index, stack);
					stack = null;
				}
				else
				{
					inventoryIn.setInventorySlotContents(index, stack.splitStack(max));
				}
				flag = true;
			}
			else if (canCombine(itemstack, stack))
			{
				//Forge: BUGFIX: Again, make things respect max stack sizes.
				int max = Math.min(stack.getMaxStackSize(), inventoryIn.getInventoryStackLimit());
				if (max > itemstack.stackSize)
				{
					int i = max - itemstack.stackSize;
					int j = Math.min(stack.stackSize, i);
					stack.stackSize -= j;
					itemstack.stackSize += j;
					flag = j > 0;
				}
			}

			if (flag)
			{
				if (inventoryIn instanceof TileEntityPipe)
				{
					TileEntityPipe tileentitypipe = (TileEntityPipe) inventoryIn;

					if (tileentitypipe.mayTransfer())
					{
						tileentitypipe.setTransferCooldown(8);
					}

					inventoryIn.markDirty();
				}

				inventoryIn.markDirty();
			}
		}

		return stack;
	}

	/**
	 * Returns the IInventory that this hopper is pointing into
	 */
	private IInventory getInventoryForHopperTransfer()
	{
		EnumFacing enumfacing = BlockPipe.getFacing(this.getBlockMetadata());
		/**
		 * Returns the IInventory (if applicable) of the TileEntity at the specified position
		 */
		return getInventoryAtPosition(this.getWorld(), (double) (this.pos.getX() + enumfacing.getFrontOffsetX()),
		                              (double) (this.pos.getY() + enumfacing.getFrontOffsetY()),
		                              (double) (this.pos.getZ() + enumfacing.getFrontOffsetZ()));
	}

	/**
	 * Returns the IInventory for the specified hopper
	 *
	 * @param hopper The hopper the return an inventory for
	 */
	/*public static IInventory getHopperInventory(IHopper hopper)
    {
        /**
         * Returns the IInventory (if applicable) of the TileEntity at the specified position
         *
        return getInventoryAtPosition(hopper.getWorld(), hopper.getXPos(), hopper.getYPos() + 1.0D, hopper.getZPos());
    }

    public static List<EntityItem> func_181556_a(World p_181556_0_, double p_181556_1_, double p_181556_3_, double p_181556_5_)
    {
        return p_181556_0_.<EntityItem>getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(p_181556_1_ - 0.5D, p_181556_3_ - 0.5D, p_181556_5_ - 0.5D, p_181556_1_ + 0.5D, p_181556_3_ + 0.5D, p_181556_5_ + 0.5D), EntitySelectors.selectAnything);
    }*/

	/**
	 * Returns the IInventory (if applicable) of the TileEntity at the specified position
	 */
	public static IInventory getInventoryAtPosition(World worldIn, double x, double y, double z)
	{
		IInventory iinventory = null;
		int i = MathHelper.floor_double(x);
		int j = MathHelper.floor_double(y);
		int k = MathHelper.floor_double(z);
		BlockPos blockpos = new BlockPos(i, j, k);
		Block block = worldIn.getBlockState(blockpos).getBlock();

		if (block.hasTileEntity())
		{
			TileEntity tileentity = worldIn.getTileEntity(blockpos);

			if (tileentity instanceof IInventory)
			{
				iinventory = (IInventory) tileentity;

				if (iinventory instanceof TileEntityChest && block instanceof BlockChest)
				{
					iinventory = ((BlockChest) block).getLockableContainer(worldIn, blockpos);
				}
			}
		}

		if (iinventory == null)
		{
			List<Entity> list = worldIn.getEntitiesInAABBexcluding(null, new AxisAlignedBB(x - 0.5D, y - 0.5D, z - 0.5D,
			                                                                               x + 0.5D, y + 0.5D,
			                                                                               z + 0.5D),
			                                                       EntitySelectors.selectInventories);

			if (list.size() > 0)
			{
				iinventory = (IInventory) list.get(worldIn.rand.nextInt(list.size()));
			}
		}

		return iinventory;
	}

	private static boolean canCombine(ItemStack stack1, ItemStack stack2)
	{
		return stack1.getItem() == stack2.getItem() && (stack1.getMetadata() == stack2.getMetadata()
			                                                && (stack1.stackSize <= stack1.getMaxStackSize()
				                                                    && ItemStack
					                                                       .areItemStackTagsEqual(stack1, stack2)));
	}

	/**
	 * Gets the world X position for this hopper entity.
	 */
	@Override
	public double getXPos()
	{
		return (double) this.pos.getX() + 0.5D;
	}

	/**
	 * Gets the world Y position for this hopper entity.
	 */
	@Override
	public double getYPos()
	{
		return (double) this.pos.getY() + 0.5D;
	}

	/**
	 * Gets the world Z position for this hopper entity.
	 */
	@Override
	public double getZPos()
	{
		return (double) this.pos.getZ() + 0.5D;
	}

	public void setTransferCooldown(int ticks)
	{
		this.transferCooldown = ticks;
	}

	public boolean isOnTransferCooldown()
	{
		return this.transferCooldown > 0;
	}

	public boolean mayTransfer()
	{
		return this.transferCooldown <= 1;
	}

	@Override
	public String getGuiID()
	{
		return "minecraft:hopper";
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
	{
		return new ContainerPipe(playerIn, this);
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


    /*protected net.minecraftforge.items.IItemHandler createUnSidedHandler()
    {
        return new net.minecraftforge.items.VanillaHopperItemHandler(this);
    }*/
}
