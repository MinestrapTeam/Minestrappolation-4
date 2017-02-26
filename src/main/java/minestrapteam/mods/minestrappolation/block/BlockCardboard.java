package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCardboard extends MBlock
{
	public BlockCardboard(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn, mapColorIn);
	}

	@Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if(worldIn.getBlockState(fromPos).getBlock() == Blocks.WATER || worldIn.getBlockState(fromPos).getBlock() == Blocks.FLOWING_WATER)
		{
			worldIn.setBlockState(pos, MBlocks.wet_cardboard_block.getDefaultState());
		}
	}
	
	@Override
	public void fillWithRain(World worldIn, BlockPos pos)
	{
		if(worldIn.rand.nextInt(5) == 1)
		{
			worldIn.setBlockState(pos, MBlocks.wet_cardboard_block.getDefaultState());
		}
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return 1200;
	}
}
