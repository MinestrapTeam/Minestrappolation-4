package minestrapteam.mods.minestrappolation.inventory.container;

import minestrapteam.mods.minestrappolation.inventory.slot.SlotAccept;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityEnderPorter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

public class ContainerEnderPorter extends MinestrappolationContainer
{
	private TileEntityEnderPorter porter;

	public ContainerEnderPorter(EntityPlayer player, TileEntityEnderPorter porter)
	{
		super(player, porter);

		this.porter = porter;
		this.addSlotToContainer(new SlotAccept(porter, 0, 71, 17, Items.ender_pearl));
		this.addSlotToContainer(new SlotAccept(porter, 1, 89, 17, MItems.poschip));
		this.addSlotToContainer(new SlotAccept(porter, 2, 71, 53, MItems.upgradechip));
		this.addSlotToContainer(new SlotAccept(porter, 3, 89, 53, MItems.upgradechip));
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
