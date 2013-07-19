package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.BossStatus;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelTheDeath;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobThedeath;

public class RenderTheDeath extends RenderLiving
{
	private float size;

	private ModelBase thedeathModel = new ModelTheDeath();

	public RenderTheDeath(ModelTheDeath modelTheDeath, float f)
	{
		super(new ModelTheDeath(), 0.5F);
		this.size = 3;
	}

	protected void preRenderScale(MobThedeath mobTheDeath, float par2)
	{
		GL11.glScalef(this.size, this.size, this.size);
	}

	protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
	{
		this.preRenderScale((MobThedeath)par1EntityLiving, par2);
	}

	public void renderHealtBar(MobThedeath mobTheDeath, double par2, double par4, double par6, float par8, float par9)
	{
		BossStatus.func_82824_a(mobTheDeath, true);
		super.doRenderLiving(mobTheDeath, par2, par4, par6, par8, par9);
	}

	public void doRenderLiving(EntityLiving living, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderHealtBar((MobThedeath)living, par2, par4, par6, par8, par9);
	}

	public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderHealtBar((MobThedeath)entity, par2, par4, par6, par8, par9);
	}
}