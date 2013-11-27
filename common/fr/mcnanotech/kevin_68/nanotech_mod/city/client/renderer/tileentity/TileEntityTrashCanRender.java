package fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.city.client.model.blocks.ModelBlockTrashCan;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTrashCan;

public class TileEntityTrashCanRender extends TileEntitySpecialRenderer
{
	public static TileEntityTrashCanRender INSTANCE = new TileEntityTrashCanRender();
	private final ModelBlockTrashCan model = new ModelBlockTrashCan();
	private static final ResourceLocation texture = new ResourceLocation("nanotech_mod_city", "textures/blocks/trashcan.png");

	public TileEntityTrashCanRender()
	{
		setTileEntityRenderer(TileEntityRenderer.instance);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float scale)
	{
		this.renderTileEntityTrashCanAt((TileEntityTrashCan)tileentity, x, y, z, scale);
	}

	public void renderTileEntityTrashCanAt(TileEntityTrashCan tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glScalef(0.8F, 0.8F, 0.8F);
		GL11.glTranslatef(0.0F, 0.38F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}