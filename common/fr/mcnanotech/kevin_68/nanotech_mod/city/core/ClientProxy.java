package fr.mcnanotech.kevin_68.nanotech_mod.city.core;

import cpw.mods.fml.client.registry.ClientRegistry;
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