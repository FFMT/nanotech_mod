package fr.mcnanotech.kevin_68.nanotech_mod.main.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobDancer;

public class ModelDancer extends ModelBase
{
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer rightleg2;
	ModelRenderer leftleg2;
	ModelRenderer rightarm2;
	ModelRenderer leftarm2;
	public float entityTicks;

	public ModelDancer()
	{
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 16, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 48, 0);
		rightarm.addBox(-3F, -2F, -2F, 4, 7, 4);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, -1.308997F, 0F, 0F);
		leftarm = new ModelRenderer(this, 48, 0);
		leftarm.addBox(-1F, -2F, -2F, 4, 7, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, -1.308997F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 0);
		rightleg.addBox(-2F, 0F, -2F, 4, 6, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0.0872665F, 0.1396263F);
		leftleg = new ModelRenderer(this, 0, 0);
		leftleg.addBox(-2F, 0F, -2F, 4, 6, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, -0.0872665F, -0.1396263F);
		rightleg2 = new ModelRenderer(this, 0, 10);
		rightleg2.addBox(-3F, 6F, -2F, 4, 6, 4);
		rightleg2.setRotationPoint(-2F, 12F, 0F);
		rightleg2.setTextureSize(64, 32);
		rightleg2.mirror = true;
		setRotation(rightleg2, 0F, 0.0872665F, 0F);
		leftleg2 = new ModelRenderer(this, 0, 10);
		leftleg2.addBox(-1F, 6F, -2F, 4, 6, 4);
		leftleg2.setRotationPoint(2F, 12F, 0F);
		leftleg2.setTextureSize(64, 32);
		leftleg2.mirror = true;
		setRotation(leftleg2, 0F, -0.0872665F, 0F);
		rightarm2 = new ModelRenderer(this, 48, 11);
		rightarm2.addBox(-5F, 3F, -2F, 4, 7, 4);
		rightarm2.setRotationPoint(-5F, 2F, 0F);
		rightarm2.setTextureSize(64, 32);
		rightarm2.mirror = true;
		setRotation(rightarm2, -1.308997F, -0.5235988F, -0.122173F);
		leftarm2 = new ModelRenderer(this, 48, 11);
		leftarm2.addBox(1F, 2F, -2F, 4, 7, 4);
		leftarm2.setRotationPoint(5F, 2F, 0F);
		leftarm2.setTextureSize(64, 32);
		leftarm2.mirror = true;
		setRotation(leftarm2, -1.308997F, 0.5235988F, 0.122173F);
	}

	public void setLivingAnimations(EntityLivingBase entity, float f6, float f5, float par9)
	{
		if(entity instanceof MobDancer)
		{
			MobDancer dancer = (MobDancer)entity;
			this.entityTicks = (dancer.ticks / 2.978873F);
		}
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)Math.sin(this.entityTicks) * 0.105F, 0.0F, (float)Math.sin(this.entityTicks) * 0.105F);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)Math.sin(this.entityTicks) * -0.015F, 0.0F, 0.0F);
		this.head.render(f5);
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glTranslatef((float)Math.sin(this.entityTicks) * 0.025F, (float)Math.abs(Math.cos(this.entityTicks)) * 0.125F - 0.02F, 0.0F);
		this.leftarm.render(f5);
		this.leftarm2.render(f5);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)Math.sin(this.entityTicks) * 0.025F, (float)Math.abs(Math.cos(this.entityTicks)) * 0.125F - 0.02F, 0.0F);
		GL11.glRotatef((float)Math.sin(this.entityTicks) * 0.025F, 0.0F, 1.0F, 0.0F);
		this.rightarm.render(f5);
		this.rightarm2.render(f5);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)Math.sin(this.entityTicks) * 0.015F, 0.0F, 0.0F);
		this.body.render(f5);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)(Math.sin(this.entityTicks) * -0.025F), (float)(Math.abs(Math.cos(this.entityTicks)) * -0.125F), 0.0F);
		this.rightleg.render(f5);
		this.rightleg2.render(f5);
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)Math.sin(Math.PI - this.entityTicks) * 0.025F, (float)Math.abs(Math.cos(Math.PI - this.entityTicks)) * 0.125F - 0.13F, 0.0F);
		this.leftleg.render(f5);
		this.leftleg2.render(f5);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
		this.leftleg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
		this.rightleg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		this.rightarm.rotateAngleX = (-1.6F + 0.2F * MathHelper.sin(f2 * 0.5F) + 0.4F);
		this.rightarm2.rotateAngleX = this.rightarm.rotateAngleX;
		this.leftarm.rotateAngleX = this.rightarm.rotateAngleX;
		this.leftarm2.rotateAngleX = this.rightarm.rotateAngleX;
		this.rightleg.rotateAngleY = (0.2F * MathHelper.sin(f2 * 0.5F) + 0.4F);
		this.rightleg2.rotateAngleY = (0.2F * MathHelper.sin(f2 * 0.5F) + 0.4F);
		this.leftleg.rotateAngleY = -(0.2F * MathHelper.sin(f2 * 0.5F) + 0.4F);
		this.leftleg2.rotateAngleY = -(0.2F * MathHelper.sin(f2 * 0.5F) + 0.4F);
	}
}