package minestrapteam.minestrappolation.tileentity;

import minestrapteam.minestrappolation.util.MelterRecipes;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class TileEntityMelter extends TileEntityInventory implements ISidedInventory, IUpdatePlayerListBox
{
	public int					burnTime;
	public int					maxBurnTime;
	public int					meltTime;
	
	public boolean				hasPower;
	
	private static final int[]	topInputSlot	= new int[] { 0 };
	private static final int[]	outputSlots		= new int[] { 2, 1 };
	private static final int[]	inputSlots		= new int[] { 1 };
	
	public TileEntityMelter()
	{
		super(4);
	}
	
	public final int getMaxMeltTime()
	{
		return this.hasPower ? 800 : 1600;
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
		this.meltTime = nbt.getShort("CookTime");
		this.maxBurnTime = getItemBurnTime(this.itemStacks[1]);
	}
	
	public boolean isPowered()
	{
		return this.hasPower;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt)
	{
		super.writeToNBT(nbt);
		
		nbt.setShort("BurnTime", (short) this.burnTime);
		nbt.setShort("CookTime", (short) this.meltTime);
	}
	
	public int getProgressScaled(int scalar)
	{
		return this.meltTime * scalar / this.getMaxMeltTime();
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
		if(this.worldObj.isBlockIndirectlyGettingPowered(this.getPos()) > 0)
		{
			this.hasPower = true;
		}
		else
		{
			this.hasPower = false;
		}
 		
		boolean burning = this.burnTime > 0;
		
		if (burning)
		{
			if (this.hasPower)
			{
				this.burnTime -= 16;
			}
			else
			{
				this.burnTime -= 4;
			}
		}
		
		if (this.worldObj.isRemote)
		{
			return;
		}
		
		if (this.canSmelt())
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
				++this.meltTime;
				if (this.meltTime >= this.getMaxMeltTime())
				{
					this.meltTime = 0;
					this.smeltItem();
					this.markDirty();
				}
			}
			else
			{
				this.meltTime = 0;
			}
		}
		else
		{
			this.meltTime = 0;
		}
		
		if (burning != this.burnTime > 0)
		{
			this.markDirty();
			this.validate();
		}
	}
	
	private boolean canSmelt()
	{
		ItemStack input = this.itemStacks[0];
		if (input != null)
		{
			ItemStack output = MelterRecipes.instance().getResult(input);
			if (output == null)
			{
				return false;
			}
			ItemStack container = new ItemStack(Items.bucket);
			if (container != null)
			{
				if (!ItemStack.areItemsEqual(container, this.itemStacks[3]))
				{
					return false;
				}
			}
			ItemStack outputSlot = this.itemStacks[2];
			if (outputSlot == null)
			{
				return true;
			}
			if (!outputSlot.isItemEqual(output))
			{
				return false;
			}
			int result = outputSlot.stackSize + output.stackSize;
			return result <= output.getMaxStackSize();
		}
		return false;
	}
	
	public void smeltItem()
	{
		if (this.canSmelt())
		{
			ItemStack input = this.itemStacks[0];
			ItemStack output = MelterRecipes.instance().getResult(input);
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
			
			ItemStack bucket = this.itemStacks[3];
			if (bucket != null && ItemStack.areItemsEqual(bucket, new ItemStack(Items.bucket)))
			{
				--bucket.stackSize;
				if (bucket.stackSize <= 0)
				{
					this.itemStacks[3] = null;
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
		{
			return 0;
		}
		
		int i = TileEntityFurnace.getItemBurnTime(stack);
		if (i == 0)
		{
			Item item = stack.getItem();
		}
		
		return i;
	}
	
	@Override
	public boolean canInsertItem(int slotID, ItemStack stack, EnumFacing side)
	{
		return this.isItemValidForSlot(slotID, stack);
	}
	
	@Override
	public boolean canExtractItem(int slotID, ItemStack stack, EnumFacing side)
	{
		return slotID != 1 || stack.getItem() == Items.bucket;
	}	

	@Override
	public int[] getSlotsForFace(EnumFacing side) 
	{
		return null;
	}

}