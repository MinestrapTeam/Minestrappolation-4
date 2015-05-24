package minestrapteam.minestrappolation.inventory.slot;

import minestrapteam.minestrappolation.util.MelterRecipes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class SlotMelter extends Slot
{
	private EntityPlayer	thePlayer;
	private int				amountCrafted;
	
	public SlotMelter(EntityPlayer player, IInventory inventory, int id, int x, int y)
	{
		super(inventory, id, x, y);
		this.thePlayer = player;
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return false;
	}
	
	@Override
	public ItemStack decrStackSize(int amount)
	{
		if (this.getHasStack())
		{
			this.amountCrafted += Math.min(amount, this.getStack().stackSize);
		}
		return super.decrStackSize(amount);
	}
	
	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack stack)
	{
		this.onCrafting(stack);
		super.onPickupFromSlot(player, stack);
	}
	
	@Override
	protected void onCrafting(ItemStack stack, int amount)
	{
		this.amountCrafted += amount;
		this.onCrafting(stack);
	}
	
	@Override
	protected void onCrafting(ItemStack stack)
	{
		stack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.amountCrafted);
		if (!this.thePlayer.worldObj.isRemote)
		{
			int amount = this.amountCrafted;
			float exp = MelterRecipes.instance().getSmeltingExperience(stack);
			int exp1;
			if (exp == 0.0F)
			{
				amount = 0;
			}
			else if (exp < 1.0F)
			{
				exp1 = MathHelper.floor_float(amount * exp);
				if (exp1 < MathHelper.ceiling_float_int(amount * exp) && (float) Math.random() < amount * exp - exp1)
				{
					++exp1;
				}
				amount = exp1;
			}
			while (amount > 0)
			{
				exp1 = EntityXPOrb.getXPSplit(amount);
				amount -= exp1;
				this.thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.worldObj, this.thePlayer.posX, this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, exp1));
			}
		}
		this.amountCrafted = 0;
	}
}
