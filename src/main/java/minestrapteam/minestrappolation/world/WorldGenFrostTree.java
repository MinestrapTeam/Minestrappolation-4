package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class WorldGenFrostTree extends WorldGenBaseTree
{
	
	protected int	leafStart	= 3;
	protected int	leafSpacing	= 1;
	
	public WorldGenFrostTree()
	{
		super(Blocks.log.getDefaultState(), Blocks.leaves.getDefaultState(), 5, 7, 1, MBlocks.lichen_permafrost, MBlocks.dirt_permafrost, Blocks.snow_layer);
	}
	
	@Override
	public boolean genLeafStructure(World world, Random rand, BlockPos pos)
	{
		world.setBlockState(pos.add(0, this.topHeight, 0), this.leaves, 2);
		
		double thickness = 2D;
		for (int r = this.leafStart; r < this.topHeight; r++)
		{
			if (r % this.leafSpacing == 0)
			{
				this.generateLeafCircles(world, rand, thickness, pos.add(0, r, 0));
			}
		}
		return true;
	}
	
	@Override
	public boolean genExtras(World world, Random rand, BlockPos pos)
	{
		return false;
	}
	
}
