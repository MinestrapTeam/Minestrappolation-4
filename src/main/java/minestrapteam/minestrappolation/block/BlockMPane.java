package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Minestrappolation;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

public class BlockMPane extends BlockPane
{
	
	public BlockMPane(Material materialIn, boolean canDrop)
	{
		super(materialIn, canDrop);
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
	}
	
}
