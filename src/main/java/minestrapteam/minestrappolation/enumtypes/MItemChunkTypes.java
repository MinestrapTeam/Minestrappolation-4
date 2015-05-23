package minestrapteam.minestrappolation.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum MItemChunkTypes implements IStringSerializable
{
	STONE(0, "stone"),
	IRON(1, "iron"),
	GOLD(2, "gold"),
	TIN(3, "tin"),
	COPPER(4, "copper");
	private static final MItemChunkTypes[]	META_LOOKUP	= new MItemChunkTypes[values().length];
	private final int					meta;
	private final String				name;
	private final String				unlocalizedName;
	
	private MItemChunkTypes(int meta, String name)
	{
		this(meta, name, name);
	}
	
	private MItemChunkTypes(int meta, String name, String unlocalizedName)
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