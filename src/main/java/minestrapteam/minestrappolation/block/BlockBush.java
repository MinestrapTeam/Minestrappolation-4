package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Config;
import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockBush extends MBlock implements IPlantable, IShearable{

	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 5);
    public Item item;
	
    public BlockBush(Item item)
    {
        super(Material.leaves, MapColor.greenColor);
        this.setStepSound(Block.soundTypeGrass);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
        this.setLightOpacity(0);
        this.setTickRandomly(true);
        this.item = item;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (worldIn.getBlockState(pos.down()).getBlock() == this || this.checkForDrop(worldIn, pos, state))
        {                   
                	int j = ((Integer)state.getValue(AGE)).intValue();
                    if(j < 5)
                    {
                    	int chance = rand.nextInt(Config.bushGrowChance);
                    	if(chance == 1)
                    	{
                    		worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 2);
                    	}
                    }  
        }
    }
    
    @Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
    		if((Integer)state.getValue(AGE) == 5)
    		{
    			if(worldIn.isRemote)
    				return true;
    			worldIn.setBlockState(pos, this.getDefaultState(), 2);
    			EntityItem ei = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(item));
    			worldIn.spawnEntityInWorld(ei);
    			if(playerIn instanceof FakePlayer)
    				ei.onCollideWithPlayer(playerIn);
    			return true;
    		}
	return false;
	}
    
    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos) 
    {
    	if((Integer)worldIn.getBlockState(pos).getValue(AGE) <= 4)
    	{
    		this.setBlockBounds(0.0F, 0.0F, 0.0F, .9F, .9F, .9F);
    	}
    	if((Integer)worldIn.getBlockState(pos).getValue(AGE) == 5)
    	{
    		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 1F, 1F);
    	}
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos.down()).getBlock();
        if (block.canSustainPlant(worldIn, pos.down(), EnumFacing.UP, this)) return true;

        if (block == this)
        {
            return true;
        }
        else if (block != Blocks.grass && block != Blocks.dirt && block != Blocks.sand)
        {
        	if(block == Blocks.mycelium && this == MBlocks.mana_bush)
        		return true;
        	else
        		return false;
        }
        return false;
    }

    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        this.checkForDrop(worldIn, pos, state);
    }

    protected final boolean checkForDrop(World worldIn, BlockPos p_176353_2_, IBlockState state)
    {
        if (this.canBlockStay(worldIn, p_176353_2_))
        {
            return true;
        }
        else
        {
            this.dropBlockAsItem(worldIn, p_176353_2_, state, 0);
            worldIn.setBlockToAir(p_176353_2_);
            return false;
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos)
    {
        return this.canPlaceBlockAt(worldIn, pos);
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }

    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        if(this == MBlocks.mana_bush)
        	return EnumWorldBlockLayer.TRANSLUCENT;
        else
        	return EnumWorldBlockLayer.CUTOUT;
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(AGE)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {AGE});
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
    {
        return net.minecraftforge.common.EnumPlantType.Plains;
    }
    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos)
    {
        return this.getDefaultState();
    }
    
    @Override
	public boolean isOpaqueCube()
	{
		return false;
	}
    
    @Override
	public boolean isVisuallyOpaque()
	{
		return false;
	}

    @Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
	{
		return true;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		ArrayList<ItemStack> list = new ArrayList();
		list.add(new ItemStack(this, 1, 0));
		return list;
	}
	
}
