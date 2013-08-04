package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core;

import ic2.api.item.ElectricItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateBoots;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateGraviChestPlate;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateLeggings;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateQuantumHelmet;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.Keyboard;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network.ServerTickHandler;

public class UltimateGraviChestPlateServerProxy
{
	private MinecraftServer mc = FMLCommonHandler.instance().getMinecraftServerInstance();

	public static boolean switchFlyModeServer(EntityPlayer var0, ItemStack stack)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack))
		{
			if(!var0.capabilities.isCreativeMode)
			{
				var0.capabilities.allowFlying = false;
				var0.capabilities.isFlying = false;
			}

			ServerProxy.sendPlayerMessage(var0, "\u00a7cGravitation engine OFF");
			ServerTickHandler.isFlyActiveByMod.put(var0, Boolean.valueOf(false));
			UltimateGraviChestPlate.saveFlyStatus(stack, false);
		}
		else
		{
			int var2 = UltimateGraviChestPlate.getCharge(stack);

			if(var2 < UltimateGraviChestPlate.minCharge && !var0.capabilities.isCreativeMode)
			{
				ServerProxy.sendPlayerMessage(var0, "Not enough energy to run Gravitation engine !");
			}
			else
			{
				ServerProxy.sendPlayerMessage(var0, "\u00a7aGravitation engine ON");
				var0.capabilities.allowFlying = true;
				var0.capabilities.isFlying = true;
				ServerTickHandler.isFlyActiveByMod.put(var0, Boolean.valueOf(true));
				UltimateGraviChestPlate.saveFlyStatus(stack, true);
			}
		}

		return true;
	}

	public static boolean switchInvisibleModeServer(EntityPlayer var0, ItemStack stack)
	{
		if(stack.getItem() == UltimateGraviSuite.ultimategraviChestPlate)
		{
			if(UltimateGraviChestPlate.readInvisibilityStatus(stack))
			{

				ServerProxy.sendPlayerMessage(var0, "\u00a7cInvisibility OFF");
				ServerTickHandler.isInvisibilityActiveByMod.put(var0, Boolean.valueOf(false));
				UltimateGraviChestPlate.saveInvisibilityStatus(stack, false);
			}
			else
			{
				int var2 = UltimateGraviChestPlate.getCharge(stack);

				if(var2 < UltimateGraviChestPlate.minCharge && !var0.capabilities.isCreativeMode)
				{
					ServerProxy.sendPlayerMessage(var0, "Not enough energy to be Invisible !");
				}
				else
				{
					ServerProxy.sendPlayerMessage(var0, "\u00a7aInvisibility ON");
					ServerTickHandler.isInvisibilityActiveByMod.put(var0, Boolean.valueOf(true));
					UltimateGraviChestPlate.saveInvisibilityStatus(stack, true);
				}
			}
		}

		if(stack.getItem() == UltimateGraviSuite.ultimateLeggings)
		{
			if(UltimateLeggings.readInvisibilityStatus(stack))
			{
				UltimateLeggings.saveInvisibilityStatus(stack, false);

			}
			else
			{
				UltimateLeggings.saveInvisibilityStatus(stack, true);

			}
		}
		if(stack.getItem() == UltimateGraviSuite.ultimateBoots)
		{
			if(UltimateBoots.readInvisibilityStatus(stack))
			{
				UltimateBoots.saveInvisibilityStatus(stack, false);

			}
			else
			{
				UltimateBoots.saveInvisibilityStatus(stack, true);

			}
		}

		if(stack.getItem() == UltimateGraviSuite.theultimateSolarHelmet)
		{
			if(UltimateQuantumHelmet.readInvisibilityStatus(stack))
			{
				UltimateQuantumHelmet.saveInvisibilityStatus(stack, false);

			}
			else
			{
				UltimateQuantumHelmet.saveInvisibilityStatus(stack, true);

			}
		}

		return true;
	}

	public static boolean switchNightVisionModeServer(EntityPlayer var0, ItemStack stack)
	{
		if(UltimateQuantumHelmet.readNightVisionStatus(stack))
		{

			ServerProxy.sendPlayerMessage(var0, "\u00a7cNight vision OFF");
			ServerTickHandler.isINightVisionActiveByMod.put(var0, Boolean.valueOf(false));
			UltimateQuantumHelmet.saveNightVisionStatus(stack, false);
		}
		else
		{
			int var2 = UltimateQuantumHelmet.getCharge(stack);

			if(var2 < UltimateQuantumHelmet.minCharge && !var0.capabilities.isCreativeMode)
			{
				ServerProxy.sendPlayerMessage(var0, "Not enough energy to be Invisible !");
			}
			else
			{
				ServerProxy.sendPlayerMessage(var0, "\u00a7aNight vision ON");
				ServerTickHandler.isINightVisionActiveByMod.put(var0, Boolean.valueOf(true));
				UltimateQuantumHelmet.saveNightVisionStatus(stack, true);
			}
		}

		return true;
	}

	public static boolean boostModeServer(EntityPlayer var0, ItemStack stack, float var2, float var3)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack) && !var0.onGround && var0.capabilities.isFlying && !var0.isInWater())
		{
			int var4 = UltimateGraviChestPlate.getCharge(stack);

			if(var4 > UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier || var0.capabilities.isCreativeMode)
			{
				var0.moveFlying(var2, var3, UltimateGraviChestPlate.boostSpeed);

				if(!var0.capabilities.isCreativeMode)
				{
					ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier, 3, true, false);
				}
			}
		}

		return true;
	}

	public static boolean firstLoadServer(EntityPlayer var0, ItemStack stack)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack))
		{
			UltimateGraviChestPlate.saveFlyStatus(stack, false);
			switchFlyModeServer(var0, stack);
			ServerProxy.sendPacket(var0, "setFlyStatus", 0);
		}
		if(UltimateGraviChestPlate.readInvisibilityStatus(stack))
		{
			UltimateGraviChestPlate.saveInvisibilityStatus(stack, false);
			UltimateLeggings.saveInvisibilityStatus(stack, false);
			UltimateBoots.saveInvisibilityStatus(stack, false);
			UltimateQuantumHelmet.saveInvisibilityStatus(stack, false);
			switchInvisibleModeServer(var0, stack);
			ServerProxy.sendPacket(var0, "setInvisibilityStatus", 0);
		}
		if(UltimateQuantumHelmet.readNightVisionStatus(stack))
		{
			UltimateQuantumHelmet.saveNightVisionStatus(stack, false);
			switchNightVisionModeServer(var0, stack);
			ServerProxy.sendPacket(var0, "setNightVisionStatus", 0);
		}

		return true;
	}

	public static boolean onTickServer(EntityPlayer var0, ItemStack stack, float var2, float var3)
	{
		if(ServerTickHandler.checkLastUndressed(var0))
		{
			UltimateGraviChestPlate.saveFlyStatus(stack, false);
			ServerTickHandler.lastUndressed.put(var0, Boolean.valueOf(false));
		}

		if(UltimateGraviChestPlate.readFlyStatus(stack) || UltimateGraviChestPlate.readInvisibilityStatus(stack))
		{
			NBTTagCompound var4 = UltimateGraviSuite.getOrCreateNbtData(stack);
			int var5 = UltimateGraviChestPlate.getCharge(stack);

			if(!var0.capabilities.isCreativeMode)
			{
				if(var5 < UltimateGraviChestPlate.dischargeOnTick)
				{
					ServerProxy.sendPlayerMessage(var0, "\u00a7cWarning ! Your\'s energy cell is depleted ! Gravitation engine shutdown !");
					switchFlyModeServer(var0, stack);
					switchInvisibleModeServer(var0, stack);
				}
				else
				{
					ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick, 3, true, false);
				}
			}

			var0.fallDistance = 0.0F;

			if(!var0.onGround && var0.capabilities.isFlying && Keyboard.isBoostKeyDown(var0))
			{
				boostModeServer(var0, stack, var2, var3);

				if(var5 <= UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier && !var0.capabilities.isCreativeMode)
				{
					ServerProxy.sendPlayerMessage(var0, "Not enough energy to boost !");
				}
				else
				{
					if(Keyboard.isJumpKeyDown(var0))
					{
						var0.motionY += (double)(UltimateGraviChestPlate.boostSpeed + 0.03F);
					}

					if(Keyboard.isSneakKeyDown(var0))
					{
						var0.motionY -= (double)(UltimateGraviChestPlate.boostSpeed + 0.03F);
					}

					if(!var0.capabilities.isCreativeMode)
					{
						ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier, 3, true, false);
					}
				}
			}
		}

		if(UltimateQuantumHelmet.readNightVisionStatus(stack))
		{
			int var4 = UltimateQuantumHelmet.getCharge(stack);

			if(!var0.capabilities.isCreativeMode)
			{
				if(var4 < UltimateQuantumHelmet.dischargeOnTick)
				{
					ServerProxy.sendPlayerMessage(var0, "\u00a7cWarning ! Your\'s energy cell is depleted ! Gravitation engine shutdown !");
					switchNightVisionModeServer(var0, stack);
				}
				else
				{
					ElectricItem.manager.discharge(stack, UltimateQuantumHelmet.dischargeOnTick, 3, true, false);
				}
			}
		}

		var0.extinguish();
		return true;
	}
}
