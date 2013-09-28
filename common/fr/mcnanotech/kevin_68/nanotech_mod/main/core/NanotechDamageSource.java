package fr.mcnanotech.kevin_68.nanotech_mod.main.core;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.util.StatCollector;

public class NanotechDamageSource extends DamageSource
{
	public static DamageSource sodiumDamage;
	public Random rand = new Random();

	protected NanotechDamageSource(String par1Str)
	{
		super(par1Str);
	}

	public static void loadDamageSource()
	{
		sodiumDamage = new NanotechDamageSource("sodium").setDamageBypassesArmor();
	}

	public ChatMessageComponent getDeathMessage(EntityLivingBase livingBase)
	{
		EntityLivingBase entitylivingbase1 = livingBase.func_94060_bK();
		String s = "deathMessage." + this.damageType + "." + rand.nextInt(2);
		String s1 = s + ".player";
		return entitylivingbase1 != null && StatCollector.func_94522_b(s1) ? ChatMessageComponent.createFromTranslationWithSubstitutions(s1, new Object[] {livingBase.getTranslatedEntityName(), entitylivingbase1.getTranslatedEntityName()}) : ChatMessageComponent.createFromTranslationWithSubstitutions(s, new Object[] {livingBase.getTranslatedEntityName()});
	}
}