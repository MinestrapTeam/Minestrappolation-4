package minestrapteam.minestrappolation.lib;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.block.BlockBarrel;
import minestrapteam.minestrappolation.block.BlockBiomeBricks;
import minestrapteam.minestrappolation.block.BlockBoulder;
import minestrapteam.minestrappolation.block.BlockCrate;
import minestrapteam.minestrappolation.block.BlockGodstone;
import minestrapteam.minestrappolation.block.BlockMelter;
import minestrapteam.minestrappolation.block.BlockPlutoniumOre;
import minestrapteam.minestrappolation.block.BlockSoulOre;
import minestrapteam.minestrappolation.block.BlockSunstoneBlock;
import minestrapteam.minestrappolation.block.BlockTransparent;
import minestrapteam.minestrappolation.block.BlockUraniumOre;
import minestrapteam.minestrappolation.block.MBlock;
import minestrapteam.minestrappolation.block.MBlockLeaves;
import minestrapteam.minestrappolation.block.MBlockLog;
import minestrapteam.minestrappolation.block.MBlockOre;
import minestrapteam.minestrappolation.block.MBlockPlanks;
import minestrapteam.minestrappolation.block.MBlockSapling;
import minestrapteam.minestrappolation.block.MBlockSnow;
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
import minestrapteam.minestrappolation.item.ItemBlockBiomeBricks;
import minestrapteam.minestrappolation.item.ItemBlockLeaves;
import minestrapteam.minestrappolation.item.ItemBlockLog;
import minestrapteam.minestrappolation.item.ItemBlockPlanks;
import minestrapteam.minestrappolation.item.ItemBlockSapling;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeCoal;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeCobble;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeCopper;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeDiamond;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeEmerald;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeGold;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeIron;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeLapis;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeMeurodite;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomePlutonium;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeRadiant;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeRedstone;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeStones;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeSunstone;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeTin;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeTitanium;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeTorite;
import minestrapteam.minestrappolation.item.BiomeItems.ItemBlockBiomeUranium;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class MBlocks
{
	
	
	public static Block	copper_block;
	public static Block	tin_block;
	public static Block	sunstone_block;
	public static Block	slate;
	
	public static Block	sunstone_ore;
	public static Block	copper_ore;
	public static Block	tin_ore;
	public static Block plutonium_ore;
	public static Block uranium_ore;
	public static Block radiant_ore;
	public static Block titanium_ore;
	public static Block meurodite_ore;
	public static Block torite_ore;
	public static Block desert_quartz;
	public static Block blazium_ore;
	public static Block soul_ore;
	
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
	
	public static Block barrel;
	public static Block crate;
	public static Block melter;
	
	// Biome Stones
	public static Block			   biome_coal;
	public static Block			   biome_iron;
	public static Block			   biome_gold;
	public static Block			   biome_redstone;
	public static Block			   biome_lapis;
	public static Block			   biome_diamond;
	public static Block			   biome_emerald;
	public static Block			   biome_sunstone;
	public static Block			   biome_tin;
	public static Block			   biome_copper;
	public static Block			   biome_plutonium;
	public static Block			   biome_uranium;
	public static Block			   biome_radiant;
	public static Block			   biome_titanium;
	public static Block			   biome_meurodite;
	public static Block			   biome_torite;
	
	public static Block			   biome_stones;
	public static Block			   biome_cobble;
	public static Block			   biome_bricks;
	
	// public static Block stone_decor;
	// public static Block crate;
	
	public static void init()
	{
		slate = new MBlock(Material.rock, MapColor.grayColor).setUnlocalizedName("slate");
		
		
		//DECOR
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
		copper_block = new MBlock(Material.iron, MapColor.adobeColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("copper_block").setCreativeTab(Minestrappolation.tabMinistrappolation);
		tin_block = new MBlock(Material.iron, MapColor.ironColor).setHardness(5.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("tin_block").setCreativeTab(Minestrappolation.tabMinistrappolation);
		sunstone_block = new BlockSunstoneBlock(Material.glass, MapColor.sandColor).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightLevel(0.9F).setUnlocalizedName("sunstone_block").setCreativeTab(Minestrappolation.tabMinistrappolation);
		godstone = new BlockGodstone(Material.rock, MapColor.sandColor).setHardness(3F).setResistance(15F).setUnlocalizedName("godstone");
				
		//WOOD
		ministrapp_log = new MBlockLog().setUnlocalizedName("ministrapp_log");
		ministrapp_leaves = new MBlockLeaves().setUnlocalizedName("ministrapp_leaves");
		ministrapp_sapling = new MBlockSapling();
		ministrapp_planks = new MBlockPlanks().setUnlocalizedName("ministrapp_planks");	
		
		//ORES
		sunstone_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.sunstone_shard, 0, 2, 5, 1, 3, "pickaxe", 2, true).setHardness(2.6F).setResistance(4.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.7F).setUnlocalizedName("sunstone_ore");
		tin_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(3.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("tin_ore");
		copper_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("copper_ore");
		plutonium_ore = new BlockPlutoniumOre(5, 60, Material.rock, MapColor.stoneColor, null, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("plutonium_ore");
		uranium_ore = new BlockUraniumOre(2, 60, Material.rock, MapColor.stoneColor, null, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("uranium_ore");
		radiant_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.radiant_quartz, 0, 1, 5, 1, 2, "pickaxe", 3, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("radiant_ore");
		titanium_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 3, false).setHardness(5.0F).setResistance(40.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("titanium_ore");
		meurodite_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.meurodite_gem, 0, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setUnlocalizedName("meurodite_ore");
		torite_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("torite_ore");
		desert_quartz = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.desert_quartz, 0, 1, 2, 1, 2, "pickaxe", 0, true).setHardness(2.0F).setStepSound(Block.soundTypePiston).setResistance(3.0F).setUnlocalizedName("desert_quartz");
		blazium_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.blaze_shard, 0, 1, 2, 1, 4, "pickaxe", 2, true).setHardness(3.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setUnlocalizedName("blazium_ore");
		soul_ore = new BlockSoulOre(Material.rock, MapColor.stoneColor, MItems.soul_gem, 0, 1, 7, 1, 0, "shovel", 2, true).setHardness(2.0F).setStepSound(Block.soundTypePiston).setResistance(3.0F).setUnlocalizedName("soul_ore");
		
		biome_coal = new BlockBiomeCoal(0, 0, Material.rock, MapColor.stoneColor, Items.coal, 0, 0, 1, 1, 0, "pickaxe", 0, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_coal");
		biome_iron = new BlockBiomeIron(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 1, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_iron");
		biome_gold = new BlockBiomeGold(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_gold");
		biome_redstone = new BlockBiomeRedstone(0, 0, Material.rock, MapColor.stoneColor, Items.redstone, 0, 1, 5, 4, 2, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_redstone");
		biome_lapis = new BlockBiomeLapis(0, 0, Material.rock, MapColor.stoneColor, Items.dye, 4, 2, 5, 4, 5, "pickaxe", 1, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_lapis");
		biome_diamond = new BlockBiomeDiamond(0, 0, Material.rock, MapColor.stoneColor, Items.diamond, 0, 3, 7, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_diamond");
		biome_emerald = new BlockBiomeEmerald(0, 0, Material.rock, MapColor.stoneColor, Items.emerald, 0, 3, 7, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_emerald");
		biome_sunstone = new BlockBiomeSunstone(0, 0, Material.rock, MapColor.stoneColor, MItems.sunstone_shard, 0, 2, 5, 1, 3, "pickaxe", 2, true).setHardness(2.6F).setResistance(4.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.7F).setUnlocalizedName("biome_sunstone");
		biome_tin = new BlockBiomeTin(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(3.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_tin");
		biome_copper = new BlockBiomeCopper(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_copper");
		biome_plutonium = new BlockBiomePlutonium(5, 60, Material.rock, MapColor.stoneColor, null, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_plutonium");
		biome_uranium = new BlockBiomeUranium(2, 60, Material.rock, MapColor.stoneColor, null, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_uranium");
		biome_radiant = new BlockBiomeRadiant(0, 0, Material.rock, MapColor.stoneColor, MItems.radiant_quartz, 0, 1, 5, 1, 2, "pickaxe", 3, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_radiant");
		biome_titanium = new BlockBiomeTitanium(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 3, false).setHardness(5.0F).setResistance(40.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_titanium");
		biome_meurodite = new BlockBiomeMeurodite(0, 0, Material.rock, MapColor.stoneColor, MItems.meurodite_gem, 0, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setUnlocalizedName("biome_meurodite");
		biome_torite = new BlockBiomeTorite(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_torite");
		
		// Biome Stones
		biome_stones = new BlockBiomeStones().setHardness(1.5F).setUnlocalizedName("biome_stone");
		biome_cobble = new BlockBiomeCobble().setHardness(1F).setUnlocalizedName("biome_cobble");
		biome_bricks = new BlockBiomeBricks().setHardness(.8F).setUnlocalizedName("biome_bricks");
		
		barrel = new BlockBarrel().setCreativeTab(Minestrappolation.tabMinistrappolation).setUnlocalizedName("barrel");
		crate = new BlockCrate().setCreativeTab(Minestrappolation.tabMinistrappolation).setUnlocalizedName("crate");
		melter = new BlockMelter().setCreativeTab(Minestrappolation.tabMinistrappolation).setUnlocalizedName("melter");
		
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
		
		register(plutonium_ore);
		register(uranium_ore);
		register(radiant_ore);
		register(titanium_ore);
		register(meurodite_ore);
		register(torite_ore);
		register(desert_quartz);
		register(blazium_ore);
		register(soul_ore);
		
		register(barrel);
		register(crate);
		register(melter);
		
		//Wood stuff
		GameRegistry.registerBlock(ministrapp_log, ItemBlockLog.class, ministrapp_log.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ministrapp_leaves, ItemBlockLeaves.class, ministrapp_leaves.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ministrapp_sapling, ItemBlockSapling.class, ministrapp_sapling.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ministrapp_planks, ItemBlockPlanks.class, ministrapp_planks.getUnlocalizedName().substring(5));
		
		// Biome Stones
		GameRegistry.registerBlock(biome_coal, ItemBlockBiomeCoal.class, biome_coal.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_iron, ItemBlockBiomeIron.class, biome_iron.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_gold, ItemBlockBiomeGold.class, biome_gold.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_redstone, ItemBlockBiomeRedstone.class, biome_redstone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_lapis, ItemBlockBiomeLapis.class, biome_lapis.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_diamond, ItemBlockBiomeDiamond.class, biome_diamond.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_emerald, ItemBlockBiomeEmerald.class, biome_emerald.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_sunstone, ItemBlockBiomeSunstone.class, biome_sunstone.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_tin, ItemBlockBiomeTin.class, biome_tin.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_copper, ItemBlockBiomeCopper.class, biome_copper.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_plutonium, ItemBlockBiomePlutonium.class, biome_plutonium.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_uranium, ItemBlockBiomeUranium.class, biome_uranium.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_radiant, ItemBlockBiomeRadiant.class, biome_radiant.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_titanium, ItemBlockBiomeTitanium.class, biome_titanium.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_meurodite, ItemBlockBiomeMeurodite.class, biome_meurodite.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_torite, ItemBlockBiomeTorite.class, biome_torite.getUnlocalizedName().substring(5));
		
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
		registerRender(plutonium_ore);
		registerRender(uranium_ore);
		registerRender(titanium_ore);
		registerRender(meurodite_ore);
		registerRender(torite_ore);
		registerRender(desert_quartz);
		registerRender(blazium_ore);
		registerRender(soul_ore);
		registerRender(barrel);
		registerRender(crate);
		registerRender(melter);
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
		copper_block.setHarvestLevel("pickaxe", 0);
		tin_block.setHarvestLevel("pickaxe", 0);
		glass_window.setHarvestLevel("pickaxe", 0);
		stone_boulder.setHarvestLevel("pickaxe", 1);
		stone_lamp_glowstone.setHarvestLevel("pickaxe", 0);
		stone_lamp_prismarine.setHarvestLevel("pickaxe", 0);
		stone_lamp_sunstone.setHarvestLevel("pickaxe", 0);
		stone_pattern_bricks.setHarvestLevel("pickaxe", 0);
		stone_refined.setHarvestLevel("pickaxe", 0);
		stone_tiles.setHarvestLevel("pickaxe", 0);
		godstone.setHarvestLevel("pickaxe", 0);
	}
}
