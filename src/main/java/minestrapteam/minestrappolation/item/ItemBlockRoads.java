package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.enumtypes.MRoadType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockRoads extends ItemBlock
{
	
	public ItemBlockRoads(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		
	}
	
	@Override
	public int getMetadata(int damageValue)
	{
		return damageValue;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return MRoadType.byMetadata(item.getItemDamage()) + "_road";
	}
}