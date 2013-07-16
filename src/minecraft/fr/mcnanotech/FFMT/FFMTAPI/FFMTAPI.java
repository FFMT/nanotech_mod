package fr.mcnanotech.FFMT.FFMTAPI;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import fr.mcnanotech.FFMT.FFMTAPI.Interfaces.NotWorking;

@Mod(modid = "FFMTAPI", name = "FFMT API", version = "1.0.1", useMetadata = true)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

/**
 * @authors kevin_68, elias54, robin4002
 */
public class FFMTAPI 
{
	public static Logger FFMTlog;
	@Metadata("FFMTAPI")
	public static ModMetadata meta;
	public static FFMTColor getColor = new FFMTColor();
	
	@PreInit
	public void preload(FMLPreInitializationEvent event)
	{
		FFMTlog = FMLLog.getLogger();
		FFMTlog.log(Level.INFO, "PreInitialization");
	}
	
	@NotWorking
	@Init
	public void load(FMLInitializationEvent event)
	{

		FFMTlog.log(Level.INFO, "Initialization");
		meta.modId       = "FFMTAPI";
		meta.name        = "FFMT API";
		meta.version     = "1.0.0";
		meta.authorList  = Arrays.asList(new String[] {"kevin_68", "robin4002", "elias54"});
		meta.description = "simplify your coder life";
		meta.url         = "http://forge.mcnanotech.fr/";
		meta.logoFile    = "/ffmt_logo.png";
	}
	
}
