package minestrapteam.mods.minestrappolation.item.blocks;

import minestrapteam.mods.minestrappolation.block.BlockCarvedPumpkin;
import minestrapteam.mods.minestrappolation.enumtypes.MPumpkinType;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCarvedPumpkin extends ItemBlock
{
	public Block block;

	public ItemBlockCarvedPumpkin(Block block)
	{
		super(block);
		this.block = block;
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	/*
	public static void inventoryRender(String type)
	{
		Item itemBlockBrickVariants = Item.getItemFromBlock(GameRegistry.findBlock(MReference.MODID, "pumpkin_carved"));
		
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:pumpkin_simple_carved_" + type);
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:pumpkin_average_carved_" + type);
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:pumpkin_complex_carved_" + type);
		
		Item itemBlockVariants = Item.getItemFromBlock(GameRegistry.findBlock(MReference.MODID, "pumpkin_carved"));
		MPumpkinType[] aenumtype = MPumpkinType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MPumpkinType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + "pumpkin_" + enumtype.getUnlocalizedName() + "_carved_" + type, "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
	*/

	@Override
	public int getMetadata(int damageValue)
	{
		return damageValue;
	}

	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return MPumpkinType.byMetadata(item.getItemDamage()) + "_carved_" + ((BlockCarvedPumpkin) this.block).type;
	}
}
