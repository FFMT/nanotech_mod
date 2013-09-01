package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.minecraftforgefrance.ffmtapi.FFMTColor;
import fr.minecraftforgefrance.ffmtapi.FFMTEntityHelper;

public class NanotechMobs
{
	public static void mobs()
	{
		if(Nanotech_mod.SuperZombie)
		{
			FFMTEntityHelper.addMob(MobSuperZombie.class, "SuperZombie", 0, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blueInt, FFMTColor.redInt, Nanotech_mod.SuperZombieProb, Nanotech_mod.SuperZombieMin, Nanotech_mod.SuperZombieMax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}

		if(Nanotech_mod.FastZombie)
		{
			FFMTEntityHelper.addMob(MobFastzombie.class, "FastZombie", 1, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blueInt, FFMTColor.redInt, Nanotech_mod.FastZombieProb, Nanotech_mod.FastZombieMin, Nanotech_mod.FastZombieMax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}

		if(Nanotech_mod.SuperSkeleton)
		{
			FFMTEntityHelper.addMob(MobSuperSkeleton.class, "SuperSkeleton", 2, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.whiteInt, FFMTColor.yellowInt, Nanotech_mod.SuperSkeletonProb, Nanotech_mod.SuperSkeletonMin, Nanotech_mod.SuperSkeletonMax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}

		if(Nanotech_mod.SuperCreeper)
		{
			FFMTEntityHelper.addMob(MobSuperCreeper.class, "SuperCreeper", 4, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.greenInt, FFMTColor.redInt, Nanotech_mod.SuperCreeperProb, Nanotech_mod.SuperCreeperMin, Nanotech_mod.SuperCreeperMax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}

		if(Nanotech_mod.SuperEnderman)
		{
			FFMTEntityHelper.addMob(MobSuperEnderman.class, "SuperEnderman", 5, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blackInt, FFMTColor.grayInt, Nanotech_mod.SuperEndermanProb, Nanotech_mod.SuperEndermanMin, Nanotech_mod.SuperEndermanMax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}

		if(Nanotech_mod.CreeperDriller)
		{
			FFMTEntityHelper.addMob(MobCreeperDriller.class, "CreeperDriller", 6, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.orangeInt, FFMTColor.redInt, Nanotech_mod.CreeperDrillerProb, Nanotech_mod.CreeperDrillerMin, Nanotech_mod.CreeperDrillerMax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}

		if(Nanotech_mod.TheDeath)
		{
			FFMTEntityHelper.addMob(MobThedeath.class, "TheDeath", 7, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blackInt, FFMTColor.whiteInt, 0, 0, 0, EnumCreatureType.monster);
		}

		if(Nanotech_mod.Fly)
		{
			FFMTEntityHelper.addMob(MobFly.class, "Fly", 8, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.grayInt, FFMTColor.blackInt, Nanotech_mod.FlyProb, Nanotech_mod.FlyMin, Nanotech_mod.FlyMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, Nanotech_mod.Nanotechbiome);
		}

		if(Nanotech_mod.FlyingCreeper)
		{
			FFMTEntityHelper.addMob(MobFlyingCreeper.class, "FlyingCreeper", 9, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.greenInt, FFMTColor.redInt, Nanotech_mod.FlyingCreeperProb, Nanotech_mod.FlyingCreeperMin, Nanotech_mod.FlyingCreeperMax, EnumCreatureType.monster, Nanotech_mod.Nanotechbiome);
		}

		if(Nanotech_mod.CrazyGuy)
		{
			FFMTEntityHelper.addMob(MobCrazyGuy.class, "CrazyGuy", 10, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.redInt, FFMTColor.yellowInt, Nanotech_mod.CrazyGuyProb, Nanotech_mod.CrazyGuyMin, Nanotech_mod.CrazyGuyMax, EnumCreatureType.creature, Nanotech_mod.Nanotechbiome);
		}
	}

}
