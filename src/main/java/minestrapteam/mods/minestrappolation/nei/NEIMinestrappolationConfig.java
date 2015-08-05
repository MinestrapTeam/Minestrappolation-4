package minestrapteam.mods.minestrappolation.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.TemplateRecipeHandler;
import minestrapteam.mods.minestrappolation.inventory.gui.GuiAlloy;
import minestrapteam.mods.minestrappolation.inventory.gui.GuiCrusher;
import minestrapteam.mods.minestrappolation.inventory.gui.GuiMelter;
import minestrapteam.mods.minestrappolation.inventory.gui.GuiSawmill;
import minestrapteam.mods.minestrappolation.inventory.gui.GuiStoneCutter;
import minestrapteam.mods.minestrappolation.lib.MReference;
import minestrapteam.mods.minestrappolation.nei.handler.AlloyRecipeHandler;
import minestrapteam.mods.minestrappolation.nei.handler.CrusherRecipesHandler;
import minestrapteam.mods.minestrappolation.nei.handler.MelterFuelHandler;
import minestrapteam.mods.minestrappolation.nei.handler.MelterRecipeHandler;
import minestrapteam.mods.minestrappolation.nei.handler.ShapedSawingHandler;
import minestrapteam.mods.minestrappolation.nei.handler.ShapedStonecuttingHandler;
import minestrapteam.mods.minestrappolation.nei.handler.ShapelessSawingHandler;
import minestrapteam.mods.minestrappolation.nei.handler.ShapelessStonecuttingHandler;

public class NEIMinestrappolationConfig implements IConfigureNEI
{
	public static ShapedStonecuttingHandler		shapedStonecuttingHandler		= new ShapedStonecuttingHandler();
	public static ShapelessStonecuttingHandler	shapelessStonecuttingHandler	= new ShapelessStonecuttingHandler();
	public static ShapedSawingHandler			shapedSawingHandler				= new ShapedSawingHandler();
	public static ShapelessSawingHandler		shapelessSawingHandler			= new ShapelessSawingHandler();
	public static MelterRecipeHandler			melterHandler					= new MelterRecipeHandler();
	public static MelterFuelHandler				melterFuelHandler				= new MelterFuelHandler();
	public static AlloyRecipeHandler			alloyHandler 					= new AlloyRecipeHandler();
	public static CrusherRecipesHandler			crusherRecipeHandler			= new CrusherRecipesHandler();
	
	@Override
	public void loadConfig()
	{
		registerHandler(shapedStonecuttingHandler);
		registerHandler(shapelessStonecuttingHandler);
		registerHandler(shapedSawingHandler);
		registerHandler(shapelessSawingHandler);
		registerHandler(melterHandler);
		registerHandler(melterFuelHandler);
		registerHandler(crusherRecipeHandler);
		registerHandler(alloyHandler);
				
		API.registerGuiOverlay(GuiStoneCutter.class, "stonecutter");
		API.registerGuiOverlay(GuiSawmill.class, "sawmill");
		API.registerGuiOverlay(GuiMelter.class, "melting");
		API.registerGuiOverlay(GuiCrusher.class, "crusher");
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
