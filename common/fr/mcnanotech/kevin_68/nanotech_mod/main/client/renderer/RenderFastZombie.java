package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelMobFastZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobFastzombie;

public class RenderFastZombie extends RenderLiving
{
	private ModelBase model = new ModelMobFastZombie();
	protected static final ResourceLocation texture = new ResourceLocation("textures/entity/zombie/zombie.png");

	public RenderFastZombie(ModelMobFastZombie model, float f)
	{
		super(new ModelMobFastZombie(), 0.5F);
	}

	protected ResourceLocation getFastTexture(MobFastzombie entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getFastTexture((MobFastzombie)entity);
	}
}