package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockHourglass extends MBlock
{
	public static final PropertyInteger FILL_LEVEL = PropertyInteger.create("level", 0, 15);
	public              boolean         isFilled   = false;
	public boolean emitsPower;
	public boolean infiniteCycle = false;
	public int     tickRate      = 1;

	//Only used by continnium 
	boolean reverse = false;

	public BlockHourglass(Material materialIn, MapColor mapColorIn, boolean filled, boolean power, boolean cycle, int tickRate)
	{
		super(materialIn, mapColorIn);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FILL_LEVEL, 0));
		this.isFilled = filled;
		this.infiniteCycle = cycle;
		this.emitsPower = power;
		this.tickRate = tickRate;
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		if (this.isFilled)
			this.updateTick(world, pos, state, world.rand);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		this.setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
		return super.getCollisionBoundingBox(worldIn, pos, state);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
	{
		this.setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
		return super.getSelectedBoundingBox(worldIn, pos);
	}

	@Override
	public int getRenderType()
	{
		return 3;
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
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
	{
		return true;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true);
	}

	protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing)
	{
		return worldIn.isSideSolid(pos.offset(facing), facing.getOpposite(), true)
			       || worldIn.getBlockState(pos.offset(EnumFacing.UP)) == MBlocks.rope.getDefaultState();
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		super.onBlockHarvested(worldIn, pos, state, player);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FILL_LEVEL, meta);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(FILL_LEVEL);
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, FILL_LEVEL);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		System.out.println(state.getValue(FILL_LEVEL).intValue());
		if (!worldIn.isRemote)
		{
			if (this.isFilled)
			{
				worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, 15 - state.getValue(FILL_LEVEL)), 2);
				worldIn.notifyNeighborsOfStateChange(pos, this);
			}

			return true;
		}
		return false;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		worldIn.scheduleUpdate(pos, this, 20 * this.tickRate);
		int level = state.getValue(FILL_LEVEL);
		this.isFilled = true;
		if (level < 15 && !this.infiniteCycle)
		{
			worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, level + 1), 2);
			worldIn.notifyNeighborsOfStateChange(pos, this);
		}
		else if (this.infiniteCycle)
		{
			if (level < 15 && !this.reverse)
			{
				worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, level + 1), 2);
				worldIn.notifyNeighborsOfStateChange(pos, this);
			}
			else
			{
				this.reverse = true;
			}

			if (this.reverse)
			{
				if (level == 0)
				{
					this.reverse = false;
				}
				else
				{
					worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, level - 1), 2);
					worldIn.notifyNeighborsOfStateChange(pos, this);
				}
			}
		}
	}

	@Override
	public boolean hasComparatorInputOverride()
	{
		return !this.emitsPower;
	}

	@Override
	public int getComparatorInputOverride(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos).getValue(FILL_LEVEL);
	}

	@Override
	public int getWeakPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
	{
		return this.emitsPower ? state.getValue(FILL_LEVEL) : 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}
}
