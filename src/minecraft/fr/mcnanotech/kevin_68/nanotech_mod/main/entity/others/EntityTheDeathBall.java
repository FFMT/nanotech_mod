package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTheDeathBall extends EntityFireball
{
	public EntityTheDeathBall(World par1World)
	{
		super(par1World);
		this.setSize(1.3125F, 1.3125F);
	}

	public EntityTheDeathBall(World par1World, EntityLiving par2EntityLiving, double par3, double par5, double par7)
	{
		super(par1World, par2EntityLiving, par3, par5, par7);
		this.setSize(1.3125F, 1.3125F);
	}

	protected float getMotionFactor()
	{
		return this.isInvulnerable() ? 0.73F : super.getMotionFactor();
	}

	@SideOnly(Side.CLIENT)
	public EntityTheDeathBall(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
	{
		super(par1World, par2, par4, par6, par8, par10, par12);
		this.setSize(1.3125F, 1.3125F);
	}

	/**
	 * Returns true if the entity is on fire. Used by render to add the fire
	 * effect on rendering.
	 */
	public boolean isBurning()
	{
		return false;
	}

	public float func_82146_a(Explosion explosion, World world, int x, int y, int z, Block block)
	{
		float var6 = super.func_82146_a(explosion, world, x, y, z, block);
		if(this.isInvulnerable() && block != Block.bedrock && block != Block.endPortal && block != Block.endPortalFrame)
		{
			var6 = Math.min(0.8F, var6);
		}
		return var6;
	}

	protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
	{
		if(!this.worldObj.isRemote)
		{
			if(par1MovingObjectPosition.entityHit != null)
			{
				if(this.shootingEntity != null)
				{
					if(par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingEntity), 8) && !par1MovingObjectPosition.entityHit.isEntityAlive())
					{
						this.shootingEntity.heal(10);
					}
				} else
				{
					par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.magic, 10);
				}

				if(par1MovingObjectPosition.entityHit instanceof EntityLiving)
				{
					byte var2 = 0;

					if(this.worldObj.difficultySetting > 1)
					{
						if(this.worldObj.difficultySetting == 2)
						{
							var2 = 50;
						} else if(this.worldObj.difficultySetting == 3)
						{
							var2 = 100;
						}
					}
				}
			}

			this.worldObj.newExplosion(this, this.posX, this.posY, this.posZ, 1.0F, false, this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
			this.setDead();
		}
	}

	public boolean canBeCollidedWith()
	{
		return false;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
	{
		return false;
	}

	protected void entityInit()
	{
		this.dataWatcher.addObject(10, Byte.valueOf((byte)0));
	}

	public boolean isInvulnerable()
	{
		return this.dataWatcher.getWatchableObjectByte(10) == 1;
	}

	public void setInvulnerable(boolean par1)
	{
		this.dataWatcher.updateObject(10, Byte.valueOf((byte)(par1 ? 1 : 0)));
	}
}
