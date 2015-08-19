package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMPane extends BlockPane
{
	
	public BlockMPane(Material materialIn, boolean canDrop)
	{
		super(materialIn, canDrop);
		this.setCreativeTab(Minestrappolation.tabMDecor);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		if(this == MBlocks.glow_glass_pane)
			return EnumWorldBlockLayer.TRANSLUCENT;
		else
			return EnumWorldBlockLayer.CUTOUT;
	}
	
}
