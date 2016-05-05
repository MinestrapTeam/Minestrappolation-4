package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockMDoubleSlab extends BlockMSlab
{

	private int   flammability;
	private Block slab;

	public BlockMDoubleSlab(Material mat, String name, float hardness, float resistance, String tool, int harvestLevel, int flame, Block slab)
	{
		super(mat, name, hardness, resistance, tool, harvestLevel, flame);
		this.setCreativeTab(null);
		this.slab = slab;
		this.setUnlocalizedName(name + "_double_slab");
		this.flammability = flame;
		if (mat == Material.wood)
			this.setStepSound(Block.soundTypeWood);
		else if (mat == Material.rock)
			this.setStepSound(Block.soundTypePiston);
		if (this == MBlocks.radiant_double_slab)
			this.setLightLevel(0.6F);
	}

	@Override
	public boolean isDouble()
	{
		return true;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(this.slab);
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return this.flammability;
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
	{
		return this == MBlocks.radiant_double_slab;
	}
}
