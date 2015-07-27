package minestrapteam.mods.minestrappolation.item.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockColdSand extends ItemBlock
{
	
	public ItemBlockColdSand(Block block)
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
		return "cold_" + BlockSand.EnumType.byMetadata(item.getItemDamage());
	}
	
}
