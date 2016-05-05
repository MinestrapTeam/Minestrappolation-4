package minestrapteam.mods.minestrappolation.inventory.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class SlotStoneCutter extends SlotCrafting
{
	private       IInventory        extraSlotInv;
	private       EntityPlayer      thePlayer;
	private final InventoryCrafting craftMatrix;

	public SlotStoneCutter(EntityPlayer player, InventoryCrafting craftingInventory, IInventory p_i45790_3_, IInventory extra, int slot, int x, int y)
	{
		super(player, craftingInventory, p_i45790_3_, slot, x, y);
		this.extraSlotInv = extra;
		this.thePlayer = player;
		this.craftMatrix = craftingInventory;
	}

	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack stack)
	{
		net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerCraftingEvent(player, stack,
		                                                                                  this.craftMatrix);
		this.onCrafting(stack);
		net.minecraftforge.common.ForgeHooks.setCraftingPlayer(player);
		ItemStack[] aitemstack = CraftingManager.getInstance().func_180303_b(this.craftMatrix, player.worldObj);
		net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);

		for (int i = 0; i < aitemstack.length; ++i)
		{
			this.craftMatrix.decrStackSize(i, 1);
		}

		ItemStack extraSlotItem = this.extraSlotInv.getStackInSlot(0);

		if (this.extraSlotInv.getStackInSlot(0) == null)
			return;

		this.extraSlotInv.decrStackSize(0, 1);
		if (!extraSlotItem.getItem().hasContainerItem(extraSlotItem))
			return;

		ItemStack extraSlotItemContainer = new ItemStack(extraSlotItem.getItem().getContainerItem());
		if (extraSlotItem.getItem().hasContainerItem(extraSlotItem) && this.thePlayer.inventory.addItemStackToInventory(
			extraSlotItemContainer))
			return;

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
