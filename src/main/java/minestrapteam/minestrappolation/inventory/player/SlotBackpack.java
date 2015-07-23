package minestrapteam.minestrappolation.inventory.player;

import minestrapteam.minestrappolation.item.ItemBackpack;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBackpack extends Slot
{
	public SlotBackpack(IInventory inventory, int par2, int par3, int par4)
	{
		super(inventory, par2, par3, par4);
	}

	@Override

	public boolean isItemValid(ItemStack itemstack)
	{
		return itemstack.getItem() instanceof ItemBackpack;
	}
}
