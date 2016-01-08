package minestrapteam.mods.minestrappolation.inventory.container;

import java.util.List;

import minestrapteam.mods.minestrappolation.crafting.recipes.CrusherRecipes;
import minestrapteam.mods.minestrappolation.inventory.slot.SlotAccept;
import minestrapteam.mods.minestrappolation.inventory.slot.SlotCrusher;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityCrusher;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityEnderPorter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerEnderPorter extends MinestrappolationContainer
{
	private TileEntityEnderPorter	porter;
	
	public ContainerEnderPorter(EntityPlayer player, TileEntityEnderPorter porter)
	{
		super(player, porter);
		
		this.porter = porter;
		this.addSlotToContainer(new SlotAccept(porter, 0, 80, 17, Items.ender_pearl));
		this.addSlotToContainer(new SlotAccept(porter, 1, 80, 53, MItems.poschip));
		this.addInventorySlots();
	}
	
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
	}
	
	@Override
	public void updateProgressBar(int id, int time)
	{

	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.porter.isUseableByPlayer(player);
	}
}