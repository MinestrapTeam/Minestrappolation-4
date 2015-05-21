package minestrapteam.minestrappolation.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
