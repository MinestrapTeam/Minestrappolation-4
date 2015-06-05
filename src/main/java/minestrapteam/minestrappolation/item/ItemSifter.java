package minestrapteam.minestrappolation.item;

import java.util.ArrayList;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.lib.MAchievements;
import minestrapteam.minestrappolation.lib.MBlocks;
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
        this.setMaxDamage(36);
        this.isDamageable();
        this.setCreativeTab(Minestrappolation.tabMTools);
    }
	
	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
			if (worldIn.getBlockState(pos) == Blocks.sand.getStateFromMeta(0))
            {
                worldIn.destroyBlock(pos, false);       
                if(!worldIn.isRemote)
                {
                	ItemStack drop = new ItemStack((Item)Chance.getRandomFromTable("sifter_sand"), 1);
                    EntityItem eitem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), drop);
                    if(drop != null)
                    {
                    	worldIn.spawnEntityInWorld(eitem);		
                    }
                }  	
                stack.damageItem(1, playerIn); 
                playerIn.addStat(MAchievements.sifter, 1);
            }
			else if (worldIn.getBlockState(pos) == Blocks.sand.getStateFromMeta(1))
            {
                worldIn.destroyBlock(pos, false);       
                if(!worldIn.isRemote)
                {
                	ItemStack drop = new ItemStack((Item)Chance.getRandomFromTable("sifter_red_sand"), 1);
                    EntityItem eitem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), drop);
                    if(drop != null)
                    {
                    	worldIn.spawnEntityInWorld(eitem);		
                    }
                }  	
                stack.damageItem(1, playerIn); 
                playerIn.addStat(MAchievements.sifter, 1);
            }
			else if (worldIn.getBlockState(pos).getBlock() == Blocks.gravel)
            {
                worldIn.destroyBlock(pos, false);       
                if(!worldIn.isRemote)
                {
                	ItemStack drop = new ItemStack((Item)Chance.getRandomFromTable("sifter_gravel"), 1);
                    EntityItem eitem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), drop);
                    if(drop != null)
                    {
                    	worldIn.spawnEntityInWorld(eitem);		
                    }
                }  	
                stack.damageItem(1, playerIn); 
                playerIn.addStat(MAchievements.sifter, 1);
            }
			else if (worldIn.getBlockState(pos).getBlock() == Blocks.dirt)
            {
                worldIn.destroyBlock(pos, false);       
                if(!worldIn.isRemote)
                {
                	ItemStack drop = new ItemStack((Item)Chance.getRandomFromTable("sifter_dirt"), 1);
                    EntityItem eitem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), drop);
                    if(drop != null)
                    {
                    	worldIn.spawnEntityInWorld(eitem);		
                    }
                }  	
                stack.damageItem(1, playerIn); 
                playerIn.addStat(MAchievements.sifter, 1);
            }
			else if (worldIn.getBlockState(pos).getBlock() == Blocks.grass)
            {
                worldIn.destroyBlock(pos, false);       
                if(!worldIn.isRemote)
                {
                	ItemStack drop = new ItemStack((Item)Chance.getRandomFromTable("sifter_dirt"), 1);
                    EntityItem eitem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), drop);
                    if(drop != null)
                    {
                    	worldIn.spawnEntityInWorld(eitem);		
                    }
                }  	
                stack.damageItem(1, playerIn); 
                playerIn.addStat(MAchievements.sifter, 1);
            }
			else if (worldIn.getBlockState(pos).getBlock() == Blocks.mycelium)
            {
                worldIn.destroyBlock(pos, false);       
                if(!worldIn.isRemote)
                {
                	ItemStack drop = new ItemStack((Item)Chance.getRandomFromTable("sifter_mycelium"), 1);
                    EntityItem eitem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), drop);
                    if(drop != null)
                    {
                    	worldIn.spawnEntityInWorld(eitem);		
                    }
                }  	
                stack.damageItem(1, playerIn); 
                playerIn.addStat(MAchievements.sifter, 1);
            }
			else if (worldIn.getBlockState(pos).getBlock() == MBlocks.dirt_permafrost)
            {
                worldIn.destroyBlock(pos, false);       
                if(!worldIn.isRemote)
                {
                	ItemStack drop = new ItemStack((Item)Chance.getRandomFromTable("sifter_permafrost"), 1);
                    EntityItem eitem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), drop);
                    if(drop != null)
                    {
                    	worldIn.spawnEntityInWorld(eitem);		
                    }
                }  	
                stack.damageItem(1, playerIn); 
                playerIn.addStat(MAchievements.sifter, 1);
            }
			else if (worldIn.getBlockState(pos).getBlock() == MBlocks.lichen_permafrost)
            {
                worldIn.destroyBlock(pos, false);       
                if(!worldIn.isRemote)
                {
                	ItemStack drop = new ItemStack((Item)Chance.getRandomFromTable("sifter_permafrost"), 1);
                    EntityItem eitem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), drop);
                    if(drop != null)
                    {
                    	worldIn.spawnEntityInWorld(eitem);		
                    }
                }  	
                stack.damageItem(1, playerIn); 
                playerIn.addStat(MAchievements.sifter, 1);
            }
			else if (worldIn.getBlockState(pos).getBlock() == MBlocks.cold_sand)
            {
                worldIn.destroyBlock(pos, false);       
                if(!worldIn.isRemote)
                {
                	ItemStack drop = new ItemStack((Item)Chance.getRandomFromTable("sifter_cold_sand"), 1);
                    EntityItem eitem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), drop);
                    if(drop != null)
                    {
                    	worldIn.spawnEntityInWorld(eitem);		
                    }
                }  	
                stack.damageItem(1, playerIn); 
                playerIn.addStat(MAchievements.sifter, 1);
            }
			else if (worldIn.getBlockState(pos).getBlock() == Blocks.soul_sand)
            {
                worldIn.destroyBlock(pos, false);       
                if(!worldIn.isRemote)
                {
                	ItemStack drop = new ItemStack((Item)Chance.getRandomFromTable("sifter_soul_sand"), 1);
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
