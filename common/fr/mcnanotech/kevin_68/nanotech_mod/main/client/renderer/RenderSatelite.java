package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSatelite;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntitySatelite;

@SideOnly(Side.CLIENT)
public class RenderSatelite extends Render
{
	private static final ResourceLocation SateliteTextures = new ResourceLocation("nanotech_mod", "textures/entity/satelite.png");

	protected ModelBase model;

	public RenderSatelite()
	{
		this.shadowSize = 0.5F;
		this.model = new ModelSatelite();
	}

	public void renderSatelite(EntitySatelite entitySatelite, double par2, double par4, double par6, float par8, float par9)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)par2, (float)par4, (float)par6);
		GL11.glRotatef(180.0F - par8, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(entitySatelite.prevRotationYaw + (entitySatelite.rotationYaw - entitySatelite.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(entitySatelite.prevRotationPitch + (entitySatelite.rotationPitch - entitySatelite.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
		float f4 = 5.75F;
		GL11.glScalef(f4, f4, f4);
		GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
		this.bindEntityTexture(entitySatelite);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		this.model.render(entitySatelite, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	protected ResourceLocation getTextures(EntitySatelite entitySatelite)
	{
		return SateliteTextures;
	}

	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getTextures((EntitySatelite)entity);
	}

	public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderSatelite((EntitySatelite)entity, par2, par4, par6, par8, par9);
	}
}
