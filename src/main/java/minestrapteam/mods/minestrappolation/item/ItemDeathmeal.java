package minestrapteam.mods.minestrappolation.item;

import java.util.Random;

import minestrapteam.mods.minestrappolation.block.BlockBush;
import minestrapteam.mods.minestrappolation.block.BlockCarvedPumpkin;
import minestrapteam.mods.minestrappolation.block.BlockWitherAsh;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDeathmeal extends Item
{
	public ItemDeathmeal()
	{
	}
	
	 public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	 {
	     if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
	     {
	         return false;
	     }
	     else
	     {
	    	 if (applyBonemeal(stack, worldIn, pos, playerIn))
             {
	    		 if (!worldIn.isRemote)
                 {
	    			 worldIn.playAuxSFX(2005, pos, 0);
                 }

                 return true;
             }
	    	 return false;
	     }
	 }
	 
	 public static int isOrganic(IBlockState iblockstate)
	 {
		 if(iblockstate.getBlock() == Blocks.cactus ||
		    iblockstate.getBlock() == Blocks.leaves ||
		    iblockstate.getBlock() == Blocks.leaves2 ||
		    iblockstate.getBlock() == Blocks.melon_block ||
		    iblockstate.getBlock() == Blocks.brown_mushroom_block ||
		    iblockstate.getBlock() == Blocks.red_mushroom_block ||
		    iblockstate.getBlock() == Blocks.pumpkin ||
		    iblockstate.getBlock() == Blocks.lit_pumpkin ||
		    iblockstate.getBlock() == Blocks.hay_block || 
		    iblockstate.getBlock() == Blocks.log ||
		    iblockstate.getBlock() == Blocks.log2 ||
		    iblockstate.getBlock() == MBlocks.ministrapp_leaves ||
		    iblockstate.getBlock() == MBlocks.ministrapp_log ||
		    iblockstate.getBlock() == MBlocks.huge_green_glowshroom ||
		    iblockstate.getBlock() == MBlocks.huge_purple_glowshroom ||
		    iblockstate.getBlock() instanceof BlockCarvedPumpkin ||
		    iblockstate.getBlock() == MBlocks.meat_block ||
		    iblockstate.getBlock() == MBlocks.melon_bricks ||
		    iblockstate.getBlock() == MBlocks.terracreep)
		 {
			 return 8;
		 }
		 else if(iblockstate.getBlock() == Blocks.cocoa ||
				 iblockstate.getBlock() == Blocks.double_plant ||
				 iblockstate.getBlock() == Blocks.sapling ||
				 iblockstate.getBlock() == Blocks.reeds ||
				 iblockstate.getBlock() == Blocks.vine ||
				 iblockstate.getBlock() == MBlocks.ministrapp_sapling ||
				 iblockstate.getBlock() == MBlocks.dead_branch ||
				 iblockstate.getBlock() == MBlocks.hanging_moss ||
				 iblockstate.getBlock() == MBlocks.hanging_glow_moss ||
				 iblockstate.getBlock() == MBlocks.seaweed)
		 {
			return 4;
		 }
		 else if(
				 iblockstate.getBlock() == Blocks.deadbush ||
				 iblockstate.getBlock() == Blocks.tallgrass ||
				 iblockstate.getBlock() == Blocks.red_flower ||
				 iblockstate.getBlock() == Blocks.yellow_flower ||
				 iblockstate.getBlock() == Blocks.waterlily ||
				 iblockstate.getBlock() == Blocks.red_mushroom ||
				 iblockstate.getBlock() == Blocks.brown_mushroom || 
				 iblockstate.getBlock() == MBlocks.shrub_grass ||
				 iblockstate.getBlock() == MBlocks.moss ||
				 iblockstate.getBlock() == MBlocks.green_glowshroom ||
				 iblockstate.getBlock() == MBlocks.purple_glowshroom)
		 {
			 return 1;
		 }
		 else if(iblockstate.getBlock() instanceof BlockCrops)
		 {
			 return ((Integer)iblockstate.getValue(BlockCrops.AGE)).intValue() + 1;
		 }
		 else if(iblockstate.getBlock() instanceof BlockBush)
		 {
			 return ((Integer)iblockstate.getValue(BlockBush.AGE)).intValue() + 1;
		 }
		 else
		 {
			 return 0;
		 }
	 }
	 
	 public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target)
	 {
		 if (worldIn instanceof net.minecraft.world.WorldServer)
			 return applyBonemeal(stack, worldIn, target, net.minecraftforge.common.util.FakePlayerFactory.getMinecraft((net.minecraft.world.WorldServer)worldIn));
	     return false;
	 }

	    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos target, EntityPlayer player)
	    {
	        IBlockState iblockstate = worldIn.getBlockState(target);

	        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, target, iblockstate, stack);
	        if (hook != 0) return hook > 0;

	        if (isOrganic(iblockstate) != 0)
	        {
	        	Random rand = new Random();
	        	BlockPos pos1 = target;
	        	int dir = 0;
	        	int checks = rand.nextInt(6);
	        	for(int i = isOrganic(iblockstate) ; i != 0 ; i = isOrganic(worldIn.getBlockState(pos1)))
	        	{
	        		worldIn.setBlockState(pos1, MBlocks.wither_ash.getDefaultState().withProperty(BlockWitherAsh.LAYERS, isOrganic(worldIn.getBlockState(pos1))));
	        		dir = rand.nextInt(6);
	        		if(dir == 0)
	        			pos1 = pos1.up();
	        		else if(dir == 1)
	        			pos1 = pos1.down();
	        		else if(dir == 2)
	        			pos1 = pos1.north();
	        		else if(dir == 3)
	        			pos1 = pos1.east();
	        		else if(dir == 4)
	        			pos1 = pos1.south();
	        		else
	        			pos1 = pos1.west();
	        	}
	        	return true;
	        }

	        return false;
	    }

	    @SideOnly(Side.CLIENT)
	    public static void spawnBonemealParticles(World worldIn, BlockPos pos, int amount)
	    {
	        if (amount == 0)
	        {
	            amount = 15;
	        }

	        Block block = worldIn.getBlockState(pos).getBlock();

	        if (block.isAir(worldIn, pos))
	        {
	            block.setBlockBoundsBasedOnState(worldIn, pos);

	            for (int j = 0; j < amount; ++j)
	            {
	                double d0 = itemRand.nextGaussian() * 0.02D;
	                double d1 = itemRand.nextGaussian() * 0.02D;
	                double d2 = itemRand.nextGaussian() * 0.02D;
	                worldIn.spawnParticle(EnumParticleTypes.SPELL_INSTANT, (double)((float)pos.getX() + itemRand.nextFloat()), (double)pos.getY() + (double)itemRand.nextFloat() * block.getBlockBoundsMaxY(), (double)((float)pos.getZ() + itemRand.nextFloat()), d0, d1, d2, new int[0]);
	            }
	        }
	        else
	        {
	            for (int i1 = 0; i1 < amount; ++i1)
	            {
	                double d0 = itemRand.nextGaussian() * 0.02D;
	                double d1 = itemRand.nextGaussian() * 0.02D;
	                double d2 = itemRand.nextGaussian() * 0.02D;
	                worldIn.spawnParticle(EnumParticleTypes.SPELL_INSTANT, (double)((float)pos.getX() + itemRand.nextFloat()), (double)pos.getY() + (double)itemRand.nextFloat() * 1.0f, (double)((float)pos.getZ() + itemRand.nextFloat()), d0, d1, d2, new int[0]);
	            }
	        }
	    }
}
