package minestrapteam.mods.minestrappolation.world;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBigGlowShroom extends WorldGenerator
{
    private int mushroomType = -1;

    public WorldGenBigGlowShroom(int p_i2017_1_)
    {
    	super(true);
        this.mushroomType = p_i2017_1_;
    }
    
    public WorldGenBigGlowShroom()
    {
    	super(false);
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        int i = rand.nextInt(2);

        if (this.mushroomType >= 0)
        {
            i = this.mushroomType;
        }

        int j = rand.nextInt(3) + 4;
        boolean flag = true;

        if (position.getY() >= 1 && position.getY() + j + 1 < 256)
        {
            int l;
            int i1;

            for (int k = position.getY(); k <= position.getY() + 1 + j; ++k)
            {
                byte b0 = 3;

                if (k <= position.getY() + 3)
                {
                    b0 = 0;
                }

                for (l = position.getX() - b0; l <= position.getX() + b0 && flag; ++l)
                {
                    for (i1 = position.getZ() - b0; i1 <= position.getZ() + b0 && flag; ++i1)
                    {
                        if (k >= 0 && k < 256)
                        {
                            BlockPos pos = new BlockPos(l, k, i1);
                            net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);

                            if (!state.getBlock().isAir(worldIn, pos) && !state.getBlock().isLeaves(worldIn, pos))
                            {
                                flag = false;
                            }
                        }
                        else
                        {
                            flag = false;
                        }
                    }
                }
            }

            if (!flag)
            {
                return false;
            }
            else
            {
                Block block1 = worldIn.getBlockState(position.down()).getBlock();

                if (block1 != Blocks.netherrack && block1 != Blocks.soul_sand)
                {
                    return false;
                }
                else
                {
                    int l1 = position.getY() + j;

                    if (i == 1)
                    {
                        l1 = position.getY() + j - 3;
                    }

                    for (l = l1; l <= position.getY() + j; ++l)
                    {
                        i1 = 1;

                        if (l < position.getY() + j)
                        {
                            ++i1;
                        }

                        if (i == 0)
                        {
                            i1 = 3;
                        }

                        for (int i2 = position.getX() - i1; i2 <= position.getX() + i1; ++i2)
                        {
                            for (int j1 = position.getZ() - i1; j1 <= position.getZ() + i1; ++j1)
                            {
                                int k1 = 5;

                                if (i2 == position.getX() - i1)
                                {
                                    --k1;
                                }

                                if (i2 == position.getX() + i1)
                                {
                                    ++k1;
                                }

                                if (j1 == position.getZ() - i1)
                                {
                                    k1 -= 3;
                                }

                                if (j1 == position.getZ() + i1)
                                {
                                    k1 += 3;
                                }

                                if (i == 0 || l < position.getY() + j)
                                {
                                    if ((i2 == position.getX() - i1 || i2 == position.getX() + i1) && (j1 == position.getZ() - i1 || j1 == position.getZ() + i1))
                                    {
                                        continue;
                                    }

                                    if (i2 == position.getX() - (i1 - 1) && j1 == position.getZ() - i1)
                                    {
                                        k1 = 1;
                                    }

                                    if (i2 == position.getX() - i1 && j1 == position.getZ() - (i1 - 1))
                                    {
                                        k1 = 1;
                                    }

                                    if (i2 == position.getX() + (i1 - 1) && j1 == position.getZ() - i1)
                                    {
                                        k1 = 3;
                                    }

                                    if (i2 == position.getX() + i1 && j1 == position.getZ() - (i1 - 1))
                                    {
                                        k1 = 3;
                                    }

                                    if (i2 == position.getX() - (i1 - 1) && j1 == position.getZ() + i1)
                                    {
                                        k1 = 7;
                                    }

                                    if (i2 == position.getX() - i1 && j1 == position.getZ() + (i1 - 1))
                                    {
                                        k1 = 7;
                                    }

                                    if (i2 == position.getX() + (i1 - 1) && j1 == position.getZ() + i1)
                                    {
                                        k1 = 9;
                                    }

                                    if (i2 == position.getX() + i1 && j1 == position.getZ() + (i1 - 1))
                                    {
                                        k1 = 9;
                                    }
                                }

                                if (k1 == 5 && l < position.getY() + j)
                                {
                                    k1 = 0;
                                }

                                if (k1 != 0 || position.getY() >= position.getY() + j - 1)
                                {
                                    BlockPos blockpos1 = new BlockPos(i2, l, j1);

                                    if (worldIn.getBlockState(blockpos1).getBlock().canBeReplacedByLeaves(worldIn, blockpos1))
                                    {
                                        this.setBlock(worldIn, blockpos1, Block.getBlockById(Block.getIdFromBlock(MBlocks.huge_green_glowshroom) + i), k1);
                                    }
                                }
                            }
                        }
                    }

                    for (l = 0; l < j; ++l)
                    {
                        BlockPos upN = position.up(l);
                        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(upN);

                        if (state.getBlock().canBeReplacedByLeaves(worldIn, upN))
                        {
                            this.setBlock(worldIn, position.up(l), Block.getBlockById(Block.getIdFromBlock(MBlocks.huge_green_glowshroom) + i), 10);
                        }
                    }

                    return true;
                }
            }
        }
        else
        {
            return false;
        }
    }
}
