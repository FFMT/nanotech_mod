package fr.mcnanotech.kevin_68.nanotechmod.main.entity.mobs;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;

public class EntityTheDeathAttackFilter implements IEntitySelector
{
	@Override
	public boolean isEntityApplicable(Entity entity)
	{
		return entity instanceof EntityLivingBase && ((EntityLivingBase)entity).getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
	}
}