package minestrapteam.mods.minestrappolation.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityCrate extends TileEntityInventory
{
	public String	test;
	
	public TileEntityCrate()
	{
		super(18);
	}
	
	@Override
	public int getSizeInventory()
	{
		return 18;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound parentNBTTagCompound)
	{
		super.writeToNBT(parentNBTTagCompound);
		NBTTagList dataForAllSlots = new NBTTagList();
		for (int i = 0; i < this.itemStacks.length; ++i)
		{
			if (this.itemStacks[i] != null)
			{
				NBTTagCompound dataForThisSlot = new NBTTagCompound();
				dataForThisSlot.setByte("Slot", (byte) i);
				this.itemStacks[i].writeToNBT(dataForThisSlot);
				dataForAllSlots.appendTag(dataForThisSlot);
			}
		}
		parentNBTTagCompound.setTag("Items", dataForAllSlots);
	}
	
	@Override
	public String getCommandSenderName() 
	{
		return "container.crate";
	}
}
