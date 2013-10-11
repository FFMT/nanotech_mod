package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelCrazyGuy;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobCrazyGuy;

public class RenderCrazyGuy extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod", "textures/entity/crazyguy.png");

	public RenderCrazyGuy(ModelCrazyGuy model, float f)
	{
		super(new ModelCrazyGuy(), 0.5F);
	}

	protected ResourceLocation getCrazyTexture(MobCrazyGuy entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getCrazyTexture((MobCrazyGuy)entity);
	}
}