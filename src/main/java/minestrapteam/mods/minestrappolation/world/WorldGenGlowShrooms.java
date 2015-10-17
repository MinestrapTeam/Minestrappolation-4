package minestrapteam.mods.minestrappolation.world;

import java.util.Random;

import minestrapteam.mods.minestrappolation.block.BlockGlowShrooms;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGlowShrooms extends WorldGenerator
{

	@Override
	public boolean generate(World world, Random random, BlockPos pos) 
	{
		Block block;
		if(random.nextInt(2) == 1)
		{
			block = MBlocks.green_glowshroom;
		}
		else
		{
			block = MBlocks.purple_glowshroom;
		}
		
		int radius = 3;
		double radius1 = radius * radius;
		double radius2 = (radius - 1) * (radius - 1);
		int x1 = (int) Math.ceil(pos.getX() - radius);
		int z1 = (int) Math.ceil(pos.getZ() - radius);
		int x2 = (int) Math.ceil(pos.getX() + radius);
		int z2 = (int) Math.ceil(pos.getZ() + radius);
		
		for (int x = x1; x <= x2; x++)
		{
			for (int z = z1; z <= z2; z++)
			{
				double xfr = z - pos.getZ();
				double zfr = x - pos.getX();
				double d = xfr * xfr + zfr * zfr;
				
				if (d <= radius1)
				{
					if (d <= radius2 || random.nextInt(2) == 0)
					{
						if(world.isAirBlock(pos.add(xfr, 0, zfr)))
						{
							if(MBlocks.green_glowshroom.canPlaceBlockAt(world, pos))
							{
								world.setBlockState(pos.add(xfr, 0, zfr), block.getDefaultState(), 2);
							}	
						}
					}
				}
			}
		}
		return false;
	}

}
