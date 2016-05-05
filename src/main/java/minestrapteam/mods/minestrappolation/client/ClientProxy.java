package minestrapteam.mods.minestrappolation.client;

import minestrapteam.mods.minestrappolation.block.*;
import minestrapteam.mods.minestrappolation.block.biomeores.*;
import minestrapteam.mods.minestrappolation.entity.EntityIceball;
import minestrapteam.mods.minestrappolation.entity.EntityMudBall;
import minestrapteam.mods.minestrappolation.entity.RenderIceBall;
import minestrapteam.mods.minestrappolation.entity.RenderMudBall;
import minestrapteam.mods.minestrappolation.item.ItemBricks;
import minestrapteam.mods.minestrappolation.item.ItemBricks2;
import minestrapteam.mods.minestrappolation.item.ItemChunk;
import minestrapteam.mods.minestrappolation.item.ItemUpgradeChips;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MFluid;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.network.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		//registry
		//OLD KEY HANLDER REGISTER, UNCOMMENT TO ACTIVATE IT
		//FMLCommonHandler.instance().bus().register(new MKeyHandler());

		//non registry
		MFluid.buildRenderFor(MBlocks.magma, "magma");
	}

	@Override
	public void registerRenders()
	{
		MBlocks.registerRenders();
		MItems.registerRenders();

		BlockBiomeStones.inventoryRender();
		BlockBiomeBricks.inventoryRender();
		BlockBiomeCobble.inventoryRender();
		BlockBiomeDiamond.inventoryRender();
		BlockBiomeIron.inventoryRender();
		BlockBiomeGold.inventoryRender();
		BlockBiomeCoal.inventoryRender();
		BlockBiomeLapis.inventoryRender();
		BlockBiomeRedstone.inventoryRender();
		BlockBiomeTin.inventoryRender();
		BlockBiomeCopper.inventoryRender();
		BlockBiomeEmerald.inventoryRender();
		BlockBiomeSunstone.inventoryRender();
		BlockBiomeTorite.inventoryRender();
		BlockBiomeTitanium.inventoryRender();
		BlockBiomeRadiant.inventoryRender();
		BlockBiomePlutonium.inventoryRender();
		BlockBiomeUranium.inventoryRender();
		BlockBiomeMeurodite.inventoryRender();
		MBlockPlanks.inventoryRender();
		MBlockLog.inventoryRender();
		BlockMSand.inventoryRender();
		BlockRoads.inventoryRender();
		BlockChiseled.inventoryRender();
		BlockMossyCobble.inventoryRender();
		BlockMossyBricks.inventoryRender();
		BlockCrackedBricks.inventoryRender();
		BlockPatternBricks.inventoryRender();
		BlockRefined.inventoryRender();
		BlockTiles.inventoryRender();
		BlockLamp.inventoryRender("sunstone");
		BlockLamp.inventoryRender("glowstone");
		BlockLamp.inventoryRender("prismarine");
		MBlockLeaves.inventoryRender();
		MBlockSapling.inventoryRender();
		BlockCarvedPumpkin.inventoryRender("neutral");
		BlockCarvedPumpkin.inventoryRender("grin");
		BlockCarvedPumpkin.inventoryRender("creepy");
		BlockCarvedPumpkin.inventoryRender("grump");
		BlockCarvedPumpkin.inventoryRender("dumpy");
		BlockCarvedPumpkin.inventoryRender("neutral_lit");
		BlockCarvedPumpkin.inventoryRender("grin_lit");
		BlockCarvedPumpkin.inventoryRender("creepy_lit");
		BlockCarvedPumpkin.inventoryRender("grump_lit");
		BlockCarvedPumpkin.inventoryRender("dumpy_lit");
		BlockVirtianSoil.inventoryRender();
		BlockBoards.inventoryRender("boards");
		BlockBoards.inventoryRender("mossy_planks");
		BlockBoards.inventoryRender("mossy_boards");

		ItemChunk.inventoryRender();
		ItemBricks.inventoryRender();
		ItemBricks2.inventoryRender();
		ItemUpgradeChips.inventoryRender();

		RenderingRegistry.registerEntityRenderingHandler(EntityMudBall.class,
		                                                 new RenderMudBall(Minecraft.getMinecraft().getRenderManager(),
		                                                                   MItems.mud_ball,
		                                                                   Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceball.class,
		                                                 new RenderIceBall(Minecraft.getMinecraft().getRenderManager(),
		                                                                   MItems.ice_charge,
		                                                                   Minecraft.getMinecraft().getRenderItem()));
	}

	@Override
	public void openGUI(Object gui)
	{
		Minecraft.getMinecraft().displayGuiScreen((GuiScreen) gui);
	}
}
