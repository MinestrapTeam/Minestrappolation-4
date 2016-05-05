package minestrapteam.mods.minestrappolation.block;

import net.minecraft.block.BlockSnowBlock;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class MBlockSnow extends BlockSnowBlock
{
	private final MapColor mapColor;

	public MBlockSnow(Material materialIn, MapColor mapColorIn)
	{
		this.mapColor = mapColorIn;
	}

	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return this.mapColor;
	}
}
