package fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.core.Nanotech_mod;

public class NanotechMobs
{
	// Eggs spawner color
	public static int eggColorRed = 16711680;
	public static int eggColorGreen = 652820;
	public static int eggColorBlue = 255;
	public static int eggColorLightBlue = 65535;
	public static int eggColorWhite = 16777215;
	public static int eggColorYellow = 16776960;
	public static int eggColorOrange = 16744448;
	public static int eggColorBrown = 8404992;
	public static int eggColorBlack = 0;
	public static int eggColorPink = 16711808;
	public static int eggColorGray = 8421504;
	public static int eggColorLightGreen = 8454052;
	public static int eggColorBlueGreen = 46220;

	public static void mobs()
	{
		if (Nanotech_mod.Superzombie)
		{
			EntityRegistry.registerGlobalEntityID(MobSuperZombie.class, "Superzombie", EntityRegistry.findGlobalUniqueEntityId(), eggColorBlueGreen, eggColorRed);
			EntityRegistry.registerModEntity(MobSuperZombie.class, "Superzombie", 0, Nanotech_mod.modInstance, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Superzombie.name", "en_US", "Superzombie");
			if (Nanotech_mod.MobSpawn)
			{
				EntityRegistry.addSpawn(MobSuperZombie.class, Nanotech_mod.Superzombiechance, Nanotech_mod.Superzombiemin, Nanotech_mod.Superzombiemax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
			}
		}

		if (Nanotech_mod.Fastzombie)
		{
			EntityRegistry.registerGlobalEntityID(MobFastzombie.class, "Fastzombie", EntityRegistry.findGlobalUniqueEntityId(), eggColorBlue, eggColorRed);
			EntityRegistry.registerModEntity(MobFastzombie.class, "Fastzombie", 1, Nanotech_mod.modInstance, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Fastzombie.name", "en_US", "Fastzombie");
			if (Nanotech_mod.MobSpawn)
			{
				EntityRegistry.addSpawn(MobFastzombie.class, Nanotech_mod.Fastzombiechance, Nanotech_mod.Fastzombiemin, Nanotech_mod.Fastzombiemax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
			}
		}

		if (Nanotech_mod.Superskeleton)
		{
			EntityRegistry.registerGlobalEntityID(MobSuperSkeleton.class, "Superskeleton", EntityRegistry.findGlobalUniqueEntityId(), eggColorWhite, eggColorYellow);
			EntityRegistry.registerModEntity(MobSuperSkeleton.class, "Superskeleton", 2, Nanotech_mod.modInstance, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Superskeleton.name", "en_US", "Superskeleton");
			if (Nanotech_mod.MobSpawn)
			{
				EntityRegistry.addSpawn(MobSuperSkeleton.class, Nanotech_mod.Superskeletonchance, Nanotech_mod.Superskeletonmin, Nanotech_mod.Superskeletonmax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
			}
		}

		if (Nanotech_mod.Supercreeper)
		{
			EntityRegistry.registerGlobalEntityID(MobSuperCreeper.class, "Supercreeper", EntityRegistry.findGlobalUniqueEntityId(), eggColorGreen, eggColorRed);
			EntityRegistry.registerModEntity(MobSuperCreeper.class, "Supercreeper", 4, Nanotech_mod.modInstance, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Supercreeper.name", "en_US", "Supercreeper");
			if (Nanotech_mod.MobSpawn)
			{
				EntityRegistry.addSpawn(MobSuperCreeper.class, Nanotech_mod.Supercreeperchance, Nanotech_mod.Supercreepermin, Nanotech_mod.Supercreepermax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
			}
		}

		if (Nanotech_mod.Superenderman)
		{
			EntityRegistry.registerGlobalEntityID(MobSuperEnderman.class, "Superenderman", EntityRegistry.findGlobalUniqueEntityId(), eggColorBlack, eggColorGray);
			EntityRegistry.registerModEntity(MobSuperEnderman.class, "Superenderman", 5, Nanotech_mod.modInstance, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Superenderman.name", "en_US", "Superenderman");
			if (Nanotech_mod.MobSpawn)
			{
				EntityRegistry.addSpawn(MobSuperEnderman.class, Nanotech_mod.Superendermanchance, Nanotech_mod.Superendermanmin, Nanotech_mod.Superendermanmax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
			}
		}

		if (Nanotech_mod.Creeperdriller)
		{
			EntityRegistry.registerGlobalEntityID(MobCreeperforreur.class, "Creeperforreur", EntityRegistry.findGlobalUniqueEntityId(), eggColorOrange, eggColorRed);
			EntityRegistry.registerModEntity(MobCreeperforreur.class, "Creeperdriller", 6, Nanotech_mod.modInstance, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Creeperforreur.name", "en_US", "Creeperdriller");
			if (Nanotech_mod.MobSpawn)
			{
				EntityRegistry.addSpawn(MobCreeperforreur.class, Nanotech_mod.Creeperdrillerchance, Nanotech_mod.Creeperdrillermin, Nanotech_mod.Creeperdrillermax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
			}
		}

		if (Nanotech_mod.TheDeath)
		{
			EntityRegistry.registerGlobalEntityID(MobThedeath.class, "TheDeath", EntityRegistry.findGlobalUniqueEntityId(), eggColorBlack, eggColorWhite);
			EntityRegistry.registerModEntity(MobThedeath.class, "TheDeath", 7, Nanotech_mod.modInstance, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.TheDeath.name", "en_US", "TheDeath");
			if (Nanotech_mod.MobSpawn)
			{
				EntityRegistry.addSpawn(MobThedeath.class, 0, 0, 0, EnumCreatureType.monster);
			}
		}

		if (Nanotech_mod.Fly)
		{
			EntityRegistry.registerGlobalEntityID(MobFly.class, "Fly", EntityRegistry.findGlobalUniqueEntityId(), eggColorGray, eggColorBlack);
			EntityRegistry.registerModEntity(MobFly.class, "Fly", 8, Nanotech_mod.modInstance, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Fly.name", "en_US", "Fly");
			if (Nanotech_mod.MobSpawn)
			{
				EntityRegistry.addSpawn(MobFly.class, Nanotech_mod.Flychance, Nanotech_mod.Flymin, Nanotech_mod.Flymax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, Nanotech_mod.Nanotechbiome);
			}
		}

		if (Nanotech_mod.Flyingcreeper)
		{
			EntityRegistry.registerGlobalEntityID(MobFlyingCreeper.class, "Flying Creeper", EntityRegistry.findGlobalUniqueEntityId(), eggColorGreen, eggColorRed);
			EntityRegistry.registerModEntity(MobFlyingCreeper.class, "Flying Creeper", 9, Nanotech_mod.modInstance, 100, 1, true);
			LanguageRegistry.instance().addStringLocalization("entity.Flying Creeper.name", "en_US", "Flying Creeper");
			if (Nanotech_mod.MobSpawn)
			{
				EntityRegistry.addSpawn(MobFlyingCreeper.class, Nanotech_mod.Flyingcreeperchance, Nanotech_mod.Flyingcreepermin, Nanotech_mod.Flyingcreepermax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
			}
		}
	}

}
