package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHourglass extends Block
{
	public static final PropertyInteger FILL_LEVEL = PropertyInteger.create("level", 0, 217);
	public boolean isFilled;
	public boolean emitsPower;
	public boolean infiniteCycle;
	public MapColor mapColor;
	private int fillLevel;
	
	public BlockHourglass(Material materialIn, MapColor mapColorIn, Boolean isFilled, Boolean emitsPower, Boolean infiniteCycle)
	{
		super(materialIn);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FILL_LEVEL, 0));
		this.isFilled = isFilled;
		this.emitsPower = emitsPower;
		this.infiniteCycle = infiniteCycle;
		this.mapColor = mapColorIn;
		if(isFilled == false)
			this.fillLevel = 0;
		else
			this.fillLevel = 1;
		this.setTickRandomly(true);
	}
	
	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return this.mapColor;
	}
	
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
		this.setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
        return super.getCollisionBoundingBox(worldIn, pos, state);
    }
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
    {
		this.setBlockBounds(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
        return super.getSelectedBoundingBox(worldIn, pos);
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return true;
    }
    
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true);
    }
    
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
    	if (!this.canBlockStay(worldIn, pos, EnumFacing.DOWN))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }

        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
    }
    
    protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing)
    {
        return worldIn.isSideSolid(pos.offset(facing), facing.getOpposite(), true) || worldIn.getBlockState(pos.offset(EnumFacing.UP)) == MBlocks.rope.getDefaultState();
    }
    
    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if(this.isFilled != false && fillLevel < 217) 
        {
        	fillLevel ++;
        	worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, fillLevel));
        }
    }
    
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty(FILL_LEVEL, fillLevel);
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FILL_LEVEL});
    }
}
