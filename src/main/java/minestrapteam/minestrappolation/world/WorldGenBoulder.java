package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBoulder extends WorldGenerator
{
	public int boulderChance;
	public Block boulderBlock;
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		BlockPos randPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
		BlockPos down = randPos.offset(EnumFacing.DOWN);
		
		if (worldIn.isAirBlock(randPos) && (worldIn.getBlockState(down).getBlock() == Blocks.grass || worldIn.getBlockState(down).getBlock() == Blocks.stone))
		{
			boulderChance = rand.nextInt(5);
			if (boulderChance == 1)
				boulderBlock = MBlocks.coldstone_boulder;
			else if (boulderChance == 2)
				boulderBlock = MBlocks.red_rock_boulder;
			else if (boulderChance == 3)
				boulderBlock = MBlocks.icestone_boulder;
			else if (boulderChance == 4)
				boulderBlock = MBlocks.oceanstone_boulder;
			else
				boulderBlock = MBlocks.stone_boulder;
				
			worldIn.setBlockState(randPos, boulderBlock.getDefaultState(), 2);
			
			for (int i = 0; i < 64; i++)
			{
				randPos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
				
				if (worldIn.isAirBlock(randPos) && (worldIn.getBlockState(down).getBlock() == Blocks.grass || worldIn.getBlockState(down).getBlock() == Blocks.stone || worldIn.getBlockState(down).getBlock() == MBlocks.lichen_permafrost))
				{
					worldIn.setBlockState(randPos, boulderBlock.getDefaultState(), 2);
				}
			}
		}
		return true;
	}
}
