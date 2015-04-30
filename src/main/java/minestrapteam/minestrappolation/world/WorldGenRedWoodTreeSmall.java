package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class WorldGenRedWoodTreeSmall extends WorldGenBaseTree
{
	protected int	leafStart	= 5;
	protected int	leafSpacing	= 2;
	
	public WorldGenRedWoodTreeSmall()
	{
		super(MBlocks.ministrapp_log, MBlocks.ministrapp_leaves, 13, 18, 1);
	}
	
	@Override
	public boolean genLeafStructure(World world, Random rand, BlockPos pos)
	{
		world.setBlockState(pos.add(0, this.topHeight, 0), this.leaves.getDefaultState(), 2);
		
		double thickness = 4D;
		for (int r = this.leafStart; r < this.topHeight; r++)
		{
			if (r % this.leafSpacing == 0)
			{
				this.generateLeafCircles(world, rand, thickness, pos.add(0, r, 0));
				thickness -= 0.4D;
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
