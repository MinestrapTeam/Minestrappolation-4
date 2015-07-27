package minestrapteam.mods.minestrappolation.item;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemAmuletPorcum extends ItemAmulet
{
	public ItemAmuletPorcum()
	{
		super(50);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean flag)
	{
		if (!world.isRemote && flag && entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
			if (player.getRNG().nextInt(60) == 0 && player.getFoodStats().needFood())
			{
				player.getFoodStats().addStats(1, 0F);
				stack.damageItem(1, player);
			}
		}
	}
}