package minestrapteam.mods.minestrappolation.inventory.gui;

import minestrapteam.mods.minestrappolation.inventory.container.ContainerSorter;
import minestrapteam.mods.minestrappolation.lib.MReference;
import minestrapteam.mods.minestrappolation.tileentity.TileEntitySorter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiSorter extends GuiContainer
{
	private static final ResourceLocation	texture	= new ResourceLocation(MReference.MODID, "textures/gui/sorter.png");
	private TileEntitySorter				sorter;
	
	public GuiSorter(EntityPlayer player, TileEntitySorter sorter)
	{
		super(new ContainerSorter(player, sorter));
		this.sorter = sorter;
		this.ySize = 169;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Filter"), 7, 7, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 7, this.ySize - 93, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		// Bind the image texture of our custom container
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		// Draw the image
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
}
