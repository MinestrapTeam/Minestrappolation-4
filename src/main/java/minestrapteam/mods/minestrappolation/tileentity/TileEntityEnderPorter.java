package minestrapteam.mods.minestrappolation.tileentity;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Random;

public class TileEntityEnderPorter extends TileEntityInventory implements ISidedInventory
{

	public HashMap<Integer, ItemStack> map = new HashMap<Integer, ItemStack>();

	private static final int[] topInputSlot   = new int[] { 0 };
	private static final int[] sideInputSlots = new int[] { 1, 2, 3 };
	private static final int[] outputSlots    = new int[] { 2, 3 };

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
		if (this.itemStacks[0] != null && this.itemStacks[0].stackSize > 0 && this.getChipBlock() == MBlocks.enderporter
			    || this.hasSelfSufficient())
		{
			int chance;

			if (this.hasUpgradeChip(new ItemStack(MItems.upgradechip, 1, 0)))
			{
				chance = 3;
			}
			else
			{
				chance = 1;
			}

			int num = rand.nextInt(chance);
			if (num == 0)
			{
				num = 1;
			}

			if (num == 1)
			{
				if (this.hasSelfSufficient())
				{
					if (this.itemStacks[0] != null && this.itemStacks[0].stackSize >= 2)
					{
						this.itemStacks[0].stackSize -= 2;
						if (this.itemStacks[0] != null && this.itemStacks[0].stackSize == 0)
						{
							this.itemStacks[0] = null;
						}
						return true;
					}
				}
				else
				{
					this.itemStacks[0].stackSize--;
					if (this.itemStacks[0] != null && this.itemStacks[0].stackSize == 0)
					{
						this.itemStacks[0] = null;
					}
					return true;
				}
			}

			if (this.hasSelfSufficient() && this.itemStacks[0] != null && this.itemStacks[0].stackSize >= 2)
			{
				return true;
			}

			if (!this.hasSelfSufficient() && this.itemStacks[0] != null && this.itemStacks[0].stackSize >= 1)
			{
				return true;
			}
		}
		return false;
	}

	public void transportEnity(World world, Entity entity, BlockPos pos)
	{
		TileEntityEnderPorter te = (TileEntityEnderPorter) world.getTileEntity(
			new BlockPos(this.getChipPos().getX(), this.getChipPos().getY(), this.getChipPos().getZ()));
		entity.setPositionAndUpdate(this.getChipPos().getX() + .5, this.getChipPos().getY() + this.hasInversionUpgrade(world, pos),
		                            this.getChipPos().getZ() + .5);
		if (te.hasUpgradeChip(new ItemStack(MItems.upgradechip, 1, 4)))
		{
			if (entity instanceof EntityItem)
			{
				EntityItem entityitem = (EntityItem) entity;
				ItemStack stack = entityitem.getEntityItem();
				if (stack.getItem() instanceof ItemBlock)
				{

					Block block = Block.getBlockFromItem(stack.getItem());

					if (!world.isAirBlock(
						new BlockPos(this.getChipPos().getX() + .5, this.getChipPos().getY() + this.hasInversionUpgrade(world, pos),
						             this.getChipPos().getZ() + .5)))
					{
						world.destroyBlock(new BlockPos(this.getChipPos().getX() + .5,
						                                this.getChipPos().getY() + this.hasInversionUpgrade(world, pos),
						                                this.getChipPos().getZ() + .5), true);
					}

					if (this.placeBlock(world, new BlockPos(this.getChipPos().getX() + .5,
					                                        this.getChipPos().getY() + this.hasInversionUpgrade(world, pos),
					                                        this.getChipPos().getZ() + .5),
					                    block.getStateFromMeta(stack.getItemDamage())))
					{
						entityitem.setDead();
					}
				}
				if (stack.getItem() instanceof ItemSeeds || stack.getItem() instanceof ItemSeedFood)
				{
					Object stack2 = null;
					Block block = null;
					if (stack.getItem() instanceof ItemSeeds)
					{
						stack2 = stack.getItem();
						block = ((ItemSeeds) stack2).getPlant(world, pos).getBlock();
					}
					if (stack.getItem() instanceof ItemSeedFood)
					{
						stack2 = stack.getItem();
						block = ((ItemSeedFood) stack2).getPlant(world, pos).getBlock();
					}

					if (!world.isAirBlock(
						new BlockPos(this.getChipPos().getX() + .5, this.getChipPos().getY() + this.hasInversionUpgrade(world, pos),
						             this.getChipPos().getZ() + .5)))
					{
						world.destroyBlock(new BlockPos(this.getChipPos().getX() + .5,
						                                this.getChipPos().getY() + this.hasInversionUpgrade(world, pos),
						                                this.getChipPos().getZ() + .5), true);
					}

					if (this.placeBlock(world, new BlockPos(this.getChipPos().getX() + .5,
					                                        this.getChipPos().getY() + this.hasInversionUpgrade(world, pos),
					                                        this.getChipPos().getZ() + .5), block.getDefaultState()))
					{
						entityitem.setDead();
					}
				}
			}
		}
	}

	private int hasInversionUpgrade(World world, BlockPos pos)
	{
		if (!this.hasSelfSufficient())
		{
			TileEntityEnderPorter te = (TileEntityEnderPorter) world.getTileEntity(
				new BlockPos(this.getChipPos().getX(), this.getChipPos().getY(), this.getChipPos().getZ()));

			if (te.hasUpgradeChip(new ItemStack(MItems.upgradechip, 1, 2)))
			{
				return -1;
			}

			return 1;
		}
		return 1;
	}

	public boolean hasSelfSufficient()
	{
		return this.hasUpgradeChip(new ItemStack(MItems.upgradechip, 1, 3));
	}

	public BlockPos getChipPos()
	{
		if (this.itemStacks[1] != null)
		{
			NBTTagCompound nbt = this.itemStacks[1].getTagCompound();
			return new BlockPos(nbt.getInteger("x"), nbt.getInteger("y"), nbt.getInteger("z"));
		}
		return this.pos;
	}

	public Block getChipBlock()
	{
		if (this.itemStacks[1] != null)
		{
			NBTTagCompound nbt = this.itemStacks[1].getTagCompound();
			return this.worldObj
				       .getBlockState(new BlockPos(nbt.getInteger("x"), nbt.getInteger("y"), nbt.getInteger("z")))
				       .getBlock();
		}
		return this.worldObj.getBlockState(this.pos).getBlock();
	}

	public void getUpgrades()
	{
		if (this.itemStacks[2] == null)
		{
			this.map.remove(0);
		}
		else
		{
			this.map.put(0, this.itemStacks[2]);
		}

		if (this.itemStacks[3] == null)
		{
			this.map.remove(1);
		}
		else
		{
			this.map.put(1, this.itemStacks[3]);
		}
	}

	public boolean hasUpgradeChip(ItemStack stack)
	{
		this.getUpgrades();
		ItemStack up1 = this.map.get(0);
		ItemStack up2 = this.map.get(1);

		if (up1 != null && up1.getIsItemStackEqual(stack))
		{
			return true;
		}
		return up2 != null && up2.getIsItemStackEqual(stack);
	}

	public boolean placeBlock(World world, BlockPos pos, IBlockState state)
	{
		if (state.getBlock().canPlaceBlockAt(world, pos))
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
		if (index == 0 && stack.getItem() == Items.ender_pearl)
			return true;
		else if (index == 1 && stack.getItem() == MItems.poschip)
			return true;
		else
			return (index == 2 || index == 3) && stack.getItem() == MItems.upgradechip;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side)
	{
		return side == EnumFacing.DOWN ? outputSlots : (side == EnumFacing.UP ? topInputSlot : sideInputSlots);
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
	{
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
	{
		return true;
	}
}
