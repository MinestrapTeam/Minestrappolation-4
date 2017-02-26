package minestrapteam.mods.minestrappolation.entity;

import java.util.List;

import minestrapteam.mods.minestrappolation.block.machines.BlockFrostGenerator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
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

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.extinguish();
    }
    
    /**
     * Called when this EntityIceball hits a block or entity.
     */
    protected void onImpact(RayTraceResult movingObject)
    {
        if (!this.world.isRemote)
        {
            boolean flag;

            if (movingObject.entityHit != null)
            {
                flag = movingObject.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.shootingEntity), 10.0F);

                if (flag)
                {
                    this.applyEnchantments(this.shootingEntity, movingObject.entityHit);

                    movingObject.entityHit.extinguish();
                    if(movingObject.entityHit instanceof EntityLiving || movingObject.entityHit instanceof EntityPlayer)
                    	((EntityLivingBase) movingObject.entityHit).addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("slowness"), 10 * 20, 10));
                }
            }
            else
            {
                flag = true;

                if (this.shootingEntity != null && this.shootingEntity instanceof EntityLiving)
                {
                    flag = this.world.getGameRules().getBoolean("mobGriefing");               
                }

                if (flag)
                {
                    BlockPos blockpos = movingObject.getBlockPos();

                    if(BlockFrostGenerator.canFreeze.containsKey(this.world.getBlockState(blockpos)))
    				{
    					this.world.setBlockState(blockpos, BlockFrostGenerator.canFreeze.get(this.world.getBlockState(blockpos)));
    				}
                }
            }

            this.setDead();
        }
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return false;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        return false;
    }

	@Override
	public void setThrowableHeading(double x, double y, double z, float velocity, float inaccuracy) 
	{
	}
}