package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import java.util.Calendar;
import java.util.Date;

import cpw.mods.fml.common.registry.EntityRegistry;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.minecraftforgefrance.ffmtlibs.FFMTColor;
import fr.minecraftforgefrance.ffmtlibs.entityhelper.FFMTEntityHelper;

public class NanotechMobs
{
	public static void mobs()
	{
		if(Nanotech_mod.superZombieProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperZombie.class, "SuperZombie", 0, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blueInt, FFMTColor.redInt, Nanotech_mod.superZombieProb, Nanotech_mod.superZombieMin, Nanotech_mod.superZombieMax, EnumCreatureType.monster, Nanotech_mod.nanotechBiome);
		}

		if(Nanotech_mod.fastZombieProb != 0)
		{
			FFMTEntityHelper.addMob(MobFastZombie.class, "FastZombie", 1, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blueInt, FFMTColor.redInt, Nanotech_mod.fastZombieProb, Nanotech_mod.fastZombieMin, Nanotech_mod.fastZombieMax, EnumCreatureType.monster, Nanotech_mod.nanotechBiome);
		}

		if(Nanotech_mod.superSkeletonProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperSkeleton.class, "SuperSkeleton", 2, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.whiteInt, FFMTColor.yellowInt, Nanotech_mod.superSkeletonProb, Nanotech_mod.superSkeletonMin, Nanotech_mod.superSkeletonMax, EnumCreatureType.monster, Nanotech_mod.nanotechBiome);
		}

		if(Nanotech_mod.superCreeperProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperCreeper.class, "SuperCreeper", 4, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.greenInt, FFMTColor.redInt, Nanotech_mod.superCreeperProb, Nanotech_mod.superCreeperMin, Nanotech_mod.superCreeperMax, EnumCreatureType.monster, Nanotech_mod.nanotechBiome);
		}

		if(Nanotech_mod.superEndermanProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperEnderman.class, "SuperEnderman", 5, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blackInt, FFMTColor.grayInt, Nanotech_mod.superEndermanProb, Nanotech_mod.superEndermanMin, Nanotech_mod.superEndermanMax, EnumCreatureType.monster, Nanotech_mod.nanotechBiome);
		}

		if(Nanotech_mod.creeperDrillerProb != 0)
		{
			FFMTEntityHelper.addMob(MobCreeperDriller.class, "CreeperDriller", 6, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.orangeInt, FFMTColor.redInt, Nanotech_mod.creeperDrillerProb, Nanotech_mod.creeperDrillerMin, Nanotech_mod.creeperDrillerMax, EnumCreatureType.monster, Nanotech_mod.nanotechBiome);
		}

		if(Nanotech_mod.theDeathSpawn)
		{
			FFMTEntityHelper.addMob(MobThedeath.class, "TheDeath", 7, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.blackInt, FFMTColor.whiteInt, 0, 0, 0, EnumCreatureType.monster);
		}

		if(Nanotech_mod.flyProb != 0)
		{
			FFMTEntityHelper.addMob(MobFly.class, "Fly", 8, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.grayInt, FFMTColor.blackInt, Nanotech_mod.flyProb, Nanotech_mod.flyMin, Nanotech_mod.flyMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, Nanotech_mod.nanotechBiome);
		}

		if(Nanotech_mod.flyingCreeperProb != 0)
		{
			FFMTEntityHelper.addMob(MobFlyingCreeper.class, "FlyingCreeper", 9, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.greenInt, FFMTColor.redInt, Nanotech_mod.flyingCreeperProb, Nanotech_mod.flyingCreeperMin, Nanotech_mod.flyingCreeperMax, EnumCreatureType.monster, Nanotech_mod.nanotechBiome);
		}

		if(Nanotech_mod.crazyGuyProb != 0)
		{
			FFMTEntityHelper.addMob(MobCrazyGuy.class, "CrazyGuy", 10, Nanotech_mod.modInstance, 100, 1, true, FFMTColor.redInt, FFMTColor.yellowInt, Nanotech_mod.crazyGuyProb, Nanotech_mod.crazyGuyMin, Nanotech_mod.crazyGuyMax, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, Nanotech_mod.nanotechBiome);
		}
		
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        
		if(calendar.get(2) + 1 == 10 && calendar.get(5) == 31)
		{
			EntityRegistry.addSpawn(MobSuperZombie.class, Nanotech_mod.superZombieProb, Nanotech_mod.superZombieMin, Nanotech_mod.superZombieMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobFastZombie.class, Nanotech_mod.fastZombieProb, Nanotech_mod.fastZombieMin, Nanotech_mod.fastZombieMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobSuperSkeleton.class, Nanotech_mod.superSkeletonProb, Nanotech_mod.superSkeletonMin, Nanotech_mod.superSkeletonMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobSuperCreeper.class, Nanotech_mod.superCreeperProb, Nanotech_mod.superCreeperMin, Nanotech_mod.superCreeperMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobSuperEnderman.class, Nanotech_mod.superEndermanProb, Nanotech_mod.superEndermanMin, Nanotech_mod.superEndermanMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobCreeperDriller.class, Nanotech_mod.creeperDrillerProb, Nanotech_mod.creeperDrillerMin, Nanotech_mod.creeperDrillerMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobFlyingCreeper.class, Nanotech_mod.flyingCreeperProb, Nanotech_mod.flyingCreeperMin, Nanotech_mod.flyingCreeperMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);	
			
			
			System.out.println("It's halloween, monster are coming");
		}
	
	}
	
}