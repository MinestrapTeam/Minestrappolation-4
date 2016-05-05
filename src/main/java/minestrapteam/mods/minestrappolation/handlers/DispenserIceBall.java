package minestrapteam.mods.minestrappolation.handlers;

import minestrapteam.mods.minestrappolation.entity.EntityIceball;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

public class DispenserIceBall extends BehaviorProjectileDispense
{

	@Override
	protected IProjectile getProjectileEntity(World worldIn, IPosition pos)
	{
		return new EntityIceball(worldIn, pos.getX(), pos.getY(), pos.getZ(), 0, 0, 0.1);
	}
}
