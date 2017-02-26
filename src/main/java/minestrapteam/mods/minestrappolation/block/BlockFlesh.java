package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFlesh extends MBlock
{
	public BlockFlesh(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn, mapColorIn);
	}

	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		float f = 0.0625F;
		return new AxisAlignedBB(pos.getX() + f, pos.getY(), pos.getZ() + f, pos.getX() + 1 - f, pos.getY() + 1 - (2 * f), pos.getZ() + 1 - f);
	}
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
    {
		float f = 0.0625F;
		return new AxisAlignedBB(pos.getX() + f, pos.getY(), pos.getZ() + f, pos.getX() + 1 - f, pos.getY() + 1 - (2 * f), pos.getZ() + 1 - f);
    }
	
	public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }

    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return true;
    }
    
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.isSideSolid(pos.offset(EnumFacing.DOWN), EnumFacing.UP, true);
    }
    
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
    	if (!this.canBlockStay(worldIn, pos, EnumFacing.DOWN))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }

        super.neighborChanged(state,worldIn,pos,blockIn,fromPos);
    }
    
    protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing)
    {
        return worldIn.isSideSolid(pos.offset(facing), facing.getOpposite(), true);
    }
	
	@Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if(worldIn.isRemote)
		{
			return true;
		}
		if((playerIn.getHeldItemMainhand() != null) && playerIn.getHeldItemMainhand().getItem() == Items.POTIONITEM && (playerIn.getHeldItemMainhand().getItemDamage() == 8193 || playerIn.getHeldItemMainhand().getItemDamage() == 8225 || playerIn.getHeldItemMainhand().getItemDamage() == 8257 || playerIn.getHeldItemMainhand().getItemDamage() == 16385 || playerIn.getHeldItemMainhand().getItemDamage() == 16417 || playerIn.getHeldItemMainhand().getItemDamage() == 16449))
		{
			playerIn.setHeldItem(EnumHand.MAIN_HAND, null);
			worldIn.setBlockState(pos, MBlocks.block_flesh_reactive.getDefaultState());
			return true;
		}
		return false;
	}
}
