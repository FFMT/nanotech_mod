package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechDamageSource;

public class ItemAlters extends Item
{
	public ItemAlters()
	{
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		int highest = 0;

		int ampli = amplifyEffect(player, Potion.damageBoost);
		if(ampli > highest)
		{
			highest = ampli;
		}
		ampli = amplifyEffect(player, Potion.digSpeed);
		if(ampli > highest)
		{
			highest = ampli;
		}
		if(highest >= 3)
		{
			player.attackEntityFrom(NanotechDamageSource.altersDamage, 6.0F);
		}
		return stack;
	}

	public int amplifyEffect(EntityPlayer player, Potion potion)
	{
		PotionEffect eff = player.getActivePotionEffect(potion);
		if(eff != null)
		{
			int max = 1;
			max = 6;
			int newAmp = eff.getAmplifier();
			int newDur = eff.getDuration();
			if(newAmp < max)
			{
				newAmp++;
			}
			newDur += 500;
			eff.combine(new PotionEffect(eff.getPotionID(), newDur, newAmp));

			return newAmp;
		}

		player.addPotionEffect(new PotionEffect(potion.id, 300, 0));
		return 1;
	}

	@Override
	public void registerIcons(IIconRegister iconregister)
	{
		this.itemIcon = iconregister.registerIcon("nanotechmod:altersItem");
	}
}