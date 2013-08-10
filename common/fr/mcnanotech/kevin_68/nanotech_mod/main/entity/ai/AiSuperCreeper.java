package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobSuperCreeper;

public class AiSuperCreeper extends EntityAIBase
{
	MobSuperCreeper swellingCreeper;
	EntityLivingBase creeperAttackTarget;

	public AiSuperCreeper(MobSuperCreeper mob)
	{
		this.swellingCreeper = mob;
		this.setMutexBits(1);
	}

    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.swellingCreeper.getAttackTarget();
        return this.swellingCreeper.getCreeperState() > 0 || entitylivingbase != null && this.swellingCreeper.getDistanceSqToEntity(entitylivingbase) < 9.0D;
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
