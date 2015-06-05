package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.enumtypes.MStoneType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMossyCobble extends ItemBlock
{
	
	public ItemBlockMossyCobble(Block block)
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
		return MStoneType.byMetadata(item.getItemDamage()) + "_mossy";
	}
}