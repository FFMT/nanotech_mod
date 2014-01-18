package fr.mcnanotech.kevin_68.nanotechmod.compatibility.core;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import fr.mcnanotech.kevin_68.nanotechmod.compatibility.core.forgemultipart.Utils.UtilMicroBlocks;

@Mod(modid = "NanotechModCompatibility", name = "Nanotech mod Compatibility", version = "@VERSION@")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class NanotechModCompatibility
{
	@Instance("NanotechModCompatibility")
	public static NanotechModCompatibility modInstance;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		if(Loader.isModLoaded("ForgeMultipart"))
		{
			UtilMicroBlocks.addBlocksToMicroBlocksList();
			//NanotechMod.nanoLog.fine("NanotechMod's blocks added to ForgeMultiPart list")
		}
	}
}
