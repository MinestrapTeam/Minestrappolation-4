package minestrapteam.mods.minestrappolation.item;

import java.util.List;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWrench extends Item
{
	
	public ItemWrench()
	{
		this.setMaxStackSize(1);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) 
	{
		if(stack.getTagCompound() == null)
		{
			stack.setTagCompound(new NBTTagCompound());
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
	    if (worldIn.getBlockState(pos).getBlock() == MBlocks.enderporter)
	    {
	    	if(playerIn.isSneaking())
	    	{
	    		stack.getTagCompound().setInteger("x", pos.getX());
		        stack.getTagCompound().setInteger("y", pos.getY());
		        stack.getTagCompound().setInteger("z", pos.getZ());
	    	}
	    }
	    return true;
	 }
	
	@Override
	 @SideOnly(Side.CLIENT)
	 public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced)
	 {
		 if(stack.getTagCompound() == null)
		 {
			stack.setTagCompound(new NBTTagCompound());
		 }
		 if(!stack.getTagCompound().hasKey("x"))
		 {
			 tooltip.add(EnumChatFormatting.RED + "Sneack right-click to get BlockPos");
		 }
		 else 
		 {
			tooltip.add(EnumChatFormatting.GREEN + Integer.toString(stack.getTagCompound().getInteger("x")) +", " + Integer.toString(stack.getTagCompound().getInteger("y")) +", " + Integer.toString(stack.getTagCompound().getInteger("z")) );
		 }

	 }
}
