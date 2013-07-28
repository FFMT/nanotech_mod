package fr.mcnanotech.kevin_68.nanotech_mod.main.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFly extends ModelBase
{
	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;

	public ModelFly()
	{
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
		Shape1.setRotationPoint(0F, 16F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 0);
		Shape2.addBox(-3F, 0F, 0F, 1, 0, 1);
		Shape2.setRotationPoint(1.5F, 16.5F, -0.4F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0.3665191F);
		Shape3 = new ModelRenderer(this, 0, 0);
		Shape3.addBox(-3F, 0F, 0F, 1, 0, 1);
		Shape3.setRotationPoint(3.3F, 14.7F, -0.4F);
		Shape3.setTextureSize(64, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, -0.3665191F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
	{
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
	}

}
