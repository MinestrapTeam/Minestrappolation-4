package minestrapteam.mods.minestrappolation.item;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.util.Chance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class ItemHangGlider extends Item
{
	private double prevVelX;
	private double prevVelZ;
	
	public ItemHangGlider()
	{
		this.maxStackSize = 1;
        this.setMaxDamage(30);
        this.isDamageable();
        this.prevVelX = 0;
        this.prevVelZ = 0;
	}
	
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		
		if(isSelected && entityIn instanceof EntityPlayer)
		{
			Random rand = new Random();
			EntityPlayer entityplayer = (EntityPlayer)entityIn;
			double absX = Math.abs(entityplayer.motionX);
			double absZ = Math.abs(entityplayer.motionZ);
			entityplayer.motionY *= 0.6D;
			entityplayer.fallDistance = 0;
			
			for(int i = 5 ; i > 0 ; i--)
			{
				BlockPos pos = new BlockPos(entityplayer.posX, entityplayer.posY - i, entityplayer.posZ);
				if (worldIn.getBlockState(pos).getBlock() == Blocks.lava || worldIn.getBlockState(pos).getBlock() == Blocks.flowing_lava || worldIn.getBlockState(pos).getBlock() == MBlocks.magma || worldIn.getBlockState(pos).getBlock() == Blocks.fire || worldIn.getBlockState(pos).getBlock() == MBlocks.blazium_block)
				{
					entityplayer.motionY += (5 - i) * 0.01D;
					if(rand.nextInt(100) == 1)
					{
						if(stack.getItemDamage() < stack.getMaxDamage())
							stack.attemptDamageItem(1, rand);
						else
							entityplayer.destroyCurrentEquippedItem();
					}
				}
				else if(worldIn.getBlockState(pos).getBlock() == MBlocks.fan)
				{
					if(entityplayer.motionY <= 0)
						entityplayer.motionY += 0.1;
					else
						entityplayer.motionY += ((0.01 * Chance.randomNumber(i, 8)) * (5 - Chance.randomNumber(-i, i)));
				}
			}
			if (absX < 0.9D)
			{
				entityplayer.motionX *= 1.06D;
			}
			else if (absX < 0.15D)
			{
				entityplayer.motionX *= 1.1D;
			}
			
			if (absZ < 0.9D)
			{
				entityplayer.motionZ *= 1.06D;
			}
			else if (absZ < 0.15D)
			{
				entityplayer.motionZ *= 1.1D;
			}
			
			//TODO: Hang Gliders should take damage every time the player runs into a wall at high velocities. So far I have not found a way to make this work, since entityplayer.isCollidedHorizontally appears to be client-side only...
		}
	}
}
