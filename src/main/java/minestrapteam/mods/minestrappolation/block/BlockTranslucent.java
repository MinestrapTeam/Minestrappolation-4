package minestrapteam.mods.minestrappolation.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTranslucent extends BlockTransparent
{
	
	private boolean	ignoreSimilarity;
	
	public BlockTranslucent(Material materialIn, MapColor mapColorIn, boolean ignoreSimilarityIn)
	{
		super(materialIn, mapColorIn, ignoreSimilarityIn);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.TRANSLUCENT;
	}
}
