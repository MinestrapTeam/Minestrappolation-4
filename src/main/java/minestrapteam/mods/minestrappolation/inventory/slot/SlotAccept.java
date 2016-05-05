package minestrapteam.mods.minestrappolation.inventory.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotAccept extends Slot
{
	Item itemToAccept;

	public SlotAccept(IInventory par1iInventory, int par2, int par3, int par4, Item item)
	{
		super(par1iInventory, par2, par3, par4);
		this.itemToAccept = item;
	}

	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
		return itemstack.getItem() == this.itemToAccept;
	}
}
