package fr.mcnanotech.kevin_68.nanotech_mod.entity.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Mob_fastzombie extends EntityMob
{
    public Mob_fastzombie(World par1World)
    {
        super(par1World);
        this.texture = "/mob/zombie.png";
        this.moveSpeed = 1.00F;
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, Mob_thedeath.class, 6.0F, 0.25F, 1.0F));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
        this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, this.moveSpeed, false));
        this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 40.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 40.0F, 0, true));
    }

    public int getMaxHealth()
    {
        return 2;
    }
    protected void fall(float par1) {}
    
    public int getAttackStrength(Entity par1Entity)
    {
        ItemStack var2 = this.getHeldItem();
        int var3 = 1;

        if (var2 != null)
        {
            var3 += var2.getDamageVsEntity(this);
        }

        return var3;
    }

    public int getTotalArmorValue()
    {
        return 3;
    }

    protected boolean isAIEnabled()
    {
        return true;
    }

    public void onLivingUpdate()
    {
        for (int k = 0; k < 2; k++)
                {
                    worldObj.spawnParticle("portal", posX + (rand.nextDouble() - 0.5D) * (double)width, (posY + rand.nextDouble() * (double)height) - 0.25D, posZ + (rand.nextDouble() - 0.5D) * (double)width, (rand.nextDouble() - 0.5D) * 2D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2D);
                }

        super.onLivingUpdate();
    }

    protected String getLivingSound()
    {
        return "mob.zombie.say";
    }

    protected String getHurtSound()
    {
        return "mob.zombiehurt";
    }

    protected String getDeathSound()
    {
        return "mob.zombiedead";
    }
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }
    /**
    protected int getDropItemId()
    {
        return Nanotech_mod.Item_edibleflesh.itemID;
    }
*/
    protected void dropRareDrop(int par1)
    {
        switch (this.rand.nextInt(4))
        {
            case 0:
                this.dropItem(Item.swordSteel.itemID, 1);
                break;
            case 1:
                this.dropItem(Item.helmetDiamond.itemID, 1);
                break;
            case 2:
                this.dropItem(Item.ingotGold.itemID, 1);
                break;
            case 3:
                this.dropItem(Item.shovelDiamond.itemID, 1);
                break;
        }
    }
}
