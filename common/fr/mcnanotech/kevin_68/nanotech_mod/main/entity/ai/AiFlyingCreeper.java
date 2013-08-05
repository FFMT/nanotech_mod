package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobFlyingCreeper;

public class AiFlyingCreeper extends EntityAIBase
{
	MobFlyingCreeper swellingCreeper;

	EntityLiving creeperAttackTarget;

	public AiFlyingCreeper(MobFlyingCreeper mob)
	{
		this.swellingCreeper = mob;
		this.setMutexBits(1);
	}

	public boolean shouldExecute()
	{
		EntityLiving var1 = this.swellingCreeper.getAttackTarget();
		return this.swellingCreeper.getCreeperState() > 0 || var1 != null && this.swellingCreeper.getDistanceSqToEntity(var1) < 9.0D;
	}

	public void startExecuting()
	{
		this.swellingCreeper.getNavigator().clearPathEntity();
		this.creeperAttackTarget = this.swellingCreeper.getAttackTarget();
	}

	public void resetTask()
	{
		this.creeperAttackTarget = null;
	}

	public void updateTask()
	{
		if(this.creeperAttackTarget == null)
		{
			this.swellingCreeper.setCreeperState(-1);
		}
		else if(this.swellingCreeper.getDistanceSqToEntity(this.creeperAttackTarget) > 49.0D)
		{
			this.swellingCreeper.setCreeperState(-1);
		}
		else if(!this.swellingCreeper.getEntitySenses().canSee(this.creeperAttackTarget))
		{
			this.swellingCreeper.setCreeperState(-1);
		}
		else
		{
			this.swellingCreeper.setCreeperState(1);
		}
	}
}
