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

public class ItemHeartContainer extends MItemFoiled
{
	public ItemHeartContainer()
	{
		this.maxStackSize = 1;
	}
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		if(playerIn.getMaxHealth() < Config.healthIncreaseMax)
		{
			
			 playerIn.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(playerIn.getMaxHealth() + 2D);
			 NBTTagCompound nbt;
			  
			  if (!playerIn.getEntityData().hasKey("PlayerPersisted")) 
			  {
			   nbt = new NBTTagCompound();
			   playerIn.getEntityData().setTag("PlayerPersisted", nbt);
			  } else {
			   nbt = playerIn.getEntityData().getCompoundTag("PlayerPersisted");
			   nbt.setDouble("health", playerIn.getMaxHealth());
			  }
			  
	          --itemStackIn.stackSize;
		}
        return itemStackIn;
    }
}
