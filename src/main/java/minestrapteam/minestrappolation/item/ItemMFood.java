package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.lib.MItems;
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
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        if(this == MItems.bread_rice_bowl || this == MItems.bread_stir_fry)
        {
    		EntityItem eitem = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(Items.stick, 1));
        	worldIn.spawnEntityInWorld(eitem);
    	}
        if (this == MItems.pbj_sandwich && !worldIn.isRemote)
        {
        	playerIn.addPotionEffect(new PotionEffect(Potion.healthBoost.id, 10 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.heal.id, 1 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10 * 20, 0));
            playerIn.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 10 * 20, 0));
        }
        if(fireTime != 0)
        {
        	playerIn.setFire(fireTime);
        }
        super.onItemUseFinish(stack, worldIn, playerIn);
        return stack;
    }
}