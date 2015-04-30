package com.delocuro.ministrappolation.blocks;

import java.util.List;
import java.util.Random;

import com.delocuro.ministrappolation.Minestrappolation;
import com.delocuro.ministrappolation.init.MBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBiomeBricks extends Block{
	
	private static final PropertyEnum VARIANT = PropertyEnum.create("type" , BlockBiomeStones.EnumType.class);
	
	public BlockBiomeBricks()
	{
		super(Material.rock);
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
		this.setUnlocalizedName("biome_bricks");
	}
	
	@Override
	protected BlockState createBlockState()
	{
	    return new BlockState(this, new IProperty[] {VARIANT});
	}
	
	/**
     * Get the damage value that this Block should drop
     */
    public int damageDropped(IBlockState state)
    {
        return ((BlockBiomeStones.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        BlockBiomeStones.EnumType[] aenumtype = BlockBiomeStones.EnumType.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
        	BlockBiomeStones.EnumType enumtype = aenumtype[j];
            list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
        }
    
    }
    
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockBiomeStones.EnumType.byMetadata(meta & 7));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockBiomeStones.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
    static final class SwitchEnumType
    {
        static final int[] WOOD_TYPE_LOOKUP = new int[BlockBiomeStones.EnumType.values().length];
        private static final String __OBFID = "CL_00002067";

        static
        {
            try
            {
                WOOD_TYPE_LOOKUP[BlockBiomeStones.EnumType.DEEPSTONE.ordinal()] = 1;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }
            try
            {
                WOOD_TYPE_LOOKUP[BlockBiomeStones.EnumType.REDROCK.ordinal()] = 2;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }
            try
            {
                WOOD_TYPE_LOOKUP[BlockBiomeStones.EnumType.DEEPREDROCK.ordinal()] = 3;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }
            try
            {
                WOOD_TYPE_LOOKUP[BlockBiomeStones.EnumType.COLDSTONE.ordinal()] = 4;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }
            try
            {
                WOOD_TYPE_LOOKUP[BlockBiomeStones.EnumType.DEEPCOLDSTONE.ordinal()] = 5;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }
            try
            {
                WOOD_TYPE_LOOKUP[BlockBiomeStones.EnumType.ICESTONE.ordinal()] = 6;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }
            try
            {
                WOOD_TYPE_LOOKUP[BlockBiomeStones.EnumType.GLACIERSTONE.ordinal()] = 7;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }
            try
            {
                WOOD_TYPE_LOOKUP[BlockBiomeStones.EnumType.OCEANSTONE.ordinal()] = 8;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }
            try
            {
                WOOD_TYPE_LOOKUP[BlockBiomeStones.EnumType.POCEANSTONE.ordinal()] = 9;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }
            
        }
    }
}
	