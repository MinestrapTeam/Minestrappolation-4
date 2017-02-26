package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.util.Chance;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDecayingCompacted extends Block
{
	public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);
	public String dimension;
	
	public BlockDecayingCompacted(Material materialIn, String dimension)
	{
		super(materialIn);
		this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
		this.dimension = dimension;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, (double)pos.getX() + 2.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 2.5D, new int[0]);
		worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, (double)pos.getX() + 2.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() - 1.5D, new int[0]);
		worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, (double)pos.getX() - 1.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 2.5D, new int[0]);
		worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, (double)pos.getX() - 1.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() - 1.5D, new int[0]);
	}
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
    }
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
    	worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
    	ItemStack stack;
    	EntityItem item;
    	int j = ((Integer)state.getValue(AGE)).intValue();
        if(j < 15)
        {
        	worldIn.setBlockState(pos, state.withProperty(AGE, Integer.valueOf(j + 1)), 2);
        }
        else
        {
        	stack = (ItemStack) Chance.getRandomFromTable(dimension + "_items");
        	int quantity = rand.nextInt(stack.getCount());
        	ItemStack newstack = new ItemStack(stack.getItem(), quantity + 1, stack.getItemDamage());
        	item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), newstack.copy());
        	worldIn.spawnEntity(item);
        	worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
        }
    }
    
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AGE, Integer.valueOf(meta));
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(AGE)).intValue();
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {AGE});
    }
}
