package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCow extends BlockFlesh
{
	public BlockCow(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn, mapColorIn);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(worldIn.isRemote)
		{
			return true;
		}
		if(playerIn.getCurrentEquippedItem().getItem() == Items.bucket)
		{
			if(playerIn.getCurrentEquippedItem().stackSize > 1)
			{
				playerIn.getCurrentEquippedItem().stackSize--;
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items.milk_bucket, 1));
				return true;
			}
			else
			{
				playerIn.destroyCurrentEquippedItem();
				playerIn.inventory.addItemStackToInventory(new ItemStack(Items.milk_bucket, 1));
				return true;
			}			
		}
		return false;
	}
}
