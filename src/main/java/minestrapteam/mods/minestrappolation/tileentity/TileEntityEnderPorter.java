package minestrapteam.mods.minestrappolation.tileentity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityEnderPorter extends TileEntityInventory implements ISidedInventory
{
	public HashMap<Integer, ItemStack> map = new HashMap<Integer, ItemStack>();

	private static final int[]	topInputSlot	= new int[] { 0 };
	private static final int[]	sideInputSlots	= new int[] { 1, 2, 3 };
	private static final int[]  outputSlots		= new int[] { 2, 3 };
	
	public TileEntityEnderPorter()
	{

	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
    }

	@Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
    }
	
	public boolean canActivate()
	{
		Random rand = new Random();
		if(this.itemStacks[0] != null && this.itemStacks[0].getCount() > 0 && this.getChipBlock() == MBlocks.enderporter || this.hasSelfSufficient())
		{
			int chance;
			
			if(this.hasUpgradeChip(new ItemStack(MItems.upgradechip, 1, 0)))
			{
				chance = 3;
			}
			else
			{
				chance = 1;
			}

			int num = rand.nextInt(chance);
			if(num == 0)
			{
				num = 1;
			}
			
			if(num == 1)
			{
				if(this.hasSelfSufficient())
				{
					if(this.itemStacks[0] != null && this.itemStacks[0].getCount() >= 2)
					{
						this.itemStacks[0].setCount(this.itemStacks[0].getCount() - 2); 
						if(this.itemStacks[0] != null && this.itemStacks[0].getCount() == 0)
						{
							this.itemStacks[0] = null;
						}
						return true;
					}
				}
				else
				{
					this.itemStacks[0].setCount(this.itemStacks[0].getCount() - 1 );
					if(this.itemStacks[0] != null && this.itemStacks[0].getCount() == 0)
					{
						this.itemStacks[0] = null;
					}
					return true;
				}
			}
			
			if(this.hasSelfSufficient() && this.itemStacks[0] != null && this.itemStacks[0].getCount() >= 2)
			{
				return true;
			}
			
			if(!this.hasSelfSufficient() && this.itemStacks[0] != null && this.itemStacks[0].getCount() >= 1)
			{
				return true;
			}
			
		}
		return false;
	}
	
	public void transportEnity(World world, Entity entity, BlockPos pos)
	{
		TileEntityEnderPorter te = (TileEntityEnderPorter) world.getTileEntity(new BlockPos(getChipPos().getX(), getChipPos().getY(), getChipPos().getZ()));
		entity.setPositionAndUpdate(getChipPos().getX() + .5, getChipPos().getY() + hasInversionUpgrade(world, pos), getChipPos().getZ() + .5);
		if(te.hasUpgradeChip(new ItemStack(MItems.upgradechip, 1, 4)))
		{
			if(entity instanceof EntityItem)
			{
				EntityItem entityitem = (EntityItem)entity;
				ItemStack stack = entityitem.getEntityItem();
				if(stack.getItem() instanceof ItemBlock)
				{
					
					Block block = Block.getBlockFromItem(stack.getItem());
					
					if(!world.isAirBlock(new BlockPos(getChipPos().getX() + .5, getChipPos().getY() + hasInversionUpgrade(world, pos), getChipPos().getZ() + .5)))
					{
						world.destroyBlock(new BlockPos(getChipPos().getX() + .5, getChipPos().getY() + hasInversionUpgrade(world, pos), getChipPos().getZ() + .5), true);
					}
					
					if(this.placeBlock(world, new BlockPos(getChipPos().getX() + .5, getChipPos().getY() + hasInversionUpgrade(world, pos), getChipPos().getZ() + .5), block.getStateFromMeta(stack.getItemDamage())))
					{
						entityitem.setDead();
					}
					
				}
				if(stack.getItem() instanceof ItemSeeds || stack.getItem() instanceof ItemSeedFood)
				{
					Object stack2 = null;
					Block block = null;
					if(stack.getItem() instanceof ItemSeeds)
					{
						stack2 = (ItemSeeds) stack.getItem();
						block = ((ItemSeeds) stack2).getPlant(world, pos).getBlock();
					}
					if(stack.getItem() instanceof ItemSeedFood)
					{
						stack2 = (ItemSeedFood) stack.getItem();
						block = ((ItemSeedFood) stack2).getPlant(world, pos).getBlock();
					}

					if(!world.isAirBlock(new BlockPos(getChipPos().getX() + .5, getChipPos().getY() + hasInversionUpgrade(world, pos), getChipPos().getZ() + .5)))
					{
						world.destroyBlock(new BlockPos(getChipPos().getX() + .5, getChipPos().getY() + hasInversionUpgrade(world, pos), getChipPos().getZ() + .5), true);
					}
					
					if(this.placeBlock(world, new BlockPos(getChipPos().getX() + .5, getChipPos().getY() + hasInversionUpgrade(world, pos), getChipPos().getZ() + .5), block.getDefaultState()))
					{
						entityitem.setDead();
					}
					
				}
			}
		}
	}
	
	private int hasInversionUpgrade(World world, BlockPos pos)
	{
		if(!this.hasSelfSufficient())
		{
			TileEntityEnderPorter te = (TileEntityEnderPorter) world.getTileEntity(new BlockPos(getChipPos().getX(), getChipPos().getY(), getChipPos().getZ()));
			
			if(te.hasUpgradeChip(new ItemStack(MItems.upgradechip, 1, 2)))
			{
				return -1;
			}
			
			return 1;
		}
		return 1;
	}
	
	public boolean hasSelfSufficient()
	{
		if(this.hasUpgradeChip(new ItemStack(MItems.upgradechip, 1, 3)))
		{
			return true;
		}
		return false;
	}
	
	public BlockPos getChipPos()
	{
		if(this.itemStacks[1] != null)
		{
			NBTTagCompound nbt = this.itemStacks[1].getTagCompound();
			return new BlockPos(nbt.getInteger("x"), nbt.getInteger("y"), nbt.getInteger("z"));
		}
		return this.pos;
	}
	
	public Block getChipBlock()
	{
		if(this.itemStacks[1] != null)
		{
			NBTTagCompound nbt = this.itemStacks[1].getTagCompound();
			return this.world.getBlockState(new BlockPos(nbt.getInteger("x"), nbt.getInteger("y"), nbt.getInteger("z"))).getBlock();
		}
		return this.world.getBlockState(this.pos).getBlock();
	}
	
	public void getUpgrades()
	{
		if(this.itemStacks[2] == null)
		{
			map.remove(0);
		}
		else
		{
			map.put(0, this.itemStacks[2]);
		}
		
		if(this.itemStacks[3] == null)
		{
			map.remove(1);
		}
		else
		{
			map.put(1, this.itemStacks[3]);
		}
	}
	
	public boolean hasUpgradeChip(ItemStack stack)
	{
		getUpgrades();
		ItemStack up1 = map.get(0);
		ItemStack up2 = map.get(1);
		
		if(up1 != null && ItemStack.areItemStacksEqual(up1,stack))		
		{
			return true;
		}
		if(up2 != null && ItemStack.areItemStacksEqual(up2,stack))
		{
			return true;
		}
		return false;
	}
	
	public boolean placeBlock(World world, BlockPos pos, IBlockState state)
	{
		if(state.getBlock().canPlaceBlockAt(world, pos))
		{
			world.setBlockState(pos, state, 2);
			return true;
		}
		return false;
	}

	@Override
	public int getSizeInventory() 
	{
		return 4;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
    {
		if(index == 0 && stack.getItem() == Items.ENDER_PEARL)
			return true;
		else if(index == 1 && stack.getItem() == MItems.poschip)
			return true;
		else if((index == 2 || index == 3) && stack.getItem() == MItems.upgradechip)
			return true;
		else
			return false;
    }

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return side == EnumFacing.DOWN ? outputSlots : (side == EnumFacing.UP ? topInputSlot : sideInputSlots);
	}

	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
	{
	    return this.isItemValidForSlot(index, itemStackIn);
	}


	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
	{
	    return true;
	}
	
}
