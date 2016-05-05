package minestrapteam.mods.minestrappolation.block.crops;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCorn extends BlockCrops
{

	public BlockCorn()
	{
		super();
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.updateTick(worldIn, pos, state, rand);

		if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
		{
			int i = state.getValue(AGE).intValue();
			int height;
			for (height = 1; worldIn.getBlockState(pos.down(height)).getBlock() == this; ++height)
			{

			}

			if (height < 3)
			{
				if (i < 7)
				{
					float f = getGrowthChance(this, worldIn, pos);

					if (rand.nextInt((int) (25.0F / f) + 1) == 0)
					{
						worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(i + 1)), 2);
					}
				}
				else
				{
					if (worldIn.getBlockState(pos.up()).getBlock() == this)
					{

					}
					else
					{
						worldIn.setBlockState(pos.up(), state.withProperty(AGE, Integer.valueOf(0)), 2);
					}
				}
			}
		}
	}

	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
	{
		return (worldIn.getLight(pos) >= 8 || worldIn.canSeeSky(pos)) && worldIn.getBlockState(pos.down()).getBlock()
		                                                                        .canSustainPlant(worldIn, pos.down(),
		                                                                                         net.minecraft.util.EnumFacing.UP,
		                                                                                         this)
			       || worldIn.getBlockState(pos.down()).getBlock() == this;
	}

	@Override
	protected Item getSeed()
	{
		return MBlocks.corn;
	}

	@Override
	protected Item getCrop()
	{
		return MBlocks.corn;
	}
}
