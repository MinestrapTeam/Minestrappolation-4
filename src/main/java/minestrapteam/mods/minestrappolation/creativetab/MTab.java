package minestrapteam.mods.minestrappolation.creativetab;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
	public ItemStack getTabIconItem()
	{
		if(tabLabel == "tabMBuilding")
		{
			return new ItemStack(MBlocks.stone_pattern_bricks);
		}
		else if(tabLabel == "tabMDecor")
		{
			return new ItemStack(MBlocks.ministrapp_sapling);
		}
		else if(tabLabel == "tabMTech")
		{
			return new ItemStack(MBlocks.alloy);
		}
		else if(tabLabel == "tabMMaterials")
		{
			return new ItemStack(MItems.reinforced_stick);
		}
		else if(tabLabel == "tabMFood")
		{
			return new ItemStack(MItems.sugar_cookie);
		}
		else if(tabLabel == "tabMTools")
		{
			return new ItemStack(MItems.copper_axe);
		}
		else
		{
			return new ItemStack(MItems.fire_sword);
		}
	}
	
}
