package minestrapteam.minestrappolation.block;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BlockMSlab extends BlockSlab
{
    public BlockMSlab(Material mat, String name, float hardness, float resistance)
    {
        super(mat);
        IBlockState iblockstate = this.blockState.getBaseState();
        setUnlocalizedName(name);
        setCreativeTab(CreativeTabs.tabBlock);
        setHardness(hardness);
        setResistance(resistance);
        this.useNeighborBrightness = true;
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
    public int damageDropped(IBlockState state)
    {
        return 0;
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
}
