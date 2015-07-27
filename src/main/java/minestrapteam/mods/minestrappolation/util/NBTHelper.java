package minestrapteam.mods.minestrappolation.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class NBTHelper {
	
	public static NBTTagCompound getPersistedPlayerTag(EntityPlayer player)
	{
		NBTTagCompound nbt;
		if (!player.getEntityData().hasKey("PlayerPersisted")) 
		{
		   nbt = new NBTTagCompound();
		   player.getEntityData().setTag("PlayerPersisted", nbt);
		} 
		else 
		{
		   nbt = player.getEntityData().getCompoundTag("PlayerPersisted");
		}
		return nbt;
	}

}
