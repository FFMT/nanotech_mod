/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.other;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.StatCollector;

public class NanotechDamageSource extends DamageSource
{
    public static DamageSource sodiumDamage;
    public static DamageSource altersDamage;
    public static DamageSource nitrogenDamage;
    public static DamageSource barbedWireDamage;
    public static DamageSource lightSaberDamage;
    public static DamageSource sateliteDamage;
    public Random rand = new Random();

    protected NanotechDamageSource(String name)
    {
        super(name);
    }

    public static void loadDamageSource()
    {
        sodiumDamage = new NanotechDamageSource("sodium").setDamageBypassesArmor();
        altersDamage = new NanotechDamageSource("alters").setDamageBypassesArmor();
        nitrogenDamage = new NanotechDamageSource("nitrogen").setDamageBypassesArmor();
        barbedWireDamage = new NanotechDamageSource("barbedWire");
        lightSaberDamage = new NanotechDamageSource("lightSaberDamage");
        sateliteDamage = new NanotechDamageSource("sateliteDamage").setDamageBypassesArmor();
    }

    @Override
    public IChatComponent func_151519_b(EntityLivingBase livingBase)
    {
        EntityLivingBase entitylivingbase1 = livingBase.func_94060_bK();
        int randInt = 0;
        if(this.damageType.equals("sodium"))
        {
            randInt = rand.nextInt(3);
        }
        String s = "death.attack." + this.damageType + "." + randInt;
        String s1 = s + ".player";
        return entitylivingbase1 != null && StatCollector.canTranslate(s1) ? new ChatComponentTranslation(s1, new Object[] {livingBase.func_145748_c_(), entitylivingbase1.func_145748_c_()}) : new ChatComponentTranslation(s, new Object[] {livingBase.func_145748_c_()});
    }
}