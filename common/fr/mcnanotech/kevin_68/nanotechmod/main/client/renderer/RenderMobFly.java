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
import fr.mcnanotech.kevin_68.nanotechmod.main.client.model.ModelFly;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs.MobFly;

public class RenderMobFly extends RenderLiving
{
    protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/entity/fly.png");

    public RenderMobFly(float shadow)
    {
        super(new ModelFly(), shadow);
    }

    protected ResourceLocation getFlyTexture(MobFly entity)
    {
        return texture;
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.getFlyTexture((MobFly)entity);
    }
}