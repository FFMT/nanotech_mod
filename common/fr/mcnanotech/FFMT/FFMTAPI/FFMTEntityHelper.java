package fr.mcnanotech.FFMT.FFMTAPI;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fr.mcnanotech.FFMT.FFMTAPI.Interfaces.IsWorking;
import fr.mcnanotech.FFMT.FFMTAPI.Interfaces.UnknownTestStatus;


/**
 * @authors kevin_68, elias54
 */
public class FFMTEntityHelper 
{
	
	/**
	 * Spawn smoke particles(ENTITY ONLY)
	 * @param speed
	 * @param entity
	 * @param velX
	 * @param velY
	 * @param velZ
	 */
	@UnknownTestStatus
	public static void spawnSmokeParticles(int speed, EntityLiving entity, double velX, double velY, double velZ)
	{
		for(int i = 0; i < speed; i++)
		{
			entity.worldObj.spawnParticle("smoke", entity.posX, entity.posY, entity.posZ, velX, velY, velZ);
		}
	}

	/**
	 * Spawn smoke particles(ENTITY ONLY)
	 * @param speed
	 * @param entity
	 * @param velX
	 * @param velY
	 * @param velZ
	 * @param xPosition (If not specified, by default is 0)
	 * @param yPosition	(If not specified, by default is 0)
	 * @param zPosition (If not specified, by default is 0)
	 */
	@UnknownTestStatus
	public static void spawnSmokeParticles(int speed, EntityLiving entity, double xVel, double yVel, double zVel, double xPosition, double yPosition, double zPosition)
	{
		for(int i = 0; i < speed; i++)
		{
			entity.worldObj.spawnParticle("smoke", entity.posX + xPosition, entity.posY + yPosition, entity.posZ + zPosition, xVel, yVel, zVel);
		}
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
//Separator
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Add another entity other than mob
	 * @param entityClass (The entity class)
	 * @param entityName (The entity name)
	 * @param id (The entity ID)
	 * @param mod (Mod instance)
	 * @param trackingRange (Number of tracking range)
	 * @param updateFrequency (Number update frequency)
	 * @param sendsVelocityUpdates (Send velocity updates or not)
	 */
	@UnknownTestStatus
	public static void addOtherEntity(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
//Separator
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Add a mob too easy
	 * @param entityClass (The entity class)
	 * @param entityName (The entity name)
	 * @param id (The entity ID)
	 * @param mod (Mod instance)
	 * @param trackingRange (Number of tracking range)
	 * @param updateFrequency (Number update frequency)
	 * @param sendsVelocityUpdates (Send velocity updates or not)
	 * @param backGroundEggColour (Background egg color)
	 * @param foreGroundEggColour (Foreground egg color)
	 * @param weightedProb (Chance to spawn)
	 * @param minSpawn (Minimum spawn per chunk)
	 * @param maxSpawn (Maximum spawn per chunk)
	 */
	@IsWorking
	public static void addMob(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int backGroundEggColour, int foreGroundEggColour, int weightedProb, int minSpawn, int maxSpawn, EnumCreatureType creatureType)
	{
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, EntityRegistry.findGlobalUniqueEntityId(), backGroundEggColour, foreGroundEggColour);
		EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
		EntityRegistry.addSpawn(entityName, weightedProb, minSpawn, maxSpawn, creatureType);
	}
	
	/**
	 * Add a mob too easy
	 * @param entityClass (The entity class)
	 * @param entityName (The entity name)
	 * @param id (The entity ID)
	 * @param mod (Mod instance)
	 * @param trackingRange (Number of tracking range)
	 * @param updateFrequency (Number update frequency)
	 * @param sendsVelocityUpdates (Send velocity updates or not)
	 * @param backGroundEggColour (Background egg color)
	 * @param foreGroundEggColour (Foreground egg color)
	 * @param weightedProb (Chance to spawn)
	 * @param minSpawn (Minimum spawn per chunk)
	 * @param maxSpawn (Maximum spawn per chunk)
	 * @param biome (Biome where you want to spawn the mob)(If not specified, this mob doesn't spawn naturally)
	 */
	@IsWorking
	public static void addMob(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int backGroundEggColour, int foreGroundEggColour, int weightedProb, int minSpawn, int maxSpawn, EnumCreatureType creatureType, BiomeGenBase... biome)
	{
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, EntityRegistry.findGlobalUniqueEntityId(), backGroundEggColour, foreGroundEggColour);
		EntityRegistry.registerModEntity(entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
		EntityRegistry.addSpawn(entityName, weightedProb, minSpawn, maxSpawn, creatureType, biome);
	}
}
