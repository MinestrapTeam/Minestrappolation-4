package minestrapteam.mods.minestrappolation.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum MBlockBiDirectional implements IStringSerializable
{
	UD(0, "ud"),
	UN(1, "un"),
	UE(2, "ue"),
	US(3, "us"),
	UW(4, "uw"),
	DN(5, "dn"),
	DE(6, "de"),
	DS(7, "ds"),
	DW(8, "dw"),
	NE(9, "ne"),
	NS(10, "ns"),
	NW(11, "nw"),
	ES(12, "es"),
	EW(13, "ew"),
	SW(14, "sw");

	private static final MBlockBiDirectional[] META_LOOKUP = new MBlockBiDirectional[values().length];
	private final int    meta;
	private final String name;
	private final String unlocalizedName;

	MBlockBiDirectional(int meta, String name)
	{
		this(meta, name, name);
	}

	MBlockBiDirectional(int meta, String name, String unlocalizedName)
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

	public static MBlockBiDirectional byMetadata(int meta)
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
		MBlockBiDirectional[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2)
		{
			MBlockBiDirectional var3 = var0[var2];
			META_LOOKUP[var3.getMetadata()] = var3;
		}
	}
}
