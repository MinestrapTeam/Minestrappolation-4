package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHourglass extends MBlock
{
	public static final PropertyInteger FILL_LEVEL = PropertyInteger.create("level", 0, 15);
	public boolean isFilled 	 =    false;
	public boolean emitsPower;
	public boolean infiniteCycle = 	  false;
	public int tickRate			 =	  1;
	
	//Only used by continnium 
	boolean reverse = false;
	
	public BlockHourglass(Material materialIn, MapColor mapColorIn, boolean filled, boolean power, boolean cycle, int tickRate)
	{
		super(materialIn, mapColorIn);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FILL_LEVEL, 0));
		this.isFilled = filled;
		this.infiniteCycle = cycle;
		this.emitsPower = power;
		this.tickRate = tickRate;
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		if(this.isFilled == true)
			this.updateTick(world, pos, state, world.rand);
	}
	
	
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
		return new AxisAlignedBB(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
    }
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos)
    {
		return new AxisAlignedBB(0.1875F, 0.0F, 0.1875F, 0.8125F, 1.0F, 0.8125F);
    }
	
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }
    
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true);
    }
    
    //TODO Find the updated version of this.
    protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing)
    {
        return worldIn.isSideSolid(pos.offset(facing), facing.getOpposite(), true) || worldIn.getBlockState(pos.offset(EnumFacing.UP)) == MBlocks.rope.getDefaultState();
    }
    
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        super.breakBlock(worldIn, pos, state);
    }
    
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        super.onBlockHarvested(worldIn, pos, state, player);
    }    
    
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FILL_LEVEL, Integer.valueOf(meta));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(FILL_LEVEL)).intValue();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FILL_LEVEL});
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
    	System.out.println(((Integer)state.getValue(FILL_LEVEL)).intValue());
    	if(!worldIn.isRemote)
		{
    		if(this.isFilled == true)
        	{
    			worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, 15 - ((Integer)state.getValue(FILL_LEVEL)).intValue()), 2);
            	worldIn.notifyNeighborsOfStateChange(pos, this, true);
        	}
 
			return true;
		}
    	return false;
	}
    
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	worldIn.scheduleUpdate(pos, this, 20 * tickRate);
        int level = ((Integer)state.getValue(FILL_LEVEL)).intValue();
        isFilled = true;
        if(level < 15 && this.infiniteCycle == false)
        {
        	worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, Integer.valueOf(level + 1)), 2);
        	worldIn.notifyNeighborsOfStateChange(pos, this,true);
        }
        else if(this.infiniteCycle == true)
        {
        		
        	if(level < 15 && reverse == false)
        	{
        		worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, Integer.valueOf(level + 1)), 2);
            	worldIn.notifyNeighborsOfStateChange(pos, this,true);
        	}
        	else
        	{
        		reverse = true;
        	}
        		
        	if(reverse == true)
        	{
        		if(level == 0)
            	{
            		reverse = false;
            	}
        		else
        		{
        			worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, Integer.valueOf(level - 1)), 2);
                	worldIn.notifyNeighborsOfStateChange(pos, this,true);
        		}
        	}
        }
    }
    
    @Override
    public boolean hasComparatorInputOverride(IBlockState state)
    {
    	if(this.emitsPower == false)
    	{
    		return true;
    	}
        return false;
    }

    @Override
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return ((Integer)worldIn.getBlockState(pos).getValue(FILL_LEVEL)).intValue();
    }
    
    @Override
    public int getWeakPower(IBlockState state, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
    	if(this.emitsPower == true)
    	{
    		return ((Integer)state.getValue(FILL_LEVEL)).intValue();
    	}
    	else
    	{
    		return 0;
    	}
       
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
    	return BlockRenderLayer.CUTOUT;
    }
}
