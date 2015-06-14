package minestrapteam.minestrappolation.block;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMDoubleSlab extends BlockMSlab{

	private int flammability;
	
	public BlockMDoubleSlab(Material mat, String name, float hardness, float resistance, String tool, int harvestLevel, int flame) 
	{
		super(mat, name, hardness, resistance, tool, harvestLevel, flame);
		setCreativeTab(null);
		flammability = flame;
		if(mat == Material.wood)
        	setStepSound(Block.soundTypeWood);
        else if(mat == Material.rock)
        	setStepSound(Block.soundTypePiston);
	}

	@Override
	public boolean isDouble()
	{
		return true;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return this.flammability;
	}
}