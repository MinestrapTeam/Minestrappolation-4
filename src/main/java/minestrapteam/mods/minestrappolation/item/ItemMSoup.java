package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemMSoup extends ItemFood
{
	public ItemStack container;
	public int fireTime;
	
	public ItemMSoup(int healAmount, float saturation, Item containerItem, int igniteTime)
    {
        super(healAmount, saturation, false);
        this.setMaxStackSize(1);
        container = new ItemStack(containerItem);
        fireTime = igniteTime;
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if(this == MItems.rice_bowl)
        {
        	playerIn.inventory.addItemStackToInventory(new ItemStack(Items.stick));
    	}
        if (this == MItems.jam_bottle && !worldIn.isRemote)
        {
        	playerIn.addStat(MAchievements.jam, 1);
        	playerIn.addPotionEffect(new PotionEffect(Potion.healthBoost.id, 10 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.heal.id, 1 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 0));
        }
        if (this == MItems.ice_cream && !worldIn.isRemote)
        {
        	playerIn.addStat(MAchievements.icecream, 1);
        	playerIn.extinguish();
        	playerIn.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 30 * 20, 2));
        	playerIn.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 30 * 20, 1));
        	playerIn.addPotionEffect(new PotionEffect(Potion.heal.id, 1, 1));
        }
        if (this == MItems.glowshroom_stew && !worldIn.isRemote)
        {
        	playerIn.addStat(MAchievements.reflux, 1);
        	playerIn.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 30 * 20, 3));
            playerIn.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 30 * 20, 3));
            playerIn.addPotionEffect(new PotionEffect(Potion.regeneration.id, 30 * 20, 1));
            playerIn.addPotionEffect(new PotionEffect(Potion.blindness.id, 30 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.nightVision.id, 30 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.confusion.id, 30 * 20, 0));
        }
        if(fireTime != 0)
        {
        	playerIn.setFire(fireTime);
        }
        super.onItemUseFinish(stack, worldIn, playerIn);
        return container;
    }
}