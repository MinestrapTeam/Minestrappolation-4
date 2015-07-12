package minestrapteam.minestrappolation.lib;

import java.util.Random;

import minestrapteam.minestrappolation.Config;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
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
		}
		if(living instanceof EntityCow)
		{
			dropQuadripedItems(living, random, onFire, looting);
		}
		if(living instanceof EntityMooshroom)
		{
			dropQuadripedItems(living, random, onFire, looting);
		}
		if(living instanceof EntitySheep)
		{
			dropQuadripedItems(living, random, onFire, looting);
		}
		if(living instanceof EntityHorse)
		{
			dropQuadripedItems(living, random, onFire, looting);
		}
	}
	
	private static void dropBatItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < Config.sinewDropChance)
		{
			living.dropItem(MItems.wing_sinew, random.nextInt(Config.sinewDropAmount + looting));
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
