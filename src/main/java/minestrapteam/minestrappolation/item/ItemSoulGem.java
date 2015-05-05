package minestrapteam.minestrappolation.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSoulGem extends MItemFoiled{
	
	
	public ItemSoulGem()
	{
		super();
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.addExperience(20);
		--stack.stackSize;
		return stack;
	}
}
