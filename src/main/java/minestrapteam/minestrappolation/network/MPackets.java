package minestrapteam.minestrappolation.network;

import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class MPackets
{
	public static void registerPackets(SimpleNetworkWrapper network)
	{
	    network.registerMessage(OpenGuiPacket.Handler.class, OpenGuiPacket.class, 0, Side.SERVER);
	}
}
