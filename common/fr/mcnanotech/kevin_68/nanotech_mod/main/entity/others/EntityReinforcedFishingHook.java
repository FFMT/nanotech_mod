package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class EntityReinforcedFishingHook extends EntityFishHook
{
	/** The tile this entity is on, X position */
	private int xTile;

	/** The tile this entity is on, Y position */
	private int yTile;

	/** The tile this entity is on, Z position */
	private int zTile;
	private int inTile;
	private boolean inGround;
	public int shake;
	public EntityPlayer angler;
	private int ticksInGround;
	private int ticksInAir;

	/** the number of ticks remaining until this fish can no longer be caught */
	private int ticksCatchable;

	/**
	 * The entity that the fishing rod is connected to, if any. When you right
	 * click on the fishing rod and the hook falls on to an entity, this it that
	 * entity.
	 */
	public Entity bobber;
	private int fishPosRotationIncrements;
	private double fishX;
	private double fishY;
	private double fishZ;
	private double fishYaw;
	private double fishPitch;
	@SideOnly(Side.CLIENT)
	private double velocityX;
	@SideOnly(Side.CLIENT)
	private double velocityY;
	@SideOnly(Side.CLIENT)
	private double velocityZ;

	public EntityReinforcedFishingHook(World par1World)
	{
		super(par1World);
		this.xTile = -1;
		this.yTile = -1;
		this.zTile = -1;
		this.setSize(0.25F, 0.25F);
		this.ignoreFrustumCheck = true;
	}

	@SideOnly(Side.CLIENT)
	public EntityReinforcedFishingHook(World par1World, double par2, double par4, double par6, EntityPlayer par8EntityPlayer)
	{
		this(par1World);
		this.setPosition(par2, par4, par6);
		this.ignoreFrustumCheck = true;
		this.angler = par8EntityPlayer;
		par8EntityPlayer.fishEntity = this;
	}

	public EntityReinforcedFishingHook(World par1World, EntityPlayer par2EntityPlayer)
	{
		super(par1World);
		this.xTile = -1;
		this.yTile = -1;
		this.zTile = -1;
		this.ignoreFrustumCheck = true;
		this.angler = par2EntityPlayer;
		this.angler.fishEntity = this;
		this.setSize(0.25F, 0.25F);
		this.setLocationAndAngles(par2EntityPlayer.posX, par2EntityPlayer.posY + 1.62D - (double)par2EntityPlayer.yOffset, par2EntityPlayer.posZ, par2EntityPlayer.rotationYaw, par2EntityPlayer.rotationPitch);
		this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
		this.posY -= 0.10000000149011612D;
		this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.yOffset = 0.0F;
		float f = 0.4F;
		this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
		this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
		this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI) * f);
		this.calculateVelocity(this.motionX, this.motionY, this.motionZ, 1.5F, 1.0F);
	}

	protected void entityInit()
	{}

	@SideOnly(Side.CLIENT)
	/**
	 * Checks if the entity is in range to render by using the past in distance and comparing it to its average edge
	 * length * 64 * renderDistanceWeight Args: distance
	 */
	public boolean isInRangeToRenderDist(double par1)
	{
		double d1 = this.boundingBox.getAverageEdgeLength() * 4.0D;
		d1 *= 64.0D;
		return par1 < d1 * d1;
	}

	public void calculateVelocity(double par1, double par3, double par5, float par7, float par8)
	{
		float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
		par1 /= (double)f2;
		par3 /= (double)f2;
		par5 /= (double)f2;
		par1 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
		par3 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
		par5 += this.rand.nextGaussian() * 0.007499999832361937D * (double)par8;
		par1 *= (double)par7;
		par3 *= (double)par7;
		par5 *= (double)par7;
		this.motionX = par1;
		this.motionY = par3;
		this.motionZ = par5;
		float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
		this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)f3) * 180.0D / Math.PI);
		this.ticksInGround = 0;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Sets the position and rotation. Only difference from the other one is no bounding on the rotation. Args: posX,
	 * posY, posZ, yaw, pitch
	 */
	public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9)
	{
		this.fishX = par1;
		this.fishY = par3;
		this.fishZ = par5;
		this.fishYaw = (double)par7;
		this.fishPitch = (double)par8;
		this.fishPosRotationIncrements = par9;
		this.motionX = this.velocityX;
		this.motionY = this.velocityY;
		this.motionZ = this.velocityZ;
	}

	@SideOnly(Side.CLIENT)
	/**
	 * Sets the velocity to the args. Args: x, y, z
	 */
	public void setVelocity(double par1, double par3, double par5)
	{
		this.velocityX = this.motionX = par1;
		this.velocityY = this.motionY = par3;
		this.velocityZ = this.motionZ = par5;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		super.onEntityUpdate();

		if(this.fishPosRotationIncrements > 0)
		{
			double d0 = this.posX + (this.fishX - this.posX) / (double)this.fishPosRotationIncrements;
			double d1 = this.posY + (this.fishY - this.posY) / (double)this.fishPosRotationIncrements;
			double d2 = this.posZ + (this.fishZ - this.posZ) / (double)this.fishPosRotationIncrements;
			double d3 = MathHelper.wrapAngleTo180_double(this.fishYaw - (double)this.rotationYaw);
			this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.fishPosRotationIncrements);
			this.rotationPitch = (float)((double)this.rotationPitch + (this.fishPitch - (double)this.rotationPitch) / (double)this.fishPosRotationIncrements);
			--this.fishPosRotationIncrements;
			this.setPosition(d0, d1, d2);
			this.setRotation(this.rotationYaw, this.rotationPitch);
		}
		else
		{
			if(!this.worldObj.isRemote)
			{
				ItemStack itemstack = this.angler.getCurrentEquippedItem();

				if(this.angler.isDead || !this.angler.isEntityAlive() || itemstack == null || itemstack.getItem() != NanotechItem.reinforcedFishingRod || this.getDistanceSqToEntity(this.angler) > 1024.0D)
				{
					this.setDead();
					this.angler.fishEntity = null;
					return;
				}

				if(this.bobber != null)
				{
					if(!this.bobber.isDead)
					{
						this.posX = this.bobber.posX;
						this.posY = this.bobber.boundingBox.minY + (double)this.bobber.height * 0.8D;
						this.posZ = this.bobber.posZ;
						return;
					}

					this.bobber = null;
				}
			}

			if(this.shake > 0)
			{
				--this.shake;
			}

			if(this.inGround)
			{
				int i = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);

				if(i == this.inTile)
				{
					++this.ticksInGround;

					if(this.ticksInGround == 1200)
					{
						this.setDead();
					}

					return;
				}

				this.inGround = false;
				this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
				this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
				this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
				this.ticksInGround = 0;
				this.ticksInAir = 0;
			}
			else
			{
				++this.ticksInAir;
			}

			Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
			Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
			MovingObjectPosition movingobjectposition = this.worldObj.clip(vec3, vec31);
			vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
			vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

			if(movingobjectposition != null)
			{
				vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
			}

			Entity entity = null;
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
			double d4 = 0.0D;
			double d5;

			for(int j = 0; j < list.size(); ++j)
			{
				Entity entity1 = (Entity)list.get(j);

				if(entity1.canBeCollidedWith() && (entity1 != this.angler || this.ticksInAir >= 5))
				{
					float f = 0.3F;
					AxisAlignedBB axisalignedbb = entity1.boundingBox.expand((double)f, (double)f, (double)f);
					MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec3, vec31);

					if(movingobjectposition1 != null)
					{
						d5 = vec3.distanceTo(movingobjectposition1.hitVec);

						if(d5 < d4 || d4 == 0.0D)
						{
							entity = entity1;
							d4 = d5;
						}
					}
				}
			}

			if(entity != null)
			{
				movingobjectposition = new MovingObjectPosition(entity);
			}

			if(movingobjectposition != null)
			{
				if(movingobjectposition.entityHit != null)
				{
					if(movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.angler), 0.0F))
					{
						this.bobber = movingobjectposition.entityHit;
					}
				}
				else
				{
					this.inGround = true;
				}
			}

			if(!this.inGround)
			{
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
				float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
				this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

				for(this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f1) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
				{
					;
				}

				while(this.rotationPitch - this.prevRotationPitch >= 180.0F)
				{
					this.prevRotationPitch += 360.0F;
				}

				while(this.rotationYaw - this.prevRotationYaw < -180.0F)
				{
					this.prevRotationYaw -= 360.0F;
				}

				while(this.rotationYaw - this.prevRotationYaw >= 180.0F)
				{
					this.prevRotationYaw += 360.0F;
				}

				this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
				this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
				float f2 = 0.92F;

				if(this.onGround || this.isCollidedHorizontally)
				{
					f2 = 0.5F;
				}

				byte b0 = 5;
				double d6 = 0.0D;

				for(int k = 0; k < b0; ++k)
				{
					double d7 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(k + 0) / (double)b0 - 0.125D + 0.125D;
					double d8 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(k + 1) / (double)b0 - 0.125D + 0.125D;
					AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getAABBPool().getAABB(this.boundingBox.minX, d7, this.boundingBox.minZ, this.boundingBox.maxX, d8, this.boundingBox.maxZ);

					if(this.worldObj.isAABBInMaterial(axisalignedbb1, Material.water))
					{
						d6 += 1.0D / (double)b0;
					}
				}

				if(d6 > 0.0D)
				{
					if(this.ticksCatchable > 0)
					{
						--this.ticksCatchable;
					}
					else
					{
						short short1 = 500;

						if(this.worldObj.canLightningStrikeAt(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) + 1, MathHelper.floor_double(this.posZ)))
						{
							short1 = 300;
						}

						if(this.rand.nextInt(short1) == 0)
						{
							this.ticksCatchable = this.rand.nextInt(30) + 10;
							this.motionY -= 0.20000000298023224D;
							this.playSound("random.splash", 0.25F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
							float f3 = (float)MathHelper.floor_double(this.boundingBox.minY);
							int l;
							float f4;
							float f5;

							for(l = 0; (float)l < 1.0F + this.width * 20.0F; ++l)
							{
								f5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
								f4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
								this.worldObj.spawnParticle("bubble", this.posX + (double)f5, (double)(f3 + 1.0F), this.posZ + (double)f4, this.motionX, this.motionY - (double)(this.rand.nextFloat() * 0.2F), this.motionZ);
							}

							for(l = 0; (float)l < 1.0F + this.width * 20.0F; ++l)
							{
								f5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
								f4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
								this.worldObj.spawnParticle("splash", this.posX + (double)f5, (double)(f3 + 1.0F), this.posZ + (double)f4, this.motionX, this.motionY, this.motionZ);
							}
						}
					}
				}

				if(this.ticksCatchable > 0)
				{
					this.motionY -= (double)(this.rand.nextFloat() * this.rand.nextFloat() * this.rand.nextFloat()) * 0.2D;
				}

				d5 = d6 * 2.0D - 1.0D;
				this.motionY += 0.03999999910593033D * d5;

				if(d6 > 0.0D)
				{
					f2 = (float)((double)f2 * 0.9D);
					this.motionY *= 0.8D;
				}

				this.motionX *= (double)f2;
				this.motionY *= (double)f2;
				this.motionZ *= (double)f2;
				this.setPosition(this.posX, this.posY, this.posZ);
			}
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		par1NBTTagCompound.setShort("xTile", (short)this.xTile);
		par1NBTTagCompound.setShort("yTile", (short)this.yTile);
		par1NBTTagCompound.setShort("zTile", (short)this.zTile);
		par1NBTTagCompound.setByte("inTile", (byte)this.inTile);
		par1NBTTagCompound.setByte("shake", (byte)this.shake);
		par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		this.xTile = par1NBTTagCompound.getShort("xTile");
		this.yTile = par1NBTTagCompound.getShort("yTile");
		this.zTile = par1NBTTagCompound.getShort("zTile");
		this.inTile = par1NBTTagCompound.getByte("inTile") & 255;
		this.shake = par1NBTTagCompound.getByte("shake") & 255;
		this.inGround = par1NBTTagCompound.getByte("inGround") == 1;
	}

	@SideOnly(Side.CLIENT)
	public float getShadowSize()
	{
		return 0.0F;
	}

	public int catchFish()
	{
		if(this.worldObj.isRemote)
		{
			return 0;
		}
		else
		{
			byte b0 = 0;

			if(this.bobber != null)
			{
				double d0 = this.angler.posX - this.posX;
				double d1 = this.angler.posY - this.posY;
				double d2 = this.angler.posZ - this.posZ;
				double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);
				double d4 = 0.1D;
				this.bobber.motionX += d0 * d4;
				this.bobber.motionY += d1 * d4 + (double)MathHelper.sqrt_double(d3) * 0.08D;
				this.bobber.motionZ += d2 * d4;
				b0 = 3;
			}
			else if(this.ticksCatchable > 0)
			{
				EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(NanotechItem.itemBase, 1, 17));
				double d5 = this.angler.posX - this.posX;
				double d6 = this.angler.posY - this.posY;
				double d7 = this.angler.posZ - this.posZ;
				double d8 = (double)MathHelper.sqrt_double(d5 * d5 + d6 * d6 + d7 * d7);
				double d9 = 0.1D;
				entityitem.motionX = d5 * d9;
				entityitem.motionY = d6 * d9 + (double)MathHelper.sqrt_double(d8) * 0.08D;
				entityitem.motionZ = d7 * d9;
				this.worldObj.spawnEntityInWorld(entityitem);
				this.angler.addStat(StatList.fishCaughtStat, 1);
				this.angler.worldObj.spawnEntityInWorld(new EntityXPOrb(this.angler.worldObj, this.angler.posX, this.angler.posY + 0.5D, this.angler.posZ + 0.5D, this.rand.nextInt(6) + 1));
				b0 = 1;
			}

			if(this.inGround)
			{
				b0 = 2;
			}

			this.setDead();
			this.angler.fishEntity = null;
			return b0;
		}
	}

	/**
	 * Will get destroyed next tick.
	 */
	public void setDead()
	{
		super.setDead();

		if(this.angler != null)
		{
			this.angler.fishEntity = null;
		}
	}
}
