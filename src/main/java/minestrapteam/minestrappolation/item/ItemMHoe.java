package minestrapteam.minestrappolation.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemMHoe extends ItemHoe 
{

	Item repairItem;
	boolean ignites = false;
	
	public ItemMHoe(ToolMaterial material, Item repair, boolean ignites) 
	{
		super(material);
		this.repairItem = repair;
		this.ignites = ignites;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) 
	{	
		return repair.getItem() == repairItem;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(this.ignites)
		{
			 pos = pos.offset(side);
		        if (!playerIn.canPlayerEdit(pos, side, stack))
		        {
		            return false;
		        }
		        else
		        {
		            if (worldIn.isAirBlock(pos))
		            {
		                worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
		                worldIn.setBlockState(pos, Blocks.fire.getDefaultState());
		            }

		            stack.damageItem(1, playerIn);
		            return true;
		        }
		}
       return false;
    }
}
