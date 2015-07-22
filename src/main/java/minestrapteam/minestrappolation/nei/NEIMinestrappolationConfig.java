package minestrapteam.minestrappolation.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.TemplateRecipeHandler;
import minestrapteam.minestrappolation.inventory.gui.GuiAlloy;
import minestrapteam.minestrappolation.inventory.gui.GuiMelter;
import minestrapteam.minestrappolation.inventory.gui.GuiSawmill;
import minestrapteam.minestrappolation.inventory.gui.GuiStoneCutter;
import minestrapteam.minestrappolation.lib.MReference;
import minestrapteam.minestrappolation.nei.handler.*;

public class NEIMinestrappolationConfig implements IConfigureNEI
{
	public static ShapedStonecuttingHandler		shapedStonecuttingHandler		= new ShapedStonecuttingHandler();
	public static ShapelessStonecuttingHandler	shapelessStonecuttingHandler	= new ShapelessStonecuttingHandler();
	public static ShapedSawingHandler			shapedSawingHandler				= new ShapedSawingHandler();
	public static ShapelessSawingHandler		shapelessSawingHandler			= new ShapelessSawingHandler();
	public static MelterRecipeHandler			melterHandler					= new MelterRecipeHandler();
	public static MelterFuelHandler				melterFuelHandler				= new MelterFuelHandler();
	public static AlloyRecipeHandler			alloyHandler = new AlloyRecipeHandler();
	
	@Override
	public void loadConfig()
	{
		registerHandler(shapedStonecuttingHandler);
		registerHandler(shapelessStonecuttingHandler);
		registerHandler(shapedSawingHandler);
		registerHandler(shapelessSawingHandler);
		registerHandler(melterHandler);
		registerHandler(melterFuelHandler);
		registerHandler(alloyHandler);
				
		API.registerGuiOverlay(GuiStoneCutter.class, "stonecutter");
		API.registerGuiOverlay(GuiSawmill.class, "sawmill");
		API.registerGuiOverlay(GuiMelter.class, "melting");
		API.registerGuiOverlay(GuiAlloy.class, "alloy");
	}
	
	private static void registerHandler(TemplateRecipeHandler handler)
	{
		API.registerRecipeHandler(handler);
		API.registerUsageHandler(handler);
	}
	
	@Override
	public String getName()
	{
		return MReference.NAME;
	}
	
	@Override
	public String getVersion()
	{
		return MReference.VERSION;
	}
}
