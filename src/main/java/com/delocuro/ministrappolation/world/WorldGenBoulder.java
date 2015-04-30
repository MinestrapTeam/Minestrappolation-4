package com.delocuro.ministrappolation.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.delocuro.ministrappolation.init.MBlocks;

public class WorldGenBoulder extends WorldGenerator
{
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		BlockPos randPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
		BlockPos down = randPos.offsetDown();
		
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
