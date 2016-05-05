package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MBlockPillar extends BlockRotatedPillar
{

	private final MapColor mapColor;

	public MBlockPillar(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn);
		this.mapColor = mapColorIn;
		this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS, EnumFacing.Axis.Y));
		this.setCreativeTab(Minestrappolation.tabMBuilding);
	}

	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return this.mapColor;
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
	{
		return this == MBlocks.radiant_pillar;
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		EnumFacing.Axis axis = EnumFacing.Axis.Y;
		int j = meta & 12;

		if (j == 4)
		{
			axis = EnumFacing.Axis.X;
		}
		else if (j == 8)
		{
			axis = EnumFacing.Axis.Z;
		}

		return this.getDefaultState().withProperty(AXIS, axis);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		EnumFacing.Axis axis = state.getValue(AXIS);

		if (axis == EnumFacing.Axis.X)
		{
			i |= 4;
		}
		else if (axis == EnumFacing.Axis.Z)
		{
			i |= 8;
		}

		return i;
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, AXIS);
	}

	@Override
	protected ItemStack createStackedBlock(IBlockState state)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, 0);
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer)
		            .withProperty(AXIS, facing.getAxis());
	}
}
