package fr.mcnanotech.kevin_68.nanotech_mod.main.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelCrazyGuy extends ModelBiped
{
	public ModelCrazyGuy()
	{
		this(0.0F, false);
	}

	protected ModelCrazyGuy(float par1, float par2, int par3, int par4)
	{
		super(par1, par2, par3, par4);
	}

	public ModelCrazyGuy(float par1, boolean par2)
	{
		super(par1, 0.0F, 64, par2 ? 32 : 64);
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
	{
		super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
		this.bipedHead.rotateAngleY = par3;
		this.bipedRightArm.rotateAngleX = par3;
		this.bipedLeftArm.rotateAngleX = -par3;
	}
}
