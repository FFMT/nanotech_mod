package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
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
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.ai.AiCreeperDriller;

public class MobCreeperDriller extends EntityMob
{
	private int lastActiveTime;

	private int timeSinceIgnited;
	private int field_82225_f = 20;
	private int field_82226_g = 3;

	public MobCreeperDriller(World par1World)
	{
		super(par1World);
		this.texture = "/mods/Nanotech_mod/textures/mob/creeperforreur.png";
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new AiCreeperDriller(this));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, MobThedeath.class, 6.0F, 0.25F, 0.5F));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.25F, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.2F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	public int func_82143_as()
	{
		return this.getAttackTarget() == null ? 3 : 3 + (this.health - 1);
	}

	protected void fall(float par1)
	{
		super.fall(par1);
		this.timeSinceIgnited = (int) ((float) this.timeSinceIgnited + par1 * 1.5F);

		if (this.timeSinceIgnited > this.field_82225_f - 5)
		{
			this.timeSinceIgnited = this.field_82225_f - 5;
		}
	}

	public int getMaxHealth()
	{
		return 20;
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, Byte.valueOf((byte) -1));
		this.dataWatcher.addObject(17, Byte.valueOf((byte) 0));
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);

		if (this.dataWatcher.getWatchableObjectByte(17) == 1)
		{
			par1NBTTagCompound.setBoolean("powered", true);
		}

		par1NBTTagCompound.setShort("Fuse", (short) this.field_82225_f);
		par1NBTTagCompound.setByte("ExplosionRadius", (byte) this.field_82226_g);
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte) (par1NBTTagCompound.getBoolean("powered") ? 1 : 0)));

		if (par1NBTTagCompound.hasKey("Fuse"))
		{
			this.field_82225_f = par1NBTTagCompound.getShort("Fuse");
		}

		if (par1NBTTagCompound.hasKey("ExplosionRadius"))
		{
			this.field_82226_g = par1NBTTagCompound.getByte("ExplosionRadius");
		}
	}

	public void onLivingUpdate()
	{
		for (int k = 0; k < 2; k++)
		{
			worldObj.spawnParticle("portal", posX + (rand.nextDouble() - 0.5D) * (double) width, (posY + rand.nextDouble() * (double) height) - 0.25D, posZ + (rand.nextDouble() - 0.5D) * (double) width, (rand.nextDouble() - 0.5D) * 2D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2D);
		}
		super.onLivingUpdate();
	}

	public void onUpdate()
	{
		if (this.isEntityAlive())
		{
			this.lastActiveTime = this.timeSinceIgnited;
			int var1 = this.getCreeperState();

			if (var1 > 0 && this.timeSinceIgnited == 0)
			{
				this.worldObj.playSoundAtEntity(this, "random.fuse", 1.0F, 0.5F);
			}

			this.timeSinceIgnited += var1;

			if (this.timeSinceIgnited < 0)
			{
				this.timeSinceIgnited = 0;
			}

			if (this.timeSinceIgnited >= this.field_82225_f)
			{
				this.timeSinceIgnited = this.field_82225_f;

				if (!this.worldObj.isRemote)
				{
					boolean var2 = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");

					if (this.getPowered())
					{
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) (this.field_82226_g * 0.5), var2);
					}
					else
					{
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float) (this.field_82226_g * 0.5), var2);
					}
					if (Nanotech_mod.MultipleExplosion = false)
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

		if (damageSource.getEntity() instanceof MobSuperSkeleton)
		{
			this.dropItem(Item.record13.itemID + this.rand.nextInt(10), 2);
		}
	}

	public boolean attackEntityAsMob(Entity par1Entity)
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
		return ((float) this.lastActiveTime + (float) (this.timeSinceIgnited - this.lastActiveTime) * par1) / (float) (this.field_82225_f - 2);
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
		this.dataWatcher.updateObject(16, Byte.valueOf((byte) par1));
	}

	public void onStruckByLightning(EntityLightningBolt par1EntityLightningBolt)
	{
		super.onStruckByLightning(par1EntityLightningBolt);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte) 1));
	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}
}
