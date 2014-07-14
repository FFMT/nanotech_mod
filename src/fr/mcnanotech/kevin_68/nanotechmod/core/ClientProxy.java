package fr.mcnanotech.kevin_68.nanotechmod.core;

import cpw.mods.fml.client.registry.ClientRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.core.client.render.tileentity.TileEntitySpotLightRender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;

public class ClientProxy extends CommonProxy
{
	public void register()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpotLight.class, new TileEntitySpotLightRender());
	}
}