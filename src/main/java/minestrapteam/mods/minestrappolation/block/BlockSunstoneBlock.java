package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;

import java.util.Random;

public class BlockSunstoneBlock extends MBlock
{

	private final MapColor mapColor;

	public BlockSunstoneBlock(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.mapColor = mapColorIn;
	}

	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return this.mapColor;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		return MathHelper.clamp_int(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 4);
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 2 + random.nextInt(3);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return MItems.sunstone_shard;
	}
}
