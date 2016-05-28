package minestrapteam.mods.minestrappolation.world;

import minestrapteam.mods.minestrappolation.block.BlockBush;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenBush extends WorldGenerator
{
	public Block bush;

	public WorldGenBush(Block bush)
	{
		this.bush = bush;
	}

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

			if (worldIn.isAirBlock(blockpos1) && ((BlockBush) this.bush).canBlockStay(worldIn, blockpos1))
			{
				worldIn.setBlockState(blockpos1, this.bush.getDefaultState().withProperty(BlockBush.AGE, 5), 2);
			}
		}

		return true;
	}
}
