package minestrapteam.minestrappolation.block.crops;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCabbage extends BlockCrops{
	@Override
	protected Item getSeed()
    {
        return MBlocks.cabbage;
    }

	@Override
    protected Item getCrop()
    {
        return MBlocks.cabbage;
    }
}
