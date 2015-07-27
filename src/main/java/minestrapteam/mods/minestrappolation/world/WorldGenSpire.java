package minestrapteam.mods.minestrappolation.world;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSpire extends WorldGenerator
{
	private Block	block;
	private Block	spawnOn;
	
	public WorldGenSpire(Block block, Block canSpawnOn)
	{
		this.block = block;
		this.spawnOn = canSpawnOn;
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		if (world.getBlockState(pos).getBlock() != this.spawnOn)
		{
			return false;
		}
		
		int depth = rand.nextInt(6) + 3;
		for (int i = 0; i < depth; i++)
		{
			world.setBlockState(pos.add(0, -i, 0), this.block.getDefaultState(), 2);
			world.setBlockState(pos.add(1, -i, 0), this.block.getDefaultState(), 2);
			world.setBlockState(pos.add(-1, -i, 0), this.block.getDefaultState(), 2);
			world.setBlockState(pos.add(0, -i, 1), this.block.getDefaultState(), 2);
			world.setBlockState(pos.add(0, -i, -1), this.block.getDefaultState(), 2);
		}
		
		int height = rand.nextInt(4) + 2;
		for (int i = 0; i < height; i++)
		{
			world.setBlockState(pos.add(0, i, 0), MBlocks.desert_quartz.getDefaultState(), 2);
		}
		return true;
	}
}
