package minestrapteam.minestrappolation.world;

import java.util.Random;

import minestrapteam.minestrappolation.block.BlockBiomeStones;
import minestrapteam.minestrappolation.block.MBlockOre;
import minestrapteam.minestrappolation.block.MStoneType;
import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
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
		this.generateOre(MBlocks.copper_ore, world, rand, x1, z1, 3, 12, 30, 15, 100, BlockHelper.forBlock(Blocks.stone));
		this.generateOre(MBlocks.tin_ore, world, rand, x1, z1, 3, 12, 30, 15, 100, BlockHelper.forBlock(Blocks.stone));
		this.generateOre(MBlocks.sunstone_ore, world, rand, x1, z1, 2, 4, 30, 1, 200, BlockHelper.forBlock(Blocks.stone));
		this.generateOre(MBlocks.slate, world, rand, x1, z1, 5, 25, 20, 1, 256, BlockHelper.forBlock(Blocks.stone));
		this.generateBoulder(world, rand, x1, z1);
	}
	
	public void generateNether(World world, Random rand, int x, int z)
	{
		
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
							chunk.setBlockState(subpos2, stoneBlock.withProperty(BlockBiomeStones.VARIANT, sType));
						}
					}
					else if (block instanceof BlockOre || block instanceof MBlockOre)
					{
						Block oreToReplace = getOreToReplace(block);
						
						if(y < deepStoneDepth)
						{
							chunk.setBlockState(subpos2, oreToReplace.getStateFromMeta(deepOreMeta));

						}
						else
						{
							chunk.setBlockState(subpos2, oreToReplace.getStateFromMeta(oreMeta));
						}
					}
				}
			}
		}
	}
	
	public Block getOreToReplace(Block block)
	{
		if(block == Blocks.coal_ore)
		{
			return MBlocks.biome_coal;
		}
		else if(block == Blocks.iron_ore)
		{
			return MBlocks.biome_iron;
		}
		else if(block == Blocks.gold_ore)
		{
			return MBlocks.biome_gold;
		}
		else if(block == Blocks.redstone_ore)
		{
			return MBlocks.biome_redstone;
		}
		else if(block == Blocks.diamond_ore)
		{
			return MBlocks.biome_diamond;
		}
		else if(block == Blocks.lapis_ore)
		{
			return MBlocks.biome_lapis;
		}
		else if(block == Blocks.emerald_ore)
		{
			return MBlocks.biome_emerald;
		}
		else if(block == MBlocks.sunstone_ore)
		{
			return MBlocks.biome_sunstone;
		}
		else if(block == MBlocks.tin_ore)
		{
			return MBlocks.biome_tin;
		}
		else if(block == MBlocks.biome_copper)
		{
			return MBlocks.biome_copper;
		}
		else if(block == MBlocks.plutonium_ore)
		{
			return MBlocks.biome_plutonium;
		}
		else if(block == MBlocks.uranium_ore)
		{
			return MBlocks.biome_uranium;
		}
		else if(block == MBlocks.radiant_ore)
		{
			return MBlocks.biome_radiant;
		}
		else if(block == MBlocks.torite_ore)
		{
			return MBlocks.biome_torite;
		}
		else if(block == MBlocks.titanium_ore)
		{
			return MBlocks.biome_torite;
		}
		else if(block == MBlocks.torite_ore)
		{
			return MBlocks.biome_meurodite;
		}
		else
		{
			return MBlocks.biome_copper;
		}
	}
	
}
