package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.attributes.AttributeInstance;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class MobSuperEnderman extends EntityMob
{
	public static boolean[] carriableBlocks = new boolean[256];

	private int teleportDelay = 0;
	private int field_70826_g = 0;

	public MobSuperEnderman(World world)
	{
		super(world);
		this.setSize(0.6F, 2.9F);
		this.stepHeight = 1.0F;
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, MobThedeath.class, 6.0F, 0.25F, 0.5F));
	}
	
	 @Override
	 protected void func_110147_ax()
	 {
		 super.func_110147_ax();
		 this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100D);
	     this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0D);
		 this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20D);
		 this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0D);
	 }

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
		this.dataWatcher.addObject(17, new Byte((byte)0));
		this.dataWatcher.addObject(18, new Byte((byte)0));
	}

	public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	{
		super.writeEntityToNBT(nbttagcompound);
		nbttagcompound.setShort("carried", (short)this.getCarried());
		nbttagcompound.setShort("carriedData", (short)this.getCarryingData());
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	{
		super.readEntityFromNBT(nbttagcompound);
		this.setCarried(nbttagcompound.getShort("carried"));
		this.setCarryingData(nbttagcompound.getShort("carriedData"));
	}

	protected Entity findPlayerToAttack()
	{
		EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 64.0D);

		if(var1 != null)
		{
			if(this.shouldAttackPlayer(var1))
			{
				if(this.field_70826_g == 0)
				{
					this.worldObj.playSoundAtEntity(var1, "mob.endermen.stare", 1.0F, 1.0F);
				}

				if(this.field_70826_g++ == 5)
				{
					this.field_70826_g = 0;
					this.setScreaming(true);
					return var1;
				}
			}
			else
			{
				this.field_70826_g = 0;
			}
		}

		return null;
	}

	private boolean shouldAttackPlayer(EntityPlayer player)
	{
		ItemStack var2 = player.inventory.armorInventory[3];

		if(var2 != null && var2.itemID == Block.pumpkin.blockID)
		{
			return false;
		}
		else
		{
			Vec3 var3 = player.getLook(1.0F).normalize();
			Vec3 var4 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX - player.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - (player.posY + (double)player.getEyeHeight()), this.posZ - player.posZ);
			double var5 = var4.lengthVector();
			var4 = var4.normalize();
			double var7 = var3.dotProduct(var4);
			return var7 > 1.0D - 0.025D / var5 ? player.canEntityBeSeen(this) : false;
		}
	}
	
	private Entity field_110194_bu;
    private static final UUID field_110192_bp = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
    private static final AttributeModifier field_110193_bq = (new AttributeModifier(field_110192_bp, "Attacking speed boost", 6.199999809265137D, 0)).func_111168_a(false);
    private boolean field_104003_g;
    
    public void onLivingUpdate()
    {
        if (this.isWet())
        {
            this.attackEntityFrom(DamageSource.drown, 1.0F);
        }

        if (this.field_110194_bu != this.entityToAttack)
        {
            AttributeInstance attributeinstance = this.func_110148_a(SharedMonsterAttributes.field_111263_d);
            attributeinstance.func_111124_b(field_110193_bq);

            if (this.entityToAttack != null)
            {
                attributeinstance.func_111121_a(field_110193_bq);
            }
        }

        this.field_110194_bu = this.entityToAttack;
        int i;

        if (!this.worldObj.isRemote && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"))
        {
            int j;
            int k;
            int l;

            if (this.getCarried() == 0)
            {
                if (this.rand.nextInt(20) == 0)
                {
                    i = MathHelper.floor_double(this.posX - 2.0D + this.rand.nextDouble() * 4.0D);
                    j = MathHelper.floor_double(this.posY + this.rand.nextDouble() * 3.0D);
                    k = MathHelper.floor_double(this.posZ - 2.0D + this.rand.nextDouble() * 4.0D);
                    l = this.worldObj.getBlockId(i, j, k);

                    if (carriableBlocks[l])
                    {
                        this.setCarried(this.worldObj.getBlockId(i, j, k));
                        this.setCarryingData(this.worldObj.getBlockMetadata(i, j, k));
                        this.worldObj.setBlock(i, j, k, 0);
                    }
                }
            }
            else if (this.rand.nextInt(2000) == 0)
            {
                i = MathHelper.floor_double(this.posX - 1.0D + this.rand.nextDouble() * 2.0D);
                j = MathHelper.floor_double(this.posY + this.rand.nextDouble() * 2.0D);
                k = MathHelper.floor_double(this.posZ - 1.0D + this.rand.nextDouble() * 2.0D);
                l = this.worldObj.getBlockId(i, j, k);
                int i1 = this.worldObj.getBlockId(i, j - 1, k);

                if (l == 0 && i1 > 0 && Block.blocksList[i1].renderAsNormalBlock())
                {
                    this.worldObj.setBlock(i, j, k, this.getCarried(), this.getCarryingData(), 3);
                    this.setCarried(0);
                }
            }
        }

        for (i = 0; i < 2; ++i)
        {
            this.worldObj.spawnParticle("portal", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height - 0.25D, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, (this.rand.nextDouble() - 0.5D) * 2.0D, -this.rand.nextDouble(), (this.rand.nextDouble() - 0.5D) * 2.0D);
        }

        if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
        {
            float f = this.getBrightness(1.0F);

            if (f > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F)
            {
                this.entityToAttack = null;
                this.setScreaming(false);
                this.field_104003_g = false;
                this.teleportRandomly();
            }
        }

        if (this.isWet() || this.isBurning())
        {
            this.entityToAttack = null;
            this.setScreaming(false);
            this.field_104003_g = false;
            this.teleportRandomly();
        }

        if (this.isScreaming() && !this.field_104003_g && this.rand.nextInt(100) == 0)
        {
            this.setScreaming(false);
        }

        this.isJumping = false;

        if (this.entityToAttack != null)
        {
            this.faceEntity(this.entityToAttack, 100.0F, 100.0F);
        }

        if (!this.worldObj.isRemote && this.isEntityAlive())
        {
            if (this.entityToAttack != null)
            {
                if (this.entityToAttack instanceof EntityPlayer && this.shouldAttackPlayer((EntityPlayer)this.entityToAttack))
                {
                    if (this.entityToAttack.getDistanceSqToEntity(this) < 16.0D)
                    {
                        this.teleportRandomly();
                    }

                    this.teleportDelay = 0;
                }
                else if (this.entityToAttack.getDistanceSqToEntity(this) > 256.0D && this.teleportDelay++ >= 30 && this.teleportToEntity(this.entityToAttack))
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
        if (MinecraftForge.EVENT_BUS.post(event)){
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
        int l;

        if (this.worldObj.blockExists(i, j, k))
        {
            boolean flag1 = false;

            while (!flag1 && j > 0)
            {
                l = this.worldObj.getBlockId(i, j - 1, k);

                if (l != 0 && Block.blocksList[l].blockMaterial.blocksMovement())
                {
                    flag1 = true;
                }
                else
                {
                    --this.posY;
                    --j;
                }
            }

            if (flag1)
            {
                this.setPosition(this.posX, this.posY, this.posZ);

                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
                {
                    flag = true;
                }
            }
        }

        if (!flag)
        {
            this.setPosition(d3, d4, d5);
            return false;
        }
        else
        {
            short short1 = 128;

            for (l = 0; l < short1; ++l)
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
    
	protected String getLivingSound()
	{
		return this.isScreaming() ? "mob.endermen.scream" : "mob.endermen.idle";
	}

	protected String getHurtSound()
	{
		return "mob.endermen.hit";
	}

	protected String getDeathSound()
	{
		return "mob.endermen.death";
	}

	protected int getDropItemId()
	{
		return Item.enderPearl.itemID;
	}

	protected void dropFewItems(boolean killbyplayer, int lootinglevel)
	{
		int var3 = this.getDropItemId();

		if(var3 > 0)
		{
			int var4 = this.rand.nextInt(2 + lootinglevel);

			for(int var5 = 0; var5 < var4; ++var5)
			{
				this.dropItem(var3, 1);
			}
		}
	}

	public void setCarried(int par1)
	{
		this.dataWatcher.updateObject(16, Byte.valueOf((byte)(par1 & 255)));
	}

	public int getCarried()
	{
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	public void setCarryingData(int par1)
	{
		this.dataWatcher.updateObject(17, Byte.valueOf((byte)(par1 & 255)));
	}

	public int getCarryingData()
	{
		return this.dataWatcher.getWatchableObjectByte(17);
	}

	public boolean attackEntityFrom(DamageSource damagesource, int par2)
	{
		if(damagesource instanceof EntityDamageSourceIndirect)
		{
			for(int var3 = 0; var3 < 64; ++var3)
			{
				if(this.teleportRandomly())
				{
					return true;
				}
			}

			return false;
		}
		else
		{
			if(damagesource.getEntity() instanceof EntityPlayer)
			{
				this.setScreaming(true);
			}

			return super.attackEntityFrom(damagesource, par2);
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


	public int getAttackStrength(Entity par1Entity)
	{
		return 7;
	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}
}
