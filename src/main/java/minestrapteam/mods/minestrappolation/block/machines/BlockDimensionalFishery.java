package minestrapteam.mods.minestrappolation.block.machines;

import minestrapteam.mods.minestrappolation.block.BlockRitualConduit;
import minestrapteam.mods.minestrappolation.block.MBlock;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockDimensionalFishery extends MBlock
{
	public static final PropertyBool ACTIVE = PropertyBool.create("active");

	public BlockDimensionalFishery(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.setDefaultState(this.blockState.getBaseState().withProperty(ACTIVE, Boolean.valueOf(false)));
		this.setTickRandomly(true);
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	{
		if (worldIn.getBlockState(pos.up()) == MBlocks.compacted_dirt.getDefaultState()
			    && worldIn.getBlockState(pos) == MBlocks.dimensional_fishery.getDefaultState()
			                                                                .withProperty(ACTIVE, true))
		{
			worldIn.setBlockState(pos.up(), MBlocks.decaying_compacted_dirt.getDefaultState());
		}
		else if (worldIn.getBlockState(pos.up()) == MBlocks.compacted_netherrack.getDefaultState()
			         && worldIn.getBlockState(pos) == MBlocks.dimensional_fishery.getDefaultState()
			                                                                     .withProperty(ACTIVE, true))
		{
			worldIn.setBlockState(pos.up(), MBlocks.decaying_compacted_netherrack.getDefaultState());
		}
		else if (worldIn.getBlockState(pos.up()) == MBlocks.compacted_endstone.getDefaultState()
			         && worldIn.getBlockState(pos) == MBlocks.dimensional_fishery.getDefaultState()
			                                                                     .withProperty(ACTIVE, true))
		{
			worldIn.setBlockState(pos.up(), MBlocks.decaying_compacted_endstone.getDefaultState());
		}
		else if (worldIn.getBlockState(pos.up()) == MBlocks.compacted_glowshrooms.getDefaultState()
			         && worldIn.getBlockState(pos) == MBlocks.dimensional_fishery.getDefaultState()
			                                                                     .withProperty(ACTIVE, true))
		{
			worldIn.setBlockState(pos.up(), MBlocks.decaying_compacted_glowshrooms.getDefaultState());
		}
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		if (this.checkBase(worldIn, pos, state) == true && state.getValue(ACTIVE) == false)
		{
			worldIn.setBlockState(pos, MBlocks.dimensional_fishery.getDefaultState().withProperty(ACTIVE, true));
		}
		else if (this.checkBase(worldIn, pos, state) == false && state.getValue(ACTIVE) == true)
		{
			worldIn.setBlockState(pos, MBlocks.dimensional_fishery.getDefaultState().withProperty(ACTIVE, false));
		}
	}

	public boolean checkBase(World world, BlockPos pos, IBlockState state)
	{
		BlockPos posDown = pos.down();
		BlockPos posUp = pos.up();
		return world.getBlockState(posDown.north().north().north().west()) == MBlocks.obsidian_bricks.getDefaultState()
			       && world.getBlockState(posDown.north().north().north()) == MBlocks.obsidian_bricks.getDefaultState()
			       && world.getBlockState(posDown.north().north().north().east()) == MBlocks.obsidian_bricks
				                                                                         .getDefaultState()

			       && world.getBlockState(posDown.north().north().west().west()) == MBlocks.ritual_conduit
				                                                                        .getDefaultState().withProperty(
				BlockRitualConduit.LEVEL, 3)
			       && world.getBlockState(posDown.north().north().west()) == MBlocks.ritual_conduit.getDefaultState()
			                                                                                       .withProperty(
				                                                                                       BlockRitualConduit.LEVEL,
				                                                                                       3)
			       && world.getBlockState(posDown.north().north()) == MBlocks.ritual_conduit.getDefaultState()
			                                                                                .withProperty(
				                                                                                BlockRitualConduit.LEVEL,
				                                                                                3)
			       && world.getBlockState(posDown.north().north().east()) == MBlocks.ritual_conduit.getDefaultState()
			                                                                                       .withProperty(
				                                                                                       BlockRitualConduit.LEVEL,
				                                                                                       3)
			       && world.getBlockState(posDown.north().north().east().east()) == MBlocks.ritual_conduit
				                                                                        .getDefaultState().withProperty(
				BlockRitualConduit.LEVEL, 3)

			       && world.getBlockState(posDown.north().west().west().west()) == MBlocks.obsidian_bricks
				                                                                       .getDefaultState()
			       && world.getBlockState(posDown.north().west().west()) == MBlocks.ritual_conduit.getDefaultState()
			                                                                                      .withProperty(
				                                                                                      BlockRitualConduit.LEVEL,
				                                                                                      3)
			       && world.getBlockState(posDown.north().west()) == Blocks.prismarine.getDefaultState()
			       && world.getBlockState(posDown.north()) == MBlocks.ritual_conduit.getDefaultState().withProperty(
			BlockRitualConduit.LEVEL, 3) && world.getBlockState(posDown.north().east()) == Blocks.prismarine
				                                                                               .getDefaultState()
			       && world.getBlockState(posDown.north().east().east()) == MBlocks.ritual_conduit.getDefaultState()
			                                                                                      .withProperty(
				                                                                                      BlockRitualConduit.LEVEL,
				                                                                                      3)
			       && world.getBlockState(posDown.north().east().east().east()) == MBlocks.obsidian_bricks
				                                                                       .getDefaultState()

			       && world.getBlockState(posDown.west().west().west()) == MBlocks.obsidian_bricks.getDefaultState()
			       && world.getBlockState(posDown.west().west()) == MBlocks.ritual_conduit.getDefaultState()
			                                                                              .withProperty(
				                                                                              BlockRitualConduit.LEVEL,
				                                                                              3)
			       && world.getBlockState(posDown.west()) == MBlocks.ritual_conduit.getDefaultState().withProperty(
			BlockRitualConduit.LEVEL, 3) && world.getBlockState(posDown) == Blocks.beacon.getDefaultState()
			       && world.getBlockState(posDown.east()) == MBlocks.ritual_conduit.getDefaultState().withProperty(
			BlockRitualConduit.LEVEL, 3) && world.getBlockState(posDown.east().east()) == MBlocks.ritual_conduit
				                                                                              .getDefaultState()
				                                                                              .withProperty(
					                                                                              BlockRitualConduit.LEVEL,
					                                                                              3)
			       && world.getBlockState(posDown.east().east().east()) == MBlocks.obsidian_bricks.getDefaultState()

			       && world.getBlockState(posDown.south().west().west().west()) == MBlocks.obsidian_bricks
				                                                                       .getDefaultState()
			       && world.getBlockState(posDown.south().west().west()) == MBlocks.ritual_conduit.getDefaultState()
			                                                                                      .withProperty(
				                                                                                      BlockRitualConduit.LEVEL,
				                                                                                      3)
			       && world.getBlockState(posDown.south().west()) == Blocks.prismarine.getDefaultState()
			       && world.getBlockState(posDown.south()) == MBlocks.ritual_conduit.getDefaultState().withProperty(
			BlockRitualConduit.LEVEL, 3) && world.getBlockState(posDown.south().east()) == Blocks.prismarine
				                                                                               .getDefaultState()
			       && world.getBlockState(posDown.south().east().east()) == MBlocks.ritual_conduit.getDefaultState()
			                                                                                      .withProperty(
				                                                                                      BlockRitualConduit.LEVEL,
				                                                                                      3)
			       && world.getBlockState(posDown.south().east().east().east()) == MBlocks.obsidian_bricks
				                                                                       .getDefaultState()

			       && world.getBlockState(posDown.south().south().west().west()) == MBlocks.ritual_conduit
				                                                                        .getDefaultState().withProperty(
				BlockRitualConduit.LEVEL, 3)
			       && world.getBlockState(posDown.south().south().west()) == MBlocks.ritual_conduit.getDefaultState()
			                                                                                       .withProperty(
				                                                                                       BlockRitualConduit.LEVEL,
				                                                                                       3)
			       && world.getBlockState(posDown.south().south()) == MBlocks.ritual_conduit.getDefaultState()
			                                                                                .withProperty(
				                                                                                BlockRitualConduit.LEVEL,
				                                                                                3)
			       && world.getBlockState(posDown.south().south().east()) == MBlocks.ritual_conduit.getDefaultState()
			                                                                                       .withProperty(
				                                                                                       BlockRitualConduit.LEVEL,
				                                                                                       3)
			       && world.getBlockState(posDown.south().south().east().east()) == MBlocks.ritual_conduit
				                                                                        .getDefaultState().withProperty(
				BlockRitualConduit.LEVEL, 3)

			       && world.getBlockState(posDown.south().south().south().west()) == MBlocks.obsidian_bricks
				                                                                         .getDefaultState()
			       && world.getBlockState(posDown.south().south().south()) == MBlocks.obsidian_bricks.getDefaultState()
			       && world.getBlockState(posDown.south().south().south().east()) == MBlocks.obsidian_bricks
				                                                                         .getDefaultState()

			       && world.getBlockState(pos.north().north().west().west()) == MBlocks.radiant_chiseled
				                                                                    .getDefaultState()
			       && world.getBlockState(pos.north().north().east().east()) == MBlocks.radiant_chiseled
				                                                                    .getDefaultState()
			       && world.getBlockState(pos.south().south().west().west()) == MBlocks.radiant_chiseled
				                                                                    .getDefaultState()
			       && world.getBlockState(pos.south().south().east().east()) == MBlocks.radiant_chiseled
				                                                                    .getDefaultState()

			       && world.getBlockState(posUp.north().north().west().west()) == MBlocks.unholy_candle
				                                                                      .getDefaultState()
			       && world.getBlockState(posUp.north().north().east().east()) == MBlocks.unholy_candle
				                                                                      .getDefaultState()
			       && world.getBlockState(posUp.south().south().west().west()) == MBlocks.unholy_candle
				                                                                      .getDefaultState()
			       && world.getBlockState(posUp.south().south().east().east()) == MBlocks.unholy_candle
				                                                                      .getDefaultState();
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
	public IBlockState getStateFromMeta(int meta)
	{
		if (meta == 0)
			return this.getDefaultState().withProperty(ACTIVE, false);
		else
			return this.getDefaultState().withProperty(ACTIVE, true);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		if (state.getValue(ACTIVE).booleanValue() == false)
			return 0;
		else
			return 1;
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, ACTIVE);
	}
}
