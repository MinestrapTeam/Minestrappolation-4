package minestrapteam.mods.minestrappolation.block.biomeores;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.enumtypes.MStoneType;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockBiomeStones extends Block
{
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", MStoneType.class);

	public BlockBiomeStones()
	{
		super(Material.rock);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, MStoneType.DEEPSTONE));
		this.setCreativeTab(Minestrappolation.tabMBuilding);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(MBlocks.biome_cobble.getStateFromMeta(this.getMetaFromState(state)).getBlock());
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return ((MStoneType) state.getValue(VARIANT)).getMetadata();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		MStoneType[] aenumtype = MStoneType.values();
		int i = aenumtype.length;

		for (int j = 0; j < i; ++j)
		{
			MStoneType enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, MStoneType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((MStoneType) state.getValue(VARIANT)).getMetadata();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, VARIANT);
	}

	public static void inventoryRender()
	{
		Item item = GameRegistry.findItem(MReference.MODID, "biome_stone");

		ModelBakery.addVariantName(item, "ministrapp:deepstone");
		ModelBakery.addVariantName(item, "ministrapp:coldstone");
		ModelBakery.addVariantName(item, "ministrapp:icestone");
		ModelBakery.addVariantName(item, "ministrapp:glacierrock");
		ModelBakery.addVariantName(item, "ministrapp:deep_coldstone");
		ModelBakery.addVariantName(item, "ministrapp:red_rock");
		ModelBakery.addVariantName(item, "ministrapp:deep_redrock");
		ModelBakery.addVariantName(item, "ministrapp:oceanstone");
		ModelBakery.addVariantName(item, "ministrapp:pressurized_oceanstone");

		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "biome_stone");
		MStoneType[] aenumtype = MStoneType.values();
		int i = aenumtype.length;

		for (int j = 0; j < i; ++j)
		{
			MStoneType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":"
				                                                                            + enumtype
					                                                                              .getUnlocalizedName(),
			                                                                            "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			         .register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}

	@Override
	public float getBlockHardness(World worldIn, BlockPos pos)
	{
		IBlockState state = worldIn.getBlockState(pos);
		if (state == this.getStateFromMeta(MStoneType.DEEPSTONE.getMetadata()) || state == this.getStateFromMeta(
			MStoneType.DEEPCOLDSTONE.getMetadata()) || state == this.getStateFromMeta(
			MStoneType.DEEPREDROCK.getMetadata()) || state == this.getStateFromMeta(
			MStoneType.GLACIERSTONE.getMetadata()) || state == this.getStateFromMeta(
			MStoneType.POCEANSTONE.getMetadata()))
			return 1.5F * this.blockHardness;
		else
			return this.blockHardness;
	}
}
