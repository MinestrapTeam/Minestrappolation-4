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
			if(te.getUpgrade() != null && te.getUpgrade().isItemEqual(new ItemStack(MItems.upgradechip, 1, 1)))
			{
				if(!(entityIn instanceof EntityPlayer))
				{
					entityIn.setPositionAndUpdate(te.getChipPos().getX() + .5, te.getChipPos().getY() + hasInversionUpgrade(worldIn, pos), te.getChipPos().getZ() + .5);
				}
				else
				{
					if(te.canActivate())
					{
						entityIn.setPositionAndUpdate(te.getChipPos().getX() + .5, te.getChipPos().getY() + hasInversionUpgrade(worldIn, pos), te.getChipPos().getZ() + .5);
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
					playerIn.setPositionAndUpdate(te.getChipPos().getX() + .5, te.getChipPos().getY() + hasInversionUpgrade(worldIn, pos), te.getChipPos().getZ() + .5);
				}
			}
		}
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);
			
		if (tileentity instanceof TileEntityCrusher)
		{
			InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityEnderPorter) tileentity);
			worldIn.updateComparatorOutputLevel(pos, this);
		}
		
		super.breakBlock(worldIn, pos, state);
	}
	
	private int hasInversionUpgrade(World world, BlockPos pos)
	{
		TileEntityEnderPorter te = (TileEntityEnderPorter) world.getTileEntity(pos);
		TileEntityEnderPorter te2 = (TileEntityEnderPorter) world.getTileEntity(new BlockPos(te.getChipPos().getX(), te.getChipPos().getY(), te.getChipPos().getZ()));
		
		if(te2.getUpgrade() != null && te2.getUpgrade().getIsItemStackEqual(new ItemStack(MItems.upgradechip, 1, 2)))
		{
			return -1;
		}
		return 1;
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

