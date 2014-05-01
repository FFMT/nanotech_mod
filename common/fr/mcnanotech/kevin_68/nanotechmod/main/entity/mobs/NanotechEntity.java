/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs;

import java.util.Calendar;
import java.util.Date;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.others.EntityReinforcedFishingHook;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.others.EntitySatelite;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.others.EntitySuperBottleOfXp;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechConfiguration;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechOther;
import fr.minecraftforgefrance.ffmtlibs.FFMTColor;
import fr.minecraftforgefrance.ffmtlibs.entity.FFMTEntityHelper;

public class NanotechEntity
{
	public static void initEntities()
	{
		if(NanotechConfiguration.superZombieProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperZombie.class, "SuperZombie", 0, NanotechMod.modInstance, 100, 1, true, FFMTColor.BLUE, FFMTColor.RED, NanotechConfiguration.superZombieProb, NanotechConfiguration.superZombieMin, NanotechConfiguration.superZombieMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechConfiguration.fastZombieProb != 0)
		{
			FFMTEntityHelper.addMob(MobFastZombie.class, "FastZombie", 1, NanotechMod.modInstance, 100, 1, true, FFMTColor.BLUE, FFMTColor.RED, NanotechConfiguration.fastZombieProb, NanotechConfiguration.fastZombieMin, NanotechConfiguration.fastZombieMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechConfiguration.superSkeletonProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperSkeleton.class, "SuperSkeleton", 2, NanotechMod.modInstance, 100, 1, true, FFMTColor.WHITE, FFMTColor.YELLOW, NanotechConfiguration.superSkeletonProb, NanotechConfiguration.superSkeletonMin, NanotechConfiguration.superSkeletonMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechConfiguration.superCreeperProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperCreeper.class, "SuperCreeper", 4, NanotechMod.modInstance, 100, 1, true, FFMTColor.GREEN, FFMTColor.RED, NanotechConfiguration.superCreeperProb, NanotechConfiguration.superCreeperMin, NanotechConfiguration.superCreeperMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechConfiguration.superEndermanProb != 0)
		{
			FFMTEntityHelper.addMob(MobSuperEnderman.class, "SuperEnderman", 5, NanotechMod.modInstance, 100, 1, true, FFMTColor.BLACK, FFMTColor.GRAY, NanotechConfiguration.superEndermanProb, NanotechConfiguration.superEndermanMin, NanotechConfiguration.superEndermanMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechConfiguration.creeperDrillerProb != 0)
		{
			FFMTEntityHelper.addMob(MobCreeperDriller.class, "CreeperDriller", 6, NanotechMod.modInstance, 100, 1, true, FFMTColor.ORANGE, FFMTColor.RED, NanotechConfiguration.creeperDrillerProb, NanotechConfiguration.creeperDrillerMin, NanotechConfiguration.creeperDrillerMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechConfiguration.theDeathSpawn)
		{
			FFMTEntityHelper.addMob(MobThedeath.class, "TheDeath", 7, NanotechMod.modInstance, 100, 1, true, FFMTColor.BLACK, FFMTColor.WHITE, 0, 0, 0, EnumCreatureType.monster);
		}

		if(NanotechConfiguration.flyProb != 0)
		{
			FFMTEntityHelper.addMob(MobFly.class, "Fly", 8, NanotechMod.modInstance, 100, 1, true, FFMTColor.GRAY, FFMTColor.BLACK, NanotechConfiguration.flyProb, NanotechConfiguration.flyMin, NanotechConfiguration.flyMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, NanotechOther.nanotechBiome);
		}

		if(NanotechConfiguration.flyingCreeperProb != 0)
		{
			FFMTEntityHelper.addMob(MobFlyingCreeper.class, "FlyingCreeper", 9, NanotechMod.modInstance, 100, 1, true, FFMTColor.GREEN, FFMTColor.RED, NanotechConfiguration.flyingCreeperProb, NanotechConfiguration.flyingCreeperMin, NanotechConfiguration.flyingCreeperMax, EnumCreatureType.monster, NanotechOther.nanotechBiome);
		}

		if(NanotechConfiguration.crazyGuyProb != 0)
		{
			FFMTEntityHelper.addMob(MobCrazyGuy.class, "CrazyGuy", 10, NanotechMod.modInstance, 100, 1, true, FFMTColor.RED, FFMTColor.YELLOW, NanotechConfiguration.crazyGuyProb, NanotechConfiguration.crazyGuyMin, NanotechConfiguration.crazyGuyMax, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, NanotechOther.nanotechBiome);
		}

		if(NanotechConfiguration.dancerProb != 0)
		{
			FFMTEntityHelper.addMob(MobDancer.class, "Dancer", 11, NanotechMod.modInstance, 100, 1, true, FFMTColor.AQUA, FFMTColor.GOLD, NanotechConfiguration.dancerProb, NanotechConfiguration.dancerMin, NanotechConfiguration.dancerMax, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills, NanotechOther.nanotechBiome);
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		if(calendar.get(2) + 1 == 10 && calendar.get(5) == 31)
		{
			EntityRegistry.addSpawn(MobSuperZombie.class, NanotechConfiguration.superZombieProb, NanotechConfiguration.superZombieMin, NanotechConfiguration.superZombieMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobFastZombie.class, NanotechConfiguration.fastZombieProb, NanotechConfiguration.fastZombieMin, NanotechConfiguration.fastZombieMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobSuperSkeleton.class, NanotechConfiguration.superSkeletonProb, NanotechConfiguration.superSkeletonMin, NanotechConfiguration.superSkeletonMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobSuperCreeper.class, NanotechConfiguration.superCreeperProb, NanotechConfiguration.superCreeperMin, NanotechConfiguration.superCreeperMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobSuperEnderman.class, NanotechConfiguration.superEndermanProb, NanotechConfiguration.superEndermanMin, NanotechConfiguration.superEndermanMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobCreeperDriller.class, NanotechConfiguration.creeperDrillerProb, NanotechConfiguration.creeperDrillerMin, NanotechConfiguration.creeperDrillerMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);
			EntityRegistry.addSpawn(MobFlyingCreeper.class, NanotechConfiguration.flyingCreeperProb, NanotechConfiguration.flyingCreeperMin, NanotechConfiguration.flyingCreeperMax, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.taiga, BiomeGenBase.swampland, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.beach, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.iceMountains, BiomeGenBase.jungleHills, BiomeGenBase.taigaHills);

			NanotechMod.nanoLogger.info("It's halloween, monster are coming");
		}

		EntityRegistry.registerGlobalEntityID(EntityReinforcedFishingHook.class, "EntityReinforcedFishingHook", 3250);// TODO
																														// fix
																														// id
		EntityRegistry.registerGlobalEntityID(EntitySuperBottleOfXp.class, "EntitySuperBottleOfXp", 3251);// TODO
																											// fix
																											// id
		EntityRegistry.registerModEntity(EntitySatelite.class, "Satelite", 1520, NanotechMod.modInstance, 250, 1, true);

	}
}