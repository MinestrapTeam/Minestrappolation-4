package minestrapteam.mods.minestrappolation.item.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockVirtianGrass extends ItemBlock
{

	public ItemBlockVirtianGrass(Block block)
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
		return 8494438;
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return "virtian_grass";
	}
}
