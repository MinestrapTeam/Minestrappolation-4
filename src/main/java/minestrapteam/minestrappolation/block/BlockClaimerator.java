package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.ChunkProtector;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
		if(placer instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)placer;
			ChunkProtector.protectChunk(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition, ChunkProtector.getPlayerUUID(player));
		}
		return this.getDefaultState();
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) 
	{
		ChunkProtector.unprotectChunk(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition);
	}
	
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
	{
		for(int j = 8 ; j >= -8 ; j--)
		{
			for(int i = 15 ; i >= 0 ; i--)
			{
				worldIn.spawnParticle(EnumParticleTypes.REDSTONE, worldIn.getChunkFromBlockCoords(pos).getChunkCoordIntPair().getXStart() + i, pos.getY() + j, worldIn.getChunkFromBlockCoords(pos).getChunkCoordIntPair().getZStart(), 0.0D, 0.0D, 1.0D, new int[40]);
				worldIn.spawnParticle(EnumParticleTypes.REDSTONE, worldIn.getChunkFromBlockCoords(pos).getChunkCoordIntPair().getXStart() + i, pos.getY() + j, worldIn.getChunkFromBlockCoords(pos).getChunkCoordIntPair().getZEnd(), 0.0D, 0.0D, 1.0D, new int[40]);
				worldIn.spawnParticle(EnumParticleTypes.REDSTONE, worldIn.getChunkFromBlockCoords(pos).getChunkCoordIntPair().getXStart(), pos.getY() + j, worldIn.getChunkFromBlockCoords(pos).getChunkCoordIntPair().getZStart() + i, 0.0D, 0.0D, 1.0D, new int[40]);
				worldIn.spawnParticle(EnumParticleTypes.REDSTONE, worldIn.getChunkFromBlockCoords(pos).getChunkCoordIntPair().getXEnd(), pos.getY() + j, worldIn.getChunkFromBlockCoords(pos).getChunkCoordIntPair().getZStart() + i, 0.0D, 0.0D, 1.0D, new int[40]);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.SOLID;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean isFullCube()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return 3;
	}
}
