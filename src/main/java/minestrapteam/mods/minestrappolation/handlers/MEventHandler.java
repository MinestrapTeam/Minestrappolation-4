package minestrapteam.mods.minestrappolation.handlers;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.block.BlockSoul;
import minestrapteam.mods.minestrappolation.block.machines.BlockFrostGenerator;
import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.lib.MReference;
import minestrapteam.mods.minestrappolation.util.ChunkHelper;
import minestrapteam.mods.minestrappolation.util.NBTHelper;
import minestrapteam.mods.minestrappolation.util.PlayerHelper;
import minestrapteam.mods.minestrappolation.util.VersionChecker;
import minestrapteam.mods.minestrappolation.world.MBiomeManager;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
					if(Minestrappolation.hasCheckedVersion == false)
					{
						check.run();
						event.entity.addChatMessage(VersionChecker.uptoDate);
						event.entity.addChatMessage(VersionChecker.motd);
						Minestrappolation.hasCheckedVersion = true;
					}
					
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
		
		if(event.state == Blocks.tallgrass.getStateFromMeta(2))
		{
			ItemStack item = new ItemStack(MBlocks.tomato_seed);
			EntityItem eitem = new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), item);
			if (rand.nextInt(100) < Config.tomatoSeedChance)
			{
				event.world.spawnEntityInWorld(eitem);
			}
		}
		
		if(event.state == Blocks.double_plant.getStateFromMeta(2) || event.state == Blocks.double_plant.getStateFromMeta(10))
		{
			ItemStack item = new ItemStack(MBlocks.corn);
			EntityItem eitem = new EntityItem(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), item);
			if (rand.nextInt(100) < Config.cornSeedChance)
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
	public void onBlockHarvest(BlockEvent.HarvestDropsEvent event)
	{
		EntityPlayer player = event.harvester;
		
		if(player != null && player.getHeldItem().getItem() != null && player.getHeldItem().getItem() == MItems.fire_pickaxe)
		{
			if(FurnaceRecipes.instance().getSmeltingResult(new ItemStack(event.state.getBlock())) != null)
			{
				ItemStack stack = FurnaceRecipes.instance().getSmeltingResult(new ItemStack(event.state.getBlock()));
				event.drops.clear();
				event.drops.add(stack.copy());
			}
		}
	}
	
	@SubscribeEvent
	public void playerUpdate(LivingUpdateEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity;
			World worldIn = player.worldObj;
			BlockPos pos = player.getPosition().down();

			if (PlayerHelper.hasArmorSet(player, MItems.meurodite_helmet, MItems.meurodite_chestplate, MItems.meurodite_leggings, MItems.meurodite_boots))
			{
				player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2, 0, true, false));
				if(player.isInLava() || player.isBurning())
				{
					if(player.worldObj.rand.nextInt(100) == 1 && !player.capabilities.isCreativeMode)
						player.inventory.damageArmor(1);
				}
			}
			else if (PlayerHelper.hasArmorSet(player, MItems.torite_helmet, MItems.torite_chestplate, MItems.torite_leggings, MItems.torite_boots))
			{
				player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2, 0, true, false));
			}
			else if (PlayerHelper.hasArmorSet(player, MItems.titanium_helmet, MItems.titanium_chestplate, MItems.titanium_leggings, MItems.titanium_boots))
			{
				player.addPotionEffect(new PotionEffect(Potion.resistance.id, 2, 1, true, false));
			}
			else if (PlayerHelper.hasArmorSet(player, MItems.ice_helmet, MItems.ice_chestplate, MItems.ice_leggings, MItems.ice_boots))
			{
				if(BlockFrostGenerator.canFreeze.containsKey(worldIn.getBlockState(pos)))
					worldIn.setBlockState(pos, BlockFrostGenerator.canFreeze.get(worldIn.getBlockState(pos)));
				if(BlockFrostGenerator.canFreeze.containsKey(worldIn.getBlockState(pos.north())))
					worldIn.setBlockState(pos.north(), BlockFrostGenerator.canFreeze.get(worldIn.getBlockState(pos.north())));
				if(BlockFrostGenerator.canFreeze.containsKey(worldIn.getBlockState(pos.east())))
					worldIn.setBlockState(pos.east(), BlockFrostGenerator.canFreeze.get(worldIn.getBlockState(pos.east())));
				if(BlockFrostGenerator.canFreeze.containsKey(worldIn.getBlockState(pos.south())))
					worldIn.setBlockState(pos.south(), BlockFrostGenerator.canFreeze.get(worldIn.getBlockState(pos.south())));
				if(BlockFrostGenerator.canFreeze.containsKey(worldIn.getBlockState(pos.west())))
					worldIn.setBlockState(pos.west(), BlockFrostGenerator.canFreeze.get(worldIn.getBlockState(pos.west())));
			}
			
			if(ChunkHelper.getChunkBiomeForEntity(player).equals(MBiomeManager.frost.biomeName) && Config.frostSpeedEffect && !player.capabilities.isCreativeMode)
			{
				player.addStat(MAchievements.frost, 1);
				ItemStack helmet = player.getCurrentArmor(3);
				ItemStack chest = player.getCurrentArmor(2);
				ItemStack pants = player.getCurrentArmor(1);
				ItemStack boots = player.getCurrentArmor(0);
				if(helmet == null || chest == null || pants == null || boots == null)
				{
					player.motionX *= .75;
					player.motionZ *= .75;
				}
				
			}
			
			if(player.inventory.hasItem(MItems.diamond_dust))
			{
				player.addStat(MAchievements.diamond_dust, 1);
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
	public void onDamage(LivingHurtEvent event)
	{
		if (event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			
			if("fall".equals(event.source.damageType))
			{
				if(player.inventory.hasItem(MItems.amuletPullum))
				{
					event.setCanceled(true);
					int slot = this.getItemsSlot(player, MItems.amuletPullum);
					ItemStack stack = player.inventory.getStackInSlot(slot);
					if(stack.getItemDamage() >= stack.getMaxDamage() || stack.getItemDamage() + (int)event.ammount > stack.getMaxDamage())
					{
						player.inventory.setInventorySlotContents(slot, null);
					}
					stack.damageItem((int)event.ammount, player);
					
				}
			}
			else
			{
				if(("mob".equals(event.source.damageType) || "player".equals(event.source.damageType)) && PlayerHelper.hasArmorSet(player, MItems.blazium_helmet, MItems.blazium_chestplate, MItems.blazium_leggings, MItems.blazium_boots))
				{
					player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2, 0, true, false));
					Entity living = event.source.getEntity();
					living.setFire(5);
				}
				
				if(player.inventory.hasItem(MItems.amuletOves))
				{
					int slot = this.getItemsSlot(player, MItems.amuletOves);
					ItemStack stack = player.inventory.getStackInSlot(slot);
					if(stack.getItemDamage() >= stack.getMaxDamage() || stack.getItemDamage() + (int)event.ammount > stack.getMaxDamage())
					{
						player.inventory.setInventorySlotContents(slot, null);
					}
					if (player.getRNG().nextInt(8) == 0)
					{
						event.setCanceled(true);
						stack.damageItem((int)event.ammount, player);
					}					
				}
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
	
	private int getItemsSlot(EntityPlayer player, Item item)
	{
		for (int i = 0; i < player.inventory.mainInventory.length; ++i)
        {
            if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() == item)
            {
                return i;
            }
        }
		return -1;
	}
}
