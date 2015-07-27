package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MFluid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockMagma extends BlockFluidClassic
{
	
	public BlockMagma()
	{
		super(MFluid.MAGMA, Material.lava);
		MFluid.MAGMA.setBlock(this);
		this.setQuantaPerBlock(4);
	}
	
	@Override
	public Fluid getFluid()
	{
		return MFluid.MAGMA;
	}
	
	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        this.checkForMixing(worldIn, pos, state);
    }

    public boolean checkForMixing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (this.blockMaterial == Material.lava)
        {
            String flag = "none";
            EnumFacing[] aenumfacing = EnumFacing.values();
            int i = aenumfacing.length;
            Block block;

            for (int j = 0; j < i; ++j)
            {
                EnumFacing enumfacing = aenumfacing[j];

                if (enumfacing != EnumFacing.DOWN && worldIn.getBlockState(pos.offset(enumfacing)).getBlock() == Blocks.flowing_lava)
                {
                	block = worldIn.getBlockState(pos.offset(enumfacing)).getBlock();
                    flag = "lava";
                    break;
                }
                if (enumfacing != EnumFacing.DOWN && worldIn.getBlockState(pos.offset(enumfacing)).getBlock() == Blocks.flowing_water)
                {
                    flag = "water_flowing";
                    break;
                }
            }

            if (flag.equals("water_flowing"))
            {
                Integer integer = (Integer)state.getValue(LEVEL);

                if (integer.intValue() == 0)
                {
                    worldIn.setBlockState(pos, Blocks.bedrock.getDefaultState());
                    return true;
                }

                if (integer.intValue() <= 4)
                {
                    worldIn.setBlockState(pos, Blocks.obsidian.getDefaultState());
                    return true;
                }
            }
            if (flag.equals("lava"))
            {
            	Integer integer = (Integer)state.getValue(LEVEL);
            	if (integer.intValue() == 0)
                {
                    worldIn.setBlockState(pos, Blocks.flowing_lava.getStateFromMeta(integer));
                    return true;
                }
            	
            	if (integer.intValue() <= 4)
                {
                    worldIn.setBlockState(pos, Blocks.flowing_lava.getStateFromMeta(integer));
                    return true;
                }
            }
        }

        return false;
    }
	
}