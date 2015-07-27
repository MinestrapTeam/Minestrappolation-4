package minestrapteam.mods.minestrappolation.network;

import io.netty.buffer.ByteBuf;
import minestrapteam.mods.minestrappolation.Minestrappolation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * This was for opening a player gui. No longer in use, but it might be helpful to some. <br> <br>
 * Packets work sending IMessages, and can only be sent and recieved with bytes. use ByteBuf to send and recieve (see below).
 * @author Sobiohazardous (Domenic)
 *
 */
public class OpenGuiPacket implements IMessage
{
	private int id;
	public static OpenGuiPacket instance = null;

	public OpenGuiPacket() { instance = this;}
	
    public OpenGuiPacket(int id) 
    {
    	this.id = id;
    	instance = this;
    }

    @Override
    public void fromBytes(ByteBuf buf) 
    {
    	id = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) 
    {
    	buf.writeInt(id);
    }

    public static class Handler implements IMessageHandler<OpenGuiPacket, IMessage> 
    {
        @Override
        public IMessage onMessage(OpenGuiPacket message, MessageContext ctx) 
        {
            IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or ctx.getServerHandler() on the server
            final EntityPlayer player = ctx.getServerHandler().playerEntity;
            mainThread.addScheduledTask(new Runnable() 
            {
                @Override
                public void run() 
                {
                	player.openGui(Minestrappolation.instance, OpenGuiPacket.instance.id, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
                }
            });
            return null; // no response in this case
        }
    }
}