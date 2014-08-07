package fr.mcnanotech.kevin_68.nanotechmod.core.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class NTMTileEntity
{
    public static void registerTiles()
    {
        GameRegistry.registerTileEntity(TileEntitySpotLight.class, "NanotechMod_SpotLight");
        GameRegistry.registerTileEntity(TileEntityLamp.class, "Nanotech_ModLamp");
        GameRegistry.registerTileEntity(TileEntityLampLight.class, "NanotechMod_LampLight");
        GameRegistry.registerTileEntity(TileEntityModernFence.class, "NanotechMod_ModernFence");
        GameRegistry.registerTileEntity(TileEntitySunShade.class, "NanotechMod_SunShade");
    }
}