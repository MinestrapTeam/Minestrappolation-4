package minestrapteam.mods.minestrappolation.tileentity;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class TileEntityEnderPorter extends TileEntityInventory
{

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
		if(this.itemStacks[0] != null && this.itemStacks[0].stackSize > 0 && this.getChipBlock() == MBlocks.enderporter || this.hasSelfSufficient())
		{
			int chance;
			
			if(this.getUpgrade() != null && this.getUpgrade().getIsItemStackEqual(new ItemStack(MItems.upgradechip, 1, 0)))
			{
				chance = 4;
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
					if(this.itemStacks[0].stackSize >= 2)
					{
						this.itemStacks[0].stackSize -= 2;
					}
					else
					{
						return false;
					}
				}
				else
				{
					this.itemStacks[0].stackSize --;
				}
				
				if(this.itemStacks[0].stackSize == 0)
				{
					this.itemStacks[0] = null;
				}
			}
			return true;
		}
		return false;
	}
	
	public void transportEnity(World world, Entity entity, BlockPos pos)
	{
		entity.setPositionAndUpdate(getChipPos().getX() + .5, getChipPos().getY() + hasInversionUpgrade(world, pos), getChipPos().getZ() + .5);
	}
	
	private int hasInversionUpgrade(World world, BlockPos pos)
	{
		if(!this.hasSelfSufficient())
		{
			TileEntityEnderPorter te = (TileEntityEnderPorter) world.getTileEntity(new BlockPos(getChipPos().getX(), getChipPos().getY(), getChipPos().getZ()));
			
			if(te.getUpgrade() != null && te.getUpgrade().getIsItemStackEqual(new ItemStack(MItems.upgradechip, 1, 2)))
			{
				return -1;
			}
			return 1;
		}
		return 1;
	}
	
	public boolean hasSelfSufficient()
	{
		if(this.getUpgrade() != null && this.getUpgrade().getIsItemStackEqual(new ItemStack(MItems.upgradechip, 1, 3)))
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
			return this.worldObj.getBlockState(new BlockPos(nbt.getInteger("x"), nbt.getInteger("y"), nbt.getInteger("z"))).getBlock();
		}
		return this.worldObj.getBlockState(this.pos).getBlock();
	}
	
	public ItemStack getUpgrade()
	{
		return this.itemStacks[2];
	}

	@Override
	public int getSizeInventory() 
	{
		return 3;
	}
	
}
