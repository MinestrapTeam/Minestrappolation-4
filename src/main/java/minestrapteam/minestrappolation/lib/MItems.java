package minestrapteam.minestrappolation.lib;

import minestrapteam.minestrappolation.Minestrappolation;
import minestrapteam.minestrappolation.item.ItemMArmor;
import minestrapteam.minestrappolation.item.ItemMAxe;
import minestrapteam.minestrappolation.item.ItemMDoor;
import minestrapteam.minestrappolation.item.ItemMHoe;
import minestrapteam.minestrappolation.item.ItemMPickaxe;
import minestrapteam.minestrappolation.item.ItemMShovel;
import minestrapteam.minestrappolation.item.ItemMSword;
import minestrapteam.minestrappolation.item.ItemSoulGem;
import minestrapteam.minestrappolation.item.MItemFoiled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MItems extends Item
{
	public static Item							dough;
	public static Item							sugar_dough;
	public static Item							chocolate_dough;
	public static Item							sugar_cookie;
	public static Item							copper_ingot;
	public static Item							tin_ingot;
	public static Item							sunstone_shard;
	
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
	
	public static Item							copper_pickaxe;
	public static Item							copper_axe;
	public static Item							copper_shovel;
	public static Item							copper_hoe;
	public static Item							copper_sword;
	
	public static Item							tin_helmet;
	public static Item							tin_chestplate;
	public static Item							tin_leggings;
	public static Item							tin_boots;
	
	public static Item							radiant_quartz;	
	public static Item							meurodite_gem;
	public static Item							soul_gem;
	public static Item							torite_ingot;
	public static Item 							desert_quartz;
	public static Item 							blaze_shard;
	
	public static final Item.ToolMaterial		COPPER		= EnumHelper.addToolMaterial("COPPER", 1, 186, 4.5F, 1.5F, 18);
	public static final ItemArmor.ArmorMaterial	ARMOR_TIN	= EnumHelper.addArmorMaterial("ARMOR_TIN", "tin", 4, new int[] { 2, 4, 3, 2 }, 6);
	
	public static void init()
	{
		dough = new ItemFood(1, 0.2F, false).setUnlocalizedName("dough").setCreativeTab(Minestrappolation.tabMinistrappolation);
		sugar_dough = new ItemFood(1, 0.2F, false).setPotionEffect(Potion.moveSpeed.id, 5, 0, 0.3F).setUnlocalizedName("sugar_dough").setCreativeTab(Minestrappolation.tabMinistrappolation);
		chocolate_dough = new ItemFood(1, 0.3F, false).setUnlocalizedName("chocolate_dough").setCreativeTab(Minestrappolation.tabMinistrappolation);
		sugar_cookie = new ItemFood(1, 0.4F, false).setPotionEffect(Potion.moveSpeed.id, 10, 0, 0.5F).setUnlocalizedName("sugar_cookie").setCreativeTab(Minestrappolation.tabMinistrappolation);
		copper_ingot = new Item().setUnlocalizedName("copper_ingot").setCreativeTab(Minestrappolation.tabMinistrappolation);
		tin_ingot = new Item().setUnlocalizedName("tin_ingot").setCreativeTab(Minestrappolation.tabMinistrappolation);
		sunstone_shard = new Item().setUnlocalizedName("sunstone_shard").setCreativeTab(Minestrappolation.tabMinistrappolation);
		
		stone_brick = new Item().setUnlocalizedName("stone_brick").setCreativeTab(Minestrappolation.tabMinistrappolation);
		deepstone_brick = new Item().setUnlocalizedName("deepstone_brick").setCreativeTab(Minestrappolation.tabMinistrappolation);
		red_rock_brick = new Item().setUnlocalizedName("red_rock_brick").setCreativeTab(Minestrappolation.tabMinistrappolation);
		deep_red_rock_brick = new Item().setUnlocalizedName("deep_red_rock_brick").setCreativeTab(Minestrappolation.tabMinistrappolation);
		coldstone_brick = new Item().setUnlocalizedName("coldstone_brick").setCreativeTab(Minestrappolation.tabMinistrappolation);
		deep_coldstone_brick = new Item().setUnlocalizedName("deep_coldstone_brick").setCreativeTab(Minestrappolation.tabMinistrappolation);
		icestone_brick = new Item().setUnlocalizedName("icestone_brick").setCreativeTab(Minestrappolation.tabMinistrappolation);
		glacierrock_brick = new Item().setUnlocalizedName("glacierrock_brick").setCreativeTab(Minestrappolation.tabMinistrappolation);
		oceanstone_brick = new Item().setUnlocalizedName("oceanstone_brick").setCreativeTab(Minestrappolation.tabMinistrappolation);
		pressurized_oceanstone_brick = new Item().setUnlocalizedName("pressurized_oceanstone_brick").setCreativeTab(Minestrappolation.tabMinistrappolation);
		slate_brick = new Item().setUnlocalizedName("slate_brick").setCreativeTab(Minestrappolation.tabMinistrappolation);
		
		copper_pickaxe = new ItemMPickaxe(COPPER, copper_ingot).setUnlocalizedName("copper_pickaxe").setCreativeTab(Minestrappolation.tabMinistrappolation);
		copper_axe = new ItemMAxe(COPPER, copper_ingot).setUnlocalizedName("copper_axe").setCreativeTab(Minestrappolation.tabMinistrappolation);
		copper_shovel = new ItemMShovel(COPPER, copper_ingot).setUnlocalizedName("copper_shovel").setCreativeTab(Minestrappolation.tabMinistrappolation);
		copper_hoe = new ItemMHoe(COPPER, copper_ingot).setUnlocalizedName("copper_hoe").setCreativeTab(Minestrappolation.tabMinistrappolation);
		copper_sword = new ItemMSword(COPPER, copper_ingot).setUnlocalizedName("copper_sword").setCreativeTab(Minestrappolation.tabMinistrappolation);
		
		tin_helmet = new ItemMArmor(ARMOR_TIN, 0, 0, tin_ingot).setUnlocalizedName("tin_helmet").setCreativeTab(Minestrappolation.tabMinistrappolation);
		tin_chestplate = new ItemMArmor(ARMOR_TIN, 0, 1, tin_ingot).setUnlocalizedName("tin_chestplate").setCreativeTab(Minestrappolation.tabMinistrappolation);
		tin_leggings = new ItemMArmor(ARMOR_TIN, 0, 2, tin_ingot).setUnlocalizedName("tin_leggings").setCreativeTab(Minestrappolation.tabMinistrappolation);
		tin_boots = new ItemMArmor(ARMOR_TIN, 0, 3, tin_ingot).setUnlocalizedName("tin_boots").setCreativeTab(Minestrappolation.tabMinistrappolation);
	
		radiant_quartz = new MItemFoiled().setUnlocalizedName("radiant_quartz").setCreativeTab(Minestrappolation.tabMinistrappolation);
		meurodite_gem = new Item().setUnlocalizedName("meurodite_gem").setCreativeTab(Minestrappolation.tabMinistrappolation);
		torite_ingot = new Item().setUnlocalizedName("torite_ingot").setCreativeTab(Minestrappolation.tabMinistrappolation);
		desert_quartz = new Item().setUnlocalizedName("desert_quartz").setCreativeTab(Minestrappolation.tabMinistrappolation);
		blaze_shard = new Item().setUnlocalizedName("blaze_shard").setCreativeTab(Minestrappolation.tabMinistrappolation);
		soul_gem = new ItemSoulGem().setUnlocalizedName("soul_gem").setCreativeTab(Minestrappolation.tabMinistrappolation);
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
		
		GameRegistry.registerItem(copper_pickaxe, copper_pickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_axe, copper_axe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_shovel, copper_shovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_hoe, copper_hoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(copper_sword, copper_sword.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(tin_helmet, tin_helmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_chestplate, tin_chestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_leggings, tin_leggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tin_boots, tin_boots.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(radiant_quartz, radiant_quartz.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(meurodite_gem, meurodite_gem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(blaze_shard, blaze_shard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(soul_gem, soul_gem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(torite_ingot, torite_ingot.getUnlocalizedName().substring(5));		
		GameRegistry.registerItem(desert_quartz, "item_desert_quartz");
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
		registerRender(desert_quartz);
		
		registerRender(copper_pickaxe);
		registerRender(copper_axe);
		registerRender(copper_shovel);
		registerRender(copper_hoe);
		registerRender(copper_sword);
		
		registerRender(tin_helmet);
		registerRender(tin_chestplate);
		registerRender(tin_leggings);
		registerRender(tin_boots);
		
		registerRender(radiant_quartz);
		registerRender(meurodite_gem);
		registerRender(blaze_shard);
		registerRender(soul_gem);
		registerRender(torite_ingot);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(MReference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
