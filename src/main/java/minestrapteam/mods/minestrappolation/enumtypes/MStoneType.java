package minestrapteam.mods.minestrappolation.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum MStoneType implements IStringSerializable
{
	DEEPSTONE(0, "deepstone", 0.6F),
	REDROCK(1, "red_rock", 0.6F),
	DEEPREDROCK(2, "deep_redrock", 0.6F),
	COLDSTONE(3, "coldstone", 0.6F),
	DEEPCOLDSTONE(4, "deep_coldstone", 0.6F),
	ICESTONE(5, "icestone", 0.9F),
	GLACIERSTONE(6, "glacierrock", 0.98F),
	OCEANSTONE(7, "oceanstone", 0.6F),
	POCEANSTONE(8, "pressurized_oceanstone", 0.6F);
	
	private static final MStoneType[]	META_LOOKUP	= new MStoneType[values().length];
	private final int					meta;
	private final String				name;
	private final String				unlocalizedName;
	private final float					slickness;
	
	private MStoneType(int meta, String name, Float slickness)
	{
		this(meta, name, name, slickness);
	}
	
	private MStoneType(int meta, String name, String unlocalizedName, float slickness)
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