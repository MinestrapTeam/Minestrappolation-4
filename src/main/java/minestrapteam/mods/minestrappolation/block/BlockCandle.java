package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCandle extends MBlock
{

	public boolean lit;
	public BlockCandle(Material materialIn, MapColor mapColorIn, boolean lit) 
	{
		super(materialIn, mapColorIn);
		this.lit = lit;
		if(lit)
		{
			this.setLightLevel(.5F);
		}
		else
		{
			this.setLightLevel(0F);
		}
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
	    if(playerIn.getHeldItem().getItem() == Items.flint_and_steel)
	    {
	    	worldIn.setBlockState(pos, MBlocks.candle_lit.getDefaultState());
	    }
		return true;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (this.lit)
		{
			double d0 = pos.getX() + 0.5D;
			double d1 = pos.getY() + 0.5D;
			double d2 = pos.getZ() + 0.5D;
			double d3 = 0D;
			
			worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 - d3, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
		}
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

}
