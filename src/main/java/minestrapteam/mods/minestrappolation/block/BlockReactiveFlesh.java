package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockReactiveFlesh extends BlockFlesh
{

	public BlockReactiveFlesh(Material materialIn, MapColor mapColorIn) 
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
			/*float x1 = pos.getX() + 0.5F;
			float y1 = pos.getY() + random.nextFloat();
			float z1 = pos.getZ() + 0.5F;
			float f = random.nextFloat() * 0.6F - 0.3F;
			float x2 = x1 + f;
			float z2 = z1 + f;*/
			
			double d0 = world.rand.nextGaussian() * 0.02D;
            double d1 = world.rand.nextGaussian() * 0.02D;
            double d2 = world.rand.nextGaussian() * 0.02D;
            world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, (double)((float)pos.getX() + world.rand.nextFloat()), (double)pos.getY() + (double)world.rand.nextFloat() * 1.0f, (double)((float)pos.getZ() + world.rand.nextFloat()), d0, d1, d2, new int[0]);
		}
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(worldIn.isRemote)
		{
			return true;
		}
		if(playerIn.getCurrentEquippedItem().getItem() == MItems.cow_gene_sample)
		{
			if(playerIn.getCurrentEquippedItem().stackSize > 1)
			{
				playerIn.getCurrentEquippedItem().stackSize--;
				worldIn.setBlockState(pos, MBlocks.block_cow.getDefaultState());
				return true;
			}
			else
			{
				playerIn.destroyCurrentEquippedItem();
				worldIn.setBlockState(pos, MBlocks.block_cow.getDefaultState());
				return true;
			}			
		}
		if(playerIn.getCurrentEquippedItem().getItem() == MItems.chicken_gene_sample)
		{
			if(playerIn.getCurrentEquippedItem().stackSize > 1)
			{
				playerIn.getCurrentEquippedItem().stackSize--;
				worldIn.setBlockState(pos, MBlocks.block_chicken.getDefaultState());
				return true;
			}
			else
			{
				playerIn.destroyCurrentEquippedItem();
				worldIn.setBlockState(pos, MBlocks.block_chicken.getDefaultState());
				return true;
			}			
		}
		if(playerIn.getCurrentEquippedItem().getItem() == MItems.wolf_gene_sample)
		{
			if(playerIn.getCurrentEquippedItem().stackSize > 1)
			{
				playerIn.getCurrentEquippedItem().stackSize--;
				worldIn.setBlockState(pos, MBlocks.block_wolf.getDefaultState());
				return true;
			}
			else
			{
				playerIn.destroyCurrentEquippedItem();
				worldIn.setBlockState(pos, MBlocks.block_wolf.getDefaultState());
				return true;
			}			
		}
		return false;
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(MBlocks.block_flesh);
    }
	
	public boolean canSilkHarvest()
	{
		return false;
	}
}
