package minestrapteam.minestrappolation.block;

import java.util.HashMap;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockFrostGenerator extends MBlock{
	
	public HashMap<Block, Block> canFreeze = new HashMap<Block, Block>();

	public BlockFrostGenerator(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn, mapColorIn);
		this.setTickRandomly(true);
		this.createFreezeMap();
	}
	
	public void createFreezeMap()
	{
		canFreeze.put(Blocks.water, Blocks.ice);
		canFreeze.put(Blocks.snow, Blocks.ice);
		canFreeze.put(Blocks.lava, Blocks.obsidian);
		canFreeze.put(Blocks.tallgrass, Blocks.air);
		canFreeze.put(Blocks.fire, Blocks.air);
		canFreeze.put(Blocks.sapling, Blocks.air);
		canFreeze.put(Blocks.cactus, Blocks.air);
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		this.updateTick(world, pos, state, world.rand);
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		world.scheduleUpdate(pos, this, 20);
		if(world.isBlockPowered(pos))
		{
			for(int x = -5; x < 5; x++)
			{
				for(int y = -5; y < 5; y++)
				{
					for(int z = -5; z < 5; z++)
					{
						if(canFreeze.containsKey(world.getBlockState(pos.add(x, y, z)).getBlock()))
						{
							int i = rand.nextInt(5);
							if(i < 1)
							{
								world.setBlockState(pos.add(x, y, z), canFreeze.get(world.getBlockState(pos.add(x, y, z)).getBlock()).getDefaultState(), 2);
							}
						}
					}
				}
			}
		}
	}
}
