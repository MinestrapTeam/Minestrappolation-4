package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

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
		else if(this == MBlocks.frozen_door)
		{
			return MBlocks.frozen_door_item;
		}
		else if(this == MBlocks.glass_door)
		{
			return MBlocks.glass_door_item;
		}
		return null;
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player)
    {
		if(this == MBlocks.redwood_door)
		{
			return new ItemStack(MBlocks.redwood_door_item);
		}
		else if(this == MBlocks.frozen_door)
		{
			return new ItemStack(MBlocks.frozen_door_item);
		}
		else if(this == MBlocks.glass_door)
		{
			return new ItemStack(MBlocks.glass_door_item);
		}
        return new ItemStack(Items.oak_door);
    }
}
