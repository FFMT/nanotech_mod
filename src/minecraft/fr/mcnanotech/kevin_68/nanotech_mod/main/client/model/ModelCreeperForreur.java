package fr.mcnanotech.kevin_68.nanotech_mod.main.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCreeperForreur extends ModelBase
{
	ModelRenderer leg23;
	ModelRenderer leg13;
	ModelRenderer leg43;
	ModelRenderer leg33;
	ModelRenderer body3;
	ModelRenderer head3;
	ModelRenderer leg22;
	ModelRenderer leg12;
	ModelRenderer leg42;
	ModelRenderer leg32;
	ModelRenderer body2;
	ModelRenderer head2;
	ModelRenderer head;
	ModelRenderer body;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer liaison1;
	ModelRenderer liaison2;

	public ModelCreeperForreur()
	{
		this(0.0F);
	}

	public ModelCreeperForreur(float par1)
	{
		textureWidth = 64;
		textureHeight = 32;

		leg23 = new ModelRenderer(this, 0, 16);
		leg23.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg23.setRotationPoint(14F, 18F, 4F);
		leg23.setTextureSize(64, 32);
		leg23.mirror = true;
		setRotation(leg23, 0F, 0F, 0F);
		leg13 = new ModelRenderer(this, 0, 16);
		leg13.addBox(0F, 0F, -2F, 4, 6, 4);
		leg13.setRotationPoint(7F, 18F, 4F);
		leg13.setTextureSize(64, 32);
		leg13.mirror = true;
		setRotation(leg13, 0F, 0F, 0F);
		leg43 = new ModelRenderer(this, 0, 16);
		leg43.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg43.setRotationPoint(13F, 18F, -4F);
		leg43.setTextureSize(64, 32);
		leg43.mirror = true;
		setRotation(leg43, 0F, 0F, 0F);
		leg33 = new ModelRenderer(this, 0, 16);
		leg33.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg33.setRotationPoint(9F, 18F, -4F);
		leg33.setTextureSize(64, 32);
		leg33.mirror = true;
		setRotation(leg33, 0F, 0F, 0F);
		body3 = new ModelRenderer(this, 16, 16);
		body3.addBox(-4F, 0F, -2F, 8, 12, 4);
		body3.setRotationPoint(11F, 6F, 0F);
		body3.setTextureSize(64, 32);
		body3.mirror = true;
		setRotation(body3, 0F, 0F, 0F);
		head3 = new ModelRenderer(this, 0, 0);
		head3.addBox(-4F, -8F, -4F, 8, 8, 8);
		head3.setRotationPoint(11F, 6F, 0F);
		head3.setTextureSize(64, 32);
		head3.mirror = true;
		setRotation(head3, 0F, 0F, 0F);
		leg22 = new ModelRenderer(this, 0, 16);
		leg22.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg22.setRotationPoint(-9F, 18F, 4F);
		leg22.setTextureSize(64, 32);
		leg22.mirror = true;
		setRotation(leg22, 0F, 0F, 0F);
		leg12 = new ModelRenderer(this, 0, 16);
		leg12.addBox(0F, 0F, -2F, 4, 6, 4);
		leg12.setRotationPoint(-15F, 18F, 4F);
		leg12.setTextureSize(64, 32);
		leg12.mirror = true;
		setRotation(leg12, 0F, 0F, 0F);
		leg42 = new ModelRenderer(this, 0, 16);
		leg42.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg42.setRotationPoint(-9F, 18F, -4F);
		leg42.setTextureSize(64, 32);
		leg42.mirror = true;
		setRotation(leg42, 0F, 0F, 0F);
		leg32 = new ModelRenderer(this, 0, 16);
		leg32.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg32.setRotationPoint(-13F, 18F, -4F);
		leg32.setTextureSize(64, 32);
		leg32.mirror = true;
		setRotation(leg32, 0F, 0F, 0F);
		body2 = new ModelRenderer(this, 16, 16);
		body2.addBox(-4F, 0F, -2F, 8, 12, 4);
		body2.setRotationPoint(-11F, 6F, 0F);
		body2.setTextureSize(64, 32);
		body2.mirror = true;
		setRotation(body2, 0F, 0F, 0F);
		head2 = new ModelRenderer(this, 0, 0);
		head2.addBox(-4F, -8F, -4F, 8, 8, 8);
		head2.setRotationPoint(-11F, 6F, 0F);
		head2.setTextureSize(64, 32);
		head2.mirror = true;
		setRotation(head2, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 6F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 6F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 16);
		leg3.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg3.setRotationPoint(-2F, 18F, -4F);
		leg3.setTextureSize(64, 32);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 16);
		leg4.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg4.setRotationPoint(2F, 18F, -4F);
		leg4.setTextureSize(64, 32);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		leg1 = new ModelRenderer(this, 0, 16);
		leg1.addBox(0F, 0F, -2F, 4, 6, 4);
		leg1.setRotationPoint(-4F, 18F, 4F);
		leg1.setTextureSize(64, 32);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 16);
		leg2.addBox(-2F, 0F, -2F, 4, 6, 4);
		leg2.setRotationPoint(2F, 18F, 4F);
		leg2.setTextureSize(64, 32);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		liaison1 = new ModelRenderer(this, 32, 0);
		liaison1.addBox(-2F, -2F, -2F, 3, 4, 4);
		liaison1.setRotationPoint(-5F, 11F, 0F);
		liaison1.setTextureSize(64, 32);
		liaison1.mirror = true;
		setRotation(liaison1, 0F, 0F, 0F);
		liaison2 = new ModelRenderer(this, 32, 0);
		liaison2.addBox(-1F, -2F, -2F, 3, 4, 4);
		liaison2.setRotationPoint(5F, 11F, 0F);
		liaison2.setTextureSize(64, 32);
		liaison2.mirror = true;
		setRotation(liaison2, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		leg23.render(f5);
		leg13.render(f5);
		leg43.render(f5);
		leg33.render(f5);
		body3.render(f5);
		head3.render(f5);
		leg22.render(f5);
		leg12.render(f5);
		leg42.render(f5);
		leg32.render(f5);
		body2.render(f5);
		head2.render(f5);
		head.render(f5);
		body.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		liaison1.render(f5);
		liaison2.render(f5);
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
		this.head.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.leg1.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leg2.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;
		this.leg3.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;
		this.leg4.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.head2.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head2.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.leg12.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leg22.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;
		this.leg32.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;
		this.leg42.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.head3.rotateAngleY = par4 / (180F / (float) Math.PI);
		this.head3.rotateAngleX = par5 / (180F / (float) Math.PI);
		this.leg13.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
		this.leg23.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;
		this.leg33.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;
		this.leg43.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
	}

}
