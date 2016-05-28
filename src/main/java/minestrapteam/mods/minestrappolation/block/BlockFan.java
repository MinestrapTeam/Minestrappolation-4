package minestrapteam.mods.minestrappolation.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockFan extends MBlock
{
	public BlockFan(int rate, Material material, MapColor mapColor)
	{
		super(material, mapColor);
		this.setTickRandomly(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.randomDisplayTick(worldIn, pos, state, rand);
		worldIn.spawnParticle(EnumParticleTypes.CLOUD, true, (double) ((float) pos.getX() + rand.nextFloat()),
		                      (double) ((float) pos.getY() + 1.1F), (double) ((float) pos.getZ() + rand.nextFloat()),
		                      0.0D, 0.3D, 0.0D);
		worldIn.spawnParticle(EnumParticleTypes.CLOUD, false, (double) ((float) pos.getX() + rand.nextFloat()),
		                      (double) ((float) pos.getY() + 1.1F), (double) ((float) pos.getZ() + rand.nextFloat()),
		                      0.0D, 0.3D, 0.0D);
	}
}
