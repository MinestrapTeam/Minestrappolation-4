package minestrapteam.mods.minestrappolation.block.crops;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockLettuce extends BlockCrops{
	@Override
	protected Item getSeed()
    {
        return MBlocks.lettuce;
    }

	@Override
    protected Item getCrop()
    {
        return MBlocks.lettuce;
    }
}
