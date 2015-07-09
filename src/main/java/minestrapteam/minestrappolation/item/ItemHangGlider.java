package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.util.Chance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemHangGlider extends Item
{
	private boolean	initCheck	= true;
	private boolean	checking	= false;
	
	public ItemHangGlider()
	{
		this.maxStackSize = 1;
        this.setMaxDamage(50);
        this.isDamageable();
	}
	
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		
			if(isSelected && entityIn instanceof EntityPlayer)
			{
				EntityPlayer entityplayer = (EntityPlayer)entityIn;
				double absX = Math.abs(entityplayer.motionX);
				double absZ = Math.abs(entityplayer.motionZ);
				entityplayer.motionY *= 0.6D;
				entityplayer.fallDistance = 0;
				
				for(int i = 5 ; i > 0 ; i--)
				{
					BlockPos pos = new BlockPos(entityplayer.posX, entityplayer.posY - i, entityplayer.posZ);
					if (worldIn.getBlockState(pos).getBlock() == Blocks.lava || worldIn.getBlockState(pos).getBlock() == Blocks.flowing_lava || worldIn.getBlockState(pos).getBlock() == MBlocks.magma)
					{
						entityplayer.motionY += (5 - i) * 0.01D;
						if(Chance.rand.nextInt(100) == 1)
						{
							if(stack.getItemDamage() < stack.getMaxDamage())
								stack.attemptDamageItem(1, Chance.rand);
							else
								entityplayer.destroyCurrentEquippedItem();
						}
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
				
				if (this.initCheck && absX + absZ > 0.15D)
				{
					this.checking = true;
					this.initCheck = false;
				}
				else if (!entityplayer.isCollidedHorizontally)
				{
					this.checking = false;
					this.initCheck = true;
				}
				
				// The problem for no damage is that player.isCollidedHorizontally
				// only
				// works client side, so it damages only client side, and not server
				// side. these packets do nothing.
				if (this.checking && entityIn.isCollidedHorizontally)
				{
					entityplayer.motionX = 0D;
					entityplayer.motionZ = 0D;
					this.checking = false;
					this.initCheck = true;
				}
				
				// wall colision
				/*
				 * if((Math.abs(prev2XMotion) > 0.3 || Math.abs(prev2ZMotion) > 0.3
				 * || (Math.abs(prev2XMotion) > 0.3 && Math.abs(prev2ZMotion) >
				 * 0.3)) && player.isCollidedHorizontally &&
				 * Math.abs(player.motionY) > 0.13) { par1ItemStack.damageItem(1,
				 * Minecraft.getMinecraft().thePlayer); }
				 */
			
		}
	}
}
