package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Iterator;
import java.util.Random;

public class BlockMoss extends BlockBush implements IGrowable
{
	private final MapColor mapColor;

	public BlockMoss(MapColor mapColor)
	{
		super(Material.snow);
		this.mapColor = mapColor;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
		this.setTickRandomly(true);
		this.setCreativeTab(Minestrappolation.tabMDecor);
		this.setBlockBoundsFromMeta(0);
	}

	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return this.mapColor;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (rand.nextInt(25) == 0)
		{
			int i = 12;
			boolean flag = true;
			Iterator iterator = BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4)).iterator();

			while (iterator.hasNext())
			{
				BlockPos blockpos1 = (BlockPos) iterator.next();

				if (worldIn.getBlockState(blockpos1).getBlock() == this)
				{
					--i;

					if (i <= 0)
					{
						return;
					}
				}
			}

			BlockPos blockpos2 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

			for (int j = 0; j < 4; ++j)
			{
				if (worldIn.isAirBlock(blockpos2) && this.canBlockStay(worldIn, blockpos2, this.getDefaultState()))
				{
					pos = blockpos2;
				}

				blockpos2 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
			}

			if (worldIn.isAirBlock(blockpos2) && this.canBlockStay(worldIn, blockpos2, this.getDefaultState()))
			{
				worldIn.setBlockState(blockpos2, this.getDefaultState(), 2);
			}
		}
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return super.canPlaceBlockAt(worldIn, pos) && this.canBlockStay(worldIn, pos, this.getDefaultState());
	}

	@Override
	protected boolean canPlaceBlockOn(Block ground)
	{
		return ground == Blocks.grass || ground == Blocks.dirt || ground == Blocks.farmland
			       || ground == Blocks.cobblestone || ground == Blocks.mossy_cobblestone || ground == Blocks.stonebrick
			       || ground == MBlocks.biome_cobble || ground == MBlocks.biome_bricks || ground == MBlocks.mossy
			       || ground == MBlocks.mossy_bricks || ground == MBlocks.cracked_bricks
			       || ground == MBlocks.pattern_bricks || ground == MBlocks.stone_pattern_bricks
			       || ground == MBlocks.chiseled || ground == MBlocks.dirt_permafrost
			       || ground == MBlocks.lichen_permafrost || ground == MBlocks.mud;
	}

	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
	{
		if (pos.getY() >= 0 && pos.getY() < 256)
		{
			IBlockState iblockstate1 = worldIn.getBlockState(pos.down());
			return iblockstate1.getBlock() == Blocks.mycelium || (iblockstate1.getBlock() == Blocks.dirt
				                                                      && iblockstate1.getValue(BlockDirt.VARIANT)
					                                                         == BlockDirt.DirtType.PODZOL
				                                                      || (iblockstate1.getBlock()
					                                                          == MBlocks.lichen_permafrost
					                                                          || (iblockstate1.getBlock()
						                                                              == MBlocks.dirt_permafrost
						                                                              || (iblockstate1.getBlock()
							                                                                  == MBlocks.mud ||
							                                                                  worldIn.getLight(pos) < 13
								                                                                  && iblockstate1
									                                                                     .getBlock()
									                                                                     .canSustainPlant(
										                                                                     worldIn,
										                                                                     pos.down(),
										                                                                     EnumFacing.UP,
										                                                                     this)))));
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	@Override
	public void setBlockBoundsForItemRender()
	{
		this.setBlockBoundsFromMeta(0);
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
	{
		this.setBlockBoundsFromMeta(0);
	}

	protected void setBlockBoundsFromMeta(int meta)
	{
		byte b0 = 0;
		float f = (float) (1 * (1 + b0)) / 16.0F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	{
		this.checkForDrop(worldIn, pos, state);
	}

	private boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
	{
		if (!this.canBlockStay(worldIn, pos, state))
		{
			this.dropBlockAsItem(worldIn, pos, state, 0);
			worldIn.setBlockToAir(pos);
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
	{
		return side == EnumFacing.UP || super.shouldSideBeRendered(worldIn, pos, side);
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		int i = 12;
		boolean flag = true;
		Iterator iterator = BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4)).iterator();

		while (iterator.hasNext())
		{
			BlockPos blockpos1 = (BlockPos) iterator.next();

			if (worldIn.getBlockState(blockpos1).getBlock() == this)
			{
				--i;

				if (i <= 0)
				{
					return;
				}
			}
		}

		BlockPos blockpos2 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

		for (int j = 0; j < 4; ++j)
		{
			if (worldIn.isAirBlock(blockpos2) && this.canBlockStay(worldIn, blockpos2, this.getDefaultState()))
			{
				pos = blockpos2;
			}

			blockpos2 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
		}

		if (worldIn.isAirBlock(blockpos2) && this.canBlockStay(worldIn, blockpos2, this.getDefaultState()))
		{
			worldIn.setBlockState(blockpos2, this.getDefaultState(), 2);
		}
	}
}
