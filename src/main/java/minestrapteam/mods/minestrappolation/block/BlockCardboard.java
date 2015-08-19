package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockCardboard extends MBlock
{
	public BlockCardboard(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn, mapColorIn);
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	{
		if(neighborBlock == Blocks.water || neighborBlock == Blocks.flowing_water)
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
}
