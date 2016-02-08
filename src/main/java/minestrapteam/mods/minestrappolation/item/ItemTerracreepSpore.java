package minestrapteam.mods.minestrappolation.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockBiomeStones;
import minestrapteam.mods.minestrappolation.block.biomeores.BlockTerraCreep;
import minestrapteam.mods.minestrappolation.enumtypes.MCreepType;
import minestrapteam.mods.minestrappolation.enumtypes.MStoneType;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemTerracreepSpore extends Item
{
	public ItemTerracreepSpore()
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
	    	if(worldIn.getBlockState(pos) == Blocks.stone.getDefaultState() || worldIn.getBlockState(pos) == Blocks.netherrack.getDefaultState() || worldIn.getBlockState(pos) == Blocks.end_stone.getDefaultState() || worldIn.getBlockState(pos).getBlock() == MBlocks.biome_stones)
	    	{
	    		IBlockState block = worldIn.getBlockState(pos);
	    		if(block == Blocks.stone.getDefaultState())
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.STONE));
	    		else if(block == MBlocks.biome_stones.getDefaultState().withProperty(BlockBiomeStones.VARIANT, MStoneType.DEEPSTONE))
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.DEEPSTONE));
	    		else if(block == MBlocks.biome_stones.getDefaultState().withProperty(BlockBiomeStones.VARIANT, MStoneType.REDROCK))
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.REDROCK));
	    		else if(block == MBlocks.biome_stones.getDefaultState().withProperty(BlockBiomeStones.VARIANT, MStoneType.DEEPREDROCK))
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.DEEPREDROCK));
	    		else if(block == MBlocks.biome_stones.getDefaultState().withProperty(BlockBiomeStones.VARIANT, MStoneType.COLDSTONE))
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.COLDSTONE));
	    		else if(block == MBlocks.biome_stones.getDefaultState().withProperty(BlockBiomeStones.VARIANT, MStoneType.DEEPCOLDSTONE))
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.DEEPCOLDSTONE));
	    		else if(block == MBlocks.biome_stones.getDefaultState().withProperty(BlockBiomeStones.VARIANT, MStoneType.ICESTONE))
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.ICESTONE));
	    		else if(block == MBlocks.biome_stones.getDefaultState().withProperty(BlockBiomeStones.VARIANT, MStoneType.GLACIERSTONE))
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.GLACIERSTONE));
	    		else if(block == MBlocks.biome_stones.getDefaultState().withProperty(BlockBiomeStones.VARIANT, MStoneType.OCEANSTONE))
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.OCEANSTONE));
	    		else if(block == MBlocks.biome_stones.getDefaultState().withProperty(BlockBiomeStones.VARIANT, MStoneType.POCEANSTONE))
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.POCEANSTONE));
	    		else if(block == Blocks.netherrack.getDefaultState())
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.NETHERRACK));
	    		else if(block == Blocks.end_stone.getDefaultState())
	    			worldIn.setBlockState(pos, MBlocks.terracreep.getDefaultState().withProperty(BlockTerraCreep.VARIANT, MCreepType.ENDSTONE));
	    		
	    		stack.stackSize--;
	    		return true;
	    	}
	    	else
	    		return false;
	    }
	}
}
