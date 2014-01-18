package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.ModelDancer;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobDancer;

public class RenderDancer extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/entity/dancer.png");

	public RenderDancer()
	{
		super(new ModelDancer(), 0.5F);
	}

	protected ResourceLocation getCrazyTexture(MobDancer entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getCrazyTexture((MobDancer)entity);
	}
}