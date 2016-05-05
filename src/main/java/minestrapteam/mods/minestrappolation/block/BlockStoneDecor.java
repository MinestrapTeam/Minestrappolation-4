package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockStoneDecor extends MBlock
{
	public static final PropertyEnum VARIANT              = PropertyEnum
		                                                        .create("variant", BlockStoneDecor.EnumType.class);
	public static final int          GLOWSTONE_LAMP_META  = BlockStoneDecor.EnumType.GLOWSTONE_LAMP.getMetadata();
	public static final int          PRISMARINE_LAMP_META = BlockStoneDecor.EnumType.PRISMARINE_LAMP.getMetadata();
	public static final int          SUNSTONE_LAMP_META   = BlockStoneDecor.EnumType.SUNSTONE_LAMP.getMetadata();
	public static final int          PATTERN_BRICKS_META  = BlockStoneDecor.EnumType.PATTERN_BRICKS.getMetadata();
	public static final int          TILES_META           = BlockStoneDecor.EnumType.TILES.getMetadata();
	public static final int          REFINED_META         = BlockStoneDecor.EnumType.REFINED.getMetadata();

	public BlockStoneDecor()
	{
		super(Material.rock, MapColor.stoneColor);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockStoneDecor.EnumType.REFINED));
		this.setCreativeTab(Minestrappolation.tabMBuilding);
	}

	/**
	 * Get the damage value that this Block should drop
	 */
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((BlockStoneDecor.EnumType) state.getValue(VARIANT)).getMetadata();
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		BlockStoneDecor.EnumType[] aenumtype = BlockStoneDecor.EnumType.values();
		int i = aenumtype.length;

		for (int j = 0; j < i; ++j)
		{
			BlockStoneDecor.EnumType enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, BlockStoneDecor.EnumType.byMetadata(meta));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockStoneDecor.EnumType) state.getValue(VARIANT)).getMetadata();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, VARIANT);
	}

	public enum EnumType implements IStringSerializable
	{
		GLOWSTONE_LAMP(5, "stone_lamp_glowstone", "lamp_glowstone"),
		PRISMARINE_LAMP(4, "stone_lamp_prismarine", "lamp_prismarine"),
		SUNSTONE_LAMP(3, "stone_lamp_sunstone", "lamp_sunstone"),
		PATTERN_BRICKS(2, "stone_pattern_bricks", "pattern_bricks"),
		TILES(1, "stone_tiles", "tiles"),
		REFINED(0, "stone_refined", "refined");

		private static final BlockStoneDecor.EnumType[] META_LOOKUP = new BlockStoneDecor.EnumType[values().length];
		private final int    meta;
		private final String name;
		private final String unlocalizedName;

		EnumType(int meta, String name, String unlocalizedName)
		{
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}

		public int getMetadata()
		{
			return this.meta;
		}

		@Override
		public String toString()
		{
			return this.name;
		}

		public static BlockStoneDecor.EnumType byMetadata(int meta)
		{
			if (meta < 0 || meta >= META_LOOKUP.length)
			{
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		@Override
		public String getName()
		{
			return this.name;
		}

		public String getUnlocalizedName()
		{
			return this.unlocalizedName;
		}

		static
		{
			BlockStoneDecor.EnumType[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2)
			{
				BlockStoneDecor.EnumType var3 = var0[var2];
				META_LOOKUP[var3.getMetadata()] = var3;
			}
		}
	}
}
