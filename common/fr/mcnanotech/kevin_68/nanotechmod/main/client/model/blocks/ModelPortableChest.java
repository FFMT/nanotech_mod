package fr.mcnanotech.kevin_68.nanotechmod.main.client.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPortableChest extends ModelBase
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
	ModelRenderer Shape12;
	ModelRenderer Shape13;
	ModelRenderer Shape14;
	ModelRenderer Shape15;
	ModelRenderer Shape16;
	ModelRenderer Shape17;

	public ModelPortableChest()
	{
		textureWidth = 128;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(-7F, -1F, -7F, 14, 1, 14);
		Shape1.setRotationPoint(0F, 24F, 0F);
		Shape1.setTextureSize(128, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 15);
		Shape2.addBox(6F, -10F, -7F, 1, 9, 14);
		Shape2.setRotationPoint(0F, 24F, 0F);
		Shape2.setTextureSize(128, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 15);
		Shape3.addBox(-7F, -10F, -7F, 1, 9, 14);
		Shape3.setRotationPoint(0F, 24F, 0F);
		Shape3.setTextureSize(128, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 38);
		Shape4.addBox(-6F, -10F, -7F, 12, 9, 1);
		Shape4.setRotationPoint(0F, 24F, 0F);
		Shape4.setTextureSize(128, 64);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 0, 38);
		Shape5.addBox(-6F, -10F, 6F, 12, 9, 1);
		Shape5.setRotationPoint(0F, 24F, 0F);
		Shape5.setTextureSize(128, 64);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 30, 15);
		Shape6.addBox(-7F, -15F, 6F, 14, 5, 1);
		Shape6.setRotationPoint(0F, 24F, 0F);
		Shape6.setTextureSize(128, 64);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 30, 15);
		Shape7.addBox(-7F, -15F, -7F, 14, 5, 1);
		Shape7.setRotationPoint(0F, 24F, 0F);
		Shape7.setTextureSize(128, 64);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 30, 21);
		Shape8.addBox(-7F, -15F, -6F, 1, 5, 12);
		Shape8.setRotationPoint(0F, 24F, 0F);
		Shape8.setTextureSize(128, 64);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 30, 21);
		Shape9.addBox(6F, -15F, -6F, 1, 5, 12);
		Shape9.setRotationPoint(0F, 24F, 0F);
		Shape9.setTextureSize(128, 64);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 42, 0);
		Shape10.addBox(-6F, -15F, -6F, 12, 1, 12);
		Shape10.setRotationPoint(0F, 24F, 0F);
		Shape10.setTextureSize(128, 64);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 0, 0);
		Shape11.addBox(-0.5F, -12F, -8F, 1, 3, 1);
		Shape11.setRotationPoint(0F, 24F, 0F);
		Shape11.setTextureSize(128, 64);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 0, 16);
		Shape12.addBox(-9F, -10F, 2F, 2, 1, 1);
		Shape12.setRotationPoint(0F, 24F, 0F);
		Shape12.setTextureSize(128, 64);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
		Shape13 = new ModelRenderer(this, 0, 16);
		Shape13.addBox(-9F, -10F, -3F, 2, 1, 1);
		Shape13.setRotationPoint(0F, 24F, 0F);
		Shape13.setTextureSize(128, 64);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0F);
		Shape14 = new ModelRenderer(this, 0, 16);
		Shape14.addBox(7F, -10F, -3F, 2, 1, 1);
		Shape14.setRotationPoint(0F, 24F, 0F);
		Shape14.setTextureSize(128, 64);
		Shape14.mirror = true;
		setRotation(Shape14, 0F, 0F, 0F);
		Shape15 = new ModelRenderer(this, 0, 16);
		Shape15.addBox(7F, -10F, 2F, 2, 1, 1);
		Shape15.setRotationPoint(0F, 24F, 0F);
		Shape15.setTextureSize(128, 64);
		Shape15.mirror = true;
		setRotation(Shape15, 0F, 0F, 0F);
		Shape16 = new ModelRenderer(this, 0, 19);
		Shape16.addBox(-10F, -10F, -3F, 1, 1, 6);
		Shape16.setRotationPoint(0F, 24F, 0F);
		Shape16.setTextureSize(128, 64);
		Shape16.mirror = true;
		setRotation(Shape16, 0F, 0F, 0F);
		Shape17 = new ModelRenderer(this, 0, 19);
		Shape17.addBox(9F, -10F, -3F, 1, 1, 6);
		Shape17.setRotationPoint(0F, 24F, 0F);
		Shape17.setTextureSize(128, 64);
		Shape17.mirror = true;
		setRotation(Shape17, 0F, 0F, 0F);
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
		Shape12.render(f5);
		Shape13.render(f5);
		Shape14.render(f5);
		Shape15.render(f5);
		Shape16.render(f5);
		Shape17.render(f5);
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