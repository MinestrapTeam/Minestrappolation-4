package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockGlaciericIce extends MBlock
{

	public BlockGlaciericIce(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
		this.slipperiness = 1.1F;
		this.setLightLevel(0.3F);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.TRANSLUCENT;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		return MathHelper.clamp_int(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 5);
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 1 + random.nextInt(4);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return MItems.glacieric_ice_shard;
	}
}
