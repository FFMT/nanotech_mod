package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelMobFastZombie;

public class RenderFastZombie extends RenderLiving
{
	private ModelBase SuperzombieModel = new ModelMobFastZombie();

	public RenderFastZombie(ModelMobFastZombie modelfastzombie, float f)
	{
		super(new ModelMobFastZombie(), 0.5F);
	}
}