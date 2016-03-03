package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockJadachiteRoot extends MBlock
{

	public BlockJadachiteRoot(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.setTickRandomly(true);
	}

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
		if(worldIn.isAirBlock(pos.up()))
		{
			worldIn.setBlockState(pos.up(), MBlocks.jadachite.getDefaultState());
		}
    }
	
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
		Block soil = MBlocks.virtian_grass;
		
		if(		worldIn.getBlockState(pos.down().north().west()) == soil.getDefaultState() &&
				worldIn.getBlockState(pos.down().north()) == soil.getDefaultState() &&
				worldIn.getBlockState(pos.down().north().east()) == soil.getDefaultState() &&
				worldIn.getBlockState(pos.down().west()) == soil.getDefaultState() &&
				worldIn.getBlockState(pos.down()) == soil.getDefaultState() &&
				worldIn.getBlockState(pos.down().east()) == soil.getDefaultState() &&
				worldIn.getBlockState(pos.down().south().west()) == soil.getDefaultState() &&
				worldIn.getBlockState(pos.down().south()) == soil.getDefaultState() &&
				worldIn.getBlockState(pos.down().south().east()) == soil.getDefaultState() &&
				worldIn.isAirBlock(pos.north().west()) &&
				worldIn.isAirBlock(pos.north()) &&
				worldIn.isAirBlock(pos.north().east()) &&
				worldIn.isAirBlock(pos.west()) &&
				worldIn.isAirBlock(pos.east()) &&
				worldIn.isAirBlock(pos.south().west()) &&
				worldIn.isAirBlock(pos.south()) &&
				worldIn.isAirBlock(pos.south().east()))
			return true;
		else
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
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.TRANSLUCENT;
	}
    
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if(worldIn.getBlockState(pos.up()).getBlock() == MBlocks.jadachite)
        	worldIn.destroyBlock(pos.up(), true);
    }
}
