package minestrapteam.mods.minestrappolation.block;

import java.util.List;

import minestrapteam.mods.minestrappolation.Minestrappolation;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockSand.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockVirtianSoil extends BlockDirt
{
	public BlockVirtianSoil(SoundType sound)
	{
		this.blockSoundType=sound;
	}
	
	public MapColor getMapColor(IBlockState state)
    {
        if (state.getValue(VARIANT).getMetadata() == 2)
        	return MapColor.BLACK;
        else
        	return MapColor.PINK;
    }
	
	public static void inventoryRender()
	{
		Item item = GameRegistry.findItem(MReference.MODID, "virtian_soil");
		
		ModelBakery.addVariantName(item, "ministrapp:virtian_soil_dirt");
		ModelBakery.addVariantName(item, "ministrapp:virtian_soil_coarse_dirt");
		ModelBakery.addVariantName(item, "ministrapp:virtian_soil_podzol");
		
		Item itemBlockVariants = GameRegistry.findItem(MReference.MODID, "virtian_soil");
		DirtType[] aenumtype = BlockDirt.DirtType.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			BlockDirt.DirtType enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(MReference.MODID + ":" + "virtian_soil_" + enumtype.getName(), "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(playerIn.getHeldItem() != null)
        {
        	if(playerIn.getHeldItem().getItem() instanceof ItemHoe && state.getValue(VARIANT).getMetadata() == 1)
        	{
        		if(playerIn.getHeldItem().getItemDamage() < playerIn.getHeldItem().getMaxDamage())
        			playerIn.getHeldItem().damageItem(1, playerIn);
        		else
        			playerIn.destroyCurrentEquippedItem();
        		worldIn.setBlockState(pos, MBlocks.virtian_soil.getDefaultState());
        		worldIn.playSoundEffect((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), MBlocks.virtian_soil.stepSound.getStepSound(), (MBlocks.virtian_soil.stepSound.getVolume() + 1.0F) / 2.0F, MBlocks.virtian_soil.stepSound.getFrequency() * 0.8F);
        		return true;
        	}
        }
		return false;
    }
}