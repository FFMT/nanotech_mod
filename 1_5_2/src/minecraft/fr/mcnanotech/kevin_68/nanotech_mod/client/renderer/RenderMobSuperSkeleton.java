package fr.mcnanotech.kevin_68.nanotech_mod.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.ModelSuperSkeleton;

public class RenderMobSuperSkeleton extends RenderLiving
{
	private ModelSuperSkeleton SuperskeletonModel = new ModelSuperSkeleton();

	public RenderMobSuperSkeleton(ModelSuperSkeleton modelsuperskeleton, float f)
	{
		super(new ModelSuperSkeleton(), 0.5F);
	}
}
