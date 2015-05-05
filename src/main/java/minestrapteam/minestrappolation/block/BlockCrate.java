package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.tileentity.TileEntityCrate;
import minestrapteam.minestrappolation.util.MGuiHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockCrate extends BlockBarrel
{
	public BlockCrate()
	{
		
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) return true;

		playerIn.openGui(Minestrappolation.instance, MGuiHandler.GUIID_CRATE, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		return new TileEntityCrate();
	}
}