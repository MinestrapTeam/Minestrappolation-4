package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
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
		BlockPos randPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
		
		if (world.getBlockState(randPos.up()).getBlock() == Blocks.water && world.getBlockState(randPos.down()).getBlock() != Blocks.water)
		{	
			for (int i = 0; i < 64; i++)
			{
				randPos = pos.add(rand.nextInt(8) - rand.nextInt(8), 0, rand.nextInt(8) - rand.nextInt(8));
				world.setBlockState(randPos, MBlocks.seaweed.getDefaultState(), 2);
			}
		}
		return true;
	}

}
