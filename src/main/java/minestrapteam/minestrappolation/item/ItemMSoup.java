package minestrapteam.minestrappolation.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMSoup extends ItemFood
{
    public ItemMSoup(int healAmount, float saturation)
    {
        super(healAmount, saturation, false);
        this.setMaxStackSize(1);
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityPlayer playerIn)
    {
        super.onItemUseFinish(stack, worldIn, playerIn);
        return new ItemStack(Items.bowl);
    }
}