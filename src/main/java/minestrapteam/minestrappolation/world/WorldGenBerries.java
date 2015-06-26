package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.minestrappolation.block.BlockBush;
import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBerries extends WorldGenerator
{
    public boolean generate(World worldIn, Random rand, BlockPos pos)
    {
    	int bush = rand.nextInt(2);
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos1 = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos1) && worldIn.getBlockState(blockpos1.down()).getBlock() == Blocks.grass && MBlocks.blackberry_bush.canPlaceBlockAt(worldIn, pos))
            {
            	if(bush == 0)
            	{
            		worldIn.setBlockState(blockpos1, MBlocks.blueberry_bush.getDefaultState().withProperty(BlockBush.AGE, 5), 2);
            	}
            	if(bush == 1)
            	{
            		worldIn.setBlockState(blockpos1, MBlocks.blackberry_bush.getDefaultState().withProperty(BlockBush.AGE, 5), 2);
            	}
            	if(bush == 2)
            	{
            		worldIn.setBlockState(blockpos1, MBlocks.raspberry_bush.getDefaultState().withProperty(BlockBush.AGE, 5), 2);
            	}
                         
            }
        }

        return true;
    }
}