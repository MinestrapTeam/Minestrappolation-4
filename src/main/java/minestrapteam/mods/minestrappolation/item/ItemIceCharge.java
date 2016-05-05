package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.block.machines.BlockFrostGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemIceCharge extends Item
{
	public ItemIceCharge()
	{
		this.setCreativeTab(Minestrappolation.tabMMaterials);
	}

	/**
	 * Called when a Block is right-clicked with this Item
	 *
	 * @param pos
	 * 	The block being right-clicked
	 * @param side
	 * 	The side being right-clicked
	 */
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
		{
			return true;
		}
		else
		{
			BlockPos pos1 = pos.offset(side);
			if (!playerIn.canPlayerEdit(pos, side, stack))
				return false;
			else
			{
				if (BlockFrostGenerator.canFreeze.containsKey(worldIn.getBlockState(pos1)))
				{
					worldIn.playSoundEffect(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "dig.glass", 1.0F,
					                        itemRand.nextFloat() * 0.4F + 0.8F);
					worldIn.setBlockState(pos1, BlockFrostGenerator.canFreeze.get(worldIn.getBlockState(pos1)));
					stack.damageItem(4, playerIn);
				}
				else if (BlockFrostGenerator.canFreeze.containsKey(worldIn.getBlockState(pos)))
				{
					worldIn.playSoundEffect(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "dig.glass", 1.0F,
					                        itemRand.nextFloat() * 0.4F + 0.8F);
					worldIn.setBlockState(pos, BlockFrostGenerator.canFreeze.get(worldIn.getBlockState(pos)));
					stack.damageItem(4, playerIn);
				}
				if (!playerIn.capabilities.isCreativeMode)
				{
					--stack.stackSize;
				}
				return true;
			}
		}
	}
}
