package minestrapteam.minestrappolation.item;

import org.lwjgl.input.Mouse;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.handlers.MGuiHandler;
import minestrapteam.minestrappolation.inventory.container.ContainerBackpack;
import minestrapteam.minestrappolation.inventory.container.ContainerSatchel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;

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
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean isCurrentItem)
	{
		if (!world.isRemote && entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;

			if (FMLClientHandler.instance().getClient().inGameHasFocus && Mouse.isButtonDown(1) && player.getHeldItem() != null && player.getHeldItem().getItem() instanceof ItemBackpack)
			{
				if(type == 0)
				{
					player.openGui(Minestrappolation.instance, MGuiHandler.GUIID_BACKPACK, world,(int) player.posX, (int) player.posY, (int) player.posZ);
					
				}
				if(type == 1)
				{
					player.openGui(Minestrappolation.instance, MGuiHandler.GUIID_SATCHEL, world,(int) player.posX, (int) player.posY, (int) player.posZ);
				}
			}

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
}