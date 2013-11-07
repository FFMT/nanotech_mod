package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.Nanotech_mod;

public class MobSuperSkeleton extends EntityMob implements IRangedAttackMob
{
	private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 0.25F, Nanotech_mod.timeUntilNextArrow, 10.0F);
	private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.31F, false);

	public MobSuperSkeleton(World world)
	{
		super(world);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIRestrictSun(this));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, MobThedeath.class, 6.0F, 1.0D, 1.2D));
		this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));

		if(world != null && !world.isRemote)
		{
			this.setCombatTask();
		}
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(50D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.25D);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(13, new Byte((byte)0));
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	protected String getLivingSound()
	{
		return "mob.skeleton.say";
	}

	protected String getHurtSound()
	{
		return "mob.skeleton.hurt";
	}

	protected String getDeathSound()
	{
		return "mob.skeleton.death";
	}

	protected void playStepSound(int x, int y, int z, int par4)
	{
		this.playSound("mob.skeleton.step", 0.15F, 1.0F);
	}

	public boolean attackEntityAsMob(Entity entity)
	{
		if(super.attackEntityAsMob(entity))
		{
			if(this.getSkeletonType() == 1 && entity instanceof EntityLivingBase)
			{
				((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.wither.id, 200));
			}

			return true;
		}
		else
		{
			return false;
		}
	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

	public void onLivingUpdate()
	{
		if(this.worldObj.isDaytime() && !this.worldObj.isRemote)
		{
			float var1 = this.getBrightness(1.0F);

			if(var1 > 0.5F && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
			{
				boolean var2 = true;
				ItemStack var3 = this.getCurrentItemOrArmor(4);

				if(var3 != null)
				{
					if(var3.isItemStackDamageable())
					{
						var3.setItemDamage(var3.getItemDamageForDisplay() + this.rand.nextInt(2));

						if(var3.getItemDamageForDisplay() >= var3.getMaxDamage())
						{
							this.renderBrokenItemStack(var3);
							this.setCurrentItemOrArmor(4, (ItemStack)null);
						}
					}

					var2 = false;
				}

				if(var2)
				{
					this.setFire(8);
				}
			}
		}

		super.onLivingUpdate();
	}

	public void onDeath(DamageSource damagesource)
	{
		super.onDeath(damagesource);

		if(damagesource.getSourceOfDamage() instanceof EntityArrow && damagesource.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer var2 = (EntityPlayer)damagesource.getEntity();
			double var3 = var2.posX - this.posX;
			double var5 = var2.posZ - this.posZ;

			if(var3 * var3 + var5 * var5 >= 2500.0D)
			{
				var2.triggerAchievement(AchievementList.snipeSkeleton);
			}
		}
	}

	protected int getDropItemId()
	{
		return Item.arrow.itemID;
	}

	protected void dropFewItems(boolean killbyplayer, int lootinglevel)
	{
		int var3;
		int var4;

		if(this.getSkeletonType() == 1)
		{
			var3 = this.rand.nextInt(3 + lootinglevel) - 1;

			for(var4 = 0; var4 < var3; ++var4)
			{
				this.dropItem(Item.coal.itemID, 1);
			}
		}
		else
		{
			var3 = this.rand.nextInt(3 + lootinglevel);

			for(var4 = 0; var4 < var3; ++var4)
			{
				this.dropItem(Item.arrow.itemID, 1);
			}
		}

		var3 = this.rand.nextInt(3 + lootinglevel);

		for(var4 = 0; var4 < var3; ++var4)
		{
			this.dropItem(Item.bone.itemID, 1);
		}
	}

	protected void dropRareDrop(int par1)
	{
		if(this.getSkeletonType() == 1)
		{
			this.entityDropItem(new ItemStack(Item.skull.itemID, 1, 1), 0.0F);
		}
	}

	protected void addRandomArmor()
	{
		super.addRandomArmor();
		this.setCurrentItemOrArmor(0, new ItemStack(Item.bow));
	}

	public void setCombatTask()
	{
		this.tasks.removeTask(this.aiAttackOnCollide);
		this.tasks.removeTask(this.aiArrowAttack);
		ItemStack stack = this.getHeldItem();
		this.tasks.addTask(4, this.aiArrowAttack);

	}

	public void attackEntityWithRangedAttack(EntityLivingBase entityliving)
	{
		EntityArrow var2 = new EntityArrow(this.worldObj, this, entityliving, 1.6F, 22.0F);
		int var3 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
		int var4 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());

		if(var3 > 0)
		{
			var2.setDamage(var2.getDamage() + (double)var3 * 0.5D + 0.5D);
		}

		if(var4 > 0)
		{
			var2.setKnockbackStrength(var4);
		}

		if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0 || this.getSkeletonType() == 1)
		{
			var2.setFire(100);
		}

		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(var2);
	}

	public int getSkeletonType()
	{
		return this.dataWatcher.getWatchableObjectByte(13);
	}

	public void setSkeletonType(int par1)
	{
		this.dataWatcher.updateObject(13, Byte.valueOf((byte)par1));
		this.isImmuneToFire = par1 == 1;

		if(par1 == 1)
		{
			this.setSize(0.72F, 2.16F);
		}
		else
		{
			this.setSize(0.6F, 1.8F);
		}
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readEntityFromNBT(nbttagcompound);

		if(nbttagcompound.hasKey("SkeletonType"))
		{
			byte var2 = nbttagcompound.getByte("SkeletonType");
			this.setSkeletonType(var2);
		}

		this.setCombatTask();
	}

	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeEntityToNBT(nbttagcompound);
		nbttagcompound.setByte("SkeletonType", (byte)this.getSkeletonType());
	}

	public void setCurrentItemOrArmor(int slot, ItemStack stack)
	{
		super.setCurrentItemOrArmor(slot, stack);

		if(!this.worldObj.isRemote && slot == 0)
		{
			this.setCombatTask();
		}
	}

	public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
	{
		EntityArrow entityarrow = new EntityArrow(this.worldObj, this, par1EntityLivingBase, 1.6F, (float)(14 - this.worldObj.difficultySetting * 4));
		int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, this.getHeldItem());
		int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, this.getHeldItem());
		entityarrow.setDamage((double)(par2 * 2.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.worldObj.difficultySetting * 0.11F));

		if(i > 0)
		{
			entityarrow.setDamage(entityarrow.getDamage() + (double)i * 0.5D + 0.5D);
		}

		if(j > 0)
		{
			entityarrow.setKnockbackStrength(j);
		}

		if(EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0 || this.getSkeletonType() == 1)
		{
			entityarrow.setFire(100);
		}

		this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.spawnEntityInWorld(entityarrow);
	}

}
