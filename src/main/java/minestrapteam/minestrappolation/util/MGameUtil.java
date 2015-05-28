package minestrapteam.minestrappolation.util;

import minestrapteam.minestrappolation.lib.MReference;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MGameUtil {
	
	public static Item getItemFromBlock(final String name) {
        return GameRegistry.findItem(MReference.NAME, name);
    }
}
