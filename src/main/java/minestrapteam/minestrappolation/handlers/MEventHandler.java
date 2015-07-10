package minestrapteam.minestrappolation.handlers;

import java.util.Random;

import minestrapteam.minestrappolation.ChunkProtector;
import minestrapteam.minestrappolation.Config;
import minestrapteam.minestrappolation.Key;
import minestrapteam.minestrappolation.block.BlockSoul;
import minestrapteam.minestrappolation.lib.MAchievements;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.lib.MReference;
import minestrapteam.minestrappolation.util.ChunkHelper;
import minestrapteam.minestrappolation.util.NBTHelper;
import minestrapteam.minestrappolation.util.VersionChecker;
import minestrapteam.minestrappolation.world.MBiomeManager;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MEventHandler
{
	
	@SubscribeEvent
	public void onPlayerJoin(EntityJoinWorldEvent event)
	{
		VersionChecker check = new VersionChecker(MReference.VERSION, "https://raw.githubusercontent.com/MinestrapTeam/Minestrappolation-4/master/version.txt", MReference.NAME);
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			NBTTagCompound nbt = NBTHelper.getPersistedPlayerTag(player);

			if(!event.world.isRemote)
			{
				if (event.world.isRemote == false && Config.checkForUpdates)
				{
					check.run();
					event.entity.addChatMessage(VersionChecker.uptoDate);
					event.entity.addChatMessage(VersionChecker.motd);
				}
				player.addStat(MAchievements.minestrapp, 1);
			}	
			    player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(Config.healthStarting);
			
			if(nbt.hasKey("health"))
			{
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(nbt.getDouble("health"));
			}
		}
	}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event)
	{
		Random rand = new Random();

		if (event.state.getBlock() instanceof BlockNetherWart)
		{
			BlockNetherWart wart = (BlockNetherWart) event.state.getBlock();
			IBlockState ground = event.world.getBlockState(event.pos.add(0, -1, 0));
			
			ItemStack item = new ItemStack(MItems.soul_gem);
			EntityItem eitem = new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), item);
			
			if (rand.nextInt(100) < Config.soulGemDropChance && (Integer) event.state.getValue(BlockNetherWart.AGE) == 3 && ground.getBlock() == MBlocks.soul_ore)
			{
				event.world.spawnEntityInWorld(eitem);
			}
			
		}
		
		if (event.state.getBlock() instanceof BlockSoul)
		{
			ItemStack stack = event.getPlayer().getHeldItem();
			if (stack.canHarvestBlock(event.state.getBlock()))
			{
				stack.damageItem(Config.soulBlockDamage, event.getPlayer());
			}
		}
		
		if(event.state == Blocks.red_flower.getStateFromMeta(2))
		{
			ItemStack item = new ItemStack(MBlocks.onion);
			EntityItem eitem = new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), item);
			if (rand.nextInt(100) < Config.onionSeedChance)
			{
				event.world.spawnEntityInWorld(eitem);
			}
		}
		
		if (event.state.getBlock() == Blocks.bedrock)
		{
			ItemStack stack = event.getPlayer().getHeldItem();
			if (stack.canHarvestBlock(event.state.getBlock()))
			{
				stack.damageItem(Config.bedrockBlockDamage, event.getPlayer());
			}
			EntityPlayer player = (EntityPlayer)event.getPlayer();
			player.addStat(MAchievements.bedrock, 1);
		}
		
	}
	
	@SubscribeEvent
	public void playerUpdate(LivingUpdateEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			ItemStack helmet = player.getCurrentArmor(3);
			ItemStack chest = player.getCurrentArmor(2);
			ItemStack pants = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
			if (helmet != null && chest != null && pants != null && boots != null)
			{
				if (helmet.getItem() == MItems.meurodite_helmet && chest.getItem() == MItems.meurodite_chestplate && pants.getItem() == MItems.meurodite_leggings && boots.getItem() == MItems.meurodite_boots)
				{
					player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2, 0, true, false));
				}
				else if (helmet.getItem() == MItems.torite_helmet && chest.getItem() == MItems.torite_chestplate && pants.getItem() == MItems.torite_leggings && boots.getItem() == MItems.torite_boots)
				{
					player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2, 0, true, false));
				}
				else if (helmet.getItem() == MItems.titanium_helmet && chest.getItem() == MItems.titanium_chestplate && pants.getItem() == MItems.titanium_leggings && boots.getItem() == MItems.titanium_boots)
				{
					player.addPotionEffect(new PotionEffect(Potion.resistance.id, 2, 1, true, false));
				}
			}
			if(ChunkHelper.getChunkBiomeForEntity(player).equals(MBiomeManager.frost.biomeName) && Config.frostSpeedEffect && !player.capabilities.isCreativeMode)
			{
				player.addStat(MAchievements.frost, 1);
				if(helmet == null || chest == null || pants == null || boots == null)
				{
					player.motionX *= .75;
					player.motionZ *= .75;
				}
				
			}
		}
		else
		{
			if(ChunkHelper.getChunkBiomeForEntity(event.entity).equals(MBiomeManager.frost) && Config.frostSpeedEffect)
			{	
					event.entity.motionX *= .75;
					event.entity.motionZ *= .75;	
			}
		}
		
		
	}
	
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		IBlockState block = event.world.getBlockState(event.target.getBlockPos());
		if (block.getBlock() == MBlocks.magma)
		{
			event.result = new ItemStack(MBlocks.magmaBucket);
			event.world.setBlockToAir(event.target.getBlockPos());
			event.setResult(Result.ALLOW);
		}
	}
	
	
	
	
	
	//Chunkster events
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	@SideOnly(Side.SERVER)
	public void chunksterBreak(BlockEvent.BreakEvent event)
	{
		if(ChunkProtector.isChunkOwned(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition))
		{
			if(!(ChunkProtector.getOwner(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition) == event.getPlayer().getName()))
			{
				event.setCanceled(true);
				if(!event.world.isRemote)
				{
					event.getPlayer().addChatMessage(new ChatComponentText("§cThis chunk is owned by " + ChunkProtector.getOwner(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition)));
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
			if(!(ChunkProtector.getOwner(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition) == event.player.getName()))
			{
				event.setCanceled(true);
				if(!event.world.isRemote)
				{
					event.player.addChatMessage(new ChatComponentText("§cThis chunk is owned by " + ChunkProtector.getOwner(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition)));
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
				if(!(ChunkProtector.getOwner(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition) == event.entityPlayer.getName()))
				{
					event.setCanceled(true);
					event.entityPlayer.addChatMessage(new ChatComponentText("§cThis chunk is owned by " + ChunkProtector.getOwner(event.world.getChunkFromBlockCoords(event.pos).xPosition, event.world.getChunkFromBlockCoords(event.pos).zPosition)));
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
	
	//************************************************************************************************************
}
