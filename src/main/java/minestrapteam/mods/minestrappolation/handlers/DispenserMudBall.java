package minestrapteam.mods.minestrappolation.handlers;

import minestrapteam.mods.minestrappolation.entity.EntityIceball;
import minestrapteam.mods.minestrappolation.entity.EntityMudBall;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DispenserMudBall extends BehaviorProjectileDispense{

	@Override
	protected IProjectile getProjectileEntity(World worldIn, IPosition pos, ItemStack stackIn)
	{
		return new EntityMudBall(worldIn, pos.getX(), pos.getY(), pos.getZ());
	}

}
