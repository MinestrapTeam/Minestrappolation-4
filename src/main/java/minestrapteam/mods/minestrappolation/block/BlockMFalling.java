package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockMFalling extends BlockFalling
{

	private final MapColor mapColor;
	public        int      meta;
	public        boolean  droppingItem;

	public BlockMFalling(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn);
		this.mapColor = mapColorIn;
		this.meta = 0;
		this.droppingItem = false;
	}

	@Override
	public MapColor getMapColor(IBlockState state)
	{
		return this.mapColor;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		if (fortune > 3)
		{
			fortune = 3;
		}

		Item item = new Item();
		int chance = rand.nextInt(2);

		if (chance == 0)
			item = MItems.bricks;
		else
			item = MItems.chunks;

		if (this == MBlocks.rubble)
		{
			if (rand.nextInt(10 - fortune * 3) == 0)
			{
				this.droppingItem = true;
				return item;
			}
			else
			{
				this.droppingItem = false;
				return Item.getItemFromBlock(this);
			}
		}
		else
			return Item.getItemFromBlock(this);
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		Random rand = new Random();
		if (this.droppingItem == true)
			return rand.nextInt(10);
		else
			return 0;
	}
}
