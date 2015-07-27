package minestrapteam.mods.minestrappolation.lib;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class MDrops 
{
	@SubscribeEvent
	public void mobDrops(LivingDropsEvent event)
	{
		EntityLivingBase living = event.entityLiving;
		Random random = living.getRNG();
		boolean onFire = living.isBurning();
		int looting = event.lootingLevel + 1;
		
		if(living instanceof EntityBat)
		{
			dropBatItems(living, random, onFire, looting);
		}
		if(living instanceof EntityPig)
		{
			dropQuadripedItems(living, random, onFire, looting);
			dropPigItems(living, random, onFire, looting);
		}
		if(living instanceof EntityCow)
		{
			dropQuadripedItems(living, random, onFire, looting);
			dropCowItems(living, random, onFire, looting);
		}
		if(living instanceof EntityMooshroom)
		{
			dropQuadripedItems(living, random, onFire, looting);
			dropCowItems(living, random, onFire, looting);
		}
		if(living instanceof EntitySheep)
		{
			dropQuadripedItems(living, random, onFire, looting);
			dropSheepItems(living, random, onFire, looting);
		}
		if(living instanceof EntityChicken)
		{
			dropChickenItems(living, random, onFire, looting);
		}
		if(living instanceof EntityWolf)
		{
			dropWolfItems(living, random, onFire, looting);
		}
		if(living instanceof EntityHorse)
		{
			dropQuadripedItems(living, random, onFire, looting);
		}
		if(living instanceof EntitySquid)
		{
			dropSquidItems(living, random, onFire, looting);
		}
		if(living instanceof EntityGuardian)
		{
			dropSquidItems(living, random, onFire, looting);
		}
		if(living instanceof EntityIronGolem)
		{
			dropIronGolemItems(living, random, onFire, looting);
		}
		if(living instanceof EntityPigZombie)
		{
			dropPigItems(living, random, onFire, looting);
		}
	}
	
	private static void dropPigItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < Config.animalFeetDropChance)
		{
			living.dropItem(MItems.pig_foot, random.nextInt(Config.animalFeetDropAmount + looting));
		}
	}
	private static void dropCowItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < Config.animalFeetDropChance)
		{
			living.dropItem(MItems.cow_foot, random.nextInt(Config.animalFeetDropAmount + looting));
		}
	}
	private static void dropSheepItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < Config.animalFeetDropChance)
		{
			living.dropItem(MItems.sheep_foot, random.nextInt(Config.animalFeetDropAmount + looting));
		}
	}
	private static void dropChickenItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < Config.animalFeetDropChance)
		{
			living.dropItem(MItems.chicken_foot, random.nextInt(Config.animalFeetDropAmount + looting));
		}
	}
	private static void dropWolfItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < Config.wolfHideDropChance)
		{
			living.dropItem(MItems.wolf_hide, random.nextInt(Config.wolfHideDropAmount + looting));
		}
	}
	private static void dropSquidItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < Config.tentacleDropChance)
		{
			living.dropItem(MItems.squid_tentacle, random.nextInt(Config.tentacleDropAmount + looting));
		}
	}
	private static void dropBatItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < Config.sinewDropChance)
		{
			living.dropItem(MItems.wing_sinew, random.nextInt(Config.sinewDropAmount + looting));
		}
	}
	private static void dropIronGolemItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < Config.doodadDropChance)
		{
			living.dropItem(MItems.technological_doodad, random.nextInt(Config.doodadDropAmount + looting));
		}
	}
	private static void dropQuadripedItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < Config.animalBoneDropChance)
		{
			living.dropItem(MItems.animal_bones, random.nextInt(Config.animalBoneDropAmount + looting));
		}
	}
}
