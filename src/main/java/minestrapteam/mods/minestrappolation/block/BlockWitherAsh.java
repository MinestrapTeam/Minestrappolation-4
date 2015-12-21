package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWitherAsh extends BlockFalling
{
    public static final PropertyInteger LAYERS = PropertyInteger.create("layers", 1, 8);

    public BlockWitherAsh()
    {
        super(Material.snow);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LAYERS, Integer.valueOf(1)));
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
        this.setTickRandomly(true);
        this.setBlockBoundsForItemRender();
    }
    
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return ((Integer)worldIn.getBlockState(pos).getValue(LAYERS)).intValue() < 5;
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = ((Integer)state.getValue(LAYERS)).intValue() - 1;
        float f = 0.125F;
        return new AxisAlignedBB((double)pos.getX() + this.minX, (double)pos.getY() + this.minY, (double)pos.getZ() + this.minZ, (double)pos.getX() + this.maxX, (double)((float)pos.getY() + (float)i * f), (double)pos.getZ() + this.maxZ);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.getBoundsForLayers(0);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        this.getBoundsForLayers(((Integer)iblockstate.getValue(LAYERS)).intValue());
    }

    protected void getBoundsForLayers(int p_150154_1_)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, (float)p_150154_1_ / 8.0F, 1.0F);
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos.down());
        Block block = iblockstate.getBlock();
        return block != Blocks.ice && block != Blocks.packed_ice ? (block.isLeaves(worldIn, pos.down()) ? true : (block == this && ((Integer)iblockstate.getValue(LAYERS)).intValue() == 8 ? true : block.isOpaqueCube() && block.getMaterial().blocksMovement())) : false;
    }

    /**
     * Called when a neighboring block changes.
     */
    /*public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        this.checkAndDropBlock(worldIn, pos, state);
    }*/

    private boolean checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!this.canPlaceBlockAt(worldIn, pos))
        {
            worldIn.setBlockToAir(pos);
            return false;
        }
        else
        {
            return true;
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
    	if (!worldIn.isRemote)
        {
            this.checkFallable(worldIn, pos);
        }
    	if (worldIn.getBlockState(pos.down()).getBlock() instanceof BlockWitherAsh && ((Integer)worldIn.getBlockState(pos.down()).getValue(LAYERS)).intValue() < 8)
    	{
    		int depleteLevel = ((Integer)worldIn.getBlockState(pos).getValue(LAYERS)).intValue();
    		int newLevel = ((Integer)worldIn.getBlockState(pos.down()).getValue(LAYERS)).intValue();
    		worldIn.setBlockState(pos.down(), MBlocks.wither_ash.getDefaultState().withProperty(LAYERS, newLevel + 1));
    		if(depleteLevel > 1)
    			worldIn.setBlockState(pos, MBlocks.wither_ash.getDefaultState().withProperty(LAYERS, depleteLevel - 1));
    		else
    			worldIn.setBlockToAir(pos);
    		worldIn.playSoundEffect(pos.down().getX(), pos.down().getY(), pos.down().getZ(), "dig.sand", 1.5F, 0.8F);
    	}
    	else if(((Integer)worldIn.getBlockState(pos).getValue(LAYERS)).intValue() > 1)
    	{
    		int dir = rand.nextInt(4);
    		BlockPos newPos;
    		int prevLevel = ((Integer)worldIn.getBlockState(pos).getValue(LAYERS)).intValue();
    		
    		if(dir == 0)
    			newPos = pos.north();
    		else if(dir == 1)
    			newPos = pos.east();
    		else if(dir == 2)
    			newPos = pos.south();
    		else
    			newPos = pos.west();
    		
    		if(worldIn.getBlockState(newPos).getBlock().getMaterial().isReplaceable() && (worldIn.getBlockState(newPos).getBlock() instanceof BlockWitherAsh) == false)
    		{
    			worldIn.setBlockState(newPos, MBlocks.wither_ash.getDefaultState());
    			worldIn.setBlockState(pos, MBlocks.wither_ash.getDefaultState().withProperty(LAYERS, prevLevel - 1));
    			worldIn.playSoundEffect(newPos.getX(), newPos.getY(), newPos.getZ(), "dig.sand", 1.5F, 0.8F);
    		}
    		else if(worldIn.getBlockState(newPos).getBlock() instanceof BlockWitherAsh)
    		{
    			int newLevel = ((Integer)worldIn.getBlockState(newPos).getValue(LAYERS)).intValue();
    			
    			if(prevLevel - newLevel > 1)
    			{
    				worldIn.setBlockState(newPos, MBlocks.wither_ash.getDefaultState().withProperty(LAYERS, newLevel + 1));
        			worldIn.setBlockState(pos, MBlocks.wither_ash.getDefaultState().withProperty(LAYERS, prevLevel - 1));
        			worldIn.playSoundEffect(newPos.getX(), newPos.getY(), newPos.getZ(), "dig.sand", 1.5F, 0.8F);
    			}
    		}
    	}
    		
    }
    
    private void checkFallable(World worldIn, BlockPos pos)
    {
        if (canFallInto(worldIn, pos.down()) && pos.getY() >= 0)
        {
            byte b0 = 32;

            if (!fallInstantly && worldIn.isAreaLoaded(pos.add(-b0, -b0, -b0), pos.add(b0, b0, b0)))
            {
                if (!worldIn.isRemote)
                {
                    EntityFallingBlock entityfallingblock = new EntityFallingBlock(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
                    this.onStartFalling(entityfallingblock);
                    worldIn.spawnEntityInWorld(entityfallingblock);
                }
            }
            else
            {
                worldIn.setBlockToAir(pos);
                BlockPos blockpos1;

                for (blockpos1 = pos.down(); canFallInto(worldIn, blockpos1) && blockpos1.getY() > 0; blockpos1 = blockpos1.down())
                {
                    ;
                }

                if (blockpos1.getY() > 0)
                {
                    worldIn.setBlockState(blockpos1.up(), this.getDefaultState());
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return side == EnumFacing.UP ? true : super.shouldSideBeRendered(worldIn, pos, side);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LAYERS, Integer.valueOf((meta & 7) + 1));
    }

    /**
     * Whether this Block can be replaced directly by other blocks (true for e.g. tall grass)
     */
    public boolean isReplaceable(World worldIn, BlockPos pos)
    {
        return ((Integer)worldIn.getBlockState(pos).getValue(LAYERS)).intValue() == 1;
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(LAYERS)).intValue() - 1;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {LAYERS});
    }

    @Override public int quantityDropped(IBlockState state, int fortune, Random random){ return ((Integer)state.getValue(LAYERS)); }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (playerIn.getCurrentEquippedItem() != null)
        {
            Item item = playerIn.getCurrentEquippedItem().getItem();

            if (item == Item.getItemFromBlock(MBlocks.wither_ash) && ((Integer)state.getValue(LAYERS)).intValue() < 8)
            {
            	worldIn.setBlockState(pos, state.withProperty(LAYERS, ((Integer)state.getValue(LAYERS)).intValue() + 1));
            	if (!playerIn.capabilities.isCreativeMode)
    			{
    				--playerIn.getCurrentEquippedItem().stackSize;
    			}
            	return true;
            }
            return false;
        }
        return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
    }
    
    
}
