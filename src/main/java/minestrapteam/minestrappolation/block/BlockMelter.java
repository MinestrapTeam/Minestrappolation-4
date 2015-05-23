package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;
import minestrapteam.minestrappolation.util.MGuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMelter extends BlockContainer
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	private static boolean	keepInventory	= false;
	public  final  boolean  isBurning 		= false;
	
	public BlockMelter()
	{
		super(Material.rock);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.setDefaultFacing(worldIn, pos, state);
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityMelter();
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state)
	{
		TileEntity te = world.getTileEntity(pos);
		
		if (te instanceof IInventory)
		{
			IInventory inventory = (IInventory) te;
			for (int i1 = 0; i1 < inventory.getSizeInventory(); ++i1)
			{
				ItemStack itemstack = inventory.getStackInSlot(i1);
				
				if (itemstack != null)
				{
					float f = world.rand.nextFloat() * 0.8F + 0.1F;
					float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;
					
					for (float f2 = world.rand.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
					{
						int j1 = world.rand.nextInt(21) + 10;
						
						if (j1 > itemstack.stackSize)
						{
							j1 = itemstack.stackSize;
						}
						
						itemstack.stackSize -= j1;
						entityitem = new EntityItem(world, pos.getX() + f, pos.getY() + f1, pos.getZ() + f2, new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
						entityitem.motionX = world.rand.nextGaussian() * 0.05F;
						entityitem.motionY = world.rand.nextGaussian() * 0.05F + 0.2F;
						entityitem.motionZ = world.rand.nextGaussian() * 0.05F;
						
						if (itemstack.hasTagCompound())
						{
							entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}
					}
				}
			}
		}
		
		super.breakBlock(world, pos, state);
	}
	
	 private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
	    {
	        if (!worldIn.isRemote)
	        {
	            Block block = worldIn.getBlockState(pos.north()).getBlock();
	            Block block1 = worldIn.getBlockState(pos.south()).getBlock();
	            Block block2 = worldIn.getBlockState(pos.west()).getBlock();
	            Block block3 = worldIn.getBlockState(pos.east()).getBlock();
	            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

	            if (enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock())
	            {
	                enumfacing = EnumFacing.SOUTH;
	            }
	            else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock())
	            {
	                enumfacing = EnumFacing.NORTH;
	            }
	            else if (enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock())
	            {
	                enumfacing = EnumFacing.EAST;
	            }
	            else if (enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock())
	            {
	                enumfacing = EnumFacing.WEST;
	            }

	            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
	        }
	    }
	 
	   @SideOnly(Side.CLIENT)
	   @Override
	   public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	   {
	    if (this.isBurning)
        {	            
	    	EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
	        double d0 = (double)pos.getX() + 0.5D;
	        double d1 = (double)pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
	        double d2 = (double)pos.getZ() + 0.5D;
	        double d3 = 0.52D;
	        double d4 = rand.nextDouble() * 0.6D - 0.3D;

	        switch (BlockMelter.SwitchEnumFacing.FACING_LOOKUP[enumfacing.ordinal()])
	        {
	            case 1:
	                worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
	                worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
	                break;
	            case 2:
	                worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
	                worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
	                break;
                case 3:
                	worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
	                worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
	                break;
	            case 4:
	                worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
	                worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
	        }
	     }
	    }
	   
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
       return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.SOLID;
	}

	@Override
	public boolean isOpaqueCube() {
		return true;
	}

	@Override
	public boolean isFullCube() {
		return true;
	}
	
	@Override
	public int getRenderType()
    {
        return 3;
    }

	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) return true;

		playerIn.openGui(Minestrappolation.instance, MGuiHandler.GUIID_MELTER, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
	@Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
	@Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }
	
	@Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }
	
	@SideOnly(Side.CLIENT)

    static final class SwitchEnumFacing
        {
            static final int[] FACING_LOOKUP = new int[EnumFacing.values().length];
            private static final String __OBFID = "CL_00002111";

            static
            {
                try
                {
                    FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 1;
                }
                catch (NoSuchFieldError var4)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 2;
                }
                catch (NoSuchFieldError var3)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 3;
                }
                catch (NoSuchFieldError var2)
                {
                    ;
                }

                try
                {
                    FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 4;
                }
                catch (NoSuchFieldError var1)
                {
                    ;
                }
            }
        }
}