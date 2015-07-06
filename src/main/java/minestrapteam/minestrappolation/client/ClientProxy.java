package minestrapteam.minestrappolation.client;

import minestrapteam.minestrappolation.block.BlockBiomeBricks;
import minestrapteam.minestrappolation.block.BlockChiseled;
import minestrapteam.minestrappolation.block.BlockCrackedBricks;
import minestrapteam.minestrappolation.block.BlockLamp;
import minestrapteam.minestrappolation.block.BlockMSand;
import minestrapteam.minestrappolation.block.BlockMossyBricks;
import minestrapteam.minestrappolation.block.BlockMossyCobble;
import minestrapteam.minestrappolation.block.BlockPatternBricks;
import minestrapteam.minestrappolation.block.BlockRefined;
import minestrapteam.minestrappolation.block.BlockRoads;
import minestrapteam.minestrappolation.block.BlockTiles;
import minestrapteam.minestrappolation.block.MBlockLeaves;
import minestrapteam.minestrappolation.block.MBlockLog;
import minestrapteam.minestrappolation.block.MBlockPlanks;
import minestrapteam.minestrappolation.block.MBlockSapling;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeCoal;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeCobble;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeCopper;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeDiamond;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeEmerald;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeGold;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeIron;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeLapis;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeMeurodite;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomePlutonium;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeRadiant;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeRedstone;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeStones;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeSunstone;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeTin;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeTitanium;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeTorite;
import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeUranium;
import minestrapteam.minestrappolation.item.ItemChunk;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MFluid;
import minestrapteam.minestrappolation.lib.MItems;
import minestrapteam.minestrappolation.tileentity.TileEntityAlloy;
import minestrapteam.minestrappolation.tileentity.TileEntityBarrel;
import minestrapteam.minestrappolation.tileentity.TileEntityCrate;
import minestrapteam.minestrappolation.tileentity.TileEntityCrusher;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;
import minestrapteam.minestrappolation.tileentity.TileEntitySawMill;
import minestrapteam.minestrappolation.tileentity.TileEntitySplitter;
import minestrapteam.minestrappolation.tileentity.TileEntityStoneCutter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		MFluid.buildRenderFor(MBlocks.magma, "magma");
	}
	
	@Override
	public void registerRenders()
	{
		MBlocks.registerRenders();
		MItems.registerRenders();
		BlockBiomeStones.preinventoryRender();
		BlockBiomeBricks.preinventoryRender();
		BlockBiomeCobble.preinventoryRender();
		BlockBiomeDiamond.preinventoryRender();
		BlockBiomeIron.preinventoryRender();
		BlockBiomeGold.preinventoryRender();
		BlockBiomeCoal.preinventoryRender();
		BlockBiomeLapis.preinventoryRender();
		BlockBiomeRedstone.preinventoryRender();
		BlockBiomeTin.preinventoryRender();
		BlockBiomeCopper.preinventoryRender();
		BlockBiomeEmerald.preinventoryRender();
		BlockBiomeSunstone.preinventoryRender();
		BlockBiomeTorite.preinventoryRender();
		BlockBiomeTitanium.preinventoryRender();
		BlockBiomeRadiant.preinventoryRender();
		BlockBiomePlutonium.preinventoryRender();
		BlockBiomeUranium.preinventoryRender();
		BlockBiomeMeurodite.preinventoryRender();
		MBlockPlanks.preinventoryRender();
		MBlockLog.preinventoryRender();
		BlockMSand.preinventoryRender();
		BlockRoads.preinventoryRender();
		BlockChiseled.preinventoryRender();
		BlockMossyCobble.preinventoryRender();
		BlockMossyBricks.preinventoryRender();
		BlockCrackedBricks.preinventoryRender();
		BlockPatternBricks.preinventoryRender();
		BlockRefined.preinventoryRender();
		BlockTiles.preinventoryRender();
		BlockLamp.preinventoryRender("sunstone");
		BlockLamp.preinventoryRender("glowstone");
		BlockLamp.preinventoryRender("prismarine");
		MBlockLeaves.preinventoryRender();
		MBlockSapling.preinventoryRender();
		
		ItemChunk.preinventoryRender();
		
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
	}

	
	@Override
	public void openGUI(Object gui)
	{
		Minecraft.getMinecraft().displayGuiScreen((GuiScreen) gui);
	}
}
