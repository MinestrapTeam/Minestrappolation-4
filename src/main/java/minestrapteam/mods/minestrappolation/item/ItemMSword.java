package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.block.machines.BlockFrostGenerator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemMSword extends ItemSword
{
	Item	repairItem;
	boolean	ignites	= false;
	boolean freezes = false;
	
	public ItemMSword(ToolMaterial material, Item repair, boolean ignites, boolean freezes)
	{
		super(material);
		this.repairItem = repair;
		this.ignites = ignites;
		this.freezes = freezes;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == this.repairItem;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		if(this.ignites)
		{
			target.setFire(5);
		}
		
		if(this.freezes)
		{
			target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 4 * 20, 10));
		}
        stack.damageItem(1, attacker);
        return true;
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
		else if(this.freezes)
		{
			BlockPos pos1 = pos.offset(side);
			if (!playerIn.canPlayerEdit(pos, side, stack))
				return false;
			else
			{
				if(BlockFrostGenerator.canFreeze.containsKey(worldIn.getBlockState(pos1)))
				{
					worldIn.playSoundEffect(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "dig.glass", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					worldIn.setBlockState(pos1, BlockFrostGenerator.canFreeze.get(worldIn.getBlockState(pos1)));
					stack.damageItem(4, playerIn);
				}
				else if(BlockFrostGenerator.canFreeze.containsKey(worldIn.getBlockState(pos)))
				{
					worldIn.playSoundEffect(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "dig.glass", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					worldIn.setBlockState(pos, BlockFrostGenerator.canFreeze.get(worldIn.getBlockState(pos)));
					stack.damageItem(4, playerIn);
				}
				return true;
			}
		}
		return false;
	}
}
