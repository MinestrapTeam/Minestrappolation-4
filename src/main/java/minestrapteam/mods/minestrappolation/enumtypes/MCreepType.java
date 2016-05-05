package minestrapteam.mods.minestrappolation.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum MCreepType implements IStringSerializable
{
	DEEPSTONE(0, "deepstone", 0.6F),
	REDROCK(1, "red_rock", 0.6F),
	DEEPREDROCK(2, "deep_redrock", 0.6F),
	COLDSTONE(3, "coldstone", 0.6F),
	DEEPCOLDSTONE(4, "deep_coldstone", 0.6F),
	ICESTONE(5, "icestone", 0.9F),
	GLACIERSTONE(6, "glacierrock", 0.98F),
	OCEANSTONE(7, "oceanstone", 0.6F),
	POCEANSTONE(8, "pressurized_oceanstone", 0.6F),
	STONE(9, "stone", 0.6F),
	NETHERRACK(10, "netherrack", 0.6F),
	ENDSTONE(11, "endstone", 0.6F);

	private static final MCreepType[] META_LOOKUP = new MCreepType[values().length];
	private final int    meta;
	private final String name;
	private final String unlocalizedName;
	private final float  slickness;

	MCreepType(int meta, String name, Float slickness)
	{
		this(meta, name, name, slickness);
	}

	MCreepType(int meta, String name, String unlocalizedName, float slickness)
	{
		this.meta = meta;
		this.name = name;
		this.unlocalizedName = unlocalizedName;
		this.slickness = slickness;
	}

	public int getMetadata()
	{
		return this.meta;
	}

	public float getSlickness()
	{
		return this.slickness;
	}

	@Override
	public String toString()
	{
		return this.name;
	}

	public static MCreepType byMetadata(int meta)
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
		MCreepType[] var0 = values();
		int var1 = var0.length;

		for (int var2 = 0; var2 < var1; ++var2)
		{
			MCreepType var3 = var0[var2];
			META_LOOKUP[var3.getMetadata()] = var3;
		}
	}
}
