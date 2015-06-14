package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Minestrappolation;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public class MBlockStairs extends BlockStairs
{
	private int flammability;
	
	public MBlockStairs(IBlockState modelState, int flame)
	{
		super(modelState);
		this.useNeighborBrightness = true;
		this.setCreativeTab(Minestrappolation.tabMBuilding);
		this.flammability = flame;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return this.flammability;
	}
	
}