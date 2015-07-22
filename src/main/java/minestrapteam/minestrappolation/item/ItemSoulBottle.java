package minestrapteam.minestrappolation.item;

import java.util.List;

import org.lwjgl.input.Keyboard;

import minestrapteam.minestrappolation.Config;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSoulBottle extends Item{
	
	public ItemSoulBottle()
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
			stack.getTagCompound().setInteger("xp", 0);
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			{
				if(player.experienceLevel > 1)
				{
					int stored = stack.getTagCompound().getInteger("xp");
					if(stored < Config.soulBottleStorage)
					{
						player.addExperienceLevel(-1);
						stack.getTagCompound().setInteger("xp", stored + 1);
					}
					
				}
			}
			else
			{
				int stored = stack.getTagCompound().getInteger("xp");
				if(stored >= 1)
				{
					player.addExperienceLevel(1);
					stack.getTagCompound().setInteger("xp", stored - 1);
				}
		
			}
		return stack;
	}
	
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced)
	 {
		 if(stack.getTagCompound() == null)
		 {
			stack.setTagCompound(new NBTTagCompound());
		 }
		 if(!stack.getTagCompound().hasKey("xp"))
		 {
			tooltip.add(EnumChatFormatting.GREEN + "0");
		 }
		 else 
		 {
			tooltip.add(EnumChatFormatting.GREEN + Integer.toString(stack.getTagCompound().getInteger("xp")));
		 }

	 }

}
