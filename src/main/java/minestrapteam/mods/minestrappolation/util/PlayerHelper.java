package minestrapteam.mods.minestrappolation.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PlayerHelper 
{
	
	public static boolean hasArmorSet(EntityPlayer player, Item head, Item torso, Item legs, Item feet)
	{
		ItemStack helmet = player.getCurrentArmor(3);
		ItemStack chest = player.getCurrentArmor(2);
		ItemStack pants = player.getCurrentArmor(1);
		ItemStack boots = player.getCurrentArmor(0);
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
