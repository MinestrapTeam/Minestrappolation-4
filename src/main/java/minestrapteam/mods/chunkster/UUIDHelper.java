package minestrapteam.mods.chunkster;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.MinecraftServer;

public class UUIDHelper
{
	public static boolean isValidUUID(String name)
	{
		GameProfile profile = MinecraftServer.getServer().getPlayerProfileCache().getGameProfileForUsername(name);
		return profile != null;
	}

	public static String getPlayerUUID(String name)
	{
		GameProfile profile = MinecraftServer.getServer().getPlayerProfileCache().getGameProfileForUsername(name);
		if (!isValidUUID(name))
		{
			return "could not look up UUID is the username correct?";
		}
		return profile.getId().toString();
	}
}
