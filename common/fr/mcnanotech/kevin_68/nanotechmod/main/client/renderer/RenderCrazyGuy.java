package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.ModelCrazyGuy;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobCrazyGuy;

public class RenderCrazyGuy extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/entity/crazyguy.png");

	public RenderCrazyGuy()
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