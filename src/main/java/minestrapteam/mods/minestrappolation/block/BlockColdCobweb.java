package minestrapteam.mods.minestrappolation.block;

import java.util.Random;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockColdCobweb extends MBlock
{
	public BlockColdCobweb()
	{
		super(Material.WEB, MapColor.AIR);
        this.setCreativeTab(Minestrappolation.tabMDecor);
	}
	
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.setInWeb();
        if(entityIn instanceof EntityLivingBase)
        {
        	((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("slowness"), 20 * 10, 2, false, false));
        	((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("mining_fatigue"), 20 * 10, 2, false, false));
        }
    }

	@Override
    public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	

    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return null;
    }

    public boolean isFullCube()
    {
        return false;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Items.STRING;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
	public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }
}
