package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviChestPlateServerProxy;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateQuantumHelmet;

public class ServerTickHandler implements ITickHandler
{
	public static Map isFlyActiveByMod = new HashMap();
	public static Map isInvisibilityActiveByMod = new HashMap();
	public static Map isINightVisionActiveByMod = new HashMap();
	public static Map lastUndressed = new HashMap();
	public static Map isLastCreativeState = new HashMap();

	public void tickStart(EnumSet var1, Object... var2)
	{

		if(var1.contains(TickType.PLAYER))
		{
			EntityPlayer var3 = (EntityPlayer)var2[0];
			ItemStack var4 = var3.inventory.armorInventory[3];

			if(var4 != null && var4.getItem() == UltimateGraviSuite.theultimateSolarHelmet)
			{
				UltimateQuantumHelmet.onTick(var3, var4);

				if(checkNightVisionActiveByMode(var3))
				{
					isINightVisionActiveByMod.put(var3, Boolean.valueOf(false));
				}
			}
			ItemStack var5 = var3.inventory.armorInventory[2];

			if(var5 != null && var5.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
			{
				if(var3.capabilities.isCreativeMode && !checkLastCreativeState(var3))
				{
					isLastCreativeState.put(var3, Boolean.valueOf(true));
				}
				else if(!var3.capabilities.isCreativeMode && checkLastCreativeState(var3) && checkFlyActiveByMode(var3))
				{
					var3.capabilities.allowFlying = true;
					var3.capabilities.isFlying = true;
					isLastCreativeState.put(var3, Boolean.valueOf(false));
				}

				UltimateGraviChestPlateServerProxy.onTickServer(var3, var5, 0.0F, 0.0F);

				if(checkInvisibilityActiveByMode(var3))
				{
					isInvisibilityActiveByMod.put(var3, Boolean.valueOf(false));
				}

				if(var3.posY > 262.0D && !var3.capabilities.isCreativeMode)
				{
					var3.setPosition(var3.posX, 262.0D, var3.posZ);
				}
			}
			else if(checkFlyActiveByMode(var3))
			{
				var3.capabilities.allowFlying = false;
				var3.capabilities.isFlying = false;
				isFlyActiveByMod.put(var3, Boolean.valueOf(false));
				lastUndressed.put(var3, Boolean.valueOf(true));
			}
		}

		if(var1.contains(TickType.WORLDLOAD))
		{
			;
		}
	}

	public void tickEnd(EnumSet var1, Object... var2)
	{}

	public EnumSet ticks()
	{
		return EnumSet.of(TickType.WORLDLOAD, TickType.PLAYER);
	}

	public String getLabel()
	{
		return "UltimateGraviSuite";
	}

	public static boolean checkLastUndressed(EntityPlayer var0)
	{
		return lastUndressed.containsKey(var0) ? ((Boolean)lastUndressed.get(var0)).booleanValue() : false;
	}

	public static boolean checkFlyActiveByMode(EntityPlayer var0)
	{
		return isFlyActiveByMod.containsKey(var0) ? ((Boolean)isFlyActiveByMod.get(var0)).booleanValue() : false;
	}

	public static boolean checkInvisibilityActiveByMode(EntityPlayer var0)
	{
		return isInvisibilityActiveByMod.containsKey(var0) ? ((Boolean)isInvisibilityActiveByMod.get(var0)).booleanValue() : false;
	}

	public static boolean checkNightVisionActiveByMode(EntityPlayer var0)
	{
		return isINightVisionActiveByMod.containsKey(var0) ? ((Boolean)isINightVisionActiveByMod.get(var0)).booleanValue() : false;
	}

	public static boolean checkLastCreativeState(EntityPlayer var0)
	{
		return isLastCreativeState.containsKey(var0) ? ((Boolean)isLastCreativeState.get(var0)).booleanValue() : false;
	}
}