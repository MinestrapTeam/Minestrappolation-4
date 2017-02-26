package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		return MathHelper.clamp(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 5);
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
