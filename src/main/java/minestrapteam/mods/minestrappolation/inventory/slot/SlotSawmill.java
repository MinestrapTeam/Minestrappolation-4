package minestrapteam.mods.minestrappolation.inventory.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class SlotSawmill extends SlotCrafting{

	private final InventoryCrafting craftMatrix;
	
	public SlotSawmill(EntityPlayer player, InventoryCrafting craftingInventory, IInventory p_i45790_3_, int slotIndex, int xPosition, int yPosition)
	{
		super(player, craftingInventory, p_i45790_3_, slotIndex, xPosition, yPosition);
		this.craftMatrix = craftingInventory;
	}

	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack stack)
	{
		net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerCraftingEvent(player, stack, craftMatrix);
        this.onCrafting(stack);
        net.minecraftforge.common.ForgeHooks.setCraftingPlayer(player);
        ItemStack[] aitemstack = CraftingManager.getInstance().func_180303_b(this.craftMatrix, player.worldObj);
        net.minecraftforge.common.ForgeHooks.setCraftingPlayer(null);

        for (int i = 0; i < aitemstack.length; ++i)
        {
            this.craftMatrix.decrStackSize(i, 1);
        }
	}
}
