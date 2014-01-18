package fr.mcnanotech.kevin_68.nanotechmod.city.client.model.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlockTrail extends ModelBase
{
	// fields
	ModelRenderer Block;

	public ModelBlockTrail()
	{
		textureWidth = 64;
		textureHeight = 32;

		Block = new ModelRenderer(this, 0, 0);
		Block.addBox(-8F, -7.99F, -8F, 16, 16, 16);
		Block.setRotationPoint(0F, 16F, 0F);
		Block.setTextureSize(64, 32);
		Block.mirror = true;
		setRotation(Block, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Block.render(f5);
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