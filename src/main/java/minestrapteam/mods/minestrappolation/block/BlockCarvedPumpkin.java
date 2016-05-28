package minestrapteam.mods.minestrappolation.block;

import minestrapteam.mods.minestrappolation.enumtypes.MPumpkinType;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MItems;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

public class BlockCarvedPumpkin extends net.minecraft.block.BlockDirectional
{
	private BlockPattern snowmanBasePattern;
	private BlockPattern snowmanPattern;
	private BlockPattern golemBasePattern;
	private BlockPattern golemPattern;

	public String type;

	private static final PropertyEnum VARIANT = PropertyEnum.create("variant", MPumpkinType.class);

	public Block changeTo;

	public BlockCarvedPumpkin(String type, Block changeTo)
	{
		super(Material.gourd);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, MPumpkinType.SIMPLE)
		                                    .withProperty(FACING, EnumFacing.NORTH));
		this.setTickRandomly(true);
		this.setUnlocalizedName("pumpkin_minestrapp_" + type);
		this.type = type;
		this.changeTo = changeTo;
	}

	public void changeResultBlock(Block block)
	{
		this.changeTo = block;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		MPumpkinType[] aenumtype = MPumpkinType.values();
		int i = aenumtype.length;

		for (int j = 0; j < i; ++j)
		{
			MPumpkinType enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		super.onBlockAdded(worldIn, pos, state);
		this.trySpawnGolem(worldIn, pos);
	}

	public boolean canDispenserPlace(World worldIn, BlockPos pos)
	{
		return this.getSnowmanBasePattern().match(worldIn, pos) != null
			       || this.getGolemBasePattern().match(worldIn, pos) != null;
	}

	private void trySpawnGolem(World worldIn, BlockPos pos)
	{
		BlockPattern.PatternHelper patternhelper;
		int i;
		int j;

		if ((patternhelper = this.getSnowmanPattern().match(worldIn, pos)) != null)
		{
			for (i = 0; i < this.getSnowmanPattern().getThumbLength(); ++i)
			{
				BlockWorldState blockworldstate = patternhelper.translateOffset(0, i, 0);
				worldIn.setBlockState(blockworldstate.getPos(), Blocks.air.getDefaultState(), 2);
			}

			EntitySnowman entitysnowman = new EntitySnowman(worldIn);
			BlockPos blockpos2 = patternhelper.translateOffset(0, 2, 0).getPos();
			entitysnowman.setLocationAndAngles((double) blockpos2.getX() + 0.5D, (double) blockpos2.getY() + 0.05D,
			                                   (double) blockpos2.getZ() + 0.5D, 0.0F, 0.0F);
			worldIn.spawnEntityInWorld(entitysnowman);

			for (j = 0; j < 120; ++j)
			{
				worldIn
					.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, (double) blockpos2.getX() + worldIn.rand.nextDouble(),
					               (double) blockpos2.getY() + worldIn.rand.nextDouble() * 2.5D,
					               (double) blockpos2.getZ() + worldIn.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
			}

			for (j = 0; j < this.getSnowmanPattern().getThumbLength(); ++j)
			{
				BlockWorldState blockworldstate1 = patternhelper.translateOffset(0, j, 0);
				worldIn.notifyNeighborsRespectDebug(blockworldstate1.getPos(), Blocks.air);
			}
		}
		else if ((patternhelper = this.getGolemPattern().match(worldIn, pos)) != null)
		{
			for (i = 0; i < this.getGolemPattern().getPalmLength(); ++i)
			{
				for (int k = 0; k < this.getGolemPattern().getThumbLength(); ++k)
				{
					worldIn.setBlockState(patternhelper.translateOffset(i, k, 0).getPos(), Blocks.air.getDefaultState(),
					                      2);
				}
			}

			BlockPos blockpos1 = patternhelper.translateOffset(1, 2, 0).getPos();
			EntityIronGolem entityirongolem = new EntityIronGolem(worldIn);
			entityirongolem.setPlayerCreated(true);
			entityirongolem.setLocationAndAngles((double) blockpos1.getX() + 0.5D, (double) blockpos1.getY() + 0.05D,
			                                     (double) blockpos1.getZ() + 0.5D, 0.0F, 0.0F);
			worldIn.spawnEntityInWorld(entityirongolem);

			for (j = 0; j < 120; ++j)
			{
				worldIn.spawnParticle(EnumParticleTypes.SNOWBALL, (double) blockpos1.getX() + worldIn.rand.nextDouble(),
				                      (double) blockpos1.getY() + worldIn.rand.nextDouble() * 3.9D,
				                      (double) blockpos1.getZ() + worldIn.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
			}

			for (j = 0; j < this.getGolemPattern().getPalmLength(); ++j)
			{
				for (int l = 0; l < this.getGolemPattern().getThumbLength(); ++l)
				{
					BlockWorldState blockworldstate2 = patternhelper.translateOffset(j, l, 0);
					worldIn.notifyNeighborsRespectDebug(blockworldstate2.getPos(), Blocks.air);
				}
			}
		}
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && World.doesBlockHaveSolidTopSurface(
			worldIn, pos.down());
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		if (placer.getHeldItem().getMetadata() == 0)
			return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite())
			           .withProperty(VARIANT, MPumpkinType.SIMPLE);
		else if (placer.getHeldItem().getMetadata() == 1)
			return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite())
			           .withProperty(VARIANT, MPumpkinType.AVERAGE);
		else
			return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite())
			           .withProperty(VARIANT, MPumpkinType.COMPLEX);
	}

	/**
	 * Convert the given metadata into a BlockStateContainer for this Block
	 */
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState iblockstate = this.getDefaultState().withProperty(VARIANT, MPumpkinType.byMetadata((meta & 3) % 4));

		switch (meta & 12)
		{
		case 0:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
			break;
		case 4:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
			break;
		case 8:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
			break;
		default:
			iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
		}

		return iblockstate;
	}

	/**
	 * Convert the BlockStateContainer into the correct metadata value
	 */
	@Override
	public int getMetaFromState(IBlockState state)
	{
		byte b0 = 0;
		int i = b0 | ((MPumpkinType) state.getValue(VARIANT)).getMetadata();

		switch (state.getValue(FACING).getHorizontalIndex())
		{
		case 1:
			i |= 4;
			break;
		case 2:
			i |= 8;
			break;
		case 3:
			i |= 12;
		}

		return i;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, VARIANT, FACING);
	}

	@Override
	protected ItemStack createStackedBlock(IBlockState state)
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((MPumpkinType) state.getValue(VARIANT)).getMetadata());
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return ((MPumpkinType) state.getValue(VARIANT)).getMetadata();
	}

	protected BlockPattern getSnowmanBasePattern()
	{
		if (this.snowmanBasePattern == null)
		{
			this.snowmanBasePattern = FactoryBlockPattern.start().aisle(new String[] { " ", "#", "#" }).where('#',
			                                                                                                  BlockWorldState
				                                                                                                  .hasState(
					                                                                                                  BlockStateHelper
						                                                                                                  .forBlock(
							                                                                                                  Blocks.snow)))
			                                             .build();
		}

		return this.snowmanBasePattern;
	}

	protected BlockPattern getSnowmanPattern()
	{
		if (this.snowmanPattern == null)
		{
			this.snowmanPattern = FactoryBlockPattern.start().aisle(new String[] { "^", "#", "#" }).where('^',
			                                                                                              BlockWorldState
				                                                                                              .hasState(
					                                                                                              BlockStateHelper
						                                                                                              .forBlock(
							                                                                                              this)))
			                                         .where('#', BlockWorldState
				                                                     .hasState(BlockStateHelper.forBlock(Blocks.snow)))
			                                         .build();
		}

		return this.snowmanPattern;
	}

	protected BlockPattern getGolemBasePattern()
	{
		if (this.golemBasePattern == null)
		{
			this.golemBasePattern = FactoryBlockPattern.start().aisle(new String[] { "~ ~", "###", "~#~" }).where('#',
			                                                                                                      BlockWorldState
				                                                                                                      .hasState(
					                                                                                                      BlockStateHelper
						                                                                                                      .forBlock(
							                                                                                                      Blocks.iron_block)))
			                                           .where('~', BlockWorldState
				                                                       .hasState(BlockStateHelper.forBlock(Blocks.air)))
			                                           .build();
		}

		return this.golemBasePattern;
	}

	protected BlockPattern getGolemPattern()
	{
		if (this.golemPattern == null)
		{
			this.golemPattern = FactoryBlockPattern.start().aisle(new String[] { "~^~", "###", "~#~" }).where('^',
			                                                                                                  BlockWorldState
				                                                                                                  .hasState(
					                                                                                                  BlockStateHelper
						                                                                                                  .forBlock(
							                                                                                                  this)))
			                                       .where('#', BlockWorldState.hasState(
				                                       BlockStateHelper.forBlock(Blocks.iron_block))).where('~',
			                                                                                                BlockWorldState
				                                                                                                .hasState(
					                                                                                                BlockStateHelper
						                                                                                                .forBlock(
							                                                                                                Blocks.air)))
			                                       .build();
		}

		return this.golemPattern;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (this.getUnlocalizedName().contains("lit"))
		{
			double d0 = (double) pos.getX() + 0.5D;
			double d1 = (double) pos.getY() + 0.5D;
			double d2 = (double) pos.getZ() + 0.5D;
			double d3 = 0.22D;
			double d4 = 0.27D;

			worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

	public static void inventoryRender(String type)
	{
		Item itemBlockpVariants = GameRegistry.findItem(MReference.MODID, "pumpkin_minestrapp_" + type);

		ModelBakery.addVariantName(itemBlockpVariants, "ministrapp:simple_carved_" + type);
		ModelBakery.addVariantName(itemBlockpVariants, "ministrapp:average_carved_" + type);
		ModelBakery.addVariantName(itemBlockpVariants, "ministrapp:complex_carved_" + type);

		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "pumpkin_minestrapp_" + type);
		MPumpkinType[] aenumtype = MPumpkinType.values();
		int i = aenumtype.length;

		for (int j = 0; j < i; ++j)
		{
			MPumpkinType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":"
				                                                                            + enumtype
					                                                                              .getUnlocalizedName()
				                                                                            + "_carved_" + type,
			                                                                            "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
			         .register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
		{
			return true;
		}
		if (playerIn.getCurrentEquippedItem() != null && playerIn.getCurrentEquippedItem().getItem() == Items.shears)
		{
			if ((playerIn.getCurrentEquippedItem().getItemDamage() < playerIn.getCurrentEquippedItem().getMaxDamage()))
			{
				playerIn.getCurrentEquippedItem().damageItem(1, playerIn);
			}
			else
			{
				playerIn.getCurrentEquippedItem().stackSize--;
			}
			if (worldIn.getBlockState(pos).getValue(VARIANT) == MPumpkinType.SIMPLE)
				worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING,
				                                                               this.getActualState(
					                                                                                      state,
					                                                                                      worldIn, pos)
				                                                                                          .getValue(
					                                                                                          FACING))
				                               .withProperty(VARIANT, MPumpkinType.AVERAGE));
			else if (worldIn.getBlockState(pos).getValue(VARIANT) == MPumpkinType.AVERAGE)
				worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING,
				                                                               this.getActualState(
					                                                                                      state,
					                                                                                      worldIn, pos)
				                                                                                          .getValue(
					                                                                                          FACING))
				                               .withProperty(VARIANT, MPumpkinType.COMPLEX));
			else if (worldIn.getBlockState(pos).getValue(VARIANT) == MPumpkinType.COMPLEX)
			{
				if (this.getUnlocalizedName().contains("lit"))
					worldIn.setBlockState(pos, MBlocks.pumpkin_smashed_lit.getDefaultState()
					                                                      .withProperty(FACING,
					                                                                                            this.getActualState(
						                                                                                            state,
						                                                                                            worldIn,
						                                                                                            pos)
					                                                                                                .getValue(
						                                                                                                FACING)));
				else
					worldIn.setBlockState(pos, MBlocks.pumpkin_smashed.getDefaultState()
					                                                  .withProperty(FACING,
					                                                                                        this.getActualState(
						                                                                                        state,
						                                                                                        worldIn,
						                                                                                        pos)
					                                                                                            .getValue(
						                                                                                            FACING)));
			}
			return true;
		}
		else if (this.getUnlocalizedName().contains("lit") == false && (playerIn.getCurrentEquippedItem() != null)
			         && (playerIn.getCurrentEquippedItem().getItem() == Items.flint_and_steel
				             || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_axe
				             || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_hoe
				             || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_pickaxe
				             || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_shovel
				             || playerIn.getCurrentEquippedItem().getItem() == MItems.fire_sword
				             || playerIn.getCurrentEquippedItem().getItem() == Items.fire_charge))
		{
			if ((playerIn.getCurrentEquippedItem().getItemDamage() < playerIn.getCurrentEquippedItem().getMaxDamage()))
			{
				playerIn.getCurrentEquippedItem().damageItem(1, playerIn);
			}
			else
			{
				playerIn.getCurrentEquippedItem().stackSize--;
			}
			worldIn.setBlockState(pos, this.changeTo.getDefaultState().withProperty(FACING,
			                                                                        this.getActualState(
				                                                                                               state,
				                                                                                               worldIn,
				                                                                                               pos)
			                                                                                                   .getValue(
				                                                                                                   FACING))
			                                        .withProperty(VARIANT,
			                                                                             this.getActualState(state,
			                                                                                                 worldIn,
			                                                                                                 pos)
			                                                                                 .getValue(VARIANT)));
			return true;
		}
		else if (this.getUnlocalizedName().contains("lit") == true && (playerIn.getCurrentEquippedItem() != null)
			         && (playerIn.getCurrentEquippedItem().getItem() == Items.potionitem
				             || playerIn.getCurrentEquippedItem().getItem() == Items.water_bucket
				             || playerIn.getCurrentEquippedItem().getItem() == Items.snowball
				             || playerIn.getCurrentEquippedItem().getItem() == MItems.crushed_ice
				             || playerIn.getCurrentEquippedItem().getItem() == MItems.ice_charge))
		{
			if ((playerIn.getCurrentEquippedItem().getItem() == Items.potionitem))
			{
				playerIn.setCurrentItemOrArmor(0, new ItemStack(Items.glass_bottle, 1));
			}
			else if ((playerIn.getCurrentEquippedItem().getItem() == Items.water_bucket))
			{
				playerIn.setCurrentItemOrArmor(0, new ItemStack(Items.bucket, 1));
			}
			else
			{
				playerIn.getCurrentEquippedItem().stackSize--;
			}
			worldIn.setBlockState(pos, this.changeTo.getDefaultState().withProperty(FACING,
			                                                                        this.getActualState(
				                                                                                               state,
				                                                                                               worldIn,
				                                                                                               pos)
			                                                                                                   .getValue(
				                                                                                                   FACING))
			                                        .withProperty(VARIANT,
			                                                                             this.getActualState(state,
			                                                                                                 worldIn,
			                                                                                                 pos)
			                                                                                 .getValue(VARIANT)));
			return true;
		}
		return false;
	}
}
