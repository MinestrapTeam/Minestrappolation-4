package minestrapteam.minestrappolation.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemMArmor extends ItemArmor
{
	
	Item			repairItem;
	ArmorMaterial	materialType;
	String			textureName;
	
	public ItemMArmor(ArmorMaterial material, int renderIndex, int armorType, Item repair, String texture)
	{
		super(material, renderIndex, armorType);
		this.repairItem = repair;
		this.materialType = material;
		this.textureName = texture;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (this.armorType == 2)
			return "ministrapp:textures/models/armor/" + this.textureName + "_2.png";
		return "ministrapp:textures/models/armor/" + this.textureName + "_1.png";
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		return repair.getItem() == this.repairItem;
	}
}
