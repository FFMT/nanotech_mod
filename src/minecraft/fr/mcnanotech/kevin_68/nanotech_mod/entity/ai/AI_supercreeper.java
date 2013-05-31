
package fr.mcnanotech.kevin_68.nanotech_mod.entity.ai;

import fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs.Mob_supercreeper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class AI_supercreeper extends EntityAIBase
{

    Mob_supercreeper swellingCreeper;

    EntityLiving creeperAttackTarget;

    public AI_supercreeper(Mob_supercreeper par1Mob_supercreeper)
    {
        this.swellingCreeper = par1Mob_supercreeper;
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
        if (this.creeperAttackTarget == null)
        {
            this.swellingCreeper.setCreeperState(-1);
        }
        else if (this.swellingCreeper.getDistanceSqToEntity(this.creeperAttackTarget) > 49.0D)
        {
            this.swellingCreeper.setCreeperState(-1);
        }
        else if (!this.swellingCreeper.getEntitySenses().canSee(this.creeperAttackTarget))
        {
            this.swellingCreeper.setCreeperState(-1);
        }
        else
        {
            this.swellingCreeper.setCreeperState(1);
        }
    }
}
