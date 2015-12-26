package minestrapteam.mods.minestrappolation.entity;

import minestrapteam.mods.minestrappolation.lib.MReference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderIceBall extends Render
{
	private static final ResourceLocation texture = new ResourceLocation(MReference.MODID, "textures/items/ice_charge.png");
    protected final Item item;
    private final RenderItem render;

    public RenderIceBall(RenderManager renderManagerIn, Item item, RenderItem render)
    {
        super(renderManagerIn);
        this.item = item;
        this.render = render;
    }

    public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        this.bindTexture(getEntityTexture(entity));
        this.render.func_181564_a(this.func_177082_d(entity), ItemCameraTransforms.TransformType.GROUND);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack func_177082_d(Entity entity)
    {
        return new ItemStack(this.item, 1, 0);
    }

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return texture;
	}

}