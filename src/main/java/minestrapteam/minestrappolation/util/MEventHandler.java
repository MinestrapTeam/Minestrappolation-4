package minestrapteam.minestrappolation.util;

import minestrapteam.minestrappolation.lib.MReference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MEventHandler {
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onPlayerJoin(EntityJoinWorldEvent event)
	{
		if(event.entity instanceof EntityPlayer)
		{
			if(event.world.isRemote == false)
			{
				VersionChecker.checkIfCurrent(MReference.VERSION, "https://raw.githubusercontent.com/MinestrapTeam/Minestrappolation-4/master/version.txt");
				event.entity.addChatMessage(VersionChecker.uptoDate);
				event.entity.addChatMessage(VersionChecker.motd);
			}
		}	
	}

}
