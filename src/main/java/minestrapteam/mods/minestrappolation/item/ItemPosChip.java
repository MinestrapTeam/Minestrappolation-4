package minestrapteam.mods.minestrappolation.item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPosChip extends Item
{	
	
	public ItemPosChip()
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
		
		if(!worldIn.isRemote)
		{
			stack.getTagCompound().setInteger("x", 0);
			stack.getTagCompound().setInteger("y", 0);
			stack.getTagCompound().setInteger("z", 0);
		}
		
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
	    stack.getTagCompound().setInteger("x", pos.getX());
		stack.getTagCompound().setInteger("y", pos.getY());
		stack.getTagCompound().setInteger("z", pos.getZ());
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
			 
		 }
		 else 
		 {
			tooltip.add(EnumChatFormatting.GREEN + playerIn.getEntityWorld().getBlockState(new BlockPos(stack.getTagCompound().getInteger("x"), stack.getTagCompound().getInteger("y"), stack.getTagCompound().getInteger("z"))).getBlock().getLocalizedName());
			tooltip.add(EnumChatFormatting.GREEN + Integer.toString(stack.getTagCompound().getInteger("x")) +", " + Integer.toString(stack.getTagCompound().getInteger("y")) +", " + Integer.toString(stack.getTagCompound().getInteger("z")) );
		 }

	 }
	 
	 public Block getStoredBlock(World world, ItemStack stack)
	 {
		 return world.getBlockState(new BlockPos(stack.getTagCompound().getInteger("x"), stack.getTagCompound().getInteger("y"), stack.getTagCompound().getInteger("z"))).getBlock();
	 }
	 
	 public BlockPos getStoredBlockPos(World world, ItemStack stack)
	 {
		 return new BlockPos(stack.getTagCompound().getInteger("x"), stack.getTagCompound().getInteger("y"), stack.getTagCompound().getInteger("z"));
	 }
}
