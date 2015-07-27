package minestrapteam.mods.minestrappolation.tileentity;

import java.util.Random;

import minestrapteam.mods.minestrappolation.block.machines.BlockCrusher;
import minestrapteam.mods.minestrappolation.crafting.recipes.CrusherRecipes;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;

public class TileEntityCrusher extends TileEntityInventory implements IUpdatePlayerListBox, ISidedInventory
{
	private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
	public int	burnTime;
	public int	maxCrushTime;
	public int	crushTime;
	
	public TileEntityCrusher()
	{
		super(4);
	}
	
	public final int getMaxCrushTime()
	{
		return 150;
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
		this.crushTime = nbt.getShort("CookTime");
		this.maxCrushTime = getItemBurnTime(this.itemStacks[1]);
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
		nbt.setShort("CookTime", (short) this.crushTime);
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
		return this.crushTime * scalar / this.getMaxCrushTime();
	}
	
	public int getBurnTimeRemainingScaled(int scalar)
	{
		if (this.maxCrushTime == 0)
		{
			this.maxCrushTime = 200;
		}
		
		return this.burnTime * scalar / this.maxCrushTime;
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
		
		if (this.canCrush())
		{
			if (this.burnTime == 0)
			{
				ItemStack fuel = this.itemStacks[1];
				this.maxCrushTime = this.burnTime = getItemBurnTime(fuel);
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
				++this.crushTime;
				if (this.crushTime >= this.getMaxCrushTime())
				{
					this.crushTime = 0;
					this.crushItem();
					this.markDirty();
				}
			}
			else
			{
				this.crushTime = 0;
			}
		}
		else
		{
			this.crushTime = 0;
		}
		
		if (burning != this.burnTime > 0)
		{
			this.markDirty();
			this.validate();
			BlockCrusher.setState(this.isBurning(), this.worldObj, this.pos);
		}
	}
	
	private boolean canCrush()
	{
		ItemStack input = this.itemStacks[0];
		if (input != null)
		{
			ItemStack output = CrusherRecipes.instance().getResult(input);
			if (output == null)
				return false;
			ItemStack outputSlot = this.itemStacks[2];
			if (outputSlot == null)
				return true;
			if (!outputSlot.isItemEqual(output))
				return false;
			int result = outputSlot.stackSize + output.stackSize;
			return result <= output.getMaxStackSize();
		}
		return false;
	}
	
	public void crushItem()
	{
		if (this.canCrush())
		{
			Random rand = new Random();
			int chance = rand.nextInt(100);
			
			ItemStack input = this.itemStacks[0];
			int itemChance = CrusherRecipes.instance().getChance(input);
			ItemStack output = CrusherRecipes.instance().getResult(input);
			ItemStack outputSlot = this.itemStacks[2];
			if (outputSlot == null)
			{
				this.itemStacks[2] = output.copy();
			}
			else if (outputSlot.isItemEqual(output))
			{
				outputSlot.stackSize += output.stackSize;
			}
			
			--input.stackSize;
			if (input.stackSize <= 0)
			{
				this.itemStacks[0] = null;
			}
			
			if (chance < itemChance && this.itemStacks[3] == null)
			{
				this.itemStacks[3] = CrusherRecipes.instance().getExtra(input);
				this.itemStacks[3].stackSize = 1;
			}
			else if (chance < itemChance && this.itemStacks[3] != null)
			{
				if (this.itemStacks[3].isItemEqual(CrusherRecipes.instance().getExtra(input)))
				{
					this.itemStacks[3].stackSize += 1;
				}
			}
		}
	}
	
	public static boolean isItemFuel(ItemStack stack)
	{
		return getItemBurnTime(stack) > 0;
	}
	
	public static int getItemBurnTime(ItemStack stack)
	{
		if (stack == null)
			return 0;
		
		int i = TileEntityFurnace.getItemBurnTime(stack);
		if (i == 0)
		{
			Item item = stack.getItem();
		}
		
		return i;
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
    {
		return index == 2 ? false : (index != 1 ? true : isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack));
    }

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
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
	
	@Override
	public String getCommandSenderName() 
	{
		return "container.crusher";
	}
}