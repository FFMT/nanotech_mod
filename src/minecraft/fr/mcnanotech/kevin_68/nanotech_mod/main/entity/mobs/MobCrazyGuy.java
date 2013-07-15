package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTwardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MobCrazyGuy extends EntityMob
{

	public MobCrazyGuy(World par1World) 
	{
		super(par1World);
		this.moveSpeed = 0.80F;
		this.texture = "/mob/zombie.png";
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, this.moveSpeed, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, MobThedeath.class, this.moveSpeed, false));
		this.tasks.addTask(4, new EntityAIMoveTwardsRestriction(this, this.moveSpeed));
		this.tasks.addTask(6, new EntityAIWander(this, this.moveSpeed));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 40.0F));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, MobThedeath.class, 40.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 40.0F, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, MobThedeath.class, 40.0F, 0, true));

	}

	@Override
	public int getMaxHealth() 
	{
		return 50;
	}
	
	public int getAttackStrength(Entity par1Entity)
	{
		ItemStack var2 = this.getHeldItem();
		int var3 = 3;

		if (var2 != null)
		{
			var3 += var2.getDamageVsEntity(this);
		}

		return var3;
	}
	
	protected String getLivingSound()
	{
		return "";
	}

	protected String getHurtSound()
	{
		return "";
	}

	protected String getDeathSound()
	{
		return "";
	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

	protected boolean isAIEnabled()
	{
		return true;
	}
	
	protected int getDropItemId()
	{
		return Item.gunpowder.itemID;
	}
}
