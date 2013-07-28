package fr.mcnanotech.FFMT.FFMTAPI;

import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentThorns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * This class is useable to replace EntityMob (e.g EntityMyEntity extends FFMTEntityMobCustomized)
 * @author Fred (elias54)
 *
 */

public abstract class FFMTEntityMobCustomized extends EntityMob {

	public int entityPhases;
	public int bossStrength;
	public boolean isInvincible;
	
	/**
	 * Adding cape system to your mob
	 */
    public String capeLocation;
    public boolean hasCape;
    public float minCapeF;
    public float maxCapeF;
    public double capeD1;
    public double capeD2;
    public double capeD3;
    public double capeD4;
    public double capeD5;
    public double capeD6;
    
    protected static Random protectedRand = new Random();
    
	public FFMTEntityMobCustomized(World par1World) 
	{
		super(par1World);
		entityPhases = 0;
		bossStrength = 8;
		isInvincible = false;
		capeLocation = "";
		hasCape = false;
	}
	
	public void onEntityUpdate()
	{
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == 0)
        {
        	FFMTEntityHelper.spawnSmokeParticles(2, this, 0.0D, 0.5D, 0.0D);
            this.setDead();
        }
        updateCloakPosition();
		super.onUpdate();
	}
	
    public void console(String s)
    {
        System.out.println(s);
    }
	
	public abstract boolean isAnEntityBoss();
	
	public PathEntity betterPathEntityToEntity(Entity entity, Entity entityToFollow, float f)
	{
		return worldObj.getPathEntityToEntity(entity, entityToFollow, f, true, false, false, true);
	}
	
	// real name : goToEntity
    public void runMotherfucker(EntityLiving entityliving)
    {
        getNavigator().setPath(getNavigator().getPathToXYZ(entityliving.posX, entityliving.posY, entityliving.posZ), 50F);
    }
	
    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        if (this.isInvincible || this.isEntityInvulnerable())
        {
            return false;
        }else
        {
        	return super.attackEntityFrom(par1DamageSource, par2);
        }
    }

    public boolean attackEntityMob(Entity par1Entity)
    {
        int i = this.getAttackStrength(par1Entity);

        if (this.isPotionActive(Potion.damageBoost))
        {
            i += 3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier();
        }

        if (this.isPotionActive(Potion.weakness))
        {
            i -= 2 << this.getActivePotionEffect(Potion.weakness).getAmplifier();
        }

        int j = 0;

        if (par1Entity instanceof EntityLiving)
        {
            i += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLiving)par1Entity);
            j += EnchantmentHelper.getKnockbackModifier(this, (EntityLiving)par1Entity);
        }

        boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), i);

        if (flag)
        {
            if (j > 0)
            {
                par1Entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)j * 0.5F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }
            
            if(onGround)
            {
            	this.motionY *= 0.6D;
            }

            int k = EnchantmentHelper.getFireAspectModifier(this);

            if (k > 0)
            {
                par1Entity.setFire(k * 4);
            }

            if (par1Entity instanceof EntityLiving)
            {
                EnchantmentThorns.func_92096_a(this, (EntityLiving)par1Entity, this.rand);
            }
        }

        return flag;
    }

    public void getPathOrWalkableBlock(Entity entity, float f)
    {
        PathEntity pathentity = worldObj.getPathEntityToEntity(this, entity, 16F, false, false, false, false);

        if (pathentity == null && f > 12F)
        {
            int i = MathHelper.floor_double(entity.posX) - 2;
            int j = MathHelper.floor_double(entity.posZ) - 2;
            int k = MathHelper.floor_double(entity.boundingBox.minY);

            for (int l = 0; l <= 4; l++)
            {
                for (int i1 = 0; i1 <= 4; i1++)
                {
                    if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && worldObj.isBlockOpaqueCube(i + l, k - 1, j + i1) && !worldObj.isBlockOpaqueCube(i + l, k, j + i1) && !worldObj.isBlockOpaqueCube(i + l, k + 1, j + i1))
                    {
                        setLocationAndAngles((float)(i + l) + 0.5F, k, (float)(j + i1) + 0.5F, rotationYaw, rotationPitch);
                        return;
                    }
                }
            }
        }
        else
        {
            setPathToEntity(pathentity);
        }
    }

    public void pathToXYZ(double d, double d1, double d2, float f)
    {
        PathEntity pathentity = worldObj.getEntityPathToXYZ(this, (int)d, (int)d1, (int)d2, f, false, false, false, false);

        if (pathentity == null && f > 12F)
        {
            int i = MathHelper.floor_double(posX) - 2;
            int j = MathHelper.floor_double(posZ) - 2;
            int k = MathHelper.floor_double(boundingBox.minY);

            for (int l = 0; l <= 4; l++)
            {
                for (int i1 = 0; i1 <= 4; i1++)
                {
                    if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && worldObj.isBlockOpaqueCube(i + l, k - 1, j + i1) && !worldObj.isBlockOpaqueCube(i + l, k, j + i1) && !worldObj.isBlockOpaqueCube(i + l, k + 1, j + i1))
                    {
                        return;
                    }
                }
            }
        }
        else
        {
            setPathToEntity(pathentity);
        }
    }
    
    public void setCape(String s)
    {
    	hasCape = true;
    	capeLocation = s;
    }
    
    public void setCape(String s, int i)
    {
        if (i > 0)
        {
            if (rand.nextInt(i) == 0)
            {
                hasCape = true;
                capeLocation = s;
            }
        }
        else
        {
            hasCape = true;
            capeLocation = s;
        }
    }
    
    public void onLivingUpdate()
    {
        if (capeLocation != "")
        {
            minCapeF = maxCapeF;
        }
    }
    
    public void selfControl()
    {
        if (entityToAttack == this)
        {
            entityToAttack = null;
        }
    }
    
    public void updateCloakPosition()
    {
        if (capeLocation != "")
        {
            capeD1 = capeD4;
            capeD2 = capeD5;
            capeD3 = capeD6;
            double d = posX - capeD4;
            double d1 = posY - capeD5;
            double d2 = posZ - capeD6;
            double d3 = 10D;

            if (d > d3)
            {
                capeD1 = capeD4 = posX;
            }

            if (d2 > d3)
            {
                capeD3 = capeD6 = posZ;
            }

            if (d1 > d3)
            {
                capeD2 = capeD5 = posY;
            }

            if (d < -d3)
            {
                capeD1 = capeD4 = posX;
            }

            if (d2 < -d3)
            {
                capeD3 = capeD6 = posZ;
            }

            if (d1 < -d3)
            {
                capeD2 = capeD5 = posY;
            }

            capeD4 += d * 0.25D;
            capeD6 += d2 * 0.25D;
            capeD5 += d1 * 0.25D;
        }
    }
    
    
    /**
     * Basic mob attack. Default to touch of death in EntityCreature. Overridden by each mob to define their attack.
     */
    protected void attackEntity(Entity par1Entity, float par2)
    {
        if (this.attackTime <= 0 && par2 < 2.0F && par1Entity.boundingBox.maxY > this.boundingBox.minY && par1Entity.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            this.attackEntityMob(par1Entity);
            FFMTEntityHelper.spawnSmokeParticles(2, this, 0.0D, 0.2D, 0.0D, par1Entity.posX, par1Entity.posY + 1, par1Entity.posZ);
        }
        if(onGround)
        {
        	this.motionY *= 0.5D;
        }
        if(this.isAnEntityBoss())
        {
	        double d = par1Entity.motionX - this.motionX;
	        double d1 = par1Entity.motionZ - this.motionZ;
	        double d2 = par1Entity.motionY - this.motionY;
	        if(par1Entity.onGround)
	        {
	        	par1Entity.moveEntity(d, d2, d1);
	        }
        }
    }
	
}
