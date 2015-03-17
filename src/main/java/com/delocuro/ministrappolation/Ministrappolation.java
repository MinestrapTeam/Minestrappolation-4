package com.delocuro.ministrappolation;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.delocuro.ministrappolation.init.MinistrappolationBlocks;
import com.delocuro.ministrappolation.init.MinistrappolationItems;
import com.delocuro.ministrappolation.init.MinistrappolationRecipes;
import com.delocuro.ministrappolation.proxy.CommonProxy;
import com.delocuro.ministrappolation.util.MinistrappolationGenHandler;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSON)
public class Ministrappolation {
	
	@Instance(Reference.MOD_ID)
	public static Ministrappolation instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final MinistrappolationTab tabMinistrappolation = new MinistrappolationTab("tabMinistrappolation");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinistrappolationBlocks.init();
		MinistrappolationBlocks.register();
		MinistrappolationBlocks.registerHarvestLevels();
		MinistrappolationItems.init();
		MinistrappolationItems.register();
		MinistrappolationRecipes.register();
		MinistrappolationRecipes.removeRecipes();
		
		if (this.proxy != null)
		{
			NetworkRegistry.INSTANCE.registerGuiHandler(this, this.proxy);
		}
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenders();
		MinistrappolationGenHandler.load();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
