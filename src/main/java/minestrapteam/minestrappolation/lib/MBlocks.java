package minestrapteam.minestrappolation.lib;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.block.BlockBiomeBricks;
import minestrapteam.minestrappolation.block.BlockBiomeCobble;
import minestrapteam.minestrappolation.block.BlockBiomeStones;
import minestrapteam.minestrappolation.block.BlockBoulder;
import minestrapteam.minestrappolation.block.BlockGodstone;
import minestrapteam.minestrappolation.block.BlockSunstoneBlock;
import minestrapteam.minestrappolation.block.BlockTransparent;
import minestrapteam.minestrappolation.block.MBlock;
import minestrapteam.minestrappolation.block.MBlockLeaves;
import minestrapteam.minestrappolation.block.MBlockLog;
import minestrapteam.minestrappolation.block.MBlockOre;
import minestrapteam.minestrappolation.block.MBlockPlanks;
import minestrapteam.minestrappolation.block.MBlockSapling;
import minestrapteam.minestrappolation.block.MBlockSnow;
import minestrapteam.minestrappolation.item.block.ItemBlockBiomeBricks;
import minestrapteam.minestrappolation.item.block.ItemBlockBiomeCobble;
import minestrapteam.minestrappolation.item.block.ItemBlockBiomeStones;
import minestrapteam.minestrappolation.item.block.ItemBlockLeaves;
import minestrapteam.minestrappolation.item.block.ItemBlockLog;
import minestrapteam.minestrappolation.item.block.ItemBlockPlanks;
import minestrapteam.minestrappolation.item.block.ItemBlockSapling;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

//import com.delocuro.ministrappolation.blocks.MinistrappolationContainer;

public class MBlocks
{
	
	public static Block	copper_ore;
	public static Block	copper_block;
	public static Block	tin_ore;
	public static Block	tin_block;
	public static Block	sunstone_ore;
	public static Block	sunstone_block;
	public static Block	slate;
	
	public static Block	snow_refined;
	public static Block	snow_bricks;
	public static Block	snow_tiles;
	public static Block	glass_bricks;
	public static Block	glass_refined;
	public static Block	glass_tiles;
	public static Block	glass_window;
	public static Block	stone_boulder;
	public static Block	stone_lamp_glowstone;
	public static Block	stone_lamp_prismarine;
	public static Block	stone_lamp_sunstone;
	public static Block	stone_pattern_bricks;
	public static Block	stone_refined;
	public static Block	stone_tiles;
	public static Block	ministrapp_log;
	public static Block	ministrapp_leaves;
	public static Block	ministrapp_sapling;
	public static Block	ministrapp_planks;
	
	public static Block godstone;
	
	// Biome Stones
	public static Block			   biome_stones;
	public static Block			   biome_cobble;
	public static Block			   biome_bricks;
	
	// public static Block stone_decor;
	// public static Block crate;
	
	public static void init()
	{
		copper_ore = new MBlockOre(Material.rock, MapColor.stoneColor).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("copper_ore").setCreativeTab(Minestrappolation.tabMinistrappolation);
		copper_block = new MBlock(Material.iron, MapColor.adobeColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("copper_block").setCreativeTab(Minestrappolation.tabMinistrappolation);
		tin_ore = new MBlock(Material.rock, MapColor.stoneColor).setHardness(3.0F).setResistance(3.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("tin_ore").setCreativeTab(Minestrappolation.tabMinistrappolation);
		tin_block = new MBlock(Material.iron, MapColor.ironColor).setHardness(5.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("tin_block").setCreativeTab(Minestrappolation.tabMinistrappolation);
		sunstone_ore = new MBlockOre(Material.rock, MapColor.stoneColor).setHardness(2.8F).setResistance(4.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.7F).setUnlocalizedName("sunstone_ore").setCreativeTab(Minestrappolation.tabMinistrappolation);
		sunstone_block = new BlockSunstoneBlock(Material.glass, MapColor.sandColor).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightLevel(0.9F).setUnlocalizedName("sunstone_block").setCreativeTab(Minestrappolation.tabMinistrappolation);
		slate = new MBlock(Material.rock, MapColor.stoneColor).setUnlocalizedName("slate");
		
		snow_refined = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.4F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_refined").setCreativeTab(Minestrappolation.tabMinistrappolation);
		snow_bricks = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.6F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_bricks").setCreativeTab(Minestrappolation.tabMinistrappolation);
		snow_tiles = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.6F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_tiles").setCreativeTab(Minestrappolation.tabMinistrappolation);
		glass_bricks = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightOpacity(1).setUnlocalizedName("glass_bricks").setCreativeTab(Minestrappolation.tabMinistrappolation);
		glass_refined = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("glass_refined").setCreativeTab(Minestrappolation.tabMinistrappolation);
		glass_tiles = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightOpacity(1).setUnlocalizedName("glass_tiles").setCreativeTab(Minestrappolation.tabMinistrappolation);
		glass_window = new BlockTransparent(Material.iron, MapColor.airColor, false).setHardness(0.8F).setResistance(2.0F).setStepSound(Block.soundTypeGlass).setLightOpacity(2).setUnlocalizedName("glass_window").setCreativeTab(Minestrappolation.tabMinistrappolation);
		stone_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_boulder").setCreativeTab(Minestrappolation.tabMinistrappolation);
		stone_lamp_glowstone = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setLightLevel(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_lamp_glowstone").setCreativeTab(Minestrappolation.tabMinistrappolation);
		stone_lamp_prismarine = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setLightLevel(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_lamp_prismarine").setCreativeTab(Minestrappolation.tabMinistrappolation);
		stone_lamp_sunstone = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setLightLevel(0.9F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_lamp_sunstone").setCreativeTab(Minestrappolation.tabMinistrappolation);
		stone_pattern_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_pattern_bricks").setCreativeTab(Minestrappolation.tabMinistrappolation);
		stone_refined = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_refined").setCreativeTab(Minestrappolation.tabMinistrappolation);
		stone_tiles = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_tiles").setCreativeTab(Minestrappolation.tabMinistrappolation);
		ministrapp_log = new MBlockLog().setUnlocalizedName("ministrapp_log");
		ministrapp_leaves = new MBlockLeaves().setUnlocalizedName("ministrapp_leaves");
		ministrapp_sapling = new MBlockSapling();
		ministrapp_planks = new MBlockPlanks().setUnlocalizedName("ministrapp_planks");
		
		godstone = new BlockGodstone(Material.rock, MapColor.yellowColor).setHardness(6F).setResistance(9F).setUnlocalizedName("godstone");
		
		// Biome Stones
		biome_stones = new BlockBiomeStones().setHardness(1.5F).setUnlocalizedName("biome_stone");
		biome_cobble = new BlockBiomeCobble().setHardness(1F).setUnlocalizedName("biome_cobble");
		biome_bricks = new BlockBiomeBricks().setHardness(.8F).setUnlocalizedName("biome_bricks");
		
		register();
		registerHarvestLevels();
	}
	
	private static void register()
	{
		register(copper_ore);
		register(copper_block);
		register(tin_ore);
		register(tin_block);
		register(sunstone_ore);
		register(sunstone_block);
		register(slate);
		
		register(snow_bricks);
		register(snow_refined);
		register(snow_tiles);
		register(glass_bricks);
		register(glass_refined);
		register(glass_tiles);
		register(glass_window);
		register(stone_boulder);
		register(stone_lamp_glowstone);
		register(stone_lamp_prismarine);
		register(stone_lamp_sunstone);
		register(stone_pattern_bricks);
		register(stone_refined);
		register(stone_tiles);
		
		register(godstone);
		
		//Wood stuff
		GameRegistry.registerBlock(ministrapp_log, ItemBlockLog.class, ministrapp_log.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ministrapp_leaves, ItemBlockLeaves.class, ministrapp_leaves.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ministrapp_sapling, ItemBlockSapling.class, ministrapp_sapling.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ministrapp_planks, ItemBlockPlanks.class, ministrapp_planks.getUnlocalizedName().substring(5));
		
		// Biome Stones
		GameRegistry.registerBlock(biome_stones, ItemBlockBiomeStones.class, biome_stones.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_cobble, ItemBlockBiomeCobble.class, biome_cobble.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_bricks, ItemBlockBiomeBricks.class, biome_bricks.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(copper_ore);
		registerRender(copper_block);
		registerRender(tin_ore);
		registerRender(tin_block);
		registerRender(sunstone_ore);
		registerRender(sunstone_block);
		registerRender(slate);
		
		registerRender(snow_refined);
		registerRender(snow_tiles);
		registerRender(snow_bricks);
		registerRender(glass_bricks);
		registerRender(glass_refined);
		registerRender(glass_tiles);
		registerRender(glass_window);
		registerRender(stone_boulder);
		registerRender(stone_lamp_glowstone);
		registerRender(stone_lamp_prismarine);
		registerRender(stone_lamp_sunstone);
		registerRender(stone_pattern_bricks);
		registerRender(stone_refined);
		registerRender(stone_tiles);
		registerRender(ministrapp_log);
		registerRender(ministrapp_leaves);
		registerRender(ministrapp_sapling);
		registerRender(godstone);
		
	}
	
	private static void register(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	private static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MReference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	private static void registerHarvestLevels()
	{
		snow_refined.setHarvestLevel("shovel", 0);
		snow_tiles.setHarvestLevel("shovel", 0);
		snow_bricks.setHarvestLevel("shovel", 0);
		copper_ore.setHarvestLevel("pickaxe", 0);
		copper_block.setHarvestLevel("pickaxe", 0);
		tin_ore.setHarvestLevel("pickaxe", 0);
		tin_block.setHarvestLevel("pickaxe", 0);
		sunstone_ore.setHarvestLevel("pickaxe", 2);
		glass_window.setHarvestLevel("pickaxe", 0);
		stone_boulder.setHarvestLevel("pickaxe", 1);
		stone_lamp_glowstone.setHarvestLevel("pickaxe", 0);
		stone_lamp_prismarine.setHarvestLevel("pickaxe", 0);
		stone_lamp_sunstone.setHarvestLevel("pickaxe", 0);
		stone_pattern_bricks.setHarvestLevel("pickaxe", 0);
		stone_refined.setHarvestLevel("pickaxe", 0);
		stone_tiles.setHarvestLevel("pickaxe", 0);
		
		// stone_decor.setHarvestLevel("pickaxe", 0);
	}
}
