package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Minestrappolation;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class MBlock extends Block
{
	private final MapColor	mapColor;
	
	public MBlock(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn);
		this.mapColor = mapColorIn;
		this.setCreativeTab(Minestrappolation.tabMBuilding);
	}
	
	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return this.mapColor;
	}
}
