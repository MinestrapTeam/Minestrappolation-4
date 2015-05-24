package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Minestrappolation;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;

public class MBlockStairs extends BlockStairs
{
	
	public MBlockStairs(IBlockState modelState)
	{
		super(modelState);
		this.useNeighborBrightness = true;
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
	}
	
}