package minestrapteam.minestrappolation.item;

import minestrapteam.minestrappolation.enumtypes.MWoodType;
import minestrapteam.minestrappolation.lib.MBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockLeaves extends ItemBlock
{
	
	public ItemBlockLeaves(Block block)
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
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int renderPass)
	{
		if(stack.getItemDamage() == MWoodType.FROZEN.getMetadata())
		{
			return 10420217;
		}
		return MBlocks.ministrapp_leaves.getRenderColor(MBlocks.ministrapp_leaves.getStateFromMeta(stack.getMetadata()));
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return MWoodType.byMetadata(item.getItemDamage()) + "_leaves";
	}
	
}
