package com.delocuro.ministrappolation.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.delocuro.ministrappolation.init.MinistrappolationItems;

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
	}
	
	public void init(FMLInitializationEvent event)
	{
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
