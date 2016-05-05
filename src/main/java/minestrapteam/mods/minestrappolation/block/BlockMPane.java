package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMPane extends BlockPane
{
	private int flammability;

	public BlockMPane(Material materialIn, boolean canDrop, int flame)
	{
		super(materialIn, canDrop);
		this.setCreativeTab(Minestrappolation.tabMDecor);
		this.flammability = flame;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		if (this == MBlocks.glow_glass_pane)
			return EnumWorldBlockLayer.TRANSLUCENT;
		else
			return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return this.flammability;
	}
}
