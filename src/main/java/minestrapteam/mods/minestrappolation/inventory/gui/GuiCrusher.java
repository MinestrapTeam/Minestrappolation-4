package minestrapteam.mods.minestrappolation.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import minestrapteam.mods.minestrappolation.inventory.container.ContainerCrusher;
import minestrapteam.mods.minestrappolation.lib.MReference;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityCrusher;

public class GuiCrusher extends GuiContainer
{
	private static final ResourceLocation	texture	= new ResourceLocation(MReference.MODID, "textures/gui/crusher.png");
	
	private TileEntityCrusher				furnace;
	
	public GuiCrusher(EntityPlayer player, TileEntityCrusher tileEntityCrusher)
	{
		super(new ContainerCrusher(player, tileEntityCrusher));
		this.furnace = tileEntityCrusher;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Ore Crusher"), 55, 7, 4210752);
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
			this.drawTexturedModalRect(j + 57, k + 48 - burn, 176, 12 - burn, 14, burn + 2);
		}
		
		int update = this.furnace.getProgressScaled(24);
		this.drawTexturedModalRect(j + 79, k + 25, 176, 14, update + 1, 16);
	}
}