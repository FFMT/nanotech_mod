package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelFly;

public class RenderMobFly extends RenderLiving
{
	private ModelFly flyModel = new ModelFly();

	public RenderMobFly(ModelFly model_Mob_fly, float f)
	{
		super(new ModelFly(), 0.5F);
	}
}
