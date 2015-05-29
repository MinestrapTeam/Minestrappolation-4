package minestrapteam.minestrappolation.util;

import java.util.ArrayList;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class Tables {
	public static void loadTables()
	{
		createTables();
		populateTables();
	}

	private static void createTables()
	{
		Chance.createChanceTable("sifter", new ArrayList<Item>());
	}
	
	private static void populateTables()
	{
		Chance.addToChanceTable("sifter", null, 25);
    	Chance.addToChanceTable("sifter", MItems.chunks, 5);
    	Chance.addToChanceTable("sifter", Items.clay_ball, 15);
	}
}
