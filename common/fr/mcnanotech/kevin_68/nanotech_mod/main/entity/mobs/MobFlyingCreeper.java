package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import net.minecraft.entity.Entity;
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
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.ai.AiFlyingCreeper;

public class MobFlyingCreeper extends EntityMob
{

	private int lastActiveTime;
	private int timeSinceIgnited;
	private int fuseTime = 30;
	private int explosionRadius = 3;

	public MobFlyingCreeper(World world)
	{
		super(world);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new AiFlyingCreeper(this));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 0.25F, 0.3F));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, MobThedeath.class, 6.0F, 0.25F, 0.5F));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 0.25F, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.2F));
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
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.25D);
	}

	public int func_82143_as()
	{
		return this.getAttackTarget() == null ? 3 : 3 + (int)(this.getHealth() - 1.0F);
	}

	protected void fall(float damage)
	{}

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

	public void onUpdate()
	{
		if(this.isEntityAlive())
		{
			this.lastActiveTime = this.timeSinceIgnited;
			int var1 = this.getCreeperState();

			if(var1 > 0 && this.timeSinceIgnited == 0)
			{
				this.playSound("random.fuse", 1.0F, 0.5F);
			}

			if(this.timeSinceIgnited == 26)
			{
				this.motionY += 2.7;
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
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)(this.explosionRadius * 2.75), var2);
					}
					else
					{
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)(this.explosionRadius * 2.5), var2);
					}
				}
			}
		}

		super.onUpdate();
	}

	protected String getHurtSound()
	{
		return "mob.creeper.say";
	}

	protected String getDeathSound()
	{
		return "mob.creeper.death";
	}

	public void onDeath(DamageSource damagesource)
	{
		super.onDeath(damagesource);

		if(damagesource.getEntity() instanceof EntitySkeleton)
		{
			int var2 = Item.record13.itemID + this.rand.nextInt(Item.recordWait.itemID - Item.record13.itemID + 1);
			this.dropItem(var2, 1);
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
	public float getCreeperFlashIntensity(float par1)
	{
		return ((float)this.lastActiveTime + (float)(this.timeSinceIgnited - this.lastActiveTime) * par1) / (float)(this.fuseTime - 2);
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

	public void onStruckByLightning(EntityLightningBolt entitylightningbolt)
	{
		super.onStruckByLightning(entitylightningbolt);
		this.dataWatcher.updateObject(17, Byte.valueOf((byte)1));
	}
}
