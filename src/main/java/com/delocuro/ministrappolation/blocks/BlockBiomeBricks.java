package com.delocuro.ministrappolation.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.delocuro.ministrappolation.Minestrappolation;

public class BlockBiomeBricks extends Block
{
	private static final PropertyEnum	VARIANT	= PropertyEnum.create("type", MStoneType.class);
	
	public BlockBiomeBricks()
	{
		super(Material.rock);
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
		this.setUnlocalizedName("biome_bricks");
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { VARIANT });
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((MStoneType) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		MStoneType[] aenumtype = MStoneType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MStoneType enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
		
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, MStoneType.byMetadata(meta & 7));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((MStoneType) state.getValue(VARIANT)).getMetadata();
	}
	
}
