package minestrapteam.mods.minestrappolation.inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import minestrapteam.mods.minestrappolation.inventory.container.ContainerStoneCutter;
import minestrapteam.mods.minestrappolation.lib.MReference;
import minestrapteam.mods.minestrappolation.tileentity.TileEntityStoneCutter;

@SideOnly(Side.CLIENT)
public class GuiStoneCutter extends GuiContainer
{
	public static final ResourceLocation	texture	= new ResourceLocation(MReference.MODID, "textures/gui/stonecutter.png");
	private TileEntityStoneCutter			stonecutter;
	
	public GuiStoneCutter(EntityPlayer player, TileEntityStoneCutter stonecutter)
	{
		super(new ContainerStoneCutter(player, stonecutter));
		this.stonecutter = stonecutter;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Stone Cutter"), 42, 6, 4210752);
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