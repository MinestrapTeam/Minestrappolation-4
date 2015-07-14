package minestrapteam.chunkster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;

public class ChunkProtector 
{
	public static HashMap<Key, ArrayList<String>> prot = new HashMap<Key, ArrayList<String>>();
	
	public static boolean protectChunk(int x, int y, String playerName)
	{
		if(!prot.containsKey(new Key(x, y)))
		{
			prot.put(new Key(x, y), new ArrayList());
			getPlayersList(x, y).add(playerName);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void addCoOwner(int x, int y, String playerName)
	{
		if(!getPlayersList(x, y).contains(playerName))
		{
			getPlayersList(x, y).add(playerName);
		}
	}
	
	public static void removeCoOwner(int x, int y, String playerName)
	{
		if(getPlayersList(x, y).contains(playerName))
		{
			getPlayersList(x, y).remove(playerName);
		}
	}
	
	public static void unprotectChunk(int x, int y)
	{
		prot.remove(new Key(x, y));
	}
	
	public static boolean isChunkOwned(int x, int y)
	{
		return prot.containsKey(new Key(x, y));
	}
	
	public static ArrayList getPlayersList(int x, int y)
	{
		return prot.get(new Key(x, y));
	}
	
	public static boolean canEditChunk(EntityPlayer player, int x, int y)
	{
		return getPlayersList(x, y).contains(UUIDHelper.getPlayerUUID(player.getName()));
	}
	
	public static void updateFile(String path)
	{
		try
        {
               FileOutputStream fos = new FileOutputStream("Minestrapp/"+path+"/chunkster.pcz");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(prot);
               oos.close();
               fos.close();
               System.out.printf("new protection data is saved in Minestrapp/"+path+"/chunkster.pcz");
        }
		catch(IOException ioe)
        {
               ioe.printStackTrace();
        }
	}
	
	public static void loadFile(String path)
	{
		 try
	      {
			 File file = new File("Minestrapp/"+path);
			 if(!file.exists())
			 {
				 System.out.println("Creating chunkster folder.");
				 file.mkdirs();
			 }
			 else
			 {
				 System.out.println("Reading chunkster data.");
			 }
	         FileInputStream fis = new FileInputStream(file+"/chunkster.pcz");
	         ObjectInputStream ois = new ObjectInputStream(fis);
	         prot = (HashMap) ois.readObject();
	         ois.close();
	         fis.close();
	      }
		  catch(IOException ioe)
	      { 
	         return;
	      }
		  catch(ClassNotFoundException c)
	      {
	         System.out.println("Class not found");
	         c.printStackTrace();
	         return;
	      }
	}
	
}
