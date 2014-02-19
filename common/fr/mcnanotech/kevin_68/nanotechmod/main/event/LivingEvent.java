/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.event;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.NanotechItem;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechAchievement;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechDamageSource;
import fr.mcnanotech.kevin_68.nanotechmod.main.other.NanotechOther;

public class LivingEvent
{
	@SubscribeEvent
	public void onLivingFall(LivingFallEvent event)
	{
		ItemStack boots = event.entityLiving.getEquipmentInSlot(1);

		if(boots != null && boots.getItem().equals(NanotechItem.mysteriousBoots))
		{
			boots.damageItem((int)(event.distance / 8), event.entityLiving);
			if(boots.stackSize == 0)
			{
				event.entityLiving.setCurrentItemOrArmor(1, null);
			}
			event.distance = 0F;
		}
	}

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		if(event.entityLiving.isPotionActive(NanotechOther.freeze))
		{
			event.entityLiving.attackEntityFrom(NanotechDamageSource.nitrogenDamage, 1);
			Block block = event.entityLiving.worldObj.getBlock((int)event.entityLiving.posX - 1, (int)event.entityLiving.posY, (int)event.entityLiving.posZ);
			if(block.equals(Blocks.flowing_water) || block.equals(Blocks.water))
			{
				event.entityLiving.worldObj.setBlock((int)event.entityLiving.posX - 1, (int)event.entityLiving.posY, (int)event.entityLiving.posZ, Blocks.ice);
			}
			else if(block.equals(Blocks.flowing_lava) || block.equals(Blocks.lava))
			{
				event.entityLiving.removePotionEffect(30);
				if(event.entityLiving.worldObj.getBlockMetadata((int)event.entityLiving.posX - 1, (int)event.entityLiving.posY, (int)event.entityLiving.posZ) == 0)
					event.entityLiving.worldObj.setBlock((int)event.entityLiving.posX - 1, (int)event.entityLiving.posY, (int)event.entityLiving.posZ, Blocks.obsidian);
				else
					event.entityLiving.worldObj.setBlock((int)event.entityLiving.posX - 1, (int)event.entityLiving.posY, (int)event.entityLiving.posZ, Blocks.cobblestone);
			}

			if(event.entityLiving.isBurning())
			{
				event.entityLiving.removePotionEffect(30);
			}
		}
	}

	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
		if(event.source.equals(NanotechDamageSource.nitrogenDamage) && event.entityLiving.worldObj.isAirBlock((int)(event.entityLiving.posX - 1), (int)event.entityLiving.posY, (int)event.entityLiving.posZ))
		{
			event.entityLiving.worldObj.setBlock((int)(event.entityLiving.posX - 1), (int)event.entityLiving.posY, (int)event.entityLiving.posZ, Blocks.ice);
		}
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;

			if(event.source.equals(NanotechDamageSource.altersDamage))
			{
				player.triggerAchievement(NanotechAchievement.deathAlters);
			}
			if(event.source.equals(NanotechDamageSource.barbedWireDamage))
			{
				player.triggerAchievement(NanotechAchievement.deathBarbedWire);
			}
			if(event.source.equals(NanotechDamageSource.lightSaberDamage))
			{
				player.triggerAchievement(NanotechAchievement.deathLightLaser);
			}
			if(event.source.equals(NanotechDamageSource.nitrogenDamage))
			{
				player.triggerAchievement(NanotechAchievement.deathNitrogen);
			}
			if(event.source.equals(NanotechDamageSource.sateliteDamage))
			{
				player.triggerAchievement(NanotechAchievement.deathSatelit);
			}
			if(event.source.equals(NanotechDamageSource.sodiumDamage))
			{
				player.triggerAchievement(NanotechAchievement.deathSodium);
			}
		}
	}

	@SubscribeEvent
	public void onLivingHurt(LivingHurtEvent event)
	{
		if(event.source.isExplosion())
		{
			ItemStack boots = event.entityLiving.getEquipmentInSlot(1);
			ItemStack leggings = event.entityLiving.getEquipmentInSlot(2);
			ItemStack chestPlate = event.entityLiving.getEquipmentInSlot(3);
			ItemStack helmet = event.entityLiving.getEquipmentInSlot(4);
			if(boots != null && boots.getItem().equals(NanotechItem.mysteriousBoots) && leggings != null && leggings.getItem().equals(NanotechItem.mysteriousLeggings) && chestPlate != null && chestPlate.getItem().equals(NanotechItem.mysteriousChestPlate) && helmet != null && helmet.getItem().equals(NanotechItem.mysteriousHelmet))
			{
				boots.damageItem((int)(event.ammount / 10), event.entityLiving);
				leggings.damageItem((int)(event.ammount / 10), event.entityLiving);
				chestPlate.damageItem((int)(event.ammount / 10), event.entityLiving);
				helmet.damageItem((int)(event.ammount / 10), event.entityLiving);
				if(boots.stackSize == 0)
				{
					event.entityLiving.setCurrentItemOrArmor(1, null);
				}
				if(leggings.stackSize == 0)
				{
					event.entityLiving.setCurrentItemOrArmor(2, null);
				}
				if(chestPlate.stackSize == 0)
				{
					event.entityLiving.setCurrentItemOrArmor(3, null);
				}
				if(helmet.stackSize == 0)
				{
					event.entityLiving.setCurrentItemOrArmor(4, null);
				}
				event.setCanceled(true);
			}
		}
	}
}