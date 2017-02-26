package minestrapteam.mods.minestrappolation.item.blocks;

import minestrapteam.mods.minestrappolation.enumtypes.MWoodType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockSapling extends ItemBlock
{
	
	public ItemBlockSapling(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return MWoodType.byMetadata(item.getItemDamage()) + "_sapling";
	}
	
}
