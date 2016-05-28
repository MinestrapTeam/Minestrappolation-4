package minestrapteam.mods.minestrappolation.entity;

import minestrapteam.mods.minestrappolation.block.machines.BlockFrostGenerator;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityIceball extends EntityFireball implements IProjectile
{
	public EntityIceball(World worldIn)
	{
		super(worldIn);
		this.setSize(0.3125F, 0.3125F);
	}

	public EntityIceball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ)
	{
		super(worldIn, shooter, accelX, accelY, accelZ);
		this.setSize(0.3125F, 0.3125F);
	}

	public EntityIceball(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ)
	{
		super(worldIn, x, y, z, accelX, accelY, accelZ);
		this.setSize(0.3125F, 0.3125F);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		this.extinguish();
	}

	@Override
	protected void onImpact(MovingObjectPosition movingObject)
	{
		if (!this.worldObj.isRemote)
		{
			boolean flag;

			if (movingObject.entityHit != null)
			{
				flag = movingObject.entityHit
					       .attackEntityFrom(DamageSource.causeThrownDamage(this, this.shootingEntity), 10.0F);

				if (flag)
				{
					this.applyEnchantments(this.shootingEntity, movingObject.entityHit);

					movingObject.entityHit.extinguish();
					if (movingObject.entityHit instanceof EntityLiving
						    || movingObject.entityHit instanceof EntityPlayer)
						((EntityLivingBase) movingObject.entityHit)
							.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10 * 20, 10));
				}
			}
			else
			{
				flag = true;

				if (this.shootingEntity instanceof EntityLiving)
				{
					flag = this.worldObj.getGameRules().getBoolean("mobGriefing");
				}

				if (flag)
				{
					BlockPos blockpos = movingObject.getBlockPos();

					if (BlockFrostGenerator.canFreeze.containsKey(this.worldObj.getBlockState(blockpos)))
					{
						this.worldObj.setBlockState(blockpos, BlockFrostGenerator.canFreeze
							                                      .get(this.worldObj.getBlockState(blockpos)));
					}
				}
			}

			this.setDead();
		}
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		return false;
	}

	@Override
	public void setThrowableHeading(double x, double y, double z, float velocity, float inaccuracy)
	{
	}
}
