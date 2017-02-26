package minestrapteam.mods.chunkster;

import com.mojang.authlib.GameProfile;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class UUIDHelper 
{
	public static boolean isValidUUID(String name)
	{
		GameProfile profile = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerProfileCache().getGameProfileForUsername(name);
		if(profile == null)
		{
			return false;
		}
		return true;
	}
	
	public static String getPlayerUUID(String name)
	{
		GameProfile profile = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerProfileCache().getGameProfileForUsername(name);
		if(!isValidUUID(name))
		{
			return "could not look up UUID is the username correct?";
		}
		return profile.getId().toString();
	}
}
