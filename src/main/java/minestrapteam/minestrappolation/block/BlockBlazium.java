package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.util.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class BlockBlazium extends MBlock
{
	
	public BlockBlazium(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.setTickRandomly(true);
	}
	
	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	{
		this.updateTick(worldIn, pos, state, worldIn.rand);
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}
	
	@Override
	public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random random)
	{
		for (int var5 = 0; var5 < 3; ++var5)
		{
			float x1 = pos.getX() + 0.5F;
			float y1 = pos.getY() + random.nextFloat();
			float z1 = pos.getZ() + 0.5F;
			float f = random.nextFloat() * 0.6F - 0.3F;
			float x2 = x1 + f;
			float z2 = z1 + f;
			
			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x1 - 0.52F, y1, z2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.FLAME, x1 - 0.52F, y1, z2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x1 + 0.52F, y1, z2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.FLAME, x1 + 0.52F, y1, z2, 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x2, y1, z1 - 0.52F, 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.FLAME, x2, y1, z1 - 0.52F, 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, x2, y1, z1 + 0.52F, 0.0D, 0.0D, 0.0D);
			world.spawnParticle(EnumParticleTypes.FLAME, x2, y1, z1 + 0.52F, 0.0D, 0.0D, 0.0D);
		}
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (Config.blaziumFireEffect)
		{
			int i = rand.nextInt(3);
			if (i > 0)
			{
				BlockPos blockpos1 = pos;
				
				for (int j = 0; j < i; ++j)
				{
					blockpos1 = blockpos1.add(rand.nextInt(3) - 1, 1, rand.nextInt(3) - 1);
					Block block = worldIn.getBlockState(blockpos1).getBlock();
					
					if (block.getMaterial() == Material.air)
					{
						if (this.isSurroundingBlockFlammable(worldIn, blockpos1))
						{
							worldIn.setBlockState(blockpos1, Blocks.fire.getDefaultState());
							return;
						}
					}
					else if (block.getMaterial().blocksMovement())
						return;
				}
			}
			else
			{
				for (int k = 0; k < 3; ++k)
				{
					BlockPos blockpos2 = pos.add(rand.nextInt(3) - 1, 0, rand.nextInt(3) - 1);
					
					if (worldIn.isAirBlock(blockpos2.up()) && this.getCanBlockBurn(worldIn, blockpos2))
					{
						worldIn.setBlockState(blockpos2.up(), Blocks.fire.getDefaultState());
					}
				}
			}
		}
	}
	
	protected boolean isSurroundingBlockFlammable(World worldIn, BlockPos pos)
	{
		EnumFacing[] aenumfacing = EnumFacing.values();
		int i = aenumfacing.length;
		
		for (int j = 0; j < i; ++j)
		{
			EnumFacing enumfacing = aenumfacing[j];
			
			if (this.getCanBlockBurn(worldIn, pos.offset(enumfacing)))
				return true;
		}
		
		return false;
	}
	
	private boolean getCanBlockBurn(World worldIn, BlockPos p_176368_2_)
	{
		return worldIn.getBlockState(p_176368_2_).getBlock().getMaterial().getCanBurn();
	}
	
}
