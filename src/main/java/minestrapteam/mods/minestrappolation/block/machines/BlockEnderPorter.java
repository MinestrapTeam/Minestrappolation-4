package minestrapteam.mods.minestrappolation.block.machines;

import minestrapteam.mods.minestrappolation.block.BlockDirectional;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityEnderPorter;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockEnderPorter extends BlockDirectional
{

	
	public BlockEnderPorter() 
	{
		super(Material.rock);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntityEnderPorter();
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
		TileEntityEnderPorter te = (TileEntityEnderPorter) worldIn.getTileEntity(pos);
		te.setLinkPos(pos.getX(), pos.getY(), pos.getZ());
		te.getDescriptionPacket();
    }
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
			return true;
		
		if(playerIn.getHeldItem() != null && playerIn.getHeldItem().getItem() == MItems.wrench)
		{
			ItemStack stack = playerIn.getHeldItem();
			NBTTagCompound nbt = stack.getTagCompound();
			
			if(nbt.hasKey("x"))
			{
				TileEntityEnderPorter te = (TileEntityEnderPorter) worldIn.getTileEntity(pos);
				te.setLinkPos(nbt.getInteger("x"), nbt.getInteger("y"), nbt.getInteger("z"));
				te.getDescriptionPacket();
				
				TileEntityEnderPorter te2 = (TileEntityEnderPorter) worldIn.getTileEntity(new BlockPos(nbt.getInteger("x"), nbt.getInteger("y"), nbt.getInteger("z")));
				te2.setLinkPos(pos.getX(), pos.getY(), pos.getZ());
				te2.getDescriptionPacket();
			}
		}
		else
		{
			TileEntityEnderPorter te = (TileEntityEnderPorter) worldIn.getTileEntity(pos);
			
			playerIn.setPositionAndUpdate(te.x + .5, te.y + 1, te.z + .5);
		}
		
		
		return true;
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
	
	@Override
	public int getRenderType()
	{
		return 3;
	}

}
