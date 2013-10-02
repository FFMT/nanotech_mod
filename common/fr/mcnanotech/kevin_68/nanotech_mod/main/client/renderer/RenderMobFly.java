package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelFly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobFly;

public class RenderMobFly extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod:textures/entity/fly.png");

	public RenderMobFly(ModelFly model, float f)
	{
		super(new ModelFly(), 0.5F);
	}

	protected ResourceLocation getFlyTexture(MobFly entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getFlyTexture((MobFly)entity);
	}
}