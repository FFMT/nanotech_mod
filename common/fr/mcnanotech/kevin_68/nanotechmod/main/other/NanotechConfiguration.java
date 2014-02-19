/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.other;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;

public class NanotechConfiguration
{

	/**
	 * NanotechMod dimension IDentifier
	 */
	public static int dimensionID;

	/**
	 * NanotechMod biomes IDentifiers
	 */
	public static int nanotechBiomeID, nitrogenOceanID;

	/**
	 * Probability for structure's spawn
	 */
	public static int structure1Prob, structure2Prob, structure3Prob, structure4Prob, structure5Prob, structure6Prob;

	/**
	 * HardRecipe mode
	 */
	public static boolean hardRecipe;

	/**
	 * NanotechMod mobs configuration
	 */
	public static boolean theDeathSpawn, multipleExplosion;

	/**
	 * NanotechMod mobs configuration
	 */
	public static int explosionRadius, ticksUntilNextArrow, superZombieProb, superZombieMin, superZombieMax, superSkeletonProb, superSkeletonMin, superSkeletonMax, superCreeperProb, superCreeperMin, superCreeperMax, superEndermanProb, superEndermanMin, superEndermanMax, fastZombieProb, fastZombieMin, fastZombieMax, flyProb, flyMin, flyMax, creeperDrillerProb, creeperDrillerMin, creeperDrillerMax,
			flyingCreeperProb, flyingCreeperMin, flyingCreeperMax, crazyGuyProb, crazyGuyMin, crazyGuyMax, dancerProb, dancerMin, dancerMax;

	/**
	 * Configuration categories
	 */
	public static final String Config_Mobs = "Mobs", Config_World = "World", Config_Other = "Other";

	public static void configure(FMLPreInitializationEvent event)
	{
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			cfg.load();

			dimensionID = cfg.get("World", "Dimension ID", 19).getInt();
			nanotechBiomeID = cfg.get("World", "Biome ID", 100).getInt();
			nitrogenOceanID = cfg.get("World", "Nitrogen Ocean", 101).getInt();

			hardRecipe = cfg.get(Config_Other, "Hard recipes", false).getBoolean(false);

			multipleExplosion = cfg.get(Config_Mobs, "Multiple Explosion (CreeperDriller)", true).getBoolean(true);
			explosionRadius = cfg.get(Config_Mobs, "Explosion Radius (SuperCreeper)", 5).getInt();
			ticksUntilNextArrow = cfg.get(Config_Mobs, "Time Until New Arrow (SuperSkeleton)", 3).getInt();

			superZombieProb = cfg.get(Config_Mobs, "SuperZombie Prob", 1).getInt();
			superZombieMin = cfg.get(Config_Mobs, "SuperZombie Min", 1).getInt();
			superZombieMax = cfg.get(Config_Mobs, "SuperZombie Max", 2).getInt();
			superSkeletonProb = cfg.get(Config_Mobs, "SuperSkeleton Prob", 1).getInt();
			superSkeletonMin = cfg.get(Config_Mobs, "SuperSkeleton Min", 1).getInt();
			superSkeletonMax = cfg.get(Config_Mobs, "SuperSkeleton Max", 2).getInt();
			superCreeperProb = cfg.get(Config_Mobs, "SuperCreeper Prob", 1).getInt();
			superCreeperMin = cfg.get(Config_Mobs, "SuperCreeper Min", 1).getInt();
			superCreeperMax = cfg.get(Config_Mobs, "SuperCreeper Max", 2).getInt();
			superEndermanProb = cfg.get(Config_Mobs, "SuperEnderman Prob", 1).getInt();
			superEndermanMin = cfg.get(Config_Mobs, "SuperEnderman Min", 1).getInt();
			superEndermanMax = cfg.get(Config_Mobs, "SuperEnderman Max", 2).getInt();
			fastZombieProb = cfg.get(Config_Mobs, "FastZombie Prob", 1).getInt();
			fastZombieMin = cfg.get(Config_Mobs, "FastZombie Min", 5).getInt();
			fastZombieMax = cfg.get(Config_Mobs, "FastZombie Max", 10).getInt();
			flyProb = cfg.get(Config_Mobs, "Fly Prob", 3).getInt();
			flyMin = cfg.get(Config_Mobs, "Fly Min", 1).getInt();
			flyMax = cfg.get(Config_Mobs, "Fly Max", 4).getInt();
			creeperDrillerProb = cfg.get(Config_Mobs, "CreeperDriller Prob", 1).getInt();
			creeperDrillerMin = cfg.get(Config_Mobs, "CreeperDriller Min", 1).getInt();
			creeperDrillerMax = cfg.get(Config_Mobs, "CreeperDriller Max", 2).getInt();
			flyingCreeperProb = cfg.get(Config_Mobs, "FlyingCreeper Prob", 1).getInt();
			flyingCreeperMin = cfg.get(Config_Mobs, "FlyingCreeper Min", 1).getInt();
			flyingCreeperMax = cfg.get(Config_Mobs, "FlyingCreeper Max", 2).getInt();
			crazyGuyProb = cfg.get(Config_Mobs, "CrazyGuy Prob", 1).getInt();
			crazyGuyMin = cfg.get(Config_Mobs, "CrazyGuy Min", 1).getInt();
			crazyGuyMax = cfg.get(Config_Mobs, "CrazyGuy Max", 2, "Set the probability to 0 to disable the mob, max = maximum spawn group and min = minimum spawn group").getInt();
			theDeathSpawn = cfg.get(Config_Mobs, "Enable TheDeath", true).getBoolean(true);
			dancerProb = cfg.get(Config_Mobs, "Dancer Prob", 2).getInt();
			dancerMin = cfg.get(Config_Mobs, "Dancer Min", 1).getInt();
			dancerMax = cfg.get(Config_Mobs, "Dancer Max", 2).getInt();

			structure1Prob = cfg.get(Config_World, "Structure 1 probability", 2).getInt();
			structure2Prob = cfg.get(Config_World, "Structure 2 probability", 2).getInt();
			structure3Prob = cfg.get(Config_World, "Structure 3 probability", 2).getInt();
			structure4Prob = cfg.get(Config_World, "Structure 4 probability", 2).getInt();
			structure5Prob = cfg.get(Config_World, "Structure 5 probability", 2).getInt();
			structure6Prob = cfg.get(Config_World, "Structure 6 probability", 2).getInt();
		}
		catch(Exception ex)
		{
			NanotechMod.nanoLogger.error("Failed to load configuration");
		}
		finally
		{
			if(cfg.hasChanged())
			{
				cfg.save();
			}
		}
	}
}
