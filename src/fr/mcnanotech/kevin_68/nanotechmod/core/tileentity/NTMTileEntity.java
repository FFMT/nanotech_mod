package fr.mcnanotech.kevin_68.nanotechmod.core.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class NTMTileEntity
{
	public static void registerTiles()
	{
		GameRegistry.registerTileEntity(TileEntitySpotLight.class, "NanotechModSpotLight");
	}
}