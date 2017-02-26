package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCandle extends Block
{
	public boolean isLit;
	public boolean isUnholy;
	
	public BlockCandle(Material materialIn, boolean lit, boolean unholy)
	{
		super(materialIn);
		isLit = lit;
		isUnholy = unholy;
	}
	
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		float f = 0.0625F;
		return new AxisAlignedBB(pos.getX() + (6 * f), pos.getY(), pos.getZ() + (6 * f), pos.getX() + 1 - (6 * f), pos.getY() + 1 - (10 * f), pos.getZ() + 1 - (6 * f));
	}
	
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }
    
	@Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        if(worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true) || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.OAK_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.DARK_OAK_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.BIRCH_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.SPRUCE_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.JUNGLE_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.ACACIA_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.redwood_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.frozen_oak_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.COBBLESTONE_WALL || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.NETHER_BRICK_FENCE)
        	return true;
        else
        	return false;
    }
    
	@Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
    	if (!this.canBlockStay(worldIn, pos, EnumFacing.DOWN))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }

        super.neighborChanged(state, worldIn, pos,blockIn, fromPos);
    }
    
    public boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing)
    {
        if(worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true) || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.OAK_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.DARK_OAK_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.BIRCH_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.SPRUCE_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.JUNGLE_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.ACACIA_FENCE || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.redwood_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.frozen_oak_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.COBBLESTONE_WALL || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.NETHER_BRICK_FENCE)
    		return true;
    	else
    		return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
    	if(this.isLit == true)
    	{
    		if(isUnholy == false)
    		{
    			double d0 = (double)pos.getX() + 0.5D;
    			double d1 = (double)pos.getY() + 0.5D;
    			double d2 = (double)pos.getZ() + 0.5D;
    			double d3 = 0.22D;
    			double d4 = 0.27D;

    			worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    		}
    		else
    		{
    			double d0 = (double)pos.getX() + 0.5D;
    			double d1 = (double)pos.getY() + 0.5D;
    			double d2 = (double)pos.getZ() + 0.5D;
    			double d3 = 0.22D;
    			double d4 = 0.27D;

    			worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, 1.0D, 0.0D, 1.0D, new int[0]);
    		}
    	}
    }
    
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(MBlocks.candle);
    }
	
	public boolean canSilkHarvest()
	{
		return false;
	}
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(worldIn.isRemote)
		{
			return true;
		}
		if(this.isLit == false && (playerIn.getHeldItemMainhand() != null) && (playerIn.getHeldItemMainhand().getItem() == Items.FLINT_AND_STEEL || playerIn.getHeldItemMainhand().getItem() == MItems.fire_axe  || playerIn.getHeldItemMainhand().getItem() == MItems.fire_hoe || playerIn.getHeldItemMainhand().getItem() == MItems.fire_pickaxe || playerIn.getHeldItemMainhand().getItem() == MItems.fire_shovel || playerIn.getHeldItemMainhand().getItem() == MItems.fire_sword || playerIn.getHeldItemMainhand().getItem() == Items.FIRE_CHARGE))
		{
			if((playerIn.getHeldItemMainhand().getItemDamage() < playerIn.getHeldItemMainhand().getMaxDamage()))
			{
				playerIn.getHeldItemMainhand().damageItem(1, playerIn);
			}
			else
			{
				playerIn.getHeldItemMainhand().setCount(playerIn.getHeldItemMainhand().getCount() - 1);
			}
			worldIn.setBlockState(pos, MBlocks.lit_candle.getDefaultState());
			return true;
		}
		else if(this.isLit == false && playerIn.getHeldItemMainhand() != null && playerIn.getHeldItemMainhand().getItem() == MItems.will_o_wisp)
		{
			playerIn.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.GLASS_BOTTLE,1));
			worldIn.setBlockState(pos, MBlocks.unholy_candle.getDefaultState());
			return true;
		}
		else if(this.isLit == true && this.isUnholy == true && playerIn.getHeldItemMainhand() != null && playerIn.getHeldItemMainhand().getItem() == Items.GLASS_BOTTLE)
		{
			playerIn.getHeldItemMainhand().setCount(playerIn.getHeldItemMainhand().getCount() - 1);
			worldIn.spawnEntity(new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(MItems.will_o_wisp, 1)));
			worldIn.setBlockState(pos, MBlocks.candle.getDefaultState());
			return true;
		}
		else if(this.isLit == true && (playerIn.getHeldItemMainhand() != null) && (playerIn.getHeldItemMainhand().getItem() == Items.POTIONITEM || playerIn.getHeldItemMainhand().getItem() == Items.WATER_BUCKET || playerIn.getHeldItemMainhand().getItem() == Items.SNOWBALL || playerIn.getHeldItemMainhand().getItem() == MItems.crushed_ice || playerIn.getHeldItemMainhand().getItem() == MItems.ice_charge))
		{
			if((playerIn.getHeldItemMainhand().getItem() == Items.POTIONITEM))
			{
				playerIn.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.GLASS_BOTTLE, 1));
			}
			else if((playerIn.getHeldItemMainhand().getItem() == Items.WATER_BUCKET))
			{
				playerIn.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.BUCKET, 1));
				
			}
			else
			{
				playerIn.getHeldItemMainhand().setCount(playerIn.getHeldItemMainhand().getCount() - 1);
			}
			worldIn.setBlockState(pos, MBlocks.candle.getDefaultState());
			return true;
		}
		return false;
	}
}