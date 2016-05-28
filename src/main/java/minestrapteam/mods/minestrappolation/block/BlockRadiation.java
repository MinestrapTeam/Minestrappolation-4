package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.block.ore.MBlockOre;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.util.PlayerHelper;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public abstract class BlockRadiation extends MBlockOre
{

	int range;
	int effectRate;

	public BlockRadiation(int range, int rate, Material material, MapColor mapColor, Item itemDrop, int expMin, int expMax, int dropAmount, int bonusAmount, String tool, int level, boolean silkHarvest)
	{
		super(material, mapColor, itemDrop, expMin, expMax, dropAmount, bonusAmount, tool, level, silkHarvest);
		this.range = range;
		this.effectRate = rate;
		this.setTickRandomly(true);
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		this.updateTick(world, pos, state, world.rand);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		if (!world.isRemote && Config.radiationEffects == true)
		{
			world.scheduleUpdate(pos, this, this.effectRate);
			AxisAlignedBB axisalignedbb = this.getCollisionBoundingBox(world, pos, state)
			                                  .expand(this.range, this.range, this.range);
			List<EntityLivingBase> list = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

			for (EntityLivingBase living : list)
			{
				if (living instanceof EntityPlayer)
				{
					if (!PlayerHelper.hasArmorSet((EntityPlayer) living, MItems.rad_helmet, MItems.rad_chestplate,
					                              MItems.rad_leggings, MItems.rad_boots))
					{
						this.addPotionEffect(living, world, pos);
					}
				}
				else
				{
					this.addPotionEffect(living, world, pos);
				}
			}
		}
	}

	public abstract void addPotionEffect(EntityLivingBase living, World world, BlockPos pos);
}
