package fr.mcnanotech.kevin_68.nanotech_mod.city.core;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity.TileEntityFountainRender;
import fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity.TileEntityLampLightRender;
import fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity.TileEntityLampRender;
import fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity.TileEntitySpotLightRender;
import fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity.TileEntitySunShadeRender;
import fr.mcnanotech.kevin_68.nanotech_mod.city.client.renderer.tileentity.TileEntityTrailRender;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityFountain;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityLamp;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityLampLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntitySunShade;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityTrail;
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.gui.GuiOverlay;
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
import fr.mcnanotech.kevin_68.nanotech_mod.main.client.renderer.items.ItemScytheRender;
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
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerModRenders()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpotLight.class, new TileEntitySpotLightRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrail.class, new TileEntityTrailRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFountain.class, new TileEntityFountainRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLamp.class, new TileEntityLampRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLampLight.class, new TileEntityLampLightRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySunShade.class, new TileEntitySunShadeRender());
	}
}