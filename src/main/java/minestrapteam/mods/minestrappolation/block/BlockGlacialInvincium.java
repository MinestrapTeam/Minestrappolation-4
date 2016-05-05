package minestrapteam.mods.minestrappolation.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGlacialInvincium extends MBlock
{
	public BlockGlacialInvincium(Material material, MapColor mapcolor)
	{
		super(material, mapcolor);
		this.slipperiness = 0.98F;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
	{
		super.onEntityCollidedWithBlock(world, pos, state, entity);
		entity.extinguish();
	}

	@Override
	public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
	{
		return false;
	}
}
