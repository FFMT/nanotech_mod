package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelCrazyGuy;

public class RenderCrazyGuy extends RenderLiving
{
	private ModelBase modelBase = new ModelCrazyGuy();

	public RenderCrazyGuy(ModelCrazyGuy modelFastZombie, float f)
	{
		super(new ModelCrazyGuy(), 0.5F);
	}
}