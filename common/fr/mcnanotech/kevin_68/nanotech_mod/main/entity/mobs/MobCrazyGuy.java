package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class MobCrazyGuy extends EntityMob
{

	public MobCrazyGuy(World world)
	{
		super(world);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, MobThedeath.class, 1.0D, false));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 40.0F));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, MobThedeath.class, 40.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, MobThedeath.class, 0, true));

	}

	 @Override
	 protected void func_110147_ax()
	 {
		 super.func_110147_ax();
		 this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(50D);
	     this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0D);
		 this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.80D);
		 this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0D);
	 }

	protected String getLivingSound()
	{
		return "Nanotech_mod:CrazyGuy";
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
		return NanotechItem.crazyGlasses.itemID;
	}
}
