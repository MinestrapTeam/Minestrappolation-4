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
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockNetherWart;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MEventHandler
{
	@SubscribeEvent
	public void onPlayerJoin(EntityJoinWorldEvent event)
	{
		VersionChecker check = new VersionChecker(MReference.VERSION, "https://raw.githubusercontent.com/MinestrapTeam/Minestrappolation-4/master/version.txt", MReference.NAME);
		if (event.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntity();
			NBTTagCompound nbt = NBTHelper.getPersistedPlayerTag(player);

			if(!event.getWorld().isRemote)
			{
				if (event.getWorld().isRemote == false && Config.checkForUpdates)
				{
					if(Minestrappolation.hasCheckedVersion == false)
					{
						check.run();
						event.getEntity().sendMessage(VersionChecker.uptoDate);
						event.getEntity().sendMessage(VersionChecker.motd);
						Minestrappolation.hasCheckedVersion = true;
					}
					
				}
				player.addStat(MAchievements.minestrapp, 1);
			}	
			    player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(Config.healthStarting);
			
			if(nbt.hasKey("health"))
			{
				player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(nbt.getDouble("health"));
			}
		}
	}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event)
	{
		Random rand = new Random();

		if (event.getState().getBlock() instanceof BlockNetherWart)
		{
			BlockNetherWart wart = (BlockNetherWart) event.getState().getBlock();
			IBlockState ground = event.getWorld().getBlockState(event.getPos().add(0, -1, 0));
			ItemStack item = new ItemStack(MItems.soul_gem);
			EntityItem eitem = new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), item);
			
			if (rand.nextInt(100) < Config.soulGemDropChance && (Integer) event.getState().getValue(BlockNetherWart.AGE) == 3 && ground.getBlock() == MBlocks.soul_ore)
			{
				event.getWorld().spawnEntity(eitem);
			}
			
		}
		
		if (event.getState().getBlock() instanceof BlockSoul)
		{
			ItemStack stack = event.getPlayer().getHeldItemMainhand();
			if (stack.canHarvestBlock(event.getState()))
			{
				stack.damageItem(Config.soulBlockDamage, event.getPlayer());
			}
		}
		
		if(event.getState() == Blocks.RED_FLOWER.getStateFromMeta(2))
		{
			ItemStack item = new ItemStack(MBlocks.onion);
			EntityItem eitem = new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), item);
			if (rand.nextInt(100) < Config.onionSeedChance)
			{
				event.getWorld().spawnEntity(eitem);
			}
		}
		
		if(event.getState() == Blocks.TALLGRASS.getStateFromMeta(2))
		{
			ItemStack item = new ItemStack(MBlocks.tomato_seed);
			EntityItem eitem = new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), item);
			if (rand.nextInt(100) < Config.tomatoSeedChance)
			{
				event.getWorld().spawnEntity(eitem);
			}
		}
		
		if(event.getState().getBlock() == Blocks.DOUBLE_PLANT)
		{
			if(event.getState().getValue(BlockDoublePlant.VARIANT) == BlockDoublePlant.EnumPlantType.GRASS)
			{
				ItemStack item = new ItemStack(MBlocks.corn);
				EntityItem eitem = new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), item);
				if (rand.nextInt(100) < Config.cornSeedChance)
				{
					event.getWorld().spawnEntity(eitem);
				}
			}
		}
		
		if (event.getState().getBlock() == Blocks.BEDROCK)
		{
			ItemStack stack = event.getPlayer().getHeldItemMainhand();
			if (stack.canHarvestBlock(event.getState()))
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
		EntityPlayer player = event.getHarvester();
		
		if(player != null)
		{
			if(player.getHeldItemMainhand() != null && (player.getHeldItemMainhand().getItem() == MItems.fire_pickaxe || player.getHeldItemMainhand().getItem() == MItems.fire_axe || player.getHeldItemMainhand().getItem() == MItems.fire_shovel))
			{
				if(FurnaceRecipes.instance().getSmeltingResult(new ItemStack(event.getState().getBlock())) != null && FurnaceRecipes.instance().getSmeltingResult(new ItemStack(event.getState().getBlock())).getItem() != event.getDrops().get(0).getItem())
				{
					if((event.getState().getBlock().getHarvestTool(event.getState()) == "pickaxe" && player.getHeldItemMainhand().getItem() == MItems.fire_pickaxe) || (event.getState().getBlock().getHarvestTool(event.getState()) == "axe" && player.getHeldItemMainhand().getItem() == MItems.fire_axe) || (event.getState().getBlock().getHarvestTool(event.getState()) == "shovel" && player.getHeldItemMainhand().getItem() == MItems.fire_shovel))
					{
						ItemStack stack = FurnaceRecipes.instance().getSmeltingResult(new ItemStack(event.getState().getBlock()));
						event.getDrops().clear();
						event.getDrops().add(stack.copy());
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void playerUpdate(LivingUpdateEvent event)
	{
		if (event.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntity();
			World worldIn = player.world;
			BlockPos pos = player.getPosition().down();

			if (PlayerHelper.hasArmorSet(player, MItems.meurodite_helmet, MItems.meurodite_chestplate, MItems.meurodite_leggings, MItems.meurodite_boots))
			{
				player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("fire_resistance"), 2, 0, true, false));
				if(player.isInLava() || player.isBurning())
				{
					if(player.world.rand.nextInt(100) == 1 && !player.capabilities.isCreativeMode)
						player.inventory.damageArmor(1);
				}
			}
			else if (PlayerHelper.hasArmorSet(player, MItems.torite_helmet, MItems.torite_chestplate, MItems.torite_leggings, MItems.torite_boots))
			{
				player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("regeneration"), 2, 0, true, false));
			}
			else if (PlayerHelper.hasArmorSet(player, MItems.titanium_helmet, MItems.titanium_chestplate, MItems.titanium_leggings, MItems.titanium_boots))
			{
				player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("resistance"), 2, 1, true, false));
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
			
			if(ChunkHelper.getChunkBiomeForEntity(player).equals(MBiomeManager.frost.getBiomeName()) && Config.frostSpeedEffect && !player.capabilities.isCreativeMode)
			{
				player.addStat(MAchievements.frost, 1);
				ItemStack helmet = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
				ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
				ItemStack pants = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
				ItemStack boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
				if(helmet == null || chest == null || pants == null || boots == null)
				{
					player.motionX *= .75;
					player.motionZ *= .75;
				}
				
			}
			
			if(player.inventory.hasItemStack(new ItemStack(MItems.diamond_dust)))
			{
				player.addStat(MAchievements.diamond_dust, 1);
			}
			if(player.inventory.hasItemStack(new ItemStack(Items.BREAD)))
			{
				player.addStat(AchievementList.MAKE_BREAD, 1);
			}
			
		}
		else
		{
			if(ChunkHelper.getChunkBiomeForEntity(event.getEntity()).equals(MBiomeManager.frost) && Config.frostSpeedEffect)
			{	
					event.getEntity().motionX *= .75;
					event.getEntity().motionZ *= .75;	
			}
		}
		
		
	}
	
	@SubscribeEvent
	public void onDamage(LivingHurtEvent event)
	{
		if (event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			
			if("fall".equals(event.getSource().damageType))
			{
				if(player.inventory.hasItemStack(new ItemStack(MItems.amuletPullum)))
				{
					event.setCanceled(true);
					int slot = this.getItemsSlot(player, MItems.amuletPullum);
					ItemStack stack = player.inventory.getStackInSlot(slot);
					if(stack.getItemDamage() >= stack.getMaxDamage() || stack.getItemDamage() + (int)event.getAmount() > stack.getMaxDamage())
					{
						player.inventory.setInventorySlotContents(slot, null);
					}
					stack.damageItem((int)event.getAmount(), player);
					
				}
			}
			else
			{
				if(("mob".equals(event.getSource().damageType) || "player".equals(event.getSource().damageType)) && PlayerHelper.hasArmorSet(player, MItems.blazium_helmet, MItems.blazium_chestplate, MItems.blazium_leggings, MItems.blazium_boots))
				{
					player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("fire_resistance"), 2, 0, true, false));
					Entity living = event.getSource().getEntity();
					living.setFire(5);
				}
				
				if(player.inventory.hasItemStack(new ItemStack(MItems.amuletOves)))
				{
					int slot = this.getItemsSlot(player, MItems.amuletOves);
					ItemStack stack = player.inventory.getStackInSlot(slot);
					if(stack.getItemDamage() >= stack.getMaxDamage() || stack.getItemDamage() + (int)event.getAmount() > stack.getMaxDamage())
					{
						player.inventory.setInventorySlotContents(slot, null);
					}
					if (player.getRNG().nextInt(8) == 0)
					{
						event.setCanceled(true);
						stack.damageItem((int)event.getAmount(), player);
					}					
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		IBlockState block = event.getWorld().getBlockState(event.getTarget().getBlockPos());
		if (block.getBlock() == MBlocks.magma)
		{
			event.setFilledBucket(new ItemStack(MBlocks.magmaBucket));
			event.getWorld().setBlockToAir(event.getTarget().getBlockPos());
			event.setResult(Result.ALLOW);
		}
	}
	
	private int getItemsSlot(EntityPlayer player, Item item)
	{
		for (int i = 0; i < player.inventory.mainInventory.size(); ++i)
        {
            if (player.inventory.mainInventory.get(i) != null && player.inventory.mainInventory.get(i).getItem() == item)
            {
                return i;
            }
        }
		return -1;
	}
}
