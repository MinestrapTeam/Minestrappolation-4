package minestrapteam.minestrappolation.network;

import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

/**
 * This is a simple static lib class to register packets with.
 * @author Sobiohazardous (Domenic)
 *
 */
public class MPackets
{
	public static void registerPackets(SimpleNetworkWrapper network)
	{
	    network.registerMessage(OpenGuiPacket.Handler.class, OpenGuiPacket.class, 0, Side.SERVER);
	}
}
