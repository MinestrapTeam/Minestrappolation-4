package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.util.Chance;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class BlockHangingMoss extends Block {

	public static final PropertyBool BOTTOM = PropertyBool.create("bottom");
	
	public BlockHangingMoss()
	{
		super(Material.vine);
		setDefaultState(blockState.getBaseState().withProperty(BOTTOM, Boolean.valueOf(false)));
		this.setTickRandomly(true);
	}

	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos.down()).getBlock();
        return state.withProperty(BOTTOM, Boolean.valueOf(block != this));
    }
	
	public int getMetaFromState(IBlockState state)
    {
        return 0;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {BOTTOM});
    }
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        if(worldIn.getBlockState(pos.up()).getBlock() == Blocks.stone || worldIn.getBlockState(pos.up()).getBlock() == MBlocks.biome_stones || worldIn.getBlockState(pos.up()).getBlock() == Blocks.dirt || worldIn.getBlockState(pos.up()).getBlock() == Blocks.mycelium || worldIn.getBlockState(pos.up()).getBlock() == Blocks.grass || worldIn.getBlockState(pos.up()).getBlock() == Blocks.leaves || worldIn.getBlockState(pos.up()).getBlock() == Blocks.leaves2 || worldIn.getBlockState(pos.up()).getBlock() == MBlocks.ministrapp_leaves || worldIn.getBlockState(pos.up()).getBlock() == this)
        {
        	int yCheck = pos.getY() - 1;
        	BlockPos pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
        	boolean outcome = false;
        	for(boolean isChecking = true ; isChecking == true ;)
        	{
        		if(worldIn.getBlockState(pos1).getBlock() == this)
        		{
        			yCheck --;
        			pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
        			isChecking = true;
        		}
        		else if(worldIn.getBlockState(pos1).getBlock() == Blocks.air)
        		{
        			outcome = true;
        			isChecking = false;
        		}
        		else
        		{
        			outcome = false;
        			isChecking = false;
        		}
        	}
        	return outcome;
        }
        else
        {
        	return false;
        }
    }
	
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
		this.checkForDrop(worldIn, pos, state);
    }

    protected final boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.canBlockStay(worldIn, pos))
        {
            return true;
        }
        else
        {
        	worldIn.setBlockState(pos, Blocks.air.getDefaultState());
        	this.dropBlockAsItem(worldIn, pos, state, 0);
            return false;
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return this.canPlaceBlockAt(worldIn, pos);
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	
        if (this.checkForDrop(worldIn, pos, state))
        {
            if (this.canBlockStay(worldIn, pos.down()))
            {
                int i;

                for (i = 1; worldIn.getBlockState(pos.up(i)).getBlock() == this; ++i)
                {
                    ;
                }

                if (i < 15)
                {
                    if (rand.nextInt(Config.seaweedGrowChance) == 0)
                    {
                        worldIn.setBlockState(pos.down(), this.getDefaultState());
                    }
                }
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
    }

}