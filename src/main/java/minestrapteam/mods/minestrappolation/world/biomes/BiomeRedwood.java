package minestrapteam.mods.minestrappolation.world.biomes;

import java.util.Random;

import minestrapteam.mods.minestrappolation.world.MBiomeDecorator;
import minestrapteam.mods.minestrappolation.world.WorldGenRedWoodTree;
import minestrapteam.mods.minestrappolation.world.WorldGenRedWoodTreeSmall;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeRedwood extends Biome
{
	
	public BiomeRedwood(BiomeProperties properties)
	{
		super(properties);
		
		this.theBiomeDecorator = new MBiomeDecorator();
		
		properties.setTemperature(1.0F);
		properties.setRainfall(2.0F);
		
		//this.setHeight(height_LowPlains);
		
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = Blocks.STONE.getDefaultState();
		
		this.theBiomeDecorator.flowersPerChunk = 5;
		this.theBiomeDecorator.treesPerChunk = 5;
		this.theBiomeDecorator.grassPerChunk = 11;
		this.theBiomeDecorator.deadBushPerChunk = 4;
	}
	
	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random random)
	{
		return random.nextInt(4) == 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos p_180627_1_)
	{
		return 1928747;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getFoliageColorAtPos(BlockPos p_180625_1_)
	{
		return 1928747;
	}
	
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer primer, int p_180622_4_, int p_180622_5_, double noise)
	{
		this.fillerBlock = Blocks.DIRT.getDefaultState();
		this.topBlock = Blocks.GRASS.getDefaultState();
		
		if (noise > 2.5D)
		{
			this.topBlock = Blocks.SAND.getDefaultState();
			this.fillerBlock = Blocks.SAND.getDefaultState();
		}
		else if (noise > -0.95D)
		{
			this.topBlock = Blocks.DIRT.getStateFromMeta(BlockDirt.DirtType.PODZOL.getMetadata());
		}
		
		this.generateBiomeTerrain(worldIn, rand, primer, p_180622_4_, p_180622_5_, noise);
	}
	
	@Override
	public WorldGenAbstractTree genBigTreeChance(Random random)
	{
		return random.nextInt(4) == 0 ? new WorldGenRedWoodTree() : random.nextInt(8) < 2 ? BiomeForest.BIG_TREE_FEATURE : new WorldGenRedWoodTreeSmall();
	}
	
}
