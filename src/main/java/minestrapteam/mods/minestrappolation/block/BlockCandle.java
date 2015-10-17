package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCandle extends Block
{
	public boolean isLit;
	
	public BlockCandle(Material materialIn, boolean lit)
	{
		super(materialIn);
		isLit = lit;
	}
	
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		float f = 0.0625F;
		return new AxisAlignedBB(pos.getX() + (6 * f), pos.getY(), pos.getZ() + (6 * f), pos.getX() + 1 - (6 * f), pos.getY() + 1 - (10 * f), pos.getZ() + 1 - (6 * f));
	}
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
    {
		float f = 0.0625F;
		return new AxisAlignedBB(pos.getX() + (5 * f), pos.getY(), pos.getZ() + (5 * f), pos.getX() + 1 - (5 * f), pos.getY() + 1 - (10 * f), pos.getZ() + 1 - (5 * f));
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }
	
	public boolean isFullCube()
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return true;
    }
    
	@Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        if(worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true) || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.oak_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.dark_oak_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.birch_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.spruce_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.jungle_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.acacia_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.redwood_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.frozen_oak_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.cobblestone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.nether_brick_fence)
        	return true;
        else
        	return false;
    }
    
	@Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
    	if (!this.canBlockStay(worldIn, pos, EnumFacing.DOWN))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }

        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
    }
    
    public boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing)
    {
    	if(worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true) || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.oak_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.dark_oak_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.birch_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.spruce_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.jungle_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.acacia_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.redwood_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.frozen_oak_fence || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.cobblestone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall_mossy || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.nether_brick_fence)
    		return true;
    	else
    		return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	if(this.isLit == true)
    	{
    		double d0 = (double)pos.getX() + 0.5D;
    		double d1 = (double)pos.getY() + 0.5D;
    		double d2 = (double)pos.getZ() + 0.5D;
    		double d3 = 0.22D;
    		double d4 = 0.27D;

    		worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
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
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(worldIn.isRemote)
		{
			return true;
		}
		if(this.isLit == false && (playerIn.getCurrentEquippedItem() != null) && (playerIn.getCurrentEquippedItem().getItem() == Items.flint_and_steel || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_axe  || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_hoe || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_pickaxe || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_shovel || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_sword || playerIn.getCurrentEquippedItem().getItem() == Items.fire_charge))
		{
			if((playerIn.getCurrentEquippedItem().getItemDamage() < playerIn.getCurrentEquippedItem().getMaxDamage()) || playerIn.getCurrentEquippedItem().getMaxDamage() == 0)
			{
				playerIn.getCurrentEquippedItem().damageItem(1, playerIn);
			}
			else
			{
				playerIn.destroyCurrentEquippedItem();
			}
			worldIn.setBlockState(pos, MBlocks.lit_candle.getDefaultState());
			return true;
		}
		return false;
	}
}