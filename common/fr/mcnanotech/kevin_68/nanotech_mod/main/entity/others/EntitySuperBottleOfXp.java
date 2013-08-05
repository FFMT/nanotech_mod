package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.others;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySuperBottleOfXp extends EntityThrowable
{
	public EntitySuperBottleOfXp(World world)
	{
		super(world);
	}

	public EntitySuperBottleOfXp(World world, EntityLiving entityliving)
	{
		super(world, entityliving);
	}

	public EntitySuperBottleOfXp(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}

	protected float getGravityVelocity()
	{
		return 0.07F;
	}

	protected float func_70182_d()
	{
		return 0.7F;
	}

	protected float func_70183_g()
	{
		return -20.0F;
	}

	protected void onImpact(MovingObjectPosition movingobjectposition)
	{
		if(!this.worldObj.isRemote)
		{
			this.worldObj.playAuxSFX(2002, (int)Math.round(this.posX), (int)Math.round(this.posY), (int)Math.round(this.posZ), 0);
			int var2 = 300 + this.worldObj.rand.nextInt(500) + this.worldObj.rand.nextInt(500);

			while(var2 > 0)
			{
				int var3 = EntityXPOrb.getXPSplit(var2);
				var2 -= var3;
				this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var3));
			}

			this.setDead();
		}
	}
}
