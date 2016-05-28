package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockBat extends BlockFlesh
{
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);

	public BlockBat(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0));
		this.setTickRandomly(true);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		int j = state.getValue(AGE).intValue();
		if (j < 3)
		{
			int chance = rand.nextInt(Config.bushGrowChance);
			if (chance == 1)
			{
				worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 2);
			}
		}
		else if (j == 3)
		{
			double xRand = pos.getX();
			double yRand = pos.getY();
			double zRand = pos.getZ();
			BlockPos pos1 = new BlockPos(xRand, yRand, zRand);
			while (!worldIn.isAirBlock(pos1))
			{
				xRand = pos.getX() + (rand.nextInt(6) / (1 + rand.nextInt(3))) * (1 - (rand.nextInt(3)));
				yRand = pos.getY() + (rand.nextInt(6) / (1 + rand.nextInt(3))) * (1 - (rand.nextInt(3)));
				zRand = pos.getZ() + (rand.nextInt(6) / (1 + rand.nextInt(3))) * (1 - (rand.nextInt(3)));
				pos1 = new BlockPos(xRand, yRand, zRand);
			}
			worldIn.setBlockState(pos, this.getDefaultState(), 2);
			EntityItem ei = new EntityItem(worldIn, xRand, yRand, zRand, new ItemStack(MItems.guano, 1));
			worldIn.spawnEntityInWorld(ei);
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(AGE);
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, AGE);
	}
}
