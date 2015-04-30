package com.delocuro.ministrappolation;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.delocuro.ministrappolation.init.MBlocks;
import com.delocuro.ministrappolation.init.MItems;
import com.delocuro.ministrappolation.init.MRecipes;
import com.delocuro.ministrappolation.proxy.CommonProxy;
import com.delocuro.ministrappolation.world.MBiomeManager;
import com.delocuro.ministrappolation.world.MinistrappolationGenHandler;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSON)
public class Minestrappolation
{
	
	@Instance(Reference.MOD_ID)
	public static Minestrappolation	instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy		proxy;
	
	public static final MTab		tabMinistrappolation	= new MTab("tabMinistrappolation");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		
		MBlocks.init();
		MItems.init();
		MItems.register();
		MRecipes.register();
		MRecipes.removeRecipes();
		MBiomeManager.load();
		proxy.preInit(event);
		if (Minestrappolation.proxy != null)
		{
			NetworkRegistry.INSTANCE.registerGuiHandler(this, Minestrappolation.proxy);
		}
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenders();
		proxy.init(event);
		MinistrappolationGenHandler.load();
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
