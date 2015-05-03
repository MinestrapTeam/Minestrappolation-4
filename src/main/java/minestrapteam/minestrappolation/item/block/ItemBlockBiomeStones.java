package minestrapteam.minestrappolation.item.block;

import minestrapteam.minestrappolation.block.MStoneType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBiomeStones extends ItemBlock
{
	
	public ItemBlockBiomeStones(Block block)
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
		return MStoneType.byMetadata(item.getItemDamage()) + "_rock";
	}
	
}