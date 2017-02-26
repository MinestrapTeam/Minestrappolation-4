package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.world.WorldGenBigGlowShroom;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;

public class BlockGlowShrooms extends BlockMushroom
{
	public BlockGlowShrooms()
	{
		float f = 0.2F;
        this.setTickRandomly(true);
	}
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
    {
		float f = 0.2F;
    	return new AxisAlignedBB(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }
	
	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if (pos.getY() >= 0 && pos.getY() < 256)
        {
            IBlockState iblockstate1 = worldIn.getBlockState(pos.down());
            return iblockstate1.getBlock() == Blocks.NETHERRACK || iblockstate1.getBlock() == Blocks.SOUL_SAND && !worldIn.isAirBlock(pos.add(0, -1, 0));
        }
        else
        {
            return false;
        }
    }
	
	@Override
	public boolean generateBigMushroom(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        worldIn.setBlockToAir(pos);
        WorldGenBigGlowShroom worldgenbigmushroom = null;

        if (this == MBlocks.green_glowshroom)
        {
            worldgenbigmushroom = new WorldGenBigGlowShroom(MBlocks.huge_green_glowshroom);
        }
        else if (this == MBlocks.purple_glowshroom)
        {
            worldgenbigmushroom = new WorldGenBigGlowShroom(MBlocks.huge_purple_glowshroom);
        }

        if (worldgenbigmushroom != null && worldgenbigmushroom.generate(worldIn, rand, pos))
        {
            return true;
        }
        else
        {
            worldIn.setBlockState(pos, state, 3);
            return false;
        }
    }
}
