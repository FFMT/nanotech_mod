package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
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
import fr.mcnanotech.kevin_68.nanotech_mod.main.blocks.NanotechBlock;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class EntityReinforcedFishingHook extends EntityFishHook
{
	private int xTile;
	private int yTile;
	private int zTile;
	private int inTile;
	private boolean inGround;
	public int shake;
	public EntityPlayer angler;
	private int ticksInGround;
	private int ticksInAir;
	private int ticksCatchable;
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
	private boolean isInNitrogen;

	public EntityReinforcedFishingHook(World world)
	{
		super(world);
		this.xTile = -1;
		this.yTile = -1;
		this.zTile = -1;
		this.inTile = 0;
		this.inGround = false;
		this.shake = 0;
		this.ticksInAir = 0;
		this.ticksCatchable = 0;
		this.bobber = null;
		setSize(0.25F, 0.25F);
		this.ignoreFrustumCheck = true;
	}

	@SideOnly(Side.CLIENT)
	public EntityReinforcedFishingHook(World world, double x, double y, double z, EntityPlayer player)
	{
		super(world, x, y, z, player);
		setPosition(x, y, z);
		this.ignoreFrustumCheck = true;
		this.angler = player;
		player.fishEntity = this;
		this.xTile = -1;
		this.yTile = -1;
		this.zTile = -1;
		this.inTile = 0;
		this.inGround = false;
		this.shake = 0;
		this.ticksInAir = 0;
		this.ticksCatchable = 0;
		this.bobber = null;
		setSize(0.25F, 0.25F);
		this.ignoreFrustumCheck = true;
	}

	public EntityReinforcedFishingHook(World world, EntityPlayer player)
	{
		super(world, player);
		this.xTile = -1;
		this.yTile = -1;
		this.zTile = -1;
		this.ignoreFrustumCheck = true;
		this.angler = player;
		this.angler.fishEntity = this;
		this.setSize(0.25F, 0.25F);
		this.setLocationAndAngles(player.posX, player.posY + 1.62D - (double)player.yOffset, player.posZ, player.rotationYaw, player.rotationPitch);
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
	public boolean isInRangeToRenderDist(double distance)
	{
		double d1 = this.boundingBox.getAverageEdgeLength() * 4.0D;
		d1 *= 64.0D;
		return distance < d1 * d1;
	}

	public void calculateVelocity(double x, double y, double z, float par7, float par8)
	{
		float f2 = MathHelper.sqrt_double(x * x + y * y + z * z);
		x /= f2;
		y /= f2;
		z /= f2;
		x += this.rand.nextGaussian() * 0.007499999832361937D * par8;
		y += this.rand.nextGaussian() * 0.007499999832361937D * par8;
		z += this.rand.nextGaussian() * 0.007499999832361937D * par8;
		x *= par7;
		y *= par7;
		z *= par7;
		this.motionX = x;
		this.motionY = y;
		this.motionZ = z;
		float f3 = MathHelper.sqrt_double(x * x + z * z);
		this.prevRotationYaw = (this.rotationYaw = (float)(Math.atan2(x, z) * 180.0D / 3.141592653589793D));
		this.prevRotationPitch = (this.rotationPitch = (float)(Math.atan2(y, f3) * 180.0D / 3.141592653589793D));
		this.ticksInGround = 0;
	}

	@SideOnly(Side.CLIENT)
	public void setPositionAndRotation2(double x, double y, double z, float par7, float par8, int par9)
	{
		this.fishX = x;
		this.fishY = y;
		this.fishZ = z;
		this.fishYaw = par7;
		this.fishPitch = par8;
		this.fishPosRotationIncrements = par9;
		this.motionX = this.velocityX;
		this.motionY = this.velocityY;
		this.motionZ = this.velocityZ;
	}

	@SideOnly(Side.CLIENT)
	public void setVelocity(double x, double y, double z)
	{
		this.velocityX = (this.motionX = x);
		this.velocityY = (this.motionY = y);
		this.velocityZ = (this.motionZ = z);
	}

	public void onUpdate()
	{
		if((!this.worldObj.isRemote) && (this.angler == null))
		{
			setDead();
		}
		super.onEntityUpdate();

		if(this.fishPosRotationIncrements > 0)
		{
			double d0 = this.posX + (this.fishX - this.posX) / this.fishPosRotationIncrements;
			double d1 = this.posY + (this.fishY - this.posY) / this.fishPosRotationIncrements;
			double d2 = this.posZ + (this.fishZ - this.posZ) / this.fishPosRotationIncrements;
			double d3 = MathHelper.wrapAngleTo180_double(this.fishYaw - this.rotationYaw);
			this.rotationYaw = ((float)(this.rotationYaw + d3 / this.fishPosRotationIncrements));
			this.rotationPitch = ((float)(this.rotationPitch + (this.fishPitch - this.rotationPitch) / this.fishPosRotationIncrements));
			this.fishPosRotationIncrements -= 1;
			setPosition(d0, d1, d2);
			setRotation(this.rotationYaw, this.rotationPitch);
		}
		else
		{
			if((!this.worldObj.isRemote) && (this.angler != null))
			{
				ItemStack itemstack = this.angler.getCurrentEquippedItem();

				if((this.angler.isDead) || (!this.angler.isEntityAlive()) || (itemstack == null) || !itemstack.getItem().equals(NanotechItem.reinforcedFishingRod) || (getDistanceSqToEntity(this.angler) > 4096.0D))
				{
					setDead();
					this.angler.fishEntity = null;
					return;
				}

				if(this.bobber != null)
				{
					if(!this.bobber.isDead)
					{
						this.posX = this.bobber.posX;
						this.posY = (this.bobber.boundingBox.minY + this.bobber.height * 0.8D);
						this.posZ = this.bobber.posZ;
						return;
					}

					this.bobber = null;
				}
			}

			if(this.shake > 0)
			{
				this.shake -= 1;
			}

			if(this.inGround)
			{
				int i = this.worldObj.getBlockId(this.xTile, this.yTile, this.zTile);

				if(i == this.inTile)
				{
					this.ticksInGround += 1;

					if(this.ticksInGround == 1200)
					{
						setDead();
					}

					return;
				}

				this.inGround = false;
				this.motionX *= this.rand.nextFloat() * 0.2F;
				this.motionY *= this.rand.nextFloat() * 0.2F;
				this.motionZ *= this.rand.nextFloat() * 0.2F;
				this.ticksInGround = 0;
				this.ticksInAir = 0;
			}
			else
			{
				this.ticksInAir += 1;
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

			for(int j = 0; j < list.size(); j++)
			{
				Entity entity1 = (Entity)list.get(j);

				if((entity1.canBeCollidedWith()) && ((entity1 != this.angler) || (this.ticksInAir >= 5)))
				{
					float f = 0.3F;
					AxisAlignedBB axisalignedbb = entity1.boundingBox.expand(f, f, f);
					MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec3, vec31);

					if(movingobjectposition1 != null)
					{
						double d5 = vec3.distanceTo(movingobjectposition1.hitVec);

						if((d5 < d4) || (d4 == 0.0D))
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
				if((movingobjectposition.entityHit != null) && (this.angler != null))
				{
					if((!(movingobjectposition.entityHit instanceof EntityBoat)) && (this.angler.capabilities.isCreativeMode))
					{
						if(movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.angler), 0.0F))
						{
							this.bobber = movingobjectposition.entityHit;
						}
					}
				}
				else
				{
					this.inGround = true;
				}
			}

			if(!this.inGround)
			{
				moveEntity(this.motionX, this.motionY, this.motionZ);
				float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
				this.rotationYaw = ((float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.141592653589793D));

				for(this.rotationPitch = ((float)(Math.atan2(this.motionY, f1) * 180.0D / 3.141592653589793D)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F);
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

				this.rotationPitch = (this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F);
				this.rotationYaw = (this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F);
				float f2 = 0.92F;

				if((this.onGround) || (this.isCollidedHorizontally))
				{
					f2 = 0.5F;
				}

				byte b0 = 5;
				double d6 = 0.0D;

				for(int k = 0; k < b0; k++)
				{
					double d7 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (k + 0) / b0 - 0.125D + 0.125D;
					double d8 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (k + 1) / b0 - 0.125D + 0.125D;
					AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getAABBPool().getAABB(this.boundingBox.minX, d7, this.boundingBox.minZ, this.boundingBox.maxX, d8, this.boundingBox.maxZ);

					if(this.worldObj.isAABBInMaterial(axisalignedbb1, Material.water))
					{
						d6 += 1.0D / b0;
					}

					if(this.isAABBInBlockId(this.worldObj, axisalignedbb1, NanotechBlock.liquidNitrogen.blockID))
					{
						this.isInNitrogen = true;

					}
					else
					{
						this.isInNitrogen = false;
					}
				}

				if(d6 > 0.0D)
				{
					if(this.ticksCatchable > 0)
					{
						this.ticksCatchable -= 1;
					}
					else
					{
						short chance = 250;

						if(this.worldObj.canLightningStrikeAt(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) + 1, MathHelper.floor_double(this.posZ)))
						{
							chance = 150;
						}

						if(this.rand.nextInt(chance) == 0)
						{
							this.ticksCatchable = (this.rand.nextInt(30) + 10);

							if(this.angler != null)
							{}

							this.motionY -= 0.2000000029802322D;
							playSound("liquid.splash", 0.25F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);

							float f3 = MathHelper.floor_double(this.boundingBox.minY);

							for(int l = 0; l < 1.0F + this.width * 20.0F; l++)
							{
								float f5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
								float f4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
								this.worldObj.spawnParticle("bubble", this.posX + f5, f3 + 1.0F, this.posZ + f4, this.motionX, this.motionY - this.rand.nextFloat() * 0.2F, this.motionZ);
							}

							for(int l = 0; l < 1.0F + this.width * 20.0F; l++)
							{
								float f5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
								float f4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width;
								this.worldObj.spawnParticle("splash", this.posX + f5, f3 + 1.0F, this.posZ + f4, this.motionX, this.motionY, this.motionZ);
							}
						}
					}
				}

				if(this.ticksCatchable > 0)
				{
					this.motionY -= this.rand.nextFloat() * this.rand.nextFloat() * this.rand.nextFloat() * 0.2D;
				}

				double d5 = d6 * 2.0D - 1.0D;
				this.motionY += 0.03999999910593033D * d5;

				if(d6 > 0.0D)
				{
					f2 = (float)(f2 * 0.9D);
					this.motionY *= 0.8D;
				}

				this.motionX *= f2;
				this.motionY *= f2;
				this.motionZ *= f2;
				setPosition(this.posX, this.posY, this.posZ);
			}
		}
	}

	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		par1NBTTagCompound.setShort("xTile", (short)this.xTile);
		par1NBTTagCompound.setShort("yTile", (short)this.yTile);
		par1NBTTagCompound.setShort("zTile", (short)this.zTile);
		par1NBTTagCompound.setByte("inTile", (byte)this.inTile);
		par1NBTTagCompound.setByte("shake", (byte)this.shake);
		par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		this.xTile = par1NBTTagCompound.getShort("xTile");
		this.yTile = par1NBTTagCompound.getShort("yTile");
		this.zTile = par1NBTTagCompound.getShort("zTile");
		this.inTile = (par1NBTTagCompound.getByte("inTile") & 0xFF);
		this.shake = (par1NBTTagCompound.getByte("shake") & 0xFF);
		this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
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
				ItemStack stack;
				if(this.isInNitrogen)
				{
					stack = new ItemStack(NanotechItem.itemBase, 1, 17);
				}
				else
				{
					stack = new ItemStack(Item.fishRaw, 1, 0);
				}

				EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, stack);

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

	public void setDead()
	{
		super.setDead();

		if(this.angler != null)
		{
			this.angler.fishEntity = null;
		}
	}

	public boolean isAABBInBlockId(World world, AxisAlignedBB axisAlignedBB, int blockId)
	{
		int i = MathHelper.floor_double(axisAlignedBB.minX);
		int j = MathHelper.floor_double(axisAlignedBB.maxX + 1.0D);
		int k = MathHelper.floor_double(axisAlignedBB.minY);
		int l = MathHelper.floor_double(axisAlignedBB.maxY + 1.0D);
		int i1 = MathHelper.floor_double(axisAlignedBB.minZ);
		int j1 = MathHelper.floor_double(axisAlignedBB.maxZ + 1.0D);

		for(int k1 = i; k1 < j; ++k1)
		{
			for(int l1 = k; l1 < l; ++l1)
			{
				for(int i2 = i1; i2 < j1; ++i2)
				{
					if(world.getBlockId(k1, l1, i2) == blockId || world.getBlockId(k1, l1 - 1, i2) == blockId)
					{
						int j2 = world.getBlockMetadata(k1, l1, i2);
						double d0 = (double)(l1 + 1);

						if(j2 < 8)
						{
							d0 = (double)(l1 + 1) - (double)j2 / 8.0D;
						}

						if(d0 >= axisAlignedBB.minY)
						{
							return true;
						}
					}
				}
			}
		}

		return false;
	}
}