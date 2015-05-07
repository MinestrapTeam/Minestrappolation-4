package minestrapteam.minestrappolation;

import minestrapteam.minestrappolation.client.CommonProxy;
import minestrapteam.minestrappolation.creativetab.MTab;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.lib.MRecipes;
import minestrapteam.minestrappolation.lib.MReference;
import minestrapteam.minestrappolation.util.MEventHandler;
import minestrapteam.minestrappolation.util.MGuiHandler;
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

@Mod(modid = MReference.MODID, name = MReference.NAME, version = MReference.VERSION)
public class Minestrappolation
{
	@Instance(MReference.MODID)
	public static Minestrappolation	instance;
	
	@SidedProxy(clientSide = MReference.CLIENT_PROXY_CLASS, serverSide = MReference.SERVER_PROXY_CLASS)
	public static CommonProxy		proxy;
	
	public static final MTab		tabMinistrappolation	= new MTab("tabMinistrappolation");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MItems.init();
		MBlocks.init();
		MItems.register();
		MRecipes.register();
		MRecipes.removeRecipes();
		MBiomeManager.load();
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
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
