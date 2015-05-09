package minestrapteam.minestrappolation.inventory.gui;

import minestrapteam.minestrappolation.inventory.container.ContainerAlloy;
import minestrapteam.minestrappolation.inventory.container.ContainerMelter;
import minestrapteam.minestrappolation.lib.MReference;
import minestrapteam.minestrappolation.tileentity.TileEntityAlloy;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiAlloy extends GuiContainer
{
	private static final ResourceLocation texture = new ResourceLocation(MReference.MODID, "textures/gui/alloy_furnace.png");
	
	private TileEntityAlloy		furnace;
	
	public GuiAlloy(EntityPlayer player, TileEntityAlloy furnace)
	{
		super(new ContainerAlloy(player, furnace));
		this.furnace = furnace;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Alloy Furnace"), 7, 7, 4210752);
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
	
		if (this.furnace.isBurning())
		{
			int burn = this.furnace.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(j + 47, k + 48 - burn, 176, 12 - burn, 14, burn + 2);
		}
		
		int update = this.furnace.getProgressScaled(24);
		this.drawTexturedModalRect(j + 79, k + 34, 176, 14, update + 1, 16);
	}
}