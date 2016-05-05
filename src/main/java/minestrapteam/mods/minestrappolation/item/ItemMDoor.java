package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;

public class ItemMDoor extends ItemDoor
{

	public ItemMDoor(Block block)
	{
		super(block);
		this.setCreativeTab(Minestrappolation.tabMDecor);
	}
}
