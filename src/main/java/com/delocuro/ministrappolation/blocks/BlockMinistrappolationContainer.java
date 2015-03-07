package com.delocuro.ministrappolation.blocks;

import java.util.Iterator;
import java.util.Random;

import com.delocuro.ministrappolation.Ministrappolation;
import com.delocuro.ministrappolation.Reference;
import com.delocuro.ministrappolation.tile_entity.TileEntityCrate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;

public class BlockMinistrappolationContainer extends BlockFalling implements ITileEntityProvider{

	public BlockMinistrappolationContainer()
	{
		super(Material.wood);
	}
	
	@Override
	protected void onStartFalling(EntityFallingBlock entity)
	{
		BlockPos pos = new BlockPos((int) entity.posX, (int) entity.posY, (int) entity.posZ);
		TileEntity te = entity.worldObj.getTileEntity(pos);
		if (te != null)
		{
			NBTTagCompound nbt = new NBTTagCompound();
			te.writeToNBT(nbt);
			entity.tileEntityData = nbt;
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
					for(float f2 = world.rand.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
					{
						int j1 = world.rand.nextInt(21) + 10;
						if(j1 > itemstack.stackSize)
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
			world.updateComparatorOutputLevel(pos, state.getBlock());
		}
		
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			player.openGui(Reference.MOD_ID, 1, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public boolean onBlockEventReceived(World world, BlockPos pos, IBlockState state, int id, int data)
	{
		super.onBlockEventReceived(world, pos, state, id, data);
		TileEntity te = world.getTileEntity(pos);
		return te != null ? te.receiveClientEvent(id, data) : false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityCrate();
	}
	
	/*private final Random rand = new Random();
	
	protected BlockMinistrappolationContainer(int chest) 
	{
		super(chest);
	}
	
	 public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	    {
	        EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3).getOpposite();
	        state = state.withProperty(FACING, enumfacing);
	        BlockPos blockpos1 = pos.north();
	        BlockPos blockpos2 = pos.south();
	        BlockPos blockpos3 = pos.west();
	        BlockPos blockpos4 = pos.east();
	        boolean flag = this == worldIn.getBlockState(blockpos1).getBlock();
	        boolean flag1 = this == worldIn.getBlockState(blockpos2).getBlock();
	        boolean flag2 = this == worldIn.getBlockState(blockpos3).getBlock();
	        boolean flag3 = this == worldIn.getBlockState(blockpos4).getBlock();

	        if (!flag && !flag1 && !flag2 && !flag3)
	        {
	            worldIn.setBlockState(pos, state, 3);
	        }
	        else if (enumfacing.getAxis() == EnumFacing.Axis.X && (flag || flag1))
	        {
	            if (flag)
	            {
	                worldIn.setBlockState(blockpos1, state, 3);
	            }
	            else
	            {
	                worldIn.setBlockState(blockpos2, state, 3);
	            }

	            worldIn.setBlockState(pos, state, 3);
	        }
	        else if (enumfacing.getAxis() == EnumFacing.Axis.Z && (flag2 || flag3))
	        {
	            if (flag2)
	            {
	                worldIn.setBlockState(blockpos3, state, 3);
	            }
	            else
	            {
	                worldIn.setBlockState(blockpos4, state, 3);
	            }

	            worldIn.setBlockState(pos, state, 3);
	        }

	        if (stack.hasDisplayName())
	        {
	            TileEntity tileentity = worldIn.getTileEntity(pos);

	            if (tileentity instanceof TileEntityCrate)
	            {
	                ((TileEntityCrate)tileentity).setCustomName(stack.getDisplayName());
	            }
	        }
	    }
	 
	 /*public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	    {
	        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
	        TileEntity tileentity = worldIn.getTileEntity(pos);

	        if (tileentity instanceof TileEntityCrate)
	        {
	            tileentity.updateContainingBlockInfo();
	        }
	    }
	 
	 public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	    {
	        TileEntity tileentity = worldIn.getTileEntity(pos);

	        if (tileentity instanceof IInventory)
	        {
	            InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
	            worldIn.updateComparatorOutputLevel(pos, this);
	        }

	        super.breakBlock(worldIn, pos, state);
	    }
	 
	 public ILockableContainer getLockableContainer(World worldIn, BlockPos pos)
	    {
	        TileEntity tileentity = worldIn.getTileEntity(pos);

	        if (!(tileentity instanceof TileEntityCrate))
	        {
	            return null;
	        }
	        else
	        {
	            Object object = (TileEntityCrate)tileentity;

	            if (this.isBlocked(worldIn, pos))
	            {
	                return null;
	            }
	            else
	            {
	                Iterator iterator = EnumFacing.Plane.HORIZONTAL.iterator();

	                while (iterator.hasNext())
	                {
	                    EnumFacing enumfacing = (EnumFacing)iterator.next();
	                    BlockPos blockpos1 = pos.offset(enumfacing);
	                    Block block = worldIn.getBlockState(blockpos1).getBlock();

	                    if (block == this)
	                    {
	                        if (this.isBlocked(worldIn, blockpos1))
	                        {
	                            return null;
	                        }

	                        TileEntity tileentity1 = worldIn.getTileEntity(blockpos1);

	                        /*if (tileentity1 instanceof TileEntityCrate)
	                        {
	                            if (enumfacing != EnumFacing.WEST && enumfacing != EnumFacing.NORTH)
	                            {
	                                object = new InventoryLargeChest("container.chestDouble", (ILockableContainer)object, (TileEntityCrate)tileentity1);
	                            }
	                            else
	                            {
	                                object = new InventoryLargeChest("container.chestDouble", (TileEntityCrate)tileentity1, (ILockableContainer)object);
	                            }
	                        }
	                    }
	                }

	                return (ILockableContainer)object;
	            }
	        }
	    }
	 
	 private boolean isBlocked(World worldIn, BlockPos pos)
	    {
	     	return false;   
	     	//return this.isBelowSolidBlock(worldIn, pos) || this.isOcelotSittingOnChest(worldIn, pos);
	    }

	    private boolean isBelowSolidBlock(World worldIn, BlockPos pos)
	    {
	        return worldIn.isSideSolid(pos.up(), EnumFacing.DOWN, false);
	    }

	    private boolean isOcelotSittingOnChest(World worldIn, BlockPos pos)
	    {
	        Iterator iterator = worldIn.getEntitiesWithinAABB(EntityOcelot.class, new AxisAlignedBB((double)pos.getX(), (double)(pos.getY() + 1), (double)pos.getZ(), (double)(pos.getX() + 1), (double)(pos.getY() + 2), (double)(pos.getZ() + 1))).iterator();
	        EntityOcelot entityocelot;

	        do
	        {
	            if (!iterator.hasNext())
	            {
	                return false;
	            }

	            Entity entity = (Entity)iterator.next();
	            entityocelot = (EntityOcelot)entity;
	        }
	        while (!entityocelot.isSitting());

	        return true;
	    }
	    
	    public TileEntity createNewTileEntity(World worldIn, int meta)
	    {
	        return new TileEntityCrate();
	    }
	    
	    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
	    {
	        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	    }*/
}
