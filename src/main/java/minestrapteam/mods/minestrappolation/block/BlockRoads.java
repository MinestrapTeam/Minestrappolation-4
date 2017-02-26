package minestrapteam.mods.minestrappolation.block;

import java.util.List;

import minestrapteam.mods.minestrappolation.enumtypes.MRoadType;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRoads extends MBlock
{
	
	private static final PropertyEnum	VARIANT	= PropertyEnum.create("type", MRoadType.class);
	
	public BlockRoads(Material materialIn, MapColor mapColorIn)
	{
		super(materialIn, mapColorIn);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
		float f = 0.0625F;
		return new AxisAlignedBB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1 - f, pos.getZ() + 1);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
	{
		double speed = MRoadType.byMetadata(this.getMetaFromState(state)).getSpeed();
		entity.motionX *= speed;
		entity.motionZ *= speed;
		if(state.getValue(VARIANT) == MRoadType.SOUL)
		{
			entity.setFire(20);
		}
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { VARIANT });
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((MRoadType) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		MRoadType[] aenumtype = MRoadType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MRoadType enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
		
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, MRoadType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((MRoadType) state.getValue(VARIANT)).getMetadata();
	}
	
	public static void inventoryRender()
	{
		Item itemBlockBrickVariants = GameRegistry.findItem(MReference.MODID, "roads");
		
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:cobble_road");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:red_sand_road");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:gravel_road");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:permafrost_road");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:sand_road");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:nether_road");
		ModelBakery.addVariantName(itemBlockBrickVariants, "ministrapp:soul_road");
		
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "roads");
		MRoadType[] aenumtype = MRoadType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MRoadType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + enumtype.getUnlocalizedName() + "_road", "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
	
}
