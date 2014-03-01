/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.entity.others.EntityTheDeathBall;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechAchievement;

public class MobThedeath extends EntityMob implements IBossDisplayData, IRangedAttackMob
{
	private float[] field_82220_d = new float[2];
	private float[] field_82221_e = new float[2];
	private float[] field_82217_f = new float[2];
	private float[] field_82218_g = new float[2];
	private int[] field_82223_h = new int[2];
	private int[] field_82224_i = new int[2];
	private int field_82222_j;
	public int deathTicks = 0;

	private static final IEntitySelector attackEntitySelector = new IEntitySelector()
	{
		public boolean isEntityApplicable(Entity entity)
		{
			return entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
		}
	};

	public MobThedeath(World world)
	{
		super(world);
		this.setHealth(this.getMaxHealth());
		this.setSize(5F, 8.0F);
		this.isImmuneToFire = true;
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 40, 20.0F));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, false, attackEntitySelector));
		this.experienceValue = 50;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(17, new Integer(0));
		this.dataWatcher.addObject(18, new Integer(0));
		this.dataWatcher.addObject(19, new Integer(0));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public float getShadowSize()
	{
		return this.height / 8.0F;
	}

	@Override
	protected String getLivingSound()
	{
		return "nanotechmod:mob.thedeath.idle";
	}

	@Override
	protected String getHurtSound()
	{
		return "nanotechmod:mob.thedeath.hit";
	}

	@Override
	protected String getDeathSound()
	{
		return "nanotechmod:mob.thedeath.death";
	}

	@Override
	public void onLivingUpdate()
	{
		this.motionY *= 0.6000000238418579D;
		double d1;
		double d3;
		double d5;

		if(!this.worldObj.isRemote && this.getWatchedTargetId(0) > 0)
		{
			Entity entity = this.worldObj.getEntityByID(this.getWatchedTargetId(0));

			if(entity != null)
			{
				if(this.posY < entity.posY)
				{
					if(this.motionY < 0.0D)
					{
						this.motionY = 0.0D;
					}

					this.motionY += (0.5D - this.motionY) * 0.6000000238418579D;
				}

				double d0 = entity.posX - this.posX;
				d1 = entity.posZ - this.posZ;
				d3 = d0 * d0 + d1 * d1;

				if(d3 > 9.0D)
				{
					d5 = (double)MathHelper.sqrt_double(d3);
					this.motionX += (d0 / d5 * 0.5D - this.motionX) * 0.6000000238418579D;
					this.motionZ += (d1 / d5 * 0.5D - this.motionZ) * 0.6000000238418579D;
				}
			}
		}

		if(this.motionX * this.motionX + this.motionZ * this.motionZ > 0.05000000074505806D)
		{
			this.rotationYaw = (float)Math.atan2(this.motionZ, this.motionX) * (180F / (float)Math.PI) - 90.0F;
		}

		super.onLivingUpdate();
		int i;

		for(i = 0; i < 2; ++i)
		{
			this.field_82218_g[i] = this.field_82221_e[i];
			this.field_82217_f[i] = this.field_82220_d[i];
		}

		int j;

		for(i = 0; i < 2; ++i)
		{
			j = this.getWatchedTargetId(i + 1);
			Entity entity1 = null;

			if(j > 0)
			{
				entity1 = this.worldObj.getEntityByID(j);
			}

			if(entity1 != null)
			{
				d1 = this.func_82214_u(i + 1);
				d3 = this.func_82208_v(i + 1);
				d5 = this.func_82213_w(i + 1);
				double d6 = entity1.posX - d1;
				double d7 = entity1.posY + (double)entity1.getEyeHeight() - d3;
				double d8 = entity1.posZ - d5;
				double d9 = (double)MathHelper.sqrt_double(d6 * d6 + d8 * d8);
				float f = (float)(Math.atan2(d8, d6) * 180.0D / Math.PI) - 90.0F;
				float f1 = (float)(-(Math.atan2(d7, d9) * 180.0D / Math.PI));
				this.field_82220_d[i] = this.func_82204_b(this.field_82220_d[i], f1, 40.0F);
				this.field_82221_e[i] = this.func_82204_b(this.field_82221_e[i], f, 10.0F);
			}
			else
			{
				this.field_82221_e[i] = this.func_82204_b(this.field_82221_e[i], this.renderYawOffset, 10.0F);
			}
		}

		for(j = 0; j < 3; ++j)
		{
			double d10 = this.func_82214_u(j);
			double d2 = this.func_82208_v(j);
			double d4 = this.func_82213_w(j);
			this.worldObj.spawnParticle("smoke", d10 + this.rand.nextGaussian() * 0.30000001192092896D, d2 + this.rand.nextGaussian() * 0.30000001192092896D, d4 + this.rand.nextGaussian() * 0.30000001192092896D, 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public ItemStack getHeldItem()
	{
		return(new ItemStack(NanotechItem.scythe));
	}

	@Override
	protected void updateAITasks()
	{
		int i;

		super.updateAITasks();
		int i1;

		for(i = 1; i < 3; ++i)
		{
			if(this.ticksExisted >= this.field_82223_h[i - 1])
			{
				this.field_82223_h[i - 1] = this.ticksExisted + 10 + this.rand.nextInt(10);

				if(this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD)
				{
					int k2 = i - 1;
					int l2 = this.field_82224_i[i - 1];
					this.field_82224_i[k2] = this.field_82224_i[i - 1] + 1;

					if(l2 > 15)
					{
						float f = 10.0F;
						float f1 = 5.0F;
						double d0 = MathHelper.getRandomDoubleInRange(this.rand, this.posX - (double)f, this.posX + (double)f);
						double d1 = MathHelper.getRandomDoubleInRange(this.rand, this.posY - (double)f1, this.posY + (double)f1);
						double d2 = MathHelper.getRandomDoubleInRange(this.rand, this.posZ - (double)f, this.posZ + (double)f);
						this.func_82209_a(i + 1, d0, d1, d2, true);
						this.field_82224_i[i - 1] = 0;
					}
				}

				i1 = this.getWatchedTargetId(i);

				if(i1 > 0)
				{
					Entity entity = this.worldObj.getEntityByID(i1);

					if(entity != null && entity.isEntityAlive() && this.getDistanceSqToEntity(entity) <= 900.0D && this.canEntityBeSeen(entity))
					{
						this.func_82216_a(i + 1, (EntityLivingBase)entity);
						this.field_82223_h[i - 1] = this.ticksExisted + 40 + this.rand.nextInt(20);
						this.field_82224_i[i - 1] = 0;
					}
					else
					{
						this.func_82211_c(i, 0);
					}
				}
				else
				{
					List list = this.worldObj.selectEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0D, 8.0D, 20.0D), attackEntitySelector);

					for(int k1 = 0; k1 < 10 && !list.isEmpty(); ++k1)
					{
						EntityLivingBase entitylivingbase = (EntityLivingBase)list.get(this.rand.nextInt(list.size()));

						if(entitylivingbase != this && entitylivingbase.isEntityAlive() && this.canEntityBeSeen(entitylivingbase))
						{
							if(entitylivingbase instanceof EntityPlayer)
							{
								if(!((EntityPlayer)entitylivingbase).capabilities.disableDamage)
								{
									this.func_82211_c(i, entitylivingbase.getEntityId());
								}
							}
							else
							{
								this.func_82211_c(i, entitylivingbase.getEntityId());
							}

							break;
						}

						list.remove(entitylivingbase);
					}
				}
			}
		}

		if(this.getAttackTarget() != null)
		{
			this.func_82211_c(0, this.getAttackTarget().getEntityId());
		}
		else
		{
			this.func_82211_c(0, 0);
		}

		if(this.field_82222_j > 0)
		{
			--this.field_82222_j;

			if(this.field_82222_j == 0 && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"))
			{
				i = MathHelper.floor_double(this.posY);
				i1 = MathHelper.floor_double(this.posX);
				int j1 = MathHelper.floor_double(this.posZ);
				boolean flag = false;

				for(int l1 = -1; l1 <= 1; ++l1)
				{
					for(int i2 = -1; i2 <= 1; ++i2)
					{
						for(int j = 0; j <= 3; ++j)
						{
							int j2 = i1 + l1;
							int k = i + j;
							int l = j1 + i2;
							Block block = this.worldObj.getBlock(j2, k, l);

							if(!block.isAir(worldObj, j2, k, l) && block.canEntityDestroy(worldObj, j2, k, l, this))
							{
								flag = this.worldObj.func_147480_a(j2, k, l, true) || flag;
							}
						}
					}
				}

				if(flag)
				{
					this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1012, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
				}
			}
		}

		if(this.ticksExisted % 20 == 0)
		{
			this.heal(1.0F);
		}
	}

	@Override
	public void setInWeb()
	{}

	@Override
	protected void onDeathUpdate()
	{
		++this.deathTicks;

		if(this.deathTicks >= 180 && this.deathTicks <= 200)
		{
			float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
			float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
			this.worldObj.spawnParticle("hugeexplosion", this.posX + (double)var1, this.posY + 2.0D + (double)var2, this.posZ + (double)var3, 0.0D, 0.0D, 0.0D);
		}

		int var4;
		int var5;

		if(!this.worldObj.isRemote)
		{
			if(this.deathTicks > 150 && this.deathTicks % 5 == 0)
			{
				var4 = 1000;

				while(var4 > 0)
				{
					var5 = EntityXPOrb.getXPSplit(var4);
					var4 -= var5;
					this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
				}
			}

			if(this.deathTicks == 1)
			{
				this.worldObj.playAuxSFX(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
			}
		}

		this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
		this.renderYawOffset = this.rotationYaw += 20.0F;

		if(this.deathTicks == 200 && !this.worldObj.isRemote)
		{
			var4 = 2000;

			while(var4 > 0)
			{
				var5 = EntityXPOrb.getXPSplit(var4);
				var4 -= var5;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var5));
			}
			this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 7.0F, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
			this.setDead();
		}
	}

	@Override
	public void onDeath(DamageSource damagesource)
	{
		Entity entity = damagesource.getEntity();

		if(entity != null && entity instanceof EntityPlayer)
		{
			((EntityPlayer)entity).triggerAchievement(NanotechAchievement.killTheDeath);

			if(((EntityPlayer)entity).inventory.armorItemInSlot(3) != null && ItemStack.areItemStacksEqual(((EntityPlayer)entity).inventory.armorItemInSlot(3), new ItemStack(NanotechItem.crazyGlasses)))
			{
				((EntityPlayer)entity).triggerAchievement(NanotechAchievement.killTheDeathWithCG);
			}
		}

		super.onDeath(damagesource);
	}

	@Override
	public int getTotalArmorValue()
	{
		return 4;
	}

	private double func_82214_u(int par1)
	{
		if(par1 <= 0)
		{
			return this.posX;
		}
		else
		{
			float f = (this.renderYawOffset + (float)(180 * (par1 - 1))) / 180.0F * (float)Math.PI;
			float f1 = MathHelper.cos(f);
			return this.posX + (double)f1 * 1.3D;
		}
	}

	private double func_82208_v(int par1)
	{
		return par1 <= 0 ? this.posY + 3.0D : this.posY + 2.2D;
	}

	private double func_82213_w(int par1)
	{
		if(par1 <= 0)
		{
			return this.posZ;
		}
		else
		{
			float f = (this.renderYawOffset + (float)(180 * (par1 - 1))) / 180.0F * (float)Math.PI;
			float f1 = MathHelper.sin(f);
			return this.posZ + (double)f1 * 1.3D;
		}
	}

	private float func_82204_b(float par1, float par2, float par3)
	{
		float f3 = MathHelper.wrapAngleTo180_float(par2 - par1);

		if(f3 > par3)
		{
			f3 = par3;
		}

		if(f3 < -par3)
		{
			f3 = -par3;
		}

		return par1 + f3;
	}

	private void func_82216_a(int par1, EntityLivingBase par2EntityLivingBase)
	{
		this.func_82209_a(par1, par2EntityLivingBase.posX, par2EntityLivingBase.posY + (double)par2EntityLivingBase.getEyeHeight() * 0.5D, par2EntityLivingBase.posZ, par1 == 0 && this.rand.nextFloat() < 0.001F);
	}

	private void func_82209_a(int par1, double par2, double par4, double par6, boolean par8)
	{
		this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
		double d3 = this.func_82214_u(par1);
		double d4 = this.func_82208_v(par1);
		double d5 = this.func_82213_w(par1);
		double d6 = par2 - d3;
		double d7 = par4 - d4;
		double d8 = par6 - d5;
		EntityTheDeathBall entityball = new EntityTheDeathBall(this.worldObj, this, d6, d7, d8);

		if(par8)
		{
			entityball.setInvulnerable(true);
		}

		entityball.posY = d4;
		entityball.posX = d3;
		entityball.posZ = d5;
		this.worldObj.spawnEntityInWorld(entityball);
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase livingBase, float par2)
	{
		this.func_82216_a(0, livingBase);
	}

	@Override
	public boolean attackEntityFrom(DamageSource damageSource, float par2)
	{
		if(this.isEntityInvulnerable())
		{
			return false;
		}
		else if(damageSource == DamageSource.drown)
		{
			return false;
		}
		else
		{
			Entity entity;
			entity = damageSource.getEntity();

			if(entity != null && !(entity instanceof EntityPlayer) && entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getCreatureAttribute() == this.getCreatureAttribute())
			{
				return false;
			}
			else
			{
				if(this.field_82222_j <= 0)
				{
					this.field_82222_j = 20;
				}

				for(int i = 0; i < this.field_82224_i.length; ++i)
				{
					this.field_82224_i[i] += 3;
				}

				return super.attackEntityFrom(damageSource, par2);
			}
		}
	}

	@Override
	protected void dropFewItems(boolean killbyplayer, int lootinglevel)
	{
		entityDropItem(new ItemStack(NanotechItem.itemBase, 25, 2), 0.0F);
		dropItem(Items.diamond, 18);
		dropItem(Items.nether_star, 1);
		dropItem(NanotechItem.scythe, 1);
	}

	@Override
	protected void despawnEntity()
	{
		this.entityAge = 0;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getBrightnessForRender(float par1)
	{
		return 15728880;
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return !this.isDead;
	}

	@Override
	protected void fall(float par1)
	{}

	@Override
	public void addPotionEffect(PotionEffect par1PotionEffect)
	{}

	@Override
	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5000.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6000000238418579D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
	}

	@SideOnly(Side.CLIENT)
	public float func_82207_a(int par1)
	{
		return this.field_82221_e[par1];
	}

	@SideOnly(Side.CLIENT)
	public float func_82210_r(int par1)
	{
		return this.field_82220_d[par1];
	}

	public int getWatchedTargetId(int par1)
	{
		return this.dataWatcher.getWatchableObjectInt(17 + par1);
	}

	public void func_82211_c(int par1, int par2)
	{
		this.dataWatcher.updateObject(17 + par1, Integer.valueOf(par2));
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	public void mountEntity(Entity par1Entity)
	{
		this.ridingEntity = null;
	}
}