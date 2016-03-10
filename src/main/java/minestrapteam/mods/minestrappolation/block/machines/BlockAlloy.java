package minestrapteam.mods.minestrappolation.block.machines;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.block.BlockDirectional;
import minestrapteam.mods.minestrappolation.handlers.MGuiHandler;
import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityAlloy;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAlloy extends BlockDirectional
{
	private static boolean					keepInventory	= false;
	public final boolean					isBurning		= false;
	public boolean							isActive		= false;
	
	public BlockAlloy(boolean active)
	{
		super(Material.rock);
		this.isActive = active;
		if (active)
		{
			this.setLightLevel(1F);
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(MBlocks.alloy);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityAlloy();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		if (!keepInventory)
		{
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if (tileentity instanceof TileEntityAlloy)
			{
				InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityAlloy) tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}
		}
		
		super.breakBlock(worldIn, pos, state);
	}
	
	public static void setState(boolean active, World worldIn, BlockPos pos)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		keepInventory = true;
		
		if (active)
		{
			worldIn.setBlockState(pos, MBlocks.alloy_active.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
			worldIn.setBlockState(pos, MBlocks.alloy_active.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
		}
		else
		{
			worldIn.setBlockState(pos, MBlocks.alloy.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
			worldIn.setBlockState(pos, MBlocks.alloy.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
		}
		
		keepInventory = false;
		
		if (tileentity != null)
		{
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity);
		}
	}
	
	@SuppressWarnings("incomplete-switch")
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (this.isActive)
		{
			EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
			double d0 = pos.getX() + 0.5D;
			double d1 = pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
			double d2 = pos.getZ() + 0.5D;
			double d3 = 0.52D;
			double d4 = rand.nextDouble() * 0.6D - 0.3D;
			
			switch (enumfacing)
			{
			case WEST:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
				break;
			case EAST:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
				break;
			case NORTH:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
				break;
			case SOUTH:
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.SOLID;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return true;
	}
	
	@Override
	public boolean isFullCube()
	{
		return true;
	}
	
	@Override
	public int getRenderType()
	{
		return 3;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
			return true;
		
		playerIn.openGui(Minestrappolation.instance, MGuiHandler.GUIID_ALLOY, worldIn, pos.getX(), pos.getY(), pos.getZ());
		playerIn.addStat(MAchievements.alloy, 1);
		return true;
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(MBlocks.alloy);
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