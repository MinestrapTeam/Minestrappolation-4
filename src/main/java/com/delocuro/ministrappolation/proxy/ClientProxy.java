package com.delocuro.ministrappolation.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.delocuro.ministrappolation.init.MBlocks;
import com.delocuro.ministrappolation.init.MItems;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders()
	{
		MBlocks.registerRenders();
		MItems.registerRenders();
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		return null;
	}
	
	@Override
	public void openGUI(Object gui)
	{
		Minecraft.getMinecraft().displayGuiScreen((GuiScreen) gui);
	}
}
