package minestrapteam.mods.minestrappolation.item.biomeitems;

import minestrapteam.mods.minestrappolation.enumtypes.MStoneType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBiomeGold extends ItemBlock
{
	
	public ItemBlockBiomeGold(Block block)
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
		return MStoneType.byMetadata(item.getItemDamage()) + "_gold";
	}
}