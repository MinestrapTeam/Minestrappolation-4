package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.ChunkProtector;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockClaimerator extends MBlock
{

	public BlockClaimerator(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn, mapColorIn);
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
		ChunkProtector.protectChunk(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition, placer.getName());
		return this.getDefaultState();
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) 
	{
		ChunkProtector.unprotectChunk(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition);
	}
}
