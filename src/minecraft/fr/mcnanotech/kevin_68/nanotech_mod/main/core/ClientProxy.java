package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelCrazyGuy;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelCreeperForreur;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelFly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelFlyingCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelMobFastZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperEnderman;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelSuperZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.model.ModelTheDeath;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderCrazyGuy;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderCreeperForreur;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderFastZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderFlyingCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderMobFly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderMobSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderSuperCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderSuperEnderman;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderSuperZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.RenderTheDeath;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobCrazyGuy;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobCreeperDriller;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobFastzombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobFly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobFlyingCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperEnderman;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobThedeath;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.TileEntityBlockSpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.main.tileentity.render.TileEntityBlockSpotLightRender;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerModRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(MobThedeath.class, new RenderTheDeath(new ModelTheDeath(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperCreeper.class, new RenderSuperCreeper(new ModelSuperCreeper(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperSkeleton.class, new RenderMobSuperSkeleton(new ModelSuperSkeleton(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperEnderman.class, new RenderSuperEnderman(new ModelSuperEnderman(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperZombie.class, new RenderSuperZombie(new ModelSuperZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobCreeperDriller.class, new RenderCreeperForreur(new ModelCreeperForreur(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobFastzombie.class, new RenderFastZombie(new ModelMobFastZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobFly.class, new RenderMobFly(new ModelFly(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobFlyingCreeper.class, new RenderFlyingCreeper(new ModelFlyingCreeper(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobCrazyGuy.class, new RenderCrazyGuy(new ModelCrazyGuy(), 0.5F));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockSpotLight.class, new TileEntityBlockSpotLightRender());
	}
}