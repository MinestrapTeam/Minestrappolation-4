package minestrapteam.mods.minestrappolation.block.machines;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.block.BlockDirectional;
import minestrapteam.mods.minestrappolation.handlers.MGuiHandler;
import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityCrusher;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCrusher extends BlockDirectional
{
	
	private static boolean					keepInventory	= false;
	public final boolean					isBurning		= false;
	public boolean							isActive		= false;
	
	public BlockCrusher(boolean active)
	{
		super(Material.rock);
		this.isActive = active;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityCrusher();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		if (!keepInventory)
		{
			TileEntity tileentity = worldIn.getTileEntity(pos);
			
			if (tileentity instanceof TileEntityCrusher)
			{
				InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityCrusher) tileentity);
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
			worldIn.setBlockState(pos, MBlocks.crusher_active.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
			worldIn.setBlockState(pos, MBlocks.crusher_active.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
		}
		else
		{
			worldIn.setBlockState(pos, MBlocks.crusher.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
			worldIn.setBlockState(pos, MBlocks.crusher.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
		}
		
		keepInventory = false;
		
		if (tileentity != null)
		{
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity);
		}
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
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
			return true;
		
		playerIn.openGui(Minestrappolation.instance, MGuiHandler.GUIID_ALLOY, worldIn, pos.getX(), pos.getY(), pos.getZ());
		MAchievements.addAchievement(playerIn, MAchievements.crusher);
		return true;
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(MBlocks.crusher);
    }
}