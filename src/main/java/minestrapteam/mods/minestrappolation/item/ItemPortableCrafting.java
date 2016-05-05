package minestrapteam.mods.minestrappolation.item;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPortableCrafting extends Item
{
	//0 = crafting, 1 = milling, 2 = cutting
	private int type;

	public ItemPortableCrafting(int type)
	{
		this.maxStackSize = 1;
		this.type = type;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 1;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		ItemPortableCrafting item = (ItemPortableCrafting) player.getHeldItem().getItem();

		if (!world.isRemote)
		{
			if (!player.isSneaking())
			{
				if (item.type == 0)
				{
					player.displayGui(new BlockWorkbench.InterfaceCraftingTable(world, player.getPosition()));
				}
			}
		}
		return stack;
	}
}
