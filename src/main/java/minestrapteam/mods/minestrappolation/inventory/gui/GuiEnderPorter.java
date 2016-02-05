package minestrapteam.mods.minestrappolation.inventory.gui;

import org.lwjgl.opengl.GL11;

import minestrapteam.mods.minestrappolation.inventory.container.ContainerEnderPorter;
import minestrapteam.mods.minestrappolation.lib.MBlocks;
import minestrapteam.mods.minestrappolation.lib.MReference;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityEnderPorter;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiEnderPorter extends GuiContainer
{
	public static final ResourceLocation	texture	= new ResourceLocation(MReference.MODID, "textures/gui/enderporter.png");
	
	private TileEntityEnderPorter			porter;
	
	public GuiEnderPorter(EntityPlayer player, TileEntityEnderPorter tileEntityEnderPorter)
	{
		super(new ContainerEnderPorter(player, tileEntityEnderPorter));
		this.porter = tileEntityEnderPorter;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("EnderPorter"), 55, 7, 4210752);
		if(porter.getChipBlock() != MBlocks.enderporter && !porter.hasSelfSufficient())
		{
			this.fontRendererObj.drawString("Wrong Block Type!", 7, 40, 16711680);
		}
		else
		{
			this.fontRendererObj.drawString(porter.getChipPos().getX() + ", " + porter.getChipPos().getY() + ", " + porter.getChipPos().getZ(), 7, 40, 4210752);
		}
		
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
	}
}