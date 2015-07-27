package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
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
		if (BlockUtil.isBlockBelow(worldIn, pos, Blocks.fire, 15) || BlockUtil.isBlockBelow(worldIn, pos, Blocks.lava, 15) || BlockUtil.isBlockBelow(worldIn, pos, Blocks.flowing_lava, 15) || BlockUtil.isBlockBelow(worldIn, pos, Blocks.lit_furnace, 15) || BlockUtil.isBlockBelow(worldIn, pos, MBlocks.magma, 15) || BlockUtil.isBlockBelow(worldIn, pos, MBlocks.alloy_active, 15) || BlockUtil.isBlockBelow(worldIn, pos, MBlocks.melter_active, 15) || BlockUtil.isBlockBelow(worldIn, pos, MBlocks.blazium_block, 15))
		{
			super.randomDisplayTick(worldIn, pos, state, rand);
		    worldIn.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, true, (double)((float)pos.getX() + rand.nextFloat()), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ() + rand.nextFloat()), 0.0D, 0.3D, 0.0D, new int[0]);
		    worldIn.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, false, (double)((float)pos.getX() + rand.nextFloat()), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ() + rand.nextFloat()), 0.0D, 0.3D, 0.0D, new int[0]);
		    worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)((float)pos.getX() + rand.nextFloat()), (double)((float)pos.getY() + 1.1F), (double)((float)pos.getZ() + rand.nextFloat()), 0.0D, 0.3D, 0.0D, new int[0]);
		}
	}

}
