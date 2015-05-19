package minestrapteam.minestrappolation.inventory.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;

public class SlotStoneCutter extends SlotCrafting
{
	private IInventory		extraSlotInv;
	private EntityPlayer	thePlayer;
	
	public SlotStoneCutter(EntityPlayer player, InventoryCrafting craftingInventory, IInventory p_i45790_3_, IInventory extra, int slot, int x, int y)
	{
		super(player, craftingInventory, p_i45790_3_, slot, x, y);
		this.extraSlotInv = extra;
		this.thePlayer = player;
	}
	
	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack stack)
	{
		super.onPickupFromSlot(player, stack);
		
		ItemStack extraSlotItem = this.extraSlotInv.getStackInSlot(0);
		
		if (this.extraSlotInv.getStackInSlot(0) != null)
		{
			this.extraSlotInv.decrStackSize(0, 1);
			
			if (extraSlotItem.getItem().hasContainerItem())
			{
				ItemStack extraSlotItemContainer = new ItemStack(extraSlotItem.getItem().getContainerItem());
				
				if (!extraSlotItem.getItem().hasContainerItem(extraSlotItem) || !this.thePlayer.inventory.addItemStackToInventory(extraSlotItemContainer))
				{
					if (this.extraSlotInv.getStackInSlot(0) == null)
					{
						this.extraSlotInv.setInventorySlotContents(0, extraSlotItemContainer);
					}
					else
					{
						this.thePlayer.dropPlayerItemWithRandomChoice(extraSlotItemContainer, false);
					}
				}
			}
		}
	}
	
}