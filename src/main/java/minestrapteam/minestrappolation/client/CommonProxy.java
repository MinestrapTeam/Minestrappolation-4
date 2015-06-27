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
import minestrapteam.minestrappolation.lib.MAchievements;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MFluid;
import minestrapteam.minestrappolation.tileentity.TileEntityAlloy;
import minestrapteam.minestrappolation.tileentity.TileEntityBarrel;
import minestrapteam.minestrappolation.tileentity.TileEntityCrate;
import minestrapteam.minestrappolation.tileentity.TileEntityCrusher;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;
import minestrapteam.minestrappolation.tileentity.TileEntitySawMill;
import minestrapteam.minestrappolation.tileentity.TileEntitySplitter;
import minestrapteam.minestrappolation.tileentity.TileEntityStoneCutter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{

	public void preInit(FMLPreInitializationEvent event)
	{
		
		
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "tile_entity_barrel");
		GameRegistry.registerTileEntity(TileEntityCrate.class, "tile_entity_crate");
		GameRegistry.registerTileEntity(TileEntityMelter.class, "tile_entity_melter");
		GameRegistry.registerTileEntity(TileEntityAlloy.class, "tile_entity_alloy");
		GameRegistry.registerTileEntity(TileEntityStoneCutter.class, "tile_entity_stonecutter");
		GameRegistry.registerTileEntity(TileEntitySawMill.class, "tile_entity_sawmill");
		GameRegistry.registerTileEntity(TileEntityCrusher.class, "tile_entity_crusher");
		GameRegistry.registerTileEntity(TileEntitySplitter.class, "tile_entity_splitter");
		
		MAchievements.preInit();
	}
	
	public void init(FMLInitializationEvent event)
	{
		
		

	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
	}
	
	public boolean isClient()
	{
		return false;
	}
	
	public void openGUI(Object gui)
	{
		
	}
	
	public void registerRenders()
	{
		
	}
}
