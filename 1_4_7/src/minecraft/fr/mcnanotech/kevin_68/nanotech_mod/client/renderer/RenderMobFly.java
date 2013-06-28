package fr.mcnanotech.kevin_68.nanotech_mod.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.ModelFly;

public class RenderMobFly extends RenderLiving
{
	private ModelFly flyModel = new ModelFly();

	public RenderMobFly(ModelFly model_Mob_fly, float f)
	{
		super(new ModelFly(), 0.5F);
	}
}
