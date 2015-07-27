package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

public class BlockMSlab extends BlockSlab
{
    private int flammability;
	
	public BlockMSlab(Material mat, String name, float hardness, float resistance, String tool, int harvestLevel, int flame)
    {
        super(mat);
        IBlockState iblockstate = this.blockState.getBaseState();
        setUnlocalizedName(name);
        setCreativeTab(Minestrappolation.tabMBuilding);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, harvestLevel);
        this.useNeighborBrightness = true;
        this.flammability = flame;
        if(mat == Material.wood)
        	setStepSound(Block.soundTypeWood);
        else if(mat == Material.rock)
        	setStepSound(Block.soundTypePiston);
        if(this == MBlocks.radiant_slab)
        	this.setLightLevel(0.6F);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
     
    	IBlockState iblockstate = this.getDefaultState();
    	if(!this.isDouble())iblockstate = iblockstate.withProperty(HALF, (meta) == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);

        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0;

        if (!this.isDouble() && state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP)
        {
            i |= 8;
        }

        return i;
    }

    @Override
    protected BlockState createBlockState()
    {
        return this.isDouble() ? new BlockState(this, new IProperty[] {}): new BlockState(this, new IProperty[] {HALF});
    }

	@Override
	public boolean isDouble() {
		return false;
	}

	@Override
	public String getUnlocalizedName(int meta) 
	{
		return null;
	}

	@Override
	public IProperty getVariantProperty() 
	{
		return null;
	}

	@Override
	public Object getVariant(ItemStack stack)
	{
		return null;
	}
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
	{
		return this.flammability;
	}
	
	@Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }
}
