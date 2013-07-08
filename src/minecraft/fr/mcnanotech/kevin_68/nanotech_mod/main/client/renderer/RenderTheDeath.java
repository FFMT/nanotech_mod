package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelTheDeath;

public class RenderTheDeath extends RenderLiving
{
	private ModelBase thedeathModel = new ModelTheDeath();

	public RenderTheDeath(ModelTheDeath modelTheDeath, float f)
	{
		super(new ModelTheDeath(), 0.5F);
	}
}