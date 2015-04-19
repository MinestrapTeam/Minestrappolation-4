package com.delocuro.ministrappolation.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.delocuro.ministrappolation.Minestrappolation;
import com.delocuro.ministrappolation.Reference;
import com.delocuro.ministrappolation.blocks.BlockBoulder;
import com.delocuro.ministrappolation.blocks.MBlock;
import com.delocuro.ministrappolation.blocks.BlockMinistrappLeaf;
import com.delocuro.ministrappolation.blocks.BlockMinistrappLog;
import com.delocuro.ministrappolation.blocks.BlockMinistrappOre;
import com.delocuro.ministrappolation.blocks.BlockSunstoneBlock;
import com.delocuro.ministrappolation.blocks.BlockTransparent;
//import com.delocuro.ministrappolation.blocks.MinistrappolationContainer;

public class MinestrappolationBlocks {
	
	public static Block copper_ore;
	public static Block copper_block;
	public static Block tin_ore;
	public static Block tin_block;
	public static Block sunstone_ore;
	public static Block sunstone_block;
	public static Block glass_bricks;
	public static Block glass_refined;
	public static Block glass_tiles;
	public static Block glass_window;
	public static Block stone_boulder;
	public static Block stone_lamp_glowstone;
	public static Block stone_lamp_prismarine;
	public static Block stone_lamp_sunstone;
	public static Block stone_pattern_bricks;
	public static Block stone_refined;
	public static Block stone_tiles;
	public static Block ministrapp_log;
	public static Block ministrapp_leaves;
	
	//public static Block stone_decor;
	//public static Block crate;
	
	public static void init()
	{
		copper_ore = new MBlock(Material.rock, MapColor.stoneColor).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("copper_ore").setCreativeTab(Minestrappolation.tabMinistrappolation);
		copper_block = new MBlock(Material.iron, MapColor.adobeColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("copper_block").setCreativeTab(Minestrappolation.tabMinistrappolation);
		tin_ore = new MBlock(Material.rock, MapColor.stoneColor).setHardness(3.0F).setResistance(3.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("tin_ore").setCreativeTab(Minestrappolation.tabMinistrappolation);
		tin_block = new MBlock(Material.iron, MapColor.ironColor).setHardness(5.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("tin_block").setCreativeTab(Minestrappolation.tabMinistrappolation);
		sunstone_ore = new BlockMinistrappOre(Material.rock, MapColor.stoneColor).setHardness(2.8F).setResistance(4.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.7F).setUnlocalizedName("sunstone_ore").setCreativeTab(Minestrappolation.tabMinistrappolation);
		sunstone_block = new BlockSunstoneBlock(Material.glass, MapColor.sandColor).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightLevel(0.9F).setUnlocalizedName("sunstone_block").setCreativeTab(Minestrappolation.tabMinistrappolation);
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
		ministrapp_log = new BlockMinistrappLog().setUnlocalizedName("ministrapp_log");
		ministrapp_leaves = new BlockMinistrappLeaf().setUnlocalizedName("ministrapp_leaves");
		
		//stone_decor = (new BlockStoneDecor()).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_decor");
		//crate = new BlockMinistrappolationContainer(Material.wood, MapColor.woodColor).setHardness(2.5F).setCreativeTab(Ministrappolation.tabMinistrappolation).setStepSound(Block.soundTypeWood).setUnlocalizedName("crate");
	}
	
	public static void register()
	{
		GameRegistry.registerBlock(copper_ore, copper_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(copper_block, copper_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tin_ore, tin_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tin_block, tin_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(sunstone_ore, sunstone_ore.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(sunstone_block, sunstone_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(glass_bricks, glass_bricks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(glass_refined, glass_refined.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(glass_tiles, glass_tiles.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(glass_window, glass_window.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(stone_boulder, stone_boulder.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(stone_lamp_glowstone, stone_lamp_glowstone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(stone_lamp_prismarine, stone_lamp_prismarine.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(stone_lamp_sunstone, stone_lamp_sunstone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(stone_pattern_bricks, stone_pattern_bricks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(stone_refined, stone_refined.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(stone_tiles, stone_tiles.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ministrapp_log, ministrapp_log.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ministrapp_leaves, ministrapp_leaves.getUnlocalizedName().substring(5));
		
		//GameRegistry.registerBlock(stone_decor, stone_decor.getUnlocalizedName().substring(5));
		//GameRegistry.registerBlock(crate, crate.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(copper_ore);
		registerRender(copper_block);
		registerRender(tin_ore);
		registerRender(tin_block);
		registerRender(sunstone_ore);
		registerRender(sunstone_block);
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
		
		//registerRender(stone_decor);
		//registerRender(crate);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerHarvestLevels()
	{
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
		
		//stone_decor.setHarvestLevel("pickaxe", 0);
	}
}
