package minestrapteam.mods.minestrappolation.block;

import java.util.List;
import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockShrubGrass extends BlockBush implements IGrowable, net.minecraftforge.common.IShearable
{
	public BlockShrubGrass(SoundType sound)
    {
        float f = 0.4F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.8F, 0.5F + f);
        this.blockSoundType=sound;
    }

	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
		return this.canPlaceBlockOn(worldIn.getBlockState(pos.down()).getBlock());
    }
	
	@Override
	protected boolean canPlaceBlockOn(Block ground)
    {
        return ground == MBlocks.dirt_permafrost || ground == MBlocks.lichen_permafrost;
    }
	
	public boolean isReplaceable(World worldIn, BlockPos pos)
    {
        return true;
    }
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return MBlocks.celery_seed;
    }
	
	public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if(random.nextInt(Config.celerySeedChance - fortune) == 1)
        	return 1;
        else
        	return 0;
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
        ret.add(new ItemStack(this, 1));
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
	}
}
