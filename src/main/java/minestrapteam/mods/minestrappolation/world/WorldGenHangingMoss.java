package minestrapteam.mods.minestrappolation.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenHangingMoss extends WorldGenerator
{
	Block block;

	public WorldGenHangingMoss(Block block)
	{
		this.block = block;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		if (world.getBlockState(pos.down()).getBlock() == Blocks.air
			    && world.getBlockState(pos.up()).getBlock() != Blocks.air)
		{
			for (int i = 0; i < 64; i++)
			{
				BlockPos randPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4),
				                           rand.nextInt(8) - rand.nextInt(8));
				if (this.block.canPlaceBlockAt(world, randPos))
				{
					world.setBlockState(randPos, this.block.getDefaultState(), 2);
				}
			}
		}
		return true;
	}
}
