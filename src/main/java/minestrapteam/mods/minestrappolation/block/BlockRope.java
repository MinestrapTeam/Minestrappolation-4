package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRope extends MBlock
{

	public BlockRope(Material materialIn, MapColor mapColorIn) 
	{
		super(materialIn, mapColorIn);
	}
	
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
		this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
        return super.getCollisionBoundingBox(worldIn, pos, state);
    }
	
	@SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBox(World worldIn, BlockPos pos)
    {
		this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
        return super.getSelectedBoundingBox(worldIn, pos);
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
        return worldIn.isSideSolid(pos.offset(EnumFacing.UP), EnumFacing.DOWN, true) || worldIn.getBlockState(pos.offset(EnumFacing.UP)) == MBlocks.rope.getDefaultState() || worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock() instanceof BlockFence;
    }
    
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
    	if (!this.canBlockStay(worldIn, pos, EnumFacing.UP))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }

        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
    }
    
    protected boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing facing)
    {
        return worldIn.isSideSolid(pos.offset(facing), facing.getOpposite(), true) || worldIn.getBlockState(pos.offset(EnumFacing.UP)) == MBlocks.rope.getDefaultState() || worldIn.getBlockState(pos.offset(EnumFacing.UP)).getBlock() instanceof BlockFence;
    }
    
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (playerIn.getCurrentEquippedItem() != null)
        {
            Item item = playerIn.getCurrentEquippedItem().getItem();

            if (item == Item.getItemFromBlock(MBlocks.rope))
            {
                int yCheck = pos.getY();
            	BlockPos pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
            	boolean isChecking = true;
            	for(boolean checking = true ; checking == true ; checking = isChecking)
            	{
            		if(worldIn.getBlockState(pos1) == MBlocks.rope.getDefaultState())
            		{
            			yCheck--;
            			pos1 = new BlockPos(pos.getX(), yCheck, pos.getZ());
            			isChecking = true;
            		}
            		else if(worldIn.isAirBlock(pos1) == true)
            		{
            			worldIn.setBlockState(pos1, MBlocks.rope.getDefaultState());
            			if (!playerIn.capabilities.isCreativeMode)
            			{
            				--playerIn.getCurrentEquippedItem().stackSize;
            			}
            			isChecking = false;
            		}
            		else
            		{
            			isChecking = false;
            		}
            	}
                return true;
            }
        }

        return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
    }
    
    @Override public boolean isLadder(IBlockAccess world, BlockPos pos, EntityLivingBase entity) { return true; }
    
    @Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return 300;
	}
}
