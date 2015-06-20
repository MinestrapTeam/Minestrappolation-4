package minestrapteam.minestrappolation.lib;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.item.ItemChunk;
import minestrapteam.minestrappolation.item.ItemMArmor;
import minestrapteam.minestrappolation.item.ItemMAxe;
import minestrapteam.minestrappolation.item.ItemMHoe;
import minestrapteam.minestrappolation.item.ItemMPickaxe;
import minestrapteam.minestrappolation.item.ItemMShovel;
import minestrapteam.minestrappolation.item.ItemMSoup;
import minestrapteam.minestrappolation.item.ItemMSword;
import minestrapteam.minestrappolation.item.ItemSifter;
import minestrapteam.minestrappolation.item.ItemSoulGem;
import minestrapteam.minestrappolation.item.MItemFoiled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MItems extends Item
{
	public static Item							dough;
	public static Item							sugar_dough;
	public static Item							chocolate_dough;
	public static Item							sugar_cookie;
	public static Item							pie_crust;
	public static Item							apple_pie;
	public static Item							fried_egg;
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
		
		tin_helmet = new ItemMArmor(ARMOR_TIN, 0, 0, tin_ingot).setUnlocalizedName("tin_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		tin_chestplate = new ItemMArmor(ARMOR_TIN, 0, 1, tin_ingot).setUnlocalizedName("tin_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		tin_leggings = new ItemMArmor(ARMOR_TIN, 0, 2, tin_ingot).setUnlocalizedName("tin_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		tin_boots = new ItemMArmor(ARMOR_TIN, 0, 3, tin_ingot).setUnlocalizedName("tin_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		bronze_helmet = new ItemMArmor(ARMOR_BRONZE, 0, 0, bronze_ingot).setUnlocalizedName("bronze_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		bronze_chestplate = new ItemMArmor(ARMOR_BRONZE, 0, 1, bronze_ingot).setUnlocalizedName("bronze_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		bronze_leggings = new ItemMArmor(ARMOR_BRONZE, 0, 2, bronze_ingot).setUnlocalizedName("bronze_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		bronze_boots = new ItemMArmor(ARMOR_BRONZE, 0, 3, bronze_ingot).setUnlocalizedName("bronze_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		steel_helmet = new ItemMArmor(ARMOR_STEEL, 0, 0, steel_ingot).setUnlocalizedName("steel_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		steel_chestplate = new ItemMArmor(ARMOR_STEEL, 0, 1, steel_ingot).setUnlocalizedName("steel_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		steel_leggings = new ItemMArmor(ARMOR_STEEL, 0, 2, steel_ingot).setUnlocalizedName("steel_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		steel_boots = new ItemMArmor(ARMOR_STEEL, 0, 3, steel_ingot).setUnlocalizedName("steel_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		meurodite_helmet = new ItemMArmor(ARMOR_MEURODITE, 0, 0, meurodite_gem).setUnlocalizedName("meurodite_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		meurodite_chestplate = new ItemMArmor(ARMOR_MEURODITE, 0, 1, meurodite_gem).setUnlocalizedName("meurodite_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		meurodite_leggings = new ItemMArmor(ARMOR_MEURODITE, 0, 2, meurodite_gem).setUnlocalizedName("meurodite_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		meurodite_boots = new ItemMArmor(ARMOR_MEURODITE, 0, 3, meurodite_gem).setUnlocalizedName("meurodite_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		torite_helmet = new ItemMArmor(ARMOR_TORITE, 0, 0, torite_ingot).setUnlocalizedName("torite_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		torite_chestplate = new ItemMArmor(ARMOR_TORITE, 0, 1, torite_ingot).setUnlocalizedName("torite_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		torite_leggings = new ItemMArmor(ARMOR_TORITE, 0, 2, torite_ingot).setUnlocalizedName("torite_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		torite_boots = new ItemMArmor(ARMOR_TORITE, 0, 3, torite_ingot).setUnlocalizedName("torite_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		blazium_helmet = new ItemMArmor(ARMOR_BLAZIUM, 0, 0, blazium_ingot).setUnlocalizedName("blazium_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		blazium_chestplate = new ItemMArmor(ARMOR_BLAZIUM, 0, 1, blazium_ingot).setUnlocalizedName("blazium_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		blazium_leggings = new ItemMArmor(ARMOR_BLAZIUM, 0, 2, blazium_ingot).setUnlocalizedName("blazium_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		blazium_boots = new ItemMArmor(ARMOR_BLAZIUM, 0, 3, blazium_ingot).setUnlocalizedName("blazium_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		titanium_helmet = new ItemMArmor(ARMOR_TITANIUM, 0, 0, titanium_ingot).setUnlocalizedName("titanium_helmet").setCreativeTab(Minestrappolation.tabMCombat);
		titanium_chestplate = new ItemMArmor(ARMOR_TITANIUM, 0, 1, titanium_ingot).setUnlocalizedName("titanium_chestplate").setCreativeTab(Minestrappolation.tabMCombat);
		titanium_leggings = new ItemMArmor(ARMOR_TITANIUM, 0, 2, titanium_ingot).setUnlocalizedName("titanium_leggings").setCreativeTab(Minestrappolation.tabMCombat);
		titanium_boots = new ItemMArmor(ARMOR_TITANIUM, 0, 3, titanium_ingot).setUnlocalizedName("titanium_boots").setCreativeTab(Minestrappolation.tabMCombat);
		
		radiant_quartz = new MItemFoiled().setUnlocalizedName("radiant_quartz").setCreativeTab(Minestrappolation.tabMMaterials);
		meurodite_gem = new Item().setUnlocalizedName("meurodite_gem").setCreativeTab(Minestrappolation.tabMMaterials);
		torite_ingot = new Item().setUnlocalizedName("torite_ingot").setCreativeTab(Minestrappolation.tabMMaterials);
		desert_quartz_item = new Item().setUnlocalizedName("desert_quartz_item").setCreativeTab(Minestrappolation.tabMMaterials);
		blaze_shard = new Item().setUnlocalizedName("blaze_shard").setCreativeTab(Minestrappolation.tabMMaterials);
		soul_gem = new ItemSoulGem().setUnlocalizedName("soul_gem").setCreativeTab(Minestrappolation.tabMMaterials);
		
		chunks = new ItemChunk().setUnlocalizedName("chunks").setCreativeTab(Minestrappolation.tabMMaterials);
		
		sifter = new ItemSifter().setUnlocalizedName("sifter");
		addItemsToChests();
	}
	
	public static void register()
	{
		GameRegistry.registerItem(reinforced_stick, reinforced_stick.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(stone_brick, stone_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(deepstone_brick, deepstone_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(red_rock_brick, red_rock_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(deep_red_rock_brick, deep_red_rock_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(coldstone_brick, coldstone_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(deep_coldstone_brick, deep_coldstone_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(icestone_brick, icestone_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(glacierrock_brick, glacierrock_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(oceanstone_brick, oceanstone_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pressurized_oceanstone_brick, pressurized_oceanstone_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(slate_brick, slate_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(granite_brick, granite_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(diorite_brick, diorite_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(andesite_brick, andesite_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(flint_brick, flint_brick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(obsidian_brick, obsidian_brick.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(chunks, chunks.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(desert_quartz_item, desert_quartz_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_ingot, copper_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_ingot, tin_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bronze_ingot, bronze_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steel_ingot, steel_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(meurodite_gem, meurodite_gem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(torite_ingot, torite_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sunstone_shard, sunstone_shard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(plutonium, plutonium.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(uranium, uranium.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(radiant_quartz, radiant_quartz.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(titanium_ingot, titanium_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(blaze_shard, blaze_shard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(blazium_ingot, blazium_ingot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(soul_gem, soul_gem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_plating, tin_plating.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steel_plating, steel_plating.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(meurodite_plating, meurodite_plating.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(dough, dough.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sugar_dough, sugar_dough.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(chocolate_dough, chocolate_dough.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(sugar_cookie, sugar_cookie.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pie_crust, pie_crust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(apple_pie, apple_pie.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fried_egg, fried_egg.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(copper_pickaxe, copper_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_axe, copper_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_shovel, copper_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_hoe, copper_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_sword, copper_sword.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(tin_helmet, tin_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_chestplate, tin_chestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_leggings, tin_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_boots, tin_boots.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(bronze_pickaxe, bronze_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bronze_axe, bronze_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bronze_shovel, bronze_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bronze_hoe, bronze_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bronze_sword, bronze_sword.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(bronze_helmet, bronze_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bronze_chestplate, bronze_chestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bronze_leggings, bronze_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bronze_boots, bronze_boots.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(steel_pickaxe, steel_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steel_axe, steel_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steel_shovel, steel_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steel_hoe, steel_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steel_sword, steel_sword.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(steel_helmet, steel_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steel_chestplate, steel_chestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steel_leggings, steel_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(steel_boots, steel_boots.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(meurodite_pickaxe, meurodite_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(meurodite_axe, meurodite_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(meurodite_shovel, meurodite_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(meurodite_hoe, meurodite_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(meurodite_sword, meurodite_sword.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(meurodite_helmet, meurodite_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(meurodite_chestplate, meurodite_chestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(meurodite_leggings, meurodite_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(meurodite_boots, meurodite_boots.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(torite_pickaxe, torite_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(torite_axe, torite_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(torite_shovel, torite_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(torite_hoe, torite_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(torite_sword, torite_sword.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(torite_helmet, torite_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(torite_chestplate, torite_chestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(torite_leggings, torite_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(torite_boots, torite_boots.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(titanium_pickaxe, titanium_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(titanium_axe, titanium_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(titanium_shovel, titanium_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(titanium_hoe, titanium_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(titanium_sword, titanium_sword.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(titanium_helmet, titanium_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(titanium_chestplate, titanium_chestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(titanium_leggings, titanium_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(titanium_boots, titanium_boots.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(fire_pickaxe, fire_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fire_axe, fire_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fire_shovel, fire_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fire_hoe, fire_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(fire_sword, fire_sword.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(blazium_helmet, blazium_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(blazium_chestplate, blazium_chestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(blazium_leggings, blazium_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(blazium_boots, blazium_boots.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(bedrock_pickaxe, bedrock_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bedrock_axe, bedrock_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bedrock_shovel, bedrock_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(bedrock_hoe, bedrock_hoe.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(sifter, sifter.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(dough);
		registerRender(sugar_dough);
		registerRender(chocolate_dough);
		registerRender(sugar_cookie);
		registerRender(pie_crust);
		registerRender(apple_pie);
		registerRender(fried_egg);
		registerRender(copper_ingot);
		registerRender(tin_ingot);
		registerRender(bronze_ingot);
		registerRender(steel_ingot);
		registerRender(blazium_ingot);
		registerRender(titanium_ingot);
		registerRender(sunstone_shard);
		registerRender(plutonium);
		registerRender(uranium);
		registerRender(tin_plating);
		registerRender(steel_plating);
		registerRender(meurodite_plating);
		registerRender(reinforced_stick);
		
		registerRender(stone_brick);
		registerRender(deepstone_brick);
		registerRender(coldstone_brick);
		registerRender(deep_coldstone_brick);
		registerRender(red_rock_brick);
		registerRender(deep_red_rock_brick);
		registerRender(icestone_brick);
		registerRender(glacierrock_brick);
		registerRender(oceanstone_brick);
		registerRender(pressurized_oceanstone_brick);
		registerRender(slate_brick);
		registerRender(granite_brick);
		registerRender(diorite_brick);
		registerRender(andesite_brick);
		registerRender(flint_brick);
		registerRender(obsidian_brick);
		registerRender(desert_quartz_item);
		
		registerRender(copper_pickaxe);
		registerRender(copper_axe);
		registerRender(copper_shovel);
		registerRender(copper_hoe);
		registerRender(copper_sword);
		
		registerRender(bronze_pickaxe);
		registerRender(bronze_axe);
		registerRender(bronze_shovel);
		registerRender(bronze_hoe);
		registerRender(bronze_sword);
		
		registerRender(steel_pickaxe);
		registerRender(steel_axe);
		registerRender(steel_shovel);
		registerRender(steel_hoe);
		registerRender(steel_sword);
		
		registerRender(meurodite_pickaxe);
		registerRender(meurodite_axe);
		registerRender(meurodite_shovel);
		registerRender(meurodite_hoe);
		registerRender(meurodite_sword);
		
		registerRender(torite_pickaxe);
		registerRender(torite_axe);
		registerRender(torite_shovel);
		registerRender(torite_hoe);
		registerRender(torite_sword);
		
		registerRender(fire_pickaxe);
		registerRender(fire_axe);
		registerRender(fire_shovel);
		registerRender(fire_hoe);
		registerRender(fire_sword);
		
		registerRender(titanium_pickaxe);
		registerRender(titanium_axe);
		registerRender(titanium_shovel);
		registerRender(titanium_hoe);
		registerRender(titanium_sword);
		
		registerRender(bedrock_pickaxe);
		registerRender(bedrock_axe);
		registerRender(bedrock_shovel);
		registerRender(bedrock_hoe);
		
		registerRender(tin_helmet);
		registerRender(tin_chestplate);
		registerRender(tin_leggings);
		registerRender(tin_boots);
		
		registerRender(bronze_helmet);
		registerRender(bronze_chestplate);
		registerRender(bronze_leggings);
		registerRender(bronze_boots);
		
		registerRender(steel_helmet);
		registerRender(steel_chestplate);
		registerRender(steel_leggings);
		registerRender(steel_boots);
		
		registerRender(meurodite_helmet);
		registerRender(meurodite_chestplate);
		registerRender(meurodite_leggings);
		registerRender(meurodite_boots);
		
		registerRender(torite_helmet);
		registerRender(torite_chestplate);
		registerRender(torite_leggings);
		registerRender(torite_boots);
		
		registerRender(blazium_helmet);
		registerRender(blazium_chestplate);
		registerRender(blazium_leggings);
		registerRender(blazium_boots);
		
		registerRender(titanium_helmet);
		registerRender(titanium_chestplate);
		registerRender(titanium_leggings);
		registerRender(titanium_boots);
		
		registerRender(radiant_quartz);
		registerRender(meurodite_gem);
		registerRender(blaze_shard);
		registerRender(soul_gem);
		registerRender(torite_ingot);
		
		registerRender(sifter);
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
