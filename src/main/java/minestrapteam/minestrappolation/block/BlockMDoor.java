package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockMDoor extends BlockDoor
{
	
	public BlockMDoor(Material materialIn)
	{
		super(materialIn);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null : this.getItem();
	}
	
	private Item getItem()
	{ 
		if(this == MBlocks.redwood_door)
		{
			return MBlocks.redwood_door_item;
		}
		else if(this == MBlocks.redwood_door)
		{
			return MBlocks.redwood_door_item;
		}
		return null;
		
	}
	
}
