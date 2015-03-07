package com.delocuro.ministrappolation.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.delocuro.ministrappolation.Ministrappolation;
import com.delocuro.ministrappolation.Reference;
import com.delocuro.ministrappolation.items.ItemMinistrappolationArmor;
import com.delocuro.ministrappolation.items.ItemMinistrappolationAxe;
import com.delocuro.ministrappolation.items.ItemMinistrappolationHoe;
import com.delocuro.ministrappolation.items.ItemMinistrappolationPickaxe;
import com.delocuro.ministrappolation.items.ItemMinistrappolationShovel;
import com.delocuro.ministrappolation.items.ItemMinistrappolationSword;

public class MinistrappolationItems extends Item{
	public static Item dough;
	public static Item sugar_dough;
	public static Item chocolate_dough;
	public static Item sugar_cookie;
	public static Item copper_ingot;
	public static Item tin_ingot;
	public static Item sunstone_shard;
	
	public static Item copper_pickaxe;
	public static Item copper_axe;
	public static Item copper_shovel;
	public static Item copper_hoe;
	public static Item copper_sword;
	
	public static Item tin_helmet;
	public static Item tin_chestplate;
	public static Item tin_leggings;
	public static Item tin_boots;
	
	public static final Item.ToolMaterial COPPER = EnumHelper.addToolMaterial("COPPER", 1, 186, 4.5F, 1.5F, 18);
	public static final ItemArmor.ArmorMaterial ARMOR_TIN = EnumHelper.addArmorMaterial("ARMOR_TIN", "tin", 4, new int[]{2,4,3,2}, 6);
	
	public static void init() 
	{
		dough = new ItemFood(1,0.2F,false).setUnlocalizedName("dough").setCreativeTab(Ministrappolation.tabMinistrappolation);
		sugar_dough = new ItemFood(1,0.2F,false).setPotionEffect(Potion.moveSpeed.id, 5, 0, 0.3F).setUnlocalizedName("sugar_dough").setCreativeTab(Ministrappolation.tabMinistrappolation);
		chocolate_dough = new ItemFood(1,0.3F,false).setUnlocalizedName("chocolate_dough").setCreativeTab(Ministrappolation.tabMinistrappolation);
		sugar_cookie = new ItemFood(1,0.4F,false).setPotionEffect(Potion.moveSpeed.id, 10, 0, 0.5F).setUnlocalizedName("sugar_cookie").setCreativeTab(Ministrappolation.tabMinistrappolation);
		copper_ingot = new Item().setUnlocalizedName("copper_ingot").setCreativeTab(Ministrappolation.tabMinistrappolation);
		tin_ingot = new Item().setUnlocalizedName("tin_ingot").setCreativeTab(Ministrappolation.tabMinistrappolation);
		sunstone_shard = new Item().setUnlocalizedName("sunstone_shard").setCreativeTab(Ministrappolation.tabMinistrappolation);
		
		copper_pickaxe = new ItemMinistrappolationPickaxe(COPPER).setUnlocalizedName("copper_pickaxe").setCreativeTab(Ministrappolation.tabMinistrappolation);
		copper_axe = new ItemMinistrappolationAxe(COPPER).setUnlocalizedName("copper_axe").setCreativeTab(Ministrappolation.tabMinistrappolation);
		copper_shovel = new ItemMinistrappolationShovel(COPPER).setUnlocalizedName("copper_shovel").setCreativeTab(Ministrappolation.tabMinistrappolation);
		copper_hoe = new ItemMinistrappolationHoe(COPPER).setUnlocalizedName("copper_hoe").setCreativeTab(Ministrappolation.tabMinistrappolation);
		copper_sword = new ItemMinistrappolationSword(COPPER).setUnlocalizedName("copper_sword").setCreativeTab(Ministrappolation.tabMinistrappolation);
		
		tin_helmet = new ItemMinistrappolationArmor(ARMOR_TIN,0,0).setUnlocalizedName("tin_helmet").setCreativeTab(Ministrappolation.tabMinistrappolation);
		tin_chestplate = new ItemMinistrappolationArmor(ARMOR_TIN,0,1).setUnlocalizedName("tin_chestplate").setCreativeTab(Ministrappolation.tabMinistrappolation);
		tin_leggings = new ItemMinistrappolationArmor(ARMOR_TIN,0,2).setUnlocalizedName("tin_leggings").setCreativeTab(Ministrappolation.tabMinistrappolation);
		tin_boots = new ItemMinistrappolationArmor(ARMOR_TIN,0,3).setUnlocalizedName("tin_boots").setCreativeTab(Ministrappolation.tabMinistrappolation);
	}
	public static void register()
	{
		GameRegistry.registerItem(dough, dough.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sugar_dough, sugar_dough.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(chocolate_dough, chocolate_dough.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sugar_cookie, sugar_cookie.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_ingot, copper_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_ingot, tin_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sunstone_shard, sunstone_shard.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(copper_pickaxe, copper_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_axe, copper_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_shovel, copper_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_hoe, copper_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_sword, copper_sword.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(tin_helmet, tin_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_chestplate, tin_chestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_leggings, tin_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_boots, tin_boots.getUnlocalizedName().substring(5));
	}
	public static void registerRenders()
	{
		registerRender(dough);
		registerRender(sugar_dough);
		registerRender(chocolate_dough);
		registerRender(sugar_cookie);
		registerRender(copper_ingot);
		registerRender(tin_ingot);
		registerRender(sunstone_shard);
		
		registerRender(copper_pickaxe);
		registerRender(copper_axe);
		registerRender(copper_shovel);
		registerRender(copper_hoe);
		registerRender(copper_sword);
		
		registerRender(tin_helmet);
		registerRender(tin_chestplate);
		registerRender(tin_leggings);
		registerRender(tin_boots);
	}
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
