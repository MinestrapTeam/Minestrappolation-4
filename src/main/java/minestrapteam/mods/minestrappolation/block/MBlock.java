package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class MBlock extends Block
{
	private final MapColor	mapColor;
	
	public MBlock(Material materialIn, MapColor mapColorIn)
	{
		this(materialIn, mapColorIn, SoundType.GROUND);
	}
	
	public MBlock(Material materialIn, MapColor mapColorIn, SoundType sound)
	{
		super(materialIn);
		this.mapColor = mapColorIn;
		this.setSoundType(sound);
		if (this != MBlocks.block_flesh_reactive)
		{
			this.setCreativeTab(Minestrappolation.tabMBuilding);
		}
	}
	
	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return this.mapColor;
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
	{
		if (this == MBlocks.bronze_block || this == MBlocks.steel_block || this == MBlocks.meurodite_block || this == MBlocks.torite_block || this == MBlocks.titanium_block || this == MBlocks.blazium_block || this == MBlocks.soul_gem_block || this == MBlocks.radiant_block || this == MBlocks.radiant_chiseled)
			return true;
		else
			return false;
	}
	
	@Override
    public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity)
    {
        if (entity instanceof net.minecraft.entity.boss.EntityDragon && this == MBlocks.obsidian_bricks)
        {
            return false;
        }

        return true;
    }
}
