package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MAchievements;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

public class BlockIceDeposit extends BlockBush{

	public BlockIceDeposit(Material material, Item item, MapColor mapcolor) 
	{
		super(material, item, mapcolor);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1F, 0.5F, 1F);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
    		if((Integer)state.getValue(AGE) == 5)
    		{
    			if(worldIn.isRemote)
    				return true;
    			if(playerIn.getHeldItem() != null)
    			{
    				if(playerIn.getHeldItem().getItem() instanceof ItemPickaxe)
        			{
        				worldIn.setBlockState(pos, this.getDefaultState(), 2);
            			EntityItem ei = new EntityItem(worldIn, playerIn.posX, playerIn.posY, playerIn.posZ, new ItemStack(item));
            			worldIn.spawnEntityInWorld(ei);
            			playerIn.getHeldItem().damageItem(2, playerIn);
            			playerIn.addStat(MAchievements.glacieric_ice, 1);
            			if(playerIn instanceof FakePlayer)
            			{
            				ei.onCollideWithPlayer(playerIn);	
            			}
            			return true;
        			} 	
    			}
    						
    		}
    		return false;
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        Block block = worldIn.getBlockState(pos.down()).getBlock();
        if(block == MBlocks.glaical_invincium)
        {
        	return true;
        }	
		return false;
    }
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		float f = 0.5F;
		return new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + f, pos.getZ() + 1);
	}
}
