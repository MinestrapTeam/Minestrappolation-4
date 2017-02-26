package minestrapteam.mods.minestrappolation.item.blocks;

import minestrapteam.mods.minestrappolation.enumtypes.AllWoodTypes;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMossyPlanks extends ItemBlock
{
	
	public ItemBlockMossyPlanks(Block block)
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
		return AllWoodTypes.byMetadata(item.getItemDamage()) + "_mossy_planks";
	}
	
}
