package minestrapteam.mods.minestrappolation.block.ore;

import minestrapteam.mods.minestrappolation.block.BlockRadiation;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlutoniumOre extends BlockRadiation
{
	public BlockPlutoniumOre(int range, int rate, Material material, MapColor mapColor, Item itemDrop, int expMin, int expMax, int dropAmount, int bonusAmount, String tool, int level, boolean silkHarvest)
	{
		super(range, rate, material, mapColor, itemDrop, expMin, expMax, dropAmount, bonusAmount, tool, level, silkHarvest);
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase living, World world, BlockPos pos)
	{
		if (living instanceof EntitySkeleton)
		{
			living.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 20 * 6, 1, false, false));
			living.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 20 * 6, 0, false, false));
		}
		else
		{
			living.addPotionEffect(new PotionEffect(Potion.wither.getId(), 20 * 2, 0, false, false));
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