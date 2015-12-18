package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockHourglass extends MBlock
{
	public static final PropertyInteger FILL_LEVEL = PropertyInteger.create("level", 0, 16);
	public boolean isFilled 	 =    false;
	public boolean emitsPower;
	public boolean infiniteCycle = 	  false;
	
	public BlockHourglass(Material materialIn, MapColor mapColorIn, boolean power, boolean cycle)
	{
		super(materialIn, mapColorIn);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FILL_LEVEL, 0));
		this.infiniteCycle = cycle;
		this.emitsPower = power;
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		this.updateTick(world, pos, state, world.rand);
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
	
	public int getRenderType()
    {
        return 3;
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

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FILL_LEVEL});
    }
    
    @Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
    	System.out.println(state.getValue(FILL_LEVEL));
    	if(!worldIn.isRemote)
		{
    		if(this.isFilled == true)
        	{
        		worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, 15 - ((Integer)state.getValue(FILL_LEVEL)).intValue()), 2);
        		worldIn.notifyNeighborsOfStateChange(pos, this);
        	}
 
			return true;
		}
    	return false;
	}
    
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	worldIn.scheduleUpdate(pos, this, 20);
        
    	int fillChance = rand.nextInt(1);
        if(fillChance == 0)
        {
        	int level = ((Integer)state.getValue(FILL_LEVEL)).intValue();
        	isFilled = true;
        	if(level < 15)
        	{
        		worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, Integer.valueOf(level + 1)), 2);
        		worldIn.notifyNeighborsOfStateChange(pos, this);
        	}
        	else if(this.infiniteCycle == true)
        	{
        		worldIn.setBlockState(pos, state.withProperty(FILL_LEVEL, Integer.valueOf(0)), 2);
        		worldIn.notifyNeighborsOfStateChange(pos, this);
        	}
        }
    }
    
    @Override
    public boolean hasComparatorInputOverride()
    {
    	if(this.emitsPower == false)
    	{
    		return true;
    	}
        return false;
    }

    @Override
    public int getComparatorInputOverride(World worldIn, BlockPos pos)
    {
        return ((Integer)worldIn.getBlockState(pos).getValue(FILL_LEVEL)).intValue();
    }
    
    @Override
    public int isProvidingWeakPower(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
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
    public EnumWorldBlockLayer getBlockLayer()
    {
    	return EnumWorldBlockLayer.CUTOUT;
    }
}
