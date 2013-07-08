package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperZombie;

public class RenderSuperZombie extends RenderLiving
{
	private ModelBase SuperzombieModel = new ModelSuperZombie();

	public RenderSuperZombie(ModelSuperZombie modelsuperzombie, float f)
	{
		super(new ModelSuperZombie(), 0.5F);
	}
}