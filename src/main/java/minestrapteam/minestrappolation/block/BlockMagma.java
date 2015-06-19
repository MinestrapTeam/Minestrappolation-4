package minestrapteam.minestrappolation.block;

import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.lib.MFluid;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockMagma extends BlockFluidClassic
{
	
	public BlockMagma()
	{
		super(MFluid.MAGMA, Material.lava);
		MFluid.MAGMA.setBlock(this);
		this.setQuantaPerBlock(4);
	}
	
	@Override
	public Fluid getFluid()
	{
		return MFluid.MAGMA;
	}
	
}