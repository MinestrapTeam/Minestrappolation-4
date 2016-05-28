package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSoul extends MBlock
{

	public BlockSoul(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return MItems.soul_gem;
	}

	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(5);
	}

	@Override
	public int getExpDrop(IBlockAccess world, BlockPos pos, int fortune)
	{
		IBlockState state = world.getBlockState(pos);
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
		{
			int j = 0;
			j = MathHelper.getRandomIntegerInRange(rand, 20, 100 + fortune);
			return j;
		}
		return 0;
	}
}
