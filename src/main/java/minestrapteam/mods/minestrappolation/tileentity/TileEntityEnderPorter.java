package minestrapteam.mods.minestrappolation.tileentity;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;

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
		if(this.itemStacks[0] != null && this.itemStacks[0].stackSize > 0 && getChipBlock() == MBlocks.enderporter)
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
				this.itemStacks[0].stackSize --;
				if(this.itemStacks[0].stackSize == 0)
				{
					this.itemStacks[0] = null;
				}
			}
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
