package minestrapteam.minestrappolation.lib;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.block.BlockAlloy;
import minestrapteam.minestrappolation.block.BlockBarrel;
import minestrapteam.minestrappolation.block.BlockBiomeBricks;
import minestrapteam.minestrappolation.block.BlockBlazium;
import minestrapteam.minestrappolation.block.BlockBoulder;
import minestrapteam.minestrappolation.block.BlockChiseled;
import minestrapteam.minestrappolation.block.BlockCrate;
import minestrapteam.minestrappolation.block.BlockCrusher;
import minestrapteam.minestrappolation.block.BlockFrostGenerator;
import minestrapteam.minestrappolation.block.BlockGodstone;
import minestrapteam.minestrappolation.block.BlockInvincium;
import minestrapteam.minestrappolation.block.BlockMDoor;
import minestrapteam.minestrappolation.block.BlockMFalling;
import minestrapteam.minestrappolation.block.BlockMPane;
import minestrapteam.minestrappolation.block.BlockMSand;
import minestrapteam.minestrappolation.block.BlockMStorage;
import minestrapteam.minestrappolation.block.BlockMelter;
import minestrapteam.minestrappolation.block.BlockPermaFrost;
import minestrapteam.minestrappolation.block.BlockPermaFrostDirt;
import minestrapteam.minestrappolation.block.BlockRadationMineral;
import minestrapteam.minestrappolation.block.BlockRadiationInsulated;
import minestrapteam.minestrappolation.block.BlockRoads;
import minestrapteam.minestrappolation.block.BlockSawmill;
import minestrapteam.minestrappolation.block.BlockSoul;
import minestrapteam.minestrappolation.block.BlockStoneCutter;
import minestrapteam.minestrappolation.block.BlockSunstoneBlock;
import minestrapteam.minestrappolation.block.BlockTransparent;
import minestrapteam.minestrappolation.block.MBlock;
import minestrapteam.minestrappolation.block.MBlockLeaves;
import minestrapteam.minestrappolation.block.MBlockLog;
import minestrapteam.minestrappolation.block.MBlockPlanks;
import minestrapteam.minestrappolation.block.MBlockSapling;
import minestrapteam.minestrappolation.block.MBlockSnow;
import minestrapteam.minestrappolation.block.MBlockStairs;
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
import minestrapteam.minestrappolation.block.ore.BlockPlutoniumOre;
import minestrapteam.minestrappolation.block.ore.BlockSoulOre;
import minestrapteam.minestrappolation.block.ore.BlockUraniumOre;
import minestrapteam.minestrappolation.block.ore.MBlockOre;
import minestrapteam.minestrappolation.enumtypes.MStoneType;
import minestrapteam.minestrappolation.enumtypes.MWoodType;
import minestrapteam.minestrappolation.item.ItemBlockBiomeBricks;
import minestrapteam.minestrappolation.item.ItemBlockChiseled;
import minestrapteam.minestrappolation.item.ItemBlockColdSand;
import minestrapteam.minestrappolation.item.ItemBlockLeaves;
import minestrapteam.minestrappolation.item.ItemBlockLog;
import minestrapteam.minestrappolation.item.ItemBlockPermaFrost;
import minestrapteam.minestrappolation.item.ItemBlockPlanks;
import minestrapteam.minestrappolation.item.ItemBlockRoads;
import minestrapteam.minestrappolation.item.ItemBlockSapling;
import minestrapteam.minestrappolation.item.ItemMDoor;
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
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MBlocks
{
	public static Block	copper_block;
	public static Block	tin_block;
	public static Block	sunstone_block;
	public static Block	blazium_block;
	public static Block	bronze_block;
	public static Block	meurodite_block;
	public static Block	plutonium_block;
	public static Block	soul_gem_block;
	public static Block	steel_block;
	public static Block	titanium_block;
	public static Block	torite_block;
	public static Block	uranium_block;
	public static Block	plutonium_insulated;
	public static Block	uranium_insulated;
	public static Block	slate;
	public static Block	flint_block;
	public static Block	sugar_block;
	public static Block	meat_block;
	
	public static Block	roads;
	public static Block chiseled;
	
	public static Block	cold_sand;
	public static Block	lichen_permafrost;
	public static Block	dirt_permafrost;
	
	public static Block	sunstone_ore;
	public static Block	copper_ore;
	public static Block	tin_ore;
	public static Block	plutonium_ore;
	public static Block	uranium_ore;
	public static Block	radiant_ore;
	public static Block	titanium_ore;
	public static Block	meurodite_ore;
	public static Block	torite_ore;
	public static Block	desert_quartz;
	public static Block	blazium_ore;
	public static Block	soul_ore;
	
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
	
	public static Block	redwood_door;
	
	// Wood
	public static Block	ministrapp_log;
	public static Block	ministrapp_leaves;
	public static Block	ministrapp_sapling;
	public static Block	ministrapp_planks;
	
	public static Block	godstone;
	
	public static Block	barrel;
	public static Block	crate;
	public static Block	melter;
	public static Block	melter_active;
	public static Block	alloy;
	public static Block	alloy_active;
	public static Block	stonecutter;
	public static Block	sawmill;
	public static Block	crusher;
	public static Block	crusher_active;
	
	// Biome Stones
	public static Block	biome_coal;
	public static Block	biome_iron;
	public static Block	biome_gold;
	public static Block	biome_redstone;
	public static Block	biome_lapis;
	public static Block	biome_diamond;
	public static Block	biome_emerald;
	public static Block	biome_sunstone;
	public static Block	biome_tin;
	public static Block	biome_copper;
	public static Block	biome_plutonium;
	public static Block	biome_uranium;
	public static Block	biome_radiant;
	public static Block	biome_titanium;
	public static Block	biome_meurodite;
	public static Block	biome_torite;
	
	public static Block	biome_stones;
	public static Block	biome_cobble;
	public static Block	biome_bricks;
	
	// Stairs
	public static Block	redwood_stairs;
	public static Block	deepstone_stairs;
	public static Block	coldstone_stairs;
	public static Block	redrock_stairs;
	public static Block	oceanstone_stairs;
	public static Block	icestone_stairs;
	public static Block	poceanstone_stairs;
	public static Block	glacierstone_stairs;
	public static Block	deep_redrock_stairs;
	public static Block	deep_coldstone_stairs;
	public static Block	deepstone_brick_stairs;
	public static Block	coldstone_brick_stairs;
	public static Block	redrock_brick_stairs;
	public static Block	oceanstone_brick_stairs;
	public static Block	icestone_brick_stairs;
	public static Block	poceanstone_brick_stairs;
	public static Block	glacierstone_brick_stairs;
	public static Block	deep_redrock_brick_stairs;
	public static Block	deep_coldstone_brick_stairs;
	
	// Fence
	public static Block	redwood_fence;
	public static Block	redwood_fence_gate;
	
	// Panes
	public static Block	refined_glass_pane;
	public static Block	bricked_glass_pane;
	public static Block	tiled_glass_pane;
	public static Block	framed_glass_pane;
	
	// Misc
	public static Block	frost_generator;
	public static Block	invincium;
	
	// BLOCK ITEMS
	public static Item	redwood_door_item;
	
	public static void init()
	{
		slate = new MBlock(Material.rock, MapColor.grayColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("slate");
		
		// DECOR
		snow_refined = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.4F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_refined").setCreativeTab(Minestrappolation.tabMBuilding);
		snow_bricks = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.6F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		snow_tiles = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.6F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_tiles").setCreativeTab(Minestrappolation.tabMBuilding);
		glass_bricks = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightOpacity(1).setUnlocalizedName("glass_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		glass_refined = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("glass_refined").setCreativeTab(Minestrappolation.tabMBuilding);
		glass_tiles = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightOpacity(1).setUnlocalizedName("glass_tiles").setCreativeTab(Minestrappolation.tabMBuilding);
		glass_window = new BlockTransparent(Material.iron, MapColor.airColor, false).setHardness(0.8F).setResistance(2.0F).setStepSound(Block.soundTypeGlass).setLightOpacity(2).setUnlocalizedName("glass_window").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_boulder").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_lamp_glowstone = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setLightLevel(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_lamp_glowstone").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_lamp_prismarine = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setLightLevel(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_lamp_prismarine").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_lamp_sunstone = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setLightLevel(0.9F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_lamp_sunstone").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_pattern_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_refined = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_refined").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_tiles = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_tiles").setCreativeTab(Minestrappolation.tabMBuilding);
		copper_block = new MBlock(Material.iron, MapColor.adobeColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("copper_block").setCreativeTab(Minestrappolation.tabMBuilding);
		tin_block = new MBlock(Material.iron, MapColor.ironColor).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("tin_block").setCreativeTab(Minestrappolation.tabMBuilding);
		sunstone_block = new BlockSunstoneBlock(Material.glass, MapColor.sandColor).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightLevel(0.9F).setUnlocalizedName("sunstone_block").setCreativeTab(Minestrappolation.tabMBuilding);
		godstone = new BlockGodstone(Material.rock, MapColor.sandColor).setHardness(3F).setResistance(15F).setUnlocalizedName("godstone").setCreativeTab(Minestrappolation.tabMBuilding);
		bronze_block = new MBlock(Material.iron, MapColor.goldColor).setHardness(5.0F).setResistance(20.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("bronze_block").setCreativeTab(Minestrappolation.tabMBuilding);
		steel_block = new MBlock(Material.iron, MapColor.clayColor).setHardness(7.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("steel_block").setCreativeTab(Minestrappolation.tabMBuilding);
		meurodite_block = new MBlock(Material.iron, MapColor.obsidianColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("meurodite_block").setCreativeTab(Minestrappolation.tabMBuilding);
		torite_block = new MBlock(Material.iron, MapColor.limeColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("torite_block").setCreativeTab(Minestrappolation.tabMBuilding);
		plutonium_block = new BlockRadationMineral(4, 20, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("plutonium_block").setCreativeTab(Minestrappolation.tabMBuilding);
		uranium_block = new BlockRadationMineral(4, 20, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("uranium_block").setCreativeTab(Minestrappolation.tabMBuilding);
		plutonium_insulated = new BlockRadiationInsulated(1, 20, Material.iron, MapColor.clayColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setUnlocalizedName("plutonium_insulated").setCreativeTab(Minestrappolation.tabMTech);
		uranium_insulated = new BlockRadiationInsulated(1, 20, Material.iron, MapColor.clayColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(7.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("uranium_insulated").setCreativeTab(Minestrappolation.tabMTech);
		titanium_block = new MBlock(Material.iron, MapColor.grayColor).setHardness(10.0F).setResistance(9999.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("titanium_block").setCreativeTab(Minestrappolation.tabMBuilding);
		blazium_block = new BlockBlazium(Material.iron, MapColor.redColor).setHardness(5.0F).setResistance(10.0F).setLightLevel(0.5F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("blazium_block").setCreativeTab(Minestrappolation.tabMBuilding);
		soul_gem_block = new BlockSoul(Material.iron, MapColor.cyanColor).setHardness(10.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("soul_gem_block").setCreativeTab(Minestrappolation.tabMBuilding);
		flint_block = new BlockMStorage(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_block").setCreativeTab(Minestrappolation.tabMBuilding);
		sugar_block = new BlockMFalling(Material.sand, MapColor.snowColor).setHardness(0.5F).setStepSound(Block.soundTypeGravel).setUnlocalizedName("sugar_block").setCreativeTab(Minestrappolation.tabMBuilding);
		meat_block = new BlockMStorage(Material.clay, MapColor.pinkColor).setHardness(0.8F).setStepSound(Block.SLIME_SOUND).setUnlocalizedName("meat_block").setCreativeTab(Minestrappolation.tabMFood);
		
		roads = new BlockRoads(Material.rock, MapColor.blackColor).setUnlocalizedName("roads").setCreativeTab(Minestrappolation.tabMBuilding);
		chiseled = new BlockChiseled(Material.rock, MapColor.grayColor).setUnlocalizedName("biome_chiseled");
		
		cold_sand = new BlockMSand().setUnlocalizedName("cold_sand").setHardness(0.7F).setStepSound(Block.soundTypeSand).setCreativeTab(Minestrappolation.tabMBuilding);
		lichen_permafrost = new BlockPermaFrost().setUnlocalizedName("permafrost").setHardness(1F).setStepSound(Block.soundTypeGrass).setCreativeTab(Minestrappolation.tabMBuilding);
		dirt_permafrost = new BlockPermaFrostDirt(Material.ground, MapColor.cyanColor).setHardness(0.9F).setStepSound(Block.soundTypeGravel).setUnlocalizedName("dirt_permafrost").setCreativeTab(Minestrappolation.tabMBuilding);
		
		// Door
		redwood_door = new BlockMDoor(Material.wood).setHardness(3.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("redwood_door");
		
		// WOOD
		ministrapp_log = new MBlockLog(300).setUnlocalizedName("ministrapp_log");
		ministrapp_leaves = new MBlockLeaves(600).setUnlocalizedName("ministrapp_leaves");
		ministrapp_sapling = new MBlockSapling(600);
		ministrapp_planks = new MBlockPlanks(300).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("ministrapp_planks");
		
		// ORES
		sunstone_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.sunstone_shard, 0, 2, 5, 1, 3, "pickaxe", 2, true).setHardness(2.6F).setResistance(4.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.7F).setUnlocalizedName("sunstone_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		tin_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(3.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("tin_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		copper_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("copper_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		plutonium_ore = new BlockPlutoniumOre(2, 20, Material.rock, MapColor.stoneColor, null, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("plutonium_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		uranium_ore = new BlockUraniumOre(2, 20, Material.rock, MapColor.stoneColor, null, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("uranium_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		radiant_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.radiant_quartz, 0, 1, 5, 1, 2, "pickaxe", 3, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("radiant_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		titanium_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 3, false).setHardness(5.0F).setResistance(100.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("titanium_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		meurodite_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.meurodite_gem, 0, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setUnlocalizedName("meurodite_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		torite_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("torite_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		desert_quartz = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.desert_quartz_item, 0, 1, 2, 1, 2, "pickaxe", 0, true).setHardness(2.0F).setStepSound(Block.soundTypePiston).setResistance(3.0F).setUnlocalizedName("desert_quartz").setCreativeTab(Minestrappolation.tabMBuilding);
		blazium_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.blaze_shard, 0, 1, 2, 1, 4, "pickaxe", 2, true).setHardness(3.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setUnlocalizedName("blazium_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		soul_ore = new BlockSoulOre(Material.rock, MapColor.stoneColor, MItems.soul_gem, 0, 1, 7, 1, 0, "shovel", 2, true).setHardness(2.0F).setStepSound(Block.soundTypePiston).setResistance(3.0F).setUnlocalizedName("soul_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		
		biome_coal = new BlockBiomeCoal(0, 0, Material.rock, MapColor.stoneColor, Items.coal, 0, 0, 1, 1, 0, "pickaxe", 0, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_coal").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_iron = new BlockBiomeIron(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 1, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_iron").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_gold = new BlockBiomeGold(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_gold").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_redstone = new BlockBiomeRedstone(0, 0, Material.rock, MapColor.stoneColor, Items.redstone, 0, 1, 5, 4, 2, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_redstone").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_lapis = new BlockBiomeLapis(0, 0, Material.rock, MapColor.stoneColor, Items.dye, 4, 2, 5, 4, 5, "pickaxe", 1, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_lapis").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_diamond = new BlockBiomeDiamond(0, 0, Material.rock, MapColor.stoneColor, Items.diamond, 0, 3, 7, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_diamond").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_emerald = new BlockBiomeEmerald(0, 0, Material.rock, MapColor.stoneColor, Items.emerald, 0, 3, 7, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_emerald").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_sunstone = new BlockBiomeSunstone(0, 0, Material.rock, MapColor.stoneColor, MItems.sunstone_shard, 0, 2, 5, 1, 3, "pickaxe", 2, true).setHardness(2.6F).setResistance(4.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.7F).setUnlocalizedName("biome_sunstone").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_tin = new BlockBiomeTin(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(3.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_tin").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_copper = new BlockBiomeCopper(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_copper").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_plutonium = new BlockBiomePlutonium(2, 20, Material.rock, MapColor.stoneColor, null, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_plutonium").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_uranium = new BlockBiomeUranium(2, 20, Material.rock, MapColor.stoneColor, null, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_uranium").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_radiant = new BlockBiomeRadiant(0, 0, Material.rock, MapColor.stoneColor, MItems.radiant_quartz, 0, 1, 5, 1, 2, "pickaxe", 3, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_radiant").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_titanium = new BlockBiomeTitanium(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 3, false).setHardness(5.0F).setResistance(100.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_titanium").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_meurodite = new BlockBiomeMeurodite(0, 0, Material.rock, MapColor.stoneColor, MItems.meurodite_gem, 0, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setUnlocalizedName("biome_meurodite").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_torite = new BlockBiomeTorite(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_torite").setCreativeTab(Minestrappolation.tabMBuilding);
		
		// Biome Stones
		biome_stones = new BlockBiomeStones().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_stone");
		biome_cobble = new BlockBiomeCobble().setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_cobble");
		biome_bricks = new BlockBiomeBricks().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_bricks");
		
		barrel = new BlockBarrel().setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("barrel").setHardness(2.5F).setStepSound(Block.soundTypeWood);
		crate = new BlockCrate().setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("crate").setHardness(2.5F).setStepSound(Block.soundTypeWood);
		melter = new BlockMelter(false).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("melter").setHardness(5F).setStepSound(Block.soundTypePiston);
		melter_active = new BlockMelter(true).setUnlocalizedName("melter_active").setHardness(5F).setStepSound(Block.soundTypePiston);
		alloy = new BlockAlloy(false).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("alloy").setHardness(4F).setStepSound(Block.soundTypePiston);
		alloy_active = new BlockAlloy(true).setUnlocalizedName("alloy_active").setHardness(4F).setStepSound(Block.soundTypePiston);
		stonecutter = new BlockStoneCutter().setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("stonecutter").setHardness(3.5F).setStepSound(Block.soundTypePiston);
		sawmill = new BlockSawmill().setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("sawmill").setHardness(2.5F).setStepSound(Block.soundTypeWood);
		crusher = new BlockCrusher(false).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("crusher").setHardness(7F).setResistance(100.0F).setStepSound(Block.soundTypePiston);
		crusher_active = new BlockCrusher(true).setUnlocalizedName("crusher_active").setHardness(7F).setResistance(100.0F).setStepSound(Block.soundTypePiston);
		
		// Stairs
		redwood_stairs = new MBlockStairs(ministrapp_planks.getStateFromMeta(MWoodType.REDWOOD.getMetadata())).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("redwood_stairs");
		deepstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata())).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deepstone_stairs");
		coldstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.COLDSTONE.getMetadata())).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("coldstone_stairs");
		redrock_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.REDROCK.getMetadata())).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("redrock_stairs");
		oceanstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.OCEANSTONE.getMetadata())).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("oceanstone_stairs");
		icestone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.ICESTONE.getMetadata())).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("icestone_stairs");
		poceanstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata())).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("poceanstone_stairs");
		glacierstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata())).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("glacierstone_stairs");
		deep_redrock_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata())).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deep_redrock_stairs");
		deep_coldstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata())).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deep_coldstone_stairs");
		deepstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata())).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deepstone_brick_stairs");
		coldstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.COLDSTONE.getMetadata())).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("coldstone_brick_stairs");
		redrock_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.REDROCK.getMetadata())).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("redrock_brick_stairs");
		oceanstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.OCEANSTONE.getMetadata())).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("oceanstone_brick_stairs");
		icestone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.ICESTONE.getMetadata())).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("icestone_brick_stairs");
		poceanstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata())).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("poceanstone_brick_stairs");
		glacierstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata())).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("glacierstone_brick_stairs");
		deep_redrock_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata())).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deep_redrock_brick_stairs");
		deep_coldstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata())).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deep_coldstone_brick_stairs");
		
		// Fence
		redwood_fence = new BlockFence(Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("redwood_fence");
		redwood_fence_gate = new BlockFenceGate().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("redwood_fence_gate");
		
		// Pane
		refined_glass_pane = new BlockMPane(Material.glass, false).setUnlocalizedName("refined_pane");
		bricked_glass_pane = new BlockMPane(Material.glass, false).setUnlocalizedName("bricked_pane");
		tiled_glass_pane = new BlockMPane(Material.glass, false).setUnlocalizedName("tiled_pane");
		framed_glass_pane = new BlockMPane(Material.glass, false).setUnlocalizedName("framed_pane");
		
		// Misc
		frost_generator = new BlockFrostGenerator(Material.rock, MapColor.iceColor).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("frost_generator");
		invincium = new BlockInvincium(Material.rock).setUnlocalizedName("invincium").setBlockUnbreakable().setHardness(50000F).setCreativeTab(Minestrappolation.tabMBuilding);
		
		// BLOCK ITEMS
		redwood_door_item = new ItemMDoor(redwood_door).setUnlocalizedName("redwood_door_item");
		
		Blocks.bedrock.setHardness(5F);
		
		register();
		registerHarvestLevels();
	}
	
	private static void register()
	{
		register(dirt_permafrost);
		GameRegistry.registerBlock(lichen_permafrost, ItemBlockPermaFrost.class, lichen_permafrost.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cold_sand, ItemBlockColdSand.class, cold_sand.getUnlocalizedName().substring(5));
		
		register(snow_bricks);
		register(snow_refined);
		register(snow_tiles);
		register(glass_bricks);
		register(glass_refined);
		register(glass_tiles);
		register(glass_window);
		
		GameRegistry.registerBlock(ministrapp_log, ItemBlockLog.class, ministrapp_log.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ministrapp_planks, ItemBlockPlanks.class, ministrapp_planks.getUnlocalizedName().substring(5));
		register(redwood_stairs);
		
		register(slate);
		GameRegistry.registerBlock(roads, ItemBlockRoads.class, roads.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(chiseled, ItemBlockChiseled.class, chiseled.getUnlocalizedName().substring(5));
		register(stone_pattern_bricks);
		register(stone_refined);
		register(stone_tiles);
		register(stone_lamp_glowstone);
		register(stone_lamp_prismarine);
		register(stone_lamp_sunstone);
		GameRegistry.registerBlock(biome_stones, ItemBlockBiomeStones.class, biome_stones.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_cobble, ItemBlockBiomeCobble.class, biome_cobble.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_bricks, ItemBlockBiomeBricks.class, biome_bricks.getUnlocalizedName().substring(5));
		register(deepstone_stairs);
		register(coldstone_stairs);
		register(redrock_stairs);
		register(oceanstone_stairs);
		register(icestone_stairs);
		register(poceanstone_stairs);
		register(glacierstone_stairs);
		register(deep_redrock_stairs);
		register(deep_coldstone_stairs);
		register(deepstone_brick_stairs);
		register(coldstone_brick_stairs);
		register(redrock_brick_stairs);
		register(oceanstone_brick_stairs);
		register(icestone_brick_stairs);
		register(poceanstone_brick_stairs);
		register(glacierstone_brick_stairs);
		register(deep_redrock_brick_stairs);
		register(deep_coldstone_brick_stairs);
		
		register(sugar_block);
		register(flint_block);
		register(copper_block);
		register(tin_block);
		register(bronze_block);
		register(steel_block);
		register(meurodite_block);
		register(torite_block);
		register(sunstone_block);
		register(plutonium_block);
		register(uranium_block);
		register(titanium_block);
		register(blazium_block);
		register(soul_gem_block);
		register(godstone);
		
		register(stone_boulder);
		
		register(desert_quartz);
		GameRegistry.registerBlock(biome_coal, ItemBlockBiomeCoal.class, biome_coal.getUnlocalizedName().substring(5));
		register(copper_ore);
		GameRegistry.registerBlock(biome_copper, ItemBlockBiomeCopper.class, biome_copper.getUnlocalizedName().substring(5));
		register(tin_ore);
		GameRegistry.registerBlock(biome_tin, ItemBlockBiomeTin.class, biome_tin.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_iron, ItemBlockBiomeIron.class, biome_iron.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_gold, ItemBlockBiomeGold.class, biome_gold.getUnlocalizedName().substring(5));
		register(meurodite_ore);
		GameRegistry.registerBlock(biome_meurodite, ItemBlockBiomeMeurodite.class, biome_meurodite.getUnlocalizedName().substring(5));
		register(torite_ore);
		GameRegistry.registerBlock(biome_torite, ItemBlockBiomeTorite.class, biome_torite.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_lapis, ItemBlockBiomeLapis.class, biome_lapis.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_redstone, ItemBlockBiomeRedstone.class, biome_redstone.getUnlocalizedName().substring(5));
		register(sunstone_ore);
		GameRegistry.registerBlock(biome_sunstone, ItemBlockBiomeSunstone.class, biome_sunstone.getUnlocalizedName().substring(5));
		register(plutonium_ore);
		GameRegistry.registerBlock(biome_plutonium, ItemBlockBiomePlutonium.class, biome_plutonium.getUnlocalizedName().substring(5));
		register(uranium_ore);
		GameRegistry.registerBlock(biome_uranium, ItemBlockBiomeUranium.class, biome_uranium.getUnlocalizedName().substring(5));
		register(radiant_ore);
		GameRegistry.registerBlock(biome_radiant, ItemBlockBiomeRadiant.class, biome_radiant.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_emerald, ItemBlockBiomeEmerald.class, biome_emerald.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(biome_diamond, ItemBlockBiomeDiamond.class, biome_diamond.getUnlocalizedName().substring(5));
		register(titanium_ore);
		GameRegistry.registerBlock(biome_titanium, ItemBlockBiomeTitanium.class, biome_titanium.getUnlocalizedName().substring(5));
		register(blazium_ore);
		register(soul_ore);
		register(invincium);
		
		GameRegistry.registerBlock(ministrapp_sapling, ItemBlockSapling.class, ministrapp_sapling.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(ministrapp_leaves, ItemBlockLeaves.class, ministrapp_leaves.getUnlocalizedName().substring(5));
		register(redwood_fence);
		register(refined_glass_pane);
		register(bricked_glass_pane);
		register(tiled_glass_pane);
		register(framed_glass_pane);
		register(redwood_fence_gate);
		register(redwood_door);
		GameRegistry.registerItem(redwood_door_item, redwood_door_item.getUnlocalizedName().substring(5));
		register(crate);
		register(barrel);
		
		register(plutonium_insulated);
		register(uranium_insulated);
		register(sawmill);
		register(stonecutter);
		register(alloy);
		register(alloy_active);
		register(melter);
		register(melter_active);
		register(frost_generator);
		register(crusher);
		register(crusher_active);
		
		register(meat_block);
	}
	
	public static void registerRenders()
	{
		registerRender(copper_ore);
		registerRender(copper_block);
		registerRender(tin_ore);
		registerRender(tin_block);
		registerRender(sunstone_ore);
		registerRender(sunstone_block);
		registerRender(bronze_block);
		registerRender(steel_block);
		registerRender(meurodite_block);
		registerRender(torite_block);
		registerRender(plutonium_block);
		registerRender(uranium_block);
		registerRender(plutonium_insulated);
		registerRender(uranium_insulated);
		registerRender(titanium_block);
		registerRender(blazium_block);
		registerRender(soul_gem_block);
		registerRender(slate);
		registerRender(flint_block);
		registerRender(sugar_block);
		registerRender(meat_block);
		
		registerRender(roads);
		registerRender(chiseled);
		
		registerRender(cold_sand);
		registerRender(lichen_permafrost);
		registerRender(dirt_permafrost);
		
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
		registerRender(radiant_ore);
		registerRender(meurodite_ore);
		registerRender(torite_ore);
		registerRender(desert_quartz);
		registerRender(blazium_ore);
		registerRender(soul_ore);
		registerRender(barrel);
		registerRender(crate);
		registerRender(melter);
		registerRender(melter_active);
		registerRender(redwood_stairs);
		registerRender(deepstone_stairs);
		registerRender(coldstone_stairs);
		registerRender(redrock_stairs);
		registerRender(oceanstone_stairs);
		registerRender(icestone_stairs);
		registerRender(poceanstone_stairs);
		registerRender(glacierstone_stairs);
		registerRender(deep_redrock_stairs);
		registerRender(deep_coldstone_stairs);
		registerRender(deepstone_brick_stairs);
		registerRender(coldstone_brick_stairs);
		registerRender(redrock_brick_stairs);
		registerRender(oceanstone_brick_stairs);
		registerRender(icestone_brick_stairs);
		registerRender(poceanstone_brick_stairs);
		registerRender(glacierstone_brick_stairs);
		registerRender(deep_redrock_brick_stairs);
		registerRender(deep_coldstone_brick_stairs);
		registerRender(redwood_door);
		registerRender(alloy);
		registerRender(alloy_active);
		registerRender(stonecutter);
		registerRender(sawmill);
		registerRender(crusher);
		registerRender(crusher_active);
		registerRender(redwood_door_item);
		registerRender(redwood_fence);
		registerRender(redwood_fence_gate);
		registerRender(refined_glass_pane);
		registerRender(bricked_glass_pane);
		registerRender(tiled_glass_pane);
		registerRender(framed_glass_pane);
		registerRender(frost_generator);
		registerRender(invincium);
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
	
	private static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MReference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	private static void registerHarvestLevels()
	{
		slate.setHarvestLevel("pickaxe", 0);
		snow_refined.setHarvestLevel("shovel", 0);
		snow_tiles.setHarvestLevel("shovel", 0);
		snow_bricks.setHarvestLevel("shovel", 0);
		copper_block.setHarvestLevel("pickaxe", 0);
		tin_block.setHarvestLevel("pickaxe", 0);
		bronze_block.setHarvestLevel("pickaxe", 2);
		steel_block.setHarvestLevel("pickaxe", 2);
		meurodite_block.setHarvestLevel("pickaxe", 2);
		torite_block.setHarvestLevel("pickaxe", 2);
		uranium_block.setHarvestLevel("pickaxe", 2);
		plutonium_block.setHarvestLevel("pickaxe", 2);
		uranium_insulated.setHarvestLevel("pickaxe", 2);
		plutonium_insulated.setHarvestLevel("pickaxe", 2);
		titanium_block.setHarvestLevel("pickaxe", 3);
		blazium_block.setHarvestLevel("pickaxe", 2);
		soul_gem_block.setHarvestLevel("pickaxe", 3);
		glass_window.setHarvestLevel("pickaxe", 0);
		stone_boulder.setHarvestLevel("pickaxe", 1);
		stone_lamp_glowstone.setHarvestLevel("pickaxe", 0);
		stone_lamp_prismarine.setHarvestLevel("pickaxe", 0);
		stone_lamp_sunstone.setHarvestLevel("pickaxe", 0);
		stone_pattern_bricks.setHarvestLevel("pickaxe", 0);
		stone_refined.setHarvestLevel("pickaxe", 0);
		stone_tiles.setHarvestLevel("pickaxe", 0);
		godstone.setHarvestLevel("pickaxe", 0);
		
		deepstone_stairs.setHarvestLevel("pickaxe", 2);
		redrock_stairs.setHarvestLevel("pickaxe", 0);
		deep_redrock_stairs.setHarvestLevel("pickaxe", 2);
		coldstone_stairs.setHarvestLevel("pickaxe", 0);
		deep_coldstone_stairs.setHarvestLevel("pickaxe", 2);
		icestone_stairs.setHarvestLevel("pickaxe", 0);
		glacierstone_stairs.setHarvestLevel("pickaxe", 2);
		oceanstone_stairs.setHarvestLevel("pickaxe", 0);
		poceanstone_stairs.setHarvestLevel("pickaxe", 2);
		
		deepstone_brick_stairs.setHarvestLevel("pickaxe", 2);
		redrock_brick_stairs.setHarvestLevel("pickaxe", 0);
		deep_redrock_brick_stairs.setHarvestLevel("pickaxe", 2);
		coldstone_brick_stairs.setHarvestLevel("pickaxe", 0);
		deep_coldstone_brick_stairs.setHarvestLevel("pickaxe", 2);
		icestone_brick_stairs.setHarvestLevel("pickaxe", 0);
		glacierstone_brick_stairs.setHarvestLevel("pickaxe", 2);
		oceanstone_brick_stairs.setHarvestLevel("pickaxe", 0);
		poceanstone_brick_stairs.setHarvestLevel("pickaxe", 2);
		
		// Coal
		biome_coal.setHarvestLevel("pickaxe", 2, biome_coal.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		biome_coal.setHarvestLevel("pickaxe", 2, biome_coal.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		biome_coal.setHarvestLevel("pickaxe", 2, biome_coal.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		biome_coal.setHarvestLevel("pickaxe", 2, biome_coal.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		biome_coal.setHarvestLevel("pickaxe", 2, biome_coal.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Iron
		biome_iron.setHarvestLevel("pickaxe", 2, biome_iron.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		biome_iron.setHarvestLevel("pickaxe", 2, biome_iron.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		biome_iron.setHarvestLevel("pickaxe", 2, biome_iron.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		biome_iron.setHarvestLevel("pickaxe", 2, biome_iron.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		biome_iron.setHarvestLevel("pickaxe", 2, biome_iron.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Lapis
		biome_lapis.setHarvestLevel("pickaxe", 2, biome_lapis.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		biome_lapis.setHarvestLevel("pickaxe", 2, biome_lapis.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		biome_lapis.setHarvestLevel("pickaxe", 2, biome_lapis.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		biome_lapis.setHarvestLevel("pickaxe", 2, biome_lapis.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		biome_lapis.setHarvestLevel("pickaxe", 2, biome_lapis.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Tin
		biome_tin.setHarvestLevel("pickaxe", 2, biome_tin.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		biome_tin.setHarvestLevel("pickaxe", 2, biome_tin.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		biome_tin.setHarvestLevel("pickaxe", 2, biome_tin.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		biome_tin.setHarvestLevel("pickaxe", 2, biome_tin.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		biome_tin.setHarvestLevel("pickaxe", 2, biome_tin.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Copper
		biome_copper.setHarvestLevel("pickaxe", 2, biome_copper.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		biome_copper.setHarvestLevel("pickaxe", 2, biome_copper.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		biome_copper.setHarvestLevel("pickaxe", 2, biome_copper.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		biome_copper.setHarvestLevel("pickaxe", 2, biome_copper.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		biome_copper.setHarvestLevel("pickaxe", 2, biome_copper.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Stones
		biome_stones.setHarvestLevel("pickaxe", 2, biome_stones.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		biome_stones.setHarvestLevel("pickaxe", 2, biome_stones.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		biome_stones.setHarvestLevel("pickaxe", 2, biome_stones.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		biome_stones.setHarvestLevel("pickaxe", 2, biome_stones.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		biome_stones.setHarvestLevel("pickaxe", 2, biome_stones.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Cobble
		biome_cobble.setHarvestLevel("pickaxe", 2, biome_cobble.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		biome_cobble.setHarvestLevel("pickaxe", 2, biome_cobble.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		biome_cobble.setHarvestLevel("pickaxe", 2, biome_cobble.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		biome_cobble.setHarvestLevel("pickaxe", 2, biome_cobble.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		biome_cobble.setHarvestLevel("pickaxe", 2, biome_cobble.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Bricks
		biome_bricks.setHarvestLevel("pickaxe", 2, biome_bricks.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		biome_bricks.setHarvestLevel("pickaxe", 2, biome_bricks.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		biome_bricks.setHarvestLevel("pickaxe", 2, biome_bricks.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		biome_bricks.setHarvestLevel("pickaxe", 2, biome_bricks.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		biome_bricks.setHarvestLevel("pickaxe", 2, biome_bricks.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
	}
}
