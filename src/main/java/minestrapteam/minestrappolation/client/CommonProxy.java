package minestrapteam.minestrappolation.client;

import minestrapteam.minestrappolation.block.BlockBiomeBricks;
import minestrapteam.minestrappolation.block.BlockBiomeCobble;
import minestrapteam.minestrappolation.block.BlockBiomeStones;
import minestrapteam.minestrappolation.block.MBlockPlanks;
import minestrapteam.minestrappolation.tileentity.TileEntityBarrel;
import minestrapteam.minestrappolation.tileentity.TileEntityCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class CommonProxy implements IGuiHandler
{
	@Override
	public abstract Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z);
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
	
	public void preInit(FMLPreInitializationEvent event)
	{
		BlockBiomeStones.preinventoryRender();
		BlockBiomeBricks.preinventoryRender();
		BlockBiomeCobble.preinventoryRender();
		MBlockPlanks.preinventoryRender();
		
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "tile_entity_barrel");
		GameRegistry.registerTileEntity(TileEntityCrate.class, "tile_entity_crate");
	}
	
	public void init(FMLInitializationEvent event)
	{
		BlockBiomeStones.inventoryRender();
		BlockBiomeBricks.inventoryRender();
		BlockBiomeCobble.inventoryRender();
		MBlockPlanks.inventoryRender();
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
	}
	
	public boolean isClient()
	{
		return false;
	}
	
	public void openGUI(Object gui)
	{
		
	}
	
	public void registerRenders()
	{
		
	}
}
