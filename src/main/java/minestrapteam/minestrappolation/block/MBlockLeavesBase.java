package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.enumtypes.MWoodType;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class MBlockLeavesBase extends BlockLeavesBase implements net.minecraftforge.common.IShearable
{
	public static final PropertyBool	DECAYABLE	= PropertyBool.create("decayable");
	public static final PropertyBool	CHECK_DECAY	= PropertyBool.create("check_decay");
	int[]								surroundings;
	@SideOnly(Side.CLIENT)
	protected int						iconIndex;
	@SideOnly(Side.CLIENT)
	protected boolean					isTransparent;
	
	public MBlockLeavesBase()
	{
		super(Material.leaves, false);
		this.setTickRandomly(true);
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
		this.setHardness(0.2F);
		this.setLightOpacity(1);
		this.setStepSound(soundTypeGrass);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		return ColorizerFoliage.getFoliageColor(0.5D, 1.0D);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(IBlockState state)
	{
		return ColorizerFoliage.getFoliageColorBasic();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
	{
		return BiomeColorHelper.getFoliageColorAtPos(worldIn, pos);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (!worldIn.isRemote)
		{
			if (((Boolean) state.getValue(CHECK_DECAY)).booleanValue() && ((Boolean) state.getValue(DECAYABLE)).booleanValue())
			{
				byte b0 = 8;
				int i = b0 + 1;
				int j = pos.getX();
				int k = pos.getY();
				int l = pos.getZ();
				byte b1 = 32;
				int i1 = b1 * b1;
				int j1 = b1 / 2;
				
				if (this.surroundings == null)
				{
					this.surroundings = new int[b1 * b1 * b1];
				}
				
				int k1;
				
				if (worldIn.isAreaLoaded(new BlockPos(j - i, k - i, l - i), new BlockPos(j + i, k + i, l + i)))
				{
					int l1;
					int i2;
					
					for (k1 = -b0; k1 <= b0; ++k1)
					{
						for (l1 = -b0; l1 <= b0; ++l1)
						{
							for (i2 = -b0; i2 <= b0; ++i2)
							{
								BlockPos tmp = new BlockPos(j + k1, k + l1, l + i2);
								Block block = worldIn.getBlockState(tmp).getBlock();
								
								if (!block.canSustainLeaves(worldIn, tmp))
								{
									if (block.isLeaves(worldIn, tmp))
									{
										this.surroundings[(k1 + j1) * i1 + (l1 + j1) * b1 + i2 + j1] = -2;
									}
									else
									{
										this.surroundings[(k1 + j1) * i1 + (l1 + j1) * b1 + i2 + j1] = -1;
									}
								}
								else
								{
									this.surroundings[(k1 + j1) * i1 + (l1 + j1) * b1 + i2 + j1] = 0;
								}
							}
						}
					}
					
					for (k1 = 1; k1 <= 4; ++k1)
					{
						for (l1 = -b0; l1 <= b0; ++l1)
						{
							for (i2 = -b0; i2 <= b0; ++i2)
							{
								for (int j2 = -b0; j2 <= b0; ++j2)
								{
									if (this.surroundings[(l1 + j1) * i1 + (i2 + j1) * b1 + j2 + j1] == k1 - 1)
									{
										if (this.surroundings[(l1 + j1 - 1) * i1 + (i2 + j1) * b1 + j2 + j1] == -2)
										{
											this.surroundings[(l1 + j1 - 1) * i1 + (i2 + j1) * b1 + j2 + j1] = k1;
										}
										
										if (this.surroundings[(l1 + j1 + 1) * i1 + (i2 + j1) * b1 + j2 + j1] == -2)
										{
											this.surroundings[(l1 + j1 + 1) * i1 + (i2 + j1) * b1 + j2 + j1] = k1;
										}
										
										if (this.surroundings[(l1 + j1) * i1 + (i2 + j1 - 1) * b1 + j2 + j1] == -2)
										{
											this.surroundings[(l1 + j1) * i1 + (i2 + j1 - 1) * b1 + j2 + j1] = k1;
										}
										
										if (this.surroundings[(l1 + j1) * i1 + (i2 + j1 + 1) * b1 + j2 + j1] == -2)
										{
											this.surroundings[(l1 + j1) * i1 + (i2 + j1 + 1) * b1 + j2 + j1] = k1;
										}
										
										if (this.surroundings[(l1 + j1) * i1 + (i2 + j1) * b1 + j2 + j1 - 1] == -2)
										{
											this.surroundings[(l1 + j1) * i1 + (i2 + j1) * b1 + j2 + j1 - 1] = k1;
										}
										
										if (this.surroundings[(l1 + j1) * i1 + (i2 + j1) * b1 + j2 + j1 + 1] == -2)
										{
											this.surroundings[(l1 + j1) * i1 + (i2 + j1) * b1 + j2 + j1 + 1] = k1;
										}
									}
								}
							}
						}
					}
				}
				
				k1 = this.surroundings[j1 * i1 + j1 * b1 + j1];
				
				if (k1 >= 0)
				{
					worldIn.setBlockState(pos, state.withProperty(CHECK_DECAY, Boolean.valueOf(false)), 4);
				}
				else
				{
					this.destroy(worldIn, pos);
				}
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (worldIn.canLightningStrike(pos.up()) && !World.doesBlockHaveSolidTopSurface(worldIn, pos.down()) && rand.nextInt(15) == 1)
        {
            double d0 = (double)((float)pos.getX() + rand.nextFloat());
            double d1 = (double)pos.getY() - 0.05D;
            double d2 = (double)((float)pos.getZ() + rand.nextFloat());
            worldIn.spawnParticle(EnumParticleTypes.DRIP_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        }
	}
	
	private void destroy(World worldIn, BlockPos pos)
	{
		this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 0);
		worldIn.setBlockToAir(pos);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(20) == 0 ? 1 : 0;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(Blocks.sapling);
	}
	
	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
	{
		super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
	}
	
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance)
	{
	}
	
	protected int getSaplingDropChance(IBlockState state)
	{
		return 20;
	}
	
	@Override
	public boolean isVisuallyOpaque()
	{
		return false;
	}
	
	public abstract MWoodType getWoodType(int meta);
	
	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
	{
		return true;
	}
	
	@Override
	public boolean isLeaves(IBlockAccess world, BlockPos pos)
	{
		return true;
	}
	
	@Override
	public void beginLeavesDecay(World world, BlockPos pos)
	{
		IBlockState state = world.getBlockState(pos);
		if (!(Boolean) state.getValue(CHECK_DECAY))
		{
			world.setBlockState(pos, state.withProperty(CHECK_DECAY, true), 4);
		}
	}
	
	@Override
	public java.util.List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		java.util.List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		int chance = this.getSaplingDropChance(state);
		
		if (fortune > 0)
		{
			chance -= 2 << fortune;
			if (chance < 10)
			{
				chance = 10;
			}
		}
		
		if (rand.nextInt(chance) == 0)
		{
			ret.add(new ItemStack(this.getItemDropped(state, rand, fortune), 1, this.damageDropped(state)));
		}
		
		chance = 200;
		if (fortune > 0)
		{
			chance -= 10 << fortune;
			if (chance < 40)
			{
				chance = 40;
			}
		}
		
		this.captureDrops(true);
		if (world instanceof World)
		{
			this.dropApple((World) world, pos, state, chance); // Dammet mojang
		}
		ret.addAll(this.captureDrops(false));
		return ret;
	}
	
}
