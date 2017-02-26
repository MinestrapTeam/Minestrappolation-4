package minestrapteam.mods.minestrappolation.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PlayerHelper 
{
	
	public static boolean hasArmorSet(EntityPlayer player, Item head, Item torso, Item legs, Item feet)
	{
		ItemStack helmet = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		ItemStack pants = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
		ItemStack boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
		if (helmet != null && chest != null && pants != null && boots != null)
		{
			if(helmet.getItem() == head && chest.getItem() == torso && pants.getItem() == legs && boots.getItem() == feet)
			{
				return true;
			}
		}	
		return false;
	}
	
}
