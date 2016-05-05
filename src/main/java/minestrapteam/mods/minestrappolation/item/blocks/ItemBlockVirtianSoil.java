package minestrapteam.mods.minestrappolation.item.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockVirtianSoil extends ItemBlock
{
	public ItemBlockVirtianSoil(Block block)
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
		return "virtian_soil_" + BlockDirt.DirtType.byMetadata(item.getItemDamage());
	}
}
