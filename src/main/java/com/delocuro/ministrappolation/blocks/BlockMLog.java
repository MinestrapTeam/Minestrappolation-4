package com.delocuro.ministrappolation.blocks;

import java.util.List;

import net.minecraft.block.BlockLog;
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
import com.google.common.base.Predicate;

public class BlockMLog extends BlockLog
{
	public static final PropertyEnum	VARIANT	= PropertyEnum.create("variant", MWoodType.class, new Predicate()
												{
													public boolean apply(MWoodType type)
													{
														return type.getMetadata() < 4;
													}
													
													@Override
													public boolean apply(Object p_apply_1_)
													{
														return this.apply((MWoodType) p_apply_1_);
													}
												});
	
	public BlockMLog()
	{
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, MWoodType.REDWOOD).withProperty(AXIS_PROP, BlockLog.EnumAxis.Y));
		this.setCreativeTab(Minestrappolation.tabMinistrappolation);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(itemIn, 1, MWoodType.REDWOOD.getMetadata()));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, MWoodType.byMetadata((meta & 3) % 4));
		
		switch (meta & 12)
		{
		case 0:
			iblockstate = iblockstate.withProperty(AXIS_PROP, BlockLog.EnumAxis.Y);
			break;
		case 4:
			iblockstate = iblockstate.withProperty(AXIS_PROP, BlockLog.EnumAxis.X);
			break;
		case 8:
			iblockstate = iblockstate.withProperty(AXIS_PROP, BlockLog.EnumAxis.Z);
			break;
		default:
			iblockstate = iblockstate.withProperty(AXIS_PROP, BlockLog.EnumAxis.NONE);
		}
		
		return iblockstate;
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		byte b0 = 0;
		int i = b0 | ((MWoodType) state.getValue(VARIANT)).getMetadata();
		
		switch ((BlockLog.EnumAxis) state.getValue(AXIS_PROP))
		{
		case X:
			i |= 4;
			break;
		case Y:
			i |= 8;
			break;
		case Z:
			i |= 12;
		default:
			break;
		}
		
		return i;
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { VARIANT, AXIS_PROP });
	}
	
	@Override
	protected ItemStack createStackedBlock(IBlockState state)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((MWoodType) state.getValue(VARIANT)).getMetadata());
	}
	
	/**
	 * Get the damage value that this Block should drop
	 */
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((MWoodType) state.getValue(VARIANT)).getMetadata();
	}
	
}
