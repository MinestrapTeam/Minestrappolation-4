package minestrapteam.minestrappolation.block;

import java.util.Iterator;
import java.util.Random;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MItems;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MBlockOre extends MBlock
{
	Item itemStack;
	int dropAmount;
	int bonusAmount;
	int expMin;
	int expMax;
	int meta;
	boolean silkHarvest;
	
	public MBlockOre(Material materialIn, MapColor mapColorIn, Item itemDrop, int meta, int expMin, int expMax, int dropAmount, int bonusAmount, String tool, int level, boolean silkHarvest)
	{
		super(materialIn, mapColorIn);
		this.itemStack = itemDrop;
		this.expMin = expMin;
		this.expMax = expMax;
		this.dropAmount = dropAmount;
		this.bonusAmount = bonusAmount;
		this.setHarvestLevel(tool, level);
		this.silkHarvest = silkHarvest;
		this.meta = meta;
	}
	
	public MBlockOre(Material materialIn, MapColor mapColorIn, Item itemDrop, int expMin, int expMax, int dropAmount, int bonusAmount, String tool, int level, boolean silkHarvest)
	{
		super(materialIn, mapColorIn);
		this.itemStack = itemDrop;
		this.expMin = expMin;
		this.expMax = expMax;
		this.dropAmount = dropAmount;
		this.bonusAmount = bonusAmount;
		this.setHarvestLevel(tool, level);
		this.silkHarvest = silkHarvest;
		this.meta = 0;
	}
	
	@Override
	public int damageDropped(IBlockState state)
    {
        return meta;
    }

	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if(itemStack != null)
		{
			return itemStack;
		}
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		if(bonusAmount == 0)
		{
			return dropAmount;
		}
		return  dropAmount + random.nextInt(bonusAmount);
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState) this.getBlockState().getValidStates().iterator().next(), random, fortune))
		{
			int j = random.nextInt(fortune + 2) - 1;
			
			if (j < 0)
			{
				j = 0;
			}
			
			return this.quantityDropped(random) * (j + 1);
		}
		else
			return this.quantityDropped(random);
	}
	
	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
	{
		super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
	}
	
	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
	{
		IBlockState state = world.getBlockState(pos);
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
		{
			int j = 0;		
			j = MathHelper.getRandomIntegerInRange(rand, expMin, expMax + fortune);
			return j;
		}
		return 0;
	}
	
	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		return this.silkHarvest;
	}
}
