package minestrapteam.minestrappolation.inventory.container;

import minestrapteam.minestrappolation.crafting.sawmill.SawingManager;
import minestrapteam.minestrappolation.tileentity.TileEntitySawMill;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;

public class ContainerSawmill extends ContainerWorkbench
{
	public World				worldObj;
	public TileEntitySawMill	sawmill;
	
	public ContainerSawmill(EntityPlayer player, TileEntitySawMill sawmill)
	{
		super(player.inventory, sawmill.getWorld(), sawmill.getPos());
		this.worldObj = sawmill.getWorld();
		this.sawmill = sawmill;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.sawmill.isUseableByPlayer(player);
	}
	
	@Override
	public void onCraftMatrixChanged(IInventory inventory)
	{
		this.craftResult.setInventorySlotContents(0, SawingManager.instance.findMatchingRecipe(this.craftMatrix, this.worldObj));
	}
}