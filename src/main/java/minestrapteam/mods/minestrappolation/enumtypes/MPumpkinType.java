package minestrapteam.mods.minestrappolation.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum MPumpkinType implements IStringSerializable
{
	SIMPLE(0, "simple"),
	AVERAGE(1, "average"),
	COMPLEX(2, "complex");
	private static final MPumpkinType[] META_LOOKUP = new MPumpkinType[values().length];
	private final int    meta;
	private final String name;
	private final String unlocalizedName;

	MPumpkinType(int meta, String name)
	{
		this(meta, name, name);
	}

	MPumpkinType(int meta, String name, String unlocalizedName)
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

	public static MPumpkinType byMetadata(int meta)
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
		MPumpkinType[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2)
		{
			MPumpkinType var3 = var0[var2];
			META_LOOKUP[var3.getMetadata()] = var3;
		}
	}
}
