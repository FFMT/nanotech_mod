package fr.mcnanotech.kevin_68.nanotech_mod.main.items;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class NanoArrowGunEntityFilter implements IEntitySelector
{
	@Override
	public boolean isEntityApplicable(Entity entity)
	{
		return entity instanceof EntityLivingBase;
	}
}