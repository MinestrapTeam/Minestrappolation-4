package minestrapteam.mods.minestrappolation.block.machines;

import java.util.List;

import com.google.common.base.Predicate;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.block.MBlock;
import minestrapteam.mods.minestrappolation.handlers.MGuiHandler;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityPipe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPipe extends BlockContainer
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate<EnumFacing>()
	{
		public boolean apply(EnumFacing p_apply_1_)
        {
            return true;
        }
	});
	
	public BlockPipe(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.DOWN));
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	}
	
	/*public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }*/
	
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity)
    {
		int dir = ((EnumFacing)worldIn.getBlockState(pos).getValue(FACING)).getIndex();
		if(dir == 0)
		{
			this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.75F, 0.75F);
        	super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
		}
		else if(dir == 1)
		{
			this.setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 1.0F, 0.75F);
        	super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
		}
		else if(dir == 2)
		{
			this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.75F);
            super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
		}
		else if(dir == 3)
		{
			this.setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 1.0F);
            super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
		}
		else if(dir == 4)
		{
			this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
		}
		else
		{
			this.setBlockBounds(0.25F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
			super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
		}
    }
	
	public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
		int dir = ((EnumFacing)worldIn.getBlockState(pos).getValue(FACING)).getIndex();
		if(dir == 0)
		{
			this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.75F, 0.75F);

		}
		else if(dir == 1)
		{
			this.setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 1.0F, 0.75F);
		}
		else if(dir == 2)
		{
			this.setBlockBounds(0.25F, 0.25F, 0.0F, 0.75F, 0.75F, 0.75F);
		}
		else if(dir == 3)
		{
			this.setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 1.0F);
		}
		else if(dir == 4)
		{
			this.setBlockBounds(0.0F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
		}
		else
		{
			this.setBlockBounds(0.25F, 0.25F, 0.25F, 1.0F, 0.75F, 0.75F);
		}
    }
	
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        EnumFacing enumfacing = facing.getOpposite();

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }
	
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);

        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            /*if (tileentity instanceof TileEntityPipe)
            {
                ((TileEntityPipe)tileentity).setCustomName(stack.getDisplayName());
            }*/
        }
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
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
			return true;
		
		playerIn.openGui(Minestrappolation.instance, MGuiHandler.GUIID_PIPE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override
	public boolean onBlockEventReceived(World world, BlockPos pos, IBlockState state, int eventID, int eventParam)
	{
		super.onBlockEventReceived(world, pos, state, eventID, eventParam);
		TileEntity te = world.getTileEntity(pos);
		return te != null ? te.receiveClientEvent(eventID, eventParam) : false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityPipe();
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean isFullCube()
    {
        return false;
    }
	
	public int getRenderType()
    {
        return 3;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}
	
	public static EnumFacing getFacing(int meta)
    {
        return EnumFacing.getFront(meta & 7);
    }
	
	public boolean hasComparatorInputOverride()
    {
        return true;
    }
	
	public int getComparatorInputOverride(World worldIn, BlockPos pos)
    {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }
	
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING, getFacing(meta));
    }
	
	public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | ((EnumFacing)state.getValue(FACING)).getIndex();

        return i;
    }
	
	protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }
}