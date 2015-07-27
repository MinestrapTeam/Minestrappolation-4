package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockRadiationInsulated extends BlockRadiation
{
	
	public BlockRadiationInsulated(int range, int rate, Material material, MapColor mapColor, Item itemDrop, int expMin, int expMax, int dropAmount, int bonusAmount, String tool, int level, boolean silkHarvest)
	{
		super(range, rate, material, mapColor, itemDrop, expMin, expMax, dropAmount, bonusAmount, tool, level, silkHarvest);
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase living, World world, BlockPos pos)
	{
		if (world.isBlockPowered(pos))
		{
			this.range = world.isBlockIndirectlyGettingPowered(pos);
			if (this == MBlocks.plutonium_insulated)
			{
				if (living instanceof EntitySkeleton)
				{
					living.addPotionEffect(new PotionEffect(Potion.resistance.getId(), 20 * 6, 2, false, false));
					living.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 20 * 6, 1, false, false));
				}
				else
				{
					living.addPotionEffect(new PotionEffect(Potion.wither.getId(), 20 * 2, 1, false, false));
				}
			}
			
			if (this == MBlocks.uranium_insulated)
			{
				if (living instanceof EntityZombie)
				{
					living.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), 20 * 6, 2, false, false));
					living.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), 20 * 6, 1, false, false));
				}
				else
				{
					living.addPotionEffect(new PotionEffect(Potion.poison.getId(), 20 * 10, 1, false, false));
				}
			}
		}
	}
	
}
