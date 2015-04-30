package com.delocuro.ministrappolation.world;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.delocuro.ministrappolation.init.MBlocks;

public class WorldGenRedWoodTree extends WorldGenBaseTree
{
	protected int	leafStart	= 5;
	protected int	leafSpacing	= 2;
	
	public WorldGenRedWoodTree()
	{
		super(MBlocks.ministrapp_log, MBlocks.ministrapp_leaves, 17, 23, 2);
	}
	
	@Override
	public boolean genLeafStructure(World world, Random rand, BlockPos pos)
	{
		world.setBlockState(pos.add(0, this.topHeight, 0), this.leaves.getDefaultState(), 2);
		world.setBlockState(pos.add(0, this.topHeight, 1), this.leaves.getDefaultState(), 2);
		world.setBlockState(pos.add(1, this.topHeight, 1), this.leaves.getDefaultState(), 2);
		world.setBlockState(pos.add(1, this.topHeight, 0), this.leaves.getDefaultState(), 2);
		
		double thinkness = 6.5D;
		for (int r = this.leafStart; r < this.topHeight; r++)
		{
			if (r % this.leafSpacing == 0)
			{
				this.generateLeafCircles(world, rand, thinkness, pos.add(0, r, 0));
				thinkness -= 0.4D;
			}
		}
		return true;
	}
	
	@Override
	public boolean genExtras(World world, Random rand, BlockPos pos)
	{
		for (int r = this.leafStart; r < this.topHeight; r++)
		{
			if (r % this.leafSpacing == 0)
			{
				int chance = rand.nextInt(2);
				if (chance == 1)
				{
					int minL = 2;
					
					int c1 = rand.nextInt(2);
					int c2 = rand.nextInt(2);
					int c3 = rand.nextInt(2);
					int c4 = rand.nextInt(2);
					
					if (c1 == 1)
					{
						for (int l = 0; l < rand.nextInt(2) + minL; l++)
						{
							world.setBlockState(pos.add(l, r, 0), this.wood.getDefaultState(), 2);
						}
						
					}
					
					if (c2 == 1)
					{
						for (int l = 0; l < rand.nextInt(2) + minL; l++)
						{
							world.setBlockState(pos.add(-l, r, 0), this.wood.getDefaultState(), 2);
						}
					}
					
					if (c3 == 1)
					{
						for (int l = 0; l < rand.nextInt(2) + minL; l++)
						{
							world.setBlockState(pos.add(0, r, -l), this.wood.getDefaultState(), 2);
						}
						
					}
					
					if (c4 == 1)
					{
						for (int l = 0; l < rand.nextInt(2) + minL; l++)
						{
							world.setBlockState(pos.add(0, r, l), this.wood.getDefaultState(), 2);
						}
					}
					
				}
			}
		}
		return true;
	}
}