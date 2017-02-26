package minestrapteam.mods.minestrappolation.lib;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MFluid
{
	public static Fluid	MAGMA;
	
	public static void init()
	{
		MAGMA = new Fluid("magma", getResource("magma_still"), getResource("magma_flowing")).setLuminosity(10).setViscosity(6500).setDensity(4000).setTemperature(1500);
		FluidRegistry.registerFluid(MAGMA);
	}
	
	public static void load()
	{
		FluidContainerRegistry.registerFluidContainer(MAGMA, new ItemStack(MBlocks.magmaBucket), FluidContainerRegistry.EMPTY_BUCKET);
	}
	
	public static ResourceLocation getResource(String name)
	{
		return new ResourceLocation(MReference.MODID, "fluid/" + name);
	}
	
	@SideOnly(Side.CLIENT)
	public static void buildRenderFor(Block block, String name)
	{
		final ModelResourceLocation fluidLocation = new ModelResourceLocation(MReference.MODID + ":" + name, "fluid");
		Item fluid = Item.getItemFromBlock(block);
        ModelBakery.addVariantName(fluid);
        ModelLoader.setCustomMeshDefinition(fluid, new ItemMeshDefinition()
        {
             public ModelResourceLocation getModelLocation(ItemStack stack)
             {
                 return fluidLocation;
             }
        });
        ModelLoader.setCustomStateMapper(block, new StateMapperBase()
        {
             protected ModelResourceLocation getModelResourceLocation(IBlockState state)
             {
                 return fluidLocation;
             }
        });
	}
}