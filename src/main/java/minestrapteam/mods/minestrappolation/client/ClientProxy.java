package minestrapteam.mods.minestrappolation.client;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.block.BlockBiomeBricks;
import minestrapteam.mods.minestrappolation.block.BlockChiseled;
import minestrapteam.mods.minestrappolation.block.BlockCrackedBricks;
import minestrapteam.mods.minestrappolation.block.BlockLamp;
import minestrapteam.mods.minestrappolation.block.BlockMSand;
import minestrapteam.mods.minestrappolation.block.BlockMossyBricks;
import minestrapteam.mods.minestrappolation.block.BlockMossyCobble;
import minestrapteam.mods.minestrappolation.block.BlockPatternBricks;
import minestrapteam.mods.minestrappolation.block.BlockRefined;
import minestrapteam.mods.minestrappolation.block.BlockRoads;
import minestrapteam.mods.minestrappolation.block.BlockTiles;
import minestrapteam.mods.minestrappolation.block.MBlockLeaves;
import minestrapteam.mods.minestrappolation.block.MBlockLog;
import minestrapteam.mods.minestrappolation.block.MBlockPlanks;
import minestrapteam.mods.minestrappolation.block.MBlockSapling;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeCoal;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeCobble;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeCopper;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeDiamond;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeEmerald;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeGold;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeIron;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeLapis;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeMeurodite;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomePlutonium;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeRadiant;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeRedstone;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeStones;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeSunstone;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeTin;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeTitanium;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeTorite;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeUranium;
import minestrapteam.mods.minestrappolation.entity.EntityMudBall;
import minestrapteam.mods.minestrappolation.entity.RenderMudBall;
import minestrapteam.mods.minestrappolation.item.ItemBricks;
import minestrapteam.mods.minestrappolation.item.ItemChunk;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MFluid;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.network.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

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
		
		ItemChunk.inventoryRender();
		ItemBricks.inventoryRender();
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMudBall.class, new RenderMudBall(Minecraft.getMinecraft().getRenderManager(), MItems.mud_ball, Minecraft.getMinecraft().getRenderItem()));
		
	}

	
	@Override
	public void openGUI(Object gui)
	{
		Minecraft.getMinecraft().displayGuiScreen((GuiScreen) gui);
	}
}
