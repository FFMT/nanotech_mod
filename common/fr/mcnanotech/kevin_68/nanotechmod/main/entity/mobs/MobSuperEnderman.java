/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs;

import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class MobSuperEnderman extends EntityMob
{
	private static final UUID attackingSpeedBoostModifierUUID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final AttributeModifier attackingSpeedBoostModifier = (new AttributeModifier(attackingSpeedBoostModifierUUID, "Attacking speed boost", 6.199999809265137D, 0)).setSaved(false);
	private static boolean[] carriableBlocks = new boolean[256];
	private int teleportDelay;
	private int stareTimer;
	private Entity lastEntityToAttack;
	private boolean isAggressive;

	public MobSuperEnderman(World par1World)
	{
		super(par1World);
		this.setSize(0.6F, 2.9F);
		this.stepHeight = 1.0F;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(120.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12.0D);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
		this.dataWatcher.addObject(17, new Byte((byte)0));
		this.dataWatcher.addObject(18, new Byte((byte)0));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("carried", (short)Block.getIdFromBlock(this.func_146080_bZ()));
		par1NBTTagCompound.setShort("carriedData", (short)this.getCarryingData());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.func_146081_a(Block.getBlockById(par1NBTTagCompound.getShort("carried")));
		this.setCarryingData(par1NBTTagCompound.getShort("carriedData"));
	}

	@Override
	protected Entity findPlayerToAttack()
	{
		EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);

		if(entityplayer != null)
		{
			if(this.shouldAttackPlayer(entityplayer))
			{
				this.isAggressive = true;

				if(this.stareTimer == 0)
				{
					this.worldObj.playSoundEffect(entityplayer.posX, entityplayer.posY, entityplayer.posZ, "mob.endermen.stare", 1.0F, 1.0F);
				}

				if(this.stareTimer++ == 5)
				{
					this.stareTimer = 0;
					this.setScreaming(true);
					return entityplayer;
				}
			}
			else
			{
				this.stareTimer = 0;
			}
		}

		return null;
	}

	private boolean shouldAttackPlayer(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.armorInventory[3];

		if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.pumpkin))
		{
			return false;
		}
		else
		{
			Vec3 vec3 = par1EntityPlayer.getLook(1.0F).normalize();
			Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX - par1EntityPlayer.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (par1EntityPlayer.posY + (double)par1EntityPlayer.getEyeHeight()), this.posZ - par1EntityPlayer.posZ);
			double d0 = vec31.lengthVector();
			vec31 = vec31.normalize();
			double d1 = vec3.dotProduct(vec31);
			return d1 > 1.0D - 0.025D / d0 ? par1EntityPlayer.canEntityBeSeen(this) : false;
		}
	}

	@Override
	public void onLivingUpdate()
	{
		if(this.isWet())
		{
			this.attackEntityFrom(DamageSource.drown, 1.0F);
		}

		if(this.lastEntityToAttack != this.entityToAttack)
		{
			IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			iattributeinstance.removeModifier(attackingSpeedBoostModifier);

			if(this.entityToAttack != null)
			{
				iattributeinstance.applyModifier(attackingSpeedBoostModifier);
			}
		}

		this.lastEntityToAttack = this.entityToAttack;
		int k;

		if(!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"))
		{
			int i;
			int j;
			Block block;

			if(this.func_146080_bZ().getMaterial() == Material.air)
			{
				if(this.rand.nextInt(20) == 0)
				{
					k = MathHelper.floor_double(this.posX - 2.0D + this.rand.nextDouble() * 4.0D);
					i = MathHelper.floor_double(this.posY + this.rand.nextDouble() * 3.0D);
					j = MathHelper.floor_double(this.posZ - 2.0D + this.rand.nextDouble() * 4.0D);
					block = this.worldObj.getBlock(k, i, j);

					if(carriableBlocks[Block.getIdFromBlock(block)])
					{
						this.func_146081_a(block);
						this.setCarryingData(this.worldObj.getBlockMetadata(k, i, j));
						this.worldObj.setBlock(k, i, j, Blocks.air);
					}
				}
			}
			else if(this.rand.nextInt(2000) == 0)
			{
				k = MathHelper.floor_double(this.posX - 1.0D + this.rand.nextDouble() * 2.0D);
				i = MathHelper.floor_double(this.posY + this.rand.nextDouble() * 2.0D);
				j = MathHelper.floor_double(this.posZ - 1.0D + this.rand.nextDouble() * 2.0D);
				block = this.worldObj.getBlock(k, i, j);
				Block block1 = this.worldObj.getBlock(k, i - 1, j);

				if(block.getMaterial() == Material.air && block1.getMaterial() != Material.air && block1.renderAsNormalBlock())
				{
					this.worldObj.setBlock(k, i, j, this.func_146080_bZ(), this.getCarryingData(), 3);
					this.func_146081_a(Blocks.air);
				}
			}
		}

		for(k = 0; k < 2; ++k)
		{
			this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
		}

		if(this.worldObj.isDaytime() && !this.worldObj.isRemote)
		{
			float f = this.getBrightness(1.0F);

			if(f > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F)
			{
				this.entityToAttack = null;
				this.setScreaming(false);
				this.isAggressive = false;
				this.teleportRandomly();
			}
		}

		if(this.isWet() || this.isBurning())
		{
			this.entityToAttack = null;
			this.setScreaming(false);
			this.isAggressive = false;
			this.teleportRandomly();
		}

		if(this.isScreaming() && !this.isAggressive && this.rand.nextInt(100) == 0)
		{
			this.setScreaming(false);
		}

		this.isJumping = false;

		if(this.entityToAttack != null)
		{
			this.faceEntity(this.entityToAttack, 100.0F, 100.0F);
		}

		if(!this.worldObj.isRemote && this.isEntityAlive())
		{
			if(this.entityToAttack != null)
			{
				if(this.entityToAttack instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer)this.entityToAttack))
				{
					if(this.entityToAttack.getDistanceSqToEntity(this) < 16.0D)
					{
						this.teleportRandomly();
					}

					this.teleportDelay = 0;
				}
				else if(this.entityToAttack.getDistanceSqToEntity(this) > 256.0D && this.teleportDelay++ >= 30 && this.teleportToEntity(this.entityToAttack))
				{
					this.teleportDelay = 0;
				}
			}
			else
			{
				this.setScreaming(false);
				this.teleportDelay = 0;
			}
		}

		super.onLivingUpdate();
	}

	protected boolean teleportRandomly()
	{
		double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * 64.0D;
		double d1 = this.posY + (double)(this.rand.nextInt(64) - 32);
		double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * 64.0D;
		return this.teleportTo(d0, d1, d2);
	}

	protected boolean teleportToEntity(Entity par1Entity)
	{
		Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX - par1Entity.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - par1Entity.posY + (double)par1Entity.getEyeHeight(), this.posZ - par1Entity.posZ);
		vec3 = vec3.normalize();
		double d0 = 16.0D;
		double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.xCoord * d0;
		double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
		double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.zCoord * d0;
		return this.teleportTo(d1, d2, d3);
	}

	protected boolean teleportTo(double par1, double par3, double par5)
	{
		EnderTeleportEvent event = new EnderTeleportEvent(this, par1, par3, par5, 0);
		if(MinecraftForge.EVENT_BUS.post(event))
		{
			return false;
		}
		double d3 = this.posX;
		double d4 = this.posY;
		double d5 = this.posZ;
		this.posX = event.targetX;
		this.posY = event.targetY;
		this.posZ = event.targetZ;
		boolean flag = false;
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.posY);
		int k = MathHelper.floor_double(this.posZ);

		if(this.worldObj.blockExists(i, j, k))
		{
			boolean flag1 = false;

			while(!flag1 && j > 0)
			{
				Block block = this.worldObj.getBlock(i, j - 1, k);

				if(block.getMaterial().blocksMovement())
				{
					flag1 = true;
				}
				else
				{
					--this.posY;
					--j;
				}
			}

			if(flag1)
			{
				this.setPosition(this.posX, this.posY, this.posZ);

				if(this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
				{
					flag = true;
				}
			}
		}

		if(!flag)
		{
			this.setPosition(d3, d4, d5);
			return false;
		}
		else
		{
			short short1 = 128;

			for(int l = 0; l < short1; ++l)
			{
				double d6 = (double)l / ((double)short1 - 1.0D);
				float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
				double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
				double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double)this.height;
				double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
				this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
			}

			this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
			this.playSound("mob.endermen.portal", 1.0F, 1.0F);
			return true;
		}
	}

	@Override
	protected String getLivingSound()
	{
		return this.isScreaming() ? "mob.endermen.scream" : "mob.endermen.idle";
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.endermen.hit";
	}

	@Override
	protected String getDeathSound()
	{
		return "mob.endermen.death";
	}

	@Override
	protected Item getDropItem()
	{
		return Items.ender_eye;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		Item item = this.getDropItem();

		if(item != null)
		{
			int j = this.rand.nextInt(2 + par2);

			for(int k = 0; k < j; ++k)
			{
				this.dropItem(item, 1);
			}
		}
	}

	public void func_146081_a(Block p_146081_1_)
	{
		this.dataWatcher.updateObject(16, Byte.valueOf((byte)(Block.getIdFromBlock(p_146081_1_) & 255)));
	}

	public Block func_146080_bZ()
	{
		return Block.getBlockById(this.dataWatcher.getWatchableObjectByte(16));
	}

	public void setCarryingData(int par1)
	{
		this.dataWatcher.updateObject(17, Byte.valueOf((byte)(par1 & 255)));
	}

	public int getCarryingData()
	{
		return this.dataWatcher.getWatchableObjectByte(17);
	}

	@Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
	{
		if(this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			this.setScreaming(true);

			if(par1DamageSource instanceof EntityDamageSource && par1DamageSource.getEntity() instanceof EntityPlayer)
			{
				this.isAggressive = true;
			}

			if(par1DamageSource instanceof EntityDamageSourceIndirect)
			{
				this.isAggressive = false;

				for(int i = 0; i < 64; ++i)
				{
					if(this.teleportRandomly())
					{
						return true;
					}
				}

				return super.attackEntityFrom(par1DamageSource, par2);
			}
			else
			{
				return super.attackEntityFrom(par1DamageSource, par2);
			}
		}
	}

	public boolean isScreaming()
	{
		return this.dataWatcher.getWatchableObjectByte(18) > 0;
	}

	public void setScreaming(boolean par1)
	{
		this.dataWatcher.updateObject(18, Byte.valueOf((byte)(par1 ? 1 : 0)));
	}

	static
	{
		carriableBlocks[Block.getIdFromBlock(Blocks.grass)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.dirt)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.sand)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.gravel)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.yellow_flower)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.red_flower)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.brown_mushroom)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.red_mushroom)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.tnt)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.cactus)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.clay)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.pumpkin)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.melon_block)] = true;
		carriableBlocks[Block.getIdFromBlock(Blocks.mycelium)] = true;
	}
}