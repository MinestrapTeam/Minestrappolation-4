package com.delocuro.ministrappolation.blocks;

import java.util.List;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.delocuro.ministrappolation.Ministrappolation;
import com.google.common.base.Predicate;

public class BlockMinistrappLog extends BlockLog
{
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockMinistrappPlanks.EnumType.class, new Predicate()
    {
        private static final String __OBFID = "CL_00002084";
        public boolean apply(BlockMinistrappPlanks.EnumType type)
        {
            return type.getMetadata() < 4;
        }
        public boolean apply(Object p_apply_1_)
        {
            return this.apply((BlockMinistrappPlanks.EnumType)p_apply_1_);
        }
    });
    private static final String __OBFID = "CL_00000281";

    public BlockMinistrappLog()
    {
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockMinistrappPlanks.EnumType.REDWOOD).withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
        this.setCreativeTab(Ministrappolation.tabMinistrappolation);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(itemIn, 1, BlockMinistrappPlanks.EnumType.REDWOOD.getMetadata()));
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, BlockMinistrappPlanks.EnumType.byMetadata((meta & 3) % 4));

        switch (meta & 12)
        {
            case 0:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
                break;
            case 8:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
                break;
            default:
                iblockstate = iblockstate.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }

        return iblockstate;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((BlockMinistrappPlanks.EnumType)state.getValue(VARIANT)).getMetadata();

        switch (BlockMinistrappLog.SwitchEnumAxis.AXIS_LOOKUP[((BlockLog.EnumAxis)state.getValue(LOG_AXIS)).ordinal()])
        {
            case 1:
                i |= 4;
                break;
            case 2:
                i |= 8;
                break;
            case 3:
                i |= 12;
        }

        return i;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT, LOG_AXIS});
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, ((BlockMinistrappPlanks.EnumType)state.getValue(VARIANT)).getMetadata());
    }

    /**
     * Get the damage value that this Block should drop
     */
    public int damageDropped(IBlockState state)
    {
        return ((BlockMinistrappPlanks.EnumType)state.getValue(VARIANT)).getMetadata();
    }

    static final class SwitchEnumAxis
        {
            static final int[] AXIS_LOOKUP = new int[BlockLog.EnumAxis.values().length];
            private static final String __OBFID = "CL_00002083";

            static
            {
                try
                {
                    AXIS_LOOKUP[BlockLog.EnumAxis.X.ordinal()] = 1;
                }
                catch (NoSuchFieldError var3)
                {
                    ;
                }

                try
                {
                    AXIS_LOOKUP[BlockLog.EnumAxis.Z.ordinal()] = 2;
                }
                catch (NoSuchFieldError var2)
                {
                    ;
                }

                try
                {
                    AXIS_LOOKUP[BlockLog.EnumAxis.NONE.ordinal()] = 3;
                }
                catch (NoSuchFieldError var1)
                {
                    ;
                }
            }
        }
}
