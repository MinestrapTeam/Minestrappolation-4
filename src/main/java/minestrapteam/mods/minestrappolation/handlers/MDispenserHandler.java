package minestrapteam.mods.minestrappolation.handlers;

import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.BlockDispenser;

public class MDispenserHandler
{
	public static void registerBehaviors()
	{
		BlockDispenser.dispenseBehaviorRegistry.putObject(MItems.ice_charge, new DispenserIceBall());
		BlockDispenser.dispenseBehaviorRegistry.putObject(MItems.mud_ball, new DispenserMudBall());
	}
}
