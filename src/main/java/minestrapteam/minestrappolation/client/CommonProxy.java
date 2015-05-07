package minestrapteam.minestrappolation.client;

import minestrapteam.minestrappolation.block.BlockBiomeBricks;
import minestrapteam.minestrappolation.block.MBlockPlanks;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeCoal;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeCobble;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeCopper;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeDiamond;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeEmerald;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeGold;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeIron;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeLapis;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeMeurodite;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomePlutonium;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeRadiant;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeRedstone;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeStones;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeSunstone;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeTin;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeTitanium;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeTorite;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeUranium;
import minestrapteam.minestrappolation.tileentity.TileEntityBarrel;
import minestrapteam.minestrappolation.tileentity.TileEntityCrate;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;
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
		BlockBiomeDiamond.preinventoryRender();
		BlockBiomeIron.preinventoryRender();
		BlockBiomeGold.preinventoryRender();
		BlockBiomeCoal.preinventoryRender();
		BlockBiomeLapis.preinventoryRender();
		BlockBiomeRedstone.preinventoryRender();
		BlockBiomeTin.preinventoryRender();
		BlockBiomeCopper.preinventoryRender();
		BlockBiomeEmerald.preinventoryRender();
		BlockBiomeSunstone.preinventoryRender();
		BlockBiomeTorite.preinventoryRender();
		BlockBiomeTitanium.preinventoryRender();
		BlockBiomeRadiant.preinventoryRender();
		BlockBiomePlutonium.preinventoryRender();
		BlockBiomeUranium.preinventoryRender();
		BlockBiomeMeurodite.preinventoryRender();
		MBlockPlanks.preinventoryRender();
		
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "tile_entity_barrel");
		GameRegistry.registerTileEntity(TileEntityCrate.class, "tile_entity_crate");
		GameRegistry.registerTileEntity(TileEntityMelter.class, "tile_entity_melter");
	}
	
	public void init(FMLInitializationEvent event)
	{
		BlockBiomeStones.inventoryRender();
		BlockBiomeBricks.inventoryRender();
		BlockBiomeCobble.inventoryRender();
		BlockBiomeDiamond.inventoryRender();
		BlockBiomeIron.inventoryRender();
		BlockBiomeGold.inventoryRender();
		BlockBiomeCoal.inventoryRender();
		BlockBiomeLapis.inventoryRender();
		BlockBiomeRedstone.inventoryRender();
		BlockBiomeTin.inventoryRender();
		BlockBiomeCopper.inventoryRender();
		BlockBiomeEmerald.inventoryRender();
		BlockBiomeSunstone.inventoryRender();
		BlockBiomeTorite.inventoryRender();
		BlockBiomeTitanium.inventoryRender();
		BlockBiomeRadiant.inventoryRender();
		BlockBiomePlutonium.inventoryRender();
		BlockBiomeUranium.inventoryRender();
		BlockBiomeMeurodite.inventoryRender();
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
