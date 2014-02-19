/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs;

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
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.ai.AiSuperCreeper;

public class MobSuperCreeper extends EntityMob
{
	private int lastActiveTime;
	private int timeSinceIgnited;
	private int field_82225_f = 30;
	private int explosionRadius = 2;// NanotechMod.explosionRadius; TODO fix

	public MobSuperCreeper(World world)
	{
		super(world);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new AiSuperCreeper(this));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, MobThedeath.class, 6.0F, 1.0D, 1.2D));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}

	public int func_82143_as()
	{
		return this.getAttackTarget() == null ? 3 : 3 + (int)(this.getHealth() - 1.0F);
	}

	@Override
	protected void fall(float damage)
	{
		super.fall(damage);
		this.timeSinceIgnited = (int)((float)this.timeSinceIgnited + damage * 1.5F);

		if(this.timeSinceIgnited > this.field_82225_f - 5)
		{
			this.timeSinceIgnited = this.field_82225_f - 5;
		}
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte)-1));
		this.dataWatcher.addObject(17, Byte.valueOf((byte)0));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeEntityToNBT(nbttagcompound);

		if(this.dataWatcher.getWatchableObjectByte(17) == 1)
		{
			nbttagcompound.setBoolean("powered", true);
		}

		nbttagcompound.setShort("Fuse", (short)this.field_82225_f);
		nbttagcompound.setByte("ExplosionRadius", (byte)this.explosionRadius);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readEntityFromNBT(nbttagcompound);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte)(nbttagcompound.getBoolean("powered") ? 1 : 0)));

		if(nbttagcompound.hasKey("Fuse"))
		{
			this.field_82225_f = nbttagcompound.getShort("Fuse");
		}

		if(nbttagcompound.hasKey("ExplosionRadius"))
		{
			this.explosionRadius = nbttagcompound.getByte("ExplosionRadius");
		}
	}

	@Override
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

			if(this.timeSinceIgnited >= this.field_82225_f)
			{
				this.timeSinceIgnited = this.field_82225_f;

				if(!this.worldObj.isRemote)
				{
					boolean var2 = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");

					if(this.getPowered())
					{
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)(this.explosionRadius * 2), var2);
					}
					else
					{
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, var2);
					}

					this.setDead();
				}
			}
		}

		super.onUpdate();
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.creeper.say";
	}

	@Override
	protected String getDeathSound()
	{
		return "mob.creeper.death";
	}

	@Override
	public void onDeath(DamageSource damagesource)
	{
		super.onDeath(damagesource);

		if(damagesource.getEntity() instanceof EntitySkeleton)
		{
			int i = Item.getIdFromItem(Items.record_13);
			int j = Item.getIdFromItem(Items.record_wait);
			int k = i + this.rand.nextInt(j - i + 1);
			this.dropItem(Item.getItemById(k), 1);
		}
	}

	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		return true;
	}

	public boolean getPowered()
	{
		return this.dataWatcher.getWatchableObjectByte(17) == 1;
	}

	@SideOnly(Side.CLIENT)
	public float setCreeperFlashTime(float par1)
	{
		return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * par1) / (float)(this.field_82225_f - 2);
	}

	@Override
	protected Item getDropItem()
	{
		return Items.gunpowder;
	}

	public int getCreeperState()
	{
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	public void setCreeperState(int par1)
	{
		this.dataWatcher.updateObject(16, Byte.valueOf((byte)par1));
	}

	@Override
	public void onStruckByLightning(EntityLightningBolt entitylightningbolt)
	{
		super.onStruckByLightning(entitylightningbolt);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte)1));
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

}
