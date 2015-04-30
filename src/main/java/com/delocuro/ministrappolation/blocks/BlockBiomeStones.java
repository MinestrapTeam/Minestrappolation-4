package com.delocuro.ministrappolation.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.delocuro.ministrappolation.Minestrappolation;
import com.delocuro.ministrappolation.Reference;
import com.delocuro.ministrappolation.init.MBlocks;

public class BlockBiomeStones extends Block
{
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockBiomeStones.EnumType.class);

    public BlockBiomeStones()
    {
        super(Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockBiomeStones.EnumType.DEEPSTONE));
        this.setCreativeTab(Minestrappolation.tabMinistrappolation);
    }
    
    /**
     * Get the Item that this Block should drop when harvested.
     *  
     * @param fortune the level of the Fortune enchantment on the player's tool
     */
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(MBlocks.biome_cobble.getStateFromMeta(this.getMetaFromState(state)).getBlock());
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
        return this.getDefaultState().withProperty(VARIANT, BlockBiomeStones.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockBiomeStones.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT});
    }

    public static enum EnumType implements IStringSerializable
    {
        DEEPSTONE(0, "deepstone"),
        REDROCK(1, "red_rock"),
        DEEPREDROCK(2, "deep_redrock"),
        COLDSTONE(3, "coldstone"),
        DEEPCOLDSTONE(4, "deep_coldstone"),
        ICESTONE(5, "icestone"),
        GLACIERSTONE(6, "glacierrock"),
        OCEANSTONE(7, "oceanstone"),
        POCEANSTONE(8, "p_oceanstone");
        private static final BlockBiomeStones.EnumType[] META_LOOKUP = new BlockBiomeStones.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;

        private EnumType(int meta, String name)
        {
            this(meta, name, name);
        }

        private EnumType(int meta, String name, String unlocalizedName)
        {
            this.meta = meta;
            this.name = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.name;
        }

        public static BlockBiomeStones.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            BlockBiomeStones.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
                BlockBiomeStones.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
}