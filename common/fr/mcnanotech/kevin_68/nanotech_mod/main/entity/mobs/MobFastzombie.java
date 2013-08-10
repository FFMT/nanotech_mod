package fr.mcnanotech.kevin_68.nanotech_mod.main.entity.mobs;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.main.items.NanotechItem;

public class MobFastzombie extends EntityMob
{
	public MobFastzombie(World world)
	{
		super(world);
		this.getNavigator().setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(3, new EntityAIAvoidEntity(this, MobThedeath.class, 6.0F, 0.25F, 1.0F));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 40.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	 @Override
	 protected void func_110147_ax()
	 {
		 super.func_110147_ax();
		 this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(2D);
	     this.func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(40.0D);
		 this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(1.0D);
		 this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1D);
	 }
	
	protected void fall(float damage)
	{}

	public int getTotalArmorValue()
	{
		return 3;
	}

	protected boolean isAIEnabled()
	{
		return true;
	}

	public void onLivingUpdate()
	{
		for(int k = 0; k < 2; k++)
		{
			worldObj.spawnParticle("portal", posX + (rand.nextDouble() - 0.5D) * (double)width, (posY + rand.nextDouble() * (double)height) - 0.25D, posZ + (rand.nextDouble() - 0.5D) * (double)width, (rand.nextDouble() - 0.5D) * 2D, -rand.nextDouble(), (rand.nextDouble() - 0.5D) * 2D);
		}

		super.onLivingUpdate();
	}

	protected String getLivingSound()
	{
		return "mob.zombie.say";
	}

	protected String getHurtSound()
	{
		return "mob.zombiehurt";
	}

	protected String getDeathSound()
	{
		return "mob.zombiedead";
	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

	
	 protected int getDropItemId() 
	 { 
		 return NanotechItem.Edibleflesh.itemID; 
		 }
	 
	protected void dropRareDrop(int par1)
	{
		switch(this.rand.nextInt(4))
		{
		case 0:
			this.dropItem(Item.swordIron.itemID, 1);
			break;
		case 1:
			this.dropItem(Item.helmetDiamond.itemID, 1);
			break;
		case 2:
			this.dropItem(Item.ingotGold.itemID, 1);
			break;
		case 3:
			this.dropItem(Item.shovelDiamond.itemID, 1);
			break;
		}
	}
}
