package minestrapteam.mods.minestrappolation.block;

import java.util.List;

import com.google.common.base.Predicate;

import minestrapteam.mods.minestrappolation.enumtypes.MPumpkinType;
import minestrapteam.mods.minestrappolation.enumtypes.MStoneType;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
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
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCarvedPumpkin extends net.minecraft.block.BlockDirectional
{
    private BlockPattern snowmanBasePattern;
    private BlockPattern snowmanPattern;
    private BlockPattern golemBasePattern;
    private BlockPattern golemPattern;
    
    public String type;

    private static final PropertyEnum	VARIANT	= PropertyEnum.create("variant", MPumpkinType.class);

    public BlockCarvedPumpkin(String type)
    {
        super(Material.gourd);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, MPumpkinType.SIMPLE).withProperty(FACING, EnumFacing.NORTH));
        this.setTickRandomly(true);
        this.setUnlocalizedName("pumpkin_minestrapp_" + type);
        this.type = type;
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

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
        this.trySpawnGolem(worldIn, pos);
    }

    public boolean canDispenserPlace(World worldIn, BlockPos pos)
    {
        return this.getSnowmanBasePattern().match(worldIn, pos) != null || this.getGolemBasePattern().match(worldIn, pos) != null;
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
            entitysnowman.setLocationAndAngles((double)blockpos2.getX() + 0.5D, (double)blockpos2.getY() + 0.05D, (double)blockpos2.getZ() + 0.5D, 0.0F, 0.0F);
            worldIn.spawnEntityInWorld(entitysnowman);

            for (j = 0; j < 120; ++j)
            {
                worldIn.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, (double)blockpos2.getX() + worldIn.rand.nextDouble(), (double)blockpos2.getY() + worldIn.rand.nextDouble() * 2.5D, (double)blockpos2.getZ() + worldIn.rand.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
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
                    worldIn.setBlockState(patternhelper.translateOffset(i, k, 0).getPos(), Blocks.air.getDefaultState(), 2);
                }
            }

            BlockPos blockpos1 = patternhelper.translateOffset(1, 2, 0).getPos();
            EntityIronGolem entityirongolem = new EntityIronGolem(worldIn);
            entityirongolem.setPlayerCreated(true);
            entityirongolem.setLocationAndAngles((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.05D, (double)blockpos1.getZ() + 0.5D, 0.0F, 0.0F);
            worldIn.spawnEntityInWorld(entityirongolem);

            for (j = 0; j < 120; ++j)
            {
                worldIn.spawnParticle(EnumParticleTypes.SNOWBALL, (double)blockpos1.getX() + worldIn.rand.nextDouble(), (double)blockpos1.getY() + worldIn.rand.nextDouble() * 3.9D, (double)blockpos1.getZ() + worldIn.rand.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
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

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && World.doesBlockHaveSolidTopSurface(worldIn, pos.down());
    }

    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
    	if(placer.getHeldItem().getMetadata() == 0)
    		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(VARIANT, MPumpkinType.SIMPLE);
    	else if(placer.getHeldItem().getMetadata() == 1)
    		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(VARIANT, MPumpkinType.AVERAGE);
    	else
    		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(VARIANT, MPumpkinType.COMPLEX);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
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
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i = b0 | ((MPumpkinType)state.getValue(VARIANT)).getMetadata();

        switch (((EnumFacing)state.getValue(FACING)).getHorizontalIndex())
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

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT, FACING});
    }
    
    protected ItemStack createStackedBlock(IBlockState state)
    {
    	return new ItemStack(Item.getItemFromBlock(this), 1, ((MPumpkinType)state.getValue(VARIANT)).getMetadata());
    }
    
    public int damageDropped(IBlockState state)
    {
        return ((MPumpkinType)state.getValue(VARIANT)).getMetadata();
    }

    protected BlockPattern getSnowmanBasePattern()
    {
        if (this.snowmanBasePattern == null)
        {
            this.snowmanBasePattern = FactoryBlockPattern.start().aisle(new String[] {" ", "#", "#"}).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.snow))).build();
        }

        return this.snowmanBasePattern;
    }

    protected BlockPattern getSnowmanPattern()
    {
        if (this.snowmanPattern == null)
        {
            this.snowmanPattern = FactoryBlockPattern.start().aisle(new String[] {"^", "#", "#"}).where('^', BlockWorldState.hasState(BlockStateHelper.forBlock(MBlocks.pumpkin_carved))).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.snow))).build();
        }

        return this.snowmanPattern;
    }

    protected BlockPattern getGolemBasePattern()
    {
        if (this.golemBasePattern == null)
        {
            this.golemBasePattern = FactoryBlockPattern.start().aisle(new String[] {"~ ~", "###", "~#~"}).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.iron_block))).where('~', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.air))).build();
        }

        return this.golemBasePattern;
    }

    protected BlockPattern getGolemPattern()
    {
        if (this.golemPattern == null)
        {
            this.golemPattern = FactoryBlockPattern.start().aisle(new String[] {"~^~", "###", "~#~"}).where('^', BlockWorldState.hasState(BlockStateHelper.forBlock(MBlocks.pumpkin_carved))).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.iron_block))).where('~', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.air))).build();
        }

        return this.golemPattern;
    }
    
   
    public static void inventoryRender(String type)
	{
		Item itemBlockpVariants = GameRegistry.findItem(MReference.MODID, "pumpkin_minestrapp_" + type);
		
		ModelBakery.addVariantName(itemBlockpVariants, "ministrapp:pumpkin_simple_carved_" + type);
		ModelBakery.addVariantName(itemBlockpVariants, "ministrapp:pumpkin_average_carved_" + type);
		ModelBakery.addVariantName(itemBlockpVariants, "ministrapp:pumpkin_complex_carved_" + type);
		
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "pumpkin_minestrapp_" + type);
		MPumpkinType[] aenumtype = MPumpkinType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			MPumpkinType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + enumtype.getUnlocalizedName() + "_carved", "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
}