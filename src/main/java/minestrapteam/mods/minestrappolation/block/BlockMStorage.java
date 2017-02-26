package minestrapteam.mods.minestrappolation.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockMStorage extends Block
{
	
	private final MapColor	mapColor;
	
	public BlockMStorage(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn);
		this.mapColor = mapColorIn;
	}
	
	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return this.mapColor;
	}
}
