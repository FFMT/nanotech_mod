package fr.mcnanotech.kevin_68.nanotechmod.core;

import cpw.mods.fml.client.registry.ClientRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.core.client.render.tileentity.TileEntityLampLightRender;
import fr.mcnanotech.kevin_68.nanotechmod.core.client.render.tileentity.TileEntityLampRender;
import fr.mcnanotech.kevin_68.nanotechmod.core.client.render.tileentity.TileEntityModernFenceRender;
import fr.mcnanotech.kevin_68.nanotechmod.core.client.render.tileentity.TileEntitySpotLightRender;
import fr.mcnanotech.kevin_68.nanotechmod.core.client.render.tileentity.TileEntitySunShadeRender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntityLamp;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntityLampLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntityModernFence;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySunShade;

public class ClientProxy extends CommonProxy
{
    @Override
    public void register()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySpotLight.class, new TileEntitySpotLightRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLamp.class, new TileEntityLampRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLampLight.class, new TileEntityLampLightRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityModernFence.class, new TileEntityModernFenceRender());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySunShade.class, new TileEntitySunShadeRender());
    }
}