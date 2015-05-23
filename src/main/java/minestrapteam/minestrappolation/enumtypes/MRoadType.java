package minestrapteam.minestrappolation.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum MRoadType implements IStringSerializable
{
	COBBLE(0, "cobble", 1.2D),
	GRAVEL(1, "gravel", 1.25D),
	SAND(2, "sand", 1.2D),
	REDSAND(3, "red_sand", 1.25D),
	NEHTER(4, "nether", 1.4F);
	private static final MRoadType[]	META_LOOKUP	= new MRoadType[values().length];
	private final int					meta;
	private final String				name;
	private final double				speed;
	private final String				unlocalizedName;
	
	private MRoadType(int meta, String name, double speed)
	{
		this(meta, name, name, speed);
	}
	
	private MRoadType(int meta, String name, String unlocalizedName, double speed)
	{
		this.meta = meta;
		this.name = name;
		this.speed = speed;
		this.unlocalizedName = unlocalizedName;
	}
	
	public int getMetadata()
	{
		return this.meta;
	}
	
	public double getSpeed()
	{
		return this.speed;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
	
	public static MRoadType byMetadata(int meta)
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
		MRoadType[] var0 = values();
		int var1 = var0.length;
		
		for (int var2 = 0; var2 < var1; ++var2)
		{
			MRoadType var3 = var0[var2];
			META_LOOKUP[var3.getMetadata()] = var3;
		}
	}
}