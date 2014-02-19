/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSuperEnderman extends ModelBiped
{
	public boolean isCarrying = false;
	public boolean isAttacking = false;

	public ModelSuperEnderman()
	{
		super(0.0F, -14.0F, 64, 32);
		float var1 = -14.0F;
		float var2 = 0.0F;
		this.bipedHeadwear = new ModelRenderer(this, 0, 16);
		this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, var2 - 0.5F);
		this.bipedHeadwear.setRotationPoint(0.0F, 0.0F + var1, 0.0F);
		this.bipedBody = new ModelRenderer(this, 32, 16);
		this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, var2);
		this.bipedBody.setRotationPoint(0.0F, 0.0F + var1, 0.0F);
		this.bipedRightArm = new ModelRenderer(this, 56, 0);
		this.bipedRightArm.addBox(-1.0F, -2.0F, -1.0F, 2, 30, 2, var2);
		this.bipedRightArm.setRotationPoint(-3.0F, 2.0F + var1, 0.0F);
		this.bipedLeftArm = new ModelRenderer(this, 56, 0);
		this.bipedLeftArm.mirror = true;
		this.bipedLeftArm.addBox(-1.0F, -2.0F, -1.0F, 2, 30, 2, var2);
		this.bipedLeftArm.setRotationPoint(5.0F, 2.0F + var1, 0.0F);
		this.bipedRightLeg = new ModelRenderer(this, 56, 0);
		this.bipedRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 30, 2, var2);
		this.bipedRightLeg.setRotationPoint(-2.0F, 12.0F + var1, 0.0F);
		this.bipedLeftLeg = new ModelRenderer(this, 56, 0);
		this.bipedLeftLeg.mirror = true;
		this.bipedLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 30, 2, var2);
		this.bipedLeftLeg.setRotationPoint(2.0F, 12.0F + var1, 0.0F);
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity entity)
	{
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
		this.bipedHead.showModel = true;
		float var7 = -14.0F;
		this.bipedBody.rotateAngleX = 0.0F;
		this.bipedBody.rotationPointY = var7;
		this.bipedBody.rotationPointZ = -0.0F;
		this.bipedRightLeg.rotateAngleX -= 0.0F;
		this.bipedLeftLeg.rotateAngleX -= 0.0F;
		this.bipedRightArm.rotateAngleX = (float)((double)this.bipedRightArm.rotateAngleX * 0.5D);
		this.bipedLeftArm.rotateAngleX = (float)((double)this.bipedLeftArm.rotateAngleX * 0.5D);
		this.bipedRightLeg.rotateAngleX = (float)((double)this.bipedRightLeg.rotateAngleX * 0.5D);
		this.bipedLeftLeg.rotateAngleX = (float)((double)this.bipedLeftLeg.rotateAngleX * 0.5D);
		float var8 = 0.4F;

		if(this.bipedRightArm.rotateAngleX > var8)
		{
			this.bipedRightArm.rotateAngleX = var8;
		}

		if(this.bipedLeftArm.rotateAngleX > var8)
		{
			this.bipedLeftArm.rotateAngleX = var8;
		}

		if(this.bipedRightArm.rotateAngleX < -var8)
		{
			this.bipedRightArm.rotateAngleX = -var8;
		}

		if(this.bipedLeftArm.rotateAngleX < -var8)
		{
			this.bipedLeftArm.rotateAngleX = -var8;
		}

		if(this.bipedRightLeg.rotateAngleX > var8)
		{
			this.bipedRightLeg.rotateAngleX = var8;
		}

		if(this.bipedLeftLeg.rotateAngleX > var8)
		{
			this.bipedLeftLeg.rotateAngleX = var8;
		}

		if(this.bipedRightLeg.rotateAngleX < -var8)
		{
			this.bipedRightLeg.rotateAngleX = -var8;
		}

		if(this.bipedLeftLeg.rotateAngleX < -var8)
		{
			this.bipedLeftLeg.rotateAngleX = -var8;
		}

		if(this.isCarrying)
		{
			this.bipedRightArm.rotateAngleX = -0.5F;
			this.bipedLeftArm.rotateAngleX = -0.5F;
			this.bipedRightArm.rotateAngleZ = 0.05F;
			this.bipedLeftArm.rotateAngleZ = -0.05F;
		}

		this.bipedRightArm.rotationPointZ = 0.0F;
		this.bipedLeftArm.rotationPointZ = 0.0F;
		this.bipedRightLeg.rotationPointZ = 0.0F;
		this.bipedLeftLeg.rotationPointZ = 0.0F;
		this.bipedRightLeg.rotationPointY = 9.0F + var7;
		this.bipedLeftLeg.rotationPointY = 9.0F + var7;
		this.bipedHead.rotationPointZ = -0.0F;
		this.bipedHead.rotationPointY = var7 + 1.0F;
		this.bipedHeadwear.rotationPointX = this.bipedHead.rotationPointX;
		this.bipedHeadwear.rotationPointY = this.bipedHead.rotationPointY;
		this.bipedHeadwear.rotationPointZ = this.bipedHead.rotationPointZ;
		this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
		this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
		this.bipedHeadwear.rotateAngleZ = this.bipedHead.rotateAngleZ;

		if(this.isAttacking)
		{
			float var9 = 1.0F;
			this.bipedHead.rotationPointY -= var9 * 5.0F;
		}
	}
}
