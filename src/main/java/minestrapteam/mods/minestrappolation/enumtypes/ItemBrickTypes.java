package minestrapteam.mods.minestrappolation.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum ItemBrickTypes implements IStringSerializable
{
	STONE(0, "stone"),
	DEEPSTONE(1, "deepstone"),
	RED_ROCK(2, "red_rock"),
	DEEP_RED_ROCK(3, "deep_red_rock"),
	COLDSTONE(4, "coldstone"),
	DEEP_COLDSTONE(5, "deep_coldstone"),
	ICESTONE(6, "icestone"),
	GLACIERROCK(7, "glacierrock"),
	OCEANSTONE(8, "oceanstone"),
	POCEANSTONE(9, "pressurized_oceanstone"),
	SLATE(10, "slate"),
	GRANITE(11, "granite"),
	DIORITE(12, "diorite"),
	ANDESITE(13, "andesite"),
	FLINT(14, "flint"),
	OBSIDIAN(15, "obsidian");
	
	private static final ItemBrickTypes[]	META_LOOKUP	= new ItemBrickTypes[values().length];
	private final int						meta;
	private final String					name;
	private final String					unlocalizedName;
	
	private ItemBrickTypes(int meta, String name)
	{
		this(meta, name, name);
	}
	
	private ItemBrickTypes(int meta, String name, String unlocalizedName)
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
	
	public static ItemBrickTypes byMetadata(int meta)
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
		ItemBrickTypes[] var0 = values();
		int var1 = var0.length;
		
		for (int var2 = 0; var2 < var1; ++var2)
		{
			ItemBrickTypes var3 = var0[var2];
			META_LOOKUP[var3.getMetadata()] = var3;
		}
	}
}