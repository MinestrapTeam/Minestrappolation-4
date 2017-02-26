package minestrapteam.mods.minestrappolation.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum AllWoodTypes implements IStringSerializable
{
	OAK(0, "oak"),
	SPRUCE(1, "spruce"),
	BIRCH(2, "birch"),
	JUNGLE(3, "jungle"),
	ACACIA(4, "acacia"),
	DARK(5, "dark_oak"),
	REDWOOD(6, "redwood"),
	FROZEN(7, "frozen_oak");
	private static final AllWoodTypes[]	META_LOOKUP	= new AllWoodTypes[values().length];
	private final int					meta;
	private final String				name;
	private final String				unlocalizedName;
	
	private AllWoodTypes(int meta, String name)
	{
		this(meta, name, name);
	}
	
	private AllWoodTypes(int meta, String name, String unlocalizedName)
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
	
	public static AllWoodTypes byMetadata(int meta)
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
		AllWoodTypes[] var0 = values();
		int var1 = var0.length;
		
		for (int var2 = 0; var2 < var1; ++var2)
		{
			AllWoodTypes var3 = var0[var2];
			META_LOOKUP[var3.getMetadata()] = var3;
		}
	}
}