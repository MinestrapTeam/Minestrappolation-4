package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.util.NBTHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHeartContainer extends MItemFoiled
{
	public ItemHeartContainer()
	{
		this.maxStackSize = 1;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (playerIn.getMaxHealth() < Config.healthIncreaseMax)
		{

			playerIn.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(playerIn.getMaxHealth() + 2D);
			NBTHelper.getPersistedPlayerTag(playerIn).setDouble("health", playerIn.getMaxHealth());
			playerIn.addStat(MAchievements.heart, 1);
			--itemStackIn.stackSize;
		}
		return itemStackIn;
	}
}
