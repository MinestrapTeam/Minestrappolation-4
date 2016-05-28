package minestrapteam.mods.minestrappolation.util;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockUtil
{
	public static boolean isBlockBelow(World world, BlockPos pos, Block block, int range)
	{
		for (int h = -1; h < range; h--)
		{
			if (world.isAirBlock(pos.add(0, h, 0)))
			{
				continue;
			}
			else
				return world.getBlockState(pos.add(0, h, 0)).getBlock() == block;
		}
		return false;
	}
}
