package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.entity.EntityIceball;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemChargeGun extends Item
{
    public static final String[] bowPullIconNameArray = new String[] {"pulling_0", "pulling_1", "pulling_2"};
    public Item ammo = new Item();

    public ItemChargeGun()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(548);
        this.setCreativeTab(Minestrappolation.tabMCombat);
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     *  
     * @param timeLeft The amount of ticks left before the using would have been complete
     */
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
    {
        int j = this.getMaxItemUseDuration(stack) - timeLeft;
        net.minecraftforge.event.entity.player.ArrowLooseEvent event = new net.minecraftforge.event.entity.player.ArrowLooseEvent(playerIn, stack, j);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return;
        j = event.charge;

        boolean flag = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;

        if (flag || playerIn.inventory.hasItem(Items.fire_charge) || playerIn.inventory.hasItem(MItems.ice_charge))
        {
            if(playerIn.inventory.hasItem(Items.fire_charge))
            	ammo = Items.fire_charge;
            else if(playerIn.inventory.hasItem(MItems.ice_charge))
            	ammo = MItems.ice_charge;
        	
        	float f = (float)j / 10.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            double accelX = (double)(-MathHelper.sin(playerIn.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(playerIn.rotationPitch / 180.0F * (float)Math.PI));
            double accelY = (double)(-MathHelper.sin(playerIn.rotationPitch / 180.0F * (float)Math.PI));
            double accelZ = (double)(MathHelper.cos(playerIn.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(playerIn.rotationPitch / 180.0F * (float)Math.PI));
            double d3 = (double)MathHelper.sqrt_double(accelX * accelX + accelY * accelY + accelZ * accelZ);
            
            EntityLargeFireball entityFireCharge = new EntityLargeFireball(worldIn);
            entityFireCharge.shootingEntity = playerIn;
            entityFireCharge.setLocationAndAngles(playerIn.posX, playerIn.posY + (double)(playerIn.height / 2.0F), playerIn.posZ, playerIn.rotationYaw, playerIn.rotationPitch);
            entityFireCharge.setPosition(entityFireCharge.posX, entityFireCharge.posY, entityFireCharge.posZ);
            entityFireCharge.motionX = entityFireCharge.motionY = entityFireCharge.motionZ = 0.0D;
            entityFireCharge.accelerationX = accelX / d3 * 0.1D * (1 + f);
            entityFireCharge.accelerationY = accelY / d3 * 0.1D * (1 + f);
            entityFireCharge.accelerationZ = accelZ / d3 * 0.1D * (1 + f);
            
            EntityIceball entityIceCharge = new EntityIceball(worldIn);
            entityIceCharge.shootingEntity = playerIn;
            entityIceCharge.setLocationAndAngles(playerIn.posX, playerIn.posY + (double)(playerIn.height / 2.0F + 0.5F), playerIn.posZ, playerIn.rotationYaw, playerIn.rotationPitch);
            entityIceCharge.setPosition(entityIceCharge.posX, entityIceCharge.posY, entityIceCharge.posZ);
            entityIceCharge.motionX = entityIceCharge.motionY = entityIceCharge.motionZ = 0.0D;
            entityIceCharge.accelerationX = accelX / d3 * 0.1D * (1 + f);
            entityIceCharge.accelerationY = accelY / d3 * 0.1D * (1 + f);
            entityIceCharge.accelerationZ = accelZ / d3 * 0.1D * (1 + f);
            
            stack.damageItem(1, playerIn);
            worldIn.playAuxSFXAtEntity(playerIn, 1009, new BlockPos((int)playerIn.posX, (int)playerIn.posY, (int)playerIn.posZ), 0);

            if(!flag)
            {
                playerIn.inventory.consumeInventoryItem(ammo);
            }

            playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);

            if (!worldIn.isRemote)
            {
            	if(ammo == Items.fire_charge)
            		worldIn.spawnEntityInWorld(entityFireCharge);
            	else if(ammo == MItems.ice_charge)
            		worldIn.spawnEntityInWorld(entityIceCharge);
            }
        }
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        return stack;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        net.minecraftforge.event.entity.player.ArrowNockEvent event = new net.minecraftforge.event.entity.player.ArrowNockEvent(playerIn, itemStackIn);
        if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return event.result;

        if (playerIn.capabilities.isCreativeMode || playerIn.inventory.hasItem(Items.fire_charge) || playerIn.inventory.hasItem(MItems.ice_charge))
        {
            playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        }

        return itemStackIn;
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
}