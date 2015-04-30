package minestrapteam.minestrappolation.creativetab;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MTab extends CreativeTabs
{
	
	public MTab(String label)
	{
		super(label);
		this.setBackgroundImageName("ministrappolation.png");
	}
	
	@Override
	public Item getTabIconItem()
	{
		return MItems.copper_ingot;
	}
	
}
