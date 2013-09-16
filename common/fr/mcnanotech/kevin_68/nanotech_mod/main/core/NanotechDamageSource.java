package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;

public class NanotechDamageSource extends DamageSource
{
	public static DamageSource sodiumDamage;

	protected NanotechDamageSource(String par1Str)
	{
		super(par1Str);
	}

	public void loadDamageSource()
	{
		sodiumDamage = new NanotechDamageSource("sodium").setDamageBypassesArmor();
	}
}