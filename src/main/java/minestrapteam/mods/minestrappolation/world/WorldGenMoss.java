package minestrapteam.mods.minestrappolation.world;

import minestrapteam.mods.minestrappolation.block.BlockMoss;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenMoss extends WorldGenerator
{
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		Block block;

		do
		{
			block = worldIn.getBlockState(pos).getBlock();
			if (!block.isLeaves(worldIn, pos) && !block.isLeaves(worldIn, pos))
				break;
			pos = pos.down();
		}
		while (pos.getY() > 0);

		for (int i = 0; i < 40; ++i)
		{
			BlockPos blockpos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4),
			                             rand.nextInt(8) - rand.nextInt(8));

			if (worldIn.isAirBlock(blockpos1) && ((BlockMoss) MBlocks.moss)
				                                     .canBlockStay(worldIn, blockpos1, MBlocks.moss.getDefaultState()))
			{
				worldIn.setBlockState(blockpos1, MBlocks.moss.getDefaultState(), 2);
			}
		}

		return true;
	}
}
