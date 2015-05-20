package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPermaFrost extends BlockGrass{
	
	
	public BlockPermaFrost()
    {
        this.setDefaultState(this.blockState.getBaseState().withProperty(SNOWY, Boolean.valueOf(false)));
        this.setTickRandomly(true);
    }
	
	@SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state)
    {
        return this.getBlockColor();
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        return 10420217;
    }
	
	 public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	    {
	        if (!worldIn.isRemote)
	        {
	            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getBlock().getLightOpacity(worldIn, pos.up()) > 2)
	            {
	                worldIn.setBlockState(pos, Blocks.dirt.getDefaultState());
	            }
	            else
	            {
	                if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
	                {
	                    for (int i = 0; i < 4; ++i)
	                    {
	                        BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
	                        Block block = worldIn.getBlockState(blockpos1.up()).getBlock();
	                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);

	                        if (iblockstate1.getBlock() == Blocks.dirt && iblockstate1.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && worldIn.getLightFromNeighbors(blockpos1.up()) >= 4 && block.getLightOpacity(worldIn, blockpos1.up()) <= 2)
	                        {
	                            worldIn.setBlockState(blockpos1, MBlocks.lichen_permafrost.getDefaultState());
	                        }
	                    }
	                }
	            }
	        }
	    }

}
