package minestrapteam.mods.minestrappolation;

import minestrapteam.mods.chunkster.CEventHandler;
import minestrapteam.mods.minestrappolation.creativetab.MTab;
import minestrapteam.mods.minestrappolation.entity.EntityIceball;
import minestrapteam.mods.minestrappolation.entity.EntityMudBall;
import minestrapteam.mods.minestrappolation.handlers.MDispenserHandler;
import minestrapteam.mods.minestrappolation.handlers.MEventHandler;
import minestrapteam.mods.minestrappolation.handlers.MFuelHandler;
import minestrapteam.mods.minestrappolation.handlers.MGuiHandler;
import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MDictionary;
import minestrapteam.mods.minestrappolation.lib.MDrops;
import minestrapteam.mods.minestrappolation.lib.MFluid;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.lib.MLoot;
import minestrapteam.mods.minestrappolation.lib.MPotions;
import minestrapteam.mods.minestrappolation.lib.MRecipes;
import minestrapteam.mods.minestrappolation.lib.MReference;
import minestrapteam.mods.minestrappolation.network.CommonProxy;
import minestrapteam.mods.minestrappolation.network.MPackets;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityAlloy;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityBarrel;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityCrate;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityCrusher;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityEnderPorter;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityMelter;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityPipe;
import minestrapteam.mods.minestrappolation.tileentity.TileEntitySawMill;
import minestrapteam.mods.minestrappolation.tileentity.TileEntitySplitter;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityStoneCutter;
import minestrapteam.mods.minestrappolation.util.Tables;
import minestrapteam.mods.minestrappolation.world.MBiomeManager;
import minestrapteam.mods.minestrappolation.world.MGenHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MReference.MODID, name = MReference.NAME, version = MReference.VERSION)
public class Minestrappolation
{
	@Instance(MReference.MODID)
	public static Minestrappolation	instance;
	
	@SidedProxy(clientSide = MReference.CLIENT_PROXY_CLASS, serverSide = MReference.SERVER_PROXY_CLASS)
	public static CommonProxy		proxy;
	
	public static final MTab		tabMBuilding	= new MTab("tabMBuilding");
	public static final MTab		tabMDecor	    = new MTab("tabMDecor");
	public static final MTab		tabMTech	    = new MTab("tabMTech");
	public static final MTab		tabMMaterials	= new MTab("tabMMaterials");
	public static final MTab		tabMFood	    = new MTab("tabMFood");
	public static final MTab		tabMTools	    = new MTab("tabMTools");
	public static final MTab		tabMCombat	    = new MTab("tabMCombat");
	
	public static SimpleNetworkWrapper network;
	
	
	public static boolean hasCheckedVersion = false;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		Config.configMain(event);
		
		MFluid.init();
		MItems.init();
		MBlocks.init();
		MPotions.loadPotions();
		MLoot.addItemsToChests();
		
		MItems.register();
		MRecipes.register();
		MRecipes.removeRecipes();
		
		MDictionary.load();
		MBiomeManager.load();
		
		Tables.loadTables();
		
		MAchievements.load();
		MFluid.load();
		
		MDispenserHandler.registerBehaviors();
		
		network = NetworkRegistry.INSTANCE.newSimpleChannel("Minestrap");
		MPackets.registerPackets(network);
		
		MinecraftForge.EVENT_BUS.register(new MEventHandler());
		MinecraftForge.EVENT_BUS.register(new MDrops());
		
		MinecraftForge.EVENT_BUS.register(new CEventHandler());
		
		proxy.preInit(event);
		if (Minestrappolation.proxy != null)
		{
			NetworkRegistry.INSTANCE.registerGuiHandler(this, new MGuiHandler());
		}
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenders();
		proxy.init(event);
		MGenHandler.load();
		EntityRegistry.registerModEntity(EntityMudBall.class, "mud_ball", EntityRegistry.findGlobalUniqueEntityId(), Minestrappolation.instance, 350, 5, true);
		EntityRegistry.registerModEntity(EntityIceball.class, "ice_ball", EntityRegistry.findGlobalUniqueEntityId() + 1, Minestrappolation.instance, 350, 5, true);
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "tile_entity_barrel");
		GameRegistry.registerTileEntity(TileEntityCrate.class, "tile_entity_crate");
		GameRegistry.registerTileEntity(TileEntityMelter.class, "tile_entity_melter");
		GameRegistry.registerTileEntity(TileEntityAlloy.class, "tile_entity_alloy");
		GameRegistry.registerTileEntity(TileEntityStoneCutter.class, "tile_entity_stonecutter");
		GameRegistry.registerTileEntity(TileEntitySawMill.class, "tile_entity_sawmill");
		GameRegistry.registerTileEntity(TileEntityCrusher.class, "tile_entity_crusher");
		GameRegistry.registerTileEntity(TileEntitySplitter.class, "tile_entity_splitter");
		GameRegistry.registerTileEntity(TileEntityEnderPorter.class, "tile_entity_enderporter");
		GameRegistry.registerTileEntity(TileEntityPipe.class, "tile_entity_pipe");
		
		GameRegistry.registerFuelHandler(new MFuelHandler());
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
