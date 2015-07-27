package minestrapteam.mods.minestrappolation.block.crops;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockPepper extends BlockCrops
{
	@Override
	protected Item getSeed()
    {
        return MBlocks.pepper_seed;
    }

	@Override
    protected Item getCrop()
    {
        return MItems.pepper;
    }
}
