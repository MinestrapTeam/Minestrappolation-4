package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockSeaweed extends Block
{

	public BlockSeaweed()
	{
		super(Material.water);
		this.setDefaultState(this.blockState.getBaseState().withProperty(BlockLiquid.LEVEL, 15));
		this.setTickRandomly(true);
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, BlockLiquid.LEVEL);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return 0;
	}

	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state)
	{
		worldIn.setBlockState(pos, Blocks.water.getDefaultState());
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		return null;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		if (worldIn.getBlockState(pos.down()).getBlock() == Blocks.clay
			    || worldIn.getBlockState(pos.down()).getBlock() == Blocks.dirt
			    || worldIn.getBlockState(pos.down()).getBlock() == Blocks.sand
			    || worldIn.getBlockState(pos.down()).getBlock() == Blocks.gravel
			    || worldIn.getBlockState(pos.down()).getBlock() == MBlocks.seaweed)
		{
			int yCheck = pos.getY() + 1;
			BlockPos pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
			boolean outcome = false;
			for (boolean isChecking = true; isChecking == true; )
			{
				if (worldIn.getBlockState(pos1).getBlock() == MBlocks.seaweed)
				{
					yCheck++;
					pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
					isChecking = true;
				}
				else if (worldIn.getBlockState(pos1).getBlock() == Blocks.water)
				{
					outcome = true;
					isChecking = false;
				}
				else
				{
					outcome = false;
					isChecking = false;
				}
			}
			return outcome;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	{
		this.checkForDrop(worldIn, pos, state);
	}

	protected final boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
	{
		if (this.canBlockStay(worldIn, pos))
		{
			return true;
		}
		else
		{
			worldIn.setBlockState(pos, Blocks.water.getDefaultState());
			this.dropBlockAsItem(worldIn, pos, state, 0);
			return false;
		}
	}

	public boolean canBlockStay(World worldIn, BlockPos pos)
	{
		return this.canPlaceBlockAt(worldIn, pos);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{

		if (this.checkForDrop(worldIn, pos, state))
		{
			if (this.canBlockStay(worldIn, pos.up()))
			{
				int i;

				for (i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i)
				{
				}

				if (i < 15)
				{
					if (rand.nextInt(Config.seaweedGrowChance) == 0)
					{
						worldIn.setBlockState(pos.up(), this.getDefaultState());
					}
				}
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Block.EnumOffsetType getOffsetType()
	{
		return Block.EnumOffsetType.XYZ;
	}
}
