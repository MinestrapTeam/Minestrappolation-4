package minestrapteam.minestrappolation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ChunkProtector 
{
	public static HashMap<Key, String> prot = new HashMap<Key, String>();
	
	public static boolean protectChunk(int x, int y, String playerName)
	{
		if(!prot.containsKey(new Key(x, y)))
		{
			prot.put(new Key(x, y), playerName);
			return true;
		}
		else
		{
			return false;
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
	
	public static String getOwner(int x, int y)
	{
		return prot.get(new Key(x, y));
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
               System.out.printf("Serialized new protection data is saved in Minestrapp/"+path+"/chunkster.pcz");
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
	      System.out.println("Deserialized protection data...");
	      Set set = prot.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) 
	      {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("key: "+ mentry.getKey() + " & Value: ");
	         System.out.println(mentry.getValue());
	      }
	}
	
}
