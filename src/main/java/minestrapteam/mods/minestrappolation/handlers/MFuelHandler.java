package minestrapteam.mods.minestrappolation.handlers;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class MFuelHandler implements IFuelHandler
{
	
	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.ministrapp_sapling))
			return 100;
		if (fuel.getItem() == MItems.reinforced_stick)
			return 100;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.redwood_slab))
			return 150;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.frozen_oak_slab))
			return 150;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.ministrapp_log))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.ministrapp_planks))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.ministrapp_boards))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.ministrapp_mossy_planks))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.ministrapp_mossy_boards))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.redwood_fence))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.redwood_fence_gate))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.redwood_stairs))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.frozen_oak_fence))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.frozen_oak_fence_gate))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.frozen_oak_stairs))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.crate))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.barrel))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.sawmill))
			return 300;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.moss))
			return 400;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.hanging_moss))
			return 400;
		if (fuel.getItem() == MItems.blaze_shard)
			return 1600;
		if (fuel.getItem() == MItems.guano)
			return 2400;
		if (fuel.getItem() == MItems.fire_shovel)
			return 4800;
		if (fuel.getItem() == MItems.blazium_ingot)
			return 6800;
		if (fuel.getItem() == MItems.fire_hoe)
			return 9600;
		if (fuel.getItem() == MItems.fire_sword)
			return 9600;
		if (fuel.getItem() == MBlocks.magmaBucket)
			return 25000;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.blazium_block))
			return 68000;
		if (fuel.getItem() == MItems.fire_axe)
			return 14400;
		if (fuel.getItem() == MItems.fire_pickaxe)
			return 14400;
		if (fuel.getItem() == MItems.blazium_helmet)
			return 19200;
		if (fuel.getItem() == MItems.blazium_chestplate)
			return 33600;
		if (fuel.getItem() == MItems.blazium_leggings)
			return 28800;
		if (fuel.getItem() == MItems.blazium_boots)
			return 14400;
		if (fuel.getItem() == MItems.plutonium)
			return 22400;
		if (fuel.getItem() == MItems.uranium)
			return 20000;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.plutonium_block))
			return 224000;
		if (fuel.getItem() == Item.getItemFromBlock(MBlocks.uranium_block))
			return 200000;
		return 0;
	}
	
}
