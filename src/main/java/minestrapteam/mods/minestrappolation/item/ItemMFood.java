package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemMFood extends ItemFood
{
	public int fireTime;
	
	public ItemMFood(int healAmount, float saturation, int igniteTime)
    {
        super(healAmount, saturation, false);
        fireTime = igniteTime;
        if(this == MItems.crushed_ice)
        	this.setAlwaysEdible();
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if(this == MItems.bread_rice_bowl || this == MItems.bread_stir_fry || this == MItems.corn_on_stick || this == MItems.grilled_corn)
        {
    		playerIn.inventory.addItemStackToInventory(new ItemStack(Items.stick));
    	}
        if (this == MItems.candy_red && !worldIn.isRemote)
        {
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(21), 1 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(10), 20 * 20, 0));
        }
        if (this == MItems.candy_blue && !worldIn.isRemote)
        {
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(21), 1 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(14), 30 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(16), 30 * 20, 0));
        }
        if (this == MItems.candy_yellow && !worldIn.isRemote)
        {
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(21), 20 * 20, 2));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(21), 1 * 20, 0));
        }
        if (this == MItems.pbj_sandwich && !worldIn.isRemote)
        {
        	playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(21), 10 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(6), 1 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(3), 10 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(5), 10 * 20, 0));
        }
        if (this == MItems.lucky_sushi && !worldIn.isRemote)
        {
        	int effect = worldIn.rand.nextInt(14);
        	if (effect == 0)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(1), 30 * 20, 0));
        	else if(effect == 1)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(3), 30 * 20, 0));
        	else if(effect == 2)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(5), 20 * 20, 0));
        	else if(effect == 3)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(6), 1, 1));
        	else if(effect == 4)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(8), 30 * 20, 1));
        	else if(effect == 5)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(10), 15 * 20, 1));
        	else if(effect == 6)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(11), 20 * 20, 0));
        	else if(effect == 7)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(12), 40 * 20, 0));
        	else if(effect == 8)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(13), 40 * 20, 0));
        	else if(effect == 9)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(14), 40 * 20, 0));
        	else if(effect == 10)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(16), 40 * 20, 0));
        	else if(effect == 11)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(21), 20 * 20, 0));
        	else if(effect == 12)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(22), 20 * 20, 1));
        	else if(effect == 13)
        		playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(23), 20, 0));
        }
        if(fireTime != 0)
        {
        	playerIn.setFire(fireTime);
        }
        if(this == MItems.crushed_ice && !worldIn.isRemote)
        {
        	playerIn.extinguish();
        }
        if (this == MItems.bread_ice_cream && !worldIn.isRemote)
        {
        	playerIn.addStat(MAchievements.icecream, 1);
        	playerIn.extinguish();
        	playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(1), 30 * 20, 2));
        	playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(5), 30 * 20, 1));
        	playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(6), 1, 1));
        }
        if (this == MItems.bread_glowshroom_stew && !worldIn.isRemote)
        {
        	playerIn.addStat(MAchievements.reflux, 1);
        	playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(1), 30 * 20, 3));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(3), 30 * 20, 3));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(10), 30 * 20, 1));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(15), 30 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(16), 30 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.potionRegistry.getObjectById(9), 30 * 20, 0));
        }
        super.onItemUseFinish(stack, worldIn, playerIn);
        return stack;
    }
}