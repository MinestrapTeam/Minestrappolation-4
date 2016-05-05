package minestrapteam.mods.minestrappolation.entity;

import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMudBall extends Render<EntityMudBall>
{
	private static final ResourceLocation texture = new ResourceLocation(MReference.MODID,
	                                                                     "textures/items/mud_Ball.png");
	protected final Item       item;
	private final   RenderItem render;

	public RenderMudBall(RenderManager renderManagerIn, Item item, RenderItem render)
	{
		super(renderManagerIn);
		this.item = item;
		this.render = render;
	}

	@Override
	public void doRender(EntityMudBall entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(0.5F, 0.5F, 0.5F);
		GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		this.bindTexture(this.getEntityTexture(entity));
		this.render.renderItem(this.getDisplayItem(), ItemCameraTransforms.TransformType.GROUND);
		GlStateManager.disableRescaleNormal();
		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	public ItemStack getDisplayItem()
	{
		return new ItemStack(this.item, 1, 0);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMudBall entity)
	{
		return texture;
	}
}
