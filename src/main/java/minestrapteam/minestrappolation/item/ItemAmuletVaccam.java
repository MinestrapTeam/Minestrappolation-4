package minestrapteam.minestrappolation.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ItemAmuletVaccam extends ItemAmulet
{
	public ItemAmuletVaccam()
	{
		super(50);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase entity, EntityLivingBase attacker)
	{
		if (!entity.worldObj.isRemote && attacker instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) attacker;
			entity.attackEntityFrom(DamageSource.generic, 1.0F);
			player.onCriticalHit(entity);
			stack.damageItem(1, player);
		}
		
		return true;
	}
}