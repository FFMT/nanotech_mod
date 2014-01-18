package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.ModelMobFastZombie;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobFastZombie;

public class RenderFastZombie extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("textures/entity/zombie/zombie.png");

	public RenderFastZombie()
	{
		super(new ModelMobFastZombie(), 0.5F);
	}

	protected ResourceLocation getFastTexture(MobFastZombie entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getFastTexture((MobFastZombie)entity);
	}
}