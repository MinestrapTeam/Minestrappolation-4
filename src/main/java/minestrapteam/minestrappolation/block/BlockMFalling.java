package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockMFalling extends BlockFalling{
	
	private final MapColor	mapColor;
	
	public BlockMFalling(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn);
		this.mapColor = mapColorIn;
	}
	
	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return this.mapColor;
	}
}
