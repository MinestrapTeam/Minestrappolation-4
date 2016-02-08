package minestrapteam.mods.minestrappolation.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import minestrapteam.mods.minestrappolation.inventory.container.ContainerSplitter;
import minestrapteam.mods.minestrappolation.lib.MReference;
import minestrapteam.mods.minestrappolation.tileentity.TileEntitySplitter;

public class GuiSplitter extends GuiContainer
{
	private static final ResourceLocation	texture	= new ResourceLocation(MReference.MODID, "textures/gui/splitter.png");
	
	private TileEntitySplitter				splitter;
	
	public GuiSplitter(EntityPlayer player, TileEntitySplitter splitter)
	{
		super(new ContainerSplitter(player, splitter));
		this.splitter = splitter;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Splitter"), 7, 7, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 7, this.ySize - 92, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTickTime, int mouseX, int mouseY)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(texture);
		int j = (this.width - this.xSize) / 2;
		int k = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(j, k, 0, 0, this.xSize, this.ySize);

		if (this.splitter.isBurning())
		{
			int burn = this.splitter.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(j + 80, k + 49 - burn, 176, 12 - burn, 14, burn + 2);
		}
		
		int update = this.splitter.getProgressScaled(24);
		this.drawTexturedModalRect(j + 55, k + 26, 176, 14, 16, update - 7);
		this.drawTexturedModalRect(j + 110, k + 26, 176, 14, 16, update - 7);
	}
}