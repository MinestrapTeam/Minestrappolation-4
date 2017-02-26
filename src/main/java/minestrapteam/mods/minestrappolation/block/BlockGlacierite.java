package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlacierite extends MBlock
{
	
	public BlockGlacierite(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.setTickRandomly(true);
		this.slipperiness = 0.99F;
	}
	
	@Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)    
	{
		this.updateTick(worldIn, pos, state, worldIn.rand);
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}
	
	@Override
    public void randomDisplayTick(IBlockState stateIn, World world, BlockPos pos, Random random)
	{
		for (int var5 = 0; var5 < 3; ++var5)
		{
			float x1 = pos.getX() + 0.5F;
			float y1 = pos.getY() + random.nextFloat();
			float z1 = pos.getZ() + 0.5F;
			float f = random.nextFloat() * 0.6F - 0.3F;
			float x2 = x1 + f;
			float z2 = z1 + f;
			
			world.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, x1 - 0.52F, y1, z2, 0.01D * (1 - random.nextInt(3)) * random.nextInt(5), 0.1D, 0.01D * (1 - random.nextInt(3)) * random.nextInt(5), new int[10]);
			world.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, x1 + 0.52F, y1, z2, 0.01D * (1 - random.nextInt(3)) * random.nextInt(5), 0.1D, 0.01D * (1 - random.nextInt(3)) * random.nextInt(5), new int[400]);
			world.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, x2, y1, z1 - 0.52F, 0.01D * (1 - random.nextInt(3)) * random.nextInt(5), 0.1D, 0.01D * (1 - random.nextInt(3)) * random.nextInt(5), new int[50]);
			world.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, x2, y1, z1 + 0.52F, 0.01D * (1 - random.nextInt(3)) * random.nextInt(5), 0.1D, 0.01D * (1 - random.nextInt(3)) * random.nextInt(5), new int[0]);
		}
	}	
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
	{
		return true;
	}
}
