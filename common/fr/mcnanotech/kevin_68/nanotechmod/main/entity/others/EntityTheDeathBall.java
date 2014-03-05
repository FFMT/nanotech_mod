/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.entity.others;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityTheDeathBall extends EntityFireball
{
	public EntityTheDeathBall(World world)
	{
		super(world);
		this.setSize(1.3125F, 1.3125F);
	}

	public EntityTheDeathBall(World world, EntityLiving entityliving, double x, double y, double z)
	{
		super(world, entityliving, x, y, z);
		this.setSize(1.3125F, 1.3125F);
	}

	@Override
	protected float getMotionFactor()
	{
		return this.isInvulnerable() ? 0.73F : super.getMotionFactor();
	}

	@SideOnly(Side.CLIENT)
	public EntityTheDeathBall(World world, double x, double y, double z, double velx, double vely, double velz)
	{
		super(world, x, y, z, velx, vely, velz);
		this.setSize(1.3125F, 1.3125F);
	}

	@Override
	public boolean isBurning()
	{
		return false;
	}

	@Override
	public float func_145772_a(Explosion explosion, World world, int x, int y, int z, Block block)
	{
		float var6 = super.func_145772_a(explosion, world, x, y, z, block);
		if(this.isInvulnerable() && block != Blocks.bedrock && block != Blocks.end_portal && block != Blocks.end_portal_frame)
		{
			var6 = Math.min(0.8F, var6);
		}
		return var6;
	}

	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition)
	{
		if(!this.worldObj.isRemote)
		{
			if(movingobjectposition.entityHit != null)
			{
				if(this.shootingEntity != null)
				{
					if(movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeMobDamage(this.shootingEntity), 8) && !movingobjectposition.entityHit.isEntityAlive())
					{
						this.shootingEntity.heal(10);
					}
				}
				else
				{
					movingobjectposition.entityHit.attackEntityFrom(DamageSource.magic, 10);
				}

				if(movingobjectposition.entityHit instanceof EntityLiving)
				{
					byte var2 = 0;

					if(this.worldObj.difficultySetting.getDifficultyId() > 1)
					{
						if(this.worldObj.difficultySetting.getDifficultyId() == 2)
						{
							var2 = 50;
						}
						else if(this.worldObj.difficultySetting.getDifficultyId() == 3)
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

	public boolean attackEntityFrom(DamageSource damagesource, int par2)
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
