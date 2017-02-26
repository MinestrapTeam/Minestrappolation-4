package minestrapteam.mods.minestrappolation.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import minestrapteam.mods.minestrappolation.inventory.container.ContainerSawmill;
import minestrapteam.mods.minestrappolation.tileentity.TileEntitySawMill;

@SideOnly(Side.CLIENT)
public class GuiSawmill extends GuiContainer
{
	public static ResourceLocation	texture	= new ResourceLocation("textures/gui/container/crafting_table.png");
	private TileEntitySawMill		sawmill;
	
	public GuiSawmill(EntityPlayer inventory, TileEntitySawMill sawmill)
	{
		super(new ContainerSawmill(inventory, sawmill));
		this.sawmill = sawmill;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Carpenter's Bench"), 42, 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 94, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}