package fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ItemScytheModel extends ModelBase
{
	//fields
	public ModelRenderer Stick;
	public ModelRenderer blade1;
	public ModelRenderer blade2;
	public ModelRenderer blade3;
	public ModelRenderer blade4;
	public ModelRenderer blade5;
	public ModelRenderer blade6;
	public ModelRenderer blade7;
	public ModelRenderer blade8;

	public ItemScytheModel()
	{
		textureWidth = 64;
		textureHeight = 64;

		Stick = new ModelRenderer(this, 0, 0);
		Stick.addBox(0F, -32F, 0F, 1, 48, 1);
		Stick.setRotationPoint(0F, 8F, 0F);
		Stick.setTextureSize(64, 64);
		Stick.mirror = true;
		setRotation(Stick, 0F, 0F, 0F);
		blade1 = new ModelRenderer(this, 6, 0);
		blade1.addBox(0F, -32F, -4F, 1, 1, 4);
		blade1.setRotationPoint(0F, 8F, 0F);
		blade1.setTextureSize(64, 64);
		blade1.mirror = true;
		setRotation(blade1, 0F, 0F, 0F);
		blade2 = new ModelRenderer(this, 6, 16);
		blade2.addBox(0F, -31F, -8F, 1, 1, 8);
		blade2.setRotationPoint(0F, 8F, 0F);
		blade2.setTextureSize(64, 64);
		blade2.mirror = true;
		setRotation(blade2, 0F, 0F, 0F);
		blade3 = new ModelRenderer(this, 5, 0);
		blade3.addBox(0F, -30F, -13F, 1, 1, 13);
		blade3.setRotationPoint(0F, 8F, 0F);
		blade3.setTextureSize(64, 64);
		blade3.mirror = true;
		setRotation(blade3, 0F, 0F, 0F);
		blade4 = new ModelRenderer(this, 8, 18);
		blade4.addBox(0F, -29F, -17F, 1, 1, 17);
		blade4.setRotationPoint(0F, 8F, 0F);
		blade4.setTextureSize(64, 64);
		blade4.mirror = true;
		setRotation(blade4, 0F, 0F, 0F);
		blade5 = new ModelRenderer(this, 28, 16);
		blade5.addBox(0F, -28F, -20F, 1, 1, 17);
		blade5.setRotationPoint(0F, 8F, 0F);
		blade5.setTextureSize(64, 64);
		blade5.mirror = true;
		setRotation(blade5, 0F, 0F, 0F);
		blade6 = new ModelRenderer(this, 18, 0);
		blade6.addBox(0F, -27F, -22F, 1, 1, 15);
		blade6.setRotationPoint(0F, 8F, 0F);
		blade6.setTextureSize(64, 64);
		blade6.mirror = true;
		setRotation(blade6, 0F, 0F, 0F);
		blade7 = new ModelRenderer(this, 35, 0);
		blade7.addBox(0F, -26F, -23F, 1, 1, 11);
		blade7.setRotationPoint(0F, 8F, 0F);
		blade7.setTextureSize(64, 64);
		blade7.mirror = true;
		setRotation(blade7, 0F, 0F, 0F);
		blade8 = new ModelRenderer(this, 48, 0);
		blade8.addBox(0F, -25F, -24F, 1, 1, 7);
		blade8.setRotationPoint(0F, 8F, 0F);
		blade8.setTextureSize(64, 64);
		blade8.mirror = true;
		setRotation(blade8, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Stick.render(f5);
		blade1.render(f5);
		blade2.render(f5);
		blade3.render(f5);
		blade4.render(f5);
		blade5.render(f5);
		blade6.render(f5);
		blade7.render(f5);
		blade8.render(f5);
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