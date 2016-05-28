package minestrapteam.mods.minestrappolation.world;

import minestrapteam.mods.minestrappolation.block.BlockBush;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenIceMound extends WorldGenerator
{

	@Override
	public boolean generate(World world, Random random, BlockPos pos)
	{
		if (world.getBlockState(pos.add(1, -1, 1)) == MBlocks.lichen_permafrost.getDefaultState()
			    && world.getBlockState(pos.add(-1, -1, -1)) == MBlocks.lichen_permafrost.getDefaultState())
		{
			int radius = random.nextInt(8) + 1;
			for (int a = 0; a < radius + 1; a++)
			{
				this.buildShell(world, pos.add(0, a, 0), radius);
				this.buildShell(world, pos.add(0, -a, 0), radius);
				radius--;
			}
			world.setBlockState(pos.add(0, radius + 2, 0),
			                    MBlocks.glacieric_ice_vein.getDefaultState().withProperty(BlockBush.AGE, 5), 2);
			world.setBlockState(pos.add(0, radius + 1, 0), MBlocks.glaical_invincium.getDefaultState(), 2);
			return true;
		}
		return false;
	}

	//Uses a modified generate generateLeafCircles(); from WorldGenBaseTree
	private void buildShell(World world, BlockPos pos, double radius)
	{
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
					world.setBlockState(pos.add(xfr, 0, zfr), MBlocks.glaical_invincium.getDefaultState(), 2);
				}
			}
		}
	}
}
