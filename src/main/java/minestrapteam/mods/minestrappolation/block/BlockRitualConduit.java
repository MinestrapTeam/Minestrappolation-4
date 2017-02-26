package minestrapteam.mods.minestrappolation.block;

import java.util.List;
import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemLead;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRitualConduit extends Block
{
	public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 3);
	public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    
    public int tickRate			 =	  1;

    public BlockRitualConduit(Material materialIn, int rate)
    {
        super(materialIn);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL,  Integer.valueOf(0)).withProperty(NORTH, Boolean.valueOf(false)).withProperty(EAST, Boolean.valueOf(false)).withProperty(SOUTH, Boolean.valueOf(false)).withProperty(WEST, Boolean.valueOf(false)));
        this.tickRate = rate;
    }
    
    @Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		this.updateTick(world, pos, state, world.rand);
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
    
    @Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }

    public boolean canConnectTo(IBlockAccess worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos).getBlock();
        if (block instanceof BlockRitualConduit)
        	return true;
        else
        	return false;
    }
    public int getMetaFromState(IBlockState state)
    {
    	return ((Integer)state.getValue(LEVEL)).intValue();
    }
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
    }
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return state.withProperty(NORTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.north()))).withProperty(EAST, Boolean.valueOf(this.canConnectTo(worldIn, pos.east()))).withProperty(SOUTH, Boolean.valueOf(this.canConnectTo(worldIn, pos.south()))).withProperty(WEST, Boolean.valueOf(this.canConnectTo(worldIn, pos.west())));
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {LEVEL, NORTH, EAST, WEST, SOUTH});
    }
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
        	ItemStack itemstack = playerIn.inventory.getCurrentItem();
        	
        	if (itemstack == null)
            {
                return true;
            }
            else
            {
            	int i = ((Integer)state.getValue(LEVEL)).intValue();
                Item item = itemstack.getItem();

                if (item == Items.ghast_tear)
                {
                    if (i < 3)
                    {
                        if (!playerIn.capabilities.isCreativeMode)
                        {
                        	--playerIn.getCurrentEquippedItem().stackSize;
                        }

                        worldIn.setBlockState(pos, state.withProperty(LEVEL, Integer.valueOf(MathHelper.clamp_int(i + 1, 0, 3))), 2);
                        worldIn.updateComparatorOutputLevel(pos, this);
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
    }
    
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World worldIn, BlockPos pos)
    {
        return ((Integer)worldIn.getBlockState(pos).getValue(LEVEL)).intValue();
    }
    
    public void attemptLiquidDispersal(World worldIn, BlockPos originalPos, BlockPos newPos, IBlockState state, Random rand)
    {
    	if(((Integer)worldIn.getBlockState(originalPos).getValue(LEVEL)).intValue() > ((Integer)worldIn.getBlockState(newPos).getValue(LEVEL)).intValue())
    	{
    		worldIn.setBlockState(newPos, MBlocks.ritual_conduit.getDefaultState().withProperty(LEVEL, ((Integer)worldIn.getBlockState(newPos).getValue(LEVEL)).intValue() + 1));
    		worldIn.setBlockState(originalPos, MBlocks.ritual_conduit.getDefaultState().withProperty(LEVEL, ((Integer)worldIn.getBlockState(originalPos).getValue(LEVEL)).intValue() - 1));
    	}
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	worldIn.scheduleUpdate(pos, this, 10 * tickRate);
    	int j = ((Integer)state.getValue(LEVEL)).intValue();
        int dir = rand.nextInt(4);
        if(dir == 0 && worldIn.getBlockState(pos.north()).getBlock() instanceof BlockRitualConduit)
        {
        	attemptLiquidDispersal(worldIn, pos, pos.north(), state, rand);
        }
        else if(dir == 1 && worldIn.getBlockState(pos.east()).getBlock() instanceof BlockRitualConduit)
        {
        	attemptLiquidDispersal(worldIn, pos, pos.east(), state, rand);
        }
        else if(dir == 2 && worldIn.getBlockState(pos.south()).getBlock() instanceof BlockRitualConduit)
        {
        	attemptLiquidDispersal(worldIn, pos, pos.south(), state, rand);
        }
        else if(dir == 3 && worldIn.getBlockState(pos.west()).getBlock() instanceof BlockRitualConduit)
        {
        	attemptLiquidDispersal(worldIn, pos, pos.west(), state, rand);
        }
    }
}
