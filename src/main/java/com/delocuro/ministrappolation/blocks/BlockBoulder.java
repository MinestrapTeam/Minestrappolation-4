package com.delocuro.ministrappolation.blocks;

import java.util.Random;

import com.delocuro.ministrappolation.init.MItems;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockBoulder extends BlockFalling
{
	private final MapColor mapColor;
	
	public BlockBoulder(Material materialIn, MapColor mapColorIn) {
		super(materialIn);
		this.mapColor = mapColorIn;
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if (fortune > 3)
        {
            fortune = 3;
        }
        
        if (rand.nextInt(100 - fortune * 3) <= 30)
        {
        	return Items.coal;
        }
        else if (rand.nextInt(100 - fortune * 3) <= 10)
        {
        	if(rand.nextInt(2) == 1)
        	{
        		return Items.gunpowder;
        	}
        	else
        	{
        		return Items.flint;
        	}
        }
        else if (rand.nextInt(100 - fortune * 3) <= 8)
        {
        	return Item.getItemFromBlock(Blocks.iron_ore);
        }
        else if (rand.nextInt(100 - fortune * 3) <= 3)
        {
        	if(rand.nextInt(2) == 1)
        	{
        		return Items.redstone;
        	}
        	else
        	{
        		return MItems.sunstone_shard;
        	}
        }
        else if (rand.nextInt(100 - fortune * 10) == 1)
        {
        	if(rand.nextInt(2) == 1)
        	{
        		return Items.emerald;
        	}
        	else
        	{
        		return Items.diamond;
        	}
        }
        else
        {
        	return Item.getItemFromBlock(Blocks.cobblestone);
        }
    }
	
	protected void onStartFalling(EntityFallingBlock fallingEntity)
    {
        fallingEntity.setHurtEntities(true);
    }

    public void onEndFalling(World worldIn, BlockPos pos)
    {
        worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), "dig.stone", 2.0F, 0.1F);
    }
}
