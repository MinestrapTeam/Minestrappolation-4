package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemMAxe extends ItemAxe
{
	
	Item	repairItem;
	boolean	ignites	= false;
	
	public ItemMAxe(ToolMaterial material, Item repair, boolean ignites)
	{
		super(material);
		this.repairItem = repair;
		this.ignites = ignites;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == this.repairItem;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if(this.toolMaterial == MItems.TORITE)
        {
        	stack.damageItem(1, attacker);
        	return true;
        }
        else
        {
        	stack.damageItem(2, attacker);
            return true;
        }
    }
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (this.ignites)
		{
			pos = pos.offset(side);
			if (!playerIn.canPlayerEdit(pos, side, stack))
				return false;
			else
			{
				if (worldIn.isAirBlock(pos))
				{
					worldIn.playSoundEffect(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					worldIn.setBlockState(pos, Blocks.fire.getDefaultState());
				}
				
				stack.damageItem(1, playerIn);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        if(this.toolMaterial == MItems.TORITE)
        	return EnumAction.BLOCK;
        else
        	return null;
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        if(this.toolMaterial == MItems.TORITE)
        	return 72000;
        else
        	return 0;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		if(this.toolMaterial == MItems.TORITE)
		{
			playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
			return itemStackIn;
		}
        return itemStackIn;
    }
}
