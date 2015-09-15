package minestrapteam.mods.minestrappolation.tileentity;

import minestrapteam.mods.minestrappolation.block.machines.BlockSplitter;
import minestrapteam.mods.minestrappolation.crafting.recipes.SplitterRecipes;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.EnumFacing;

public class TileEntitySplitter extends TileEntityInventory implements ISidedInventory, IUpdatePlayerListBox
{
	public int					burnTime;
	public int					maxBurnTime;
	public int					splitTime;
	
	private static final int[]	topInputSlot	= new int[] { 0 };
	private static final int[]	outputSlots		= new int[] { 2, 1 };
	private static final int[]	inputSlots		= new int[] { 1 };
	
	public TileEntitySplitter()
	{
		super(4);
	}
	
	public final int getMaxSplitTime()
	{
		return 200;
	}
	
	@Override
	public int getSizeInventory()
	{
		return 4;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		
		this.burnTime = nbt.getShort("BurnTime");
		this.splitTime = nbt.getShort("CookTime");
		this.maxBurnTime = getItemBurnTime(this.itemStacks[1]);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		this.itemStacks = new ItemStack[this.getSizeInventory()];
		
		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");
			
			if (b0 >= 0 && b0 < this.itemStacks.length)
			{
				this.itemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		nbt.setShort("BurnTime", (short) this.burnTime);
		nbt.setShort("CookTime", (short) this.splitTime);
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < this.itemStacks.length; ++i)
		{
			if (this.itemStacks[i] != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.itemStacks[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		
		nbt.setTag("Items", nbttaglist);
	}
	
	public int getProgressScaled(int scalar)
	{
		return this.splitTime * scalar / this.getMaxSplitTime();
	}
	
	public int getBurnTimeRemainingScaled(int scalar)
	{
		if (this.maxBurnTime == 0)
		{
			this.maxBurnTime = 200;
		}
		
		return this.burnTime * scalar / this.maxBurnTime;
	}
	
	public boolean isBurning()
	{
		return this.burnTime > 0;
	}
	
	@Override
	public void update()
	{
		boolean burning = this.burnTime > 0;
		
		if (burning)
		{
				this.burnTime -= 4;
		}
		
		if (this.worldObj.isRemote)
			return;
		
		if (this.canSplit())
		{
			if (this.burnTime == 0)
			{
				ItemStack fuel = this.itemStacks[1];
				this.maxBurnTime = this.burnTime = getItemBurnTime(fuel);
				if (this.burnTime > 0)
				{
					this.markDirty();
					if (fuel != null)
					{
						--fuel.stackSize;
						if (fuel.stackSize == 0)
						{
							this.itemStacks[1] = fuel.getItem().getContainerItem(fuel);
						}
					}
				}
			}
			else if (this.isBurning())
			{
				++this.splitTime;
				if (this.splitTime >= this.getMaxSplitTime())
				{
					this.splitTime = 0;
					this.splitItem();
					this.markDirty();
				}
			}
			else
			{
				this.splitTime = 0;
			}
		}
		else
		{
			this.splitTime = 0;
		}
		
		if (burning != this.burnTime > 0)
		{
			this.markDirty();
			this.validate();
			BlockSplitter.setState(this.isBurning(), this.worldObj, this.pos);
		}
	}
	
	private boolean canSplit()
	{
		ItemStack input = this.itemStacks[0];
		if (input != null)
		{
			ItemStack output = SplitterRecipes.instance().getResult(input);
			ItemStack output2 = SplitterRecipes.instance().getResult2(input);
			if (output == null && output2 == null)
			{
				return false;	
			}
			ItemStack outputSlot = this.itemStacks[2];
			ItemStack outputSlot2 = this.itemStacks[3];
			if(outputSlot == null && outputSlot2 == null)
			{
				return true;
			}
			else if ((outputSlot2 != null && outputSlot != null) && (outputSlot.isItemEqual(output) && outputSlot2.isItemEqual(output2)))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	
	public void splitItem()
	{
		if (this.canSplit())
		{
			ItemStack input = this.itemStacks[0];
			ItemStack output = SplitterRecipes.instance().getResult(input);
			ItemStack output2 = SplitterRecipes.instance().getResult2(input);
			ItemStack outputSlot = this.itemStacks[2];
			ItemStack outputSlot2 = this.itemStacks[3];
			
			if (outputSlot == null && outputSlot2 == null)
			{
				this.itemStacks[2] = output.copy();
				this.itemStacks[3] = output2.copy();
			}
			else
			{
					if(outputSlot.isItemEqual(output))
					{
						outputSlot.stackSize += output.stackSize;
					}
					if(outputSlot2.isItemEqual(output2))
					{
						outputSlot2.stackSize += output2.stackSize;
					}
			}
			
			--input.stackSize;
			if (input.stackSize <= 0)
			{
				this.itemStacks[0] = null;
			}

		}
	}
	
	public static boolean isItemFuel(ItemStack stack)
	{
		return getItemBurnTime(stack) > 0;
	}
	
	public static int getItemBurnTime(ItemStack stack)
	{
		Item item = null;
		if(stack != null)
		{
			item = stack.getItem();
		}
		if(item == MItems.mana_leaf) return 820;
		if(item == Items.gold_nugget) return 960;
		if(item == Items.dye && item.getMetadata(stack) == 4) return 3200;
		if(item == Items.gold_ingot) return 6400;
		if(item == MItems.soul_gem) return 9600;
		if(item == MItems.radiant_quartz) return 12800;
		if(item == Item.getItemFromBlock(Blocks.lapis_block))return 32000;
		if(item == Item.getItemFromBlock(Blocks.gold_block) || item == Item.getItemFromBlock(MBlocks.radiant_block) || item == Item.getItemFromBlock(MBlocks.radiant_chiseled) || item == Item.getItemFromBlock(MBlocks.radiant_pillar))return 64000;
		if(item == Item.getItemFromBlock(MBlocks.soul_gem_block)) return 96000;
		return 0;
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
    {
		return index == 2 ? false : (index != 1 ? true : isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack));
    }

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? outputSlots : (side == EnumFacing.UP ? topInputSlot : inputSlots);
	}

	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
	{
	    return this.isItemValidForSlot(index, itemStackIn);
	}


	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
	{
	    if (direction == EnumFacing.DOWN && index == 1)
	    {
	            Item item = stack.getItem();

	        if (item != Items.water_bucket && item != Items.bucket)
	        {
	            return false;
	        }
	    }

	    return true;
	}
}