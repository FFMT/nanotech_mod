package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelFly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobFly;

public class RenderMobFly extends RenderLiving
{
	private ModelFly model = new ModelFly();
	protected static final ResourceLocation texture = new ResourceLocation("Nanotech_mod:textures/entity/fly.png");

	public RenderMobFly(ModelFly model, float f)
	{
		super(new ModelFly(), 0.5F);
	}
	
	protected ResourceLocation func_110870_a(MobFly entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110870_a((MobFly)par1Entity);
	}
}
