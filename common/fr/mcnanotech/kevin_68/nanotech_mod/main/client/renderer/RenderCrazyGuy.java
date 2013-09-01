package fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelCrazyGuy;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobCrazyGuy;

public class RenderCrazyGuy extends RenderLiving
{
	private ModelBase model = new ModelCrazyGuy();
	protected static final ResourceLocation texture = new ResourceLocation("nanotech_mod", "textures/entity/CrazyGuy.png");

	public RenderCrazyGuy(ModelCrazyGuy model, float f)
	{
		super(new ModelCrazyGuy(), 0.5F);
	}

	protected ResourceLocation func_110870_a(MobCrazyGuy entity)
	{
		return texture;
	}

	@Override
	protected ResourceLocation func_110775_a(Entity par1Entity)
	{
		return this.func_110870_a((MobCrazyGuy)par1Entity);
	}
}