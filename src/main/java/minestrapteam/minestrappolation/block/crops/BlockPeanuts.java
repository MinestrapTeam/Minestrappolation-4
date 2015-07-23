package minestrapteam.minestrappolation.block.crops;

import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockPeanuts extends BlockCrops
{
	@Override
	protected Item getSeed()
    {
        return MBlocks.peanuts;
    }

	@Override
    protected Item getCrop()
    {
        return MBlocks.peanuts;
    }
}
