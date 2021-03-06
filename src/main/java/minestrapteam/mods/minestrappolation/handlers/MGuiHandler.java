package minestrapteam.mods.minestrappolation.handlers;

import minestrapteam.mods.minestrappolation.inventory.InventoryBackpack;
import minestrapteam.mods.minestrappolation.inventory.container.*;
import minestrapteam.mods.minestrappolation.inventory.gui.*;
import minestrapteam.mods.minestrappolation.tileentity.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class MGuiHandler implements IGuiHandler
{
	public static final int GUIID_BARREL      = 1;
	public static final int GUIID_CRATE       = 2;
	public static final int GUIID_MELTER      = 3;
	public static final int GUIID_ALLOY       = 4;
	public static final int GUIID_STONECUTTER = 5;
	public static final int GUIID_SAWMILL     = 6;
	public static final int GUIID_CRUSHER     = 6;
	public static final int GUIID_SPLITTER    = 7;
	public static final int GUIID_BACKPACK    = 8;
	public static final int GUIID_SATCHEL     = 9;
	public static final int GUIID_ENDERPORTER = 10;
	public static final int GUIID_PIPE        = 11;
	public static final int GUIID_SORTER      = 12;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{

		BlockPos xyz = new BlockPos(x, y, z);

		TileEntity tileEntity = world.getTileEntity(xyz);

		// Barrel
		if (tileEntity instanceof TileEntityBarrel)
		{
			TileEntityBarrel tileEntityBarrel = (TileEntityBarrel) tileEntity;
			return new ContainerBarrel(player, tileEntityBarrel);
		}

		// Crate
		if (tileEntity instanceof TileEntityCrate)
		{
			TileEntityCrate tileEntityCrate = (TileEntityCrate) tileEntity;
			return new ContainerCrate(player, tileEntityCrate);
		}

		// Crate
		if (tileEntity instanceof TileEntityMelter)
		{
			TileEntityMelter tileEntityMelter = (TileEntityMelter) tileEntity;
			return new ContainerMelter(player, tileEntityMelter);
		}

		// Alloy
		if (tileEntity instanceof TileEntityAlloy)
		{
			TileEntityAlloy tileEntityAlloy = (TileEntityAlloy) tileEntity;
			return new ContainerAlloy(player, tileEntityAlloy);
		}

		// StoneCutter
		if (tileEntity instanceof TileEntityStoneCutter)
		{
			TileEntityStoneCutter tileEntityStoneCutter = (TileEntityStoneCutter) tileEntity;
			return new ContainerStoneCutter(player, tileEntityStoneCutter);
		}

		// Sawmill
		if (tileEntity instanceof TileEntitySawMill)
		{
			TileEntitySawMill tileEntitySawMill = (TileEntitySawMill) tileEntity;
			return new ContainerSawmill(player, tileEntitySawMill);
		}

		// Crusher
		if (tileEntity instanceof TileEntityCrusher)
		{
			TileEntityCrusher tileEntityCrusher = (TileEntityCrusher) tileEntity;
			return new ContainerCrusher(player, tileEntityCrusher);
		}

		// Splitter
		if (tileEntity instanceof TileEntitySplitter)
		{
			TileEntitySplitter tileEntityCrusher = (TileEntitySplitter) tileEntity;
			return new ContainerSplitter(player, tileEntityCrusher);
		}

		// EnderPorter
		if (tileEntity instanceof TileEntityEnderPorter)
		{
			TileEntityEnderPorter tileEntityEnderPorter = (TileEntityEnderPorter) tileEntity;
			return new ContainerEnderPorter(player, tileEntityEnderPorter);
		}

		// Item Pipe
		if (tileEntity instanceof TileEntityPipe)
		{
			TileEntityPipe tileEntityPipe = (TileEntityPipe) tileEntity;
			return new ContainerPipe(player, tileEntityPipe);
		}

		// Item Sorter
		if (tileEntity instanceof TileEntitySorter)
		{
			TileEntitySorter tileEntitySorter = (TileEntitySorter) tileEntity;
			return new ContainerSorter(player, tileEntitySorter);
		}

		if (ID == GUIID_BACKPACK)
		{
			return new ContainerBackpack(player, player.inventory, new InventoryBackpack(player.getHeldItem()));
		}

		if (ID == GUIID_SATCHEL)
		{
			return new ContainerSatchel(player, player.inventory, new InventoryBackpack(player.getHeldItem()));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{

		BlockPos xyz = new BlockPos(x, y, z);

		TileEntity tileEntity = world.getTileEntity(xyz);

		// Barrel
		if (tileEntity instanceof TileEntityBarrel)
		{
			TileEntityBarrel tileEntityBarrel = (TileEntityBarrel) tileEntity;
			return new GuiBarrel(player, tileEntityBarrel);
		}

		// Crate
		if (tileEntity instanceof TileEntityCrate)
		{
			TileEntityCrate tileEntityCrate = (TileEntityCrate) tileEntity;
			return new GuiCrate(player, tileEntityCrate);
		}

		// Crate
		if (tileEntity instanceof TileEntityMelter)
		{
			TileEntityMelter tileEntityMelter = (TileEntityMelter) tileEntity;
			return new GuiMelter(player, tileEntityMelter);
		}

		// Alloy
		if (tileEntity instanceof TileEntityAlloy)
		{
			TileEntityAlloy tileEntityAlloy = (TileEntityAlloy) tileEntity;
			return new GuiAlloy(player, tileEntityAlloy);
		}

		// StoneCutter
		if (tileEntity instanceof TileEntityStoneCutter)
		{
			TileEntityStoneCutter tileEntityStoneCutter = (TileEntityStoneCutter) tileEntity;
			return new GuiStoneCutter(player, tileEntityStoneCutter);
		}

		// Sawmill
		if (tileEntity instanceof TileEntitySawMill)
		{
			TileEntitySawMill tileEntitySawMill = (TileEntitySawMill) tileEntity;
			return new GuiSawmill(player, tileEntitySawMill);
		}

		// Crusher
		if (tileEntity instanceof TileEntityCrusher)
		{
			TileEntityCrusher tileEntityCrusher = (TileEntityCrusher) tileEntity;
			return new GuiCrusher(player, tileEntityCrusher);
		}

		// Splitter
		if (tileEntity instanceof TileEntitySplitter)
		{
			TileEntitySplitter tileEntitySplitter = (TileEntitySplitter) tileEntity;
			return new GuiSplitter(player, tileEntitySplitter);
		}

		// EnderPorter
		if (tileEntity instanceof TileEntityEnderPorter)
		{
			TileEntityEnderPorter tileEntityEnderPorter = (TileEntityEnderPorter) tileEntity;
			return new GuiEnderPorter(player, tileEntityEnderPorter);
		}

		// Pipe
		if (tileEntity instanceof TileEntityPipe)
		{
			TileEntityPipe tileEntityPipe = (TileEntityPipe) tileEntity;
			return new GuiPipe(player, tileEntityPipe);
		}

		// Pipe
		if (tileEntity instanceof TileEntitySorter)
		{
			TileEntitySorter tileEntitySorter = (TileEntitySorter) tileEntity;
			return new GuiSorter(player, tileEntitySorter);
		}

		if (ID == GUIID_BACKPACK)
		{
			return new GuiBackpack(new ContainerBackpack(player, player.inventory,
			                                             new InventoryBackpack(player
				                                                                                       .getHeldItem())));
		}

		if (ID == GUIID_SATCHEL)
		{
			return new GuiSatchel(new ContainerSatchel(player, player.inventory,
			                                           new InventoryBackpack(player.getHeldItem())));
		}
		return null;
	}
}
