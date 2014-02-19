/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.renderer;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.ModelDancer;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobDancer;

public class RenderDancer extends RenderLiving
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod", "textures/entity/dancer.png");

	public RenderDancer()
	{
		super(new ModelDancer(), 0.5F);
	}

	protected ResourceLocation getCrazyTexture(MobDancer entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getCrazyTexture((MobDancer)entity);
	}
}