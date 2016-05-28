package minestrapteam.mods.minestrappolation.world;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenMud extends WorldGenerator
{
	private Block block;
	private int   numberOfBlocks;

	public WorldGenMud(int size)
	{
		this.block = MBlocks.mud;
		this.numberOfBlocks = size;
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		if (worldIn.getBlockState(position).getBlock().getMaterial() != Material.water)
		{
			return false;
		}
		else
		{
			int i = rand.nextInt(this.numberOfBlocks - 2) + 2;
			byte b0 = 1;

			for (int j = position.getX() - i; j <= position.getX() + i; ++j)
			{
				for (int k = position.getZ() - i; k <= position.getZ() + i; ++k)
				{
					int l = j - position.getX();
					int i1 = k - position.getZ();

					if (l * l + i1 * i1 <= i * i)
					{
						for (int j1 = position.getY() - b0; j1 <= position.getY() + b0; ++j1)
						{
							BlockPos blockpos1 = new BlockPos(j, j1, k);
							Block block = worldIn.getBlockState(blockpos1).getBlock();

							if (block == Blocks.dirt || block == MBlocks.mud)
							{
								worldIn.setBlockState(blockpos1, this.block.getDefaultState(), 2);
							}
						}
					}
				}
			}

			return true;
		}
	}
}
