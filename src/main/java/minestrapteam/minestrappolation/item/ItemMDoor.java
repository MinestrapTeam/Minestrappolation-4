package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.Minestrappolation;
import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;

public class ItemMDoor extends ItemDoor
{
	
	public ItemMDoor(Block block)
	{
		super(block);
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
	}
	
}
