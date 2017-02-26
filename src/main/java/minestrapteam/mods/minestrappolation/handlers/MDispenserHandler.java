package minestrapteam.mods.minestrappolation.handlers;

import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.BlockDispenser;

public class MDispenserHandler 
{
	public static void registerBehaviors()
	{
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(MItems.ice_charge, new DispenserIceBall());
		BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(MItems.mud_ball, new DispenserMudBall());
	}
}
