package com.delocuro.ministrappolation.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.delocuro.ministrappolation.init.MinestrappolationBlocks;
import com.delocuro.ministrappolation.init.MinistrappolationItems;

public class BlockMinistrappOre extends MBlock{
	
	private final MapColor mapColor;
	
	public BlockMinistrappOre(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn, mapColorIn);
		this.mapColor = mapColorIn;
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this == MinestrappolationBlocks.sunstone_ore ? MinistrappolationItems.sunstone_shard : Item.getItemFromBlock(this);
    }
	
	public int quantityDropped(Random random)
    {
		return this == MinestrappolationBlocks.sunstone_ore ? 1 + random.nextInt(3) : 1;
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }

            return this.quantityDropped(random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }
    
    @Override
    public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
    {
        IBlockState state = world.getBlockState(pos);
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int j = 0;

            if (this == MinestrappolationBlocks.sunstone_ore)
            {
                j = MathHelper.getRandomIntegerInRange(rand, 2, 5);
            }

            return j;
        }
        return 0;
    }
}
