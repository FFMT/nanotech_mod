package fr.mcnanotech.kevin_68.nanotech_mod.core;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.ModelCreeperForreur;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.ModelFly;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.ModelFlyingCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.ModelMobFastZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.ModelSuperCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.ModelSuperEnderman;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.ModelSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.ModelSuperZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.client.model.ModelTheDeath;
import fr.mcnanotech.kevin_68.nanotech_mod.client.renderer.RenderCreeperForreur;
import fr.mcnanotech.kevin_68.nanotech_mod.client.renderer.RenderFastZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.client.renderer.RenderFlyingCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.client.renderer.RenderMobFly;
import fr.mcnanotech.kevin_68.nanotech_mod.client.renderer.RenderMobSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotech_mod.client.renderer.RenderSuperCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.client.renderer.RenderSuperEnderman;
import fr.mcnanotech.kevin_68.nanotech_mod.client.renderer.RenderSuperZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.client.renderer.RenderTheDeath;
import fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs.MobCreeperforreur;
import fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs.MobFastzombie;
import fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs.MobFly;
import fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs.MobFlyingCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs.MobSuperCreeper;
import fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs.MobSuperEnderman;
import fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs.MobSuperSkeleton;
import fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs.MobSuperZombie;
import fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs.MobThedeath;

public class ClientProxy extends CommonProxy
{
	public static int renderBlockID;

	@Override
	public void registerRenderThings()
	{
		MinecraftForgeClient.preloadTexture("/fr/mcnanotech/kevin_68/nanotech_mod/client/textures/terrain.png");
		MinecraftForgeClient.preloadTexture("/Nanotech_mod/client/textures/items.png");
		MinecraftForgeClient.preloadTexture("/Nanotech_mod/client/textures/GUI_blockjump.png");
		MinecraftForgeClient.preloadTexture("/Nanotech_mod/client/textures/GUI_blocksmoke.png");
	}
	
	@Override
	public void registerModRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(MobThedeath.class, new RenderTheDeath(new ModelTheDeath(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperCreeper.class, new RenderSuperCreeper(new ModelSuperCreeper(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperSkeleton.class, new RenderMobSuperSkeleton(new ModelSuperSkeleton(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperEnderman.class, new RenderSuperEnderman(new ModelSuperEnderman(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobSuperZombie.class, new RenderSuperZombie(new ModelSuperZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobCreeperforreur.class, new RenderCreeperForreur(new ModelCreeperForreur(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobFastzombie.class, new RenderFastZombie(new ModelMobFastZombie(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobFly.class, new RenderMobFly(new ModelFly(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(MobFlyingCreeper.class, new RenderFlyingCreeper(new ModelFlyingCreeper(), 0.5F));
	}
}