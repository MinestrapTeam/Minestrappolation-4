package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.enumtypes.MWoodType;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MBlockSketchyBackwaterFlowerpot extends BlockContainer
{
    public static final PropertyInteger LEGACY_DATA = PropertyInteger.create("legacy_data", 0, 15);
    public static final PropertyEnum CONTENTS = PropertyEnum.create("contents", MBlockSketchyBackwaterFlowerpot.EnumFlowerType.class);

    public MBlockSketchyBackwaterFlowerpot()
    {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(CONTENTS, MBlockSketchyBackwaterFlowerpot.EnumFlowerType.EMPTY).withProperty(LEGACY_DATA, Integer.valueOf(0)));
        this.setBlockBoundsForItemRender();
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        float f = 0.375F;
        float f1 = f / 2.0F;
        this.setBlockBounds(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f, 0.5F + f1);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 3;
    }

    public boolean isFullCube()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityFlowerPot)
        {
            Item item = ((TileEntityFlowerPot)tileentity).getFlowerPotItem();

            if (item instanceof ItemBlock)
            {
                return Block.getBlockFromItem(item).colorMultiplier(worldIn, pos, renderPass);
            }
        }

        return 16777215;
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = playerIn.inventory.getCurrentItem();

        if (itemstack != null && itemstack.getItem() instanceof ItemBlock)
        {
            TileEntityFlowerPot tileentityflowerpot = this.getTileEntity(worldIn, pos);

            if (tileentityflowerpot == null)
            {
                return false;
            }
            else if (tileentityflowerpot.getFlowerPotItem() != null)
            {
                return false;
            }
            else
            {
                Block block = Block.getBlockFromItem(itemstack.getItem());

                if (!this.canNotContain(block, itemstack.getMetadata()))
                {
                    return false;
                }
                else
                {
                    tileentityflowerpot.setFlowerPotData(itemstack.getItem(), itemstack.getMetadata());
                    tileentityflowerpot.markDirty();
                    worldIn.markBlockForUpdate(pos);

                    if (!playerIn.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                    {
                        playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, (ItemStack)null);
                    }

                    return true;
                }
            }
        }
        else
        {
            return false;
        }
    }

    private boolean canNotContain(Block blockIn, int meta)
    {
        return blockIn != Blocks.yellow_flower && blockIn != Blocks.red_flower && blockIn != Blocks.cactus && blockIn != Blocks.brown_mushroom && blockIn != Blocks.red_mushroom && blockIn != Blocks.sapling && blockIn != MBlocks.ministrapp_sapling && blockIn != Blocks.deadbush ? blockIn == Blocks.tallgrass && meta == BlockTallGrass.EnumType.FERN.getMeta() : true;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        TileEntityFlowerPot tileentityflowerpot = this.getTileEntity(worldIn, pos);
        return tileentityflowerpot != null && tileentityflowerpot.getFlowerPotItem() != null ? tileentityflowerpot.getFlowerPotItem() : Item.getItemFromBlock(MBlocks.ministrapp_flower_pot);
    }

    public int getDamageValue(World worldIn, BlockPos pos)
    {
        TileEntityFlowerPot tileentityflowerpot = this.getTileEntity(worldIn, pos);
        return tileentityflowerpot != null && tileentityflowerpot.getFlowerPotItem() != null ? tileentityflowerpot.getFlowerPotData() : 0;
    }

    /**
     * Returns true only if block is flowerPot
     */
    @SideOnly(Side.CLIENT)
    public boolean isFlowerPot()
    {
        return true;
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) && World.doesBlockHaveSolidTopSurface(worldIn, pos.down());
    }

    /**
     * Called when a neighboring block changes.
     */
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!World.doesBlockHaveSolidTopSurface(worldIn, pos.down()))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }

    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        super.breakBlock(worldIn, pos, state);
    }

    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
    {
        super.onBlockHarvested(worldIn, pos, state, player);

        if (player.capabilities.isCreativeMode)
        {
            TileEntityFlowerPot tileentityflowerpot = this.getTileEntity(worldIn, pos);

            if (tileentityflowerpot != null)
            {
                tileentityflowerpot.setFlowerPotData((Item)null, 0);
            }
        }
    }

    /**
     * Get the Item that this Block should drop when harvested.
     *  
     * @param fortune the level of the Fortune enchantment on the player's tool
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(MBlocks.ministrapp_flower_pot);
    }

    private TileEntityFlowerPot getTileEntity(World worldIn, BlockPos pos)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity instanceof TileEntityFlowerPot ? (TileEntityFlowerPot)tileentity : null;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        Object object = null;
        int j = 0;

        switch (meta)
        {
            case 1:
                object = Blocks.red_flower;
                j = BlockFlower.EnumFlowerType.POPPY.getMeta();
                break;
            case 2:
                object = Blocks.yellow_flower;
                break;
            case 3:
                object = Blocks.sapling;
                j = BlockPlanks.EnumType.OAK.getMetadata();
                break;
            case 4:
                object = Blocks.sapling;
                j = BlockPlanks.EnumType.SPRUCE.getMetadata();
                break;
            case 5:
                object = Blocks.sapling;
                j = BlockPlanks.EnumType.BIRCH.getMetadata();
                break;
            case 6:
                object = Blocks.sapling;
                j = BlockPlanks.EnumType.JUNGLE.getMetadata();
                break;
            case 7:
                object = Blocks.red_mushroom;
                break;
            case 8:
                object = Blocks.brown_mushroom;
                break;
            case 9:
                object = Blocks.cactus;
                break;
            case 10:
                object = Blocks.deadbush;
                break;
            case 11:
                object = Blocks.tallgrass;
                j = BlockTallGrass.EnumType.FERN.getMeta();
                break;
            case 12:
                object = Blocks.sapling;
                j = BlockPlanks.EnumType.ACACIA.getMetadata();
                break;
            case 13:
                object = Blocks.sapling;
                j = BlockPlanks.EnumType.DARK_OAK.getMetadata();
            case 14:
            	object = MBlocks.ministrapp_sapling;
            	j = MWoodType.REDWOOD.getMetadata();
            case 15:
            	object = MBlocks.ministrapp_sapling;
            	j = MWoodType.FROZEN.getMetadata();
        }

        return new TileEntityFlowerPot(Item.getItemFromBlock((Block)object), j);
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {CONTENTS, LEGACY_DATA});
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(LEGACY_DATA)).intValue();
    }

    /**
     * Get the actual Block state of this Block at the given position. This applies properties not visible in the
     * metadata, such as fence connections.
     */
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        MBlockSketchyBackwaterFlowerpot.EnumFlowerType enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.EMPTY;
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityFlowerPot)
        {
            TileEntityFlowerPot tileentityflowerpot = (TileEntityFlowerPot)tileentity;
            Item item = tileentityflowerpot.getFlowerPotItem();

            if (item instanceof ItemBlock)
            {
                int i = tileentityflowerpot.getFlowerPotData();
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.sapling)
                {
                    switch (MBlockSketchyBackwaterFlowerpot.SwitchEnumType.WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.byMetadata(i).ordinal()])
                    {
                        case 1:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.OAK_SAPLING;
                            break;
                        case 2:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.SPRUCE_SAPLING;
                            break;
                        case 3:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.BIRCH_SAPLING;
                            break;
                        case 4:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.JUNGLE_SAPLING;
                            break;
                        case 5:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.ACACIA_SAPLING;
                            break;
                        case 6:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.DARK_OAK_SAPLING;
                            break;
                        default:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.EMPTY;
                    }
                }
                else if (block == MBlocks.ministrapp_sapling)
                {
                	switch(MBlockSketchyBackwaterFlowerpot.SwitchEnumType.MWOOD_TYPE_LOOKUP[MWoodType.byMetadata(i).ordinal()])
                	{
                		case 1:
                			enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.REDWOOD_SAPLING;
                			break;
                		case 2:
                			enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.FROZEN_OAK_SAPLING;
                			break;
                		default:
                			enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.EMPTY;
                	}
                }
                else if (block == Blocks.tallgrass)
                {
                    switch (i)
                    {
                        case 0:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.DEAD_BUSH;
                            break;
                        case 2:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.FERN;
                            break;
                        default:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.EMPTY;
                    }
                }
                else if (block == Blocks.yellow_flower)
                {
                    enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.DANDELION;
                }
                else if (block == Blocks.red_flower)
                {
                    switch (MBlockSketchyBackwaterFlowerpot.SwitchEnumType.FLOWER_TYPE_LOOKUP[BlockFlower.EnumFlowerType.getType(BlockFlower.EnumFlowerColor.RED, i).ordinal()])
                    {
                        case 1:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.POPPY;
                            break;
                        case 2:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.BLUE_ORCHID;
                            break;
                        case 3:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.ALLIUM;
                            break;
                        case 4:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.HOUSTONIA;
                            break;
                        case 5:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.RED_TULIP;
                            break;
                        case 6:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.ORANGE_TULIP;
                            break;
                        case 7:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.WHITE_TULIP;
                            break;
                        case 8:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.PINK_TULIP;
                            break;
                        case 9:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.OXEYE_DAISY;
                            break;
                        default:
                            enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.EMPTY;
                    }
                }
                else if (block == Blocks.red_mushroom)
                {
                    enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.MUSHROOM_RED;
                }
                else if (block == Blocks.brown_mushroom)
                {
                    enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.MUSHROOM_BROWN;
                }
                else if (block == Blocks.deadbush)
                {
                    enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.DEAD_BUSH;
                }
                else if (block == Blocks.cactus)
                {
                    enumflowertype = MBlockSketchyBackwaterFlowerpot.EnumFlowerType.CACTUS;
                }
            }
        }

        return state.withProperty(CONTENTS, enumflowertype);
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }


    /*============================FORGE START=====================================*/
    @Override
    public java.util.List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        java.util.List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
        TileEntityFlowerPot te = world.getTileEntity(pos) instanceof TileEntityFlowerPot ? (TileEntityFlowerPot)world.getTileEntity(pos) : null;
        if (te != null && te.getFlowerPotItem() != null)
            ret.add(new ItemStack(te.getFlowerPotItem(), 1, te.getFlowerPotData()));
        return ret;
    }
    @Override
    public boolean removedByPlayer(World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
    {
        if (willHarvest) return true; //If it will harvest, delay deletion of the block until after getDrops
        return super.removedByPlayer(world, pos, player, willHarvest);
    }
    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te)
    {
        super.harvestBlock(world, player, pos, state, te);
        world.setBlockToAir(pos);
    }
    /*===========================FORGE END==========================================*/

    public static enum EnumFlowerType implements IStringSerializable
    {
        EMPTY("empty"),
        POPPY("rose"),
        BLUE_ORCHID("blue_orchid"),
        ALLIUM("allium"),
        HOUSTONIA("houstonia"),
        RED_TULIP("red_tulip"),
        ORANGE_TULIP("orange_tulip"),
        WHITE_TULIP("white_tulip"),
        PINK_TULIP("pink_tulip"),
        OXEYE_DAISY("oxeye_daisy"),
        DANDELION("dandelion"),
        OAK_SAPLING("oak_sapling"),
        SPRUCE_SAPLING("spruce_sapling"),
        BIRCH_SAPLING("birch_sapling"),
        JUNGLE_SAPLING("jungle_sapling"),
        ACACIA_SAPLING("acacia_sapling"),
        DARK_OAK_SAPLING("dark_oak_sapling"),
        MUSHROOM_RED("mushroom_red"),
        MUSHROOM_BROWN("mushroom_brown"),
        DEAD_BUSH("dead_bush"),
        FERN("fern"),
        CACTUS("cactus"),
        REDWOOD_SAPLING("redwood_sapling"),
        FROZEN_OAK_SAPLING("frozen_oak_sapling");
        private final String name;

        private static final String __OBFID = "CL_00002115";

        private EnumFlowerType(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return this.name;
        }

        public String getName()
        {
            return this.name;
        }
    }

    static final class SwitchEnumType
        {
            static final int[] WOOD_TYPE_LOOKUP;
            static final int[] MWOOD_TYPE_LOOKUP;

            static final int[] FLOWER_TYPE_LOOKUP = new int[BlockFlower.EnumFlowerType.values().length];
            private static final String __OBFID = "CL_00002116";

            static
            {
                try
                {
                    FLOWER_TYPE_LOOKUP[BlockFlower.EnumFlowerType.POPPY.ordinal()] = 1;
                }
                catch (NoSuchFieldError var15)
                {
                    ;
                }

                try
                {
                    FLOWER_TYPE_LOOKUP[BlockFlower.EnumFlowerType.BLUE_ORCHID.ordinal()] = 2;
                }
                catch (NoSuchFieldError var14)
                {
                    ;
                }

                try
                {
                    FLOWER_TYPE_LOOKUP[BlockFlower.EnumFlowerType.ALLIUM.ordinal()] = 3;
                }
                catch (NoSuchFieldError var13)
                {
                    ;
                }

                try
                {
                    FLOWER_TYPE_LOOKUP[BlockFlower.EnumFlowerType.HOUSTONIA.ordinal()] = 4;
                }
                catch (NoSuchFieldError var12)
                {
                    ;
                }

                try
                {
                    FLOWER_TYPE_LOOKUP[BlockFlower.EnumFlowerType.RED_TULIP.ordinal()] = 5;
                }
                catch (NoSuchFieldError var11)
                {
                    ;
                }

                try
                {
                    FLOWER_TYPE_LOOKUP[BlockFlower.EnumFlowerType.ORANGE_TULIP.ordinal()] = 6;
                }
                catch (NoSuchFieldError var10)
                {
                    ;
                }

                try
                {
                    FLOWER_TYPE_LOOKUP[BlockFlower.EnumFlowerType.WHITE_TULIP.ordinal()] = 7;
                }
                catch (NoSuchFieldError var9)
                {
                    ;
                }

                try
                {
                    FLOWER_TYPE_LOOKUP[BlockFlower.EnumFlowerType.PINK_TULIP.ordinal()] = 8;
                }
                catch (NoSuchFieldError var8)
                {
                    ;
                }

                try
                {
                    FLOWER_TYPE_LOOKUP[BlockFlower.EnumFlowerType.OXEYE_DAISY.ordinal()] = 9;
                }
                catch (NoSuchFieldError var7)
                {
                    ;
                }

                WOOD_TYPE_LOOKUP = new int[BlockPlanks.EnumType.values().length];

                try
                {
                    WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.OAK.ordinal()] = 1;
                }
                catch (NoSuchFieldError var6)
                {
                    ;
                }

                try
                {
                    WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
                }
                catch (NoSuchFieldError var5)
                {
                    ;
                }

                try
                {
                    WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
                }
                catch (NoSuchFieldError var4)
                {
                    ;
                }

                try
                {
                    WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
                }
                catch (NoSuchFieldError var3)
                {
                    ;
                }

                try
                {
                    WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
                }
                catch (NoSuchFieldError var2)
                {
                    ;
                }

                try
                {
                    WOOD_TYPE_LOOKUP[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
                }
                catch (NoSuchFieldError var1)
                {
                    ;
                }
                
                MWOOD_TYPE_LOOKUP = new int[MWoodType.values().length];

                try
                {
                    MWOOD_TYPE_LOOKUP[MWoodType.REDWOOD.ordinal()] = 1;
                }
                catch (NoSuchFieldError var16)
                {
                    ;
                }

                try
                {
                    MWOOD_TYPE_LOOKUP[MWoodType.FROZEN.ordinal()] = 2;
                }
                catch (NoSuchFieldError var17)
                {
                    ;
                }
            }
        }
}