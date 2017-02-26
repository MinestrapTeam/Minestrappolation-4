package minestrapteam.mods.minestrappolation.block.ore;

import java.util.Random;

import minestrapteam.mods.minestrappolation.block.MBlock;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MBlockOre extends MBlock
{
	Item	itemStack;
	int		dropAmount;
	int		bonusAmount;
	int		expMin;
	int		expMax;
	int		meta;
	boolean	silkHarvest;
	
	boolean	isBeingSilkHarvested	= false;
	
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
		if (this.isBeingSilkHarvested == true)
			return this.getMetaFromState(state);
		return this.meta;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		System.out.println(this.meta);
		if (this.itemStack != null)
			return this.itemStack;
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		if (this.bonusAmount == 0)
			return this.dropAmount;
		return this.dropAmount + random.nextInt(this.bonusAmount);
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
			j = MathHelper.getRandomIntegerInRange(rand, this.expMin, this.expMax + fortune);
			return j;
		}
		return 0;
	}
	
	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te)
	{
		player.triggerAchievement(StatList.mineBlockStatArray[getIdFromBlock(this)]);
		player.addExhaustion(0.025F);
		
		if (this.canSilkHarvest(worldIn, pos, worldIn.getBlockState(pos), player) && EnchantmentHelper.getSilkTouchModifier(player))
		{
			this.isBeingSilkHarvested = true;
			java.util.ArrayList<ItemStack> items = new java.util.ArrayList<ItemStack>();
			ItemStack itemstack = this.createStackedBlock(state);
			
			if (itemstack != null)
			{
				items.add(itemstack);
			}
			
			net.minecraftforge.event.ForgeEventFactory.fireBlockHarvesting(items, worldIn, pos, worldIn.getBlockState(pos), 0, 1.0f, true, player);
			for (ItemStack stack : items)
			{
				spawnAsEntity(worldIn, pos, stack);
			}
		}
		else
		{
			this.harvesters.set(player);
			int i = EnchantmentHelper.getFortuneModifier(player);
			this.dropBlockAsItem(worldIn, pos, state, i);
			this.harvesters.set(null);
		}
	}
	
	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		
		return this.silkHarvest;
	}
	
	@Override
    public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
    {
        if (entity instanceof net.minecraft.entity.boss.EntityDragon && (this == MBlocks.continnium_ore || this == MBlocks.dimensium_ore))
        {
            return false;
        }

        return true;
    }
}
