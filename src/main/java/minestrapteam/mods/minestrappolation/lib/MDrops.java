package minestrapteam.mods.minestrappolation.lib;

import minestrapteam.mods.minestrappolation.Config;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Calendar;
import java.util.Random;

public class MDrops
{
	public boolean isHalloween = false;

	@SubscribeEvent
	public void mobDrops(LivingDropsEvent event)
	{
		EntityLivingBase living = event.entityLiving;
		Random random = living.getRNG();
		boolean onFire = living.isBurning();
		int looting = event.lootingLevel + 1;
		EntityPlayer player = null;
		if (event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			player = ((EntityPlayer) event.source.getSourceOfDamage());
		}

		Calendar calendar = Calendar.getInstance();

		if (calendar.get(2) + 1 == 10 && calendar.get(5) >= 20 && calendar.get(5) <= 31)
		{
			this.isHalloween = true;
		}
		if (living instanceof EntityBat)
		{
			dropBatItems(living, random, onFire, looting);
		}
		if (living instanceof EntityPig)
		{
			dropQuadripedItems(living, random, onFire, looting);
			dropPigItems(living, random, onFire, looting);
		}
		if (living instanceof EntityCow)
		{
			dropQuadripedItems(living, random, onFire, looting);
			dropCowItems(living, random, onFire, looting);
		}
		if (living instanceof EntityMooshroom)
		{
			dropQuadripedItems(living, random, onFire, looting);
			dropCowItems(living, random, onFire, looting);
			dropMooshroomItems(living, random, onFire, looting);
		}
		if (living instanceof EntitySheep)
		{
			dropQuadripedItems(living, random, onFire, looting);
			dropSheepItems(living, random, onFire, looting);
		}
		if (living instanceof EntityChicken)
		{
			dropChickenItems(living, random, onFire, looting);
		}
		if (living instanceof EntityWolf)
		{
			dropWolfItems(living, random, onFire, looting);
		}
		if (living instanceof EntityHorse)
		{
			dropQuadripedItems(living, random, onFire, looting);
		}
		if (living instanceof EntitySquid)
		{
			dropSquidItems(living, random, onFire, looting);
		}
		if (living instanceof EntityGuardian)
		{
			dropSquidItems(living, random, onFire, looting);
			if (((EntityGuardian) living).isElder() == true)
			{
				dropElderGuardianItems(living, random, onFire, looting);
			}
		}
		if (living instanceof EntityIronGolem)
		{
			dropIronGolemItems(living, random, onFire, looting);
		}
		if (living instanceof EntityZombie)
		{
			if (this.isHalloween == true)
			{
				dropHalloweenItems(living, random, onFire, looting);
			}
		}
		if (living instanceof EntitySkeleton)
		{
			if (this.isHalloween == true)
			{
				dropHalloweenItems(living, random, onFire, looting);
			}
			if (((EntitySkeleton) living).getSkeletonType() == 1)
			{
				dropWitherSkeletonItems(living, random, onFire, looting);
			}
			dropSkeletonItems(living, random, onFire, looting, player);
		}
		if (living instanceof EntityWitch)
		{
			if (this.isHalloween == true)
			{
				dropHalloweenItems(living, random, onFire, looting);
			}
		}
		if (living instanceof EntityPigZombie)
		{
			dropPigItems(living, random, onFire, looting);
		}
		if (living instanceof EntityEndermite)
		{
			dropEndermiteItems(living, random, onFire, looting);
		}
		if (living instanceof EntitySlime || living instanceof EntityMagmaCube)
		{
			dropSlimeItems(living, random, onFire, looting);
		}
		if (living instanceof EntityVillager)
		{
			dropVillagerItems(living, random, onFire, looting);
			if (this.isHalloween == true)
			{
				dropHalloweenItems(living, random, onFire, looting);
			}
		}
	}

	private static void dropPigItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.animalFeetDropChance)
		{
			living.dropItem(MItems.pig_foot, random.nextInt(Config.animalFeetDropAmount + looting));
		}
		if ((random.nextFloat() * 100) / looting < Config.fatDropChance)
		{
			if (onFire == false)
				living.dropItem(MItems.fat, random.nextInt(Config.fatDropAmount + looting));
			else
				living.dropItem(MItems.tallow, random.nextInt(Config.fatDropAmount + looting));
		}
	}

	private static void dropCowItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.animalFeetDropChance)
		{
			living.dropItem(MItems.cow_foot, random.nextInt(Config.animalFeetDropAmount + looting));
		}
	}

	private static void dropMooshroomItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.fungusDropChance)
		{
			living.dropItem(MItems.infectious_fungus, random.nextInt(Config.fungusDropAmount + looting));
		}
	}

	private static void dropSheepItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.animalFeetDropChance)
		{
			living.dropItem(MItems.sheep_foot, random.nextInt(Config.animalFeetDropAmount + looting));
		}
	}

	private static void dropChickenItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.animalFeetDropChance)
		{
			living.dropItem(MItems.chicken_foot, random.nextInt(Config.animalFeetDropAmount + looting));
		}
	}

	private static void dropWolfItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.wolfHideDropChance)
		{
			living.dropItem(MItems.wolf_hide, random.nextInt(Config.wolfHideDropAmount + looting));
		}
	}

	private static void dropSquidItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.tentacleDropChance)
		{
			if (onFire == false)
				living.dropItem(MItems.squid_tentacle, random.nextInt(Config.tentacleDropAmount + looting));
			else
				living.dropItem(MItems.calamari, random.nextInt(Config.tentacleDropAmount + looting));
		}
	}

	private static void dropElderGuardianItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < 70)
		{
			living.dropItem(MItems.heart_piece, 1);
		}
	}

	private static void dropBatItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.sinewDropChance)
		{
			living.dropItem(MItems.wing_sinew, random.nextInt(Config.sinewDropAmount + looting));
		}
		if ((random.nextFloat() * 100) / looting < Config.guanoDropChance)
		{
			living.dropItem(MItems.guano, random.nextInt(Config.guanoDropAmount + looting));
		}
	}

	private static void dropIronGolemItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.doodadDropChance)
		{
			living.dropItem(MItems.technological_doodad, random.nextInt(Config.doodadDropAmount + looting));
		}
	}

	private static void dropSlimeItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.slimeCoreDropChance)
		{
			if (looting > 1)
				looting = 1;
			living.dropItem(MItems.slime_core, random.nextInt(Config.slimeCoreDropAmount + looting));
		}
	}

	private static void dropVillagerItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.fleshDropChance)
		{
			living.dropItem(MItems.flesh, random.nextInt(Config.fleshDropAmount + looting));
		}
	}

	private static void dropSkeletonItems(EntityLivingBase living, Random random, boolean onFire, int looting, EntityPlayer player)
	{
		if ((random.nextFloat() * 100) < Config.nyehHehHehChance)
		{
			living.dropItem(MItems.spaghetti, random.nextInt(Config.nyehHehHehAmount + 1));
			if (player != null)
				player.addStat(MAchievements.bonetrousle, 1);
		}
	}

	private static void dropWitherSkeletonItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.witherBoneDropChance)
		{
			living.dropItem(MItems.wither_bone, random.nextInt(Config.witherBoneDropAmount + looting));
			System.out.println("Dropped");
		}
	}

	private static void dropEndermiteItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.enderAuraDropChance)
		{
			living.dropItem(MItems.ender_aura, random.nextInt(Config.enderAuraDropAmount + looting));
		}
	}

	private static void dropQuadripedItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.animalBoneDropChance)
		{
			living.dropItem(MItems.animal_bones, random.nextInt(Config.animalBoneDropAmount + looting));
		}
	}

	private static void dropHalloweenItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if ((random.nextFloat() * 100) / looting < Config.candyDropChance)
		{
			int type = random.nextInt(3);
			if (type == 0)
				living.dropItem(MItems.candy_red, random.nextInt(Config.candyDropAmount + looting));
			else if (type == 1)
				living.dropItem(MItems.candy_blue, random.nextInt(Config.candyDropAmount + looting));
			else
				living.dropItem(MItems.candy_yellow, random.nextInt(Config.candyDropAmount + looting));
		}
	}
}
