package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemInertCrystalHeart extends Item
{
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (playerIn.getMaxHealth() > 10F)
		{
			playerIn.addStat(MAchievements.crystal_heart, 1);
			playerIn.attackEntityFrom(DamageSource.causeIndirectMagicDamage(playerIn, playerIn), (float) 10);
			itemStackIn.setItem(MItems.crystal_heart);
			itemStackIn.stackSize = 1;
		}
		return itemStackIn;
	}
}
