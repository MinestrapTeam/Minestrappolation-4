package minestrapteam.mods.chunkster;

import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockDoor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CEventHandler
{
	private static void checkProtection(Event event, EntityPlayer player, ProtectionData protection)
	{
		if (protection == null || protection.canEdit(player))
		{
			return;
		}

		event.setCanceled(true);
		if (player.worldObj.isRemote)
		{
			return;
		}

		player.addChatMessage(new TextComponentString("§cThis chunk is owned by " + protection.owner));
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	@SideOnly(Side.SERVER)
	public void chunksterBreak(BlockEvent.BreakEvent event)
	{
		final Chunk chunk = event.getWorld().getChunkFromBlockCoords(event.getPos());
		final ProtectionData protection = ChunkProtector.getProtectionData(chunk.xPosition, chunk.zPosition);

		checkProtection(event, event.getPlayer(), protection);
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	@SideOnly(Side.SERVER)
	public void chunksterBreak(BlockEvent.PlaceEvent event)
	{
		final Chunk chunk = event.getWorld().getChunkFromBlockCoords(event.getPos());
		final ProtectionData protection = ChunkProtector.getProtectionData(chunk.xPosition, chunk.zPosition);

		checkProtection(event, event.getPlayer(), protection);
	}

	@SubscribeEvent(priority = EventPriority.HIGH)
	@SideOnly(Side.SERVER)
	public void chunksterInteract(PlayerInteractEvent event)
	{
		final Chunk chunk = event.getWorld().getChunkFromBlockCoords(event.getPos());
		final ProtectionData protection = ChunkProtector.getProtectionData(chunk.xPosition, chunk.zPosition);

		if (protection.redstoneUseable)
		{
			Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
			if (block == Blocks.LEVER || block instanceof BlockDoor || block instanceof BlockButton)
			{
				return; // do not check permission or cancel the event
			}
		}

		checkProtection(event, event.getEntityPlayer(), protection);
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
