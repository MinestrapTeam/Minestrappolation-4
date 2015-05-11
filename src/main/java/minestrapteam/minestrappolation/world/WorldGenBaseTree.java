package minestrapteam.minestrappolation.world;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class WorldGenBaseTree extends WorldGenAbstractTree
{
	protected IBlockState	wood;
	protected IBlockState	leaves;
	
	public int		minHeight;
	public int		maxHeight;
	public int		width;
	
	public int		topHeight;
	
	public Block[]  canGrowOn;
	
	public WorldGenBaseTree(IBlockState wood, IBlockState leaves, int minHeight, int maxHeight, int width,Block...blocks)
	{
		super(true);
		this.wood = wood;
		this.leaves = leaves;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.width = width;
		this.canGrowOn = blocks;
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos)
	{
		if (!this.canSpawn(world, pos))
			return false;
		
		// Calculates the random height of the tree
		this.topHeight = rand.nextInt(this.maxHeight - this.minHeight + 1) + this.minHeight;
		
		if (!world.isAirBlock(pos.add(0, this.topHeight, 0)))
			return false;
		
		this.genLeafStructure(world, rand, pos);
		this.createTrunk(world, rand, pos);
		this.genExtras(world, rand, pos);
		return true;
	}
	
	public abstract boolean genLeafStructure(World world, Random rand, BlockPos pos);
	
	public abstract boolean genExtras(World world, Random rand, BlockPos pos);
	
	public boolean canSpawn(World world, BlockPos pos)
	{
		IBlockState ground = world.getBlockState(pos.add(0, -1, 0));
		Block groundBlock = Blocks.grass;
		
		for(int b = 0; b < this.canGrowOn.length; b++)
		{
			if(ground.getBlock() == this.canGrowOn[b])
			{
				groundBlock = ground.getBlock();
				continue;
			}
		}	
			
		return ground.getBlock() == groundBlock;
	}
	
	public void createTrunk(World world, Random rand, BlockPos pos)
	{
		for (int h = 0; h < this.topHeight; h++)
		{
			if (this.width == 1)
			{
				world.setBlockState(pos.add(0, h, 0), this.wood, 2);
			}
			else if (this.width == 2)
			{
				world.setBlockState(pos.add(0, h, 0), this.wood, 2);
				world.setBlockState(pos.add(0, h, 1), this.wood, 2);
				world.setBlockState(pos.add(1, h, 1), this.wood, 2);
				world.setBlockState(pos.add(1, h, 0), this.wood, 2);
			}
			else
			{
				for (int i = 0; i < this.width; i++)
				{
					for (int j = 0; j < this.width; j++)
					{
						world.setBlockState(pos.add(i, h, j), this.wood, 2);
					}
				}
			}
		}
	}
	
	public void generateLeafCircles(World world, Random random, double radius, BlockPos pos)
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
					if (d <= radius2 || random.nextInt(2) == 0)
					{
						world.setBlockState(pos.add(xfr, 0, zfr), this.leaves, 2);
					}
				}
			}
		}
	}
}