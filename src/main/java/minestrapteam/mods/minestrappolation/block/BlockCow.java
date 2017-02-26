package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCow extends BlockFlesh
{
	public BlockCow(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn, mapColorIn);
	}

	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(worldIn.isRemote)
		{
			return true;
		}
		if(playerIn.getHeldItemMainhand() != null && playerIn.getHeldItemMainhand().getItem() == Items.BUCKET)
		{
			if(playerIn.getHeldItemMainhand().getCount() > 1)
			{
				playerIn.getHeldItemMainhand().setCount(playerIn.getHeldItemMainhand().getCount() - 1);
				EntityItem ei = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(Items.MILK_BUCKET, 1));
				worldIn.spawnEntity(ei);
				if(playerIn instanceof FakePlayer)
					ei.onCollideWithPlayer(playerIn);
				return true;
			}
			else
			{
				playerIn.setHeldItem(EnumHand.MAIN_HAND, null);
				EntityItem ei = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(Items.MILK_BUCKET, 1));
				worldIn.spawnEntity(ei);
				if(playerIn instanceof FakePlayer)
					ei.onCollideWithPlayer(playerIn);
				return true;
			}			
		}
		if(playerIn.getHeldItemMainhand() != null && playerIn.getHeldItemMainhand().getItem() == MItems.infectious_fungus)
		{
			if(playerIn.getHeldItemMainhand().getCount() > 1)
			{
				playerIn.addStat(MAchievements.gene_block, 1);
				playerIn.getHeldItemMainhand().setCount(playerIn.getHeldItemMainhand().getCount() - 1);
				worldIn.setBlockState(pos, MBlocks.block_mooshroom.getDefaultState());
				return true;
			}
			else
			{
				playerIn.addStat(MAchievements.gene_block, 1);
				playerIn.setHeldItem(EnumHand.MAIN_HAND, null);
				worldIn.setBlockState(pos, MBlocks.block_mooshroom.getDefaultState());
				return true;
			}			
		}
		return false;
	}
}
