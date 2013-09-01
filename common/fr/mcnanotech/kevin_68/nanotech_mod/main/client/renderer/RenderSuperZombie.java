package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperZombie;

public class RenderSuperZombie extends RenderLiving
{
	private ModelBase model = new ModelSuperZombie();
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod:textures/entity/superzombie.png");

	public RenderSuperZombie(ModelSuperZombie model, float f)
	{
		super(new ModelSuperZombie(), 0.5F);
	}
	
	protected ResourceLocation func_110870_a(MobSuperZombie entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110870_a((MobSuperZombie)par1Entity);
	}
}