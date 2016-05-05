package minestrapteam.mods.minestrappolation.inventory.container;

import minestrapteam.mods.minestrappolation.tileentity.TileEntityPipe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerPipe extends MinestrappolationContainer
{
	public ContainerPipe(EntityPlayer player, TileEntityPipe pipe)
	{
		super(player, pipe);

		this.addSlotToContainer(new Slot(pipe, 0, 80, 17));
		this.addInventorySlots(0, -36);
	}

	@Override
	public int[] merge(EntityPlayer player, int slot, ItemStack stack)
	{
		return new int[] { 0, 1 };
	}
}
