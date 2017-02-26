package minestrapteam.mods.minestrappolation.inventory.slot;

import minestrapteam.mods.minestrappolation.item.ItemBackpack;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBackpack extends Slot
{
	public SlotBackpack(IInventory par1iInventory, int par2, int par3, int par4)
	{
		super(par1iInventory, par2, par3, par4);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
		return !(itemstack.getItem() instanceof ItemBackpack);
	}

}