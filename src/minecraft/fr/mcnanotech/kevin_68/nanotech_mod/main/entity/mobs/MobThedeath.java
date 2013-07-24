package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
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
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.core.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others.EntityTheDeathBall;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class MobThedeath extends EntityMob implements IBossDisplayData, IRangedAttackMob
{
	private float[] field_82220_d = new float[2];
	private float[] field_82221_e = new float[2];
	private float[] field_82217_f = new float[2];
	private float[] field_82218_g = new float[2];
	private int[] field_82223_h = new int[2];
	private int[] field_82224_i = new int[2];
	private int field_82222_j;

	public MobThedeath(World world)
	{
		super(world);
		this.setEntityHealth(this.getMaxHealth());
		this.texture = "/mods/Nanotech_mod/textures/mob/thedeath.png";
		this.setSize(5F, 8.0F);
		this.isImmuneToFire = true;
		this.moveSpeed = 0.6F;
		this.getNavigator().setCanSwim(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIArrowAttack(this, this.moveSpeed, 40, 40.0F));
		this.tasks.addTask(5, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 50.0F, 0, false, false, mobSelector));
		this.experienceValue = 50;
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Integer(this.getMaxHealth()));
		this.dataWatcher.addObject(17, new Integer(0));
		this.dataWatcher.addObject(18, new Integer(0));
		this.dataWatcher.addObject(19, new Integer(0));
		this.dataWatcher.addObject(20, new Integer(0));
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("Invul", this.func_82212_n());
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.func_82215_s(par1NBTTagCompound.getInteger("Invul"));
		this.dataWatcher.updateObject(16, Integer.valueOf(this.health));
	}

	@SideOnly(Side.CLIENT)
	public float getShadowSize()
	{
		return this.height / 8.0F;
	}

	protected String getLivingSound()
	{
		return "nanotech.monster";
	}

	protected String getHurtSound()
	{
		return "nanotech.monsterhurt";
	}

	protected String getDeathSound()
	{
		return "nanotech.monsterdeath";
	}

	public void onLivingUpdate()
	{
		if(!this.worldObj.isRemote)
		{
			this.dataWatcher.updateObject(16, Integer.valueOf(this.health));
		}

		this.motionY *= 0.6000000238418579D;
		double var4;
		double var6;
		double var8;

		if(!this.worldObj.isRemote && this.getWatchedTargetId(0) > 0)
		{
			Entity var1 = this.worldObj.getEntityByID(this.getWatchedTargetId(0));

			if(var1 != null)
			{
				if(this.posY < var1.posY || !this.isArmored() && this.posY < var1.posY + 5.0D)
				{
					if(this.motionY < 0.0D)
					{
						this.motionY = 0.0D;
					}

					this.motionY += (0.5D - this.motionY) * 0.6000000238418579D;
				}

				double var2 = var1.posX - this.posX;
				var4 = var1.posZ - this.posZ;
				var6 = var2 * var2 + var4 * var4;

				if(var6 > 9.0D)
				{
					var8 = (double)MathHelper.sqrt_double(var6);
					this.motionX += (var2 / var8 * 0.5D - this.motionX) * 0.6000000238418579D;
					this.motionZ += (var4 / var8 * 0.5D - this.motionZ) * 0.6000000238418579D;
				}
			}
		}

		if(this.motionX * this.motionX + this.motionZ * this.motionZ > 0.05000000074505806D)
		{
			this.rotationYaw = (float)Math.atan2(this.motionZ, this.motionX) * (180F / (float)Math.PI) - 90.0F;
		}

		super.onLivingUpdate();
		int var20;

		for(var20 = 0; var20 < 2; ++var20)
		{
			this.field_82218_g[var20] = this.field_82221_e[var20];
			this.field_82217_f[var20] = this.field_82220_d[var20];
		}

		int var21;

		for(var20 = 0; var20 < 2; ++var20)
		{
			var21 = this.getWatchedTargetId(var20 + 1);
			Entity var3 = null;

			if(var21 > 0)
			{
				var3 = this.worldObj.getEntityByID(var21);
			}

			if(var3 != null)
			{
				var4 = this.func_82214_u(var20 + 1);
				var6 = this.func_82208_v(var20 + 1);
				var8 = this.func_82213_w(var20 + 1);
				double var10 = var3.posX - var4;
				double var12 = var3.posY + (double)var3.getEyeHeight() - var6;
				double var14 = var3.posZ - var8;
				double var16 = (double)MathHelper.sqrt_double(var10 * var10 + var14 * var14);
				float var18 = (float)(Math.atan2(var14, var10) * 180.0D / Math.PI) - 90.0F;
				float var19 = (float)(-(Math.atan2(var12, var16) * 180.0D / Math.PI));
				this.field_82220_d[var20] = this.func_82204_b(this.field_82220_d[var20], var19, 40.0F);
				this.field_82221_e[var20] = this.func_82204_b(this.field_82221_e[var20], var18, 10.0F);
			}
			else
			{
				this.field_82221_e[var20] = this.func_82204_b(this.field_82221_e[var20], this.renderYawOffset, 10.0F);
			}
		}

		boolean var22 = this.isArmored();

		for(var21 = 0; var21 < 3; ++var21)
		{
			double var23 = this.func_82214_u(var21);
			double var5 = this.func_82208_v(var21);
			double var7 = this.func_82213_w(var21);
			this.worldObj.spawnParticle("smoke", var23 + this.rand.nextGaussian() * 0.30000001192092896D, var5 + this.rand.nextGaussian() * 0.30000001192092896D, var7 + this.rand.nextGaussian() * 0.30000001192092896D, 0.0D, 0.0D, 0.0D);

			if(var22 && this.worldObj.rand.nextInt(4) == 0)
			{
				this.worldObj.spawnParticle("mobSpell", var23 + this.rand.nextGaussian() * 0.30000001192092896D, var5 + this.rand.nextGaussian() * 0.30000001192092896D, var7 + this.rand.nextGaussian() * 0.30000001192092896D, 0.699999988079071D, 0.699999988079071D, 0.5D);
			}
		}

		if(this.func_82212_n() > 0)
		{
			for(var21 = 0; var21 < 3; ++var21)
			{
				this.worldObj.spawnParticle("mobSpell", this.posX + this.rand.nextGaussian() * 1.0D, this.posY + (double)(this.rand.nextFloat() * 3.3F), this.posZ + this.rand.nextGaussian() * 1.0D, 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D);
			}
		}
	}

	public ItemStack getHeldItem()
	{
		return (new ItemStack(NanotechItem.scythe));
	}

	public int deathTicks = 0;

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
				this.worldObj.func_82739_e(1018, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
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

	public void onDeath(DamageSource par1DamageSource)
	{
		Entity entity = par1DamageSource.getEntity();

		if (entity != null && entity instanceof EntityPlayer)
		{
			((EntityPlayer) entity).triggerAchievement(NanotechAchievement.killTheDeath);
			
			if (((EntityPlayer)entity).inventory.armorItemInSlot(3) != null && ((EntityPlayer)entity).inventory.armorItemInSlot(3) == new ItemStack(NanotechItem.crazyGlasses))
			{
				((EntityPlayer)entity).triggerAchievement(NanotechAchievement.killTheDeathWithCG);
			}
		}

		super.onDeath(par1DamageSource);
	}

	protected void updateAITasks()
	{
		int var1;

		if(this.func_82212_n() > 0)
		{
			var1 = this.func_82212_n() - 1;

			if(var1 <= 0)
			{
				this.worldObj.newExplosion(this, this.posX, this.posY + (double)this.getEyeHeight(), this.posZ, 7.0F, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
				this.worldObj.func_82739_e(1013, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
			}

			this.func_82215_s(var1);

			if(this.ticksExisted % 10 == 0)
			{
				this.heal(10);
			}
		}
		else
		{
			super.updateAITasks();
			int var13;

			for(var1 = 1; var1 < 3; ++var1)
			{
				if(this.ticksExisted >= this.field_82223_h[var1 - 1])
				{
					this.field_82223_h[var1 - 1] = this.ticksExisted + 10 + this.rand.nextInt(10);

					if(this.worldObj.difficultySetting >= 2)
					{
						int var10001 = var1 - 1;
						int var10003 = this.field_82224_i[var1 - 1];
						this.field_82224_i[var10001] = this.field_82224_i[var1 - 1] + 1;

						if(var10003 > 15)
						{
							float var2 = 10.0F;
							float var3 = 5.0F;
							double var4 = MathHelper.getRandomDoubleInRange(this.rand, this.posX - (double)var2, this.posX + (double)var2);
							double var6 = MathHelper.getRandomDoubleInRange(this.rand, this.posY - (double)var3, this.posY + (double)var3);
							double var8 = MathHelper.getRandomDoubleInRange(this.rand, this.posZ - (double)var2, this.posZ + (double)var2);
							this.func_82209_a(var1 + 1, var4, var6, var8, true);
							this.field_82224_i[var1 - 1] = 0;
						}
					}

					var13 = this.getWatchedTargetId(var1);

					if(var13 > 0)
					{
						Entity var15 = this.worldObj.getEntityByID(var13);

						if(var15 != null && var15.isEntityAlive() && this.getDistanceSqToEntity(var15) <= 900.0D && this.canEntityBeSeen(var15))
						{
							this.func_82216_a(var1 + 1, (EntityLiving)var15);
							this.field_82223_h[var1 - 1] = this.ticksExisted + 40 + this.rand.nextInt(20);
							this.field_82224_i[var1 - 1] = 0;
						}
						else
						{
							this.func_82211_c(var1, 0);
						}
					}
					else
					{
						List var14 = this.worldObj.selectEntitiesWithinAABB(EntityLiving.class, this.boundingBox.expand(20.0D, 8.0D, 20.0D), mobSelector);

						for(int var17 = 0; var17 < 10 && !var14.isEmpty(); ++var17)
						{
							EntityLiving var5 = (EntityLiving)var14.get(this.rand.nextInt(var14.size()));

							if(var5 != this && var5.isEntityAlive() && this.canEntityBeSeen(var5))
							{
								if(var5 instanceof EntityPlayer)
								{
									if(!((EntityPlayer)var5).capabilities.disableDamage)
									{
										this.func_82211_c(var1, var5.entityId);
									}
								}
								else
								{
									this.func_82211_c(var1, var5.entityId);
								}

								break;
							}

							var14.remove(var5);
						}
					}
				}
			}

			if(this.getAttackTarget() != null)
			{
				this.func_82211_c(0, this.getAttackTarget().entityId);
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
					var1 = MathHelper.floor_double(this.posY);
					var13 = MathHelper.floor_double(this.posX);
					int var16 = MathHelper.floor_double(this.posZ);
					boolean var19 = false;

					for(int var18 = -1; var18 <= 1; ++var18)
					{
						for(int var20 = -1; var20 <= 1; ++var20)
						{
							for(int var7 = 0; var7 <= 3; ++var7)
							{
								int var21 = var13 + var18;
								int var9 = var1 + var7;
								int var10 = var16 + var20;
								int var11 = this.worldObj.getBlockId(var21, var9, var10);

								if(var11 > 0 && var11 != Block.bedrock.blockID && var11 != Block.endPortal.blockID && var11 != Block.endPortalFrame.blockID)
								{
									int var12 = this.worldObj.getBlockMetadata(var21, var9, var10);
									this.worldObj.playAuxSFX(2001, var21, var9, var10, var11 + (var12 << 12));
									Block.blocksList[var11].dropBlockAsItem(this.worldObj, var21, var9, var10, var12, 0);
									this.worldObj.setBlockToAir(var21, var9, var10);
									var19 = true;
								}
							}
						}
					}

					if(var19)
					{
						this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1012, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
					}
				}
			}

			if(this.ticksExisted % 20 == 0)
			{
				this.heal(1);
			}
		}
	}

	public void func_82206_m()
	{
		this.func_82215_s(220);
		this.setEntityHealth(this.getMaxHealth() / 3);
	}

	public void setInWeb()
	{}

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
			float var2 = (this.renderYawOffset + (float)(180 * (par1 - 1))) / 180.0F * (float)Math.PI;
			float var3 = MathHelper.cos(var2);
			return this.posX + (double)var3 * 1.3D;
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
			float var2 = (this.renderYawOffset + (float)(180 * (par1 - 1))) / 180.0F * (float)Math.PI;
			float var3 = MathHelper.sin(var2);
			return this.posZ + (double)var3 * 1.3D;
		}
	}

	private float func_82204_b(float par1, float par2, float par3)
	{
		float var4 = MathHelper.wrapAngleTo180_float(par2 - par1);

		if(var4 > par3)
		{
			var4 = par3;
		}

		if(var4 < -par3)
		{
			var4 = -par3;
		}

		return par1 + var4;
	}

	private void func_82216_a(int par1, EntityLiving par2EntityLiving)
	{
		this.func_82209_a(par1, par2EntityLiving.posX, par2EntityLiving.posY + (double)par2EntityLiving.getEyeHeight() * 0.5D, par2EntityLiving.posZ, par1 == 0 && this.rand.nextFloat() < 0.001F);
	}

	private void func_82209_a(int par1, double par2, double par4, double par6, boolean par8)
	{
		this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
		double var9 = this.func_82214_u(par1);
		double var11 = this.func_82208_v(par1);
		double var13 = this.func_82213_w(par1);
		double var15 = par2 - var9;
		double var17 = par4 - var11;
		double var19 = par6 - var13;
		EntityTheDeathBall var21 = new EntityTheDeathBall(this.worldObj, this, var15, var17, var19);

		if(par8)
		{
			var21.setInvulnerable(true);
		}

		var21.posY = var11;
		var21.posX = var9;
		var21.posZ = var13;
		this.worldObj.spawnEntityInWorld(var21);
	}

	public void attackEntityWithRangedAttack(EntityLiving par1EntityLiving)
	{
		this.func_82216_a(0, par1EntityLiving);
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		if(this.isEntityInvulnerable())
		{
			return false;
		}
		else if(par1DamageSource == DamageSource.drown)
		{
			return false;
		}
		else if(this.func_82212_n() > 0)
		{
			return false;
		}
		else
		{
			Entity var3;

			if(this.isArmored())
			{
				var3 = par1DamageSource.getSourceOfDamage();

				if(var3 instanceof EntityArrow)
				{
					return false;
				}
			}

			var3 = par1DamageSource.getEntity();

			if(var3 != null && !(var3 instanceof EntityPlayer) && var3 instanceof EntityLiving && ((EntityLiving)var3).getCreatureAttribute() == this.getCreatureAttribute())
			{
				return false;
			}
			else
			{
				if(this.field_82222_j <= 0)
				{
					this.field_82222_j = 20;
				}

				for(int var4 = 0; var4 < this.field_82224_i.length; ++var4)
				{
					this.field_82224_i[var4] += 3;
				}

				return super.attackEntityFrom(par1DamageSource, par2);
			}
		}
	}

	protected void dropFewItems(boolean par1, int par2)
	{
		entityDropItem(new ItemStack(NanotechItem.ItemBase, 25, 2), 0.0F);
		dropItem(Item.diamond.itemID, 18);
		dropItem(Item.netherStar.itemID, 1);
		dropItem(NanotechItem.scythe.itemID, 1);
	}

	protected void despawnEntity()
	{
		this.entityAge = 0;
	}

	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(float par1)
	{
		return 15728880;
	}

	public boolean canBeCollidedWith()
	{
		return !this.isDead;
	}

	protected void fall(float par1)
	{}

	public void addPotionEffect(PotionEffect par1PotionEffect)
	{}

	protected boolean isAIEnabled()
	{
		return true;
	}

	public int getMaxHealth()
	{
		return 5000;
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

	public int func_82212_n()
	{
		return this.dataWatcher.getWatchableObjectInt(20);
	}

	public void func_82215_s(int par1)
	{
		this.dataWatcher.updateObject(20, Integer.valueOf(par1));
	}

	public int getWatchedTargetId(int par1)
	{
		return this.dataWatcher.getWatchableObjectInt(17 + par1);
	}

	public void func_82211_c(int par1, int par2)
	{
		this.dataWatcher.updateObject(17 + par1, Integer.valueOf(par2));
	}

	public boolean isArmored()
	{
		return false;
	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLiving entityliving, float f)
	{

	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getBossHealth()
	{
		return this.dataWatcher.getWatchableObjectInt(16);
	}

}
