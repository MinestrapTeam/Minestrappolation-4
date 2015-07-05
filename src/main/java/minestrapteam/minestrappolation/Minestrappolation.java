package minestrapteam.minestrappolation;

import minestrapteam.minestrappolation.client.CommonProxy;
import minestrapteam.minestrappolation.creativetab.MTab;
import minestrapteam.minestrappolation.handlers.MEventHandler;
import minestrapteam.minestrappolation.handlers.MFuelHandler;
import minestrapteam.minestrappolation.handlers.MGuiHandler;
import minestrapteam.minestrappolation.lib.MAchievements;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MDictionary;
import minestrapteam.minestrappolation.lib.MFluid;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.lib.MRecipes;
import minestrapteam.minestrappolation.lib.MReference;
import minestrapteam.minestrappolation.util.Tables;
import minestrapteam.minestrappolation.world.MBiomeManager;
import minestrapteam.minestrappolation.world.MGenHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
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
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		Config.configInit(event);
		MFluid.init();
		MItems.init();
		MBlocks.init();
		
		MItems.register();
		MRecipes.register();
		MRecipes.removeRecipes();
		
		MDictionary.load();
		MBiomeManager.load();
		
		Tables.loadTables();
		
		MAchievements.load();
		MFluid.load();
		
		MinecraftForge.EVENT_BUS.register(new MEventHandler());
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
		
		GameRegistry.registerFuelHandler(new MFuelHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
