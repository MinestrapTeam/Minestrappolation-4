package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.Config;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSoulGem extends MItemFoiled
{
	
	public ItemSoulGem()
	{
		super();
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.addExperience(Config.soulGemXPGain);
		--stack.stackSize;
		return stack;
	}
}
