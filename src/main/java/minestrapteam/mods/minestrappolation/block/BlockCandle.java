package minestrapteam.mods.minestrappolation.block;

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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockCandle extends Block
{
	public boolean isLit;
	public boolean isUnholy;

	public BlockCandle(Material materialIn, boolean lit, boolean unholy)
	{
		super(materialIn);
		this.isLit = lit;
		this.isUnholy = unholy;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		float f = 0.0625F;
		return new AxisAlignedBB(pos.getX() + (6 * f), pos.getY(), pos.getZ() + (6 * f), pos.getX() + 1 - (6 * f),
		                         pos.getY() + 1 - (10 * f), pos.getZ() + 1 - (6 * f));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
	{
		float f = 0.0625F;
		return new AxisAlignedBB(pos.getX() + (5 * f), pos.getY(), pos.getZ() + (5 * f), pos.getX() + 1 - (5 * f),
		                         pos.getY() + 1 - (10 * f), pos.getZ() + 1 - (5 * f));
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
	{
		return true;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true)
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.oak_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.dark_oak_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.birch_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.spruce_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.jungle_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.acacia_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.redwood_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.frozen_oak_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.cobblestone_wall
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall_mossy
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall_mossy
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall_mossy
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall_mossy
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.nether_brick_fence;
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
		return worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true)
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.oak_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.dark_oak_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.birch_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.spruce_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.jungle_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.acacia_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.redwood_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.frozen_oak_fence
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.cobblestone_wall
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.red_rock_wall_mossy
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.coldstone_wall_mossy
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.icestone_wall_mossy
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == MBlocks.oceanstone_wall_mossy
			       || worldIn.getBlockState(pos.offset(EnumFacing.DOWN)).getBlock() == Blocks.nether_brick_fence;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (this.isLit == true)
		{
			if (this.isUnholy == false)
			{
				double d0 = (double) pos.getX() + 0.5D;
				double d1 = (double) pos.getY() + 0.5D;
				double d2 = (double) pos.getZ() + 0.5D;
				double d3 = 0.22D;
				double d4 = 0.27D;

				worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
			}
			else
			{
				double d0 = (double) pos.getX() + 0.5D;
				double d1 = (double) pos.getY() + 0.5D;
				double d2 = (double) pos.getZ() + 0.5D;
				double d3 = 0.22D;
				double d4 = 0.27D;

				worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, 1.0D, 0.0D, 1.0D);
			}
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(MBlocks.candle);
	}

	@Override
	public boolean canSilkHarvest()
	{
		return false;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
		{
			return true;
		}
		if (this.isLit == false && (playerIn.getCurrentEquippedItem() != null) && (playerIn.getCurrentEquippedItem()
		                                                                                   .getItem()
			                                                                           == Items.flint_and_steel ||
			                                                                           playerIn.getCurrentEquippedItem()
			                                                                                   .getItem()
				                                                                           == MItems.fire_axe ||
			                                                                           playerIn.getCurrentEquippedItem()
			                                                                                   .getItem()
				                                                                           == MItems.fire_hoe ||
			                                                                           playerIn.getCurrentEquippedItem()
			                                                                                   .getItem()
				                                                                           == MItems.fire_pickaxe ||
			                                                                           playerIn.getCurrentEquippedItem()
			                                                                                   .getItem()
				                                                                           == MItems.fire_shovel ||
			                                                                           playerIn.getCurrentEquippedItem()
			                                                                                   .getItem()
				                                                                           == MItems.fire_sword ||
			                                                                           playerIn.getCurrentEquippedItem()
			                                                                                   .getItem()
				                                                                           == Items.fire_charge))
		{
			if ((playerIn.getCurrentEquippedItem().getItemDamage() < playerIn.getCurrentEquippedItem().getMaxDamage()))
			{
				playerIn.getCurrentEquippedItem().damageItem(1, playerIn);
			}
			else
			{
				playerIn.getCurrentEquippedItem().stackSize--;
			}
			worldIn.setBlockState(pos, MBlocks.lit_candle.getDefaultState());
			return true;
		}
		else if (this.isLit == false && playerIn.getCurrentEquippedItem() != null
			         && playerIn.getCurrentEquippedItem().getItem() == MItems.will_o_wisp)
		{
			playerIn.getCurrentEquippedItem().setItem(Items.glass_bottle);
			worldIn.setBlockState(pos, MBlocks.unholy_candle.getDefaultState());
			return true;
		}
		else if (this.isLit == true && this.isUnholy == true && playerIn.getCurrentEquippedItem() != null
			         && playerIn.getCurrentEquippedItem().getItem() == Items.glass_bottle)
		{
			playerIn.getCurrentEquippedItem().stackSize--;
			worldIn.spawnEntityInWorld(new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ,
			                                          new ItemStack(MItems.will_o_wisp, 1)));
			worldIn.setBlockState(pos, MBlocks.candle.getDefaultState());
			return true;
		}
		else if (this.isLit == true && (playerIn.getCurrentEquippedItem() != null) && (playerIn.getCurrentEquippedItem()
		                                                                                       .getItem()
			                                                                               == Items.potionitem ||
			                                                                               playerIn
				                                                                               .getCurrentEquippedItem()
				                                                                               .getItem()
				                                                                               == Items.water_bucket ||
			                                                                               playerIn
				                                                                               .getCurrentEquippedItem()
				                                                                               .getItem()
				                                                                               == Items.snowball ||
			                                                                               playerIn
				                                                                               .getCurrentEquippedItem()
				                                                                               .getItem()
				                                                                               == MItems.crushed_ice ||
			                                                                               playerIn
				                                                                               .getCurrentEquippedItem()
				                                                                               .getItem()
				                                                                               == MItems.ice_charge))
		{
			if ((playerIn.getCurrentEquippedItem().getItem() == Items.potionitem))
			{
				playerIn.setCurrentItemOrArmor(0, new ItemStack(Items.glass_bottle, 1));
			}
			else if ((playerIn.getCurrentEquippedItem().getItem() == Items.water_bucket))
			{
				playerIn.setCurrentItemOrArmor(0, new ItemStack(Items.bucket, 1));
			}
			else
			{
				playerIn.getCurrentEquippedItem().stackSize--;
			}
			worldIn.setBlockState(pos, MBlocks.candle.getDefaultState());
			return true;
		}
		return false;
	}
}
