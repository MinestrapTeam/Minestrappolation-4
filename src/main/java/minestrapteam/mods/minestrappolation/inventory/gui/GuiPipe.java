package minestrapteam.mods.minestrappolation.inventory.gui;

import minestrapteam.mods.minestrappolation.inventory.container.ContainerPipe;
import minestrapteam.mods.minestrappolation.lib.MReference;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityPipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiPipe extends GuiContainer
{
	private static final ResourceLocation	texture	= new ResourceLocation(MReference.MODID, "textures/gui/pipe.png");
	private TileEntityPipe					pipe;
	
	public GuiPipe(EntityPlayer player, TileEntityPipe pipe)
	{
		super(new ContainerPipe(player, pipe));
		this.pipe = pipe;
		this.ySize = 148;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Pipe"), 7, 7, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 7, this.ySize - 110, 4210752);
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
