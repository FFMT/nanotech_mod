package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobCreeperforreur;

public class AiCreeperforreur extends EntityAIBase
{
	MobCreeperforreur swellingCreeper;
	EntityLiving creeperAttackTarget;

	public AiCreeperforreur(MobCreeperforreur mobcreeperforreur)
	{
		swellingCreeper = mobcreeperforreur;
		setMutexBits(1);
	}

	public boolean shouldExecute()
	{
		EntityLiving var1 = swellingCreeper.getAttackTarget();
		return swellingCreeper.getCreeperState() > 0 || var1 != null && swellingCreeper.getDistanceSqToEntity(var1) < 9.0D;
	}

	public void startExecuting()
	{
		swellingCreeper.getNavigator().clearPathEntity();
		creeperAttackTarget = swellingCreeper.getAttackTarget();
	}

	public void resetTask()
	{
		creeperAttackTarget = null;
	}

	public void updateTask()
	{
		if (creeperAttackTarget == null)
		{
			swellingCreeper.setCreeperState(-1);
		}
		else if (swellingCreeper.getDistanceSqToEntity(creeperAttackTarget) > 49.0D)
		{
			swellingCreeper.setCreeperState(-1);
		}
		else if (!swellingCreeper.getEntitySenses().canSee(creeperAttackTarget))
		{
			swellingCreeper.setCreeperState(-1);
		}
		else
		{
			swellingCreeper.setCreeperState(1);
		}
	}
}
