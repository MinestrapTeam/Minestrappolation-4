package minestrapteam.mods.minestrappolation.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Chance
{
	private static Random rand = new Random();
	@SuppressWarnings("rawtypes")
	private static Map<String, ArrayList>	chanceTableMap	= new HashMap<String, ArrayList>();
	
	public static int randomNumber(int min, int max)
	{
		int number = rand.nextInt(max - min + 1) + min;
		return number;
		
	}
	
	public static boolean doesTableExist(String table){
		return chanceTableMap.containsKey(table);
	}
	
	public static void clearTable(String table)
	{
		chanceTableMap.get(table).clear();
	}
	
	public static void createChanceTable(String table, @SuppressWarnings("rawtypes") ArrayList list)
	{
		chanceTableMap.put(table, list);
	}
	
	@SuppressWarnings("unchecked")
	public static void addToChanceTable(String table, Object toAdd, int chance)
	{
		for (int a = 0; a < chance; a++)
		{
			chanceTableMap.get(table).add(toAdd);
		}
	}
	
	public static int chanceTableSize(String table){
		return chanceTableMap.get(table).size();
	}
	
	public static Object getRandomFromTable(String table)
	{
		if(doesTableExist(table))
		{
			int index = randomNumber(0, chanceTableMap.get(table).size() - 1);
			return chanceTableMap.get(table).get(index);
		}
		else
		{
			return null;
		}
		
	}
}
