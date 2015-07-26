package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.minestrappolation.block.BlockBush;
import minestrapteam.minestrappolation.block.BlockSeaweed;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWaterPlant extends WorldGenerator
{
	public Block plant;
	
	public WorldGenWaterPlant(Block plant)
	{
		this.plant = plant;
	}
	
   	public boolean generate(World worldIn, Random rand, BlockPos pos)
    {
        Block block;
/*
        do
        {
            block = worldIn.getBlockState(pos).getBlock();
            if (!block.isLeaves(worldIn, pos) && !block.isLeaves(worldIn, pos)) break;
            pos = pos.down();
        } while (pos.getY() > 0);
*/
        for (int i = 0; i < 40; ++i)
        {
            BlockPos blockpos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.getBlockState(blockpos1) == Blocks.water && ((BlockSeaweed) plant).canBlockStay(worldIn, blockpos1))
            {
                worldIn.setBlockState(blockpos1, plant.getDefaultState(), 2);
            }
        }

        return true;
    }
}
