package com.delocuro.ministrappolation.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.delocuro.ministrappolation.init.MinestrappolationBlocks;

public class WorldGenBoulder extends WorldGenerator
{
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
    {
        
            BlockPos blockpos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos1) && (worldIn.getBlockState(blockpos1.down()).getBlock() == Blocks.grass || worldIn.getBlockState(blockpos1.down()).getBlock() == Blocks.stone))
            {
            	worldIn.setBlockState(blockpos1, MinestrappolationBlocks.stone_boulder.getDefaultState(), 2);
            	
            	for (int i = 0; i < 64; i++)
                {
            		blockpos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            		
            		if (worldIn.isAirBlock(blockpos1) && (worldIn.getBlockState(blockpos1.down()).getBlock() == Blocks.grass || worldIn.getBlockState(blockpos1.down()).getBlock() == Blocks.stone))
                    {
            			worldIn.setBlockState(blockpos1, MinestrappolationBlocks.stone_boulder.getDefaultState(), 2);
                    }
                }
            }
            return true;
    }
}
