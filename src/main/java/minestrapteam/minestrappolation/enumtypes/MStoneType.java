package minestrapteam.minestrappolation.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum MStoneType implements IStringSerializable
{
	DEEPSTONE(0, "deepstone"),
	REDROCK(1, "red_rock"),
	DEEPREDROCK(2, "deep_redrock"),
	COLDSTONE(3, "coldstone"),
	DEEPCOLDSTONE(4, "deep_coldstone"),
	ICESTONE(5, "icestone"),
	GLACIERSTONE(6, "glacierrock"),
	OCEANSTONE(7, "oceanstone"),
	POCEANSTONE(8, "pressurized_oceanstone");
	private static final MStoneType[]	META_LOOKUP	= new MStoneType[values().length];
	private final int					meta;
	private final String				name;
	private final String				unlocalizedName;
	
	private MStoneType(int meta, String name)
	{
		this(meta, name, name);
	}
	
	private MStoneType(int meta, String name, String unlocalizedName)
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
	
	public static MStoneType byMetadata(int meta)
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
		MStoneType[] var0 = values();
		int var1 = var0.length;
		
		for (int var2 = 0; var2 < var1; ++var2)
		{
			MStoneType var3 = var0[var2];
			META_LOOKUP[var3.getMetadata()] = var3;
		}
	}
}