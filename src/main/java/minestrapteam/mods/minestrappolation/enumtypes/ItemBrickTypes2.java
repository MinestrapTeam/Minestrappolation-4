package minestrapteam.mods.minestrappolation.enumtypes;

import net.minecraft.util.IStringSerializable;

public enum ItemBrickTypes2 implements IStringSerializable
{
	SANDSTONE(0, "sandstone"),
	RED_SANDSTONE(1, "red_sandstone");
	
	private static final ItemBrickTypes2[]	META_LOOKUP	= new ItemBrickTypes2[values().length];
	private final int						meta;
	private final String					name;
	private final String					unlocalizedName;
	
	private ItemBrickTypes2(int meta, String name)
	{
		this(meta, name, name);
	}
	
	private ItemBrickTypes2(int meta, String name, String unlocalizedName)
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
	
	public static ItemBrickTypes2 byMetadata(int meta)
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
		ItemBrickTypes2[] var0 = values();
		int var1 = var0.length;
		
		for (int var2 = 0; var2 < var1; ++var2)
		{
			ItemBrickTypes2 var3 = var0[var2];
			META_LOOKUP[var3.getMetadata()] = var3;
		}
	}
}