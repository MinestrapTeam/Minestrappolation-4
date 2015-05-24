package minestrapteam.minestrappolation.block;

import java.util.HashMap;
import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFrostGenerator extends MBlock
{
	
	public HashMap<IBlockState, IBlockState>	canFreeze	= new HashMap<IBlockState, IBlockState>();
	
	int											range		= 5;
	
	public BlockFrostGenerator(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.setTickRandomly(true);
		this.createFreezeMap();
	}
	
	public void createFreezeMap()
	{
		this.canFreeze.put(Blocks.water.getDefaultState(), Blocks.ice.getDefaultState());
		this.canFreeze.put(Blocks.snow.getDefaultState(), Blocks.ice.getDefaultState());
		this.canFreeze.put(Blocks.lava.getDefaultState(), Blocks.obsidian.getDefaultState());
		this.canFreeze.put(Blocks.tallgrass.getStateFromMeta(BlockTallGrass.EnumType.GRASS.getMeta()), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.tallgrass.getStateFromMeta(BlockTallGrass.EnumType.FERN.getMeta()), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.tallgrass.getStateFromMeta(BlockTallGrass.EnumType.DEAD_BUSH.getMeta()), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.fire.getDefaultState(), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.ACACIA.getMetadata()), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.OAK.getMetadata()), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.DARK_OAK.getMetadata()), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.JUNGLE.getMetadata()), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.BIRCH.getMetadata()), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.cactus.getDefaultState(), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.sand.getDefaultState(), MBlocks.cold_sand.getDefaultState());
		this.canFreeze.put(Blocks.sand.getStateFromMeta(BlockSand.EnumType.RED_SAND.getMetadata()), MBlocks.cold_sand.getStateFromMeta(BlockSand.EnumType.RED_SAND.getMetadata()));
		this.canFreeze.put(Blocks.grass.getDefaultState(), MBlocks.lichen_permafrost.getDefaultState());
		this.canFreeze.put(Blocks.mycelium.getDefaultState(), MBlocks.lichen_permafrost.getDefaultState());
		this.canFreeze.put(Blocks.dirt.getStateFromMeta(BlockDirt.DirtType.PODZOL.getMetadata()), MBlocks.lichen_permafrost.getDefaultState());
	}
	
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state)
	{
		this.updateTick(world, pos, state, world.rand);
	}
	
	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
	{
		world.scheduleUpdate(pos, this, 20);
		if (world.isBlockPowered(pos))
		{
			for (int x = -this.range; x < this.range; x++)
			{
				for (int y = -this.range; y < this.range; y++)
				{
					for (int z = -this.range; z < this.range; z++)
					{
						int s = rand.nextInt(50);
						if (s < 1 && world.getBlockState(pos.add(x, 0, z)) == Blocks.air.getDefaultState() && world.getBlockState(pos.add(x, -1, z)) != Blocks.air.getDefaultState())
						{
							world.setBlockState(pos.add(x, 0, z), Blocks.snow_layer.getDefaultState(), 2);
						}
						
						if (this.canFreeze.containsKey(world.getBlockState(pos.add(x, y, z))))
						{
							int i = rand.nextInt(5);
							if (i < 1)
							{
								world.setBlockState(pos.add(x, y, z), this.canFreeze.get(world.getBlockState(pos.add(x, y, z))), 2);
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
