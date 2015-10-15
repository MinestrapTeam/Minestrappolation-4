package minestrapteam.mods.minestrappolation.item.blocks;

import minestrapteam.mods.minestrappolation.block.BlockCarvedPumpkin;
import minestrapteam.mods.minestrappolation.enumtypes.MPumpkinType;
import minestrapteam.mods.minestrappolation.enumtypes.MStoneType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCarvedPumpkin extends ItemBlock
{
	
	public ItemBlockCarvedPumpkin(Block block)
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
		return MPumpkinType.byMetadata(item.getItemDamage()) + "_carved";
	}
}