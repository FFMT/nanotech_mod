package fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.network;

import ic2.api.item.ElectricItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.ServerProxy;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.core.UltimateGraviSuite;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateBoots;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateGraviChestPlate;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateLeggings;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.items.UltimateQuantumHelmet;
import fr.mcnanotech.kevin_68.nanotech_mod.ultimateGraviSuite.keyboard.Keyboard;

public class ServerPacketHelper
{
	private MinecraftServer mc = FMLCommonHandler.instance().getMinecraftServerInstance();

	public static boolean switchFlyModeServer(EntityPlayer player, ItemStack stack)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack))
		{
			if(!player.capabilities.isCreativeMode)
			{
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
			}

			ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.off"));
			ServerTickHandler.isFlyActiveByMod.put(player, Boolean.valueOf(false));
			UltimateGraviChestPlate.saveFlyStatus(stack, false);
		}
		else
		{
			int var2 = UltimateGraviChestPlate.getCharge(stack);

			if(var2 < UltimateGraviChestPlate.minCharge && !player.capabilities.isCreativeMode)
			{
				ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.noenergy"));
			}
			else
			{
				ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.on"));
				player.capabilities.allowFlying = true;
				player.capabilities.isFlying = true;
				ServerTickHandler.isFlyActiveByMod.put(player, Boolean.valueOf(true));
				UltimateGraviChestPlate.saveFlyStatus(stack, true);
			}
		}

		return true;
	}

	public static boolean switchInvisibleModeServer(EntityPlayer player, ItemStack stack)
	{
		if(stack.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate))
		{
			if(UltimateGraviChestPlate.readInvisibilityStatus(stack))
			{

				ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.inv.off"));
				ServerTickHandler.isInvisibilityActiveByMod.put(player, Boolean.valueOf(false));
				UltimateGraviChestPlate.saveInvisibilityStatus(stack, false);
			}
			else
			{
				int charge = UltimateGraviChestPlate.getCharge(stack);

				if(charge < UltimateGraviChestPlate.minCharge && !player.capabilities.isCreativeMode)
				{
					ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.inv.noenergy"));
				}
				else
				{
					ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.inv.on"));
					ServerTickHandler.isInvisibilityActiveByMod.put(player, Boolean.valueOf(true));
					UltimateGraviChestPlate.saveInvisibilityStatus(stack, true);
				}
			}
		}

		if(stack.getItem().equals(UltimateGraviSuite.ultimateLeggings))
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
		if(stack.getItem().equals(UltimateGraviSuite.ultimateBoots))
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

		if(stack.getItem().equals(UltimateGraviSuite.ultimateHelmet))
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

	public static boolean switchNightVisionModeServer(EntityPlayer player, ItemStack stack)
	{
		if(UltimateQuantumHelmet.readNightVisionStatus(stack))
		{

			ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("helmet.night.off"));
			ServerTickHandler.isINightVisionActiveByMod.put(player, Boolean.valueOf(false));
			UltimateQuantumHelmet.saveNightVisionStatus(stack, false);
		}
		else
		{
			int charge = UltimateQuantumHelmet.getCharge(stack);

			if(charge < UltimateQuantumHelmet.minCharge && !player.capabilities.isCreativeMode)
			{
				ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("helmet.night.noenergy"));
			}
			else
			{
				ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("helmet.night.on"));
				ServerTickHandler.isINightVisionActiveByMod.put(player, Boolean.valueOf(true));
				UltimateQuantumHelmet.saveNightVisionStatus(stack, true);
			}
		}

		return true;
	}

	public static boolean boostModeServer(EntityPlayer player, ItemStack stack, float f1, float f2)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack) && !player.onGround && player.capabilities.isFlying && !player.isInWater())
		{
			int var4 = UltimateGraviChestPlate.getCharge(stack);

			if(var4 > UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier || player.capabilities.isCreativeMode)
			{
				player.moveFlying(f1, f2, UltimateGraviChestPlate.boostSpeed);

				if(!player.capabilities.isCreativeMode)
				{
					ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier, 3, true, false);
				}
			}
		}

		return true;
	}

	public static boolean firstLoadServer(EntityPlayer player, ItemStack stack)
	{
		if(UltimateGraviChestPlate.readFlyStatus(stack))
		{
			UltimateGraviChestPlate.saveFlyStatus(stack, false);
			switchFlyModeServer(player, stack);
			ServerProxy.sendPacket(player, "setFlyStatus", 0);
		}
		if(UltimateGraviChestPlate.readInvisibilityStatus(stack))
		{
			UltimateGraviChestPlate.saveInvisibilityStatus(stack, false);
			UltimateLeggings.saveInvisibilityStatus(stack, false);
			UltimateBoots.saveInvisibilityStatus(stack, false);
			UltimateQuantumHelmet.saveInvisibilityStatus(stack, false);
			switchInvisibleModeServer(player, stack);
			ServerProxy.sendPacket(player, "setInvisibilityStatus", 0);
		}
		if(UltimateQuantumHelmet.readNightVisionStatus(stack))
		{
			UltimateQuantumHelmet.saveNightVisionStatus(stack, false);
			switchNightVisionModeServer(player, stack);
			ServerProxy.sendPacket(player, "setNightVisionStatus", 0);
		}

		return true;
	}

	public static boolean onTickServer(EntityPlayer player, ItemStack stack, float var2, float var3)
	{
		if(ServerTickHandler.checkLastUndressed(player))
		{
			UltimateGraviChestPlate.saveFlyStatus(stack, false);
			ServerTickHandler.lastUndressed.put(player, Boolean.valueOf(false));
		}

		if(UltimateGraviChestPlate.readFlyStatus(stack) || UltimateGraviChestPlate.readInvisibilityStatus(stack))
		{
			NBTTagCompound tagCompound = UltimateGraviSuite.getOrCreateNbtData(stack);
			int charge = UltimateGraviChestPlate.getCharge(stack);

			if(!player.capabilities.isCreativeMode)
			{
				if(charge < UltimateGraviChestPlate.dischargeOnTick)
				{
					ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.outofenergy"));
					switchFlyModeServer(player, stack);
					switchInvisibleModeServer(player, stack);
				}
				else
				{
					ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick, 3, true, false);
				}
			}

			player.fallDistance = 0.0F;

			if(!player.onGround && player.capabilities.isFlying && Keyboard.isBoostKeyDown(player))
			{
				boostModeServer(player, stack, var2, var3);

				if(charge <= UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier && !player.capabilities.isCreativeMode)
				{
					ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.boost.noenergy"));
				}
				else
				{
					if(Keyboard.isJumpKeyDown(player))
					{
						player.motionY += (double)(UltimateGraviChestPlate.boostSpeed + 0.03F);
					}

					if(Keyboard.isSneakKeyDown(player))
					{
						player.motionY -= (double)(UltimateGraviChestPlate.boostSpeed + 0.03F);
					}

					if(!player.capabilities.isCreativeMode)
					{
						ElectricItem.manager.discharge(stack, UltimateGraviChestPlate.dischargeOnTick * UltimateGraviChestPlate.boostMultiplier, 3, true, false);
					}
				}
			}
		}

		if(UltimateQuantumHelmet.readNightVisionStatus(stack))
		{
			int charge = UltimateQuantumHelmet.getCharge(stack);

			if(!player.capabilities.isCreativeMode)
			{
				if(charge < UltimateQuantumHelmet.dischargeOnTick)
				{
					ServerProxy.sendPlayerMessage(player, StatCollector.translateToLocal("gravi.fly.outofenergy"));
					switchNightVisionModeServer(player, stack);
				}
				else
				{
					ElectricItem.manager.discharge(stack, UltimateQuantumHelmet.dischargeOnTick, 3, true, false);
				}
			}
		}

		player.extinguish();
		return true;
	}
}