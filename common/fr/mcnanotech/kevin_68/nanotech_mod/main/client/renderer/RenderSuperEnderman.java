package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperEnderman;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperEnderman;

public class RenderSuperEnderman extends RenderLiving
{
	private ModelSuperEnderman model;
	private Random rnd = new Random();
	protected static final ResourceLocation texture = new ResourceLocation("textures/entity/enderman/enderman.png");

	public RenderSuperEnderman()
	{
		super(new ModelSuperEnderman(), 0.5F);
		this.model = (ModelSuperEnderman)super.mainModel;
		this.setRenderPassModel(this.model);
	}

	protected ResourceLocation getEndermanTexture(MobSuperEnderman entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEndermanTexture((MobSuperEnderman)entity);
	}

	public void renderMob_superenderman(MobSuperEnderman mob, double par2, double par4, double par6, float par8, float par9)
	{
		this.model.isCarrying = mob.getCarried() > 0;
		this.model.isAttacking = mob.isScreaming();

		if(mob.isScreaming())
		{
			double var10 = 0.02D;
			par2 += this.rnd.nextGaussian() * var10;
			par6 += this.rnd.nextGaussian() * var10;
		}

		super.doRenderLiving(mob, par2, par4, par6, par8, par9);
	}

	protected void renderCarrying(MobSuperEnderman mob, float par2)
	{
		super.renderEquippedItems(mob, par2);

		if(mob.getCarried() > 0)
		{
			GL11.glEnable(GL12.GL_RESCALE_NORMAL);
			GL11.glPushMatrix();
			float f1 = 0.5F;
			GL11.glTranslatef(0.0F, 0.6875F, -0.75F);
			f1 *= 1.0F;
			GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			GL11.glScalef(-f1, -f1, f1);
			int i = mob.getBrightnessForRender(par2);
			int j = i % 65536;
			int k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.bindTexture(TextureMap.locationBlocksTexture);
			this.renderBlocks.renderBlockAsItem(Block.blocksList[mob.getCarried()], mob.getCarryingData(), 1.0F);
			GL11.glPopMatrix();
			GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		}
	}

	protected int renderEyes(MobSuperEnderman mob, int par2, float par3)
	{
		if(par2 != 0)
		{
			return -1;
		}
		else
		{
			this.bindTexture(new ResourceLocation("textures/entity/enderman/enderman_eyes.png"));
			float var4 = 1.0F;
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glDisable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
			GL11.glDisable(GL11.GL_LIGHTING);
			char var5 = 61680;
			int var6 = var5 % 65536;
			int var7 = var5 / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)var6 / 1.0F, (float)var7 / 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, var4);
			return 1;
		}
	}

	protected int shouldRenderPass(EntityLiving entityliving, int par2, float par3)
	{
		return this.renderEyes((MobSuperEnderman)entityliving, par2, par3);
	}

	protected void renderEquippedItems(EntityLiving entityliving, float par2)
	{
		this.renderCarrying((MobSuperEnderman)entityliving, par2);
	}

	public void doRenderLiving(EntityLiving entityliving, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderMob_superenderman((MobSuperEnderman)entityliving, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderMob_superenderman((MobSuperEnderman)entity, par2, par4, par6, par8, par9);
	}
}
