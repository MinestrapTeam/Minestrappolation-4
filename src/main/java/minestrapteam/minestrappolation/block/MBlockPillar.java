package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.Minestrappolation;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;

public class MBlockPillar extends BlockRotatedPillar{

	public MBlockPillar(Material materialIn) 
	{
		super(materialIn);
		this.setCreativeTab(Minestrappolation.tabMBuilding);
	}

}
