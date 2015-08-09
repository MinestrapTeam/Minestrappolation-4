package minestrapteam.mods.minestrappolation.item;

import java.util.HashMap;

import minestrapteam.mods.minestrappolation.enumtypes.MWoodType;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemMPickaxe extends ItemPickaxe
{
	
	Item	repairItem;
	boolean	ignites	= false;
	boolean freezes = false;
	
	public HashMap<IBlockState, IBlockState>	canFreeze	= new HashMap<IBlockState, IBlockState>();
	
	public ItemMPickaxe(ToolMaterial material, Item repair, boolean ignites, boolean freezes)
	{
		super(material);
		this.repairItem = repair;
		this.ignites = ignites;
		this.freezes = freezes;
		//if(this.freezes)
		//	this.createFreezeMap();
	}
	
	/*public void createFreezeMap()
	{
		this.canFreeze.put(Blocks.water.getDefaultState(), Blocks.ice.getDefaultState());
		this.canFreeze.put(Blocks.snow.getDefaultState(), MBlocks.snow_refined.getDefaultState());
		this.canFreeze.put(MBlocks.snow_bricks.getDefaultState(), MBlocks.snow_tiles.getDefaultState());
		this.canFreeze.put(MBlocks.snow_refined.getDefaultState(), Blocks.ice.getDefaultState());
		this.canFreeze.put(MBlocks.snow_tiles.getDefaultState(), Blocks.ice.getDefaultState());
		this.canFreeze.put(Blocks.ice.getDefaultState(), Blocks.packed_ice.getDefaultState());
		for(int i = 0 ; i < 16 ; i++)
		{
			if (i < 14)
				this.canFreeze.put(Blocks.snow_layer.getStateFromMeta(i), Blocks.snow_layer.getStateFromMeta(i + 1));
			else
				this.canFreeze.put(Blocks.snow_layer.getStateFromMeta(15), Blocks.snow.getDefaultState());
		}
		
		this.canFreeze.put(Blocks.fire.getDefaultState(), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.lava.getDefaultState(), Blocks.obsidian.getDefaultState());
		
		for(int i = 0 ; i < 16 ; i++)
		{
			this.canFreeze.put(Blocks.tallgrass.getStateFromMeta(i), Blocks.deadbush.getDefaultState());
		}
		this.canFreeze.put(Blocks.deadbush.getDefaultState(), Blocks.air.getDefaultState());
		for(int i = 0 ; i < 16 ; i++)
		{
			this.canFreeze.put(Blocks.red_flower.getStateFromMeta(i), Blocks.deadbush.getDefaultState());
		}
		for(int i = 0 ; i < 16 ; i++)
		{
			this.canFreeze.put(Blocks.double_plant.getStateFromMeta(i), Blocks.deadbush.getDefaultState());
		}
		this.canFreeze.put(Blocks.yellow_flower.getDefaultState(), Blocks.deadbush.getDefaultState());
		this.canFreeze.put(Blocks.red_mushroom.getDefaultState(), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.brown_mushroom.getDefaultState(), Blocks.air.getDefaultState());
		this.canFreeze.put(Blocks.reeds.getDefaultState(), Blocks.air.getDefaultState());
		for(int i = 0 ; i < 16 ; i++)
		{
			this.canFreeze.put(Blocks.vine.getStateFromMeta(i), Blocks.air.getDefaultState());
		}
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.ACACIA.getMetadata()), Blocks.deadbush.getDefaultState());
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.OAK.getMetadata()), MBlocks.ministrapp_sapling.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.DARK_OAK.getMetadata()), MBlocks.ministrapp_sapling.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.deadbush.getDefaultState());
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.JUNGLE.getMetadata()), Blocks.deadbush.getDefaultState());
		this.canFreeze.put(Blocks.sapling.getStateFromMeta(BlockPlanks.EnumType.BIRCH.getMetadata()), Blocks.deadbush.getDefaultState());
		this.canFreeze.put(Blocks.cactus.getDefaultState(), Blocks.snow.getDefaultState());
		this.canFreeze.put(Blocks.lit_pumpkin.getStateFromMeta(0), Blocks.pumpkin.getStateFromMeta(0));
		this.canFreeze.put(Blocks.lit_pumpkin.getStateFromMeta(1), Blocks.pumpkin.getStateFromMeta(1));
		this.canFreeze.put(Blocks.lit_pumpkin.getStateFromMeta(2), Blocks.pumpkin.getStateFromMeta(2));
		this.canFreeze.put(Blocks.lit_pumpkin.getStateFromMeta(3), Blocks.pumpkin.getStateFromMeta(3));
		for(int i = 0 ; i < 16 ; i++)
		{
			this.canFreeze.put(Blocks.pumpkin.getStateFromMeta(i), Blocks.snow.getDefaultState());
		}
		this.canFreeze.put(Blocks.melon_block.getDefaultState(), Blocks.snow.getDefaultState());
		
		this.canFreeze.put(Blocks.log.getStateFromMeta(BlockPlanks.EnumType.OAK.getMetadata()), MBlocks.ministrapp_log.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		this.canFreeze.put(Blocks.log2.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), MBlocks.ministrapp_log.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		this.canFreeze.put(Blocks.leaves.getStateFromMeta(BlockPlanks.EnumType.OAK.getMetadata()), MBlocks.ministrapp_leaves.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		this.canFreeze.put(Blocks.leaves.getStateFromMeta(BlockPlanks.EnumType.BIRCH.getMetadata()), MBlocks.dead_branch.getDefaultState());
		this.canFreeze.put(Blocks.leaves.getStateFromMeta(BlockPlanks.EnumType.JUNGLE.getMetadata()), MBlocks.dead_branch.getDefaultState());
		this.canFreeze.put(Blocks.leaves2.getStateFromMeta(BlockPlanks.EnumType.OAK.getMetadata()), MBlocks.dead_branch.getDefaultState());
		this.canFreeze.put(Blocks.leaves2.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), MBlocks.ministrapp_leaves.getStateFromMeta(MWoodType.FROZEN.getMetadata()));
		for(int i = 0 ; i < 16 ; i++)
		{
			this.canFreeze.put(Blocks.red_mushroom_block.getStateFromMeta(i), Blocks.snow.getDefaultState());
		}
		for(int i = 0 ; i < 16 ; i++)
		{
			this.canFreeze.put(Blocks.brown_mushroom_block.getStateFromMeta(i), Blocks.snow.getDefaultState());
		}
		
		this.canFreeze.put(Blocks.sand.getDefaultState(), MBlocks.cold_sand.getDefaultState());
		this.canFreeze.put(Blocks.sand.getStateFromMeta(BlockSand.EnumType.RED_SAND.getMetadata()), MBlocks.cold_sand.getStateFromMeta(BlockSand.EnumType.RED_SAND.getMetadata()));
		this.canFreeze.put(Blocks.grass.getDefaultState(), MBlocks.lichen_permafrost.getDefaultState());
		this.canFreeze.put(Blocks.mycelium.getDefaultState(), MBlocks.lichen_permafrost.getDefaultState());
		this.canFreeze.put(Blocks.dirt.getStateFromMeta(BlockDirt.DirtType.DIRT.getMetadata()), MBlocks.dirt_permafrost.getDefaultState());
		this.canFreeze.put(Blocks.dirt.getStateFromMeta(BlockDirt.DirtType.COARSE_DIRT.getMetadata()), MBlocks.dirt_permafrost.getDefaultState());
		this.canFreeze.put(Blocks.dirt.getStateFromMeta(BlockDirt.DirtType.PODZOL.getMetadata()), MBlocks.lichen_permafrost.getDefaultState());
		for(int i = 0 ; i < 16 ; i++)
		{
			this.canFreeze.put(Blocks.farmland.getStateFromMeta(i), MBlocks.dirt_permafrost.getDefaultState());
		}
		
		this.canFreeze.put(Blocks.sponge.getStateFromMeta(1), Blocks.snow.getDefaultState());
		this.canFreeze.put(Blocks.web.getDefaultState(), MBlocks.cold_cobweb.getDefaultState());
	}*/
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == this.repairItem;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if(this.toolMaterial == MItems.TORITE)
        {
        	stack.damageItem(1, attacker);
        	return true;
        }
        else
        {
        	stack.damageItem(2, attacker);
            return true;
        }
    }
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (this.ignites)
		{
			pos = pos.offset(side);
			if (!playerIn.canPlayerEdit(pos, side, stack))
				return false;
			else
			{
				if (worldIn.isAirBlock(pos))
				{
					worldIn.playSoundEffect(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					worldIn.setBlockState(pos, Blocks.fire.getDefaultState());
					stack.damageItem(4, playerIn);
				}
				return true;
			}
		}
		/*else if(this.freezes)
		{
			if (!playerIn.canPlayerEdit(pos, side, stack))
				return false;
			else
			{
				if (this.canFreeze.containsKey(worldIn.getBlockState(pos)))
				{
					worldIn.playSoundEffect(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					worldIn.setBlockState(pos, this.canFreeze.get(worldIn.getBlockState(pos)), 2);
					stack.damageItem(4, playerIn);
				}
				return true;
			}
		}*/
		return false;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        if(this.toolMaterial == MItems.TORITE)
        	return EnumAction.BLOCK;
        else
        	return null;
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        if(this.toolMaterial == MItems.TORITE)
        	return 72000;
        else
        	return 0;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		if(this.toolMaterial == MItems.TORITE)
		{
			playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
			return itemStackIn;
		}
        return itemStackIn;
    }
}
