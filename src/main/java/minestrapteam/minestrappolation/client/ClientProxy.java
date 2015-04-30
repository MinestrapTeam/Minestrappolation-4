package minestrapteam.minestrappolation.client;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy
{
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
