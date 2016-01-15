package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockJadachite extends MBlock
{
	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
	
    private boolean	ignoreSimilarity;
    
	public BlockJadachite(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)).withProperty(UP, Boolean.valueOf(true)).withProperty(DOWN, Boolean.valueOf(true)));
		this.ignoreSimilarity = true;
	}

	public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.TRANSLUCENT;
	}
    
    @Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();
		
		if (this == MBlocks.jadachite)
		{
			if (worldIn.getBlockState(pos.offset(side.getOpposite())) != iblockstate)
				return true;
			
			if (block == this)
				return false;
		}
		
		return !this.ignoreSimilarity && block == this ? false : super.shouldSideBeRendered(worldIn, pos, side);
	}
    
    public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos).getBlock();
        if (block instanceof BlockJadachite)
        	return true;
        else
        	return false;
    }
    
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty(UP, Boolean.valueOf(this.canConnectTo(worldIn, pos.up()))).withProperty(DOWN, Boolean.valueOf(this.canConnectTo(worldIn, pos.down()))).withProperty(NORTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.north()))).withProperty(EAST, Boolean.valueOf(this.canConnectTo(worldIn, pos.east()))).withProperty(SOUTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.south()))).withProperty(WEST, Boolean.valueOf(this.canConnectTo(worldIn, pos.west())));
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {UP, DOWN, NORTH, EAST, WEST, SOUTH});
    }
}
