package minestrapteam.minestrappolation.inventory.gui;

import minestrapteam.minestrappolation.inventory.container.ContainerMelter;
import minestrapteam.minestrappolation.lib.MReference;
import minestrapteam.minestrappolation.tileentity.TileEntityMelter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiMelter extends GuiContainer
{
	public static final ResourceLocation	texture	= new ResourceLocation(MReference.MODID, "textures/gui/melter.png");
	
	private TileEntityMelter				melter;
	
	public GuiMelter(EntityPlayer player, TileEntityMelter melter)
	{
		super(new ContainerMelter(player, melter));
		this.melter = melter;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Melter"), 7, 7, 4210752);
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
		
		boolean power = this.melter.isPowered();
		if (this.melter.isBurning())
		{
			int burn = this.melter.getBurnTimeRemainingScaled(12);
			this.drawTexturedModalRect(j + 56, k + 48 - burn, power ? 190 : 176, 12 - burn, 14, burn + 2);
		}
		
		if (power)
		{
			this.drawTexturedModalRect(j + 43, k + 20, 176, 31, 12, 10);
		}
		
		int update = this.melter.getProgressScaled(24);
		this.drawTexturedModalRect(j + 79, k + 34, 176, 14, update + 1, 16);
	}
}