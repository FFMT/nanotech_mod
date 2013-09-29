package fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

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

	private void adjustRotatePivotViaMeta(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		GL11.glPushMatrix();
		GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float scale)
	{
		TileEntityModernFence te = (TileEntityModernFence)tileentity;
		if(te.render[0])
			this.renderTileEntityAtBlockLamp0((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[1])
			this.renderTileEntityAtBlockLamp1((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[2])
			this.renderTileEntityAtBlockLamp2((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[3])
			this.renderTileEntityAtBlockLamp3((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[4])
			this.renderTileEntityAtBlockLamp4((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[5])
			this.renderTileEntityAtBlockLamp5((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[6])
			this.renderTileEntityAtBlockLamp6((TileEntityModernFence)tileentity, x, y, z, scale);
		if(te.render[7])
			this.renderTileEntityAtBlockLamp7((TileEntityModernFence)tileentity, x, y, z, scale);
		this.renderTileEntityAtBlockLamp((TileEntityModernFence)tileentity, x, y, z, scale);
	}

	public void renderTileEntityAtBlockLamp(TileEntityModernFence tileentity, double x, double y, double z, float scale)
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

	public void renderTileEntityAtBlockLamp0(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockLamp1(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(270F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockLamp2(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(0F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockLamp3(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockLamp4(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(225F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockLamp5(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(135F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockLamp6(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(315F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	public void renderTileEntityAtBlockLamp7(TileEntityModernFence tileentity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	private void adjustLightFixture(World world, int i, int j, int k, Block block)
	{
		Tessellator tess = Tessellator.instance;
		float brightness = block.getBlockBrightness(world, i, j, k);
		int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
		int modulousModifier = skyLight % 65536;
		int divModifier = skyLight / 65536;
		tess.setColorOpaque_F(brightness, brightness, brightness);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)modulousModifier, divModifier);
	}
}