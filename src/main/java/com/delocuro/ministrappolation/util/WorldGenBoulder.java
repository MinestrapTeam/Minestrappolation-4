package com.delocuro.ministrappolation.util;

import java.util.Random;

import com.delocuro.ministrappolation.init.MinistrappolationBlocks;

import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.state.IBlockState;
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
        
            BlockPos blockpos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos1) && (worldIn.getBlockState(blockpos1.down()).getBlock() == Blocks.grass || worldIn.getBlockState(blockpos1.down()).getBlock() == Blocks.stone))
            {
            	worldIn.setBlockState(blockpos1, MinistrappolationBlocks.stone_boulder.getDefaultState(), 2);
            	
            	for (int i = 0; i < 64; i++)
                {
            		blockpos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            		
            		if (worldIn.isAirBlock(blockpos1) && (worldIn.getBlockState(blockpos1.down()).getBlock() == Blocks.grass || worldIn.getBlockState(blockpos1.down()).getBlock() == Blocks.stone))
                    {
            			worldIn.setBlockState(blockpos1, MinistrappolationBlocks.stone_boulder.getDefaultState(), 2);
                    }
                }
            }
            return true;
    }
}
