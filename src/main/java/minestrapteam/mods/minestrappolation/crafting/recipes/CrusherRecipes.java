package minestrapteam.mods.minestrappolation.crafting.recipes;

import com.google.common.collect.Maps;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class CrusherRecipes
{
	private static final CrusherRecipes                crusherBase    = new CrusherRecipes();
	private              Map                           meltingList    = Maps.newHashMap();
	private              Map                           experienceList = Maps.newHashMap();
	private              Map                           chance         = Maps.newHashMap();
	public               HashMap<ItemStack, ItemStack> extraDropList  = new HashMap<ItemStack, ItemStack>();

	public static CrusherRecipes instance()
	{
		return crusherBase;
	}

	private CrusherRecipes()
	{
		//Stones
		this.addRecipe(new ItemStack(Blocks.stone, 1, 0), new ItemStack(Blocks.cobblestone, 1), 0.05F, null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 0), new ItemStack(MBlocks.biome_cobble, 1, 0), 0.05F,
		               null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 1), new ItemStack(MBlocks.biome_cobble, 1, 1), 0.05F,
		               null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 2), new ItemStack(MBlocks.biome_cobble, 1, 2), 0.05F,
		               null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 3), new ItemStack(MBlocks.biome_cobble, 1, 3), 0.05F,
		               null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 4), new ItemStack(MBlocks.biome_cobble, 1, 4), 0.05F,
		               null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 5), new ItemStack(MBlocks.biome_cobble, 1, 5), 0.05F,
		               null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 6), new ItemStack(MBlocks.biome_cobble, 1, 6), 0.05F,
		               null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 7), new ItemStack(MBlocks.biome_cobble, 1, 7), 0.05F,
		               null, 0);
		this.addRecipe(new ItemStack(MBlocks.biome_stones, 1, 8), new ItemStack(MBlocks.biome_cobble, 1, 8), 0.05F,
		               null, 0);

		this.addRecipe(new ItemStack(Blocks.mossy_cobblestone, 1, 0), new ItemStack(Blocks.gravel, 1), 0.05F,
		               new ItemStack(Blocks.vine, 1), 1);

		this.addRecipe(new ItemStack(Blocks.cobblestone, 1, 0), new ItemStack(Blocks.gravel, 1), 0.05F,
		               new ItemStack(MItems.chunks, 1, 0), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 0), new ItemStack(Blocks.gravel, 1), 0.05F,
		               new ItemStack(MItems.chunks, 1, 0), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 1), new ItemStack(Blocks.gravel, 1), 0.05F,
		               new ItemStack(MItems.chunks, 1, 1), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 2), new ItemStack(Blocks.gravel, 1), 0.05F,
		               new ItemStack(MItems.chunks, 1, 1), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 3), new ItemStack(Blocks.gravel, 1), 0.05F,
		               new ItemStack(MItems.chunks, 1, 2), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 4), new ItemStack(Blocks.gravel, 1), 0.05F,
		               new ItemStack(MItems.chunks, 1, 2), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 5), new ItemStack(Blocks.gravel, 1), 0.05F,
		               new ItemStack(MItems.chunks, 1, 3), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 6), new ItemStack(Blocks.gravel, 1), 0.05F,
		               new ItemStack(MItems.chunks, 1, 3), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 7), new ItemStack(Blocks.gravel, 1), 0.05F,
		               new ItemStack(MItems.chunks, 1, 4), 5);
		this.addRecipe(new ItemStack(MBlocks.biome_cobble, 1, 8), new ItemStack(Blocks.gravel, 1), 0.05F,
		               new ItemStack(MItems.chunks, 1, 4), 5);

		this.addRecipe(new ItemStack(Blocks.stone, 1, 3), new ItemStack(MItems.desert_quartz_item, 2, 0), 0.1F,
		               new ItemStack(MItems.chunks, 1, 0), 80);
		this.addRecipe(new ItemStack(Blocks.stone, 1, 1), new ItemStack(Blocks.stone, 1, 3), 0.1F,
		               new ItemStack(MItems.desert_quartz_item, 1, 0), 80);
		this.addRecipe(new ItemStack(Blocks.stone, 1, 5), new ItemStack(Blocks.stone, 1, 3), 0.1F,
		               new ItemStack(MItems.chunks, 1, 0), 80);
		this.addRecipe(new ItemStack(MBlocks.slate, 1, 0), new ItemStack(Items.clay_ball, 2, 0), 0.1F,
		               new ItemStack(MItems.desert_quartz_item, 1, 0), 80);

		this.addRecipe(Blocks.sandstone, new ItemStack(Blocks.sand, 3, 0), 0.5F,
		               new ItemStack(MItems.desert_quartz_item), 2);
		this.addRecipe(Blocks.red_sandstone, new ItemStack(Blocks.sand, 3, 1), 0.5F,
		               new ItemStack(MItems.desert_quartz_item), 2);

		this.addRecipe(Blocks.hardened_clay, new ItemStack(Blocks.sand, 1, 1), 0.2F, null, 0);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 0), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 15), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 1), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 14), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 2), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 13), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 3), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 12), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 4), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 11), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 5), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 10), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 6), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 9), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 7), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 8), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 8), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 7), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 9), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 6), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 10), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 5), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 11), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 4), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 12), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 3), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 13), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 2), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 14), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 1), 5);
		this.addRecipe(new ItemStack(Blocks.stained_hardened_clay, 1, 15), new ItemStack(Blocks.sand, 1, 1), 0.2F,
		               new ItemStack(Items.dye, 1, 0), 5);

		this.addRecipe(new ItemStack(Blocks.prismarine, 1, 0), new ItemStack(Items.prismarine_shard, 3, 0), 0.3F,
		               new ItemStack(Items.prismarine_crystals, 1, 0), 3);
		this.addRecipe(new ItemStack(Items.prismarine_shard, 1, 0), new ItemStack(MItems.chunks, 1, 3), 0.1F,
		               new ItemStack(MItems.radiant_quartz, 1, 0), 1);

		this.addRecipe(new ItemStack(MBlocks.flint_block, 1), new ItemStack(Items.flint, 3, 0), 0.1F,
		               new ItemStack(Items.flint, 1, 0), 30);
		this.addRecipe(new ItemStack(MBlocks.desert_quartz_block, 1), new ItemStack(MItems.desert_quartz_item, 3), 0.1F,
		               new ItemStack(MItems.desert_quartz_item, 1), 10);
		this.addRecipe(new ItemStack(Blocks.quartz_block, 1, 0), new ItemStack(Items.quartz, 3, 0), 0.1F,
		               new ItemStack(Items.quartz, 1, 0), 10);

		//Ores
		this.addRecipe(Blocks.coal_ore, new ItemStack(Items.coal, 3, 0), 0.05F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 0), new ItemStack(Items.coal, 3, 0), 0.05F,
		               new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 1), new ItemStack(Items.coal, 3, 0), 0.05F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 2), new ItemStack(Items.coal, 3, 0), 0.05F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 3), new ItemStack(Items.coal, 3, 0), 0.05F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 4), new ItemStack(Items.coal, 3, 0), 0.05F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 5), new ItemStack(Items.coal, 3, 0), 0.05F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 6), new ItemStack(Items.coal, 3, 0), 0.05F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 7), new ItemStack(Items.coal, 3, 0), 0.05F,
		               new ItemStack(MItems.chunks, 1, 4), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_coal, 1, 8), new ItemStack(Items.coal, 3, 0), 0.05F,
		               new ItemStack(MItems.chunks, 1, 4), 20);

		this.addRecipe(Blocks.iron_ore, new ItemStack(MItems.chunks, 2, 7), 0.35F, new ItemStack(MItems.chunks, 1, 0),
		               20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 0), new ItemStack(MItems.chunks, 2, 7), 0.35F,
		               new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 1), new ItemStack(MItems.chunks, 2, 7), 0.35F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 2), new ItemStack(MItems.chunks, 2, 7), 0.35F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 3), new ItemStack(MItems.chunks, 2, 7), 0.35F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 4), new ItemStack(MItems.chunks, 2, 7), 0.35F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 5), new ItemStack(MItems.chunks, 2, 7), 0.35F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 6), new ItemStack(MItems.chunks, 2, 7), 0.35F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 7), new ItemStack(MItems.chunks, 2, 7), 0.35F,
		               new ItemStack(MItems.chunks, 1, 4), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_iron, 1, 8), new ItemStack(MItems.chunks, 2, 7), 0.35F,
		               new ItemStack(MItems.chunks, 1, 4), 20);

		this.addRecipe(Blocks.gold_ore, new ItemStack(MItems.chunks, 2, 8), 0.5F, new ItemStack(MItems.chunks, 1, 0),
		               20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 0), new ItemStack(MItems.chunks, 2, 8), 0.5F,
		               new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 1), new ItemStack(MItems.chunks, 2, 8), 0.5F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 2), new ItemStack(MItems.chunks, 2, 8), 0.5F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 3), new ItemStack(MItems.chunks, 2, 8), 0.5F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 4), new ItemStack(MItems.chunks, 2, 8), 0.5F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 5), new ItemStack(MItems.chunks, 2, 8), 0.5F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 6), new ItemStack(MItems.chunks, 2, 8), 0.5F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 7), new ItemStack(MItems.chunks, 2, 8), 0.5F,
		               new ItemStack(MItems.chunks, 1, 4), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_gold, 1, 8), new ItemStack(MItems.chunks, 2, 8), 0.5F,
		               new ItemStack(MItems.chunks, 1, 4), 20);

		this.addRecipe(Blocks.redstone_ore, new ItemStack(Items.redstone, 9, 0), 0.35F,
		               new ItemStack(Items.glowstone_dust), 5);
		this.addRecipe(MBlocks.biome_redstone, new ItemStack(Items.redstone, 9, 0), 0.35F,
		               new ItemStack(Items.glowstone_dust), 5);

		this.addRecipe(Blocks.lapis_ore, new ItemStack(Items.dye, 18, 4), 0.1F, new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 0), new ItemStack(Items.dye, 18, 4), 0.1F,
		               new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 1), new ItemStack(Items.dye, 18, 4), 0.1F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 2), new ItemStack(Items.dye, 18, 4), 0.1F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 3), new ItemStack(Items.dye, 18, 4), 0.1F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 4), new ItemStack(Items.dye, 18, 4), 0.1F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 5), new ItemStack(Items.dye, 18, 4), 0.1F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 6), new ItemStack(Items.dye, 18, 4), 0.1F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 7), new ItemStack(Items.dye, 18, 4), 0.1F,
		               new ItemStack(MItems.chunks, 1, 4), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_lapis, 1, 8), new ItemStack(Items.dye, 18, 4), 0.1F,
		               new ItemStack(MItems.chunks, 1, 4), 20);

		this.addRecipe(Blocks.emerald_ore, new ItemStack(Items.emerald, 2, 0), 0.5F, new ItemStack(Items.diamond), 5);
		this.addRecipe(MBlocks.biome_emerald, new ItemStack(Items.emerald, 2, 0), 0.5F, new ItemStack(Items.diamond),
		               5);

		this.addRecipe(Blocks.diamond_ore, new ItemStack(Items.diamond, 2, 0), 0.5F, new ItemStack(Items.emerald), 5);
		this.addRecipe(MBlocks.biome_diamond, new ItemStack(Items.diamond, 2, 0), 0.5F, new ItemStack(Items.emerald),
		               5);

		this.addRecipe(Blocks.quartz_ore, new ItemStack(Items.quartz, 3, 0), 0.5F, new ItemStack(MItems.radiant_quartz),
		               2);

		this.addRecipe(MBlocks.desert_quartz, new ItemStack(MItems.desert_quartz_item, 8, 0), 0.1F,
		               new ItemStack(MItems.radiant_quartz), 1);

		this.addDictionaryRecipes("oreCopper", new ItemStack(MItems.chunks, 2, 5), new ItemStack(MItems.chunks, 1, 6),
		                          0.25F, 8);

		this.addRecipe(MBlocks.tin_ore, new ItemStack(MItems.chunks, 2, 6), 0.25F, new ItemStack(MItems.chunks, 1, 5),
		               8);
		this.addRecipe(MBlocks.biome_tin, new ItemStack(MItems.chunks, 2, 6), 0.25F, new ItemStack(MItems.chunks, 1, 5),
		               8);

		this.addRecipe(MBlocks.meurodite_ore, new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F,
		               new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 0), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F,
		               new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 1), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 2), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 3), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 4), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 5), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 6), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 7), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F,
		               new ItemStack(MItems.chunks, 1, 4), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_meurodite, 1, 8), new ItemStack(MItems.meurodite_gem, 2, 0), 0.5F,
		               new ItemStack(MItems.chunks, 1, 4), 20);

		this.addRecipe(MBlocks.torite_ore, new ItemStack(MItems.chunks, 2, 9), 0.6F, new ItemStack(Items.emerald), 1);
		this.addRecipe(MBlocks.biome_torite, new ItemStack(MItems.chunks, 2, 9), 0.6F, new ItemStack(Items.emerald), 1);

		this.addRecipe(MBlocks.sunstone_ore, new ItemStack(MItems.sunstone_shard, 6, 0), 0.5F,
		               new ItemStack(Items.glowstone_dust), 5);
		this.addRecipe(MBlocks.biome_sunstone, new ItemStack(MItems.sunstone_shard, 6, 0), 0.5F,
		               new ItemStack(Items.glowstone_dust), 5);

		this.addRecipe(MBlocks.plutonium_ore, new ItemStack(MItems.plutonium, 3, 0), 0.5F,
		               new ItemStack(MItems.uranium), 3);
		this.addRecipe(MBlocks.biome_plutonium, new ItemStack(MItems.plutonium, 3, 0), 0.5F,
		               new ItemStack(MItems.uranium), 3);

		this.addRecipe(MBlocks.uranium_ore, new ItemStack(MItems.uranium, 3, 0), 0.5F, new ItemStack(MItems.plutonium),
		               3);
		this.addRecipe(MBlocks.biome_uranium, new ItemStack(MItems.uranium, 3, 0), 0.5F,
		               new ItemStack(MItems.plutonium), 3);

		this.addRecipe(MBlocks.radiant_ore, new ItemStack(MItems.radiant_quartz, 3, 0), 0.6F,
		               new ItemStack(Items.prismarine_shard), 20);
		this.addRecipe(MBlocks.biome_radiant, new ItemStack(MItems.radiant_quartz, 3, 0), 0.6F,
		               new ItemStack(Items.prismarine_shard), 20);

		this.addRecipe(MBlocks.titanium_ore, new ItemStack(MItems.chunks, 2, 10), 1.0F,
		               new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_titanium, 1, 0), new ItemStack(MItems.chunks, 2, 10), 1.0F,
		               new ItemStack(MItems.chunks, 1, 0), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_titanium, 1, 1), new ItemStack(MItems.chunks, 2, 10), 1.0F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_titanium, 1, 2), new ItemStack(MItems.chunks, 2, 10), 1.0F,
		               new ItemStack(MItems.chunks, 1, 1), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_titanium, 1, 3), new ItemStack(MItems.chunks, 2, 10), 1.0F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_titanium, 1, 4), new ItemStack(MItems.chunks, 2, 10), 1.0F,
		               new ItemStack(MItems.chunks, 1, 2), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_titanium, 1, 5), new ItemStack(MItems.chunks, 2, 10), 1.0F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_titanium, 1, 6), new ItemStack(MItems.chunks, 2, 10), 1.0F,
		               new ItemStack(MItems.chunks, 1, 3), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_titanium, 1, 7), new ItemStack(MItems.chunks, 2, 10), 1.0F,
		               new ItemStack(MItems.chunks, 1, 4), 20);
		this.addRecipe(new ItemStack(MBlocks.biome_titanium, 1, 8), new ItemStack(MItems.chunks, 2, 10), 1.0F,
		               new ItemStack(MItems.chunks, 1, 4), 20);

		this.addRecipe(MBlocks.blazium_ore, new ItemStack(MItems.blaze_shard, 6, 0), 0.5F,
		               new ItemStack(Items.blaze_powder), 20);
		this.addRecipe(MItems.blaze_shard, new ItemStack(Items.blaze_powder, 1, 0), 0.1F,
		               new ItemStack(MItems.sunstone_shard), 5);
		this.addRecipe(Items.blaze_rod, new ItemStack(Items.blaze_powder, 3, 0), 0.05F, new ItemStack(Items.dye, 1, 15),
		               10);

		this.addRecipe(MBlocks.soul_ore, new ItemStack(MItems.soul_gem, 2, 0), 0.5F, new ItemStack(Items.nether_wart),
		               2);

		this.addRecipe(MBlocks.dimensium_ore, new ItemStack(MItems.dimensium_chunk, 2), 0.5F,
		               new ItemStack(MItems.continnium_chunk, 1), 10);
		this.addRecipe(MBlocks.continnium_ore, new ItemStack(MItems.continnium_chunk, 2), 0.5F,
		               new ItemStack(MItems.dimensium_chunk, 1), 10);

		//Misc
		this.addRecipe(Blocks.clay, new ItemStack(Blocks.sand, 1, 0), 0.1F, new ItemStack(Items.clay_ball, 2, 0), 50);
		this.addRecipe(MBlocks.mud, new ItemStack(Blocks.dirt, 1, 0), 0.1F, new ItemStack(MItems.mud_ball, 1, 0), 10);
		this.addRecipe(MBlocks.rubble, new ItemStack(Blocks.gravel, 1, 0), 0.1F,
		               new ItemStack(MItems.technological_doodad, 1, 0), 10);
		this.addRecipe(Blocks.gravel, new ItemStack(Blocks.sand, 1, 0), 0.05F, new ItemStack(Items.flint, 1, 0), 30);
		this.addRecipe(new ItemStack(Blocks.dirt, 1, 1), new ItemStack(Blocks.dirt, 1, 0), 0.05F,
		               new ItemStack(Items.flint, 1, 0), 10);
		this.addRecipe(Blocks.bookshelf, new ItemStack(Items.book, 3), 0.05F, new ItemStack(Items.paper, 1), 5);
		this.addRecipe(Blocks.web, new ItemStack(Items.string, 4), .2F, new ItemStack(Items.spider_eye, 1, 0), 20);
		this.addRecipe(MBlocks.cold_cobweb, new ItemStack(Items.string, 4), .3F, new ItemStack(Blocks.ice, 1, 0), 5);
		this.addRecipe(Blocks.ladder, new ItemStack(Items.stick, 1), 0.05F, new ItemStack(Items.stick, 1), 50);
		this.addRecipe(MBlocks.dead_branch, new ItemStack(Items.stick, 12), 0.05F, new ItemStack(Items.stick, 4), 10);
		this.addRecipe(Blocks.anvil, new ItemStack(Blocks.iron_block, 1), 1.0F, new ItemStack(MItems.steel_ingot, 1),
		               10);
		this.addRecipe(Blocks.beacon, new ItemStack(Items.nether_star, 1), 0.2F, new ItemStack(Blocks.obsidian, 1), 50);
		this.addRecipe(Blocks.cauldron, new ItemStack(Items.iron_ingot, 4), 0.2F, new ItemStack(Items.iron_ingot, 1),
		               70);
		this.addRecipe(Blocks.hopper, new ItemStack(Items.iron_ingot, 3), 0.2F, new ItemStack(Blocks.planks, 1, 0), 70);
		this.addRecipe(Blocks.melon_block, new ItemStack(Items.melon, 9), 0.05F, new ItemStack(Items.melon_seeds, 1, 0),
		               70);
		this.addRecipe(Blocks.red_mushroom_block, new ItemStack(Blocks.red_mushroom, 3), 0.05F,
		               new ItemStack(Blocks.brown_mushroom, 1), 1);
		this.addRecipe(Blocks.brown_mushroom_block, new ItemStack(Blocks.brown_mushroom, 3), 0.05F,
		               new ItemStack(Blocks.red_mushroom, 1), 1);
		this.addRecipe(Blocks.lit_pumpkin, new ItemStack(Blocks.pumpkin, 1), 0.05F, new ItemStack(Blocks.torch, 1), 20);
		this.addRecipe(Blocks.glowstone, new ItemStack(Items.glowstone_dust, 4), 0F, null, 0);
		this.addRecipe(MBlocks.sunstone_block, new ItemStack(MItems.sunstone_shard, 4), 0F, null, 0);
		this.addRecipe(Items.reeds, new ItemStack(Items.paper, 2), 0F, new ItemStack(Items.sugar, 1), 5);
		this.addRecipe(Items.wheat, new ItemStack(MItems.dough, 1), 0F, new ItemStack(MItems.dough, 1), 30);
		this.addRecipe(Blocks.snow, new ItemStack(Items.snowball, 4), 0F, null, 0);
		this.addRecipe(Blocks.snow_layer, new ItemStack(Items.snowball, 2), 0F, null, 0);
		this.addRecipe(MBlocks.snow_bricks, new ItemStack(Items.snowball, 4), 0F, null, 0);
		this.addRecipe(MBlocks.snow_tiles, new ItemStack(Items.snowball, 4), 0F, null, 0);
		this.addRecipe(MBlocks.snow_refined, new ItemStack(Items.snowball, 4), 0F, null, 0);
		this.addRecipe(new ItemStack(MBlocks.cold_sand, 1, 0), new ItemStack(Blocks.sand, 1, 0), 0.1F,
		               new ItemStack(Blocks.ice), 5);
		this.addRecipe(new ItemStack(MBlocks.cold_sand, 1, 1), new ItemStack(Blocks.sand, 1, 1), 0.1F,
		               new ItemStack(Blocks.ice), 5);
		this.addRecipe(new ItemStack(MBlocks.dirt_permafrost, 1, 0), new ItemStack(Blocks.dirt, 1, 0), 0.1F,
		               new ItemStack(Blocks.packed_ice), 5);
		this.addRecipe(Blocks.ice, new ItemStack(MItems.crushed_ice, 1), 0.1F, new ItemStack(MItems.crushed_ice, 1),
		               50);
		this.addRecipe(Blocks.packed_ice, new ItemStack(MItems.crushed_ice, 1), 0.1F,
		               new ItemStack(MItems.crushed_ice, 1), 50);
		this.addRecipe(MBlocks.glacieric_ice, new ItemStack(MItems.crushed_ice, 4), 0.1F,
		               new ItemStack(MItems.glacieric_ice_shard, 1), 100);
		this.addRecipe(Items.diamond, new ItemStack(MItems.diamond_dust, 4), 0.1F,
		               new ItemStack(MItems.radiant_quartz, 1), 5);
		this.addRecipe(MItems.dimensium_ingot, new ItemStack(MItems.dimensium_dust, 8), 0.1F,
		               new ItemStack(MItems.dimensium_dust, 1), 10);
		this.addRecipe(MBlocks.hanging_glow_moss, new ItemStack(Items.glowstone_dust, 1), 0.1F,
		               new ItemStack(Items.glowstone_dust), 20);

		//Dyes
		this.addRecipe(Items.bone, new ItemStack(Items.dye, 5, 15), 0.1F, new ItemStack(Items.dye, 1, 15), 10);
		this.addRecipe(new ItemStack(Blocks.red_flower, 1, 3), new ItemStack(Items.dye, 3, 7), 0.1F,
		               new ItemStack(Items.dye, 1, 7), 10);
		this.addRecipe(new ItemStack(Blocks.red_flower, 1, 6), new ItemStack(Items.dye, 3, 7), 0.1F,
		               new ItemStack(Items.dye, 1, 7), 10);
		this.addRecipe(new ItemStack(Blocks.red_flower, 1, 8), new ItemStack(Items.dye, 3, 7), 0.1F,
		               new ItemStack(Items.dye, 1, 7), 10);
		this.addRecipe(new ItemStack(Blocks.red_flower, 1, 7), new ItemStack(Items.dye, 3, 9), 0.1F,
		               new ItemStack(Items.dye, 1, 9), 10);
		this.addRecipe(new ItemStack(Blocks.double_plant, 1, 5), new ItemStack(Items.dye, 5, 9), 0.1F,
		               new ItemStack(Items.dye, 1, 9), 10);
		this.addRecipe(new ItemStack(Blocks.red_flower, 1, 0), new ItemStack(Items.dye, 3, 1), 0.1F,
		               new ItemStack(Items.dye, 1, 1), 10);
		this.addRecipe(new ItemStack(Blocks.red_flower, 1, 4), new ItemStack(Items.dye, 3, 1), 0.1F,
		               new ItemStack(Items.dye, 1, 1), 10);
		this.addRecipe(new ItemStack(Blocks.double_plant, 1, 4), new ItemStack(Items.dye, 5, 1), 0.1F,
		               new ItemStack(Items.dye, 1, 1), 10);
		this.addRecipe(new ItemStack(Blocks.red_flower, 1, 5), new ItemStack(Items.dye, 3, 14), 0.1F,
		               new ItemStack(Items.dye, 1, 14), 10);
		this.addRecipe(new ItemStack(Blocks.yellow_flower, 1, 0), new ItemStack(Items.dye, 3, 11), 0.1F,
		               new ItemStack(Items.dye, 1, 11), 10);
		this.addRecipe(new ItemStack(Blocks.double_plant, 1, 0), new ItemStack(Items.dye, 5, 11), 0.1F,
		               new ItemStack(Items.dye, 1, 11), 10);
		this.addRecipe(new ItemStack(Blocks.red_flower, 1, 1), new ItemStack(Items.dye, 3, 12), 0.1F,
		               new ItemStack(Items.dye, 1, 12), 10);
		this.addRecipe(new ItemStack(Blocks.red_flower, 1, 2), new ItemStack(Items.dye, 3, 13), 0.1F,
		               new ItemStack(Items.dye, 1, 13), 10);
		this.addRecipe(new ItemStack(Blocks.double_plant, 1, 1), new ItemStack(Items.dye, 5, 13), 0.1F,
		               new ItemStack(Items.dye, 1, 13), 10);

		this.addRecipe(MItems.wither_bone, new ItemStack(MItems.deathmeal, 5), 0.1F, new ItemStack(MItems.deathmeal, 1),
		               10);
	}

	public void addRecipe(Block input, ItemStack stack, float experience, ItemStack extra, int chance)
	{
		this.addRecipe(Item.getItemFromBlock(input), stack, experience, extra, chance);
	}

	public void addRecipe(Item input, ItemStack stack, float experience, ItemStack extra, int chance)
	{
		this.addRecipe(new ItemStack(input, 1, 32767), stack, experience, extra, chance);
	}

	public void addRecipe(ItemStack input, ItemStack stack, float experience, ItemStack extra, int chance)
	{
		this.meltingList.put(input, stack);
		this.experienceList.put(stack, Float.valueOf(experience));
		this.extraDropList.put(input, extra);
		this.chance.put(input, chance);
	}

	public ItemStack getResult(ItemStack stack)
	{
		Iterator iterator = this.meltingList.entrySet().iterator();
		Entry entry;

		do
		{
			if (!iterator.hasNext())
				return null;

			entry = (Entry) iterator.next();
		}
		while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	public ItemStack getExtra(ItemStack stack)
	{
		Iterator iterator = this.extraDropList.entrySet().iterator();
		Entry entry;

		do
		{
			if (!iterator.hasNext())
				return null;

			entry = (Entry) iterator.next();
		}
		while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	public int getChance(ItemStack stack)
	{
		Iterator iterator = this.chance.entrySet().iterator();
		Entry entry;

		do
		{
			if (!iterator.hasNext())
				return 0;

			entry = (Entry) iterator.next();
		}
		while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));

		return (Integer) entry.getValue();
	}

	private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
	{
		return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1
			                                                                                                         .getMetadata());
	}

	public Map getSmeltingList()
	{
		return this.meltingList;
	}

	public float getSmeltingExperience(ItemStack stack)
	{
		float ret = stack.getItem().getSmeltingExperience(stack);
		if (ret != -1)
			return ret;

		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;

		do
		{
			if (!iterator.hasNext())
				return 0.0F;

			entry = (Entry) iterator.next();
		}
		while (!this.compareItemStacks(stack, (ItemStack) entry.getKey()));

		return ((Float) entry.getValue()).floatValue();
	}

	public void addDictionaryRecipes(String name, ItemStack output, ItemStack bonus, Float exp, int chance)
	{
		for (ItemStack is : OreDictionary.getOres(name))
		{
			this.addRecipe(is, output, exp, bonus, chance);
		}
	}
}
