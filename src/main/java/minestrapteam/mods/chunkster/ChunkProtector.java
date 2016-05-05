package minestrapteam.mods.chunkster;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import java.io.*;
import java.util.HashMap;

public class ChunkProtector
{
	public static HashMap<Key, ProtectionData> prot = new HashMap<Key, ProtectionData>();

	public static boolean protectChunk(int x, int y, String playerName)
	{
		if (!prot.containsKey(new Key(x, y)))
		{
			prot.put(new Key(x, y), new ProtectionData(playerName));
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean addCoOwner(int x, int y, String playerName)
	{
		return getProtectionData(x, y).addTrustedPlayer(playerName);
	}

	public static void unprotectChunk(int x, int y)
	{
		prot.remove(new Key(x, y));
	}

	public static boolean isChunkOwned(int x, int y)
	{
		return prot.containsKey(new Key(x, y));
	}

	public static ProtectionData getProtectionData(int x, int y)
	{
		return prot.get(new Key(x, y));
	}

	public static boolean canEditChunk(EntityPlayer player, int x, int y)
	{
		return MinecraftServer.getServer().getConfigurationManager().getOppedPlayers()
		                      .getGameProfileFromName(player.getName()) != null || getProtectionData(x, y).canEdit(
			UUIDHelper.getPlayerUUID(player.getName()));
	}

	public static void updateFile(String path)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream("Minestrapp/" + path + "/chunkster.pcz");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(prot);
			oos.close();
			fos.close();
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public static void loadFile(String path)
	{
		try
		{
			File file = new File("Minestrapp/" + path);
			if (!file.exists())
			{
				System.out.println("Creating chunkster folder.");
				file.mkdirs();
			}
			else
			{
				System.out.println("Reading chunkster data.");
			}
			FileInputStream fis = new FileInputStream(file + "/chunkster.pcz");
			ObjectInputStream ois = new ObjectInputStream(fis);
			prot = (HashMap<Key, ProtectionData>) ois.readObject();
			ois.close();
			fis.close();
		}
		catch (IOException ignored)
		{
		}
		catch (ClassNotFoundException c)
		{
			System.out.println("Class not found");
			c.printStackTrace();
		}
	}
}
