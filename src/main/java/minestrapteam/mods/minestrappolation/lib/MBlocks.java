package minestrapteam.mods.minestrappolation.lib;

import java.util.ArrayList;

import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.block.BlockBat;
import minestrapteam.mods.minestrappolation.block.BlockBiomeBricks;
import minestrapteam.mods.minestrappolation.block.BlockBlazium;
import minestrapteam.mods.minestrappolation.block.BlockBoulder;
import minestrapteam.mods.minestrappolation.block.BlockBush;
import minestrapteam.mods.minestrappolation.block.BlockCardboard;
import minestrapteam.mods.minestrappolation.block.BlockCarvedPumpkin;
import minestrapteam.mods.minestrappolation.block.BlockChicken;
import minestrapteam.mods.minestrappolation.block.BlockChimney;
import minestrapteam.mods.minestrappolation.block.BlockChiseled;
import minestrapteam.mods.minestrappolation.block.BlockClaimerator;
import minestrapteam.mods.minestrappolation.block.BlockColdCobweb;
import minestrapteam.mods.minestrappolation.block.BlockCow;
import minestrapteam.mods.minestrappolation.block.BlockCrackedBricks;
import minestrapteam.mods.minestrappolation.block.BlockDeadBranch;
import minestrapteam.mods.minestrappolation.block.BlockFan;
import minestrapteam.mods.minestrappolation.block.BlockFlesh;
import minestrapteam.mods.minestrappolation.block.BlockGlacialInvincium;
import minestrapteam.mods.minestrappolation.block.BlockGlaciericIce;
import minestrapteam.mods.minestrappolation.block.BlockGlacierite;
import minestrapteam.mods.minestrappolation.block.BlockGodstone;
import minestrapteam.mods.minestrappolation.block.BlockHangingMoss;
import minestrapteam.mods.minestrappolation.block.BlockIceDeposit;
import minestrapteam.mods.minestrappolation.block.BlockInvincium;
import minestrapteam.mods.minestrappolation.block.BlockLamp;
import minestrapteam.mods.minestrappolation.block.BlockMDoor;
import minestrapteam.mods.minestrappolation.block.BlockMDoubleSlab;
import minestrapteam.mods.minestrappolation.block.BlockMFalling;
import minestrapteam.mods.minestrappolation.block.BlockMMelon;
import minestrapteam.mods.minestrappolation.block.BlockMPane;
import minestrapteam.mods.minestrappolation.block.BlockMSand;
import minestrapteam.mods.minestrappolation.block.BlockMSlab;
import minestrapteam.mods.minestrappolation.block.BlockMStorage;
import minestrapteam.mods.minestrappolation.block.BlockMagma;
import minestrapteam.mods.minestrappolation.block.BlockMagneticTorch;
import minestrapteam.mods.minestrappolation.block.BlockMooshroom;
import minestrapteam.mods.minestrappolation.block.BlockMoss;
import minestrapteam.mods.minestrappolation.block.BlockMossyBricks;
import minestrapteam.mods.minestrappolation.block.BlockMossyCobble;
import minestrapteam.mods.minestrappolation.block.BlockMud;
import minestrapteam.mods.minestrappolation.block.BlockPatternBricks;
import minestrapteam.mods.minestrappolation.block.BlockPermaFrost;
import minestrapteam.mods.minestrappolation.block.BlockPermaFrostDirt;
import minestrapteam.mods.minestrappolation.block.BlockRabbit;
import minestrapteam.mods.minestrappolation.block.BlockRadationMineral;
import minestrapteam.mods.minestrappolation.block.BlockRadiationInsulated;
import minestrapteam.mods.minestrappolation.block.BlockReactiveFlesh;
import minestrapteam.mods.minestrappolation.block.BlockRefined;
import minestrapteam.mods.minestrappolation.block.BlockRoads;
import minestrapteam.mods.minestrappolation.block.BlockRope;
import minestrapteam.mods.minestrappolation.block.BlockSawmill;
import minestrapteam.mods.minestrappolation.block.BlockSeaweed;
import minestrapteam.mods.minestrappolation.block.BlockSheep;
import minestrapteam.mods.minestrappolation.block.BlockShrubGrass;
import minestrapteam.mods.minestrappolation.block.BlockSoul;
import minestrapteam.mods.minestrappolation.block.BlockSunstoneBlock;
import minestrapteam.mods.minestrappolation.block.BlockTiles;
import minestrapteam.mods.minestrappolation.block.BlockTranslucent;
import minestrapteam.mods.minestrappolation.block.BlockTransparent;
import minestrapteam.mods.minestrappolation.block.BlockWetCardboard;
import minestrapteam.mods.minestrappolation.block.BlockWolf;
import minestrapteam.mods.minestrappolation.block.MBlock;
import minestrapteam.mods.minestrappolation.block.MBlockLeaves;
import minestrapteam.mods.minestrappolation.block.MBlockLog;
import minestrapteam.mods.minestrappolation.block.MBlockPillar;
import minestrapteam.mods.minestrappolation.block.MBlockPlanks;
import minestrapteam.mods.minestrappolation.block.MBlockSapling;
import minestrapteam.mods.minestrappolation.block.MBlockSketchyBackwaterFlowerpot;
import minestrapteam.mods.minestrappolation.block.MBlockSnow;
import minestrapteam.mods.minestrappolation.block.MBlockStairs;
import minestrapteam.mods.minestrappolation.block.MBlockWall;
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
import minestrapteam.mods.minestrappolation.block.crops.BlockCabbage;
import minestrapteam.mods.minestrappolation.block.crops.BlockCelery;
import minestrapteam.mods.minestrappolation.block.crops.BlockLettuce;
import minestrapteam.mods.minestrappolation.block.crops.BlockOnion;
import minestrapteam.mods.minestrappolation.block.crops.BlockPeanuts;
import minestrapteam.mods.minestrappolation.block.crops.BlockPepper;
import minestrapteam.mods.minestrappolation.block.crops.BlockRice;
import minestrapteam.mods.minestrappolation.block.machines.BlockAlloy;
import minestrapteam.mods.minestrappolation.block.machines.BlockBarrel;
import minestrapteam.mods.minestrappolation.block.machines.BlockCrate;
import minestrapteam.mods.minestrappolation.block.machines.BlockCrusher;
import minestrapteam.mods.minestrappolation.block.machines.BlockFrostGenerator;
import minestrapteam.mods.minestrappolation.block.machines.BlockMelter;
import minestrapteam.mods.minestrappolation.block.machines.BlockSplitter;
import minestrapteam.mods.minestrappolation.block.machines.BlockStoneCutter;
import minestrapteam.mods.minestrappolation.block.ore.BlockPlutoniumOre;
import minestrapteam.mods.minestrappolation.block.ore.BlockSoulOre;
import minestrapteam.mods.minestrappolation.block.ore.BlockUraniumOre;
import minestrapteam.mods.minestrappolation.block.ore.MBlockOre;
import minestrapteam.mods.minestrappolation.enumtypes.MRoadType;
import minestrapteam.mods.minestrappolation.enumtypes.MStoneType;
import minestrapteam.mods.minestrappolation.enumtypes.MWoodType;
import minestrapteam.mods.minestrappolation.item.ItemMDoor;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeCoal;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeCobble;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeCopper;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeDiamond;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeEmerald;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeGold;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeIron;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeLapis;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeMeurodite;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomePlutonium;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeRadiant;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeRedstone;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeStones;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeSunstone;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeTin;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeTitanium;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeTorite;
import minestrapteam.mods.minestrappolation.item.biomeitems.ItemBlockBiomeUranium;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockBiomeBricks;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockCarvedPumpkin;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockChiseled;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockColdSand;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockCrackedBricks;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockLampGlowstone;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockLampPrismarine;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockLampSunstone;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockLeaves;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockLog;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockMSlab;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockMossyBricks;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockMossyCobble;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockPatternBricks;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockPermaFrost;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockPlanks;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockRefined;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockRoads;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockSapling;
import minestrapteam.mods.minestrappolation.item.blocks.ItemBlockTiles;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MBlocks
{
	public static ArrayList<Block> blockList = new ArrayList<Block>();
	
	//Soil
	public static Block	cold_sand;
	public static Block	lichen_permafrost;
	public static Block	dirt_permafrost;
	public static Block mud;
	public static Block rubble;
	
	//Plants
	public static Block	ministrapp_leaves;
	public static Block	ministrapp_sapling;
	public static Block dead_branch;
	public static Block shrub_grass;
	public static Block moss;
	public static Block hanging_moss;
	public static Block hanging_glow_moss;
	public static Block blueberry_bush;
	public static Block blackberry_bush;
	public static Block strawberry_bush;
	public static Block raspberry_bush;
	public static Block mana_bush;
	public static Block seaweed;
	public static Block rice_crop;
	public static Item	rice;
	public static Block pepper_crop;
	public static Item	pepper_seed;
	public static Block peanut_crop;
	public static Item	peanuts;
	public static Block cabbage_crop;
	public static Item	cabbage;
	public static Block onion_crop;
	public static Item	onion;
	public static Block lettuce_crop;
	public static Item	lettuce;
	public static Block celery_crop;
	public static Item	celery_seed;
	
	public static Block pumpkin_carved;
	
	//Food Blocks
	public static Block	sugar_block;
	public static Block	meat_block;
	public static Block melon_bricks;
	
	//Mineral Blocks
	public static Block	copper_block;
	public static Block	tin_block;
	public static Block	bronze_block;
	public static Block	steel_block;
	public static Block	meurodite_block;
	public static Block	torite_block;
	public static Block	sunstone_block;
	public static Block	uranium_block;
	public static Block	plutonium_block;
	public static Block	titanium_block;
	public static Block glacierite_block;
	public static Block	blazium_block;
	public static Block	soul_gem_block;
	
	//Wood Blocks
	public static Block	ministrapp_log;
	public static Block	ministrapp_planks;	
	
	//Glass Decor Blocks
	public static Block	glass_bricks;
	public static Block	glass_refined;
	public static Block	glass_tiles;
	public static Block	glass_window;
	public static Block glow_glass;
	
	//Misc. Decor Blocks
	public static Block	snow_refined;
	public static Block	snow_bricks;
	public static Block	snow_tiles;
	public static Block mud_bricks;
	public static Block cardboard_block;
	public static Block wet_cardboard_block;
	public static Block	invincium;
	public static Block	glaical_invincium;
	
	//Misc. Stone Decor Blocks
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
	public static Block sandstone_bricks;
	public static Block sandstone_pattern_bricks;
	public static Block red_sandstone_bricks;
	public static Block red_sandstone_pattern_bricks;
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
	public static Block desert_pillar;
	public static Block	radiant_block;
	public static Block	radiant_chiseled;
	public static Block radiant_pillar;
	public static Block obsidian_bricks;
	public static Block glow_mossy_netherrack;
	public static Block glow_mossy_nether_bricks;
	public static Block glow_mossy_end_stone;
	
	//Biome Stone Decor Blocks
	public static Block	stone_lamp_glowstone;
	public static Block	stone_lamp_prismarine;
	public static Block	stone_lamp_sunstone;
	public static Block	stone_pattern_bricks;
	public static Block	stone_refined;
	public static Block	stone_tiles;
	public static Block	biome_stones;
	public static Block	biome_cobble;
	public static Block	biome_bricks;
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
	
	//Utility Decor Blocks
	public static Block magnetic_torch;
	public static Block	stone_boulder;
	public static Block	red_rock_boulder;
	public static Block	coldstone_boulder;
	public static Block	icestone_boulder;
	public static Block	oceanstone_boulder;
	public static Block ministrapp_flower_pot;
	public static Block	roads;
	public static Block fan;
	public static Block rope;
	public static Block chimney;
	public static Block cold_cobweb;
	public static Block glacieric_ice;
	public static Block	godstone;
	
	//Gene Blocks
	public static Block block_flesh;
	public static Block block_flesh_reactive;
	public static Block block_bat;
	public static Block block_rabbit;
	public static Block block_cow;
	public static Block block_mooshroom;
	public static Block block_chicken;
	public static Block block_wolf;
	public static Block block_sheep_white;
	public static Block block_sheep_silver;
	public static Block block_sheep_grey;
	public static Block block_sheep_black;
	public static Block block_sheep_brown;
	public static Block block_sheep_pink;
	public static Block block_sheep_red;
	public static Block block_sheep_orange;
	public static Block block_sheep_yellow;
	public static Block block_sheep_lime;
	public static Block block_sheep_green;
	public static Block block_sheep_cyan;
	public static Block block_sheep_light_blue;
	public static Block block_sheep_blue;
	public static Block block_sheep_purple;
	public static Block block_sheep_magenta;
	
	//Tech Blocks
	public static Block	crate;
	public static Block	barrel;
	public static Block	sawmill;
	public static Block	stonecutter;
	public static Block	plutonium_insulated;
	public static Block	uranium_insulated;
	public static Block	alloy;
	public static Block	alloy_active;
	public static Block	melter;
	public static Block	melter_active;
	public static Block	crusher;
	public static Block	crusher_active;
	public static Block splitter;
	public static Block splitter_active;
	public static Block	frost_generator;
	public static Block claimerator;
	
	//Fences and Panes
	public static Block cardboard;
	public static Block	redwood_fence;
	public static Block	redwood_fence_gate;
	public static Block	frozen_oak_fence;
	public static Block	frozen_oak_fence_gate;
	public static Block red_rock_wall;
	public static Block red_rock_wall_mossy;
	public static Block coldstone_wall;
	public static Block coldstone_wall_mossy;
	public static Block icestone_wall;
	public static Block icestone_wall_mossy;
	public static Block oceanstone_wall;
	public static Block oceanstone_wall_mossy;
	public static Block	refined_glass_pane;
	public static Block	bricked_glass_pane;
	public static Block	tiled_glass_pane;
	public static Block	framed_glass_pane;
	public static Block glow_glass_pane;
	public static Block	steel_mesh;
	
	//Doors
	public static Block	redwood_door;
	public static Block	frozen_door;
	public static Block glass_door;
	
	public static Item	redwood_door_item;
	public static Item  frozen_door_item;
	public static Item  glass_door_item;
	
	//Ores
	public static Block	desert_quartz;
	public static Block glacieric_ice_vein;
	public static Block	biome_coal;
	public static Block	copper_ore;
	public static Block	biome_copper;
	public static Block	tin_ore;
	public static Block	biome_tin;
	public static Block	biome_iron;
	public static Block	biome_gold;
	public static Block	meurodite_ore;
	public static Block	biome_meurodite;
	public static Block	torite_ore;
	public static Block	biome_torite;
	public static Block	biome_redstone;
	public static Block	biome_lapis;
	public static Block	sunstone_ore;
	public static Block	biome_sunstone;
	public static Block	plutonium_ore;
	public static Block	biome_plutonium;
	public static Block	uranium_ore;
	public static Block	biome_uranium;
	public static Block	radiant_ore;
	public static Block	biome_radiant;
	public static Block	biome_diamond;
	public static Block	biome_emerald;
	public static Block	titanium_ore;
	public static Block	biome_titanium;
	public static Block	blazium_ore;
	public static Block	soul_ore;
	
	// Stairs
	public static Block	redwood_stairs;
	public static Block	frozen_oak_stairs;
	public static Block andesite_brick_stairs;
	public static Block diorite_brick_stairs;
	public static Block granite_brick_stairs;
	public static Block slate_brick_stairs;
	public static Block sandstone_brick_stairs;
	public static Block red_sandstone_brick_stairs;
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
	public static Block prismarine_stairs;
	
	//Slabs
	public static BlockMSlab       redwood_slab;
	public static BlockMDoubleSlab redwood_double_slab;
	public static BlockMSlab       frozen_oak_slab;
	public static BlockMDoubleSlab frozen_oak_double_slab;
	public static BlockMSlab	   andesite_brick_slab;
	public static BlockMDoubleSlab andesite_brick_double_slab;
	public static BlockMSlab	   diorite_brick_slab;
	public static BlockMDoubleSlab diorite_brick_double_slab;
	public static BlockMSlab	   granite_brick_slab;
	public static BlockMDoubleSlab granite_brick_double_slab;
	public static BlockMSlab	   slate_brick_slab;
	public static BlockMDoubleSlab slate_brick_double_slab;
	public static BlockMSlab	   sandstone_brick_slab;
	public static BlockMDoubleSlab sandstone_brick_double_slab;
	public static BlockMSlab	   red_sandstone_brick_slab;
	public static BlockMDoubleSlab red_sandstone_brick_double_slab;
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
	public static BlockMSlab	   prismarine_slab;
	public static BlockMDoubleSlab prismarine_double_slab;
	
	//Fluid
	public static Block magma;
	public static Item	magmaBucket;
	
	public static void init()
	{
		//Soil Blocks
		cold_sand = new BlockMSand().setUnlocalizedName("cold_sand").setHardness(0.7F).setStepSound(Block.soundTypeSand).setCreativeTab(Minestrappolation.tabMBuilding);
		lichen_permafrost = new BlockPermaFrost().setUnlocalizedName("permafrost").setHardness(1F).setStepSound(Block.soundTypeGrass).setCreativeTab(Minestrappolation.tabMBuilding);
		dirt_permafrost = new BlockPermaFrostDirt(Material.ground, MapColor.cyanColor).setHardness(0.9F).setStepSound(Block.soundTypeGravel).setUnlocalizedName("dirt_permafrost").setCreativeTab(Minestrappolation.tabMBuilding);
		mud = new BlockMud(Material.ground, MapColor.brownColor).setHardness(0.5F).setStepSound(Block.SLIME_SOUND).setUnlocalizedName("mud").setCreativeTab(Minestrappolation.tabMBuilding);
		rubble = new BlockMFalling(Material.rock, MapColor.grayColor).setHardness(0.7F).setStepSound(Block.soundTypePiston).setUnlocalizedName("rubble").setCreativeTab(Minestrappolation.tabMBuilding);
		
		//Plants
		ministrapp_leaves = new MBlockLeaves(600).setUnlocalizedName("ministrapp_leaves");
		ministrapp_sapling = new MBlockSapling(600);
		dead_branch = new BlockDeadBranch(Material.vine, MapColor.woodColor).setStepSound(Block.soundTypeGrass).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("dead_branch");
		shrub_grass = new BlockShrubGrass().setStepSound(Block.soundTypeGrass).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("shrub_grass");
		moss = new BlockMoss(MapColor.greenColor).setHardness(0.3F).setStepSound(Block.soundTypeCloth).setUnlocalizedName("moss").setCreativeTab(Minestrappolation.tabMDecor);
		hanging_moss = new BlockHangingMoss(600).setStepSound(Block.soundTypeGrass).setUnlocalizedName("hanging_moss").setCreativeTab(Minestrappolation.tabMDecor);
		hanging_glow_moss = new BlockHangingMoss(0).setStepSound(Block.soundTypeGrass).setLightLevel(0.8F).setUnlocalizedName("hanging_glow_moss").setCreativeTab(Minestrappolation.tabMDecor);
		blueberry_bush = new BlockBush(Material.leaves, MItems.blueberry, MapColor.greenColor).setStepSound(Block.soundTypeGrass).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("blueberry_bush");
		blackberry_bush = new BlockBush(Material.leaves, MItems.blackberry, MapColor.greenColor).setStepSound(Block.soundTypeGrass).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("blackberry_bush");
		raspberry_bush = new BlockBush(Material.leaves, MItems.raspberry, MapColor.greenColor).setStepSound(Block.soundTypeGrass).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("raspberry_bush");
		strawberry_bush = new BlockBush(Material.leaves, MItems.strawberry, MapColor.greenColor).setStepSound(Block.soundTypeGrass).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("strawberry_bush");
		mana_bush = new BlockBush(Material.leaves, MItems.mana_leaf, MapColor.lightBlueColor).setStepSound(Block.soundTypeGrass).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("mana_bush");
		seaweed = new BlockSeaweed().setStepSound(Block.soundTypeGrass).setUnlocalizedName("seaweed").setCreativeTab(Minestrappolation.tabMDecor);
		rice_crop = new BlockRice().setUnlocalizedName("rice_crop");
		rice = new ItemSeeds(rice_crop, Blocks.farmland).setUnlocalizedName("rice").setCreativeTab(Minestrappolation.tabMFood);
		pepper_crop = new BlockPepper().setUnlocalizedName("pepper_crop");
		pepper_seed = new ItemSeeds(pepper_crop, Blocks.farmland).setUnlocalizedName("pepper_seeds").setCreativeTab(Minestrappolation.tabMFood);
		peanut_crop = new BlockPeanuts().setUnlocalizedName("peanut_crop");
		peanuts = new ItemSeedFood(1, 0.2F, peanut_crop, Blocks.farmland).setUnlocalizedName("peanuts").setCreativeTab(Minestrappolation.tabMFood);
		cabbage_crop = new BlockCabbage().setUnlocalizedName("cabbage_crop");
		cabbage = new ItemSeedFood(3, 0.1F, cabbage_crop, Blocks.farmland).setUnlocalizedName("cabbage").setCreativeTab(Minestrappolation.tabMFood);
		onion_crop = new BlockOnion().setUnlocalizedName("onion_crop");
		onion = new ItemSeedFood(2, 0.2F, onion_crop, Blocks.farmland).setPotionEffect(Potion.blindness.id, 10, 0, 0.1F).setUnlocalizedName("onion").setCreativeTab(Minestrappolation.tabMFood);
		lettuce_crop = new BlockLettuce().setUnlocalizedName("lettuce_crop");
		lettuce = new ItemSeedFood(1, 0F, lettuce_crop, Blocks.farmland).setUnlocalizedName("lettuce").setCreativeTab(Minestrappolation.tabMFood);
		celery_crop = new BlockCelery().setUnlocalizedName("celery_crop");
		celery_seed = new ItemSeeds(celery_crop, Blocks.farmland).setUnlocalizedName("celery_seeds").setCreativeTab(Minestrappolation.tabMFood);
		pumpkin_carved = new BlockCarvedPumpkin().setHardness(1F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMDecor);
		
		//Food Blocks
		sugar_block = new BlockMFalling(Material.sand, MapColor.snowColor).setHardness(0.5F).setStepSound(Block.soundTypeGravel).setUnlocalizedName("sugar_block").setCreativeTab(Minestrappolation.tabMBuilding);
		meat_block = new BlockMStorage(Material.clay, MapColor.pinkColor).setHardness(0.8F).setStepSound(Block.SLIME_SOUND).setUnlocalizedName("meat_block").setCreativeTab(Minestrappolation.tabMFood);
		melon_bricks = new BlockMMelon().setHardness(1.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMFood).setUnlocalizedName("melon_bricks");
		
		//Mineral Blocks
		copper_block = new MBlock(Material.iron, MapColor.adobeColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("copper_block").setCreativeTab(Minestrappolation.tabMBuilding);
		tin_block = new MBlock(Material.iron, MapColor.ironColor).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("tin_block").setCreativeTab(Minestrappolation.tabMBuilding);
		bronze_block = new MBlock(Material.iron, MapColor.goldColor).setHardness(5.0F).setResistance(20.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("bronze_block").setCreativeTab(Minestrappolation.tabMBuilding);
		steel_block = new MBlock(Material.iron, MapColor.clayColor).setHardness(7.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("steel_block").setCreativeTab(Minestrappolation.tabMBuilding);
		meurodite_block = new MBlock(Material.iron, MapColor.obsidianColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("meurodite_block").setCreativeTab(Minestrappolation.tabMBuilding);
		torite_block = new MBlock(Material.iron, MapColor.limeColor).setHardness(5.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("torite_block").setCreativeTab(Minestrappolation.tabMBuilding);
		sunstone_block = new BlockSunstoneBlock(Material.glass, MapColor.sandColor).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightLevel(0.9F).setUnlocalizedName("sunstone_block").setCreativeTab(Minestrappolation.tabMBuilding);
		plutonium_block = new BlockRadationMineral(4, 20, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("plutonium_block").setCreativeTab(Minestrappolation.tabMBuilding);
		uranium_block = new BlockRadationMineral(4, 20, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("uranium_block").setCreativeTab(Minestrappolation.tabMBuilding);
		blazium_block = new BlockBlazium(Material.iron, MapColor.redColor).setHardness(5.0F).setResistance(10.0F).setLightLevel(0.5F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("blazium_block").setCreativeTab(Minestrappolation.tabMBuilding);
		glacierite_block = new BlockGlacierite(Material.iron, MapColor.blueColor).setHardness(5.0F).setResistance(10.0F).setLightLevel(0.3F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("glacierite_block").setCreativeTab(Minestrappolation.tabMBuilding);
		soul_gem_block = new BlockSoul(Material.iron, MapColor.cyanColor).setHardness(10.0F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("soul_gem_block").setCreativeTab(Minestrappolation.tabMBuilding);
		titanium_block = new MBlock(Material.iron, MapColor.grayColor).setHardness(10.0F).setResistance(9999.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("titanium_block").setCreativeTab(Minestrappolation.tabMBuilding);
		
		//Wood Blocks
		ministrapp_log = new MBlockLog(300).setUnlocalizedName("ministrapp_log");
		ministrapp_planks = new MBlockPlanks(300).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("ministrapp_planks");
		
		//Glass Decor Blocks
		glass_bricks = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightOpacity(1).setUnlocalizedName("glass_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		glass_refined = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("glass_refined").setCreativeTab(Minestrappolation.tabMBuilding);
		glass_tiles = new BlockTransparent(Material.glass, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightOpacity(1).setUnlocalizedName("glass_tiles").setCreativeTab(Minestrappolation.tabMBuilding);
		glass_window = new BlockTransparent(Material.iron, MapColor.airColor, true).setHardness(0.8F).setResistance(2.0F).setStepSound(Block.soundTypeGlass).setLightOpacity(2).setUnlocalizedName("glass_window").setCreativeTab(Minestrappolation.tabMBuilding);
		glow_glass = new BlockTranslucent(Material.iron, MapColor.airColor, false).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightOpacity(0).setLightLevel(0.9F).setUnlocalizedName("glow_glass").setCreativeTab(Minestrappolation.tabMBuilding);
		
		//Misc. Decor Blocks
		snow_refined = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.4F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_refined").setCreativeTab(Minestrappolation.tabMBuilding);
		snow_bricks = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.6F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		snow_tiles = new MBlockSnow(Material.snow, MapColor.snowColor).setHardness(0.6F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_tiles").setCreativeTab(Minestrappolation.tabMBuilding);
		cardboard_block = new BlockCardboard(Material.cloth, MapColor.brownColor).setHardness(0.1F).setResistance(0F).setUnlocalizedName("cardboard_block").setStepSound(Block.soundTypePiston).setCreativeTab(Minestrappolation.tabMBuilding);
		wet_cardboard_block = new BlockWetCardboard(Material.cloth, MapColor.brownColor).setHardness(0F).setResistance(0F).setUnlocalizedName("wet_cardboard_block").setStepSound(Block.soundTypePiston).setCreativeTab(Minestrappolation.tabMBuilding);
		mud_bricks = new MBlock(Material.ground, MapColor.brownColor).setHardness(0.7F).setStepSound(Block.SLIME_SOUND).setUnlocalizedName("mud_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		invincium = new BlockInvincium(Material.rock).setUnlocalizedName("invincium").setBlockUnbreakable().setHardness(50000F).setResistance(50000F).setCreativeTab(Minestrappolation.tabMBuilding);
		glaical_invincium = new BlockGlacialInvincium(Material.rock, MapColor.blueColor).setUnlocalizedName("glaical_invincium").setBlockUnbreakable().setHardness(50000F).setResistance(50000F).setCreativeTab(Minestrappolation.tabMBuilding);
		
		//Misc. Stone Decor Blocks
		slate = new MBlock(Material.rock, MapColor.grayColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("slate").setCreativeTab(Minestrappolation.tabMBuilding);
		slate_refined = new MBlock(Material.rock, MapColor.grayColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("slate_refined").setCreativeTab(Minestrappolation.tabMBuilding);
		slate_bricks = new MBlock(Material.rock, MapColor.grayColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("slate_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		slate_pattern_bricks = new MBlock(Material.rock, MapColor.grayColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("slate_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		diorite_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("diorite_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		diorite_pattern_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("diorite_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		granite_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("granite_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		granite_pattern_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("granite_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		andesite_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("andesite_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		andesite_pattern_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("andesite_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		sandstone_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(0.8F).setStepSound(Block.soundTypePiston).setUnlocalizedName("sandstone_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		sandstone_pattern_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(0.8F).setStepSound(Block.soundTypePiston).setUnlocalizedName("sandstone_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		red_sandstone_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(0.8F).setStepSound(Block.soundTypePiston).setUnlocalizedName("red_sandstone_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		red_sandstone_pattern_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(0.8F).setStepSound(Block.soundTypePiston).setUnlocalizedName("red_sandstone_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		flint_block = new BlockMStorage(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_block").setCreativeTab(Minestrappolation.tabMBuilding);
		flint_bricks = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		flint_pattern_bricks = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		flint_refined = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_refined").setCreativeTab(Minestrappolation.tabMBuilding);
		flint_tiles = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_tiles").setCreativeTab(Minestrappolation.tabMBuilding);
		flint_chiseled = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_chiseled").setCreativeTab(Minestrappolation.tabMBuilding);
		flint_lamp_sunstone = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setLightLevel(0.7F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_lamp_sunstone").setCreativeTab(Minestrappolation.tabMBuilding);
		flint_lamp_glowstone = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setLightLevel(0.8F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_lamp_glowstone").setCreativeTab(Minestrappolation.tabMBuilding);
		flint_lamp_prismarine = new MBlock(Material.rock, MapColor.blackColor).setHardness(3F).setResistance(15.0F).setLightLevel(0.8F).setStepSound(Block.soundTypePiston).setUnlocalizedName("flint_lamp_prismarine").setCreativeTab(Minestrappolation.tabMBuilding);
		desert_quartz_block = new MBlock(Material.rock, MapColor.adobeColor).setHardness(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("desert_quartz_block").setCreativeTab(Minestrappolation.tabMBuilding);
		desert_quartz_chiseled = new MBlock(Material.rock, MapColor.adobeColor).setHardness(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("desert_quartz_chiseled").setCreativeTab(Minestrappolation.tabMBuilding);
		desert_pillar = new MBlockPillar(Material.rock, MapColor.adobeColor).setUnlocalizedName("desert_pillar").setHardness(1F).setResistance(4F);
		radiant_block = new MBlock(Material.rock, MapColor.pinkColor).setHardness(1.0F).setLightLevel(0.6F).setStepSound(Block.soundTypePiston).setUnlocalizedName("radiant_quartz_block").setCreativeTab(Minestrappolation.tabMBuilding);
		radiant_chiseled = new MBlock(Material.rock, MapColor.pinkColor).setHardness(1.0F).setLightLevel(0.6F).setStepSound(Block.soundTypePiston).setUnlocalizedName("radiant_quartz_chiseled").setCreativeTab(Minestrappolation.tabMBuilding);
		radiant_pillar = new MBlockPillar(Material.rock, MapColor.pinkColor).setLightLevel(0.6F).setUnlocalizedName("radiant_pillar").setHardness(1F).setResistance(4F);
		obsidian_bricks =  new MBlock(Material.rock, MapColor.obsidianColor).setHardness(50.0F).setResistance(2000.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("obsidian_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		glow_mossy_netherrack = new MBlock(Material.rock, MapColor.netherrackColor).setHardness(0.4F).setStepSound(Block.soundTypePiston).setLightLevel(0.5F).setUnlocalizedName("glow_mossy_netherrack").setCreativeTab(Minestrappolation.tabMBuilding);
		glow_mossy_nether_bricks = new MBlock(Material.rock, MapColor.netherrackColor).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.5F).setUnlocalizedName("glow_mossy_nether_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		glow_mossy_end_stone = new MBlock(Material.rock, MapColor.stoneColor).setHardness(3.0F).setResistance(15.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.5F).setUnlocalizedName("glow_mossy_end_stone").setCreativeTab(Minestrappolation.tabMBuilding);
		
		//Biome Stone Decor Blocks
		stone_lamp_glowstone = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setLightLevel(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_lamp_glowstone").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_lamp_prismarine = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setLightLevel(1.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_lamp_prismarine").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_lamp_sunstone = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setLightLevel(0.9F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_lamp_sunstone").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_pattern_bricks = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_pattern_bricks").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_refined = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_refined").setCreativeTab(Minestrappolation.tabMBuilding);
		stone_tiles = new MBlock(Material.rock, MapColor.stoneColor).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_tiles").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_stones = new BlockBiomeStones().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_stone");
		biome_cobble = new BlockBiomeCobble().setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_cobble");
		biome_bricks = new BlockBiomeBricks().setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_bricks");
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
		
		//Utility Decor Blocks
		magnetic_torch = new BlockMagneticTorch().setLightLevel(0.9375F).setStepSound(Block.soundTypeWood).setUnlocalizedName("magnetic_torch").setCreativeTab(Minestrappolation.tabMDecor);
		stone_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("stone_boulder").setCreativeTab(Minestrappolation.tabMBuilding);
		red_rock_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("red_rock_boulder").setCreativeTab(Minestrappolation.tabMBuilding);
		coldstone_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("coldstone_boulder").setCreativeTab(Minestrappolation.tabMBuilding);
		icestone_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("icestone_boulder").setCreativeTab(Minestrappolation.tabMBuilding);
		oceanstone_boulder = new BlockBoulder(Material.rock, MapColor.stoneColor).setHardness(8.0F).setResistance(20.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("oceanstone_boulder").setCreativeTab(Minestrappolation.tabMBuilding);
		ministrapp_flower_pot = new MBlockSketchyBackwaterFlowerpot().setHardness(0.0F).setStepSound(Block.soundTypeStone).setUnlocalizedName("ministrapp_flower_pot").setCreativeTab(Minestrappolation.tabMDecor);
		roads = new BlockRoads(Material.rock, MapColor.blackColor).setHardness(3.0F).setResistance(10.0F).setUnlocalizedName("roads").setCreativeTab(Minestrappolation.tabMBuilding);
		rope = new BlockRope(Material.cloth, MapColor.brownColor).setHardness(0.8F).setStepSound(Block.soundTypeCloth).setUnlocalizedName("rope").setCreativeTab(Minestrappolation.tabMDecor);
		chimney = new BlockChimney(Material.rock, MapColor.blackColor).setHardness(1.5F).setResistance(10F).setUnlocalizedName("chimney").setCreativeTab(Minestrappolation.tabMDecor);
		fan = new BlockFan(6, Material.rock, MapColor.pinkColor).setHardness(3F).setResistance(20F).setUnlocalizedName("fan").setCreativeTab(Minestrappolation.tabMTech);
		cold_cobweb = new BlockColdCobweb().setLightOpacity(1).setHardness(5.0F).setUnlocalizedName("cold_cobweb");
		glacieric_ice = new BlockGlaciericIce(Material.ice, MapColor.iceColor).setHardness(0.5F).setLightOpacity(3).setStepSound(Block.soundTypeGlass).setUnlocalizedName("glacieric_ice").setCreativeTab(Minestrappolation.tabMBuilding);
		godstone = new BlockGodstone(Material.rock, MapColor.sandColor).setHardness(3F).setResistance(15F).setUnlocalizedName("godstone").setCreativeTab(Minestrappolation.tabMBuilding);
		
		//Gene Blocks
		block_flesh = new BlockFlesh(Material.cloth, MapColor.pinkColor).setHardness(0.7F).setStepSound(Block.SLIME_SOUND).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_flesh");
		block_flesh_reactive = new BlockReactiveFlesh(Material.cloth, MapColor.pinkColor).setHardness(0.7F).setStepSound(Block.SLIME_SOUND).setUnlocalizedName("block_flesh_reactive");
		block_bat = new BlockBat(Material.cloth, MapColor.brownColor).setHardness(0.7F).setStepSound(Block.SLIME_SOUND).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_bat");
		block_rabbit = new BlockRabbit(Material.cloth, MapColor.brownColor).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_rabbit");
		block_cow = new BlockCow(Material.cloth, MapColor.brownColor).setHardness(0.7F).setStepSound(Block.SLIME_SOUND).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_cow");
		block_mooshroom = new BlockMooshroom(Material.cloth, MapColor.redColor).setHardness(0.7F).setStepSound(Block.SLIME_SOUND).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_mooshroom");
		block_chicken = new BlockChicken(Material.cloth, MapColor.ironColor).setHardness(0.7F).setStepSound(Block.SLIME_SOUND).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_chicken");
		block_wolf = new BlockWolf(Material.cloth, MapColor.silverColor).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_wolf");
		block_sheep_white = new BlockSheep(Material.cloth, MapColor.ironColor, 0).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_white");
		block_sheep_orange = new BlockSheep(Material.cloth, MapColor.ironColor, 1).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_orange");
		block_sheep_magenta = new BlockSheep(Material.cloth, MapColor.ironColor, 2).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_magenta");
		block_sheep_light_blue = new BlockSheep(Material.cloth, MapColor.ironColor, 3).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_light_blue");
		block_sheep_yellow = new BlockSheep(Material.cloth, MapColor.ironColor, 4).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_yellow");
		block_sheep_lime = new BlockSheep(Material.cloth, MapColor.ironColor, 5).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_lime");
		block_sheep_pink = new BlockSheep(Material.cloth, MapColor.ironColor, 6).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_pink");
		block_sheep_grey = new BlockSheep(Material.cloth, MapColor.ironColor, 7).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_grey");
		block_sheep_silver = new BlockSheep(Material.cloth, MapColor.ironColor, 8).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_silver");
		block_sheep_cyan = new BlockSheep(Material.cloth, MapColor.ironColor, 9).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_cyan");
		block_sheep_purple = new BlockSheep(Material.cloth, MapColor.ironColor, 10).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_purple");
		block_sheep_blue = new BlockSheep(Material.cloth, MapColor.ironColor, 11).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_blue");
		block_sheep_brown = new BlockSheep(Material.cloth, MapColor.ironColor, 12).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_brown");
		block_sheep_green = new BlockSheep(Material.cloth, MapColor.ironColor, 13).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_green");
		block_sheep_red = new BlockSheep(Material.cloth, MapColor.ironColor, 14).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_red");
		block_sheep_black = new BlockSheep(Material.cloth, MapColor.ironColor, 15).setHardness(0.7F).setStepSound(Block.soundTypeCloth).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("block_sheep_black");
		
		//Tech Blocks
		crate = new BlockCrate().setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("crate").setHardness(2.5F).setStepSound(Block.soundTypeWood);
		barrel = new BlockBarrel().setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("barrel").setHardness(2.5F).setStepSound(Block.soundTypeWood);
		sawmill = new BlockSawmill().setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("sawmill").setHardness(2.5F).setStepSound(Block.soundTypeWood);
		stonecutter = new BlockStoneCutter().setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("stonecutter").setHardness(3.5F).setStepSound(Block.soundTypePiston);
		alloy = new BlockAlloy(false).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("alloy").setHardness(4F).setStepSound(Block.soundTypePiston);
		alloy_active = new BlockAlloy(true).setUnlocalizedName("alloy_active").setHardness(4F).setStepSound(Block.soundTypePiston);
		melter = new BlockMelter(false).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("melter").setHardness(5F).setStepSound(Block.soundTypePiston);
		melter_active = new BlockMelter(true).setUnlocalizedName("melter_active").setHardness(5F).setStepSound(Block.soundTypePiston);
		crusher = new BlockCrusher(false).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("crusher").setHardness(7F).setResistance(100.0F).setStepSound(Block.soundTypePiston);
		crusher_active = new BlockCrusher(true).setUnlocalizedName("crusher_active").setHardness(7F).setResistance(100.0F).setStepSound(Block.soundTypePiston);
		splitter = new BlockSplitter(false).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("splitter");
		splitter_active = new BlockSplitter(true).setUnlocalizedName("splitter_active");
		frost_generator = new BlockFrostGenerator(Material.rock, MapColor.iceColor).setHardness(50.0F).setResistance(2000.0F).setCreativeTab(Minestrappolation.tabMTech).setUnlocalizedName("frost_generator");
		plutonium_insulated = new BlockRadiationInsulated(1, 20, Material.iron, MapColor.clayColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setUnlocalizedName("plutonium_insulated").setStepSound(Block.soundTypeMetal).setCreativeTab(Minestrappolation.tabMTech).setHardness(7F).setResistance(10.0F);
		uranium_insulated = new BlockRadiationInsulated(1, 20, Material.iron, MapColor.clayColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(7F).setResistance(10.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("uranium_insulated").setCreativeTab(Minestrappolation.tabMTech);
		claimerator = new BlockClaimerator(Material.rock, MapColor.obsidianColor).setHardness(50.0F).setResistance(2000.0F).setUnlocalizedName("claimerator").setCreativeTab(Minestrappolation.tabMTech);
		
		//Fences and Panes
		redwood_fence = new BlockFence(Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("redwood_fence");
		redwood_fence_gate = new BlockFenceGate().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("redwood_fence_gate");
		frozen_oak_fence = new BlockFence(Material.wood).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("frozen_oak_fence");
		frozen_oak_fence_gate = new BlockFenceGate().setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("frozen_oak_fence_gate");
		red_rock_wall = new MBlockWall(biome_cobble, 2.0F, 10.0F).setUnlocalizedName("red_rock_wall");
		red_rock_wall_mossy = new MBlockWall(biome_cobble, 2.0F, 10.0F).setUnlocalizedName("red_rock_wall_mossy");
		coldstone_wall = new MBlockWall(biome_cobble, 2.0F, 10.0F).setUnlocalizedName("coldstone_wall");
		coldstone_wall_mossy = new MBlockWall(biome_cobble, 2.0F, 10.0F).setUnlocalizedName("coldstone_wall_mossy");
		icestone_wall = new MBlockWall(biome_cobble, 2.0F, 10.0F).setUnlocalizedName("icestone_wall");
		icestone_wall_mossy = new MBlockWall(biome_cobble, 2.0F, 10.0F).setUnlocalizedName("icestone_wall_mossy");
		oceanstone_wall = new MBlockWall(biome_cobble, 2.0F, 10.0F).setUnlocalizedName("oceanstone_wall");
		oceanstone_wall_mossy = new MBlockWall(biome_cobble, 2.0F, 10.0F).setUnlocalizedName("oceanstone_wall_mossy");
		refined_glass_pane = new BlockMPane(Material.glass, false, 0).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("refined_pane");
		bricked_glass_pane = new BlockMPane(Material.glass, false, 0).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("bricked_pane");
		tiled_glass_pane = new BlockMPane(Material.glass, false, 0).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("tiled_pane");
		framed_glass_pane = new BlockMPane(Material.iron, true, 0).setHardness(3.0F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("framed_pane");
		glow_glass_pane = new BlockMPane(Material.glass, false, 0).setHardness(0.3F).setStepSound(Block.soundTypeGlass).setLightLevel(0.9F).setUnlocalizedName("glow_glass_pane");
		steel_mesh = new BlockMPane(Material.iron, true, 0).setHardness(5.0F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("steel_mesh");
		cardboard = new BlockMPane(Material.cloth, true, 1200).setHardness(0.1F).setResistance(0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("cardboard");
		
		//Doors
		redwood_door = new BlockMDoor(Material.wood).setHardness(3.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("redwood_door");
		frozen_door = new BlockMDoor(Material.wood).setHardness(3.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("frozen_oak_door");
		glass_door = new BlockMDoor(Material.rock).setHardness(3.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("glass_door");
		
		redwood_door_item = new ItemMDoor(redwood_door).setUnlocalizedName("redwood_door_item");
		frozen_door_item = new ItemMDoor(frozen_door).setUnlocalizedName("frozen_oak_door_item");
		glass_door_item = new ItemMDoor(glass_door).setUnlocalizedName("glass_door_item");
		
		//Ores
		desert_quartz = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.desert_quartz_item, 0, 1, 2, 1, 2, "pickaxe", 0, true).setHardness(2.0F).setStepSound(Block.soundTypePiston).setResistance(3.0F).setUnlocalizedName("desert_quartz").setCreativeTab(Minestrappolation.tabMBuilding);
		glacieric_ice_vein = new BlockIceDeposit(Material.glass, MItems.glacieric_ice_shard, MapColor.iceColor).setStepSound(Block.soundTypeGlass).setBlockUnbreakable().setHardness(50000F).setResistance(50000F).setCreativeTab(Minestrappolation.tabMDecor).setUnlocalizedName("glacieric_ice_vein");
		biome_coal = new BlockBiomeCoal(0, 0, Material.rock, MapColor.stoneColor, Items.coal, 0, 0, 1, 1, 0, "pickaxe", 0, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_coal").setCreativeTab(Minestrappolation.tabMBuilding);
		copper_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("copper_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_copper = new BlockBiomeCopper(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_copper").setCreativeTab(Minestrappolation.tabMBuilding);
		tin_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(3.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("tin_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_tin = new BlockBiomeTin(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 0, false).setHardness(3.0F).setResistance(3.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_tin").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_iron = new BlockBiomeIron(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 1, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_iron").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_gold = new BlockBiomeGold(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_gold").setCreativeTab(Minestrappolation.tabMBuilding);
		meurodite_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.meurodite_gem, 0, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setUnlocalizedName("meurodite_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_meurodite = new BlockBiomeMeurodite(0, 0, Material.rock, MapColor.stoneColor, MItems.meurodite_gem, 0, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setUnlocalizedName("biome_meurodite").setCreativeTab(Minestrappolation.tabMBuilding);
		torite_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("torite_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_torite = new BlockBiomeTorite(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 2, false).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_torite").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_redstone = new BlockBiomeRedstone(0, 0, Material.rock, MapColor.stoneColor, Items.redstone, 0, 1, 5, 4, 2, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_redstone").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_lapis = new BlockBiomeLapis(0, 0, Material.rock, MapColor.stoneColor, Items.dye, 4, 2, 5, 4, 5, "pickaxe", 1, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_lapis").setCreativeTab(Minestrappolation.tabMBuilding);
		sunstone_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.sunstone_shard, 0, 2, 5, 1, 3, "pickaxe", 2, true).setHardness(2.6F).setResistance(4.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.7F).setUnlocalizedName("sunstone_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_sunstone = new BlockBiomeSunstone(0, 0, Material.rock, MapColor.stoneColor, MItems.sunstone_shard, 0, 2, 5, 1, 3, "pickaxe", 2, true).setHardness(2.6F).setResistance(4.0F).setStepSound(Block.soundTypePiston).setLightLevel(0.7F).setUnlocalizedName("biome_sunstone").setCreativeTab(Minestrappolation.tabMBuilding);
		plutonium_ore = new BlockPlutoniumOre(2, 20, Material.rock, MapColor.stoneColor, MItems.plutonium, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("plutonium_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_plutonium = new BlockBiomePlutonium(2, 20, Material.rock, MapColor.stoneColor, MItems.plutonium, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_plutonium").setCreativeTab(Minestrappolation.tabMBuilding);
		uranium_ore = new BlockUraniumOre(2, 20, Material.rock, MapColor.stoneColor, MItems.uranium, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("uranium_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_uranium = new BlockBiomeUranium(2, 20, Material.rock, MapColor.stoneColor, MItems.uranium, 1, 2, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_uranium").setCreativeTab(Minestrappolation.tabMBuilding);
		radiant_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.radiant_quartz, 0, 1, 5, 1, 2, "pickaxe", 3, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("radiant_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_radiant = new BlockBiomeRadiant(0, 0, Material.rock, MapColor.stoneColor, MItems.radiant_quartz, 0, 1, 5, 1, 2, "pickaxe", 3, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_radiant").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_diamond = new BlockBiomeDiamond(0, 0, Material.rock, MapColor.stoneColor, Items.diamond, 0, 3, 7, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_diamond").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_emerald = new BlockBiomeEmerald(0, 0, Material.rock, MapColor.stoneColor, Items.emerald, 0, 3, 7, 1, 0, "pickaxe", 2, true).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_emerald").setCreativeTab(Minestrappolation.tabMBuilding);
		blazium_ore = new MBlockOre(Material.rock, MapColor.stoneColor, MItems.blaze_shard, 0, 1, 2, 1, 4, "pickaxe", 2, true).setHardness(3.0F).setStepSound(Block.soundTypePiston).setResistance(5.0F).setUnlocalizedName("blazium_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		soul_ore = new BlockSoulOre(Material.ground, MapColor.stoneColor, MItems.soul_gem, 0, 1, 7, 1, 0, "shovel", 2, true).setHardness(2.0F).setStepSound(Block.soundTypeSand).setResistance(3.0F).setUnlocalizedName("soul_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		titanium_ore = new MBlockOre(Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 3, false).setHardness(5.0F).setResistance(100.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("titanium_ore").setCreativeTab(Minestrappolation.tabMBuilding);
		biome_titanium = new BlockBiomeTitanium(0, 0, Material.rock, MapColor.stoneColor, null, 0, 0, 1, 0, "pickaxe", 3, false).setHardness(5.0F).setResistance(100.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("biome_titanium").setCreativeTab(Minestrappolation.tabMBuilding);
		
		//Stairs
		redwood_stairs = new MBlockStairs(ministrapp_planks.getStateFromMeta(MWoodType.REDWOOD.getMetadata()), 300).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("redwood_stairs");
		frozen_oak_stairs = new MBlockStairs(ministrapp_planks.getStateFromMeta(MWoodType.FROZEN.getMetadata()), 300).setHardness(2.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("frozen_oak_stairs");
		andesite_brick_stairs = new MBlockStairs(andesite_bricks.getDefaultState(), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("andesite_brick_stairs");
		diorite_brick_stairs = new MBlockStairs(diorite_bricks.getDefaultState(), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("diorite_brick_stairs");
		granite_brick_stairs = new MBlockStairs(granite_bricks.getDefaultState(), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("granite_brick_stairs");
		slate_brick_stairs = new MBlockStairs(slate_bricks.getDefaultState(), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("slate_brick_stairs");
		sandstone_brick_stairs = new MBlockStairs(sandstone_bricks.getDefaultState(), 0).setHardness(0.8F).setStepSound(Block.soundTypePiston).setUnlocalizedName("sandstone_brick_stairs");
		red_sandstone_brick_stairs = new MBlockStairs(red_sandstone_bricks.getDefaultState(), 0).setHardness(0.8F).setStepSound(Block.soundTypePiston).setUnlocalizedName("red_sandstone_brick_stairs");
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
		prismarine_stairs = new MBlockStairs(Blocks.prismarine.getDefaultState(), 0).setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setUnlocalizedName("prismarine_stairs");
		
		//Slabs
		redwood_slab = new BlockMSlab(Material.wood, "redwood_slab", 2F, 5F, "axe", 0, 300);
		redwood_double_slab = new BlockMDoubleSlab(Material.wood, "redwood", 2F, 5F, "axe", 0, 300, redwood_slab);
		frozen_oak_slab = new BlockMSlab(Material.wood, "frozen_oak_slab", 2F, 5F, "axe", 0, 300);
		frozen_oak_double_slab = new BlockMDoubleSlab(Material.wood, "frozen_oak", 2F, 5F, "axe", 0, 300, frozen_oak_slab);
		
		andesite_brick_slab = new BlockMSlab(Material.rock, "andesite_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		andesite_brick_double_slab = new BlockMDoubleSlab(Material.rock, "andesite_brick", 2F, 10F, "pickaxe", 0, 0, andesite_brick_slab);
		diorite_brick_slab = new BlockMSlab(Material.rock, "diorite_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		diorite_brick_double_slab = new BlockMDoubleSlab(Material.rock, "diorite_brick", 2F, 10F, "pickaxe", 0, 0, diorite_brick_slab);
		granite_brick_slab = new BlockMSlab(Material.rock, "granite_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		granite_brick_double_slab = new BlockMDoubleSlab(Material.rock, "granite_brick", 2F, 10F, "pickaxe", 0, 0, granite_brick_slab);
		slate_brick_slab = new BlockMSlab(Material.rock, "slate_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		slate_brick_double_slab = new BlockMDoubleSlab(Material.rock, "slate_brick", 2F, 10F, "pickaxe", 0, 0, slate_brick_slab);
		sandstone_brick_slab = new BlockMSlab(Material.rock, "sandstone_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		sandstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "sandstone_brick", 2F, 10F, "pickaxe", 0, 0, sandstone_brick_slab);
		red_sandstone_brick_slab = new BlockMSlab(Material.rock, "red_sandstone_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		red_sandstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "red_sandstone_brick", 2F, 10F, "pickaxe", 0, 0, red_sandstone_brick_slab);
		desert_quartz_slab = new BlockMSlab(Material.rock, "desert_quartz_slab", 1F, 4F, "pickaxe", 0, 0);
		desert_quartz_double_slab = new BlockMDoubleSlab(Material.rock, "desert_quartz", 1F, 4F, "pickaxe", 0, 0, desert_quartz_slab);
		radiant_slab = new BlockMSlab(Material.rock, "radiant_quartz_slab", 1F, 4F, "pickaxe", 3, 0);
		radiant_double_slab = new BlockMDoubleSlab(Material.rock, "radiant_quartz", 1F, 4F, "pickaxe", 3, 0, radiant_slab);
		prismarine_slab = new BlockMSlab(Material.rock, "prismarine_slab", 1.5F, 10F, "pickaxe", 0, 0);
		prismarine_double_slab = new BlockMDoubleSlab(Material.rock, "prismarine", 1.5F, 10F, "pickaxe", 0, 0, prismarine_slab);
		
		deepstone_slab = new BlockMSlab(Material.rock, "deepstone_slab", 2F, 10F, "pickaxe", 2, 0);
		deepstone_double_slab = new BlockMDoubleSlab(Material.rock, "deepstone", 2F, 10F, "pickaxe", 2, 0, deepstone_slab);
		red_rock_slab = new BlockMSlab(Material.rock, "red_rock_slab", 2F, 10F, "pickaxe", 0, 0);
		red_rock_double_slab = new BlockMDoubleSlab(Material.rock, "red_rock", 2F, 10F, "pickaxe", 0, 0, red_rock_slab);
		deep_red_rock_slab = new BlockMSlab(Material.rock, "deep_red_rock_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_red_rock_double_slab = new BlockMDoubleSlab(Material.rock, "deep_red_rock", 2F, 10F, "pickaxe", 2, 0, deep_red_rock_slab);
		coldstone_slab = new BlockMSlab(Material.rock, "coldstone_slab", 2F, 10F, "pickaxe", 0, 0);
		coldstone_double_slab = new BlockMDoubleSlab(Material.rock, "coldstone", 2F, 10F, "pickaxe", 0, 0, coldstone_slab);
		deep_coldstone_slab = new BlockMSlab(Material.rock, "deep_coldstone_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_coldstone_double_slab = new BlockMDoubleSlab(Material.rock, "deep", 2F, 10F, "pickaxe", 2, 0, deep_coldstone_slab);
		icestone_slab = new BlockMSlab(Material.rock, "icestone_slab", 2F, 10F, "pickaxe", 0, 0);
		icestone_double_slab = new BlockMDoubleSlab(Material.rock, "icestone", 2F, 10F, "pickaxe", 0, 0, icestone_slab);
		glacierrock_slab = new BlockMSlab(Material.rock, "glacierrock_slab", 2F, 10F, "pickaxe", 2, 0);
		glacierrock_double_slab = new BlockMDoubleSlab(Material.rock, "glacierrock", 2F, 10F, "pickaxe", 2, 0, glacierrock_slab);
		oceanstone_slab = new BlockMSlab(Material.rock, "oceanstone_slab", 2F, 10F, "pickaxe", 0, 0);
		oceanstone_double_slab = new BlockMDoubleSlab(Material.rock, "oceanstone", 2F, 10F, "pickaxe", 0, 0, oceanstone_slab);
		poceanstone_slab = new BlockMSlab(Material.rock, "poceanstone_slab", 2F, 10F, "pickaxe", 2, 0);
		poceanstone_double_slab = new BlockMDoubleSlab(Material.rock, "poceanstone", 2F, 10F, "pickaxe", 2, 0, poceanstone_slab);
		
		deepstone_cobble_slab = new BlockMSlab(Material.rock, "deepstone_cobble_slab", 2F, 10F, "pickaxe", 2, 0);
		deepstone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "deepstone_cobble", 2F, 10F, "pickaxe", 2, 0, deepstone_cobble_slab);
		red_rock_cobble_slab = new BlockMSlab(Material.rock, "red_rock_cobble_slab", 2F, 10F, "pickaxe", 0, 0);
		red_rock_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "red_rock_cobble", 2F, 10F, "pickaxe", 0, 0, red_rock_cobble_slab);
		deep_red_rock_cobble_slab = new BlockMSlab(Material.rock, "deep_red_rock_cobble_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_red_rock_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "deep_red_rock_cobble", 2F, 10F, "pickaxe", 2, 0, deep_red_rock_cobble_slab);
		coldstone_cobble_slab = new BlockMSlab(Material.rock, "coldstone_cobble_slab", 2F, 10F, "pickaxe", 0, 0);
		coldstone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "coldstone_cobble", 2F, 10F, "pickaxe", 0, 0, coldstone_cobble_slab);
		deep_coldstone_cobble_slab = new BlockMSlab(Material.rock, "deep_coldstone_cobble_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_coldstone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "deep_coldstone_cobble", 2F, 10F, "pickaxe", 2, 0, deep_coldstone_cobble_slab);
		icestone_cobble_slab = new BlockMSlab(Material.rock, "icestone_cobble_slab", 2F, 10F, "pickaxe", 0, 0);
		icestone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "icestone_cobble", 2F, 10F, "pickaxe", 0, 0, icestone_cobble_slab);
		glacierrock_cobble_slab = new BlockMSlab(Material.rock, "glacierrock_cobble_slab", 2F, 10F, "pickaxe", 2, 0);
		glacierrock_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "glacierrock_cobble", 2F, 10F, "pickaxe", 2, 0, glacierrock_cobble_slab);
		oceanstone_cobble_slab = new BlockMSlab(Material.rock, "oceanstone_cobble_slab", 2F, 10F, "pickaxe", 0, 0);
		oceanstone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "oceanstone_cobble", 2F, 10F, "pickaxe", 0, 0, oceanstone_cobble_slab);
		poceanstone_cobble_slab = new BlockMSlab(Material.rock, "poceanstone_cobble_slab", 2F, 10F, "pickaxe", 2, 0);
		poceanstone_cobble_double_slab = new BlockMDoubleSlab(Material.rock, "poceanstone_cobble", 2F, 10F, "pickaxe", 2, 0, poceanstone_cobble_slab);
		
		deepstone_brick_slab = new BlockMSlab(Material.rock, "deepstone_brick_slab", 2F, 10F, "pickaxe", 2, 0);
		deepstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "deepstone_brick", 2F, 10F, "pickaxe", 2, 0, deepstone_brick_slab);
		red_rock_brick_slab = new BlockMSlab(Material.rock, "red_rock_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		red_rock_brick_double_slab = new BlockMDoubleSlab(Material.rock, "red_rock_brick", 2F, 10F, "pickaxe", 0, 0, red_rock_brick_slab);
		deep_red_rock_brick_slab = new BlockMSlab(Material.rock, "deep_red_rock_brick_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_red_rock_brick_double_slab = new BlockMDoubleSlab(Material.rock, "deep_red_rock_brick", 2F, 10F, "pickaxe", 2, 0, deep_red_rock_cobble_slab);
		coldstone_brick_slab = new BlockMSlab(Material.rock, "coldstone_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		coldstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "coldstone_brick", 2F, 10F, "pickaxe", 0, 0, coldstone_brick_slab);
		deep_coldstone_brick_slab = new BlockMSlab(Material.rock, "deep_coldstone_brick_slab", 2F, 10F, "pickaxe", 2, 0);
		deep_coldstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "deep_coldstone_brick", 2F, 10F, "pickaxe", 2, 0, deep_coldstone_brick_slab);
		icestone_brick_slab = new BlockMSlab(Material.rock, "icestone_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		icestone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "icestone_brick", 2F, 10F, "pickaxe", 0, 0, icestone_brick_slab);
		glacierrock_brick_slab = new BlockMSlab(Material.rock, "glacierrock_brick_slab", 2F, 10F, "pickaxe", 2, 0);
		glacierrock_brick_double_slab = new BlockMDoubleSlab(Material.rock, "glacierrock_brick", 2F, 10F, "pickaxe", 2, 0, glacierrock_brick_slab);
		oceanstone_brick_slab = new BlockMSlab(Material.rock, "oceanstone_brick_slab", 2F, 10F, "pickaxe", 0, 0);
		oceanstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "oceanstone_brick", 2F, 10F, "pickaxe", 0, 0, oceanstone_brick_slab);
		poceanstone_brick_slab = new BlockMSlab(Material.rock, "poceanstone_brick_slab", 2F, 10F, "pickaxe", 2, 0);
		poceanstone_brick_double_slab = new BlockMDoubleSlab(Material.rock, "poceanstone_brick", 2F, 10F, "pickaxe", 2, 0, poceanstone_brick_slab);
		
		//Fluid
		magma = new BlockMagma().setUnlocalizedName("magma");
		magmaBucket = new ItemBucket(magma).setUnlocalizedName("magma_bucket").setCreativeTab(Minestrappolation.tabMTools);	
		
		//Vanilla
		Blocks.bedrock.setHardness(70F);
		
		//Registry
		register();
		registerHarvestLevels();
		
		MinecraftForge.addGrassSeed(new ItemStack(pepper_seed), Config.pepperSeedChance);
		MinecraftForge.addGrassSeed(new ItemStack(rice), Config.riceSeedChance);
	}
	
	private static void register()
	{
		//Building Tab
		register(mud);
		register(mud_bricks);
		register(rubble);
		register(dirt_permafrost);
		register(lichen_permafrost, ItemBlockPermaFrost.class);
		register(cold_sand, ItemBlockColdSand.class);
		
		register(cardboard_block);
		register(wet_cardboard_block);
		register(snow_bricks);
		register(snow_refined);
		register(snow_tiles);
		register(glacieric_ice);
		register(melon_bricks);
		register(glass_bricks);
		register(glass_refined);
		register(glass_tiles);
		register(glass_window);
		register(glow_glass);
		
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
		register(slate_brick_stairs);
		registerSlab("slate_brick_slab", "slate_brick_double_slab", slate_brick_slab, slate_brick_double_slab);
		register(granite_bricks);
		register(granite_pattern_bricks);
		register(granite_brick_stairs);
		registerSlab("granite_brick_slab", "granite_brick_double_slab", granite_brick_slab, granite_brick_double_slab);
		register(diorite_bricks);
		register(diorite_pattern_bricks);
		register(diorite_brick_stairs);
		registerSlab("diorite_brick_slab", "diorite_brick_double_slab", diorite_brick_slab, diorite_brick_double_slab);
		register(andesite_bricks);
		register(andesite_pattern_bricks);
		register(andesite_brick_stairs);
		registerSlab("andesite_brick_slab", "andesite_brick_double_slab", andesite_brick_slab, andesite_brick_double_slab);
		register(sandstone_bricks);
		register(sandstone_pattern_bricks);
		register(sandstone_brick_stairs);
		registerSlab("sandstone_brick_slab", "sandstone_brick_double_slab", sandstone_brick_slab, sandstone_brick_double_slab);
		register(red_sandstone_bricks);
		register(red_sandstone_pattern_bricks);
		register(red_sandstone_brick_stairs);
		registerSlab("red_sandstone_brick_slab", "red_sandstone_brick_double_slab", red_sandstone_brick_slab, red_sandstone_brick_double_slab);
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
		register(desert_pillar);
		register(desert_quartz_stairs);
		registerSlab("desert_quartz_slab", "desert_quartz_double_slab", desert_quartz_slab, desert_quartz_double_slab);
		register(radiant_block);
		register(radiant_chiseled);
		register(radiant_pillar);
		registerSlab("radiant_quartz_slab", "radiant_quartz_double_slab", radiant_slab, radiant_double_slab);
		register(radiant_stairs);
		registerSlab("prismarine_slab", "prismarine_double_slab", prismarine_slab, prismarine_double_slab);
		register(prismarine_stairs);
		register(obsidian_bricks);
		register(glow_mossy_netherrack);
		register(glow_mossy_nether_bricks);
		register(glow_mossy_end_stone);
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
		register(glacierite_block);
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
		register(glaical_invincium);
		register(invincium);
		
		//Decor Tab
		register(shrub_grass);
		register(moss);
		register(hanging_moss);
		register(hanging_glow_moss);
		register(blueberry_bush);
		register(blackberry_bush);
		register(raspberry_bush);
		register(strawberry_bush);
		register(mana_bush);
		register(rice_crop);
		register(seaweed);
		GameRegistry.registerItem(rice, rice.getUnlocalizedName().substring(5));
		register(pepper_crop);
		GameRegistry.registerItem(pepper_seed, pepper_seed.getUnlocalizedName().substring(5));
		register(peanut_crop);
		GameRegistry.registerItem(peanuts, peanuts.getUnlocalizedName().substring(5));
		register(cabbage_crop);
		GameRegistry.registerItem(cabbage, cabbage.getUnlocalizedName().substring(5));
		register(onion_crop);
		GameRegistry.registerItem(onion, onion.getUnlocalizedName().substring(5));
		register(lettuce_crop);
		GameRegistry.registerItem(lettuce, lettuce.getUnlocalizedName().substring(5));
		register(celery_crop);
		GameRegistry.registerItem(celery_seed, celery_seed.getUnlocalizedName().substring(5));
		
		register(ministrapp_sapling, ItemBlockSapling.class);
		register(ministrapp_leaves, ItemBlockLeaves.class);
		
		register(dead_branch);
		register(cold_cobweb);
		register(pumpkin_carved, ItemBlockCarvedPumpkin.class);
		register(magnetic_torch);
		register(ministrapp_flower_pot);
		register(glacieric_ice_vein);
		register(redwood_fence);
		register(frozen_oak_fence);
		register(red_rock_wall);
		register(red_rock_wall_mossy);
		register(coldstone_wall);
		register(coldstone_wall_mossy);
		register(icestone_wall);
		register(icestone_wall_mossy);
		register(oceanstone_wall);
		register(oceanstone_wall_mossy);
		register(cardboard);
		register(refined_glass_pane);
		register(bricked_glass_pane);
		register(tiled_glass_pane);
		register(framed_glass_pane);
		register(glow_glass_pane);
		register(steel_mesh);
		register(rope);
		register(redwood_fence_gate);
		register(frozen_oak_fence_gate);
		register(redwood_door);
		register(frozen_door);
		register(glass_door);
		GameRegistry.registerItem(redwood_door_item, redwood_door_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(frozen_door_item, frozen_door_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(glass_door_item, glass_door_item.getUnlocalizedName().substring(5));
		register(crate);
		register(barrel);
		register(chimney);
		
		//Tech Tab
		register(fan);
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
		register(splitter);
		register(splitter_active);
		register(claimerator);
		register(block_flesh);
		register(block_flesh_reactive);
		register(block_bat);
		register(block_rabbit);
		register(block_chicken);
		register(block_cow);
		register(block_mooshroom);
		register(block_wolf);
		register(block_sheep_white);
		register(block_sheep_silver);
		register(block_sheep_grey);
		register(block_sheep_black);
		register(block_sheep_brown);
		register(block_sheep_pink);
		register(block_sheep_red);
		register(block_sheep_orange);
		register(block_sheep_yellow);
		register(block_sheep_lime);
		register(block_sheep_green);
		register(block_sheep_cyan);
		register(block_sheep_light_blue);
		register(block_sheep_blue);
		register(block_sheep_purple);
		register(block_sheep_magenta);
		
		//Foods Tab
		register(meat_block);
		
		//Building Tab (Slabs)
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
		
		//Tools Tab
		GameRegistry.registerBlock(magma, magma.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(magmaBucket, magmaBucket.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		for(Block block: blockList)
		{
			registerRender(block);
		}
		registerRender(redwood_door_item);
		registerRender(frozen_door_item);
		registerRender(glass_door_item);
		registerRender(magmaBucket);
		
		registerRender(rice);
		registerRender(pepper_seed);
		registerRender(peanuts);
		registerRender(onion);
		registerRender(cabbage);
		registerRender(lettuce);
		registerRender(celery_seed);
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
		moss.setHarvestLevel("shovel", 0);
		mud.setHarvestLevel("shovel", 0);
		mud_bricks.setHarvestLevel("shovel", 0);
		rubble.setHarvestLevel("pickaxe", 0);
		cold_sand.setHarvestLevel("shovel", 0);
		dirt_permafrost.setHarvestLevel("shovel", 0);
		lichen_permafrost.setHarvestLevel("shovel", 0);
		
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
		flint_block.setHarvestLevel("pickaxe", 1);
		flint_bricks.setHarvestLevel("pickaxe", 1);
		flint_pattern_bricks.setHarvestLevel("pickaxe", 1);
		flint_refined.setHarvestLevel("pickaxe", 1);
		flint_tiles.setHarvestLevel("pickaxe", 1);
		flint_chiseled.setHarvestLevel("pickaxe", 1);
		flint_lamp_sunstone.setHarvestLevel("pickaxe", 1);
		flint_lamp_glowstone.setHarvestLevel("pickaxe", 1);
		flint_lamp_prismarine.setHarvestLevel("pickaxe", 1);
		desert_quartz_block.setHarvestLevel("pickaxe", 0);
		desert_quartz_chiseled.setHarvestLevel("pickaxe", 0);
		desert_pillar.setHarvestLevel("pickaxe", 0);
		desert_quartz_stairs.setHarvestLevel("pickaxe", 0);
		radiant_block.setHarvestLevel("pickaxe", 3);
		radiant_chiseled.setHarvestLevel("pickaxe", 3);
		radiant_pillar.setHarvestLevel("pickaxe", 3);
		radiant_stairs.setHarvestLevel("pickaxe", 3);
		obsidian_bricks.setHarvestLevel("pickaxe", 3);
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
		glacierite_block.setHarvestLevel("pickaxe", 2);
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
		claimerator.setHarvestLevel("pickaxe", 2);
		frost_generator.setHarvestLevel("pickaxe", 2);
		
		glass_door.setHarvestLevel("pickaxe", 0);
		
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
		
		// Roads
		roads.setHarvestLevel("pickaxe", 0, roads.getStateFromMeta(MRoadType.COBBLE.getMetadata()));
		roads.setHarvestLevel("pickaxe", 0, roads.getStateFromMeta(MRoadType.SAND.getMetadata()));
		roads.setHarvestLevel("pickaxe", 0, roads.getStateFromMeta(MRoadType.REDSAND.getMetadata()));
		roads.setHarvestLevel("pickaxe", 0, roads.getStateFromMeta(MRoadType.GRAVEL.getMetadata()));
		roads.setHarvestLevel("pickaxe", 1, roads.getStateFromMeta(MRoadType.NETHER.getMetadata()));
		roads.setHarvestLevel("pickaxe", 3, roads.getStateFromMeta(MRoadType.SOUL.getMetadata()));
	}
	
	public static void registerSlab(String name, String name2, BlockMSlab one, BlockMDoubleSlab two)
	{
		GameRegistry.registerBlock(two, ItemBlockMSlab.class, name2, new Object[]{one, two});
		GameRegistry.registerBlock(one, ItemBlockMSlab.class, name, new Object[]{one, two});
		blockList.add(one);
		blockList.add(two);
	}
}
