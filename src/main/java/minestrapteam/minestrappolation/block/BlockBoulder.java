package minestrapteam.minestrappolation.block;

import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockBoulder extends BlockFalling
{
	public int dropID;
	
	public BlockBoulder(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn);
		dropID = 0;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if (fortune > 3)
		{
			fortune = 3;
		}
		if(this == MBlocks.stone_boulder)
		{
			if (rand.nextInt(100 - fortune * 3) <= 30)
			{
				dropID = 0;
				return MItems.chunks;
			}
			else if (rand.nextInt(100 - fortune * 3) <= 20)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 1;
					return Items.gunpowder;
				}
				else
				{
					dropID = 2;
					return Items.flint;
				}
			}
			else if (rand.nextInt(100 - fortune * 3) <= 18)
			{
				dropID = 3;
				return MItems.chunks;
			}
			else if (rand.nextInt(100 - fortune * 3) <= 13)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 4;
					return Items.redstone;
				}
				else
					dropID = 4;
					return MItems.sunstone_shard;
			}
			else if (rand.nextInt(100 - fortune * 10) == 11)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 5;
					return MItems.meurodite_gem;
				}
				else
				{
					dropID = 6;
					return Items.diamond;
				}
			}
			else
			{
				dropID = 7;
				return Item.getItemFromBlock(Blocks.cobblestone);
			}
		}
		else if(this == MBlocks.red_rock_boulder)
		{
			if (rand.nextInt(100 - fortune * 3) <= 30)
			{
				dropID = 0;
				return MItems.chunks;
			}
			else if (rand.nextInt(100 - fortune * 3) <= 20)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 1;
					return MItems.desert_quartz_item;
				}
				else
				{
					dropID = 2;
					return Items.clay_ball;
				}
			}
			else if (rand.nextInt(100 - fortune * 3) <= 18)
			{
				dropID = 3;
				return MItems.chunks;
			}
			else if (rand.nextInt(100 - fortune * 3) <= 13)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 4;
					return Items.redstone;
				}
				else
					dropID = 4;
					return MItems.sunstone_shard;
			}
			else if (rand.nextInt(100 - fortune * 10) == 11)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 5;
					return MItems.radiant_quartz;
				}
				else
				{
					dropID = 6;
					return Items.diamond;
				}
			}
			else
			{
				dropID = 7;
				return Item.getItemFromBlock(MBlocks.biome_cobble);
			}
		}
		else if(this == MBlocks.coldstone_boulder)
		{
			if (rand.nextInt(100 - fortune * 3) <= 30)
			{
				dropID = 0;
				return MItems.chunks;
			}
			else if (rand.nextInt(100 - fortune * 3) <= 20)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 1;
					return Items.bone;
				}
				else
				{
					dropID = 2;
					return Items.dye;
				}
			}
			else if (rand.nextInt(100 - fortune * 3) <= 18)
			{
				dropID = 3;
				return MItems.chunks;
			}
			else if (rand.nextInt(100 - fortune * 3) <= 13)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 4;
					return Items.redstone;
				}
				else
					dropID = 4;
					return MItems.sunstone_shard;
			}
			else if (rand.nextInt(100 - fortune * 10) == 11)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 5;
					return Items.emerald;
				}
				else
				{
					dropID = 6;
					return Items.diamond;
				}
			}
			else
			{
				dropID = 7;
				return Item.getItemFromBlock(MBlocks.biome_cobble);
			}
		}
		else if(this == MBlocks.icestone_boulder)
		{
			if (rand.nextInt(100 - fortune * 3) <= 30)
			{
				dropID = 0;
				return MItems.chunks;
			}
			else if (rand.nextInt(100 - fortune * 3) <= 20)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 1;
					return Items.snowball;
				}
				else
				{
					dropID = 2;
					return Item.getItemFromBlock(Blocks.ice);
				}
			}
			else if (rand.nextInt(100 - fortune * 3) <= 18)
			{
				dropID = 3;
				return MItems.chunks;
			}
			else if (rand.nextInt(100 - fortune * 3) <= 13)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 4;
					return Item.getItemFromBlock(Blocks.packed_ice);
				}
				else
					dropID = 4;
					return MItems.sunstone_shard;
			}
			else if (rand.nextInt(100 - fortune * 10) == 11)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 5;
					return Items.emerald;
				}
				else
				{
					dropID = 6;
					return Items.diamond;
				}
			}
			else
			{
				dropID = 7;
				return Item.getItemFromBlock(MBlocks.biome_cobble);
			}
		}
		else if(this == MBlocks.oceanstone_boulder)
		{
			if (rand.nextInt(100 - fortune * 3) <= 30)
			{
				dropID = 0;
				return MItems.chunks;
			}
			else if (rand.nextInt(100 - fortune * 3) <= 20)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 1;
					return Items.fish;
				}
				else
				{
					dropID = 2;
					return Items.prismarine_shard;
				}
			}
			else if (rand.nextInt(100 - fortune * 3) <= 18)
			{
				dropID = 3;
				return MItems.chunks;
			}
			else if (rand.nextInt(100 - fortune * 3) <= 13)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 4;
					return Items.redstone;
				}
				else
					dropID = 4;
					return Items.prismarine_crystals;
			}
			else if (rand.nextInt(100 - fortune * 10) == 11)
			{
				if (rand.nextInt(2) == 1)
				{
					dropID = 5;
					return Item.getItemFromBlock(Blocks.sea_lantern);
				}
				else
				{
					dropID = 6;
					return Items.diamond;
				}
			}
			else
			{
				dropID = 7;
				return Item.getItemFromBlock(MBlocks.biome_cobble);
			}
		}
		else
			return Item.getItemFromBlock(Blocks.gravel);
	}
	
	@Override
	public int damageDropped(IBlockState state)
    {
        //TODO: ADD CORRECT METADATA VALUES FOR EACH OUTCOME.
		if (dropID == 0)
		{
			if (this == MBlocks.red_rock_boulder)
				return 1;
			else if (this == MBlocks.coldstone_boulder)
				return 2;
			else if (this == MBlocks.icestone_boulder)
				return 3;
			else if (this == MBlocks.oceanstone_boulder)
				return 4;
			else
				return 0;
		}
		else if (dropID == 1)
		{
			if (this == MBlocks.oceanstone_boulder)
				return 2;
			else
				return 0;
		}
		else if (dropID == 2)
		{
			if(this == MBlocks.coldstone_boulder)
				return 4;
			else
				return 0;
		}
		else if (dropID == 3)
		{
			if (this == MBlocks.stone_boulder)
				return 9;
			else if (this == MBlocks.red_rock_boulder)
				return 5;
			else if (this == MBlocks.coldstone_boulder)
				return 6;
			else if (this == MBlocks.icestone_boulder)
				return 8;
			else if (this == MBlocks.oceanstone_boulder)
				return 7;
			else
				return 0;
		}
		else if (dropID == 4)
		{
			return 0;
		}
		else if (dropID == 5)
		{
			return 0;
		}
		else if (dropID == 6)
		{
			return 0;
		}
		else if (dropID == 7)
		{
			if (this == MBlocks.red_rock_boulder)
				return 1;
			else if (this == MBlocks.coldstone_boulder)
				return 3;
			else if (this == MBlocks.icestone_boulder)
				return 5;
			else if (this == MBlocks.oceanstone_boulder)
				return 7;
			else
				return 0;
		}
		else
		{
			return 0;
		}
    }
	
	@Override
	protected void onStartFalling(EntityFallingBlock fallingEntity)
	{
		fallingEntity.setHurtEntities(true);
	}
	
	@Override
	public void onEndFalling(World worldIn, BlockPos pos)
	{
		worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), "dig.stone", 2.0F, 0.1F);
	}
}
