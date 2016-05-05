package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.entity.EntityMudBall;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemMudBall extends Item
{
	public ItemMudBall()
	{
		this.maxStackSize = 16;
		this.setCreativeTab(Minestrappolation.tabMMaterials);
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world,
	 * entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
	{
		if (!playerIn.capabilities.isCreativeMode)
		{
			--itemStackIn.stackSize;
		}

		worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

		if (!worldIn.isRemote)
		{
			worldIn.spawnEntityInWorld(new EntityMudBall(worldIn, playerIn));
		}

		playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
		return itemStackIn;
	}
}
