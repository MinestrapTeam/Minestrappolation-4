package minestrapteam.minestrappolation.util;

import minestrapteam.minestrappolation.inventory.ContainerBarrel;
import minestrapteam.minestrappolation.inventory.ContainerCrate;
import minestrapteam.minestrappolation.inventory.GuiBarrel;
import minestrapteam.minestrappolation.inventory.GuiCrate;
import minestrapteam.minestrappolation.tileentity.TileEntityBarrel;
import minestrapteam.minestrappolation.tileentity.TileEntityCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class MGuiHandler implements IGuiHandler {
	public static final int GUIID_BARREL = 1;
	public static final int GUIID_CRATE = 2;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		BlockPos xyz = new BlockPos(x, y, z);
		
		TileEntity tileEntity = world.getTileEntity(xyz);
		
		//Barrel
		if (tileEntity instanceof TileEntityBarrel) {
			TileEntityBarrel tileEntityBarrel = (TileEntityBarrel) tileEntity;
			return new ContainerBarrel(player, tileEntityBarrel);
		}
		
		//Crate
		if (tileEntity instanceof TileEntityCrate) {
			TileEntityCrate tileEntityCrate = (TileEntityCrate) tileEntity;
			return new ContainerCrate(player, tileEntityCrate);
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		BlockPos xyz = new BlockPos(x, y, z);
		
		TileEntity tileEntity = world.getTileEntity(xyz);
		
		//Barrel
		if (tileEntity instanceof TileEntityBarrel) {
			TileEntityBarrel tileEntityBarrel = (TileEntityBarrel) tileEntity;
			return new GuiBarrel(player, tileEntityBarrel);
		}
		
		//Crate
		if (tileEntity instanceof TileEntityCrate) {
			TileEntityCrate tileEntityCrate = (TileEntityCrate) tileEntity;
			return new GuiCrate(player, tileEntityCrate);
		}
		
		return null;
	}
}
