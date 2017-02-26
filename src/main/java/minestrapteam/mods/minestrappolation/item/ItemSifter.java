package minestrapteam.mods.minestrappolation.item;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.util.Chance;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

public class ItemSifter extends Item{
	
	public Boolean isReusable;
	public Item base;
	
	public ItemSifter(int durability, boolean reusable)
    {
        this.maxStackSize = 1;
        this.setMaxDamage(durability);
        this.isDamageable();
        this.setCreativeTab(Minestrappolation.tabMTools);
        this.isReusable = reusable;
    }
	
	public ItemSifter(int durability, boolean reusable, Item base)
    {
        this.maxStackSize = 1;
        this.setMaxDamage(durability);
        this.isDamageable();
        this.setCreativeTab(Minestrappolation.tabMTools);
        this.isReusable = reusable;
        this.base = base;
    }
	
	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
			
			if (worldIn.getBlockState(pos) == Blocks.sand.getStateFromMeta(0))
            {
                this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_sand");
                playerIn.addStat(MAchievements.sifter, 1);
            }
			else if (worldIn.getBlockState(pos) == Blocks.sand.getStateFromMeta(1))
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_red_sand"); 
            }
			else if (worldIn.getBlockState(pos).getBlock() == Blocks.clay)
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_clay");
            }
			else if (worldIn.getBlockState(pos).getBlock() == MBlocks.mud)
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_mud");
            }
			else if (worldIn.getBlockState(pos).getBlock() == MBlocks.rubble)
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_rubble");
            }
			else if (worldIn.getBlockState(pos).getBlock() == Blocks.gravel)
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_gravel");
            }
			else if (worldIn.getBlockState(pos) == Blocks.dirt.getStateFromMeta(0) || worldIn.getBlockState(pos) == Blocks.dirt.getStateFromMeta(1) || worldIn.getBlockState(pos).getBlock() == Blocks.grass)
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_dirt");
            }
			else if (worldIn.getBlockState(pos) == Blocks.dirt.getStateFromMeta(2))
			{
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_podzol");
			}
			else if (worldIn.getBlockState(pos).getBlock() == Blocks.mycelium)
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_mycelium");
            }
			else if (worldIn.getBlockState(pos).getBlock() == MBlocks.dirt_permafrost || worldIn.getBlockState(pos).getBlock() == MBlocks.lichen_permafrost)
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_permafrost");
            }
			else if (worldIn.getBlockState(pos).getBlock() == MBlocks.cold_sand)
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_cold_sand");
            }
			else if (worldIn.getBlockState(pos).getBlock() == Blocks.soul_sand)
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_soul_sand");
            }
			else if (worldIn.getBlockState(pos) == MBlocks.virtian_soil.getStateFromMeta(0) || worldIn.getBlockState(pos) == MBlocks.virtian_soil.getStateFromMeta(1) || worldIn.getBlockState(pos).getBlock() == MBlocks.virtian_grass)
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_virtian_soil");
            }
			else if (worldIn.getBlockState(pos) == MBlocks.virtian_soil.getStateFromMeta(2))
            {
				this.spawnDropFrom(stack, playerIn, worldIn, pos, "sifter_viartian_ash");
            }
            return true;
    }
	
	private void spawnDropFrom(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, String table)
	{
		worldIn.destroyBlock(pos, false);       
        ItemStack drop = (ItemStack)Chance.getRandomFromTable(table);
        if(drop != null)
        {
        	drop.stackSize = 1; 
        	if(!worldIn.isRemote)
        	{
        		EntityItem ei = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, drop);
        		worldIn.spawnEntityInWorld(ei);
        		if(playerIn instanceof FakePlayer)
        			ei.onCollideWithPlayer(playerIn);
        	}
        }	
        if(isReusable == false)
        {
        	stack.damageItem(1, playerIn);
        }
        else if(isReusable == true)
        {
        	if(stack.getItemDamage() == stack.getMaxDamage())
        	{
        		stack.setItem(base);
        	 	stack.setItemDamage(0);
        	}
        	else
        	{
        		stack.damageItem(1, playerIn);
        	}
        }
	}
}
