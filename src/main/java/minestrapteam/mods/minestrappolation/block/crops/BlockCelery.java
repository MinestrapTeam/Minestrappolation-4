package minestrapteam.mods.minestrappolation.block.crops;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCelery extends BlockCrops{
	@Override
	protected Item getSeed()
    {
        return MBlocks.celery_seed;
    }

	@Override
    protected Item getCrop()
    {
        return MItems.celery;
    }
}
