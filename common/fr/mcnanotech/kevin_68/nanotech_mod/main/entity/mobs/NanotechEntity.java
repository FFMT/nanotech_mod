package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import java.util.Calendar;
import java.util.Date;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntityReinforcedFishingHook;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntitySatelite;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntitySuperBottleOfXp;
import fr.mcnanotech.kevin_68.nanotech_mod.main.other.NanotechOther;
import fr.minecraftforgefrance.ffmtlibs.FFMTColor;
import fr.minecraftforgefrance.ffmtlibs.entityhelper.FFMTEntityHelper;

public class NanotechEntity
{
	public static void mobs()
	{
		if(NanotechMod.superZombieProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperZombie.class, "SuperZombie", 0, NanotechMod.modInstance, 100, 1, true, FFMTColor.BLUE, FFMTColor.RED, NanotechMod.superZombieProb, NanotechMod.superZombieMin, NanotechMod.superZombieMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechMod.fastZombieProb != 0)
		{
			FFMTEntityHelper.addMob(MobFastZombie.class, "FastZombie", 1, NanotechMod.modInstance, 100, 1, true, FFMTColor.BLUE, FFMTColor.RED, NanotechMod.fastZombieProb, NanotechMod.fastZombieMin, NanotechMod.fastZombieMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechMod.superSkeletonProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperSkeleton.class, "SuperSkeleton", 2, NanotechMod.modInstance, 100, 1, true, FFMTColor.WHITE, FFMTColor.YELLOW, NanotechMod.superSkeletonProb, NanotechMod.superSkeletonMin, NanotechMod.superSkeletonMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechMod.superCreeperProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperCreeper.class, "SuperCreeper", 4, NanotechMod.modInstance, 100, 1, true, FFMTColor.GREEN, FFMTColor.RED, NanotechMod.superCreeperProb, NanotechMod.superCreeperMin, NanotechMod.superCreeperMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechMod.superEndermanProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperEnderman.class, "SuperEnderman", 5, NanotechMod.modInstance, 100, 1, true, FFMTColor.BLACK, FFMTColor.GRAY, NanotechMod.superEndermanProb, NanotechMod.superEndermanMin, NanotechMod.superEndermanMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechMod.creeperDrillerProb != 0)
		{
			FFMTEntityHelper.addMob(MobCreeperDriller.class, "CreeperDriller", 6, NanotechMod.modInstance, 100, 1, true, FFMTColor.ORANGE, FFMTColor.RED, NanotechMod.creeperDrillerProb, NanotechMod.creeperDrillerMin, NanotechMod.creeperDrillerMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechMod.theDeathSpawn)
		{
			FFMTEntityHelper.addMob(MobThedeath.class, "TheDeath", 7, NanotechMod.modInstance, 100, 1, true, FFMTColor.BLACK, FFMTColor.WHITE, 0, 0, 0, EnumCreatureType.monster);
		}

		if(NanotechMod.flyProb != 0)
		{
			FFMTEntityHelper.addMob(MobFly.class, "Fly", 8, NanotechMod.modInstance, 100, 1, true, FFMTColor.GRAY, FFMTColor.BLACK, NanotechMod.flyProb, NanotechMod.flyMin, NanotechMod.flyMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, NanotechOther.nanotechBiome);
		}

		if(NanotechMod.flyingCreeperProb != 0)
		{
			FFMTEntityHelper.addMob(MobFlyingCreeper.class, "FlyingCreeper", 9, NanotechMod.modInstance, 100, 1, true, FFMTColor.GREEN, FFMTColor.RED, NanotechMod.flyingCreeperProb, NanotechMod.flyingCreeperMin, NanotechMod.flyingCreeperMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechMod.crazyGuyProb != 0)
		{
			FFMTEntityHelper.addMob(MobCrazyGuy.class, "CrazyGuy", 10, NanotechMod.modInstance, 100, 1, true, FFMTColor.RED, FFMTColor.YELLOW, NanotechMod.crazyGuyProb, NanotechMod.crazyGuyMin, NanotechMod.crazyGuyMax, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, NanotechOther.nanotechBiome);
		}
		
		if(NanotechMod.dancerProb != 0)
		{
			FFMTEntityHelper.addMob(MobDancer.class, "Dancer", 11, NanotechMod.modInstance, 100, 1, true, FFMTColor.AQUA, FFMTColor.GOLD, NanotechMod.dancerProb, NanotechMod.dancerMin, NanotechMod.dancerMax, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, NanotechOther.nanotechBiome);
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		if(calendar.get(2) + 1 == 10 && calendar.get(5) == 31)
		{
			EntityRegistry.addSpawn(MobSuperZombie.class, NanotechMod.superZombieProb, NanotechMod.superZombieMin, NanotechMod.superZombieMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobFastZombie.class, NanotechMod.fastZombieProb, NanotechMod.fastZombieMin, NanotechMod.fastZombieMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobSuperSkeleton.class, NanotechMod.superSkeletonProb, NanotechMod.superSkeletonMin, NanotechMod.superSkeletonMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobSuperCreeper.class, NanotechMod.superCreeperProb, NanotechMod.superCreeperMin, NanotechMod.superCreeperMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobSuperEnderman.class, NanotechMod.superEndermanProb, NanotechMod.superEndermanMin, NanotechMod.superEndermanMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobCreeperDriller.class, NanotechMod.creeperDrillerProb, NanotechMod.creeperDrillerMin, NanotechMod.creeperDrillerMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobFlyingCreeper.class, NanotechMod.flyingCreeperProb, NanotechMod.flyingCreeperMin, NanotechMod.flyingCreeperMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);

			System.out.println("It's halloween, monster are coming");
		}

	}

	public static void otherEntity()
	{
		EntityRegistry.registerGlobalEntityID(EntityReinforcedFishingHook.class, "EntityReinforcedFishingHook", 2048);
		EntityRegistry.registerGlobalEntityID(EntitySuperBottleOfXp.class, "EntitySuperBottleOfXp", 2049);
		EntityRegistry.registerModEntity(EntitySatelite.class, "Satelite", 1520, NanotechMod.modInstance, 250, 1, true);
	}

}