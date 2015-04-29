package com.delocuro.ministrappolation.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.delocuro.ministrappolation.Minestrappolation;
import com.delocuro.ministrappolation.world.WorldGenRedWoodTree;
import com.delocuro.ministrappolation.world.WorldGenRedWoodTreeSmall;

public class BlockMSapling extends BlockBush implements IGrowable {
	
	private static final PropertyEnum TYPE = PropertyEnum.create("type" , BlockMinistrappPlanks.EnumType.class);
	 public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
	
	public BlockMSapling()
	{
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, BlockMinistrappPlanks.EnumType.REDWOOD).withProperty(STAGE, Integer.valueOf(0)));
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                this.grow(worldIn, pos, state, rand);
            }
        }
    }
	
	public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (((Integer)state.getValue(STAGE)).intValue() == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateTree(worldIn, pos, state, rand);
        }
    }
	
	@Override
	protected BlockState createBlockState()
	{
	    return new BlockState(this, new IProperty[] {TYPE, STAGE});
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}
	
	public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        Object object = rand.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true);
        int i = 0;
        int j = 0;
        boolean flag = false;

        switch (BlockMSapling.SwitchEnumType.WOOD_TYPE_LOOKUP[((BlockMinistrappPlanks.EnumType)state.getValue(TYPE)).ordinal()])
        {       
            case 1:
            	label78:

                    for (i = 0; i >= -1; --i)
                    {
                        for (j = 0; j >= -1; --j)
                        {
                            if (this.isTypeAt(worldIn, pos.add(i, 0, j), BlockMinistrappPlanks.EnumType.REDWOOD) && this.isTypeAt(worldIn, pos.add(i + 1, 0, j), BlockMinistrappPlanks.EnumType.REDWOOD) && this.isTypeAt(worldIn, pos.add(i, 0, j + 1), BlockMinistrappPlanks.EnumType.REDWOOD) && this.isTypeAt(worldIn, pos.add(i + 1, 0, j + 1), BlockMinistrappPlanks.EnumType.REDWOOD))
                            {
                                object = new WorldGenRedWoodTree();
                                flag = true;
                                break label78;
                            }
                        }
                    }

                    if (!flag)
                    {
                        j = 0;
                        i = 0;
                        object = new WorldGenRedWoodTreeSmall();
                    }              
        }

        IBlockState iblockstate1 = Blocks.air.getDefaultState();

        if (flag)
        {
            worldIn.setBlockState(pos.add(i, 0, j), iblockstate1, 4);
            worldIn.setBlockState(pos.add(i + 1, 0, j), iblockstate1, 4);
            worldIn.setBlockState(pos.add(i, 0, j + 1), iblockstate1, 4);
            worldIn.setBlockState(pos.add(i + 1, 0, j + 1), iblockstate1, 4);
        }
        else
        {
            worldIn.setBlockState(pos, iblockstate1, 4);
        }

        if (!((WorldGenerator)object).generate(worldIn, rand, pos.add(i, 0, j)))
        {
            if (flag)
            {
                worldIn.setBlockState(pos.add(i, 0, j), state, 4);
                worldIn.setBlockState(pos.add(i + 1, 0, j), state, 4);
                worldIn.setBlockState(pos.add(i, 0, j + 1), state, 4);
                worldIn.setBlockState(pos.add(i + 1, 0, j + 1), state, 4);
            }
            else
            {
                worldIn.setBlockState(pos, state, 4);
            }
        }
    }
	
	/**
     * Check whether the given BlockPos has a Sapling of the given type
     */
    public boolean isTypeAt(World worldIn, BlockPos pos, BlockMinistrappPlanks.EnumType type)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        return iblockstate.getBlock() == this && iblockstate.getValue(TYPE) == type;
    }
	
	/**
     * Get the damage value that this Block should drop
     */
    public int damageDropped(IBlockState state)
    {
        return ((BlockMinistrappPlanks.EnumType)state.getValue(TYPE)).getMetadata();
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        BlockMinistrappPlanks.EnumType[] aenumtype = BlockMinistrappPlanks.EnumType.values();
        int i = aenumtype.length;

        for (int j = 0; j < i; ++j)
        {
            BlockMinistrappPlanks.EnumType enumtype = aenumtype[j];
            list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
        }
    
    }
    
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(TYPE, BlockMinistrappPlanks.EnumType.byMetadata(meta & 7)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((BlockMinistrappPlanks.EnumType)state.getValue(TYPE)).getMetadata();
        i |= ((Integer)state.getValue(STAGE)).intValue() << 3;
        return i;
    }
	
	static final class SwitchEnumType
    {
        static final int[] WOOD_TYPE_LOOKUP = new int[BlockMinistrappPlanks.EnumType.values().length];
        private static final String __OBFID = "CL_00002067";

        static
        {
            try
            {
                WOOD_TYPE_LOOKUP[BlockMinistrappPlanks.EnumType.REDWOOD.ordinal()] = 1;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }
            
        }
    }

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		 return (double)worldIn.rand.nextFloat() < 0.45D;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		this.grow(worldIn, pos, state, rand);
	}

}
