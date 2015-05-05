package minestrapteam.minestrappolation.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MItemFoiled extends Item
{
	public MItemFoiled()
	{
		super();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}
}