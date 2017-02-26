package minestrapteam.mods.minestrappolation.block.machines;

import java.util.List;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.block.BlockDirectional;
import minestrapteam.mods.minestrappolation.handlers.MGuiHandler;
import minestrapteam.mods.minestrappolation.item.ItemWrench;
import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityCrusher;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityEnderPorter;
import minestrapteam.mods.minestrappolation.util.PlayerHelper;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockEnderPorter extends BlockDirectional
{

	
	public BlockEnderPorter() 
	{
		super(Material.rock);
		setBlockBounds();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntityEnderPorter();
	}
	
	private void setBlockBounds() 
	{
		float min = 0.01F;
		float max = 1 - min;
		setBlockBounds(min, min, min, max, max, max);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) 
    {
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
		if(!worldIn.isRemote)
		{
			TileEntityEnderPorter te = (TileEntityEnderPorter) worldIn.getTileEntity(pos);
			if(te.hasUpgradeChip(new ItemStack(MItems.upgradechip, 1, 1)))
			{
				if(!(entityIn instanceof EntityPlayer))
				{
					te.transportEnity(worldIn, entityIn, pos);
				}
				else
				{
					if(te.canActivate())
					{
						te.transportEnity(worldIn, entityIn, pos);
					}
				}
			}
		}
		
    }
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!worldIn.isRemote)
		{
			if(playerIn.getHeldItem() != null)
			{
					playerIn.openGui(Minestrappolation.instance, MGuiHandler.GUIID_ENDERPORTER, worldIn, pos.getX(), pos.getY(), pos.getZ());
			}
			else
			{
				TileEntityEnderPorter te = (TileEntityEnderPorter) worldIn.getTileEntity(pos);
				if(te.canActivate())
				{
					te.transportEnity(worldIn, playerIn, pos);
				}
			}
		}
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);
			
		if (tileentity instanceof TileEntityEnderPorter)
		{
			InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityEnderPorter) tileentity);
			worldIn.updateComparatorOutputLevel(pos, this);
		}
		
		super.breakBlock(worldIn, pos, state);
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

	public boolean hasComparatorInputOverride()
    {
        return true;
    }
	
	public int getComparatorInputOverride(World worldIn, BlockPos pos)
    {
        return Container.calcRedstone(worldIn.getTileEntity(pos));
    }
}

