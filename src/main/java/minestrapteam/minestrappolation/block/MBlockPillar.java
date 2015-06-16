package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public class MBlockPillar extends BlockRotatedPillar{

	private final MapColor	mapColor;
	
	public MBlockPillar(Material materialIn, MapColor mapColorIn) 
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
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
	{
		if (this == MBlocks.radiant_pillar)
			return true;
		else
			return false;
	}
}
