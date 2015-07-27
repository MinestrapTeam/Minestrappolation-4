package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.util.BlockUtil;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockChimney extends MBlock
{

	public BlockChimney(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn, mapColorIn);
		this.setTickRandomly(true);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (BlockUtil.isBlockBelow(worldIn, pos, Blocks.fire, 10))
		{
			super.randomDisplayTick(worldIn, pos, state, rand);
		    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, (double)((float)pos.getX() + rand.nextFloat()), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ() + rand.nextFloat()), 0.0D, 0.3D, 0.0D, new int[0]);
		    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, false, (double)((float)pos.getX() + rand.nextFloat()), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ() + rand.nextFloat()), 0.0D, 0.3D, 0.0D, new int[0]);
		}
	}

}
