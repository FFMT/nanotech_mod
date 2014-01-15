package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.ai.AiCreeperDriller;

public class MobCreeperDriller extends EntityMob
{
	private int lastActiveTime;

	private int timeSinceIgnited;
	private int fuseTime = 20;
	private int explosionRadius = 3;

	public MobCreeperDriller(World world)
	{
		super(world);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new AiCreeperDriller(this));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, MobThedeath.class, 6.0F, 1.0D, 1.2D));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
	}

	public int getMaxSafePointTries()
	{
		return this.getAttackTarget() == null ? 3 : 3 + (int)(this.getHealth() - 1.0F);
	}

	protected void fall(float damage)
	{
		super.fall(damage);
		this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + damage * 1.5F);

		if(this.timeSinceIgnited > this.fuseTime - 5)
		{
			this.timeSinceIgnited = this.fuseTime - 5;
		}
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte)-1));
		this.dataWatcher.addObject(17, Byte.valueOf((byte)0));
	}

	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeEntityToNBT(nbttagcompound);

		if(this.dataWatcher.getWatchableObjectByte(17) == 1)
		{
			nbttagcompound.setBoolean("powered", true);
		}

		nbttagcompound.setShort("Fuse", (short)this.fuseTime);
		nbttagcompound.setByte("ExplosionRadius", (byte)this.explosionRadius);
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readEntityFromNBT(nbttagcompound);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte)(nbttagcompound.getBoolean("powered") ? 1 : 0)));

		if(nbttagcompound.hasKey("Fuse"))
		{
			this.fuseTime = nbttagcompound.getShort("Fuse");
		}

		if(nbttagcompound.hasKey("ExplosionRadius"))
		{
			this.explosionRadius = nbttagcompound.getByte("ExplosionRadius");
		}
	}

	public void onLivingUpdate()
	{
		for(int k = 0; k < 2; k++)
		{
			worldObj.spawnParticle("portal", posX + (rand.nextDouble() - 0.5D) * (double)width, (posY + rand.nextDouble() * (double)height) - 0.25D, posZ + (rand.nextDouble() - 0.5D) * (double)width, (rand.nextDouble() - 0.5D) * 2D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2D);
		}
		super.onLivingUpdate();
	}

	public void onUpdate()
	{
		if(this.isEntityAlive())
		{
			this.lastActiveTime = this.timeSinceIgnited;
			int var1 = this.getCreeperState();

			if(var1 > 0 && this.timeSinceIgnited == 0)
			{
				this.worldObj.playSoundAtEntity(this, "random.fuse", 1.0F, 0.5F);
			}

			this.timeSinceIgnited += var1;

			if(this.timeSinceIgnited < 0)
			{
				this.timeSinceIgnited = 0;
			}

			if(this.timeSinceIgnited >= this.fuseTime)
			{
				this.timeSinceIgnited = this.fuseTime;

				if(!this.worldObj.isRemote)
				{
					boolean var2 = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");

					if(this.getPowered())
					{
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)(this.explosionRadius * 0.5), var2);
					}
					else
					{
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)(this.explosionRadius * 0.5), var2);
					}
					if(NanotechMod.multipleExplosion = false)
					{
						this.setDead();
					}
				}
			}
		}
		super.onUpdate();
	}

	protected String getLivingSound()
	{
		return "mob.creeper.say";
	}

	protected String getHurtSound()
	{
		return "mob.creeper.say";
	}

	protected String getDeathSound()
	{
		return "mob.creeper.death";
	}

	public void onDeath(DamageSource damageSource)
	{
		super.onDeath(damageSource);

		if(damageSource.getEntity() instanceof MobSuperSkeleton)
		{
			this.dropItem(Item.record13.itemID + this.rand.nextInt(10), 2);
		}
	}

	public boolean attackEntityAsMob(Entity entity)
	{
		return true;
	}

	public boolean getPowered()
	{
		return this.dataWatcher.getWatchableObjectByte(17) == 1;
	}

	@SideOnly(Side.CLIENT)
	public float setCreeperFlashTime(float time)
	{
		return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * time) / (float)(this.fuseTime - 2);
	}

	protected int getDropItemId()
	{
		return Item.gunpowder.itemID;
	}

	public int getCreeperState()
	{
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	public void setCreeperState(int par1)
	{
		this.dataWatcher.updateObject(16, Byte.valueOf((byte)par1));
	}

	public void onStruckByLightning(EntityLightningBolt entitylightninbolt)
	{
		super.onStruckByLightning(entitylightninbolt);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte)1));
	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}
}
