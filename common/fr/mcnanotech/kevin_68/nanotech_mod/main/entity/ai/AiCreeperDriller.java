package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs.MobCreeperDriller;

public class AiCreeperDriller extends EntityAIBase
{
	MobCreeperDriller swellingCreeper;
	EntityLivingBase creeperAttackTarget;

	public AiCreeperDriller(MobCreeperDriller mob)
	{
		swellingCreeper = mob;
		setMutexBits(1);
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
		creeperAttackTarget = null;
	}

	public void updateTask()
	{
		if(creeperAttackTarget == null)
		{
			swellingCreeper.setCreeperState(-1);
		}
		else if(swellingCreeper.getDistanceSqToEntity(creeperAttackTarget) > 49.0D)
		{
			swellingCreeper.setCreeperState(-1);
		}
		else if(!swellingCreeper.getEntitySenses().canSee(creeperAttackTarget))
		{
			swellingCreeper.setCreeperState(-1);
		}
		else
		{
			swellingCreeper.setCreeperState(1);
		}
	}
}
