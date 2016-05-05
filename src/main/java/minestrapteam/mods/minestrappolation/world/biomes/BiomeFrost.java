package minestrapteam.mods.minestrappolation.world.biomes;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.world.MBiomeDecorator;
import minestrapteam.mods.minestrappolation.world.WorldGenFrostTree;
import minestrapteam.mods.minestrappolation.world.WorldGenIceMound;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeFrost extends BiomeGenBase
{

	public BiomeFrost(int id)
	{
		super(id);
		this.theBiomeDecorator = new MBiomeDecorator();

		this.setTemperatureRainfall(0.0F, 0.5F);
		this.setHeight(height_LowPlains);
		this.enableSnow = true;

		this.topBlock = MBlocks.lichen_permafrost.getDefaultState();
		this.fillerBlock = Blocks.stone.getDefaultState();

		this.theBiomeDecorator.flowersPerChunk = 0;
		this.theBiomeDecorator.treesPerChunk = 1;
		this.theBiomeDecorator.grassPerChunk = 1;
	}

	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos)
	{
		super.decorate(worldIn, rand, pos);
		if (rand.nextInt(20) == 0)
		{
			int i = rand.nextInt(16) + 8;
			int j = rand.nextInt(16) + 8;
			BlockPos blockpos1 = worldIn.getHeight(pos.add(i, -1, j));
			(new WorldGenIceMound()).generate(worldIn, rand, blockpos1);
		}
	}

	@Override
	public WorldGenAbstractTree genBigTreeChance(Random random)
	{
		return random.nextInt(4) == 0 ? this.worldGeneratorTrees : new WorldGenFrostTree();
	}

	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer primer, int p_180622_4_, int p_180622_5_, double noise)
	{
		this.fillerBlock = MBlocks.dirt_permafrost.getDefaultState();
		this.topBlock = MBlocks.lichen_permafrost.getDefaultState();

		if (noise > 2.5D)
		{
			this.topBlock = MBlocks.cold_sand.getDefaultState();
			this.fillerBlock = MBlocks.cold_sand.getDefaultState();
		}

		this.generateBiomeTerrain(worldIn, rand, primer, p_180622_4_, p_180622_5_, noise);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos p_180627_1_)
	{
		return 10420217;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getFoliageColorAtPos(BlockPos p_180625_1_)
	{
		return 10420217;
	}
}
