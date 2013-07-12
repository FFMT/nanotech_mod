package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.mcnanotech.FFMT.FFMTAPI.FFMTColor;
import fr.mcnanotech.FFMT.FFMTAPI.FFMTEntityHelper;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class NanotechMobs
{
	public static void mobs()
	{
		if (Nanotech_mod.Superzombie)
		{
			FFMTEntityHelper.addMob(MobSuperZombie.class, "SuperZombie", "SuperZombie", 0, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blueGreenInt, FFMTColor.redInt, Nanotech_mod.Superzombiechance, Nanotech_mod.Superzombiemin, Nanotech_mod.Superzombiemax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}

		if (Nanotech_mod.Fastzombie)
		{
			FFMTEntityHelper.addMob(MobFastzombie.class, "FastZombie", "FastZombie", 1, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blueInt, FFMTColor.redInt, Nanotech_mod.Fastzombiechance, Nanotech_mod.Fastzombiemin, Nanotech_mod.Fastzombiemax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}

		if (Nanotech_mod.Superskeleton)
		{
			FFMTEntityHelper.addMob(MobSuperSkeleton.class, "SuperSkeleton", "SuperSkeleton", 2, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.whiteInt, FFMTColor.yellowInt, Nanotech_mod.Superskeletonchance, Nanotech_mod.Superskeletonmin, Nanotech_mod.Superskeletonmax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}

		if (Nanotech_mod.Supercreeper)
		{
			FFMTEntityHelper.addMob(MobSuperCreeper.class, "SuperCreeper", "SuperCreeper", 4, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.greenInt, FFMTColor.redInt, Nanotech_mod.Supercreeperchance, Nanotech_mod.Supercreepermin, Nanotech_mod.Supercreepermax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}

		if (Nanotech_mod.Superenderman)
		{
			FFMTEntityHelper.addMob(MobSuperEnderman.class, "SuperEnderman", "SuperEnderman", 5, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blackInt, FFMTColor.grayGuiInt, Nanotech_mod.Superendermanchance, Nanotech_mod.Superendermanmin, Nanotech_mod.Superendermanmax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);	
		}

		if (Nanotech_mod.Creeperdriller)
		{
			FFMTEntityHelper.addMob(MobCreeperDriller.class, "CreeperDriller", "CreeperDriller", 6, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.orangeInt, FFMTColor.redInt, Nanotech_mod.Creeperdrillerchance, Nanotech_mod.Creeperdrillermin, Nanotech_mod.Creeperdrillermax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);	
		}

		if (Nanotech_mod.TheDeath)
		{
			FFMTEntityHelper.addMob(MobThedeath.class, "TheDeath", "TheDeath", 7, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blackInt, FFMTColor.whiteInt, 0, 0, 0, EnumCreatureType.monster);	
		}

		if (Nanotech_mod.Fly)
		{
			FFMTEntityHelper.addMob(MobFly.class, "Fly", "Fly", 8, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.grayGuiInt, FFMTColor.blackInt, Nanotech_mod.Flychance, Nanotech_mod.Flymin, Nanotech_mod.Flymax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, Nanotech_mod.Nanotechbiome);
		}

		if (Nanotech_mod.Flyingcreeper)
		{
			FFMTEntityHelper.addMob(MobFlyingCreeper.class, "FlyingCreeper", "FlyingCreeper", 9, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.greenInt, FFMTColor.redInt, Nanotech_mod.Flyingcreeperchance, Nanotech_mod.Flyingcreepermin, Nanotech_mod.Flyingcreepermax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}
	}

}
