/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSatelite extends ModelBase
{
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;

	public ModelSatelite()
	{
		textureWidth = 128;
		textureHeight = 128;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(-8F, -8F, -8F, 16, 16, 16);
		Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 0);
		Shape2.addBox(8F, 0F, 0F, 4, 1, 1);
		Shape2.setRotationPoint(0F, 0F, 0F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 0);
		Shape3.addBox(-12F, 0F, 0F, 4, 1, 1);
		Shape3.setRotationPoint(0F, 0F, 0F);
		Shape3.setTextureSize(128, 128);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 32);
		Shape4.addBox(-75F, -10F, 0F, 63, 20, 1);
		Shape4.setRotationPoint(0F, 0F, 0F);
		Shape4.setTextureSize(128, 128);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 0, 53);
		Shape5.addBox(12F, -10F, 0F, 63, 20, 1);
		Shape5.setRotationPoint(0F, 0F, 0F);
		Shape5.setTextureSize(128, 128);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 48, 0);
		Shape6.addBox(-4F, -4F, -9F, 8, 8, 1);
		Shape6.setRotationPoint(0F, 0F, 0F);
		Shape6.setTextureSize(128, 128);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
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
	}

}
