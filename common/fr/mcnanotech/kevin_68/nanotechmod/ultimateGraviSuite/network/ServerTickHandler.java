/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.network;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UltimateGraviSuiteMod;
import fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common.UltimateQuantumHelmet;

public class ServerTickHandler implements ITickHandler
{
	public static Map isFlyActiveByMod = new HashMap();
	public static Map isInvisibilityActiveByMod = new HashMap();
	public static Map isINightVisionActiveByMod = new HashMap();
	public static Map lastUndressed = new HashMap();
	public static Map isLastCreativeState = new HashMap();

	public void tickStart(EnumSet type, Object... tickData)
	{

		if(type.contains(TickType.PLAYER))
		{
			EntityPlayer player = (EntityPlayer)tickData[0];
			ItemStack helmet = player.inventory.armorInventory[3];

			if(helmet != null && helmet.getItem().equals(UltimateGraviSuiteMod.ultimateHelmet))
			{
				UltimateQuantumHelmet.onTick(player, helmet);

				if(checkNightVisionActiveByMode(player))
				{
					isINightVisionActiveByMod.put(player, Boolean.valueOf(false));
				}
			}
			ItemStack chestPlate = player.inventory.armorInventory[2];

			if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate))
			{
				if(player.capabilities.isCreativeMode && !checkLastCreativeState(player))
				{
					isLastCreativeState.put(player, Boolean.valueOf(true));
				}
				else if(!player.capabilities.isCreativeMode && checkLastCreativeState(player) && checkFlyActiveByMode(player))
				{
					player.capabilities.allowFlying = true;
					player.capabilities.isFlying = true;
					isLastCreativeState.put(player, Boolean.valueOf(false));
				}

				ServerPacketHelper.onTickServer(player, chestPlate, 0.0F, 0.0F);

				if(checkInvisibilityActiveByMode(player))
				{
					isInvisibilityActiveByMod.put(player, Boolean.valueOf(false));
				}

				if(player.posY > 262.0D && !player.capabilities.isCreativeMode)
				{
					player.setPosition(player.posX, 262.0D, player.posZ);
				}
			}
			else if(checkFlyActiveByMode(player))
			{
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
				isFlyActiveByMod.put(player, Boolean.valueOf(false));
				lastUndressed.put(player, Boolean.valueOf(true));
			}
		}
	}

	public void tickEnd(EnumSet type, Object... tickData)
	{}

	public EnumSet ticks()
	{
		return EnumSet.of(TickType.PLAYER);
	}

	public String getLabel()
	{
		return "UltimateGraviSuite";
	}

	public static boolean checkLastUndressed(EntityPlayer player)
	{
		return lastUndressed.containsKey(player) ? ((Boolean)lastUndressed.get(player)).booleanValue() : false;
	}

	public static boolean checkFlyActiveByMode(EntityPlayer player)
	{
		return isFlyActiveByMod.containsKey(player) ? ((Boolean)isFlyActiveByMod.get(player)).booleanValue() : false;
	}

	public static boolean checkInvisibilityActiveByMode(EntityPlayer player)
	{
		return isInvisibilityActiveByMod.containsKey(player) ? ((Boolean)isInvisibilityActiveByMod.get(player)).booleanValue() : false;
	}

	public static boolean checkNightVisionActiveByMode(EntityPlayer player)
	{
		return isINightVisionActiveByMod.containsKey(player) ? ((Boolean)isINightVisionActiveByMod.get(player)).booleanValue() : false;
	}

	public static boolean checkLastCreativeState(EntityPlayer player)
	{
		return isLastCreativeState.containsKey(player) ? ((Boolean)isLastCreativeState.get(player)).booleanValue() : false;
	}
}