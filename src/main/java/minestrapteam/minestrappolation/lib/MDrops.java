package minestrapteam.minestrappolation.lib;

import java.util.Random;

import minestrapteam.minestrappolation.Config;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
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
		
		if(living instanceof EntityPig)
		{
			dropPigItems(living, random, onFire, looting);
		}
	}
	
	private static void dropPigItems(EntityLivingBase living, Random random, boolean onFire, int looting)
	{
		if (random.nextFloat() / looting < Config.testDropChance)
		{
			living.dropItem(Items.apple, random.nextInt(Config.dropAmount + looting));
		}
	}
}
