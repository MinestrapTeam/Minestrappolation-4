package minestrapteam.chunkster;


import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CEventHandler 
{
	@SubscribeEvent(priority = EventPriority.HIGH)
	@SideOnly(Side.SERVER)
	public void chunksterBreak(BlockEvent.BreakEvent event)
	{
		if(ChunkProtector.isChunkOwned(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition))
		{
			if(!ChunkProtector.canEditChunk(event.getPlayer(), event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition))
			{
				event.setCanceled(true);
				if(!event.world.isRemote)
				{
					event.getPlayer().addChatMessage(new ChatComponentText("§cThis chunk is owned by " + ChunkProtector.getPlayersList(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition).get(0)));
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	@SideOnly(Side.SERVER)
	public void chunksterBreak(BlockEvent.PlaceEvent event)
	{
		if(ChunkProtector.isChunkOwned(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition))
		{
			if(!ChunkProtector.canEditChunk(event.player, event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition))
			{
				event.setCanceled(true);
				if(!event.world.isRemote)
				{
					event.player.addChatMessage(new ChatComponentText("§cThis chunk is owned by " + ChunkProtector.getPlayersList(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition).get(0)));
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	@SideOnly(Side.SERVER)
	public void chunksterInteract(PlayerInteractEvent event)
	{
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if(ChunkProtector.isChunkOwned(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition))
			{
				if(!ChunkProtector.canEditChunk(event.entityPlayer, event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition))
				{
					event.setCanceled(true);
					event.entityPlayer.addChatMessage(new ChatComponentText("§cThis chunk is owned by " + ChunkProtector.getPlayersList(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition).get(0)));
				}
			}
		}	
	}
	
	@SubscribeEvent
	@SideOnly(Side.SERVER)
	public void worldLoad(WorldEvent.Load event)
	{
		ChunkProtector.loadFile(event.world.getWorldInfo().getWorldName());
	}

	@SubscribeEvent
	@SideOnly(Side.SERVER)
	public void worldSave(WorldEvent.Save event)
	{
		ChunkProtector.updateFile(event.world.getWorldInfo().getWorldName());
	}
}
