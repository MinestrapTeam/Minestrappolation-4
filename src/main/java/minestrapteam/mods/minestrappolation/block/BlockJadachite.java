package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.enumtypes.MBlockBiDirectional;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockJadachite extends MBlock
{
	public static final PropertyEnum	TYPE	= PropertyEnum.create("type", MBlockBiDirectional.class);
	
    private boolean	ignoreSimilarity;
    
	public BlockJadachite(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, MBlockBiDirectional.UD));
		this.ignoreSimilarity = true;
		this.setTickRandomly(true);
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        int dir = rand.nextInt(6);
        boolean checking = false;
        Block up = worldIn.getBlockState(pos.up()).getBlock();
        Block down = worldIn.getBlockState(pos.down()).getBlock();
        Block north = worldIn.getBlockState(pos.north()).getBlock();
        Block east = worldIn.getBlockState(pos.east()).getBlock();
        Block south = worldIn.getBlockState(pos.south()).getBlock();
        Block west = worldIn.getBlockState(pos.west()).getBlock();
        if(up == MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	checking = true;
        if(up != MBlocks.jadachite && (down == MBlocks.jadachite || down == Blocks.soul_sand) && north != MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	checking = true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north == MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	checking = true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east == MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	checking = true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east != MBlocks.jadachite && south == MBlocks.jadachite && west != MBlocks.jadachite)
        	checking = true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west == MBlocks.jadachite)
        	checking = true;
        
        if(checking == true)
        {
        	if(dir == 0)
        	{
        		if(up.isReplaceable(worldIn, pos.up()) && this.canPlaceBlockAt(worldIn, pos.up()))
        			worldIn.setBlockState(pos.up(), MBlocks.jadachite.getDefaultState());
        	}
        	else if(dir == 1)
        	{
        		if(down.isReplaceable(worldIn, pos.down()) && this.canPlaceBlockAt(worldIn, pos.down()))
        			worldIn.setBlockState(pos.down(), MBlocks.jadachite.getDefaultState());
        	}
        	else if(dir == 2)
        	{
        		if(north.isReplaceable(worldIn, pos.north()) && this.canPlaceBlockAt(worldIn, pos.north()))
        			worldIn.setBlockState(pos.north(), MBlocks.jadachite.getDefaultState());
        	}
        	else if(dir == 3)
        	{
        		if(east.isReplaceable(worldIn, pos.east()) && this.canPlaceBlockAt(worldIn, pos.east()))
        			worldIn.setBlockState(pos.east(), MBlocks.jadachite.getDefaultState());
        	}
        	else if(dir == 4)
        	{
        		if(south.isReplaceable(worldIn, pos.south()) && this.canPlaceBlockAt(worldIn, pos.south()))
        			worldIn.setBlockState(pos.south(), MBlocks.jadachite.getDefaultState());
        	}
        	else if(dir == 5)
        	{
        		if(west.isReplaceable(worldIn, pos.west()) && this.canPlaceBlockAt(worldIn, pos.west()))
        			worldIn.setBlockState(pos.west(), MBlocks.jadachite.getDefaultState());
        	}
        }
    }
	
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        Block up = worldIn.getBlockState(pos.up()).getBlock();
        Block down = worldIn.getBlockState(pos.down()).getBlock();
        Block north = worldIn.getBlockState(pos.north()).getBlock();
        Block east = worldIn.getBlockState(pos.east()).getBlock();
        Block south = worldIn.getBlockState(pos.south()).getBlock();
        Block west = worldIn.getBlockState(pos.west()).getBlock();
        
        if(up == MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && (down == MBlocks.jadachite || down == Blocks.soul_sand) && north != MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north == MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east == MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east != MBlocks.jadachite && south == MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west == MBlocks.jadachite)
        	return true;
        if(up == MBlocks.jadachite && (down == MBlocks.jadachite || down == Blocks.soul_sand) && north != MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up == MBlocks.jadachite && down != MBlocks.jadachite && north == MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up == MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east == MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up == MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east != MBlocks.jadachite && south == MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up == MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west == MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && (down == MBlocks.jadachite || down == Blocks.soul_sand) && north == MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && (down == MBlocks.jadachite || down == Blocks.soul_sand) && north != MBlocks.jadachite && east == MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && (down == MBlocks.jadachite || down == Blocks.soul_sand) && north != MBlocks.jadachite && east != MBlocks.jadachite && south == MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && (down == MBlocks.jadachite || down == Blocks.soul_sand) && north != MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west == MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north == MBlocks.jadachite && east == MBlocks.jadachite && south != MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north == MBlocks.jadachite && east != MBlocks.jadachite && south == MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north == MBlocks.jadachite && east != MBlocks.jadachite && south != MBlocks.jadachite && west == MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east == MBlocks.jadachite && south == MBlocks.jadachite && west != MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east == MBlocks.jadachite && south != MBlocks.jadachite && west == MBlocks.jadachite)
        	return true;
        if(up != MBlocks.jadachite && down != MBlocks.jadachite && north != MBlocks.jadachite && east != MBlocks.jadachite && south == MBlocks.jadachite && west == MBlocks.jadachite)
        	return true;
        return false;
    }
	
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        this.checkForDrop(worldIn, pos, state);
    }

    protected final boolean checkForDrop(World worldIn, BlockPos p_176353_2_, IBlockState state)
    {
        if (this.canBlockStay(worldIn, p_176353_2_))
        {
            return true;
        }
        else
        {
            this.dropBlockAsItem(worldIn, p_176353_2_, state, 0);
            worldIn.setBlockToAir(p_176353_2_);
            return false;
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return this.canPlaceBlockAt(worldIn, pos);
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
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return MItems.jadachite_shard;
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
    
    @Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(TYPE, MBlockBiDirectional.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((MBlockBiDirectional) state.getValue(TYPE)).getMetadata();
	}
    
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        if(this.canConnectTo(worldIn, pos.up()))
        {
        	if(this.canConnectTo(worldIn, pos.north()))
        		return state.withProperty(TYPE, MBlockBiDirectional.UN);
        	else if(this.canConnectTo(worldIn, pos.east()))
        		return state.withProperty(TYPE, MBlockBiDirectional.UE);
        	else if(this.canConnectTo(worldIn, pos.south()))
        		return state.withProperty(TYPE, MBlockBiDirectional.US);
        	else if(this.canConnectTo(worldIn, pos.west()))
        		return state.withProperty(TYPE, MBlockBiDirectional.UW);
        	else
        		return state.withProperty(TYPE, MBlockBiDirectional.UD);
        }
        else if(this.canConnectTo(worldIn, pos.down()))
        {
        	if(this.canConnectTo(worldIn, pos.north()))
        		return state.withProperty(TYPE, MBlockBiDirectional.DN);
        	else if(this.canConnectTo(worldIn, pos.east()))
        		return state.withProperty(TYPE, MBlockBiDirectional.DE);
        	else if(this.canConnectTo(worldIn, pos.south()))
        		return state.withProperty(TYPE, MBlockBiDirectional.DS);
        	else if(this.canConnectTo(worldIn, pos.west()))
        		return state.withProperty(TYPE, MBlockBiDirectional.DW);
        	else
        		return state.withProperty(TYPE, MBlockBiDirectional.UD);
        }
        else if(this.canConnectTo(worldIn, pos.north()))
        {
        	if(this.canConnectTo(worldIn, pos.east()))
        		return state.withProperty(TYPE, MBlockBiDirectional.NE);
        	else if(this.canConnectTo(worldIn, pos.west()))
        		return state.withProperty(TYPE, MBlockBiDirectional.NW);
        	else
        		return state.withProperty(TYPE, MBlockBiDirectional.NS);
        }
        else if(this.canConnectTo(worldIn, pos.east()))
        {
        	if(this.canConnectTo(worldIn, pos.south()))
        		return state.withProperty(TYPE, MBlockBiDirectional.ES);
        	else
        		return state.withProperty(TYPE, MBlockBiDirectional.EW);
        }
        else if(this.canConnectTo(worldIn, pos.south()))
        {
        	if(this.canConnectTo(worldIn, pos.west()))
        		return state.withProperty(TYPE, MBlockBiDirectional.SW);
        	else
        		return state.withProperty(TYPE, MBlockBiDirectional.NS);
        }
        else if(this.canConnectTo(worldIn, pos.west()))
        	return state.withProperty(TYPE, MBlockBiDirectional.EW);
        else
        	return state.withProperty(TYPE, MBlockBiDirectional.UD);
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {TYPE});
    }
}
