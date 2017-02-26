package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.chunkster.ChunkProtector;
import minestrapteam.mods.chunkster.UUIDHelper;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
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
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		if(placer instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)placer;
			ChunkProtector.protectChunk(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition, UUIDHelper.getPlayerUUID(placer.getName()));
		}
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
				worldIn.spawnParticle(EnumParticleTypes.REDSTONE, worldIn.getChunkFromBlockCoords(pos).getPos().getXStart() + i, pos.getY() + j, worldIn.getChunkFromBlockCoords(pos).getPos().getZStart(), 0.0D, 0.0D, 1.0D, new int[40]);
				worldIn.spawnParticle(EnumParticleTypes.REDSTONE, worldIn.getChunkFromBlockCoords(pos).getPos().getXStart() + i, pos.getY() + j, worldIn.getChunkFromBlockCoords(pos).getPos().getZEnd(), 0.0D, 0.0D, 1.0D, new int[40]);
				worldIn.spawnParticle(EnumParticleTypes.REDSTONE, worldIn.getChunkFromBlockCoords(pos).getPos().getXStart(), pos.getY() + j, worldIn.getChunkFromBlockCoords(pos).getPos().getZStart() + i, 0.0D, 0.0D, 1.0D, new int[40]);
				worldIn.spawnParticle(EnumParticleTypes.REDSTONE, worldIn.getChunkFromBlockCoords(pos).getPos().getXEnd(), pos.getY() + j, worldIn.getChunkFromBlockCoords(pos).getPos().getZStart() + i, 0.0D, 0.0D, 1.0D, new int[40]);
			}
		}
	}
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
			return true;
		
		if(playerIn.getHeldItemMainhand() != null)
		{
			if(playerIn.getHeldItemMainhand().getItem() == Items.NAME_TAG)
			{
				String name = playerIn.getHeldItemMainhand().getDisplayName();
				
				if(UUIDHelper.isValidUUID(name))
				{
						if(ChunkProtector.addCoOwner(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition, UUIDHelper.getPlayerUUID(name)))
						{
							playerIn.sendMessage(new TextComponentString(name + " with UUID " + UUIDHelper.getPlayerUUID(name) + " can now edit this chunk!"));
						}	
						else
						{
							playerIn.sendMessage(new TextComponentString(name + " can already edit this chunk"));
						}			
				}
				else
				{
					playerIn.sendMessage(new TextComponentString("Invalid UUID is the username correct?"));
				}
			}
			
			if(playerIn.getHeldItemMainhand().getItem() == Items.REDSTONE)
			{
				if(playerIn.isSneaking())
				{
					ChunkProtector.getProtectionData(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition).setUseRedstoneObjects(false);
					playerIn.sendMessage(new TextComponentString("Levers, doors, and buttons CANNOT be used by everyone"));
				}
				else
				{
					ChunkProtector.getProtectionData(worldIn.getChunkFromBlockCoords(pos).xPosition, worldIn.getChunkFromBlockCoords(pos).zPosition).setUseRedstoneObjects(true);
					playerIn.sendMessage(new TextComponentString("Levers, doors, and buttons CAN now be used by everyone"));
				}
			}
			
		}
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.SOLID;
	}
	
	@Override
    public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}
}
