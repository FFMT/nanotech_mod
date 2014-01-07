package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MobDancer extends EntityAnimal
{
    public float field_70886_e;
    public float destPos;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i = 1.0F;
    public float ticks = 0;
    
    public MobDancer(World par1World)
    {
        super(par1World);
        this.setSize(0.3F, 1.8F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.10D);
    }
    
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		ticks++;
	}
   
    protected String getLivingSound()
    {
        return "";
    }

    protected String getHurtSound()
    {
        return "";
    }

    protected String getDeathSound()
    {
        return "";
    }

    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        this.playSound("", 0.15F, 1.0F);
    }

    protected int getDropItemId()
    {
        return 0;
    }

   /* protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);

        for (int k = 0; k < j; ++k)
        {
            this.dropItem(Item.feather.itemID, 1);
        }

        if (this.isBurning())
        {
            this.dropItem(Item.chickenCooked.itemID, 1);
        }
        else
        {
            this.dropItem(Item.chickenRaw.itemID, 1);
        }
    }*/

    public MobDancer spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new MobDancer(this.worldObj);
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }
}