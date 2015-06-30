package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.Config;
import minestrapteam.minestrappolation.Minestrappolation;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemHeartContainer extends Item
{
	public ItemHeartContainer()
	{
		this.maxStackSize = 1;
	}
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		if(playerIn.getMaxHealth() < Config.healthIncreaseMax)
		{
			playerIn.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(playerIn.getMaxHealth() + 1D);
	        --itemStackIn.stackSize;
		}
        return itemStackIn;
    }
}
