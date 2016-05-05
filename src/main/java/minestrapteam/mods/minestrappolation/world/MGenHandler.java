package minestrapteam.mods.minestrappolation.world;

import com.google.common.base.Predicate;
import minestrapteam.mods.minestrappolation.Config;
import minestrapteam.mods.minestrappolation.api.MRegistry;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeStones;
import minestrapteam.mods.minestrappolation.block.ore.BlockPlutoniumOre;
import minestrapteam.mods.minestrappolation.block.ore.BlockUraniumOre;
import minestrapteam.mods.minestrappolation.block.ore.MBlockOre;
import minestrapteam.mods.minestrappolation.enumtypes.MStoneType;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MGenHandler implements IWorldGenerator
{

	public static Map<Block, Block> oreReplacements = new HashMap();

	public static void load()
	{
		GameRegistry.registerWorldGenerator(new MGenHandler(), 0);
		loadOreMOreReplacement();
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		// chunkX <<= 4;
		// chunkZ <<= 4;
		BlockPos pos = new BlockPos(chunkX, 1, chunkZ);
		if (chunkGenerator instanceof ChunkProviderGenerate)
		{
			this.generateOverworld(world, random, chunkX, chunkZ);
			if (Config.genBiomeStones == true)
			{
				this.genBiomeStone(world, chunkX, chunkZ, random);
			}
		}
		else if (chunkGenerator instanceof ChunkProviderHell)
		{
			this.generateNether(world, random, chunkX, chunkZ);
		}
		else if (chunkGenerator instanceof ChunkProviderEnd)
		{
			this.generateEnd(world, random, chunkX, chunkZ);
		}
	}

	public void generateEnd(World world, Random rand, int x, int z)
	{
		int x1 = x;
		int y1 = 0;
		int z1 = z;
		this.generateHangingMoss(world, rand, x1, z1, MBlocks.hanging_glow_moss);

		this.generateOre(MBlocks.continnium_ore, world, rand, x1, z1, 3, 12, 3, 15, 100,
		                 BlockHelper.forBlock(Blocks.end_stone), Config.genContinnium);
		this.generateOre(MBlocks.dimensium_ore, world, rand, x1, z1, 3, 12, 3, 15, 100,
		                 BlockHelper.forBlock(Blocks.end_stone), Config.genDimensium);
	}

	public void generateOverworld(World world, Random rand, int x, int z)
	{
		int x1 = x;
		int y1 = 0;
		int z1 = z;
		BlockPos pos = new BlockPos(x1 * 16, 0, z1 * 16);
		Chunk chunk = world.getChunkFromBlockCoords(pos);
		WorldChunkManager chunkManager = world.getWorldChunkManager();
		BiomeGenBase biome = chunk.getBiome(pos, chunkManager);

		this.generateOre(MBlocks.copper_ore, world, rand, x1, z1, 3, 12, 20, 15, 100,
		                 BlockHelper.forBlock(Blocks.stone), Config.genCopper);
		this.generateOre(MBlocks.tin_ore, world, rand, x1, z1, 3, 12, 24, 15, 100, BlockHelper.forBlock(Blocks.stone),
		                 Config.genTin);
		this.generateOre(MBlocks.meurodite_ore, world, rand, x1, z1, 1, 9, 10, 1, 32,
		                 BlockHelper.forBlock(Blocks.stone), Config.genMeurodite);
		this.generateOre(MBlocks.sunstone_ore, world, rand, x1, z1, 2, 4, 20, 1, 200,
		                 BlockHelper.forBlock(Blocks.stone), Config.genSunstone);

		this.generateOre(MBlocks.plutonium_ore, world, rand, x1, z1, 1, 4, 15, 1, 32,
		                 BlockHelper.forBlock(Blocks.stone), Config.genPlutonium);
		this.generateOre(MBlocks.uranium_ore, world, rand, x1, z1, 1, 4, 15, 1, 32, BlockHelper.forBlock(Blocks.stone),
		                 Config.genUranium);
		this.generateOre(MBlocks.radiant_ore, world, rand, x1, z1, 1, 4, 10, 15, 128,
		                 BlockHelper.forBlock(Blocks.stone), Config.genRadiant);
		this.generateOre(MBlocks.titanium_ore, world, rand, x1, z1, 1, 4, 12, 1, 10, BlockHelper.forBlock(Blocks.stone),
		                 Config.genTitanium);
		this.generateOre(MBlocks.slate, world, rand, x1, z1, 10, 33, 18, 0, 80, BlockHelper.forBlock(Blocks.stone),
		                 Config.genSlate);
		this.generateOre(MBlocks.rubble, world, rand, x1, z1, 1, 10, 90, 0, 256, BlockHelper.forBlock(Blocks.gravel),
		                 Config.genRubble);
		this.generateOre(MBlocks.rubble, world, rand, x1, z1, 10, 50, 30, 0, 256,
		                 BlockHelper.forBlock(Blocks.stonebrick), Config.genRubble);
		this.generateBoulder(world, rand, x1, z1);

		if (biome == BiomeGenBase.ocean || biome == BiomeGenBase.river || biome == BiomeGenBase.deepOcean
			    || biome == BiomeGenBase.swampland)
		{
			this.generateSeaweed(world, rand, x1, z1);
		}

		if (biome == BiomeGenBase.jungle || biome == BiomeGenBase.jungleEdge || biome == BiomeGenBase.jungleHills
			    || biome == BiomeGenBase.swampland || biome == BiomeGenBase.roofedForest
			    || biome == MBiomeManager.redwood)
		{
			this.generateOre(MBlocks.torite_ore, world, rand, x1, z1, 1, 6, 4, 1, 20,
			                 BlockHelper.forBlock(Blocks.stone), Config.genTorite);
			this.generateHangingMoss(world, rand, x1, z1, MBlocks.hanging_moss);
		}
		if (biome == BiomeGenBase.desert || biome == BiomeGenBase.desertHills || biome == MBiomeManager.redwood)
		{
			this.generateDesertQuartz(world, rand, x1, z1);
		}
		if (biome == BiomeGenBase.forest || biome == BiomeGenBase.megaTaiga || biome == BiomeGenBase.megaTaigaHills
			    || biome == BiomeGenBase.swampland || biome == MBiomeManager.redwood)
		{
			this.generateMoss(world, rand, x1, z1);
		}

		//Berries
		if (biome == BiomeGenBase.forest || biome == BiomeGenBase.forestHills || biome == BiomeGenBase.birchForest
			    || biome == BiomeGenBase.birchForestHills)
		{
			this.generateBerries(world, rand, x1, z1, new WorldGenBush(MBlocks.blueberry_bush));
		}
		if (biome == BiomeGenBase.roofedForest || biome == BiomeGenBase.swampland)
		{
			this.generateBerries(world, rand, x1, z1, new WorldGenBush(MBlocks.strawberry_bush));
		}
		if (biome == BiomeGenBase.extremeHills || biome == BiomeGenBase.extremeHillsEdge
			    || biome == BiomeGenBase.extremeHillsPlus || biome == BiomeGenBase.taiga
			    || biome == BiomeGenBase.taigaHills || biome == BiomeGenBase.megaTaiga
			    || biome == BiomeGenBase.megaTaigaHills)
		{
			this.generateBerries(world, rand, x1, z1, new WorldGenBush(MBlocks.blackberry_bush));
			if (biome == BiomeGenBase.extremeHills || biome == BiomeGenBase.extremeHillsEdge
				    || biome == BiomeGenBase.extremeHillsPlus || biome == BiomeGenBase.taigaHills)
			{
				new WorldGenRedWoodTreeSmall().generate(world, rand, pos);
				this.generateHangingMoss(world, rand, x1, z1, MBlocks.hanging_moss);
			}
		}
		if (biome == BiomeGenBase.savanna || biome == BiomeGenBase.savannaPlateau || biome == BiomeGenBase.mesa
			    || biome == BiomeGenBase.mesaPlateau || biome == BiomeGenBase.mesaPlateau_F
			    || biome == MBiomeManager.redwood)
		{
			this.generateBerries(world, rand, x1, z1, new WorldGenBush(MBlocks.raspberry_bush));
		}
		if (biome == BiomeGenBase.mushroomIsland || biome == BiomeGenBase.mushroomIslandShore
			    || biome == BiomeGenBase.deepOcean || biome == BiomeGenBase.ocean)
		{
			this.generateBerries(world, rand, x1, z1, new WorldGenBush(MBlocks.mana_bush));
		}

		if (biome == MBiomeManager.frost)
		{
			new WorldGenIceMound().generate(world, rand, pos);
		}

		if (biome == BiomeGenBase.swampland || biome == BiomeGenBase.river || biome == BiomeGenBase.frozenRiver)
		{
			this.generateMud(world, rand, x1, z1, 4, 10, 20, 50, 64, Config.genMud);
		}

		for (x1 = 0; x1 < 16; x1++)
		{
			for (z1 = 0; z1 < 16; z1++)
			{
				chunk.setBlockState(pos.add(chunk.xPosition + x1, 0, chunk.zPosition + z1),
				                    MBlocks.invincium.getDefaultState());
			}
		}
	}

	public void generateNether(World world, Random rand, int x, int z)
	{
		int x1 = x;
		int y1 = 0;
		int z1 = z;
		this.generateOre(MBlocks.blazium_ore, world, rand, x1, z1, 1, 10, 15, 0, 128,
		                 BlockHelper.forBlock(Blocks.netherrack), true);
		this.generateOre(MBlocks.glow_mossy_netherrack, world, rand, x1, z1, 5, 20, 2, 0, 128,
		                 BlockHelper.forBlock(Blocks.netherrack), true);
		this.generateOre(MBlocks.glow_mossy_nether_bricks, world, rand, x1, z1, 5, 20, 30, 0, 100,
		                 BlockHelper.forBlock(Blocks.nether_brick), true);
		this.generateOre(MBlocks.soul_ore, world, rand, x1, z1, 3, 8, 30, 0, 128,
		                 BlockHelper.forBlock(Blocks.soul_sand), true);
		this.generateHangingMoss(world, rand, x1, z1, MBlocks.hanging_glow_moss);
		this.genGlowShrooms(world, rand, x1, z1);
	}

	private void generateOre(Block block, World world, Random rand, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Predicate blockType, boolean generate)
	{
		if (generate == true)
		{
			int vienSize = minVienSize + rand.nextInt(maxVienSize - minVienSize);
			int heightRange = maxY - minY;
			WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), vienSize, blockType);
			for (int i = 0; i < chance; i++)
			{
				int xRand = chunkX * 16 + rand.nextInt(16);
				int yRand = rand.nextInt(heightRange) + minY;
				int zRand = chunkZ * 16 + rand.nextInt(16);
				BlockPos position = new BlockPos(xRand, yRand, zRand);
				gen.generate(world, rand, position);
			}
		}
	}

	private void generateMud(World world, Random rand, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, boolean generate)
	{
		if (generate == true)
		{
			int vienSize = minVienSize + rand.nextInt(maxVienSize - minVienSize);
			int heightRange = maxY - minY;
			WorldGenMud gen = new WorldGenMud(vienSize);
			for (int i = 0; i < chance; i++)
			{
				int xRand = chunkX * 16 + rand.nextInt(16);
				int yRand = rand.nextInt(heightRange) + minY;
				int zRand = chunkZ * 16 + rand.nextInt(16);
				BlockPos position = new BlockPos(xRand, yRand, zRand);
				gen.generate(world, rand, position);
			}
		}
	}

	private void generateBoulder(World world, Random rand, int chunkX, int chunkZ)
	{
		WorldGenBoulder gen = new WorldGenBoulder();
		for (int i = 0; i < 1; i++)
		{
			int xRand = chunkX * 16 + rand.nextInt(16);
			int yRand = rand.nextInt(100);
			int zRand = chunkZ * 16 + rand.nextInt(16);
			BlockPos position = new BlockPos(xRand, yRand, zRand);
			gen.generate(world, rand, position);
		}
	}

	private void generateDesertQuartz(World world, Random rand, int chunkX, int chunkZ)
	{
		WorldGenSpire gen = new WorldGenSpire(MBlocks.desert_quartz, Blocks.sand);
		for (int i = 0; i < 6; i++)
		{
			int xRand = chunkX * 16 + rand.nextInt(16);
			int yRand = rand.nextInt(100);
			int zRand = chunkZ * 16 + rand.nextInt(16);
			BlockPos position = new BlockPos(xRand, yRand, zRand);
			gen.generate(world, rand, position);
		}
	}

	private void generateMoss(World world, Random rand, int chunkX, int chunkZ)
	{
		WorldGenMoss gen = new WorldGenMoss();
		for (int i = 0; i < 5; i++)
		{
			int xRand = chunkX * 16 + rand.nextInt(16);
			int yRand = rand.nextInt(256);
			int zRand = chunkZ * 16 + rand.nextInt(16);
			BlockPos position = new BlockPos(xRand, yRand, zRand);
			gen.generate(world, rand, position);
		}
	}

	private void generateSeaweed(World world, Random rand, int chunkX, int chunkZ)
	{
		WorldGenSeaweed gen = new WorldGenSeaweed();
		for (int i = 0; i < 5; i++)
		{
			int xRand = chunkX * 16 + rand.nextInt(16);
			int yRand = rand.nextInt(63);
			int zRand = chunkZ * 16 + rand.nextInt(16);
			BlockPos position = new BlockPos(xRand, yRand, zRand);
			gen.generate(world, rand, position);
		}
	}

	private void generateHangingMoss(World world, Random rand, int chunkX, int chunkZ, Block block)
	{
		WorldGenHangingMoss gen = new WorldGenHangingMoss(block);
		int chance;
		if (block == MBlocks.hanging_glow_moss)
			chance = 3;
		else
			chance = 7;
		for (int i = 0; i < chance; i++)
		{
			int xRand = chunkX * 16 + rand.nextInt(16);
			int yRand = rand.nextInt(128);
			int zRand = chunkZ * 16 + rand.nextInt(16);
			BlockPos position = new BlockPos(xRand, yRand, zRand);
			gen.generate(world, rand, position);
		}
	}

	private void genGlowShrooms(World world, Random rand, int chunkX, int chunkZ)
	{
		WorldGenGlowShrooms gen = new WorldGenGlowShrooms();
		for (int i = 0; i < 10; i++)
		{
			int xRand = chunkX * 16 + rand.nextInt(16);
			int yRand = rand.nextInt(256);
			int zRand = chunkZ * 16 + rand.nextInt(16);
			BlockPos position = new BlockPos(xRand, yRand, zRand);
			gen.generate(world, rand, position);
		}
	}

	private void generateBerries(World world, Random rand, int chunkX, int chunkZ, WorldGenerator berry)
	{
		WorldGenerator gen = berry;
		for (int i = 0; i < 2; i++)
		{
			int xRand = chunkX * 16 + rand.nextInt(16);
			int yRand = rand.nextInt(256);
			int zRand = chunkZ * 16 + rand.nextInt(16);
			BlockPos position = new BlockPos(xRand, yRand, zRand);
			gen.generate(world, rand, position);
		}
	}

	public void genBiomeStone(World world, int chunkX, int chunkZ, Random random)
	{
		BlockPos pos = new BlockPos(chunkX * 16, 0, chunkZ * 16);
		Chunk chunk = world.getChunkFromBlockCoords(pos);
		WorldChunkManager chunkManager = world.getWorldChunkManager();

		for (int x = 0; x < 16; x++)
		{
			for (int z = 0; z < 16; z++)
			{
				BlockPos subpos = new BlockPos(x, 0, z);
				BiomeGenBase biome = chunk.getBiome(subpos, chunkManager);
				IBlockState stoneBlock = MBlocks.biome_stones.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata());
				IBlockState deepStoneBlock = MBlocks.biome_stones.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata());
				MStoneType sType = MStoneType.DEEPSTONE;
				MStoneType dType = MStoneType.DEEPSTONE;
				int deepStoneDepth = 0;
				int oreMeta = MStoneType.DEEPSTONE.getMetadata();
				int deepOreMeta = MStoneType.DEEPSTONE.getMetadata();
				Block ore;

				if (biome.temperature < 0.2F)
				{
					stoneBlock = MBlocks.biome_stones.getStateFromMeta(MStoneType.ICESTONE.getMetadata());
					deepStoneBlock = MBlocks.biome_stones.getStateFromMeta(MStoneType.GLACIERSTONE.getMetadata());
					sType = MStoneType.ICESTONE;
					dType = MStoneType.GLACIERSTONE;
					deepStoneDepth = random.nextInt(5) + 30;
					oreMeta = MStoneType.ICESTONE.getMetadata();
					deepOreMeta = MStoneType.GLACIERSTONE.getMetadata();
				}
				else if (biome.temperature < 0.4F)
				{
					stoneBlock = MBlocks.biome_stones.getStateFromMeta(MStoneType.COLDSTONE.getMetadata());
					deepStoneBlock = MBlocks.biome_stones.getStateFromMeta(MStoneType.DEEPCOLDSTONE.getMetadata());
					deepStoneDepth = random.nextInt(5) + 35;
					sType = MStoneType.COLDSTONE;
					dType = MStoneType.DEEPCOLDSTONE;
					oreMeta = MStoneType.COLDSTONE.getMetadata();
					deepOreMeta = MStoneType.DEEPCOLDSTONE.getMetadata();
				}
				else if (biome.getTempCategory() == TempCategory.OCEAN)
				{
					stoneBlock = MBlocks.biome_stones.getStateFromMeta(MStoneType.OCEANSTONE.getMetadata());
					deepStoneBlock = MBlocks.biome_stones.getStateFromMeta(MStoneType.POCEANSTONE.getMetadata());
					deepStoneDepth = random.nextInt(5) + 20;
					sType = MStoneType.OCEANSTONE;
					dType = MStoneType.POCEANSTONE;
					oreMeta = MStoneType.OCEANSTONE.getMetadata();
					deepOreMeta = MStoneType.POCEANSTONE.getMetadata();
				}
				else if (biome.temperature >= 1.0F)
				{
					stoneBlock = MBlocks.biome_stones.getStateFromMeta(MStoneType.REDROCK.getMetadata());
					deepStoneBlock = MBlocks.biome_stones.getStateFromMeta(MStoneType.DEEPREDROCK.getMetadata());
					deepStoneDepth = random.nextInt(5) + 35;
					sType = MStoneType.REDROCK;
					dType = MStoneType.DEEPREDROCK;
					oreMeta = MStoneType.REDROCK.getMetadata();
					deepOreMeta = MStoneType.DEEPREDROCK.getMetadata();
				}
				else
				{
					deepStoneBlock = MBlocks.biome_stones.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata());
					deepStoneDepth = random.nextInt(5) + 35;
					dType = MStoneType.DEEPSTONE;
				}

				for (int y = 256; y >= 0; y--)
				{
					BlockPos subpos2 = new BlockPos(x, y, z);
					Block block = chunk.getBlock(x, y, z);
					IBlockState state = chunk.getBlockState(subpos2);

					if (state == Blocks.stone.getDefaultState())
					{
						if (y < deepStoneDepth)
						{
							chunk.setBlockState(subpos2, deepStoneBlock.withProperty(BlockBiomeStones.VARIANT, dType));
						}
						else
						{
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F
								    || biome.getTempCategory() == TempCategory.OCEAN)
							{
								chunk.setBlockState(subpos2, stoneBlock.withProperty(BlockBiomeStones.VARIANT, sType));
							}
						}
					}
					else if (block instanceof BlockOre || block instanceof MBlockOre && block != MBlocks.desert_quartz
						         || block instanceof BlockPlutoniumOre || block instanceof BlockUraniumOre
						         || block instanceof BlockRedstoneOre)
					{
						Block oreToReplace = this.getOreToReplace(block);
						if (!oreReplacements.containsKey(block))
						{
							oreMeta = 0;
							deepOreMeta = 0;
						}

						if (y < deepStoneDepth)
						{
							chunk.setBlockState(subpos2, oreToReplace.getStateFromMeta(deepOreMeta));
						}
						else
						{
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F
								    || biome.getTempCategory() == TempCategory.OCEAN)
							{
								chunk.setBlockState(subpos2, oreToReplace.getStateFromMeta(oreMeta));
							}
						}
					}
					else if (block == Blocks.cobblestone)
					{
						if (y < deepStoneDepth)
						{
							chunk.setBlockState(subpos2, MBlocks.biome_cobble.getStateFromMeta(deepOreMeta));
						}
						else
						{
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F
								    || biome.getTempCategory() == TempCategory.OCEAN)
							{
								chunk.setBlockState(subpos2, MBlocks.biome_cobble.getStateFromMeta(oreMeta));
							}
						}
					}
					else if (block == Blocks.mossy_cobblestone)
					{
						if (y < deepStoneDepth)
						{
							chunk.setBlockState(subpos2, MBlocks.mossy.getStateFromMeta(deepOreMeta));
						}
						else
						{
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F
								    || biome.getTempCategory() == TempCategory.OCEAN)
							{
								chunk.setBlockState(subpos2, MBlocks.mossy.getStateFromMeta(oreMeta));
							}
						}
					}
					else if (block == Blocks.stonebrick.getStateFromMeta(0))
					{
						if (y < deepStoneDepth)
						{
							chunk.setBlockState(subpos2, MBlocks.biome_bricks.getStateFromMeta(deepOreMeta));
						}
						else
						{
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F
								    || biome.getTempCategory() == TempCategory.OCEAN)
							{
								chunk.setBlockState(subpos2, MBlocks.biome_bricks.getStateFromMeta(oreMeta));
							}
						}
					}
					else if (block == Blocks.stonebrick.getStateFromMeta(1))
					{
						if (y < deepStoneDepth)
						{
							chunk.setBlockState(subpos2, MBlocks.cracked_bricks.getStateFromMeta(deepOreMeta));
						}
						else
						{
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F
								    || biome.getTempCategory() == TempCategory.OCEAN)
							{
								chunk.setBlockState(subpos2, MBlocks.cracked_bricks.getStateFromMeta(oreMeta));
							}
						}
					}
					else if (block == Blocks.stonebrick.getStateFromMeta(2))
					{
						if (y < deepStoneDepth)
						{
							chunk.setBlockState(subpos2, MBlocks.mossy_bricks.getStateFromMeta(deepOreMeta));
						}
						else
						{
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F
								    || biome.getTempCategory() == TempCategory.OCEAN)
							{
								chunk.setBlockState(subpos2, MBlocks.mossy_bricks.getStateFromMeta(oreMeta));
							}
						}
					}
					else if (biome.temperature < 0.2F)
					{
						if (block == Blocks.dirt)
							chunk.setBlockState(subpos2, MBlocks.dirt_permafrost.getDefaultState());
						else if (block == Blocks.grass)
							chunk.setBlockState(subpos2, MBlocks.lichen_permafrost.getDefaultState());
						else if (state == Blocks.sand.getStateFromMeta(0))
							chunk.setBlockState(subpos2, MBlocks.cold_sand.getStateFromMeta(0));
						else if (state == Blocks.sand.getStateFromMeta(1))
							chunk.setBlockState(subpos2, MBlocks.cold_sand.getStateFromMeta(1));
						else if (block == Blocks.web)
							chunk.setBlockState(subpos2, MBlocks.cold_cobweb.getDefaultState());
						else if (block == Blocks.tallgrass || block == Blocks.red_flower
							         || block == Blocks.yellow_flower)
							chunk.setBlockState(subpos2, MBlocks.shrub_grass.getDefaultState());
					}
				}
			}
		}
	}

	public static void loadOreMOreReplacement()
	{
		MRegistry.registerBiomeOreReplacement(Blocks.coal_ore, MBlocks.biome_coal);
		MRegistry.registerBiomeOreReplacement(Blocks.iron_ore, MBlocks.biome_iron);
		MRegistry.registerBiomeOreReplacement(Blocks.gold_ore, MBlocks.biome_gold);
		MRegistry.registerBiomeOreReplacement(Blocks.redstone_ore, MBlocks.biome_redstone);
		MRegistry.registerBiomeOreReplacement(Blocks.lit_redstone_ore, MBlocks.biome_redstone);
		MRegistry.registerBiomeOreReplacement(Blocks.diamond_ore, MBlocks.biome_diamond);
		MRegistry.registerBiomeOreReplacement(Blocks.lapis_ore, MBlocks.biome_lapis);
		MRegistry.registerBiomeOreReplacement(Blocks.emerald_ore, MBlocks.biome_emerald);
		MRegistry.registerBiomeOreReplacement(MBlocks.sunstone_ore, MBlocks.biome_sunstone);
		MRegistry.registerBiomeOreReplacement(MBlocks.tin_ore, MBlocks.biome_tin);
		MRegistry.registerBiomeOreReplacement(MBlocks.copper_ore, MBlocks.biome_copper);
		MRegistry.registerBiomeOreReplacement(MBlocks.plutonium_ore, MBlocks.biome_plutonium);
		MRegistry.registerBiomeOreReplacement(MBlocks.uranium_ore, MBlocks.biome_uranium);
		MRegistry.registerBiomeOreReplacement(MBlocks.radiant_ore, MBlocks.biome_radiant);
		MRegistry.registerBiomeOreReplacement(MBlocks.torite_ore, MBlocks.biome_torite);
		MRegistry.registerBiomeOreReplacement(MBlocks.titanium_ore, MBlocks.biome_titanium);
		MRegistry.registerBiomeOreReplacement(MBlocks.meurodite_ore, MBlocks.biome_meurodite);
	}

	public Block getOreToReplace(Block block)
	{
		if (!oreReplacements.containsKey(block))
		{
			return block;
		}
		return oreReplacements.get(block);
	}
}
