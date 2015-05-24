package minestrapteam.minestrappolation.util;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class MFuelHandler implements IFuelHandler
{
	
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.ministrapp_log))
			return 300;
		return 0;
	}
	
}
