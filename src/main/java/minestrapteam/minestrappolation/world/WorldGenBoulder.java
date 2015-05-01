package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBoulder extends WorldGenerator
{
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		BlockPos randPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
		BlockPos down = randPos.offset(EnumFacing.DOWN);
		
		if (worldIn.isAirBlock(randPos) && (worldIn.getBlockState(down).getBlock() == Blocks.grass || worldIn.getBlockState(down).getBlock() == Blocks.stone))
		{
			worldIn.setBlockState(randPos, MBlocks.stone_boulder.getDefaultState(), 2);
			
			for (int i = 0; i < 64; i++)
			{
				randPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
				
				if (worldIn.isAirBlock(randPos) && (worldIn.getBlockState(down).getBlock() == Blocks.grass || worldIn.getBlockState(down).getBlock() == Blocks.stone))
				{
					worldIn.setBlockState(randPos, MBlocks.stone_boulder.getDefaultState(), 2);
				}
			}
		}
		return true;
	}
}
