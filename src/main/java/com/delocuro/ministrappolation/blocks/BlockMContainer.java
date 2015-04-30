package com.delocuro.ministrappolation.blocks;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.delocuro.ministrappolation.Minestrappolation;
import com.delocuro.ministrappolation.tile_entity.TileEntityCrate;

public class BlockMContainer extends BlockFalling implements ITileEntityProvider{

	private final MapColor mapColor;
	
	public BlockMContainer(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn);
		this.mapColor = mapColorIn;
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
			player.openGui(Minestrappolation.instance, 1, world, pos.getX(), pos.getY(), pos.getZ());
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
}
