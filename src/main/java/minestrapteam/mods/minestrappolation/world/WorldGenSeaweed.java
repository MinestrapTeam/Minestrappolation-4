package minestrapteam.mods.minestrappolation.world;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSeaweed extends WorldGenerator
{

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) 
	{		
		if (world.getBlockState(pos.up()).getBlock() == Blocks.water && world.getBlockState(pos.down()).getBlock() != Blocks.water)
		{	
			for (int i = 0; i < 64; i++)
			{
				BlockPos randPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
				if(MBlocks.seaweed.canPlaceBlockAt(world, randPos))
				{
					world.setBlockState(randPos, MBlocks.seaweed.getDefaultState(), 2);
				}
			}
		}
		return true;
	}

}
