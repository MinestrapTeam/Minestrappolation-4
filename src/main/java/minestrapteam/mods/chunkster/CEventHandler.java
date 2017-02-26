package minestrapteam.mods.chunkster;

import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockDoor;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
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
		if(ChunkProtector.isChunkOwned(event.getWorld().getChunkFromBlockCoords(event.getPos()).xPosition, event.getWorld().getChunkFromBlockCoords(event.getPos()).zPosition))
		{
			if(!ChunkProtector.canEditChunk(event.getPlayer(), event.getWorld().getChunkFromBlockCoords(event.getPos()).xPosition, event.getWorld().getChunkFromBlockCoords(event.getPos()).zPosition))
			{
				event.setCanceled(true);
				if(!event.getWorld().isRemote)
				{
					event.getPlayer().sendMessage(new TextComponentString("§cThis chunk is owned by " + ChunkProtector.getProtectionData(event.getWorld().getChunkFromBlockCoords(event.getPos()).xPosition, event.getWorld().getChunkFromBlockCoords(event.getPos()).zPosition).owner));
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	@SideOnly(Side.SERVER)
	public void chunksterBreak(BlockEvent.PlaceEvent event)
	{
		if(ChunkProtector.isChunkOwned(event.getWorld().getChunkFromBlockCoords(event.getPos()).xPosition, event.getWorld().getChunkFromBlockCoords(event.getPos()).zPosition))
		{
			if(!ChunkProtector.canEditChunk(event.getPlayer(), event.getWorld().getChunkFromBlockCoords(event.getPos()).xPosition, event.getWorld().getChunkFromBlockCoords(event.getPos()).zPosition))
			{
				event.setCanceled(true);
				if(!event.getWorld().isRemote)
				{
					event.getPlayer().sendMessage(new TextComponentString("§cThis chunk is owned by " + ChunkProtector.getProtectionData(event.getWorld().getChunkFromBlockCoords(event.getPos()).xPosition, event.getWorld().getChunkFromBlockCoords(event.getPos()).zPosition).owner));
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	@SideOnly(Side.SERVER)
	public void chunksterInteract(RightClickBlock event)
	{
		if(ChunkProtector.isChunkOwned(event.getWorld().getChunkFromBlockCoords(event.getPos()).xPosition, event.getWorld().getChunkFromBlockCoords(event.getPos()).zPosition))
		{
				if(!ChunkProtector.canEditChunk(event.getEntityPlayer(), event.getWorld().getChunkFromBlockCoords(event.getPos()).xPosition, event.getWorld().getChunkFromBlockCoords(event.getPos()).zPosition))
				{
					if(ChunkProtector.getProtectionData(event.getWorld().getChunkFromBlockCoords(event.getPos()).xPosition, event.getWorld().getChunkFromBlockCoords(event.getPos()).zPosition).redstoneUseable)
					{
						Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
						if(block == Blocks.LEVER || block instanceof BlockDoor || block instanceof BlockButton)
						{
							
						}
						else
						{
							event.setCanceled(true);
							event.getEntityPlayer().sendMessage(new TextComponentString("§cThis chunk is owned by " + ChunkProtector.getProtectionData(event.getWorld().getChunkFromBlockCoords(event.getPos()).xPosition, event.getWorld().getChunkFromBlockCoords(event.getPos()).zPosition).owner));
						}
					}
					else
					{
						event.setCanceled(true);
						event.getEntityPlayer().sendMessage(new TextComponentString("§cThis chunk is owned by " + ChunkProtector.getProtectionData(event.getWorld().getChunkFromBlockCoords(event.getPos()).xPosition, event.getWorld().getChunkFromBlockCoords(event.getPos()).zPosition).owner));
					}
					
				}				
		}
	}
	
	@SubscribeEvent
	@SideOnly(Side.SERVER)
	public void worldLoad(WorldEvent.Load event)
	{
		ChunkProtector.loadFile(event.getWorld().getWorldInfo().getWorldName());
	}

	@SubscribeEvent
	@SideOnly(Side.SERVER)
	public void worldSave(WorldEvent.Save event)
	{
		ChunkProtector.updateFile(event.getWorld().getWorldInfo().getWorldName());
	}
}
