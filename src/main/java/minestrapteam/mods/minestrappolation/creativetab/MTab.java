package minestrapteam.mods.minestrappolation.creativetab;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MTab extends CreativeTabs
{
	String tabLabel;
	public MTab(String label)
	{
		super(label);
		tabLabel = label;
		this.setBackgroundImageName("ministrappolation.png");
	}
	
	@Override
	public Item getTabIconItem()
	{
		if(tabLabel == "tabMBuilding")
		{
			return Item.getItemFromBlock(MBlocks.stone_pattern_bricks);
		}
		else if(tabLabel == "tabMDecor")
		{
			return Item.getItemFromBlock(MBlocks.ministrapp_sapling);
		}
		else if(tabLabel == "tabMTech")
		{
			return Item.getItemFromBlock(MBlocks.alloy);
		}
		else if(tabLabel == "tabMMaterials")
		{
			return MItems.reinforced_stick;
		}
		else if(tabLabel == "tabMFood")
		{
			return MItems.sugar_cookie;
		}
		else if(tabLabel == "tabMTools")
		{
			return MItems.copper_axe;
		}
		else
		{
			return MItems.fire_sword;
		}
	}
	
}
