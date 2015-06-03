package minestrapteam.minestrappolation.item;

import java.util.ArrayList;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.lib.MAchievements;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.util.Chance;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSifter extends Item{

	public ItemSifter()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(9);
        this.isDamageable();
        this.setCreativeTab(Minestrappolation.tabMTools);
    }
	
	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
			if (worldIn.getBlockState(pos).getBlock() == Blocks.sand)
            {
                worldIn.destroyBlock(pos, false);       
                if(!worldIn.isRemote)
                {
                	ItemStack drop = new ItemStack((Item)Chance.getRandomFromTable("sifter"), 1, 0);
                    EntityItem eitem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), drop);
                    if(drop != null)
                    {
                    	worldIn.spawnEntityInWorld(eitem);		
                    }
                }  	
                stack.damageItem(1, playerIn); 
                playerIn.addStat(MAchievements.sifter, 1);
            }     
            return true;
    }
}
