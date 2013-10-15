package fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.city.client.model.blocks.ModelBlockModernFence;
import fr.mcnanotech.kevin_68.nanotech_mod.city.client.model.blocks.ModelBlockModernFence2;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityModernFence;

public class TileEntityModernFenceRender extends TileEntitySpecialRenderer
{
	private final ModelBlockModernFence model;
	private final ModelBlockModernFence2 model2;
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod_city", "textures/blocks/BlockModernFence.png");
	protected static final ResourceLocation texture2 = new ResourceLocation("nanotech_mod_city", "textures/blocks/BlockModernFence2.png");

	public TileEntityModernFenceRender()
	{
		this.model = new ModelBlockModernFence();
		this.model2 = new ModelBlockModernFence2();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float scale)
	{
		TileEntityModernFence te = (TileEntityModernFence)tileentity;
		if(te.render[0])
			this.renderTileEntityAtBlockModernFence0((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[1])
			this.renderTileEntityAtBlockModernFence1((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[2])
			this.renderTileEntityAtBlockModernFence2((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[3])
			this.renderTileEntityAtBlockModernFence3((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[4])
			this.renderTileEntityAtBlockModernFence4((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[5])
			this.renderTileEntityAtBlockModernFence5((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[6])
			this.renderTileEntityAtBlockModernFence6((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[7])
			this.renderTileEntityAtBlockModernFence7((TileEntityModernFence)tileentity, x, y, z, scale);
		this.renderTileEntityAtBlockModernFence((TileEntityModernFence)tileentity, x, y, z, scale);
	}

	public void renderTileEntityAtBlockModernFence(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture2);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);
		this.model2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockModernFence0(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockModernFence1(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockModernFence2(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockModernFence3(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockModernFence4(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(225F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockModernFence5(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(135F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockModernFence6(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(315F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockModernFence7(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}