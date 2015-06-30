package minestrapteam.minestrappolation.lib;

import java.util.ArrayList;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.item.ItemChunk;
import minestrapteam.minestrappolation.item.ItemHeartContainer;
import minestrapteam.minestrappolation.item.ItemMArmor;
import minestrapteam.minestrappolation.item.ItemMAxe;
import minestrapteam.minestrappolation.item.ItemMHoe;
import minestrapteam.minestrappolation.item.ItemMPickaxe;
import minestrapteam.minestrappolation.item.ItemMShovel;
import minestrapteam.minestrappolation.item.ItemMSoup;
import minestrapteam.minestrappolation.item.ItemMSword;
import minestrapteam.minestrappolation.item.ItemSifter;
import minestrapteam.minestrappolation.item.ItemSoulBottle;
import minestrapteam.minestrappolation.item.ItemSoulGem;
import minestrapteam.minestrappolation.item.MItemFoiled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MItems extends Item
{
	public static ArrayList<Item> itemList = new ArrayList<Item>();
	
	public static Item							dough;
	public static Item							sugar_dough;
	public static Item							chocolate_dough;
	public static Item							sugar_cookie;
	public static Item							pie_crust;
	public static Item							apple_pie;
	public static Item							fried_egg;
	public static Item							blueberry;
	public static Item							blackberry;
	public static Item							raspberry;
	public static Item							strawberry;
	public static Item							rice;
	public static Item							pepper;
	public static Item							onion;
	public static Item							cabbage;
	public static Item							mana_leaf;
	
	public static Item							copper_ingot;
	public static Item							tin_ingot;
	public static Item							sunstone_shard;
	public static Item							bronze_ingot;
	public static Item							steel_ingot;
	public static Item							blazium_ingot;
	public static Item							titanium_ingot;
	public static Item							plutonium;
	public static Item							uranium;
	public static Item							tin_plating;
	public static Item							steel_plating;
	public static Item							meurodite_plating;
	public static Item							reinforced_stick;
	
	public static Item							stone_brick;
	public static Item							deepstone_brick;
	public static Item							red_rock_brick;
	public static Item							deep_red_rock_brick;
	public static Item							coldstone_brick;
	public static Item							deep_coldstone_brick;
	public static Item							icestone_brick;
	public static Item							glacierrock_brick;
	public static Item							oceanstone_brick;
	public static Item							pressurized_oceanstone_brick;
	public static Item							slate_brick;
	public static Item							granite_brick;
	public static Item							diorite_brick;
	public static Item							andesite_brick;
	public static Item							flint_brick;
	public static Item							obsidian_brick;
	
	public static Item							copper_pickaxe;
	public static Item							copper_axe;
	public static Item							copper_shovel;
	public static Item							copper_hoe;
	public static Item							copper_sword;
	
	public static Item							bronze_pickaxe;
	public static Item							bronze_axe;
	public static Item							bronze_shovel;
	public static Item							bronze_hoe;
	public static Item							bronze_sword;
	
	public static Item							steel_pickaxe;
	public static Item							steel_axe;
	public static Item							steel_shovel;
	public static Item							steel_hoe;
	public static Item							steel_sword;
	
	public static Item							meurodite_pickaxe;
	public static Item							meurodite_axe;
	public static Item							meurodite_shovel;
	public static Item							meurodite_hoe;
	public static Item							meurodite_sword;
	
	public static Item							torite_pickaxe;
	public static Item							torite_axe;
	public static Item							torite_shovel;
	public static Item							torite_hoe;
	public static Item							torite_sword;
	
	public static Item							fire_pickaxe;
	public static Item							fire_axe;
	public static Item							fire_shovel;
	public static Item							fire_hoe;
	public static Item							fire_sword;
	
	public static Item							titanium_pickaxe;
	public static Item							titanium_axe;
	public static Item							titanium_shovel;
	public static Item							titanium_hoe;
	public static Item							titanium_sword;
	
	public static Item							bedrock_pickaxe;
	public static Item							bedrock_axe;
	public static Item							bedrock_shovel;
	public static Item							bedrock_hoe;
	
	public static Item							tin_helmet;
	public static Item							tin_chestplate;
	public static Item							tin_leggings;
	public static Item							tin_boots;
	
	public static Item							bronze_helmet;
	public static Item							bronze_chestplate;
	public static Item							bronze_leggings;
	public static Item							bronze_boots;
	
	public static Item							steel_helmet;
	public static Item							steel_chestplate;
	public static Item							steel_leggings;
	public static Item							steel_boots;
	
	public static Item							meurodite_helmet;
	public static Item							meurodite_chestplate;
	public static Item							meurodite_leggings;
	public static Item							meurodite_boots;
	
	public static Item							torite_helmet;
	public static Item							torite_chestplate;
	public static Item							torite_leggings;
	public static Item							torite_boots;
	
	public static Item							blazium_helmet;
	public static Item							blazium_chestplate;
	public static Item							blazium_leggings;
	public static Item							blazium_boots;
	
	public static Item							titanium_helmet;
	public static Item							titanium_chestplate;
	public static Item							titanium_leggings;
	public static Item							titanium_boots;
	
	public static Item							radiant_quartz;
	public static Item							meurodite_gem;
	public static Item							soul_gem;
	public static Item							torite_ingot;
	public static Item							desert_quartz_item;
	public static Item							blaze_shard;
	
	public static Item							chunks;
	
	public static Item							sifter;
	public static Item							heart_container;
	public static Item							soulbottle;
	
	public static final Item.ToolMaterial		COPPER			= EnumHelper.addToolMaterial("COPPER", 1, 186, 4.5F, 1.5F, 18);
	public static final Item.ToolMaterial		BRONZE			= EnumHelper.addToolMaterial("BRONZE", 2, 1016, 5.8F, 2.0F, 16);
	public static final Item.ToolMaterial		STEEL			= EnumHelper.addToolMaterial("STEEL", 2, 420, 7.8F, 2.5F, 20);
	public static final Item.ToolMaterial		MEURODITE		= EnumHelper.addToolMaterial("MEURODITE", 2, 905, 7.0F, 2.5F, 13);
	public static final Item.ToolMaterial		TORITE			= EnumHelper.addToolMaterial("TORITE", 3, 1208, 9.0F, 3.5F, 28);
	public static final Item.ToolMaterial		BLAZIUM			= EnumHelper.addToolMaterial("BLAZIUM", 2, 808, 8.0F, 3.5F, 18);
	public static final Item.ToolMaterial		TITANIUM		= EnumHelper.addToolMaterial("TITANIUM", 4, 3122, 14.0F, 5.0F, 8);
	public static final Item.ToolMaterial		BEDROCK			= EnumHelper.addToolMaterial("BEDROCK", 5, 6244, 7.0F, 1.0F, 5);
	
	public static final ItemArmor.ArmorMaterial	ARMOR_TIN		= EnumHelper.addArmorMaterial("ARMOR_TIN", "tin", 4, new int[] { 2, 4, 3, 2 }, 6);
	public static final ItemArmor.ArmorMaterial	ARMOR_BRONZE	= EnumHelper.addArmorMaterial("ARMOR_BRONZE", "bronze", 30, new int[] { 2, 6, 5, 2 }, 10);
	public static final ItemArmor.ArmorMaterial	ARMOR_STEEL		= EnumHelper.addArmorMaterial("ARMOR_STEEL", "steel", 19, new int[] { 3, 7, 5, 3 }, 14);
	public static final ItemArmor.ArmorMaterial	ARMOR_MEURODITE	= EnumHelper.addArmorMaterial("ARMOR_MEURODITE", "meurodite", 24, new int[] { 3, 7, 6, 2 }, 10);
	public static final ItemArmor.ArmorMaterial	ARMOR_TORITE	= EnumHelper.addArmorMaterial("ARMOR_TORITE", "torite", 31, new int[] { 4, 9, 7, 3 }, 30);
	public static final ItemArmor.ArmorMaterial	ARMOR_BLAZIUM	= EnumHelper.addArmorMaterial("ARMOR_BLAZIUM", "blazium", 22, new int[] { 2, 7, 6, 2 }, 10);
	public static final ItemArmor.ArmorMaterial	ARMOR_TITANIUM	= EnumHelper.addArmorMaterial("ARMOR_TITANIUM", "titanium", 66, new int[] { 6, 16, 12, 6 }, 8);
	
	public static void init()
	{
		dough = new ItemFood(1, 0.2F, false).setUnlocalizedName("dough").setCreativeTab(Minestrappolation.tabMFood);
		sugar_dough = new ItemFood(1, 0.2F, false).setPotionEffect(Potion.moveSpeed.id, 5, 0, 0.3F).setUnlocalizedName("sugar_dough").setCreativeTab(Minestrappolation.tabMFood);
		chocolate_dough = new ItemFood(1, 0.3F, false).setUnlocalizedName("chocolate_dough").setCreativeTab(Minestrappolation.tabMFood);
		sugar_cookie = new ItemFood(1, 0.4F, false).setPotionEffect(Potion.moveSpeed.id, 10, 0, 0.5F).setUnlocalizedName("sugar_cookie").setCreativeTab(Minestrappolation.tabMFood);
		pie_crust = new ItemFood(2, 0.2F, false).setUnlocalizedName("pie_crust").setCreativeTab(Minestrappolation.tabMFood);
		apple_pie = new ItemFood(6, 0.7F, false).setUnlocalizedName("apple_pie").setCreativeTab(Minestrappolation.tabMFood);
		fried_egg = new ItemMSoup(6, 0.4F).setUnlocalizedName("fried_egg").setCreativeTab(Minestrappolation.tabMFood);
		blueberry = new ItemFood(0, 1.0F, false).setPotionEffect(Potion.healthBoost.id, 10, 0, 0.3F).setUnlocalizedName("blueberry").setCreativeTab(Minestrappolation.tabMFood);
		blackberry = new ItemFood(1, 0.4F, false).setPotionEffect(Potion.digSpeed.id, 10, 0, 0.3F).setUnlocalizedName("blackberry").setCreativeTab(Minestrappolation.tabMFood);
		raspberry = new ItemFood(1, 0.0F, false).setPotionEffect(Potion.heal.id, 1, 0, 0.3F).setUnlocalizedName("raspberry").setCreativeTab(Minestrappolation.tabMFood);
		strawberry = new ItemFood(1, 0.0F, false).setPotionEffect(Potion.heal.id, 1, 0, 0.3F).setUnlocalizedName("strawberry").setCreativeTab(Minestrappolation.tabMFood);
		rice = new ItemFood(1, 0.3F, false).setUnlocalizedName("rice").setCreativeTab(Minestrappolation.tabMFood);
		pepper = new ItemFood(1, 0.3F, false).setUnlocalizedName("pepper").setCreativeTab(Minestrappolation.tabMFood);
		onion = new ItemFood(1, 0.3F, false).setUnlocalizedName("onion").setCreativeTab(Minestrappolation.tabMFood);
		cabbage = new ItemFood(1, 0.3F, false).setUnlocalizedName("cabbage").setCreativeTab(Minestrappolation.tabMFood);
		mana_leaf = new Item().setUnlocalizedName("mana_leaf").setCreativeTab(Minestrappolation.tabMMaterials);
		
		copper_ingot = new Item().setUnlocalizedName("copper_ingot").setCreativeTab(Minestrappolation.tabMMaterials);
		tin_ingot = new Item().setUnlocalizedName("tin_ingot").setCreativeTab(Minestrappolation.tabMMaterials);
		bronze_ingot = new Item().setUnlocalizedName("bronze_ingot").setCreativeTab(Minestrappolation.tabMMaterials);
		steel_ingot = new Item().setUnlocalizedName("steel_ingot").setCreativeTab(Minestrappolation.tabMMaterials);
		blazium_ingot = new Item().setUnlocalizedName("blazium_ingot").setCreativeTab(Minestrappolation.tabMMaterials);
		titanium_ingot = new Item().setUnlocalizedName("titanium_ingot").setCreativeTab(Minestrappolation.tabMMaterials);
		sunstone_shard = new Item().setUnlocalizedName("sunstone_shard").setCreativeTab(Minestrappolation.tabMMaterials);
		plutonium = new Item().setUnlocalizedName("plutonium").setCreativeTab(Minestrappolation.tabMMaterials);
		uranium = new Item().setUnlocalizedName("uranium").setCreativeTab(Minestrappolation.tabMMaterials);
		tin_plating = new Item().setUnlocalizedName("tin_plating").setCreativeTab(Minestrappolation.tabMMaterials);
		steel_plating = new Item().setUnlocalizedName("steel_plating").setCreativeTab(Minestrappolation.tabMMaterials);
		meurodite_plating = new Item().setUnlocalizedName("meurodite_plating").setCreativeTab(Minestrappolation.tabMMaterials);
		reinforced_stick = new Item().setUnlocalizedName("reinforced_stick").setCreativeTab(Minestrappolation.tabMMaterials);
		
		stone_brick = new Item().setUnlocalizedName("stone_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		deepstone_brick = new Item().setUnlocalizedName("deepstone_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		red_rock_brick = new Item().setUnlocalizedName("red_rock_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		deep_red_rock_brick = new Item().setUnlocalizedName("deep_red_rock_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		coldstone_brick = new Item().setUnlocalizedName("coldstone_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		deep_coldstone_brick = new Item().setUnlocalizedName("deep_coldstone_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		icestone_brick = new Item().setUnlocalizedName("icestone_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		glacierrock_brick = new Item().setUnlocalizedName("glacierrock_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		oceanstone_brick = new Item().setUnlocalizedName("oceanstone_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		pressurized_oceanstone_brick = new Item().setUnlocalizedName("pressurized_oceanstone_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		slate_brick = new Item().setUnlocalizedName("slate_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		granite_brick = new Item().setUnlocalizedName("granite_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		diorite_brick = new Item().setUnlocalizedName("diorite_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		andesite_brick = new Item().setUnlocalizedName("andesite_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		flint_brick = new Item().setUnlocalizedName("flint_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		obsidian_brick = new Item().setUnlocalizedName("obsidian_brick").setCreativeTab(Minestrappolation.tabMMaterials);
		
		copper_pickaxe = new ItemMPickaxe(COPPER, copper_ingot, false).setUnlocalizedName("copper_pickaxe").setCreativeTab(Minestrappolation.tabMTools);
		copper_axe = new ItemMAxe(COPPER, copper_ingot, false).setUnlocalizedName("copper_axe").setCreativeTab(Minestrappolation.tabMTools);
		copper_shovel = new ItemMShovel(COPPER, copper_ingot, false).setUnlocalizedName("copper_shovel").setCreativeTab(Minestrappolation.tabMTools);
		copper_hoe = new ItemMHoe(COPPER, copper_ingot, false).setUnlocalizedName("copper_hoe").setCreativeTab(Minestrappolation.tabMTools);
		copper_sword = new ItemMSword(COPPER, copper_ingot, false).setUnlocalizedName("copper_sword").setCreativeTab(Minestrappolation.tabMCombat);
		
		bronze_pickaxe = new ItemMPickaxe(BRONZE, bronze_ingot, false).setUnlocalizedName("bronze_pickaxe").setCreativeTab(Minestrappolation.tabMTools);
		bronze_axe = new ItemMAxe(BRONZE, bronze_ingot, false).setUnlocalizedName("bronze_axe").setCreativeTab(Minestrappolation.tabMTools);
		bronze_shovel = new ItemMShovel(BRONZE, bronze_ingot, false).setUnlocalizedName("bronze_shovel").setCreativeTab(Minestrappolation.tabMTools);
		bronze_hoe = new ItemMHoe(BRONZE, bronze_ingot, false).setUnlocalizedName("bronze_hoe").setCreativeTab(Minestrappolation.tabMTools);
		bronze_sword = new ItemMSword(BRONZE, bronze_ingot, false).setUnlocalizedName("bronze_sword").setCreativeTab(Minestrappolation.tabMCombat);
		
		steel_pickaxe = new ItemMPickaxe(STEEL, steel_ingot, false).setUnlocalizedName("steel_pickaxe").setCreativeTab(Minestrappolation.tabMTools);
		steel_axe = new ItemMAxe(STEEL, steel_ingot, false).setUnlocalizedName("steel_axe").setCreativeTab(Minestrappolation.tabMTools);
		steel_shovel = new ItemMShovel(STEEL, steel_ingot, false).setUnlocalizedName("steel_shovel").setCreativeTab(Minestrappolation.tabMTools);
		steel_hoe = new ItemMHoe(STEEL, steel_ingot, false).setUnlocalizedName("steel_hoe").setCreativeTab(Minestrappolation.tabMTools);
		steel_sword = new ItemMSword(STEEL, steel_ingot, false).setUnlocalizedName("steel_sword").setCreativeTab(Minestrappolation.tabMCombat);
		
		meurodite_pickaxe = new ItemMPickaxe(MEURODITE, meurodite_gem, false).setUnlocalizedName("meurodite_pickaxe").setCreativeTab(Minestrappolation.tabMTools);
		meurodite_axe = new ItemMAxe(MEURODITE, meurodite_gem, false).setUnlocalizedName("meurodite_axe").setCreativeTab(Minestrappolation.tabMTools);
		meurodite_shovel = new ItemMShovel(MEURODITE, meurodite_gem, false).setUnlocalizedName("meurodite_shovel").setCreativeTab(Minestrappolation.tabMTools);
		meurodite_hoe = new ItemMHoe(MEURODITE, meurodite_gem, false).setUnlocalizedName("meurodite_hoe").setCreativeTab(Minestrappolation.tabMTools);
		meurodite_sword = new ItemMSword(MEURODITE, meurodite_gem, false).setUnlocalizedName("meurodite_sword").setCreativeTab(Minestrappolation.tabMCombat);
		
		torite_pickaxe = new ItemMPickaxe(TORITE, torite_ingot, false).setUnlocalizedName("torite_pickaxe").setCreativeTab(Minestrappolation.tabMTools);
		torite_axe = new ItemMAxe(TORITE, torite_ingot, false).setUnlocalizedName("torite_axe").setCreativeTab(Minestrappolation.tabMTools);
		torite_shovel = new ItemMShovel(TORITE, torite_ingot, false).setUnlocalizedName("torite_shovel").setCreativeTab(Minestrappolation.tabMTools);
		torite_hoe = new ItemMHoe(TORITE, torite_ingot, false).setUnlocalizedName("torite_hoe").setCreativeTab(Minestrappolation.tabMTools);
		torite_sword = new ItemMSword(TORITE, torite_ingot, false).setUnlocalizedName("torite_sword").setCreativeTab(Minestrappolation.tabMCombat);
		
		fire_pickaxe = new ItemMPickaxe(BLAZIUM, blazium_ingot, true).setUnlocalizedName("fire_pickaxe").setCreativeTab(Minestrappolation.tabMTools);
		fire_axe = new ItemMAxe(BLAZIUM, blazium_ingot, true).setUnlocalizedName("fire_axe").setCreativeTab(Minestrappolation.tabMTools);
		fire_shovel = new ItemMShovel(BLAZIUM, blazium_ingot, true).setUnlocalizedName("fire_shovel").setCreativeTab(Minestrappolation.tabMTools);
		fire_hoe = new ItemMHoe(BLAZIUM, blazium_ingot, true).setUnlocalizedName("fire_hoe").setCreativeTab(Minestrappolation.tabMTools);
		fire_sword = new ItemMSword(BLAZIUM, blazium_ingot, true).setUnlocalizedName("fire_sword").setCreativeTab(Minestrappolation.tabMCombat);
		
		titanium_pickaxe = new ItemMPickaxe(TITANIUM, titanium_ingot, false).setUnlocalizedName("titanium_pickaxe").setCreativeTab(Minestrappolation.tabMTools);
		titanium_axe = new ItemMAxe(TITANIUM, titanium_ingot, false).setUnlocalizedName("titanium_axe").setCreativeTab(Minestrappolation.tabMTools);
		titanium_shovel = new ItemMShovel(TITANIUM, titanium_ingot, false).setUnlocalizedName("titanium_shovel").setCreativeTab(Minestrappolation.tabMTools);
		titanium_hoe = new ItemMHoe(TITANIUM, titanium_ingot, false).setUnlocalizedName("titanium_hoe").setCreativeTab(Minestrappolation.tabMTools);
		titanium_sword = new ItemMSword(TITANIUM, titanium_ingot, false).setUnlocalizedName("titanium_sword").setCreativeTab(Minestrappolation.tabMCombat);
		
		bedrock_pickaxe = new ItemMPickaxe(BEDROCK, Item.getItemFromBlock(Blocks.bedrock), false).setUnlocalizedName("bedrock_pickaxe").setCreativeTab(Minestrappolation.tabMTools);
		bedrock_axe = new ItemMAxe(BEDROCK, Item.getItemFromBlock(Blocks.bedrock), false).setUnlocalizedName("bedrock_axe").setCreativeTab(Minestrappolation.tabMTools);
		bedrock_shovel = new ItemMShovel(BEDROCK, Item.getItemFromBlock(Blocks.bedrock), false).setUnlocalizedName("bedrock_shovel").setCreativeTab(Minestrappolation.tabMTools);
		bedrock_hoe = new ItemMHoe(BEDROCK, Item.getItemFromBlock(Blocks.bedrock), false).setUnlocalizedName("bedrock_hoe").setCreativeTab(Minestrappolation.tabMTools);
		
		tin_helmet = new ItemMArmor(ARMOR_TIN, 0, 0, tin_ingot, "tin").setUnlocalizedName("tin_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		tin_chestplate = new ItemMArmor(ARMOR_TIN, 0, 1, tin_ingot, "tin").setUnlocalizedName("tin_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		tin_leggings = new ItemMArmor(ARMOR_TIN, 0, 2, tin_ingot, "tin").setUnlocalizedName("tin_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		tin_boots = new ItemMArmor(ARMOR_TIN, 0, 3, tin_ingot, "tin").setUnlocalizedName("tin_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		bronze_helmet = new ItemMArmor(ARMOR_BRONZE, 0, 0, bronze_ingot, "bronze").setUnlocalizedName("bronze_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		bronze_chestplate = new ItemMArmor(ARMOR_BRONZE, 0, 1, bronze_ingot, "bronze").setUnlocalizedName("bronze_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		bronze_leggings = new ItemMArmor(ARMOR_BRONZE, 0, 2, bronze_ingot, "bronze").setUnlocalizedName("bronze_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		bronze_boots = new ItemMArmor(ARMOR_BRONZE, 0, 3, bronze_ingot, "bronze").setUnlocalizedName("bronze_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		steel_helmet = new ItemMArmor(ARMOR_STEEL, 0, 0, steel_ingot, "steel").setUnlocalizedName("steel_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		steel_chestplate = new ItemMArmor(ARMOR_STEEL, 0, 1, steel_ingot, "steel").setUnlocalizedName("steel_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		steel_leggings = new ItemMArmor(ARMOR_STEEL, 0, 2, steel_ingot, "steel").setUnlocalizedName("steel_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		steel_boots = new ItemMArmor(ARMOR_STEEL, 0, 3, steel_ingot, "steel").setUnlocalizedName("steel_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		meurodite_helmet = new ItemMArmor(ARMOR_MEURODITE, 0, 0, meurodite_gem, "meurodite").setUnlocalizedName("meurodite_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		meurodite_chestplate = new ItemMArmor(ARMOR_MEURODITE, 0, 1, meurodite_gem, "meurodite").setUnlocalizedName("meurodite_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		meurodite_leggings = new ItemMArmor(ARMOR_MEURODITE, 0, 2, meurodite_gem, "meurodite").setUnlocalizedName("meurodite_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		meurodite_boots = new ItemMArmor(ARMOR_MEURODITE, 0, 3, meurodite_gem, "meurodite").setUnlocalizedName("meurodite_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		torite_helmet = new ItemMArmor(ARMOR_TORITE, 0, 0, torite_ingot, "tortite").setUnlocalizedName("torite_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		torite_chestplate = new ItemMArmor(ARMOR_TORITE, 0, 1, torite_ingot, "tortite").setUnlocalizedName("torite_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		torite_leggings = new ItemMArmor(ARMOR_TORITE, 0, 2, torite_ingot, "tortite").setUnlocalizedName("torite_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		torite_boots = new ItemMArmor(ARMOR_TORITE, 0, 3, torite_ingot, "tortite").setUnlocalizedName("torite_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		blazium_helmet = new ItemMArmor(ARMOR_BLAZIUM, 0, 0, blazium_ingot, "blazium").setUnlocalizedName("blazium_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		blazium_chestplate = new ItemMArmor(ARMOR_BLAZIUM, 0, 1, blazium_ingot, "blazium").setUnlocalizedName("blazium_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		blazium_leggings = new ItemMArmor(ARMOR_BLAZIUM, 0, 2, blazium_ingot, "blazium").setUnlocalizedName("blazium_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		blazium_boots = new ItemMArmor(ARMOR_BLAZIUM, 0, 3, blazium_ingot, "blazium").setUnlocalizedName("blazium_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		titanium_helmet = new ItemMArmor(ARMOR_TITANIUM, 0, 0, titanium_ingot, "titanium").setUnlocalizedName("titanium_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		titanium_chestplate = new ItemMArmor(ARMOR_TITANIUM, 0, 1, titanium_ingot, "titanium").setUnlocalizedName("titanium_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		titanium_leggings = new ItemMArmor(ARMOR_TITANIUM, 0, 2, titanium_ingot, "titanium").setUnlocalizedName("titanium_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		titanium_boots = new ItemMArmor(ARMOR_TITANIUM, 0, 3, titanium_ingot, "titanium").setUnlocalizedName("titanium_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		radiant_quartz = new MItemFoiled().setUnlocalizedName("radiant_quartz").setCreativeTab(Minestrappolation.tabMMaterials);
		meurodite_gem = new Item().setUnlocalizedName("meurodite_gem").setCreativeTab(Minestrappolation.tabMMaterials);
		torite_ingot = new Item().setUnlocalizedName("torite_ingot").setCreativeTab(Minestrappolation.tabMMaterials);
		desert_quartz_item = new Item().setUnlocalizedName("desert_quartz_item").setCreativeTab(Minestrappolation.tabMMaterials);
		blaze_shard = new Item().setUnlocalizedName("blaze_shard").setCreativeTab(Minestrappolation.tabMMaterials);
		soul_gem = new ItemSoulGem().setUnlocalizedName("soul_gem").setCreativeTab(Minestrappolation.tabMMaterials);
		
		chunks = new ItemChunk().setUnlocalizedName("chunks").setCreativeTab(Minestrappolation.tabMMaterials);
		
		sifter = new ItemSifter().setUnlocalizedName("sifter");
		heart_container = new ItemHeartContainer().setUnlocalizedName("heart_container").setCreativeTab(Minestrappolation.tabMTools);
		soulbottle = new ItemSoulBottle().setUnlocalizedName("soul_bottle").setCreativeTab(Minestrappolation.tabMTools);
		
		addItemsToChests();
	}
	
	public static void register()
	{	
		register(reinforced_stick);
		register(mana_leaf);
		
		register(stone_brick);
		register(deepstone_brick);
		register(red_rock_brick);
		register(deep_red_rock_brick);
		register(coldstone_brick);
		register(deep_coldstone_brick);
		register(icestone_brick);
		register(glacierrock_brick);
		register(oceanstone_brick);
		register(pressurized_oceanstone_brick);
		register(slate_brick);
		register(granite_brick);
		register(diorite_brick);
		register(andesite_brick);
		register(flint_brick);
		register(obsidian_brick);
		
		register(chunks);
		register(desert_quartz_item);
		register(copper_ingot);
		register(tin_ingot);
		register(bronze_ingot);
		register(steel_ingot);
		register(meurodite_gem);
		register(torite_ingot);
		register(sunstone_shard);
		register(plutonium);
		register(uranium);
		register(radiant_quartz);
		register(titanium_ingot);
		register(blaze_shard);
		register(blazium_ingot);
		register(soul_gem);
		register(tin_plating);
		register(steel_plating);
		register(meurodite_plating);
		
		register(dough);
		register(sugar_dough);
		register(chocolate_dough);
		register(sugar_cookie);
		register(pie_crust);
		register(apple_pie);
		register(fried_egg);
		register(blueberry);
		register(blackberry);
		register(strawberry);
		register(raspberry);
		register(rice);
		register(pepper);
		register(onion);
		register(cabbage);
		
		register(copper_pickaxe);
		register(copper_axe);
		register(copper_shovel);
		register(copper_hoe);
		register(copper_sword);
		
		register(tin_helmet);
		register(tin_chestplate);
		register(tin_leggings);
		register(tin_boots);
		
		register(bronze_pickaxe);
		register(bronze_axe);
		register(bronze_shovel);
		register(bronze_hoe);
		register(bronze_sword);
		
		register(bronze_helmet);
		register(bronze_chestplate);
		register(bronze_leggings);
		register(bronze_boots);
		
		register(steel_pickaxe);
		register(steel_axe);
		register(steel_shovel);
		register(steel_hoe);
		register(steel_sword);
		
		register(steel_helmet);
		register(steel_chestplate);
		register(steel_leggings);
		register(steel_boots);
		
		register(meurodite_pickaxe);
		register(meurodite_axe);
		register(meurodite_shovel);
		register(meurodite_hoe);
		register(meurodite_sword);
		
		register(meurodite_helmet);
		register(meurodite_chestplate);
		register(meurodite_leggings);
		register(meurodite_boots);
		
		register(torite_pickaxe);
		register(torite_axe);
		register(torite_shovel);
		register(torite_hoe);
		register(torite_sword);
		
		register(torite_helmet);
		register(torite_chestplate);
		register(torite_leggings);
		register(torite_boots);
		
		register(titanium_pickaxe);
		register(titanium_axe);
		register(titanium_shovel);
		register(titanium_hoe);
		register(titanium_sword);
		
		register(titanium_helmet);
		register(titanium_chestplate);
		register(titanium_leggings);
		register(titanium_boots);
		
		register(fire_pickaxe);
		register(fire_axe);
		register(fire_shovel);
		register(fire_hoe);
		register(fire_sword);
		
		register(blazium_helmet);
		register(blazium_chestplate);
		register(blazium_leggings);
		register(blazium_boots);
		
		register(bedrock_pickaxe);
		register(bedrock_axe);
		register(bedrock_shovel);
		register(bedrock_hoe);
		
		register(sifter);
		register(heart_container);
		register(soulbottle);
	}
	
	public static void register(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
		itemList.add(item);
	}
	
	public static void registerRenders()
	{
		for(Item item: itemList)
		{
			registerRender(item);
		}
	}
	
	public static void addItemsToChests()
	{
		ChestGenHooks bonusChest = ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST);
		ChestGenHooks dungeonChest = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);
		ChestGenHooks mineshaftCorridor = ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR);
		ChestGenHooks strongholdCorridor = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR);
		ChestGenHooks strongholdCrossing = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING);
		ChestGenHooks jungleChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		ChestGenHooks desertChest = ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST);
		ChestGenHooks blacksmithChest = ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH);
		ChestGenHooks strongholdLibrary = ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY);
		
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(copper_ingot), 1, 4, 20));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(tin_ingot), 1, 4, 20));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(sunstone_shard), 1, 4, 25));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(steel_ingot), 1, 3, 10));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(bronze_ingot), 1, 3, 10));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(meurodite_gem), 1, 1, 5));
		dungeonChest.addItem(new WeightedRandomChestContent(new ItemStack(radiant_quartz), 1, 2, 4));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(copper_ingot), 1, 5, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(tin_ingot), 1, 5, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(sunstone_shard), 4, 8, 30));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(steel_ingot), 1, 3, 15));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronze_ingot), 1, 3, 15));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(meurodite_gem), 1, 3, 8));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(steel_pickaxe), 1, 1, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronze_pickaxe), 1, 1, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.sunstone_block), 1, 1, 3));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(uranium), 0, 2, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(plutonium), 0, 2, 2));
		mineshaftCorridor.addItem(new WeightedRandomChestContent(new ItemStack(radiant_quartz), 0, 5, 1));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(copper_ingot), 1, 5, 30));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(tin_ingot), 1, 5, 30));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(sunstone_shard), 3, 9, 30));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronze_ingot), 1, 3, 15));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(steel_ingot), 1, 3, 15));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(meurodite_gem), 1, 3, 13));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(torite_ingot), 1, 3, 8));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronze_pickaxe), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(steel_sword), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronze_helmet), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(steel_chestplate), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(bronze_leggings), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(steel_boots), 1, 1, 2));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(titanium_ingot), 0, 1, 1));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.godstone), 0, 1, 1));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(soul_gem), 1, 2, 1));
		strongholdCorridor.addItem(new WeightedRandomChestContent(new ItemStack(radiant_quartz), 1, 2, 2));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(copper_ingot), 1, 5, 15));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(tin_ingot), 1, 5, 15));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(sunstone_shard), 1, 6, 20));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(bronze_ingot), 1, 3, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(steel_ingot), 1, 3, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(meurodite_gem), 1, 1, 8));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(bronze_pickaxe), 0, 1, 2));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(steel_pickaxe), 0, 1, 2));
		strongholdCrossing.addItem(new WeightedRandomChestContent(new ItemStack(meurodite_pickaxe), 0, 1, 2));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(desert_quartz_item), 1, 3, 15));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(radiant_quartz), 1, 3, 8));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(soul_gem), 1, 2, 3));
		strongholdLibrary.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.radiant_ore), 1, 1, 2));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(copper_ingot), 1, 4, 30));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(tin_ingot), 1, 4, 30));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(bronze_ingot), 1, 4, 25));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(torite_ingot), 1, 5, 15));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(meurodite_gem), 1, 3, 13));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(radiant_quartz), 1, 2, 6));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(steel_ingot), 1, 3, 8));
		jungleChest.addItem(new WeightedRandomChestContent(new ItemStack(soul_gem), 0, 3, 1));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(copper_ingot), 1, 4, 30));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(tin_ingot), 1, 4, 30));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(bronze_ingot), 1, 4, 25));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(desert_quartz_item), 3, 11, 30));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(meurodite_gem), 1, 3, 13));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(radiant_quartz), 1, 4, 6));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(steel_ingot), 1, 3, 8));
		desertChest.addItem(new WeightedRandomChestContent(new ItemStack(soul_gem), 0, 3, 1));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(copper_ingot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(tin_ingot), 1, 5, 30));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(bronze_ingot), 1, 3, 25));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(steel_ingot), 1, 3, 25));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(meurodite_gem), 1, 2, 13));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(sunstone_shard), 1, 8, 15));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(desert_quartz_item), 1, 5, 15));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(radiant_quartz), 1, 3, 8));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(steel_sword), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(steel_pickaxe), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(steel_helmet), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(steel_chestplate), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(steel_leggings), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(steel_boots), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(bronze_sword), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(bronze_pickaxe), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(bronze_helmet), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(bronze_chestplate), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(bronze_leggings), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(bronze_boots), 1, 1, 2));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(MBlocks.radiant_ore), 1, 1, 1));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(titanium_ingot), 0, 1, 1));
		blacksmithChest.addItem(new WeightedRandomChestContent(new ItemStack(soul_gem), 0, 3, 1));
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MReference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
