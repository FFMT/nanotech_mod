package fr.mcnanotech.kevin_68.nanotechmod.main.client.model.items;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ItemCrazyGlassesModel extends ModelBiped
{
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;

	public ItemCrazyGlassesModel()
	{
		textureWidth = 64;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 56, 28 + 32);
		Shape1.addBox(4F, -5F, -5F, 1, 1, 3);
		Shape1.setRotationPoint(0F, 0F, 0F);
		Shape1.setTextureSize(64, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 56, 20 + 32);
		Shape2.addBox(-5F, -5F, -5F, 1, 1, 3);
		Shape2.setRotationPoint(0F, 0F, 0F);
		Shape2.setTextureSize(64, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 60, 3 + 32);
		Shape3.addBox(-5F, -5F, 1F, 1, 2, 1);
		Shape3.setRotationPoint(0F, 0F, 0F);
		Shape3.setTextureSize(64, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 60, 0 + 32);
		Shape4.addBox(4F, -5F, 1F, 1, 2, 1);
		Shape4.setRotationPoint(0F, 0F, 0F);
		Shape4.setTextureSize(64, 64);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 56, 6 + 32);
		Shape5.addBox(-4F, -5F, -5F, 1, 1, 1);
		Shape5.setRotationPoint(0F, 0F, 0F);
		Shape5.setTextureSize(64, 64);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 60, 6 + 32);
		Shape6.addBox(3F, -5F, -5F, 1, 1, 1);
		Shape6.setRotationPoint(0F, 0F, 0F);
		Shape6.setTextureSize(64, 64);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 58, 13 + 32);
		Shape7.addBox(-3F, -5.2F, -5F, 2, 2, 1);
		Shape7.setRotationPoint(0F, 0F, 0F);
		Shape7.setTextureSize(64, 64);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 58, 10 + 32);
		Shape8.addBox(1F, -5.2F, -5F, 2, 2, 1);
		Shape8.setRotationPoint(0F, 0F, 0F);
		Shape8.setTextureSize(64, 64);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 58, 8 + 32);
		Shape9.addBox(-1F, -5F, -5F, 2, 1, 1);
		Shape9.setRotationPoint(0F, 0F, 0F);
		Shape9.setTextureSize(64, 64);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 56, 16 + 32);
		Shape10.addBox(-5F, -5F, -2F, 1, 1, 3);
		Shape10.setRotationPoint(0F, 0F, 0F);
		Shape10.setTextureSize(64, 64);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 56, 24 + 32);
		Shape11.addBox(4F, -5F, -2F, 1, 1, 3);
		Shape11.setRotationPoint(0F, 0F, 0F);
		Shape11.setTextureSize(64, 64);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
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
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
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
		this.Shape1.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape1.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.Shape2.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape2.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.Shape3.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape3.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.Shape4.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape4.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.Shape5.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape5.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.Shape6.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape6.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.Shape7.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape7.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.Shape8.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape8.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.Shape9.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape9.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.Shape10.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape10.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.Shape11.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.Shape11.rotateAngleX = f4 / (180F / (float)Math.PI);
	}

}
