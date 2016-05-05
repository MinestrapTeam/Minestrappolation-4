package minestrapteam.mods.minestrappolation.item;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGuano extends Item
{
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
		{
			return false;
		}
		else
		{
			if (applyBonemeal(stack, worldIn, pos, playerIn))
			{
				if (!worldIn.isRemote)
				{
					worldIn.playAuxSFX(2005, pos, 0);
				}

				return true;
			}
			return false;
		}
	}

	public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target)
	{
		if (worldIn instanceof net.minecraft.world.WorldServer)
			return applyBonemeal(stack, worldIn, target, net.minecraftforge.common.util.FakePlayerFactory
				                                             .getMinecraft((net.minecraft.world.WorldServer) worldIn));
		return false;
	}

	public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target, EntityPlayer player)
	{
		IBlockState iblockstate = worldIn.getBlockState(target);

		int hook = net.minecraftforge.event.ForgeEventFactory
			           .onApplyBonemeal(player, worldIn, target, iblockstate, stack);
		if (hook != 0)
			return hook > 0;

		if (iblockstate.getBlock() instanceof IGrowable)
		{
			IGrowable igrowable = (IGrowable) iblockstate.getBlock();

			if (igrowable.canGrow(worldIn, target, iblockstate, worldIn.isRemote))
			{
				if (!worldIn.isRemote)
				{
					if (igrowable.canUseBonemeal(worldIn, worldIn.rand, target, iblockstate))
					{
						igrowable.grow(worldIn, worldIn.rand, target, iblockstate);
					}

					--stack.stackSize;
				}
				return true;
			}
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	public static void spawnBonemealParticles(World worldIn, BlockPos pos, int amount)
	{
		if (amount == 0)
		{
			amount = 15;
		}

		Block block = worldIn.getBlockState(pos).getBlock();

		if (block.isAir(worldIn, pos))
		{
			block.setBlockBoundsBasedOnState(worldIn, pos);

			for (int j = 0; j < amount; ++j)
			{
				double d0 = itemRand.nextGaussian() * 0.02D;
				double d1 = itemRand.nextGaussian() * 0.02D;
				double d2 = itemRand.nextGaussian() * 0.02D;
				worldIn.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY,
				                      (double) ((float) pos.getX() + itemRand.nextFloat()),
				                      (double) pos.getY() + (double) itemRand.nextFloat() * block.getBlockBoundsMaxY(),
				                      (double) ((float) pos.getZ() + itemRand.nextFloat()), d0, d1, d2);
			}
		}
		else
		{
			for (int i1 = 0; i1 < amount; ++i1)
			{
				double d0 = itemRand.nextGaussian() * 0.02D;
				double d1 = itemRand.nextGaussian() * 0.02D;
				double d2 = itemRand.nextGaussian() * 0.02D;
				worldIn.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY,
				                      (double) ((float) pos.getX() + itemRand.nextFloat()),
				                      (double) pos.getY() + (double) itemRand.nextFloat() * 1.0f,
				                      (double) ((float) pos.getZ() + itemRand.nextFloat()), d0, d1, d2);
			}
		}
	}
}
