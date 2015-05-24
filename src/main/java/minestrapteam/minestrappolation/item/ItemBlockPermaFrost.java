package minestrapteam.minestrappolation.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockPermaFrost extends ItemBlock
{
	
	public ItemBlockPermaFrost(Block block)
	{
		super(block);
		this.setHasSubtypes(false);
		this.setMaxDamage(0);
		
	}
	
	@Override
	public int getMetadata(int damageValue)
	{
		return damageValue;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int renderPass)
	{
		return 10420217;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return "permafrost";
	}
	
}
