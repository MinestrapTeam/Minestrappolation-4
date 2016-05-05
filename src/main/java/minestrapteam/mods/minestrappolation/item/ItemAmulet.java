package minestrapteam.mods.minestrappolation.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemAmulet extends Item
{
	private String desc;

	public ItemAmulet(int maxDamage, String desc)
	{
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(maxDamage);
		this.desc = desc;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced)
	{
		tooltip.add(this.desc);
	}
}
