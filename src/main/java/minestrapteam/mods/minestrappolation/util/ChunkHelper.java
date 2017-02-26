package minestrapteam.mods.minestrappolation.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

public class ChunkHelper 
{
	
	public static String getChunkBiomeForEntity(Entity entity)
	{
		BlockPos pos = new BlockPos(entity.getPosition());
		Chunk c = entity.world.getChunkFromBlockCoords(pos);
		return c.getBiome(pos, entity.world.getBiomeProvider()).getBiomeName();
	}
	
}
