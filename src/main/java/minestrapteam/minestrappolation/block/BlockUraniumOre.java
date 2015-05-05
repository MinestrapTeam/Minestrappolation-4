package minestrapteam.minestrappolation.block;


import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockUraniumOre extends BlockRadiation
{
	public BlockUraniumOre(Material material, int range, int rate)
	{
		super(material, range, rate);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1 + random.nextInt(2);
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase living)
	{
		if (living instanceof EntityZombie)
		{
			living.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 180, 1, false, false));
			living.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 180, 0, false, false));
		}
		else
		{
			living.addPotionEffect(new PotionEffect(Potion.poison.getId(), 200, 0, false, false));
		}
	}
	
	
	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
	{
		return 5 + fortune;
	}
	
	
	@Override
	public void onBlockDestroyedByExplosion(World world, BlockPos pos, Explosion explosion)
	{
		world.createExplosion(null, 2.0, 2.0, 2.0, 4F, true);
	}
}