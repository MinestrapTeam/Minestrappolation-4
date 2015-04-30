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

public class BlockMPlanks extends Block
{
	public static final PropertyEnum	VARIANT	= PropertyEnum.create("variant", MWoodType.class);
	
	public BlockMPlanks()
	{
		super(Material.wood);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, MWoodType.REDWOOD));
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((MWoodType) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		MWoodType[] aenumtype = MWoodType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MWoodType enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, MWoodType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((MWoodType) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { VARIANT });
	}
}
