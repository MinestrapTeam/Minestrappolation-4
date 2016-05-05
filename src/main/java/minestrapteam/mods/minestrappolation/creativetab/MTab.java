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
		this.tabLabel = label;
		this.setBackgroundImageName("ministrappolation.png");
	}

	@Override
	public Item getTabIconItem()
	{
		if (this.tabLabel == "tabMBuilding")
		{
			return Item.getItemFromBlock(MBlocks.stone_pattern_bricks);
		}
		else if (this.tabLabel == "tabMDecor")
		{
			return Item.getItemFromBlock(MBlocks.ministrapp_sapling);
		}
		else if (this.tabLabel == "tabMTech")
		{
			return Item.getItemFromBlock(MBlocks.alloy);
		}
		else if (this.tabLabel == "tabMMaterials")
		{
			return MItems.reinforced_stick;
		}
		else if (this.tabLabel == "tabMFood")
		{
			return MItems.sugar_cookie;
		}
		else if (this.tabLabel == "tabMTools")
		{
			return MItems.copper_axe;
		}
		else
		{
			return MItems.fire_sword;
		}
	}
}
