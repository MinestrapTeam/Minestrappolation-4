package minestrapteam.mods.minestrappolation.block.machines;

import minestrapteam.mods.minestrappolation.block.MBlock;
import minestrapteam.mods.minestrappolation.enumtypes.MWoodType;
import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Random;

public class BlockFrostGenerator extends MBlock
{

	public static HashMap<IBlockState, IBlockState> canFreeze = new HashMap<IBlockState, IBlockState>();

	int range = 8;

	public BlockFrostGenerator(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.setTickRandomly(true);
		this.createFreezeMap();
	}

	public void createFreezeMap()
	{
		canFreeze.put(Blocks.water.getDefaultState(), Blocks.ice.getDefaultState());
		canFreeze.put(Blocks.snow.getDefaultState(), MBlocks.snow_refined.getDefaultState());
		canFreeze.put(MBlocks.snow_bricks.getDefaultState(), MBlocks.snow_tiles.getDefaultState());
		canFreeze.put(MBlocks.snow_refined.getDefaultState(), Blocks.ice.getDefaultState());
		canFreeze.put(MBlocks.snow_tiles.getDefaultState(), Blocks.ice.getDefaultState());
		canFreeze.put(Blocks.ice.getDefaultState(), Blocks.packed_ice.getDefaultState());
		for (int i = 0; i < 16; i++)
		{
			if (i < 14)
				canFreeze.put(Blocks.snow_layer.getStateFromMeta(i), Blocks.snow_layer.getStateFromMeta(i + 1));
			else
				canFreeze.put(Blocks.snow_layer.getStateFromMeta(15), Blocks.snow.getDefaultState());
		}

		canFreeze.put(Blocks.fire.getDefaultState(), Blocks.air.getDefaultState());
		canFreeze.put(Blocks.lava.getDefaultState(), Blocks.obsidian.getDefaultState());

		for (int i = 0; i < 16; i++)
		{
			canFreeze.put(Blocks.tallgrass.getStateFromMeta(i), MBlocks.shrub_grass.getDefaultState());
		}
		canFreeze.put(Blocks.deadbush.getDefaultState(), Blocks.air.getDefaultState());
		for (int i = 0; i < 16; i++)
		{
			canFreeze.put(Blocks.red_flower.getStateFromMeta(i), Blocks.deadbush.getDefaultState());
		}
		for (int i = 0; i < 16; i++)
		{
			canFreeze.put(Blocks.double_plant.getStateFromMeta(i), Blocks.deadbush.getDefaultState());
		}
		canFreeze.put(Blocks.yellow_flower.getDefaultState(), Blocks.deadbush.getDefaultState());
		canFreeze.put(Blocks.red_mushroom.getDefaultState(), Blocks.air.getDefaultState());
		canFreeze.put(Blocks.brown_mushroom.getDefaultState(), Blocks.air.getDefaultState());
		canFreeze.put(Blocks.reeds.getDefaultState(), Blocks.air.getDefaultState());
		for (int i = 0; i < 16; i++)
		{
			canFreeze.put(Blocks.vine.getStateFromMeta(i), Blocks.air.getDefaultState());
		}
		canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.ACACIA.getMetadata()),
		                   Blocks.deadbush.getDefaultState());
		canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.OAK.getMetadata()),
		                   MBlocks.ministrapp_sapling.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.DARK_OAK.getMetadata()),
		                   MBlocks.ministrapp_sapling.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()),
		                   Blocks.deadbush.getDefaultState());
		canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.JUNGLE.getMetadata()),
		                   Blocks.deadbush.getDefaultState());
		canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.BIRCH.getMetadata()),
		                   Blocks.deadbush.getDefaultState());
		canFreeze.put(Blocks.cactus.getDefaultState(), Blocks.snow.getDefaultState());
		canFreeze.put(Blocks.lit_pumpkin.getStateFromMeta(0), Blocks.pumpkin.getStateFromMeta(0));
		canFreeze.put(Blocks.lit_pumpkin.getStateFromMeta(1), Blocks.pumpkin.getStateFromMeta(1));
		canFreeze.put(Blocks.lit_pumpkin.getStateFromMeta(2), Blocks.pumpkin.getStateFromMeta(2));
		canFreeze.put(Blocks.lit_pumpkin.getStateFromMeta(3), Blocks.pumpkin.getStateFromMeta(3));
		for (int i = 0; i < 16; i++)
		{
			canFreeze.put(Blocks.pumpkin.getStateFromMeta(i), Blocks.snow.getDefaultState());
		}
		canFreeze.put(Blocks.melon_block.getDefaultState(), Blocks.snow.getDefaultState());

		canFreeze.put(Blocks.log.getStateFromMeta(BlockPlanks.EnumType.OAK.getMetadata()),
		                   MBlocks.ministrapp_log.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		canFreeze.put(Blocks.log2.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()),
		                   MBlocks.ministrapp_log.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		canFreeze.put(Blocks.leaves.getStateFromMeta(BlockPlanks.EnumType.OAK.getMetadata()),
		                   MBlocks.ministrapp_leaves.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		canFreeze.put(Blocks.leaves.getStateFromMeta(BlockPlanks.EnumType.BIRCH.getMetadata()),
		                   MBlocks.dead_branch.getDefaultState());
		canFreeze.put(Blocks.leaves.getStateFromMeta(BlockPlanks.EnumType.JUNGLE.getMetadata()),
		                   MBlocks.dead_branch.getDefaultState());
		canFreeze.put(Blocks.leaves2.getStateFromMeta(BlockPlanks.EnumType.OAK.getMetadata()),
		                   MBlocks.dead_branch.getDefaultState());
		canFreeze.put(Blocks.leaves2.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()),
		                   MBlocks.ministrapp_leaves.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		for (int i = 0; i < 16; i++)
		{
			canFreeze.put(Blocks.red_mushroom_block.getStateFromMeta(i), Blocks.snow.getDefaultState());
		}
		for (int i = 0; i < 16; i++)
		{
			canFreeze.put(Blocks.brown_mushroom_block.getStateFromMeta(i), Blocks.snow.getDefaultState());
		}

		canFreeze.put(Blocks.sand.getDefaultState(), MBlocks.cold_sand.getDefaultState());
		canFreeze.put(Blocks.sand.getStateFromMeta(BlockSand.EnumType.RED_SAND.getMetadata()),
		                   MBlocks.cold_sand.getStateFromMeta(BlockSand.EnumType.RED_SAND.getMetadata()));
		canFreeze.put(Blocks.grass.getDefaultState(), MBlocks.lichen_permafrost.getDefaultState());
		canFreeze.put(Blocks.mycelium.getDefaultState(), MBlocks.lichen_permafrost.getDefaultState());
		canFreeze.put(Blocks.dirt.getStateFromMeta(BlockDirt.DirtType.DIRT.getMetadata()),
		                   MBlocks.dirt_permafrost.getDefaultState());
		canFreeze.put(Blocks.dirt.getStateFromMeta(BlockDirt.DirtType.COARSE_DIRT.getMetadata()),
		                   MBlocks.dirt_permafrost.getDefaultState());
		canFreeze.put(Blocks.dirt.getStateFromMeta(BlockDirt.DirtType.PODZOL.getMetadata()),
		                   MBlocks.lichen_permafrost.getDefaultState());
		for (int i = 0; i < 16; i++)
		{
			canFreeze.put(Blocks.farmland.getStateFromMeta(i), MBlocks.dirt_permafrost.getDefaultState());
		}

		canFreeze.put(Blocks.sponge.getStateFromMeta(1), Blocks.snow.getDefaultState());
		canFreeze.put(Blocks.web.getDefaultState(), MBlocks.cold_cobweb.getDefaultState());
	}

	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		this.updateTick(world, pos, state, world.rand);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		if (placer instanceof EntityPlayer)
			((EntityPlayer) placer).addStat(MAchievements.frost_gen, 1);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		world.scheduleUpdate(pos, this, 100);
		if (world.isBlockPowered(pos))
		{
			for (int x = -this.range; x < this.range; x++)
			{
				for (int y = (int) (-this.range + (Math.abs(this.range) - Math.sqrt(
					(this.range * this.range) - (x * x)))); y <= (int) (this.range - (Math.abs(this.range) - Math.sqrt(
					(this.range * this.range) - (x * x)))); y++)
				{
					for (int z = (int) (-this.range + (Math.abs(this.range) - Math.sqrt(
						(this.range * this.range) - (x * x)))); z <= (int) (this.range - (Math.abs(this.range) - Math.sqrt(
						     (this.range * this.range) - (x * x)))); z++)
					{
						int s = rand.nextInt(500);
						for (int i = -this.range; i < this.range; i++)
						{
							if (s < 1 && world.getBlockState(pos.add(x, i, z)) == Blocks.air.getDefaultState()
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.air.getDefaultState()
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(0)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(1)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(2)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(3)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(4)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(5)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(6)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(7)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(8)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(9)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(10)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(11)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(12)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(13)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(14)
								    && world.getBlockState(pos.add(x, i - 1, z)) != Blocks.snow_layer
									                                                    .getStateFromMeta(15))
							{
								world.setBlockState(pos.add(x, i, z), Blocks.snow_layer.getDefaultState(), 2);
							}
						}

						if (canFreeze.containsKey(world.getBlockState(pos.add(x, y, z))))
						{
							int i = rand.nextInt(5);
							if (i < 1)
							{
								world.setBlockState(pos.add(x, y, z),
								                    canFreeze.get(world.getBlockState(pos.add(x, y, z))), 2);
							}
						}
					}
				}
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.SOLID;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return 3;
	}
}
