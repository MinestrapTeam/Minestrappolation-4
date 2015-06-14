package minestrapteam.minestrappolation.block;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMDoubleSlab extends BlockMSlab{

	public BlockMDoubleSlab(Material mat, String name, float hardness, float resistance) 
	{
		super(mat, name, hardness, resistance);
		setCreativeTab(null);
	}

	@Override
	public boolean isDouble()
	{
		return true;
	}
}