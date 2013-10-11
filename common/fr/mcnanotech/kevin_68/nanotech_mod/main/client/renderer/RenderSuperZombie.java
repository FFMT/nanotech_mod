package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperZombie;

public class RenderSuperZombie extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod", "textures/entity/superzombie.png");

	public RenderSuperZombie(ModelSuperZombie model, float f)
	{
		super(new ModelSuperZombie(), 0.5F);
	}

	protected ResourceLocation getZombieTexture(MobSuperZombie entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getZombieTexture((MobSuperZombie)entity);
	}
}