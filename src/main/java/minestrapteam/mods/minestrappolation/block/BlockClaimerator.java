package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.chunkster.ChunkProtector;
import minestrapteam.mods.chunkster.UUIDHelper;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
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
			ChunkProtector.protectChunk(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition, UUIDHelper.getPlayerUUID(placer.getCommandSenderName()));
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
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
			return true;
		
		if(playerIn.getHeldItem() != null)
		{
			if(playerIn.getHeldItem().getItem() == Items.name_tag)
			{
				String name = playerIn.getHeldItem().getDisplayName();
				
				if(UUIDHelper.isValidUUID(name))
				{
						if(ChunkProtector.addCoOwner(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition, UUIDHelper.getPlayerUUID(name)))
						{
							playerIn.addChatMessage(new ChatComponentText(name + " with UUID " + UUIDHelper.getPlayerUUID(name) + " can now edit this chunk!"));
						}	
						else
						{
							playerIn.addChatMessage(new ChatComponentText(name + " can already edit this chunk"));
						}			
				}
				else
				{
					playerIn.addChatMessage(new ChatComponentText("Invalid UUID is the username correct?"));
				}
			}
			
			if(playerIn.getHeldItem().getItem() == Items.redstone)
			{
				if(playerIn.isSneaking())
				{
					ChunkProtector.getProtectionData(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition).setUseRedstoneObjects(false);
					playerIn.addChatMessage(new ChatComponentText("Levers, doors, and buttons CANNOT be used by everyone"));
				}
				else
				{
					ChunkProtector.getProtectionData(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition).setUseRedstoneObjects(true);
					playerIn.addChatMessage(new ChatComponentText("Levers, doors, and buttons CAN now be used by everyone"));
				}
			}
			
		}
		return true;
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
