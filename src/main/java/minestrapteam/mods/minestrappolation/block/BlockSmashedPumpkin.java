package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.enumtypes.MPumpkinType;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSmashedPumpkin extends BlockPumpkin
{
	public BlockSmashedPumpkin()
    {
    }
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	if(this.getUnlocalizedName().contains("lit"))
    	{
    		double d0 = (double)pos.getX() + 0.5D;
    		double d1 = (double)pos.getY() + 0.5D;
    		double d2 = (double)pos.getZ() + 0.5D;
    		double d3 = 0.22D;
    		double d4 = 0.27D;

    		worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
    	}
    }
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(worldIn.isRemote)
		{
			return true;
		}
		if(this.getUnlocalizedName().contains("lit") == false && (playerIn.getCurrentEquippedItem() != null) && (playerIn.getCurrentEquippedItem().getItem() == Items.flint_and_steel || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_axe  || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_hoe || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_pickaxe || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_shovel || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_sword || playerIn.getCurrentEquippedItem().getItem() == Items.fire_charge))
		{
			if((playerIn.getCurrentEquippedItem().getItemDamage() < playerIn.getCurrentEquippedItem().getMaxDamage()))
			{
				playerIn.getCurrentEquippedItem().damageItem(1, playerIn);
			}
			else
			{
				playerIn.getCurrentEquippedItem().stackSize--;
			}
			worldIn.setBlockState(pos, ((BlockSmashedPumpkin)MBlocks.pumpkin_smashed_lit).getDefaultState().withProperty(FACING, this.getActualState(state, worldIn, pos).getValue(FACING)));
			return true;
		}
		else if(this.getUnlocalizedName().contains("lit") == true && (playerIn.getCurrentEquippedItem() != null) && (playerIn.getCurrentEquippedItem().getItem() == Items.potionitem || playerIn.getCurrentEquippedItem().getItem() == Items.water_bucket || playerIn.getCurrentEquippedItem().getItem() == Items.snowball || playerIn.getCurrentEquippedItem().getItem() == MItems.crushed_ice || playerIn.getCurrentEquippedItem().getItem() == MItems.ice_charge))
		{
			if((playerIn.getCurrentEquippedItem().getItem() == Items.potionitem))
			{
				playerIn.setCurrentItemOrArmor(0, new ItemStack(Items.glass_bottle, 1));
			}
			else if((playerIn.getCurrentEquippedItem().getItem() == Items.water_bucket))
			{
				playerIn.setCurrentItemOrArmor(0, new ItemStack(Items.bucket, 1));
			}
			else
			{
				playerIn.getCurrentEquippedItem().stackSize--;
			}
			worldIn.setBlockState(pos, ((BlockSmashedPumpkin)MBlocks.pumpkin_smashed).getDefaultState().withProperty(FACING, this.getActualState(state, worldIn, pos).getValue(FACING)));
			return true;
		}
		return false;
	}
}
