package minestrapteam.minestrappolation.lib;

import java.util.ArrayList;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.block.BlockAlloy;
import minestrapteam.minestrappolation.block.BlockBarrel;
import minestrapteam.minestrappolation.block.BlockBiomeBricks;
import minestrapteam.minestrappolation.block.BlockBlazium;
import minestrapteam.minestrappolation.block.BlockBoulder;
import minestrapteam.minestrappolation.block.BlockChiseled;
import minestrapteam.minestrappolation.block.BlockCrackedBricks;
import minestrapteam.minestrappolation.block.BlockCrate;
import minestrapteam.minestrappolation.block.BlockCrusher;
import minestrapteam.minestrappolation.block.BlockDeadBranch;
import minestrapteam.minestrappolation.block.BlockFrostGenerator;
import minestrapteam.minestrappolation.block.BlockGodstone;
import minestrapteam.minestrappolation.block.BlockInvincium;
import minestrapteam.minestrappolation.block.BlockLamp;
import minestrapteam.minestrappolation.block.BlockMDoor;
import minestrapteam.minestrappolation.block.BlockMDoubleSlab;
import minestrapteam.minestrappolation.block.BlockMFalling;
import minestrapteam.minestrappolation.block.BlockMPane;
import minestrapteam.minestrappolation.block.BlockMSand;
import minestrapteam.minestrappolation.block.BlockMSlab;
import minestrapteam.minestrappolation.block.BlockMStorage;
import minestrapteam.minestrappolation.block.BlockMelter;
import minestrapteam.minestrappolation.block.BlockMossyBricks;
import minestrapteam.minestrappolation.block.BlockMossyCobble;
import minestrapteam.minestrappolation.block.BlockPatternBricks;
import minestrapteam.minestrappolation.block.BlockPermaFrost;
import minestrapteam.minestrappolation.block.BlockPermaFrostDirt;
import minestrapteam.minestrappolation.block.BlockRadationMineral;
import minestrapteam.minestrappolation.block.BlockRadiationInsulated;
import minestrapteam.minestrappolation.block.BlockRefined;
import minestrapteam.minestrappolation.block.BlockRoads;
import minestrapteam.minestrappolation.block.BlockSawmill;
import minestrapteam.minestrappolation.block.BlockSoul;
import minestrapteam.minestrappolation.block.BlockStoneCutter;
import minestrapteam.minestrappolation.block.BlockSunstoneBlock;
import minestrapteam.minestrappolation.block.BlockTiles;
import minestrapteam.minestrappolation.block.BlockTransparent;
import minestrapteam.minestrappolation.block.MBlock;
import minestrapteam.minestrappolation.block.MBlockLeaves;
import minestrapteam.minestrappolation.block.MBlockLog;
import minestrapteam.minestrappolation.block.MBlockPillar;
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
import minestrapteam.minestrappolation.item.ItemBlockCrackedBricks;
import minestrapteam.minestrappolation.item.ItemBlockLampGlowstone;
import minestrapteam.minestrappolation.item.ItemBlockLampPrismarine;
import minestrapteam.minestrappolation.item.ItemBlockLampSunstone;
import minestrapteam.minestrappolation.item.ItemBlockLeaves;
import minestrapteam.minestrappolation.item.ItemBlockLog;
import minestrapteam.minestrappolation.item.ItemBlockMSlab;
import minestrapteam.minestrappolation.item.ItemBlockMossyBricks;
import minestrapteam.minestrappolation.item.ItemBlockMossyCobble;
import minestrapteam.minestrappolation.item.ItemBlockPatternBricks;
import minestrapteam.minestrappolation.item.ItemBlockPermaFrost;
import minestrapteam.minestrappolation.item.ItemBlockPlanks;
import minestrapteam.minestrappolation.item.ItemBlockRefined;
import minestrapteam.minestrappolation.item.ItemBlockRoads;
import minestrapteam.minestrappolation.item.ItemBlockSapling;
import minestrapteam.minestrappolation.item.ItemBlockTiles;
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
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MBlocks
{
	public static ArrayList<Block> blockList = new ArrayList<Block>();
	
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
	public static Block	sugar_block;
	public static Block	meat_block;
	
	public static Block	slate;
	public static Block	slate_bricks;
	public static Block	slate_pattern_bricks;
	public static Block	slate_refined;
	public static Block	granite_bricks;
	public static Block	granite_pattern_bricks;
	public static Block	diorite_bricks;
	public static Block	diorite_pattern_bricks;
	public static Block	andesite_bricks;
	public static Block	andesite_pattern_bricks;
	public static Block	flint_block;
	public static Block	flint_bricks;
	public static Block	flint_pattern_bricks;
	public static Block	flint_refined;
	public static Block	flint_tiles;
	public static Block	flint_chiseled;
	public static Block	flint_lamp_sunstone;
	public static Block	flint_lamp_glowstone;
	public static Block	flint_lamp_prismarine;
	public static Block	desert_quartz_block;
	public static Block	desert_quartz_chiseled;
	public static Block	radiant_block;
	public static Block	radiant_chiseled;
	
	public static Block	roads;
	public static Block chiseled;
	public static Block mossy;
	public static Block mossy_bricks;
	public static Block cracked_bricks;
	public static Block pattern_bricks;
	public static Block refined;
	public static Block tiles;
	public static Block lamp_sunstone;
	public static Block lamp_glowstone;
	public static Block lamp_prismarine;
	
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
	public static Block	red_rock_boulder;
	public static Block	coldstone_boulder;
	public static Block	icestone_boulder;
	public static Block	oceanstone_boulder;
	public static Block	stone_lamp_glowstone;
	public static Block	stone_lamp_prismarine;
	public static Block	stone_lamp_sunstone;
	public static Block	stone_pattern_bricks;
	public static Block	stone_refined;
	public static Block	stone_tiles;
	
	public static Block	redwood_door;
	public static Block	frozen_door;
	
	// Wood
	public static Block	ministrapp_log;
	public static Block	ministrapp_leaves;
	public static Block	ministrapp_sapling;
	public static Block	ministrapp_planks;
	public static Block dead_branch;
	
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
	public static Block	frozen_oak_stairs;
	public static Block	desert_quartz_stairs;
	public static Block radiant_stairs;
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
	
	public static BlockMSlab       redwood_slab;
	public static BlockMDoubleSlab redwood_double_slab;
	public static BlockMSlab       frozen_oak_slab;
	public static BlockMDoubleSlab frozen_oak_double_slab;
	public static BlockMSlab	   desert_quartz_slab;
	public static BlockMDoubleSlab desert_quartz_double_slab;
	public static BlockMSlab	   radiant_slab;
	public static BlockMDoubleSlab radiant_double_slab;
	public static BlockMSlab       deepstone_slab;
	public static BlockMDoubleSlab deepstone_double_slab;
	public static BlockMSlab       red_rock_slab;
	public static BlockMDoubleSlab red_rock_double_slab;
	public static BlockMSlab       deep_red_rock_slab;
	public static BlockMDoubleSlab deep_red_rock_double_slab;
	public static BlockMSlab       coldstone_slab;
	public static BlockMDoubleSlab coldstone_double_slab;
	public static BlockMSlab       deep_coldstone_slab;
	public static BlockMDoubleSlab deep_coldstone_double_slab;
	public static BlockMSlab       icestone_slab;
	public static BlockMDoubleSlab icestone_double_slab;
	public static BlockMSlab       glacierrock_slab;
	public static BlockMDoubleSlab glacierrock_double_slab;
	public static BlockMSlab       oceanstone_slab;
	public static BlockMDoubleSlab oceanstone_double_slab;
	public static BlockMSlab       poceanstone_slab;
	public static BlockMDoubleSlab poceanstone_double_slab;
	public static BlockMSlab       deepstone_cobble_slab;
	public static BlockMDoubleSlab deepstone_cobble_double_slab;
	public static BlockMSlab       red_rock_cobble_slab;
	public static BlockMDoubleSlab red_rock_cobble_double_slab;
	public static BlockMSlab       deep_red_rock_cobble_slab;
	public static BlockMDoubleSlab deep_red_rock_cobble_double_slab;
	public static BlockMSlab       coldstone_cobble_slab;
	public static BlockMDoubleSlab coldstone_cobble_double_slab;
	public static BlockMSlab       deep_coldstone_cobble_slab;
	public static BlockMDoubleSlab deep_coldstone_cobble_double_slab;
	public static BlockMSlab       icestone_cobble_slab;
	public static BlockMDoubleSlab icestone_cobble_double_slab;
	public static BlockMSlab       glacierrock_cobble_slab;
	public static BlockMDoubleSlab glacierrock_cobble_double_slab;
	public static BlockMSlab       oceanstone_cobble_slab;
	public static BlockMDoubleSlab oceanstone_cobble_double_slab;
	public static BlockMSlab       poceanstone_cobble_slab;
	public static BlockMDoubleSlab poceanstone_cobble_double_slab;
	public static BlockMSlab       deepstone_brick_slab;
	public static BlockMDoubleSlab deepstone_brick_double_slab;
	public static BlockMSlab       red_rock_brick_slab;
	public static BlockMDoubleSlab red_rock_brick_double_slab;
	public static BlockMSlab       deep_red_rock_brick_slab;
	public static BlockMDoubleSlab deep_red_rock_brick_double_slab;
	public static BlockMSlab       coldstone_brick_slab;
	public static BlockMDoubleSlab coldstone_brick_double_slab;
	public static BlockMSlab       deep_coldstone_brick_slab;
	public static BlockMDoubleSlab deep_coldstone_brick_double_slab;
	public static BlockMSlab       icestone_brick_slab;
	public static BlockMDoubleSlab icestone_brick_double_slab;
	public static BlockMSlab       glacierrock_brick_slab;
	public static BlockMDoubleSlab glacierrock_brick_double_slab;
	public static BlockMSlab       oceanstone_brick_slab;
	public static BlockMDoubleSlab oceanstone_brick_double_slab;
	public static BlockMSlab       poceanstone_brick_slab;
	public static BlockMDoubleSlab poceanstone_brick_double_slab;
	
	// Fence
	public static Block	redwood_fence;
	public static Block	redwood_fence_gate;
	public static Block	frozen_oak_fence;
	public static Block	frozen_oak_fence_gate;
	
	// Panes
	public static Block	refined_glass_pane;
	public static Block	bricked_glass_pane;
	public static Block	tiled_glass_pane;
	public static Block	framed_glass_pane;
	public static Block	steel_mesh;
	
	// Misc
	public static Block	frost_generator;
	public static Block	invincium;
	
	//Pillars
	public static Block desert_pillar;
	public static Block radiant_pillar;
	
	// BLOCK ITEMS
	public static Item	redwood_door_item;
	public static Item  frozen_door_item;
	
	public static void init()
	{
		slate = new MBlock(Material.rock, MapColor.grayColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("slate").setCreativeTab(Minestrappolation.tabMBuilding);;
		slate_refined = new MBlock(Material.rock, MapColor.grayColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("slate_refined").setCreativeTab(Minestrappolation.tabMBuilding);;
		slate_bricks = new MBlock(Material.rock, MapColor.grayColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("slate_bricks").setCreativeTab(Minestrappolation.tabMBuilding);;
		slate_pattern_bricks = new MBlock(Material.rock, MapColor.grayColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("slate_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);;
		diorite_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("diorite_bricks").setCreativeTab(Minestrappolation.tabMBuilding);;
		diorite_pattern_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("diorite_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);;
		granite_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("granite_bricks").setCreativeTab(Minestrappolation.tabMBuilding);;
		granite_pattern_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("granite_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);;
		andesite_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("andesite_bricks").setCreativeTab(Minestrappolation.tabMBuilding);;
		andesite_pattern_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("andesite_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);;
		flint_bricks = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_bricks").setCreativeTab(Minestrappolation.tabMBuilding);;
		flint_pattern_bricks = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);;
		flint_refined = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_refined").setCreativeTab(Minestrappolation.tabMBuilding);;
		flint_tiles = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_tiles").setCreativeTab(Minestrappolation.tabMBuilding);;
		flint_chiseled = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_chiseled").setCreativeTab(Minestrappolation.tabMBuilding);;
		flint_lamp_sunstone = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setLightLevel(0.7F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_lamp_sunstone").setCreativeTab(Minestrappolation.tabMBuilding);;
		flint_lamp_glowstone = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setLightLevel(0.8F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_lamp_glowstone").setCreativeTab(Minestrappolation.tabMBuilding);;
		flint_lamp_prismarine = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setLightLevel(0.8F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_lamp_prismarine").setCreativeTab(Minestrappolation.tabMBuilding);;
		desert_quartz_block = new MBlock(Material.rock, MapColor.adobeColor).setHardness(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("desert_quartz_block").setCreativeTab(Minestrappolation.tabMBuilding);
		desert_quartz_chiseled = new MBlock(Material.rock, MapColor.adobeColor).setHardness(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("desert_quartz_chiseled").setCreativeTab(Minestrappolation.tabMBuilding);
		radiant_block = new MBlock(Material.rock, MapColor.pinkColor).setHardness(1.0F).setLightLevel(0.6F).setStepSound(Block.soundTypePiston).setUnlocalizedName("radiant_quartz_block").setCreativeTab(Minestrappolation.tabMBuilding);
		radiant_chiseled = new MBlock(Material.rock, MapColor.pinkColor).setHardness(1.0F).setLightLevel(0.6F).setStepSound(Block.soundTypePiston).setUnlocalizedName("radiant_quartz_chiseled").setCreativeTab(Minestrappolation.tabMBuilding);
		
		// DECOR
		snow_refined = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.4F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_refined").setCreativeTab(Minestrappolation.tabMBuilding);
		snow_bricks = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.6F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		snow_tiles = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.6F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_tiles").setCreativeTab(Minestrappolation.tabMBuilding);
		glass_bricks = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightOpacity(1).setUnlocalizedName("glass_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		glass_refined = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("glass_refined").setCreativeTab(Minestrappolation.tabMBuilding);
		glass_tiles = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightOpacity(1).setUnlocalizedName("glass_tiles").setCreativeTab(Minestrappolation.tabMBuilding);
		glass_window = new BlockTransparent(Material.iron, MapColor.airColor, true).setHardness(0.8F).setResistance(2.0F).setStepSound(Block.soundTypeGlass).setLightOpacity(2).setUnlocalizedName("glass_window").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_boulder").setCreativeTab(Minestrappolation.tabMBuilding);
		red_rock_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("red_rock_boulder").setCreativeTab(Minestrappolation.tabMBuilding);
		coldstone_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("coldstone_boulder").setCreativeTab(Minestrappolation.tabMBuilding);
		icestone_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("icestone_boulder").setCreativeTab(Minestrappolation.tabMBuilding);
		oceanstone_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("oceanstone_boulder").setCreativeTab(Minestrappolation.tabMBuilding);
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
		chiseled = new BlockChiseled(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_chiseled");
		mossy = new BlockMossyCobble(Material.rock, MapColor.stoneColor).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_mossy");
		mossy_bricks = new BlockMossyBricks(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_mossy_bricks");
		cracked_bricks = new BlockCrackedBricks(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_cracked_bricks");
		pattern_bricks = new BlockPatternBricks(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_pattern_bricks");
		refined = new BlockRefined(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_refined");
		tiles = new BlockTiles(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_tiles");
		lamp_sunstone = new BlockLamp(Material.rock, MapColor.stoneColor, "sunstone").setHardness(1.5F).setResistance(10.0F).setLightLevel(0.9F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_lamp_sunstone");
		lamp_glowstone = new BlockLamp(Material.rock, MapColor.stoneColor, "glowstone").setHardness(1.5F).setResistance(10.0F).setLightLevel(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_lamp_glowstone");
		lamp_prismarine = new BlockLamp(Material.rock, MapColor.stoneColor, "prismarine").setHardness(1.5F).setResistance(10.0F).setLightLevel(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_lamp_prismarine");
		
		cold_sand = new BlockMSand().setUnlocalizedName("cold_sand").setHardness(0.7F).setStepSound(Block.soundTypeSand).setCreativeTab(Minestrappolation.tabMBuilding);
		lichen_permafrost = new BlockPermaFrost().setUnlocalizedName("permafrost").setHardness(1F).setStepSound(Block.soundTypeGrass).setCreativeTab(Minestrappolation.tabMBuilding);
		dirt_permafrost = new BlockPermaFrostDirt(Material.ground, MapColor.cyanColor).setHardness(0.9F).setStepSound(Block.soundTypeGravel).setUnlocalizedName("dirt_permafrost").setCreativeTab(Minestrappolation.tabMBuilding);
		
		// Door
		redwood_door = new BlockMDoor(Material.wood).setHardness(3.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("redwood_door");
		frozen_door = new BlockMDoor(Material.wood).setHardness(3.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("frozen_oak_door");
		
		// WOOD
		ministrapp_log = new MBlockLog(300).setUnlocalizedName("ministrapp_log");
		ministrapp_leaves = new MBlockLeaves(600).setUnlocalizedName("ministrapp_leaves");
		ministrapp_sapling = new MBlockSapling(600);
		ministrapp_planks = new MBlockPlanks(300).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("ministrapp_planks");
		dead_branch = new BlockDeadBranch(Material.vine, MapColor.woodColor).setStepSound(Block.soundTypeGrass).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("dead_branch");
		
		// ORES
		sunstone_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.sunstone_shard, 0, 2, 5, 1, 3, "pickaxe", 2, true).setHardness(2.6F).setResistance(4.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.7F).setUnlocalizedName("sunstone_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		tin_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(3.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("tin_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		copper_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("copper_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		plutonium_ore = new BlockPlutoniumOre(2, 20, Material.rock, MapColor.stoneColor, MItems.plutonium, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("plutonium_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		uranium_ore = new BlockUraniumOre(2, 20, Material.rock, MapColor.stoneColor, MItems.uranium, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("uranium_ore").setCreativeTab(Minestrappolation.tabMBuilding);
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
		biome_plutonium = new BlockBiomePlutonium(2, 20, Material.rock, MapColor.stoneColor, MItems.plutonium, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_plutonium").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_uranium = new BlockBiomeUranium(2, 20, Material.rock, MapColor.stoneColor, MItems.uranium, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_uranium").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_radiant = new BlockBiomeRadiant(0, 0, Material.rock, MapColor.stoneColor, MItems.radiant_quartz, 0, 1, 5, 1, 2, "pickaxe", 3, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_radiant").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_titanium = new BlockBiomeTitanium(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 3, false).setHardness(5.0F).setResistance(100.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_titanium").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_meurodite = new BlockBiomeMeurodite(0, 0, Material.rock, MapColor.stoneColor, MItems.meurodite_gem, 0, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setUnlocalizedName("biome_meurodite").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_torite = new BlockBiomeTorite(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_torite").setCreativeTab(Minestrappolation.tabMBuilding);
		
		// Biome Stones
		biome_stones = new BlockBiomeStones().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_stone");
		biome_cobble = new BlockBiomeCobble().setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_cobble");
		biome_bricks = new BlockBiomeBricks().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_bricks");
		
		
		//Machines and storage
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
		frost_generator = new BlockFrostGenerator(Material.rock, MapColor.iceColor).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("frost_generator");
		
		// Stairs
		redwood_stairs = new MBlockStairs(ministrapp_planks.getStateFromMeta(MWoodType.REDWOOD.getMetadata()), 300).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("redwood_stairs");
		frozen_oak_stairs = new MBlockStairs(ministrapp_planks.getStateFromMeta(MWoodType.FROZEN.getMetadata()), 300).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("frozen_oak_stairs");
		desert_quartz_stairs = new MBlockStairs(desert_quartz_block.getDefaultState(), 0).setHardness(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("desert_quartz_stairs");
		radiant_stairs = new MBlockStairs(radiant_block.getDefaultState(), 0).setHardness(1.0F).setLightLevel(0.6F).setStepSound(Block.soundTypePiston).setUnlocalizedName("radiant_quartz_stairs");
		deepstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()), 0).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deepstone_stairs");
		coldstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.COLDSTONE.getMetadata()), 0).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("coldstone_stairs");
		redrock_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.REDROCK.getMetadata()), 0).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("redrock_stairs");
		oceanstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.OCEANSTONE.getMetadata()), 0).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("oceanstone_stairs");
		icestone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.ICESTONE.getMetadata()), 0).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("icestone_stairs");
		poceanstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()), 0).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("poceanstone_stairs");
		glacierstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()), 0).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("glacierstone_stairs");
		deep_redrock_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()), 0).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deep_redrock_stairs");
		deep_coldstone_stairs = new MBlockStairs(biome_cobble.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()), 0).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deep_coldstone_stairs");
		deepstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deepstone_brick_stairs");
		coldstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.COLDSTONE.getMetadata()), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("coldstone_brick_stairs");
		redrock_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.REDROCK.getMetadata()), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("redrock_brick_stairs");
		oceanstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.OCEANSTONE.getMetadata()), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("oceanstone_brick_stairs");
		icestone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.ICESTONE.getMetadata()), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("icestone_brick_stairs");
		poceanstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("poceanstone_brick_stairs");
		glacierstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("glacierstone_brick_stairs");
		deep_redrock_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deep_redrock_brick_stairs");
		deep_coldstone_brick_stairs = new MBlockStairs(biome_bricks.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("deep_coldstone_brick_stairs");
		
		// Fence
		redwood_fence = new BlockFence(Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("redwood_fence");
		redwood_fence_gate = new BlockFenceGate().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("redwood_fence_gate");
		frozen_oak_fence = new BlockFence(Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("frozen_oak_fence");
		frozen_oak_fence_gate = new BlockFenceGate().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("frozen_oak_fence_gate");
		
		// Pane
		refined_glass_pane = new BlockMPane(Material.glass, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("refined_pane");
		bricked_glass_pane = new BlockMPane(Material.glass, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("bricked_pane");
		tiled_glass_pane = new BlockMPane(Material.glass, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("tiled_pane");
		framed_glass_pane = new BlockMPane(Material.iron, true).setHardness(3.0F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("framed_pane");
		steel_mesh = new BlockMPane(Material.iron, true).setHardness(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("steel_mesh");
		
		// Misc
		invincium = new BlockInvincium(Material.rock).setUnlocalizedName("invincium").setBlockUnbreakable().setHardness(50000F).setCreativeTab(Minestrappolation.tabMBuilding);
		
		//Wood Slabs
		redwood_slab = new BlockMSlab(Material.wood, "redwood_slab", 2F, 5F, "axe", 0, 300);
		redwood_double_slab = new BlockMDoubleSlab(Material.wood, "redwood_double_slab", 2F, 5F, "axe", 0, 300);
		frozen_oak_slab = new BlockMSlab(Material.wood, "frozen_oak_slab", 2F, 5F, "axe", 0, 300);
		frozen_oak_double_slab = new BlockMDoubleSlab(Material.wood, "frozen_oak_double_slab", 2F, 5F, "axe", 0, 300);
		
		//Stone Slabs
		desert_quartz_slab = new BlockMSlab(Material.rock, "desert_quartz_slab", 1F, 4F, "pickaxe", 1, 0);
		desert_quartz_double_slab = new BlockMDoubleSlab(Material.rock, "desert_quartz_double_slab", 1F, 4F, "pickaxe", 0, 0);
		radiant_slab = new BlockMSlab(Material.rock, "radiant_quartz_slab", 1F, 4F, "pickaxe", 1, 0);
		radiant_double_slab = new BlockMDoubleSlab(Material.rock, "radiant_quartz_double_slab", 1F, 4F, "pickaxe", 0, 0);
		
		deepstone_slab = new BlockMSlab(Material.rock, "deepstone_slab", 2F, 10F, "pickaxe", 2, 0);
		deepstone_double_slab = new BlockMDoubleSlab(Material.rock, "deepstone_double_slab", 2F, 10F, "pickaxe", 2, 0);
		red_rock_slab = new BlockMSlab(Material.rock, "red_rock_slab", 2F, 10F, "pickaxe", 0, 0);
		red_rock_double_slab = new BlockMDoubleSlab(Material.rock, "red_rock_double_slab", 2F, 10F, "pickaxe", 0, 0);
		deep_red_rock_slab = new BlockMSlab(Material.rock, "deep_red_rock_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_red_rock_double_slab = new BlockMDoubleSlab(Material.rock, "deep_red_rock_double_slab", 2F, 10F, "pickaxe", 2, 0);
		coldstone_slab = new BlockMSlab(Material.rock, "coldstone_slab", 2F, 10F, "pickaxe", 0, 0);
		coldstone_double_slab = new BlockMDoubleSlab(Material.rock, "coldstone_double_slab", 2F, 10F, "pickaxe", 0, 0);
		deep_coldstone_slab = new BlockMSlab(Material.rock, "deep_coldstone_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_coldstone_double_slab = new BlockMDoubleSlab(Material.rock, "deep_coldstone_double_slab", 2F, 10F, "pickaxe", 2, 0);
		icestone_slab = new BlockMSlab(Material.rock, "icestone_slab", 2F, 10F, "pickaxe", 0, 0);
		icestone_double_slab = new BlockMDoubleSlab(Material.rock, "icestone_double_slab", 2F, 10F, "pickaxe", 0, 0);
		glacierrock_slab = new BlockMSlab(Material.rock, "glacierrock_slab", 2F, 10F, "pickaxe", 2, 0);
		glacierrock_double_slab = new BlockMDoubleSlab(Material.rock, "glacierrock_double_slab", 2F, 10F, "pickaxe", 2, 0);
		oceanstone_slab = new BlockMSlab(Material.rock, "oceanstone_slab", 2F, 10F, "pickaxe", 0, 0);
		oceanstone_double_slab = new BlockMDoubleSlab(Material.rock, "oceanstone_double_slab", 2F, 10F, "pickaxe", 0, 0);
		poceanstone_slab = new BlockMSlab(Material.rock, "poceanstone_slab", 2F, 10F, "pickaxe", 2, 0);
		poceanstone_double_slab = new BlockMDoubleSlab(Material.rock, "poceanstone_double_slab", 2F, 10F, "pickaxe", 2, 0);
		
		deepstone_cobble_slab = new BlockMSlab(Material.rock, "deepstone_cobble_slab", 2F, 10F, "pickaxe", 2, 0);
		deepstone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "deepstone_cobble_double_slab", 2F, 10F, "pickaxe", 2, 0);
		red_rock_cobble_slab = new BlockMSlab(Material.rock, "red_rock_cobble_slab", 2F, 10F, "pickaxe", 0, 0);
		red_rock_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "red_rock_cobble_double_slab", 2F, 10F, "pickaxe", 0, 0);
		deep_red_rock_cobble_slab = new BlockMSlab(Material.rock, "deep_red_rock_cobble_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_red_rock_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "deep_red_rock_cobble_double_slab", 2F, 10F, "pickaxe", 2, 0);
		coldstone_cobble_slab = new BlockMSlab(Material.rock, "coldstone_cobble_slab", 2F, 10F, "pickaxe", 0, 0);
		coldstone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "coldstone_cobble_double_slab", 2F, 10F, "pickaxe", 0, 0);
		deep_coldstone_cobble_slab = new BlockMSlab(Material.rock, "deep_coldstone_cobble_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_coldstone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "deep_coldstone_cobble_double_slab", 2F, 10F, "pickaxe", 2, 0);
		icestone_cobble_slab = new BlockMSlab(Material.rock, "icestone_cobble_slab", 2F, 10F, "pickaxe", 0, 0);
		icestone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "icestone_cobble_double_slab", 2F, 10F, "pickaxe", 0, 0);
		glacierrock_cobble_slab = new BlockMSlab(Material.rock, "glacierrock_cobble_slab", 2F, 10F, "pickaxe", 2, 0);
		glacierrock_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "glacierrock_cobble_double_slab", 2F, 10F, "pickaxe", 2, 0);
		oceanstone_cobble_slab = new BlockMSlab(Material.rock, "oceanstone_cobble_slab", 2F, 10F, "pickaxe", 0, 0);
		oceanstone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "oceanstone_cobble_double_slab", 2F, 10F, "pickaxe", 0, 0);
		poceanstone_cobble_slab = new BlockMSlab(Material.rock, "poceanstone_cobble_slab", 2F, 10F, "pickaxe", 2, 0);
		poceanstone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "poceanstone_cobble_double_slab", 2F, 10F, "pickaxe", 2, 0);
		
		deepstone_brick_slab = new BlockMSlab(Material.rock, "deepstone_brick_slab", 2F, 10F, "pickaxe", 2, 0);
		deepstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "deepstone_brick_double_slab", 2F, 10F, "pickaxe", 2, 0);
		red_rock_brick_slab = new BlockMSlab(Material.rock, "red_rock_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		red_rock_brick_double_slab = new BlockMDoubleSlab(Material.rock, "red_rock_brick_double_slab", 2F, 10F, "pickaxe", 0, 0);
		deep_red_rock_brick_slab = new BlockMSlab(Material.rock, "deep_red_rock_brick_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_red_rock_brick_double_slab = new BlockMDoubleSlab(Material.rock, "deep_red_rock_brick_double_slab", 2F, 10F, "pickaxe", 2, 0);
		coldstone_brick_slab = new BlockMSlab(Material.rock, "coldstone_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		coldstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "coldstone_brick_double_slab", 2F, 10F, "pickaxe", 0, 0);
		deep_coldstone_brick_slab = new BlockMSlab(Material.rock, "deep_coldstone_brick_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_coldstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "deep_coldstone_brick_double_slab", 2F, 10F, "pickaxe", 2, 0);
		icestone_brick_slab = new BlockMSlab(Material.rock, "icestone_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		icestone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "icestone_brick_double_slab", 2F, 10F, "pickaxe", 0, 0);
		glacierrock_brick_slab = new BlockMSlab(Material.rock, "glacierrock_brick_slab", 2F, 10F, "pickaxe", 2, 0);
		glacierrock_brick_double_slab = new BlockMDoubleSlab(Material.rock, "glacierrock_brick_double_slab", 2F, 10F, "pickaxe", 2, 0);
		oceanstone_brick_slab = new BlockMSlab(Material.rock, "oceanstone_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		oceanstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "oceanstone_brick_double_slab", 2F, 10F, "pickaxe", 0, 0);
		poceanstone_brick_slab = new BlockMSlab(Material.rock, "poceanstone_brick_slab", 2F, 10F, "pickaxe", 2, 0);
		poceanstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "poceanstone_brick_double_slab", 2F, 10F, "pickaxe", 2, 0);
		
		//Pillars
		desert_pillar = new MBlockPillar(Material.rock, MapColor.adobeColor).setUnlocalizedName("desert_pillar").setHardness(1F).setResistance(4F);
		radiant_pillar = new MBlockPillar(Material.rock, MapColor.pinkColor).setLightLevel(0.6F).setUnlocalizedName("radiant_pillar").setHardness(1F).setResistance(4F);
		
		// BLOCK ITEMS
		redwood_door_item = new ItemMDoor(redwood_door).setUnlocalizedName("redwood_door_item");
		frozen_door_item = new ItemMDoor(frozen_door).setUnlocalizedName("frozen_oak_door_item");
		
		Blocks.bedrock.setHardness(70F);
		
		register();
		registerHarvestLevels();
	}
	
	private static void register()
	{
		register(dirt_permafrost);
		register(lichen_permafrost, ItemBlockPermaFrost.class);
		register(cold_sand, ItemBlockColdSand.class);
		
		register(snow_bricks);
		register(snow_refined);
		register(snow_tiles);
		register(glass_bricks);
		register(glass_refined);
		register(glass_tiles);
		register(glass_window);
		
		register(ministrapp_log, ItemBlockLog.class);
		register(ministrapp_planks, ItemBlockPlanks.class);
		registerSlab("redwood_slab", "redwood_double_slab", redwood_slab, redwood_double_slab);
		registerSlab("frozen_oak_slab", "frozen_oak_double_slab", frozen_oak_slab, frozen_oak_double_slab);
		register(redwood_stairs);
		register(frozen_oak_stairs);
		
		register(slate);
		register(slate_bricks);
		register(slate_pattern_bricks);
		register(slate_refined);
		register(granite_bricks);
		register(granite_pattern_bricks);
		register(diorite_bricks);
		register(diorite_pattern_bricks);
		register(andesite_bricks);
		register(andesite_pattern_bricks);
		register(flint_block);
		register(flint_bricks);
		register(flint_pattern_bricks);
		register(flint_refined);
		register(flint_tiles);
		register(flint_chiseled);
		register(flint_lamp_sunstone);
		register(flint_lamp_glowstone);
		register(flint_lamp_prismarine);
		register(desert_quartz_block);
		register(desert_quartz_chiseled);
		register(desert_quartz_stairs);
		registerSlab("desert_quartz_slab", "desert_quartz_double_slab", desert_quartz_slab, desert_quartz_double_slab);
		register(radiant_block);
		register(radiant_chiseled);
		registerSlab("radiant_quartz_slab", "radiant_quartz_double_slab", radiant_slab, radiant_double_slab);
		register(radiant_stairs);
		register(stone_pattern_bricks);
		register(stone_refined);
		register(stone_tiles);
		register(stone_lamp_sunstone);
		register(stone_lamp_glowstone);
		register(stone_lamp_prismarine);
		register(roads, ItemBlockRoads.class);
		register(biome_stones, ItemBlockBiomeStones.class);
		register(biome_cobble, ItemBlockBiomeCobble.class);
		register(biome_bricks, ItemBlockBiomeBricks.class);
		register(chiseled, ItemBlockChiseled.class);
		register(mossy, ItemBlockMossyCobble.class);
		register(mossy_bricks, ItemBlockMossyBricks.class);
		register(cracked_bricks, ItemBlockCrackedBricks.class);
		register(pattern_bricks, ItemBlockPatternBricks.class);
		register(refined, ItemBlockRefined.class);
		register(tiles, ItemBlockTiles.class);
		register(lamp_sunstone, ItemBlockLampSunstone.class);
		register(lamp_glowstone, ItemBlockLampGlowstone.class);
		register(lamp_prismarine, ItemBlockLampPrismarine.class);
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
		register(red_rock_boulder);
		register(coldstone_boulder);
		register(icestone_boulder);
		register(oceanstone_boulder);
		
		register(desert_quartz);
		register(biome_coal, ItemBlockBiomeCoal.class);
		register(copper_ore);
		register(biome_copper, ItemBlockBiomeCopper.class);
		register(tin_ore);
		register(biome_tin, ItemBlockBiomeTin.class);
		register(biome_iron, ItemBlockBiomeIron.class);
		register(biome_gold, ItemBlockBiomeGold.class);
		register(meurodite_ore);
		register(biome_meurodite, ItemBlockBiomeMeurodite.class);
		register(torite_ore);
		register(biome_torite, ItemBlockBiomeTorite.class);
		register(biome_lapis, ItemBlockBiomeLapis.class);
		register(biome_redstone, ItemBlockBiomeRedstone.class);
		register(sunstone_ore);
		register(biome_sunstone, ItemBlockBiomeSunstone.class);
		register(plutonium_ore);
		register(biome_plutonium, ItemBlockBiomePlutonium.class);
		register(uranium_ore);
		register(biome_uranium, ItemBlockBiomeUranium.class);
		register(radiant_ore);
		register(biome_radiant, ItemBlockBiomeRadiant.class);
		register(biome_emerald, ItemBlockBiomeEmerald.class);
		register(biome_diamond, ItemBlockBiomeDiamond.class);
		register(titanium_ore);
		register(biome_titanium, ItemBlockBiomeTitanium.class);
		register(blazium_ore);
		register(soul_ore);
		register(invincium);
		
		register(ministrapp_sapling, ItemBlockSapling.class);
		register(ministrapp_leaves, ItemBlockLeaves.class);
		register(dead_branch);
		register(redwood_fence);
		register(frozen_oak_fence);
		register(refined_glass_pane);
		register(bricked_glass_pane);
		register(tiled_glass_pane);
		register(framed_glass_pane);
		register(steel_mesh);
		register(redwood_fence_gate);
		register(frozen_oak_fence_gate);
		register(redwood_door);
		register(frozen_door);
		GameRegistry.registerItem(redwood_door_item, redwood_door_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frozen_door_item, frozen_door_item.getUnlocalizedName().substring(5));
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
		
		register(desert_pillar);
		register(radiant_pillar);
		
		register(meat_block);
		
		registerSlab("deepstone_slab", "deepstone_double_slab", deepstone_slab, deepstone_double_slab);
		registerSlab("red_rock_slab", "red_rock_double_slab", red_rock_slab, red_rock_double_slab);
		registerSlab("deep_red_rock_slab", "deep_red_rock_double_slab", deep_red_rock_slab, deep_red_rock_double_slab);
		registerSlab("coldstone_slab", "coldstone_double_slab", coldstone_slab, coldstone_double_slab);
		registerSlab("deep_coldstone_slab", "deep_coldstone_double_slab", deep_coldstone_slab, deep_coldstone_double_slab);
		registerSlab("icestone_slab", "icestone_double_slab", icestone_slab, icestone_double_slab);
		registerSlab("glacierrock_slab", "glacierrock_double_slab", glacierrock_slab, glacierrock_double_slab);
		registerSlab("oceanstone_slab", "oceanstone_double_slab", oceanstone_slab, oceanstone_double_slab);
		registerSlab("poceanstone_slab", "poceanstone_double_slab", poceanstone_slab, poceanstone_double_slab);
		
		registerSlab("deepstone_cobble_slab", "deepstone_cobble_double_slab", deepstone_cobble_slab, deepstone_cobble_double_slab);
		registerSlab("red_rock_cobble_slab", "red_rock_cobble_double_slab", red_rock_cobble_slab, red_rock_cobble_double_slab);
		registerSlab("deep_red_rock_cobble_slab", "deep_red_rock_cobble_double_slab", deep_red_rock_cobble_slab, deep_red_rock_cobble_double_slab);
		registerSlab("coldstone_cobble_slab", "coldstone_cobble_double_slab", coldstone_cobble_slab, coldstone_cobble_double_slab);
		registerSlab("deep_coldstone_cobble_slab", "deep_coldstone_cobble_double_slab", deep_coldstone_cobble_slab, deep_coldstone_cobble_double_slab);
		registerSlab("icestone_cobble_slab", "icestone_cobble_double_slab", icestone_cobble_slab, icestone_cobble_double_slab);
		registerSlab("glacierrock_cobble_slab", "glacierrock_cobble_double_slab", glacierrock_cobble_slab, glacierrock_cobble_double_slab);
		registerSlab("oceanstone_cobble_slab", "oceanstone_cobble_double_slab", oceanstone_cobble_slab, oceanstone_cobble_double_slab);
		registerSlab("poceanstone_cobble_slab", "poceanstone_cobble_double_slab", poceanstone_cobble_slab, poceanstone_cobble_double_slab);
		
		registerSlab("deepstone_brick_slab", "deepstone_brick_double_slab", deepstone_brick_slab, deepstone_brick_double_slab);
		registerSlab("red_rock_brick_slab", "red_rock_brick_double_slab", red_rock_brick_slab, red_rock_brick_double_slab);
		registerSlab("deep_red_rock_brick_slab", "deep_red_rock_brick_double_slab", deep_red_rock_brick_slab, deep_red_rock_brick_double_slab);
		registerSlab("coldstone_brick_slab", "coldstone_brick_double_slab", coldstone_brick_slab, coldstone_brick_double_slab);
		registerSlab("deep_coldstone_brick_slab", "deep_coldstone_brick_double_slab", deep_coldstone_brick_slab, deep_coldstone_brick_double_slab);
		registerSlab("icestone_brick_slab", "icestone_brick_double_slab", icestone_brick_slab, icestone_brick_double_slab);
		registerSlab("glacierrock_brick_slab", "glacierrock_brick_double_slab", glacierrock_brick_slab, glacierrock_brick_double_slab);
		registerSlab("oceanstone_brick_slab", "oceanstone_brick_double_slab", oceanstone_brick_slab, oceanstone_brick_double_slab);
		registerSlab("poceanstone_brick_slab", "poceanstone_brick_double_slab", poceanstone_brick_slab, poceanstone_brick_double_slab);
	}
	
	public static void registerRenders()
	{
		for(Block block: blockList)
		{
			registerRender(block);
		}
		registerRender(redwood_door_item);
		registerRender(frozen_door_item);
	}
	
	private static void register(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
		blockList.add(block);
	}
	
	private static void register(Block block, Class<? extends ItemBlock> itemclass)
	{
		GameRegistry.registerBlock(block, itemclass, block.getUnlocalizedName().substring(5));
		blockList.add(block);
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
		slate_bricks.setHarvestLevel("pickaxe", 0);
		slate_pattern_bricks.setHarvestLevel("pickaxe", 0);
		granite_bricks.setHarvestLevel("pickaxe", 0);
		granite_pattern_bricks.setHarvestLevel("pickaxe", 0);
		diorite_bricks.setHarvestLevel("pickaxe", 0);
		diorite_pattern_bricks.setHarvestLevel("pickaxe", 0);
		andesite_bricks.setHarvestLevel("pickaxe", 0);
		andesite_pattern_bricks.setHarvestLevel("pickaxe", 0);
		slate_refined.setHarvestLevel("pickaxe", 0);
		flint_block.setHarvestLevel("pickaxe", 0);
		flint_bricks.setHarvestLevel("pickaxe", 0);
		flint_pattern_bricks.setHarvestLevel("pickaxe", 0);
		flint_refined.setHarvestLevel("pickaxe", 0);
		flint_tiles.setHarvestLevel("pickaxe", 0);
		flint_chiseled.setHarvestLevel("pickaxe", 0);
		flint_lamp_sunstone.setHarvestLevel("pickaxe", 0);
		flint_lamp_glowstone.setHarvestLevel("pickaxe", 0);
		flint_lamp_prismarine.setHarvestLevel("pickaxe", 0);
		desert_quartz_block.setHarvestLevel("pickaxe", 0);
		desert_quartz_chiseled.setHarvestLevel("pickaxe", 0);
		desert_quartz_stairs.setHarvestLevel("pickaxe", 0);
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
		framed_glass_pane.setHarvestLevel("pickaxe", 0);
		steel_mesh.setHarvestLevel("pickaxe", 0);
		stone_boulder.setHarvestLevel("pickaxe", 2);
		red_rock_boulder.setHarvestLevel("pickaxe", 2);
		coldstone_boulder.setHarvestLevel("pickaxe", 2);
		icestone_boulder.setHarvestLevel("pickaxe", 2);
		oceanstone_boulder.setHarvestLevel("pickaxe", 2);
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
		
		Blocks.bedrock.setHarvestLevel("pickaxe", 4);
		
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
		
		// Chiseled
		chiseled.setHarvestLevel("pickaxe", 2, chiseled.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		chiseled.setHarvestLevel("pickaxe", 2, chiseled.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		chiseled.setHarvestLevel("pickaxe", 2, chiseled.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		chiseled.setHarvestLevel("pickaxe", 2, chiseled.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		chiseled.setHarvestLevel("pickaxe", 2, chiseled.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
				
		// Mossy Cobble
		mossy.setHarvestLevel("pickaxe", 2, mossy.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		mossy.setHarvestLevel("pickaxe", 2, mossy.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		mossy.setHarvestLevel("pickaxe", 2, mossy.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		mossy.setHarvestLevel("pickaxe", 2, mossy.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		mossy.setHarvestLevel("pickaxe", 2, mossy.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Mossy Bricks
		mossy_bricks.setHarvestLevel("pickaxe", 2, mossy_bricks.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		mossy_bricks.setHarvestLevel("pickaxe", 2, mossy_bricks.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		mossy_bricks.setHarvestLevel("pickaxe", 2, mossy_bricks.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		mossy_bricks.setHarvestLevel("pickaxe", 2, mossy_bricks.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		mossy_bricks.setHarvestLevel("pickaxe", 2, mossy_bricks.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Cracked Bricks
		cracked_bricks.setHarvestLevel("pickaxe", 2, cracked_bricks.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		cracked_bricks.setHarvestLevel("pickaxe", 2, cracked_bricks.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		cracked_bricks.setHarvestLevel("pickaxe", 2, cracked_bricks.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		cracked_bricks.setHarvestLevel("pickaxe", 2, cracked_bricks.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		cracked_bricks.setHarvestLevel("pickaxe", 2, cracked_bricks.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Refined
		refined.setHarvestLevel("pickaxe", 2, refined.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		refined.setHarvestLevel("pickaxe", 2, refined.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		refined.setHarvestLevel("pickaxe", 2, refined.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		refined.setHarvestLevel("pickaxe", 2, refined.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		refined.setHarvestLevel("pickaxe", 2, refined.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Tiles
		tiles.setHarvestLevel("pickaxe", 2, tiles.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		tiles.setHarvestLevel("pickaxe", 2, tiles.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		tiles.setHarvestLevel("pickaxe", 2, tiles.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		tiles.setHarvestLevel("pickaxe", 2, tiles.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		tiles.setHarvestLevel("pickaxe", 2, tiles.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Sunstone Lamp
		lamp_sunstone.setHarvestLevel("pickaxe", 2, lamp_sunstone.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		lamp_sunstone.setHarvestLevel("pickaxe", 2, lamp_sunstone.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		lamp_sunstone.setHarvestLevel("pickaxe", 2, lamp_sunstone.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		lamp_sunstone.setHarvestLevel("pickaxe", 2, lamp_sunstone.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		lamp_sunstone.setHarvestLevel("pickaxe", 2, lamp_sunstone.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Glowstone Lamp
		lamp_glowstone.setHarvestLevel("pickaxe", 2, lamp_glowstone.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		lamp_glowstone.setHarvestLevel("pickaxe", 2, lamp_glowstone.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		lamp_glowstone.setHarvestLevel("pickaxe", 2, lamp_glowstone.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		lamp_glowstone.setHarvestLevel("pickaxe", 2, lamp_glowstone.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		lamp_glowstone.setHarvestLevel("pickaxe", 2, lamp_glowstone.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
		
		// Prismarine Lamp
		lamp_prismarine.setHarvestLevel("pickaxe", 2, lamp_prismarine.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()));
		lamp_prismarine.setHarvestLevel("pickaxe", 2, lamp_prismarine.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata()));
		lamp_prismarine.setHarvestLevel("pickaxe", 2, lamp_prismarine.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata()));
		lamp_prismarine.setHarvestLevel("pickaxe", 2, lamp_prismarine.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata()));
		lamp_prismarine.setHarvestLevel("pickaxe", 2, lamp_prismarine.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata()));
	}
	
	public static void registerSlab(String name, String name2, BlockMSlab one, BlockMDoubleSlab two)
	{
		GameRegistry.registerBlock(two, ItemBlockMSlab.class, name2, new Object[]{one, two});
		GameRegistry.registerBlock(one, ItemBlockMSlab.class, name, new Object[]{one, two});
		blockList.add(one);
		blockList.add(two);
	}
}
