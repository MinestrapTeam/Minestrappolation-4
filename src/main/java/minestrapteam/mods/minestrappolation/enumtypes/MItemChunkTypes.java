package minestrapteam.mods.minestrappolation.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum MItemChunkTypes implements IStringSerializable
{
	STONE(0, "stone"),
	RED_ROCK(1, "red_rock"),
	COLDSTONE(2, "coldstone"),
	ICESTONE(3, "icestone"),
	OCEANSTONE(4, "oceanstone"),
	COPPER(5, "copper"),
	TIN(6, "tin"),
	IRON(7, "iron"),
	GOLD(8, "gold"),
	TORITE(9, "torite"),
	TITANIUM(10, "titanium");

	private static final MItemChunkTypes[] META_LOOKUP = new MItemChunkTypes[values().length];
	private final int    meta;
	private final String name;
	private final String unlocalizedName;

	MItemChunkTypes(int meta, String name)
	{
		this(meta, name, name);
	}

	MItemChunkTypes(int meta, String name, String unlocalizedName)
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

	public static MItemChunkTypes byMetadata(int meta)
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
		MItemChunkTypes[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2)
		{
			MItemChunkTypes var3 = var0[var2];
			META_LOOKUP[var3.getMetadata()] = var3;
		}
	}
}
