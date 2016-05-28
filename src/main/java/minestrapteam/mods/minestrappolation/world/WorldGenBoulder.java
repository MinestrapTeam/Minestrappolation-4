package minestrapteam.mods.minestrappolation.world;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenBoulder extends WorldGenerator
{
	public int   boulderChance;
	public Block boulderBlock;

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		BlockPos randPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4),
		                           rand.nextInt(8) - rand.nextInt(8));
		BlockPos down = randPos.offset(EnumFacing.DOWN);

		if (worldIn.isAirBlock(randPos) && (worldIn.getBlockState(down).getBlock() == Blocks.grass
			                                    || worldIn.getBlockState(down).getBlock() == Blocks.stone))
		{
			this.boulderChance = rand.nextInt(5);
			if (this.boulderChance == 1)
				this.boulderBlock = MBlocks.coldstone_boulder;
			else if (this.boulderChance == 2)
				this.boulderBlock = MBlocks.red_rock_boulder;
			else if (this.boulderChance == 3)
				this.boulderBlock = MBlocks.icestone_boulder;
			else if (this.boulderChance == 4)
				this.boulderBlock = MBlocks.oceanstone_boulder;
			else
				this.boulderBlock = MBlocks.stone_boulder;

			worldIn.setBlockState(randPos, this.boulderBlock.getDefaultState(), 2);

			for (int i = 0; i < 64; i++)
			{
				randPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4),
				                  rand.nextInt(8) - rand.nextInt(8));

				if (worldIn.isAirBlock(randPos) && (worldIn.getBlockState(down).getBlock() == Blocks.grass
					                                    || worldIn.getBlockState(down).getBlock() == Blocks.stone
					                                    || worldIn.getBlockState(down).getBlock()
						                                       == MBlocks.lichen_permafrost))
				{
					worldIn.setBlockState(randPos, this.boulderBlock.getDefaultState(), 2);
				}
			}
		}
		return true;
	}
}
