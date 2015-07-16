package minestrapteam.minestrappolation.util;

import minestrapteam.minestrappolation.lib.MReference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MGameUtil {
	
	public static Block findBlock(final String name) {
		return GameRegistry.findBlock(MReference.NAME, name);
    }
}
