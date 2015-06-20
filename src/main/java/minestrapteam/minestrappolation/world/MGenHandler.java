package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.minestrappolation.block.BiomeOres.BlockBiomeStones;
import minestrapteam.minestrappolation.block.ore.BlockPlutoniumOre;
import minestrapteam.minestrappolation.block.ore.BlockUraniumOre;
import minestrapteam.minestrappolation.block.ore.MBlockOre;
import minestrapteam.minestrappolation.enumtypes.MStoneType;
import minestrapteam.minestrappolation.lib.MBlocks;
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
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.google.common.base.Predicate;

public class MGenHandler implements IWorldGenerator
{
	
	public static void load()
	{
		GameRegistry.registerWorldGenerator(new MGenHandler(), 0);
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
			this.genBiomeStone(world, chunkX, chunkZ, random);
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
		
		this.generateOre(MBlocks.copper_ore, world, rand, x1, z1, 3, 12, 20, 15, 100, BlockHelper.forBlock(Blocks.stone));
		this.generateOre(MBlocks.tin_ore, world, rand, x1, z1, 3, 12, 24, 15, 100, BlockHelper.forBlock(Blocks.stone));
		this.generateOre(MBlocks.meurodite_ore, world, rand, x1, z1, 1, 9, 10, 1, 32, BlockHelper.forBlock(Blocks.stone));
		this.generateOre(MBlocks.sunstone_ore, world, rand, x1, z1, 2, 4, 20, 1, 200, BlockHelper.forBlock(Blocks.stone));
		
		this.generateOre(MBlocks.plutonium_ore, world, rand, x1, z1, 1, 4, 15, 1, 32, BlockHelper.forBlock(Blocks.stone));
		this.generateOre(MBlocks.uranium_ore, world, rand, x1, z1, 1, 4, 15, 1, 32, BlockHelper.forBlock(Blocks.stone));
		this.generateOre(MBlocks.radiant_ore, world, rand, x1, z1, 1, 4, 10, 15, 128, BlockHelper.forBlock(Blocks.stone));
		this.generateOre(MBlocks.titanium_ore, world, rand, x1, z1, 1, 4, 12, 1, 10, BlockHelper.forBlock(Blocks.stone));
		this.generateOre(MBlocks.slate, world, rand, x1, z1, 10, 33, 18, 0, 80, BlockHelper.forBlock(Blocks.stone));
		this.generateBoulder(world, rand, x1, z1);
		
		if (biome == BiomeGenBase.jungle || biome == BiomeGenBase.jungleEdge || biome == BiomeGenBase.jungleHills || biome == BiomeGenBase.swampland || biome == BiomeGenBase.roofedForest || biome == MBiomeManager.redwood)
		{
			this.generateOre(MBlocks.torite_ore, world, rand, x1, z1, 1, 6, 4, 1, 20, BlockHelper.forBlock(Blocks.stone));
		}
		if (biome == BiomeGenBase.desert || biome == BiomeGenBase.desertHills || biome == MBiomeManager.redwood)
		{
			this.generateDesertQuartz(world, rand, x1, z1);
		}
		if (biome == BiomeGenBase.forest || biome == BiomeGenBase.megaTaiga || biome == BiomeGenBase.megaTaigaHills || biome == BiomeGenBase.swampland || biome == MBiomeManager.redwood)
		{
			this.generateMoss(world, rand, x1, z1);
		}
		// Redwood Trees
		if (biome instanceof BiomeGenHills || biome instanceof BiomeGenTaiga)
		{
			new WorldGenRedWoodTreeSmall().generate(world, rand, pos);
		}
		
		for (x1 = 0; x1 < 16; x1++)
		{
			for (z1 = 0; z1 < 16; z1++)
			{
				chunk.setBlockState(pos.add(chunk.xPosition + x1, 0, chunk.zPosition + z1), MBlocks.invincium.getDefaultState());
			}
		}
	}
	
	public void generateNether(World world, Random rand, int x, int z)
	{
		int x1 = x;
		int y1 = 0;
		int z1 = z;
		this.generateOre(MBlocks.blazium_ore, world, rand, x1, z1, 1, 10, 15, 0, 128, BlockHelper.forBlock(Blocks.netherrack));
		this.generateOre(MBlocks.soul_ore, world, rand, x1, z1, 3, 8, 30, 0, 128, BlockHelper.forBlock(Blocks.soul_sand));
	}
	
	private void generateOre(Block block, World world, Random rand, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Predicate blockType)
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
					;
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
					;
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
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F || biome.getTempCategory() == TempCategory.OCEAN)
							{
								chunk.setBlockState(subpos2, stoneBlock.withProperty(BlockBiomeStones.VARIANT, sType));
							}
						}
					}
					else if (block instanceof BlockOre || block instanceof MBlockOre && block != MBlocks.desert_quartz || block instanceof BlockPlutoniumOre || block instanceof BlockUraniumOre || block instanceof BlockRedstoneOre)
					{
						Block oreToReplace = this.getOreToReplace(block);
						
						if (y < deepStoneDepth)
						{
							chunk.setBlockState(subpos2, oreToReplace.getStateFromMeta(deepOreMeta));
							
						}
						else
						{
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F || biome.getTempCategory() == TempCategory.OCEAN)
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
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F || biome.getTempCategory() == TempCategory.OCEAN)
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
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F || biome.getTempCategory() == TempCategory.OCEAN)
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
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F || biome.getTempCategory() == TempCategory.OCEAN)
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
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F || biome.getTempCategory() == TempCategory.OCEAN)
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
							if (biome.temperature >= 1.0F || biome.temperature < 0.4F || biome.getTempCategory() == TempCategory.OCEAN)
							{
								chunk.setBlockState(subpos2, MBlocks.mossy_bricks.getStateFromMeta(oreMeta));
							}
						}
					}
				}
			}
		}
	}
	
	public Block getOreToReplace(Block block)
	{
		if (block == Blocks.coal_ore)
			return MBlocks.biome_coal;
		else if (block == Blocks.iron_ore)
			return MBlocks.biome_iron;
		else if (block == Blocks.gold_ore)
			return MBlocks.biome_gold;
		else if (block == Blocks.redstone_ore)
			return MBlocks.biome_redstone;
		else if (block == Blocks.lit_redstone_ore)
			return MBlocks.biome_redstone;
		else if (block == Blocks.diamond_ore)
			return MBlocks.biome_diamond;
		else if (block == Blocks.lapis_ore)
			return MBlocks.biome_lapis;
		else if (block == Blocks.emerald_ore)
			return MBlocks.biome_emerald;
		else if (block == MBlocks.sunstone_ore)
			return MBlocks.biome_sunstone;
		else if (block == MBlocks.tin_ore)
			return MBlocks.biome_tin;
		else if (block == MBlocks.copper_ore)
			return MBlocks.biome_copper;
		else if (block == MBlocks.plutonium_ore)
			return MBlocks.biome_plutonium;
		else if (block == MBlocks.uranium_ore)
			return MBlocks.biome_uranium;
		else if (block == MBlocks.radiant_ore)
			return MBlocks.biome_radiant;
		else if (block == MBlocks.torite_ore)
			return MBlocks.biome_torite;
		else if (block == MBlocks.titanium_ore)
			return MBlocks.biome_titanium;
		else if (block == MBlocks.meurodite_ore)
			return MBlocks.biome_meurodite;
		else
			return MBlocks.biome_bricks;
	}
	
}
