package minestrapteam.minestrappolation.world;

import java.util.Random;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeRedwood extends BiomeGenBase
{	
	public BiomeRedwood(int id)
	{
		super(id);
		
		this.theBiomeDecorator = new MBiomeDecorator();
		
		this.setTemperatureRainfall(1.0F, 2F);
		this.setHeight(height_LowPlains);
		this.enableSnow = false;
		
		this.topBlock = Blocks.grass.getDefaultState();
		this.fillerBlock = Blocks.stone.getDefaultState();
		
		this.theBiomeDecorator.flowersPerChunk = 5;
		this.theBiomeDecorator.treesPerChunk = 6;
		this.theBiomeDecorator.grassPerChunk = 11;
		this.theBiomeDecorator.deadBushPerChunk = 4;
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random random)
	{
		return random.nextInt(4) == 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
	}
	
	@Override
	public void genTerrainBlocks(World world, Random random, ChunkPrimer primer, int x, int y, double noise)
	{
		if (noise > 3.5D)
		{
			this.topBlock = Blocks.sand.getDefaultState();
			this.fillerBlock = Blocks.sand.getDefaultState();
		}
		else if (noise > -0.95D)
		{
			this.topBlock = Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
			this.fillerBlock = Blocks.dirt.getDefaultState();
		}
		else
		{
			this.topBlock = Blocks.grass.getDefaultState();
			this.fillerBlock = Blocks.dirt.getDefaultState();
		}
		
		this.genTerrainBlocks(world, random, primer, x, y, noise);
	}
	
	@Override
	public WorldGenAbstractTree genBigTreeChance(Random random)
	{
		return random.nextInt(4) == 0 ? new WorldGenRedwoodTree() : random.nextInt(8) < 2 ? this.worldGeneratorTrees : new WorldGenRedwoodTreeSmall();
	}
	
}
