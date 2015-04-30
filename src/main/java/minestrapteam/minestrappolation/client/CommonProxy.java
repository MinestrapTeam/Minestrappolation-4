package minestrapteam.minestrappolation.client;

import minestrapteam.minestrappolation.block.MStoneType;
import minestrapteam.minestrappolation.lib.MReference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class CommonProxy implements IGuiHandler
{
	@Override
	public abstract Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z);
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
	
	public void preInit(FMLPreInitializationEvent event)
	{
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "biome_stone");
		
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:deepstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:coldstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:icestone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:glacierrock");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:deep_coldstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:red_rock");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:deep_redrock");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:oceanstone");
		ModelBakery.addVariantName(itemBlockVariants, "ministrapp:p_oceanstone");
	}
	
	public void init(FMLInitializationEvent event)
	{
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "biome_stone");
		
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":deepstone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.DEEPSTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":coldstone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.COLDSTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":icestone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.ICESTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":glacierrock", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.GLACIERSTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":deep_coldstone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.DEEPCOLDSTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":red_rock", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.REDROCK.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":deep_redrock", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.DEEPREDROCK.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":oceanstone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.OCEANSTONE.getMetadata(), itemModelResourceLocation);
		
		itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":pressurized_oceanstone", "inventory");
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, MStoneType.POCEANSTONE.getMetadata(), itemModelResourceLocation);
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
	}
	
	public boolean isClient()
	{
		return false;
	}
	
	public void openGUI(Object gui)
	{
		
	}
	
	public void registerRenders()
	{
		
	}
}
