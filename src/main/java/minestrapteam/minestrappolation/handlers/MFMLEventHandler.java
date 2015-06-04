package minestrapteam.minestrappolation.handlers;

import minestrapteam.minestrappolation.lib.MAchievements;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class MFMLEventHandler {

	@SubscribeEvent
	public void onPlayerCraft(PlayerEvent.ItemCraftedEvent event)
	{
			if(event.crafting.getItem() == Item.getItemFromBlock(MBlocks.godstone))
			{
				MAchievements.addAchievement(event.player, MAchievements.god);
			}
	}
	
	@SubscribeEvent
	public void onPlayerSmelt(PlayerEvent.ItemSmeltedEvent event)
	{
			
	}
}
