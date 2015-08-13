package minestrapteam.mods.minestrappolation.item;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import org.lwjgl.input.Mouse;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.handlers.MGuiHandler;
import minestrapteam.mods.minestrappolation.inventory.InventoryBackpack;
import minestrapteam.mods.minestrappolation.inventory.container.ContainerBackpack;
import minestrapteam.mods.minestrappolation.inventory.container.ContainerSatchel;

public class ItemBackpack extends Item
{
	//0 = backpack, 1 = satchel
	private int type;
	
	public ItemBackpack(int type)
	{
		this.maxStackSize = 1;
		this.type = type;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) 
	{
		return 1;
	}
		
	/*
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean isCurrentItem)
	{
		if (!world.isRemote && entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;

			if (player.openContainer != null && player.openContainer instanceof ContainerBackpack && ((ContainerBackpack) player.openContainer).needsUpdate)
			{
				((ContainerBackpack) player.openContainer).writeToNBT();
				
				((ContainerBackpack) player.openContainer).needsUpdate = false;
			}
			
			if (player.openContainer != null && player.openContainer instanceof ContainerSatchel && ((ContainerSatchel) player.openContainer).needsUpdate)
			{
				((ContainerSatchel) player.openContainer).writeToNBT();

				((ContainerSatchel) player.openContainer).needsUpdate = false;
			}
		}
	}	
	*/

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		ItemBackpack item = (ItemBackpack)player.getHeldItem().getItem();

		if (!world.isRemote) 
		{
			if (!player.isSneaking()) 
			{
				if(item.type == 0)
				{
					player.openGui(Minestrappolation.instance, MGuiHandler.GUIID_BACKPACK, world,(int) player.posX, (int) player.posY, (int) player.posZ);
					
				}
				if(item.type == 1)
				{
					player.openGui(Minestrappolation.instance, MGuiHandler.GUIID_SATCHEL, world,(int) player.posX, (int) player.posY, (int) player.posZ);
				}
			} 
			else 
			{
				new InventoryBackpack(player.getHeldItem());
			}
		}
		return stack;
	}
}