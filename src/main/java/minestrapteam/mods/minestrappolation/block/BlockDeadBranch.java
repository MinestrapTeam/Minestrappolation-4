package minestrapteam.mods.minestrappolation.block;

import java.util.List;
import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDeadBranch extends MBlock implements IGrowable, net.minecraftforge.common.IShearable
{	
	public BlockDeadBranch(Material materialIn, MapColor mapColorIn, SoundType sound)
	{
		super(materialIn, mapColorIn, sound);
	}
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }
	
	@Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
	{
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Items.STICK;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(5);
	}
	
	@Override
	protected boolean canSilkHarvest()
	{
		return true;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
	{
		return true;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) 
	{
		List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
        ret.add(new ItemStack(MBlocks.dead_branch, 1));
        return ret;
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) 
	{
		return false;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		return false;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) 
	{
		//nah fam
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{
		this.dropBlockAsItem(worldIn, pos, this.getDefaultState(), 1);
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return 1200;
	}
}
