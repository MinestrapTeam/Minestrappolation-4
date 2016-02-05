package minestrapteam.mods.minestrappolation.item;

import java.util.List;

import minestrapteam.mods.minestrappolation.enumtypes.ItemChipTypes;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemUpgradeChips extends Item
{
	
	public ItemUpgradeChips()
	{
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
	}
	
	public static void inventoryRender()
	{
		Item itemBlockBrickVariants = GameRegistry.findItem(MReference.MODID, "chips");
		
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:preserver_chips");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:collision_chips");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:inversion_chips");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:selfsufficient_chips");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:placer_chips");
		
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "chips");
		ItemChipTypes[] aenumtype = ItemChipTypes.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			ItemChipTypes enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + enumtype.getUnlocalizedName() + "_chips", "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, List list)
	{
		ItemChipTypes[] aenumtype = ItemChipTypes.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			ItemChipTypes enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item)
	{
		return ItemChipTypes.byMetadata(item.getItemDamage()) + "_chips";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced)
	{
		if(stack.getItemDamage() == 0)
		{
			tooltip.add("Enderporter Upgrade.");
			tooltip.add("Lowers the chance of the");
			tooltip.add("Enderporter consuming an");
			tooltip.add("Ender Pearl when used.");
		}
		if(stack.getItemDamage() == 1)
		{
			tooltip.add("Enderporter Upgrade.");
			tooltip.add("Makes the Enderporter");
			tooltip.add("teleport any entity that");
			tooltip.add("touches it.");
		}
		if(stack.getItemDamage() == 2)
		{
			tooltip.add("Enderporter Upgrade.");
			tooltip.add("Sends teleported entities");
			tooltip.add("below the recieving Enderporter,");
			tooltip.add("rather than above it.");
		}
		if(stack.getItemDamage() == 3)
		{
			tooltip.add("Enderporter Upgrade.");
			tooltip.add("Allows the Enderporter to");
			tooltip.add("teleport entities to locations");
			tooltip.add("without another Enderporter.");
		}
		if(stack.getItemDamage() == 4)
		{
			tooltip.add("Enderporter Upgrade.");
			tooltip.add("Makes the Enderporter place");
			tooltip.add("teleported block entities at");
			tooltip.add("the destination point.");
		}
	}
}