package fr.mcnanotech.kevin_68.nanotech_mod.city.client.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlockTrashCan extends ModelBase
{
	// fields
	ModelRenderer Bottom;
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
	ModelRenderer Shape18;
	ModelRenderer Shape19;
	ModelRenderer Shape20;
	ModelRenderer Shape21;
	ModelRenderer Shape22;
	ModelRenderer Shape23;
	ModelRenderer Shape24;

	public ModelBlockTrashCan()
	{
		textureWidth = 128;
		textureHeight = 128;

		Bottom = new ModelRenderer(this, 0, 0);
		Bottom.addBox(-10F, -0.1F, -10F, 20, 0, 20);
		Bottom.setRotationPoint(0F, 24F, 0F);
		Bottom.setTextureSize(128, 128);
		Bottom.mirror = true;
		setRotation(Bottom, 0F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(9F, -20F, -3F, 1, 20, 6);
		Shape1.setRotationPoint(0F, 24F, 0F);
		Shape1.setTextureSize(128, 128);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 26);
		Shape2.addBox(-10F, -20F, -3F, 1, 20, 6);
		Shape2.setRotationPoint(0F, 24F, 0F);
		Shape2.setTextureSize(128, 128);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 0, 52);
		Shape3.addBox(-3F, -20F, 9F, 6, 20, 1);
		Shape3.setRotationPoint(0F, 24F, 0F);
		Shape3.setTextureSize(128, 128);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 0, 73);
		Shape4.addBox(-3F, -20F, -10F, 6, 20, 1);
		Shape4.setRotationPoint(0F, 24F, 0F);
		Shape4.setTextureSize(128, 128);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 14, 20);
		Shape5.addBox(8F, -20F, 2F, 1, 20, 3);
		Shape5.setRotationPoint(0F, 24F, 0F);
		Shape5.setTextureSize(128, 128);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 22, 20);
		Shape6.addBox(8F, -20F, -5F, 1, 20, 3);
		Shape6.setRotationPoint(0F, 24F, 0F);
		Shape6.setTextureSize(128, 128);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 14, 43);
		Shape7.addBox(-9F, -20F, 2F, 1, 20, 3);
		Shape7.setRotationPoint(0F, 24F, 0F);
		Shape7.setTextureSize(128, 128);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 22, 43);
		Shape8.addBox(-9F, -20F, -5F, 1, 20, 3);
		Shape8.setRotationPoint(0F, 24F, 0F);
		Shape8.setTextureSize(128, 128);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 14, 66);
		Shape9.addBox(-5F, -20F, -9F, 3, 20, 1);
		Shape9.setRotationPoint(0F, 24F, 0F);
		Shape9.setTextureSize(128, 128);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 22, 66);
		Shape10.addBox(2F, -20F, -9F, 3, 20, 1);
		Shape10.setRotationPoint(0F, 24F, 0F);
		Shape10.setTextureSize(128, 128);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 14, 87);
		Shape11.addBox(-5F, -20F, 8F, 3, 20, 1);
		Shape11.setRotationPoint(0F, 24F, 0F);
		Shape11.setTextureSize(128, 128);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 22, 87);
		Shape12.addBox(2F, -20F, 8F, 3, 20, 1);
		Shape12.setRotationPoint(0F, 24F, 0F);
		Shape12.setTextureSize(128, 128);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
		Shape13 = new ModelRenderer(this, 30, 20);
		Shape13.addBox(7F, -20F, 4F, 1, 20, 3);
		Shape13.setRotationPoint(0F, 24F, 0F);
		Shape13.setTextureSize(128, 128);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0F);
		Shape14 = new ModelRenderer(this, 38, 20);
		Shape14.addBox(7F, -20F, -7F, 1, 20, 3);
		Shape14.setRotationPoint(0F, 24F, 0F);
		Shape14.setTextureSize(128, 128);
		Shape14.mirror = true;
		setRotation(Shape14, 0F, 0F, 0F);
		Shape15 = new ModelRenderer(this, 38, 43);
		Shape15.addBox(-8F, -20F, -7F, 1, 20, 3);
		Shape15.setRotationPoint(0F, 24F, 0F);
		Shape15.setTextureSize(128, 128);
		Shape15.mirror = true;
		setRotation(Shape15, 0F, 0F, 0F);
		Shape16 = new ModelRenderer(this, 30, 43);
		Shape16.addBox(-8F, -20F, 4F, 1, 20, 3);
		Shape16.setRotationPoint(0F, 24F, 0F);
		Shape16.setTextureSize(128, 128);
		Shape16.mirror = true;
		setRotation(Shape16, 0F, 0F, 0F);
		Shape17 = new ModelRenderer(this, 30, 66);
		Shape17.addBox(-7F, -20F, -8F, 3, 20, 1);
		Shape17.setRotationPoint(0F, 24F, 0F);
		Shape17.setTextureSize(128, 128);
		Shape17.mirror = true;
		setRotation(Shape17, 0F, 0F, 0F);
		Shape18 = new ModelRenderer(this, 38, 66);
		Shape18.addBox(4F, -20F, -8F, 3, 20, 1);
		Shape18.setRotationPoint(0F, 24F, 0F);
		Shape18.setTextureSize(128, 128);
		Shape18.mirror = true;
		setRotation(Shape18, 0F, 0F, 0F);
		Shape19 = new ModelRenderer(this, 30, 87);
		Shape19.addBox(-7F, -20F, 7.013333F, 3, 20, 1);
		Shape19.setRotationPoint(0F, 24F, 0F);
		Shape19.setTextureSize(128, 128);
		Shape19.mirror = true;
		setRotation(Shape19, 0F, 0F, 0F);
		Shape20 = new ModelRenderer(this, 38, 87);
		Shape20.addBox(4F, -20F, 7F, 3, 20, 1);
		Shape20.setRotationPoint(0F, 24F, 0F);
		Shape20.setTextureSize(128, 128);
		Shape20.mirror = true;
		setRotation(Shape20, 0F, 0F, 0F);
		Shape21 = new ModelRenderer(this, 46, 20);
		Shape21.addBox(-7F, -20F, -7F, 1, 20, 1);
		Shape21.setRotationPoint(0F, 24F, 0F);
		Shape21.setTextureSize(128, 128);
		Shape21.mirror = true;
		setRotation(Shape21, 0F, 0F, 0F);
		Shape22 = new ModelRenderer(this, 50, 20);
		Shape22.addBox(6F, -20F, -7F, 1, 20, 1);
		Shape22.setRotationPoint(0F, 24F, 0F);
		Shape22.setTextureSize(128, 128);
		Shape22.mirror = true;
		setRotation(Shape22, 0F, 0F, 0F);
		Shape23 = new ModelRenderer(this, 54, 20);
		Shape23.addBox(6F, -20F, 6F, 1, 20, 1);
		Shape23.setRotationPoint(0F, 24F, 0F);
		Shape23.setTextureSize(128, 128);
		Shape23.mirror = true;
		setRotation(Shape23, 0F, 0F, 0F);
		Shape24 = new ModelRenderer(this, 58, 20);
		Shape24.addBox(-7F, -20F, 6F, 1, 20, 1);
		Shape24.setRotationPoint(0F, 24F, 0F);
		Shape24.setTextureSize(128, 128);
		Shape24.mirror = true;
		setRotation(Shape24, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Bottom.render(f5);
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
		Shape18.render(f5);
		Shape19.render(f5);
		Shape20.render(f5);
		Shape21.render(f5);
		Shape22.render(f5);
		Shape23.render(f5);
		Shape24.render(f5);
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
