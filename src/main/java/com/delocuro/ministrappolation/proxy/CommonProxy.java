package com.delocuro.ministrappolation.proxy;

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

import com.delocuro.ministrappolation.Reference;
import com.delocuro.ministrappolation.blocks.BlockBiomeStones;
import com.delocuro.ministrappolation.init.MBlocks;
import com.delocuro.ministrappolation.init.MItems;

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
		Item itemBlockVariants = GameRegistry.findItem(Reference.MOD_ID, "biome_stone");
 
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
		Item itemBlockVariants = GameRegistry.findItem(Reference.MOD_ID, "biome_stone");
	   
		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(Reference.MOD_ID+":deepstone", "inventory");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, BlockBiomeStones.EnumType.DEEPSTONE.getMetadata(), itemModelResourceLocation);
	    
	    itemModelResourceLocation = new ModelResourceLocation(Reference.MOD_ID+":coldstone", "inventory");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, BlockBiomeStones.EnumType.COLDSTONE.getMetadata(), itemModelResourceLocation);
	    
	    itemModelResourceLocation = new ModelResourceLocation(Reference.MOD_ID+":icestone", "inventory");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, BlockBiomeStones.EnumType.ICESTONE.getMetadata(), itemModelResourceLocation);
	    
	    itemModelResourceLocation = new ModelResourceLocation(Reference.MOD_ID+":glacierrock", "inventory");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, BlockBiomeStones.EnumType.GLACIERSTONE.getMetadata(), itemModelResourceLocation);
	    
	    itemModelResourceLocation = new ModelResourceLocation(Reference.MOD_ID+":deep_coldstone", "inventory");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, BlockBiomeStones.EnumType.DEEPCOLDSTONE.getMetadata(), itemModelResourceLocation);
	    
	    itemModelResourceLocation = new ModelResourceLocation(Reference.MOD_ID+":red_rock", "inventory");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, BlockBiomeStones.EnumType.REDROCK.getMetadata(), itemModelResourceLocation);
	    
	    itemModelResourceLocation = new ModelResourceLocation(Reference.MOD_ID+":deep_redrock", "inventory");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, BlockBiomeStones.EnumType.DEEPREDROCK.getMetadata(), itemModelResourceLocation);
	    
	    itemModelResourceLocation = new ModelResourceLocation(Reference.MOD_ID+":oceanstone", "inventory");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, BlockBiomeStones.EnumType.OCEANSTONE.getMetadata(), itemModelResourceLocation);
	    
	    itemModelResourceLocation = new ModelResourceLocation(Reference.MOD_ID+":pressurized_oceanstone", "inventory");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, BlockBiomeStones.EnumType.POCEANSTONE.getMetadata(), itemModelResourceLocation);
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
