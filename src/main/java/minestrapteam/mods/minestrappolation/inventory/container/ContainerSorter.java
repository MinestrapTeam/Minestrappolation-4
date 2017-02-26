package minestrapteam.mods.minestrappolation.inventory.container;

import minestrapteam.mods.minestrappolation.tileentity.TileEntitySorter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSorter extends MinestrappolationContainer
{
	public ContainerSorter(EntityPlayer player, TileEntitySorter sorter)
	{
		super(player, sorter);
		
		this.addSlotToContainer(new Slot(sorter, 0, 80, 17));
		this.addSlotToContainer(new Slot(sorter, 1, 80, 52));
		this.addInventorySlots(0, 3);
	}
	
	@Override
	public int[] merge(EntityPlayer player, int slot, ItemStack stack)
	{
		return new int[] { 0, 2 };
	}
}
